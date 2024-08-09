package com.group.consult.commerce.model.constant;

import cn.hutool.core.lang.tree.TreeNodeConfig;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 基础常量
 *
 * @author Huang, Dylan Bo
 * @since 2024/08/08
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BaseConstant {

    /**
     * 创建时间列名称
     */
    public static final String CREATED_TIME_COLUMN_NAME = "createTime";

    /**
     * 创建时间列名称
     */
    public static final String UPDATE_TIME_COLUMN_NAME = "updateTime";

    /**
     * DESC列名称
     */
    public static final String DESC_COLUMN_NAME = "DESC";

    /**
     * ASC列名称
     */
    public static final String ASC_COLUMN_NAME = "ASC";

    /**
     * 默认每页大小
     */
    public static final int DEFAULT_SIZE_OF_PAGES = 20;

    /**
     * 默认当前页码
     */
    public static final int DEFAULT_NUM_OF_PAGES = 1;

    /**
     * 竞价场次编码格式
     */
    public static final String BIDDING_SESSION_CODE_FORMAT = "yyyyMMddHHmmss";

    /**
     * 邮箱
     */
    public static final String EMAIL_CN = "邮箱";

    /**
     * 手机号
     */
    public static final String PHONE_CN = "手机号";

    /**
     * 根节点ID
     */
    public static final Long ROOT_ID = 0L;

    /**
     * 默认树节点配置
     */
    public static final TreeNodeConfig DEFAULT_TREE_NODE_CONFIG = new TreeNodeConfig();

    /**
     * 产品展示图片和视频最大数量
     */
    public static final int PRODUCT_SHOW_IMG_AND_VID_MAX_COUNT = 8;

    /**
     * 产品特性字段最大长度
     */
    public static final int PRODUCT_FEATURE_FIELD_MAX_LENGTH = 1024;

    /**
     * 市场渠道标签组名称
     */
    public static final String CHANNEL_TAG_GROUP_NAME = "市场渠道";

    /**
     * DataHub文件名时间格式
     */
    public static final String DATA_HUB_BLOB_NAME_DATE_FORMAT = "yyyyMMdd";
}
