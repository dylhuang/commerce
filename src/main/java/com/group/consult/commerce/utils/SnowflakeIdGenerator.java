package com.group.consult.commerce.utils;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Random;

/**
 * 基于雪花id改造
 * @author mzhoulei
 */
public class SnowflakeIdGenerator {

    /**
     *  起始的时间戳，// 2021-05-09 00:00:00
     */
    private final static long START_TIMESTAMP = 1620537600000L;

    /**
     * 每一部分占用的位数
     * 序列号占用的位数
     */
    private final static long SEQUENCE_BIT = 12;
    /**
     * 机器标识占用的位数
     */
    private final static long WORKER_ID_BIT = 5;
    /**
     * 数据中心占用的位数
     */
    private final static long DATA_CENTER_ID_BIT = 5;

    /**
     * 每一部分的最大值
     */
    private final static long MAX_SEQUENCE_NUM = -1L ^ (-1L << SEQUENCE_BIT);
    private final static long MAX_WORKER_ID = -1L ^ (-1L << WORKER_ID_BIT);
    private final static long MAX_DATA_CENTER_ID = -1L ^ (-1L << DATA_CENTER_ID_BIT);

    /**
     * 每一部分向左的位移
     */
    private final static long WORKER_ID_LEFT_SHIFT = SEQUENCE_BIT;
    private final static long DATA_CENTER_ID_LEFT_SHIFT = WORKER_ID_LEFT_SHIFT + WORKER_ID_BIT;
    private final static long TIMESTAMP_LEFT_SHIFT = DATA_CENTER_ID_LEFT_SHIFT + DATA_CENTER_ID_BIT;
    /**
     * 工作机器 ID
     */
    private final long workerId;
    /**
     * 数据中心 ID
     */
    private final long dataCenterId;
    /**
     * 当前时间戳
     */
    private long currentTimestamp = System.currentTimeMillis();
    /**
     * 序列号
     */
    private long sequence = 0L;

    private static SnowflakeIdGenerator snowflakeIdGenerator = new SnowflakeIdGenerator();

    private SnowflakeIdGenerator() {
        // 生成默认的 workerId 和 dataCenterId
        this.workerId = getWorkerId();
        this.dataCenterId = getDataCenterId();
    }

    public static void main(String[] args) {
        System.out.println(SnowflakeIdGenerator.buildId());
        System.out.println(SnowflakeIdGenerator.buildId("opk"));
        System.out.println(SnowflakeIdGenerator.buildId("HZDBH"));
        System.out.println(SnowflakeIdGenerator.buildId("YX00A"));
        System.out.println(SnowflakeIdGenerator.buildId("YX00A"));
        System.out.println(SnowflakeIdGenerator.buildId("YX00A"));
    }

    /**
     * 生成id
     * @return
     */
    public static long buildId() {
        return snowflakeIdGenerator.nextId();
    }

    /**
     * 生成带前缀的id
     * @param prefix
     * @return
     */
    public static String buildId(String prefix) {
        StringBuffer sb = new StringBuffer();
        sb.append(prefix).append(buildId());
        return sb.toString();
    }

    private synchronized long nextId() {
        long timestamp = getCurrentTimestamp();
        if (timestamp < currentTimestamp) {
            throw new RuntimeException(
                    "Clock moved backwards. Refusing to generate id for " + (currentTimestamp
                            - timestamp) + " milliseconds");
        }

        if (timestamp == currentTimestamp) {
            // 同一毫秒内生成 ID
            sequence = (sequence + 1) & MAX_SEQUENCE_NUM;
            if (sequence == 0) {
                // 当前毫秒内序列号已达到最大值，等待下一毫秒
                timestamp = waitNextMillis(currentTimestamp);
            }
        } else {
            // 不同毫秒内生成 ID
            sequence = 0L;
        }

        currentTimestamp = timestamp;

        // 生成 ID
        return ((currentTimestamp - START_TIMESTAMP) << TIMESTAMP_LEFT_SHIFT) |
                (dataCenterId << DATA_CENTER_ID_LEFT_SHIFT) |
                (workerId << WORKER_ID_LEFT_SHIFT) |
                sequence;
    }

    private synchronized String nextIdStr() {
        return String.valueOf(nextId());
    }

    private long getCurrentTimestamp() {
        return System.currentTimeMillis();
    }

    private long getWorkerId() {
        // 可以使用 MAC 地址作为 workerId
        byte[] mac = null;
        try {
            InetAddress address = InetAddress.getLocalHost();
            NetworkInterface network = NetworkInterface.getByInetAddress(address);
            mac = network.getHardwareAddress();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (mac != null) {
            return
                    ((0x000000FF & (long) mac[mac.length - 1]) |
                            (0x0000FF00 & (((long) mac[mac.length - 2]) << 8))) >> 6;
        }
        return new Random().nextInt((int) MAX_WORKER_ID);
    }

    private long getDataCenterId() {
        // 可以使用 IP 地址的 hashcode 作为 dataCenterId
        long id = 0L;
        try {
            InetAddress address = InetAddress.getLocalHost();
            byte[] ip = address.getAddress();
            id = ((0x000000FF & (long) ip[ip.length - 1]) |
                    (0x0000FF00 & (((long) ip[ip.length - 2]) << 8))) >> 4;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return id % MAX_DATA_CENTER_ID;
    }

    private long waitNextMillis(long lastTimestamp) {
        long timestamp = getCurrentTimestamp();
        while (timestamp <= lastTimestamp) {
            timestamp = getCurrentTimestamp();
        }
        return timestamp;
    }
}
