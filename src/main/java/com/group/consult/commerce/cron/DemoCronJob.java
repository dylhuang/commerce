package com.group.consult.commerce.cron;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务计划任务
 * {秒数} {分钟} {小时} {日期} {月份} {星期}
 *
 * @author Huang, Dylan Bo
 * @since 2024/08/06
 */
@Slf4j
@Component
@EnableScheduling
@RequiredArgsConstructor
public class DemoCronJob {

    @Async("asyncExecutor")
    @Scheduled(cron = "0 * * * * ?")
    public void loadExample() {
        log.info("Scheduled load Example");
        System.out.println("current time is : " + System.currentTimeMillis());
    }
}