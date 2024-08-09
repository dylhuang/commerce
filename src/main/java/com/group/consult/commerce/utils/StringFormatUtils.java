package com.group.consult.commerce.utils;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.group.consult.commerce.model.constant.BaseConstant;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.LocalDateTime;

/**
 * 字符串格式化工具类
 *
 * @author Huang, Dylan Bo
 * @since 2024/08/08
 */
@Slf4j
public class StringFormatUtils {

    private static final String ORDER_BY_FORMAT = "{} {}";

    private static final String ORDER_BY_FULL_FORMAT = " ORDER BY {}";

    private static final String FIELD_CANNOT_BE_NULL = "{} cannot be null";

    private static final String FIELD_CANNOT_BE_EMPTY = "{} cannot be empty";

    private static final String FIELD_LENGTH_IS_OVER_LIMIT = "{} length is over limit";

    private static final String FIELD_MUST_BE_GREATER_THAN_0 = "{} must be greater than 0";

    private static final String PRICE_NOT_IN_RULE = "price [{}] not in rule [{}]";

    private static final String URL_SOURCE = "&source={}";

    private static final String STRING_1_FORMAT = "jsapi_ticket={}&noncestr={}&timestamp={}&url={}";

    private static final String USER_HAS_ROLE_FORMAT = "{}已经被分配为{}角色";

    private static final String WRONG_FORMAT = "{}格式错误[{}]";

    private static final String REQUIRED_FIELD_MISSING_FORMAT = "必填项{}缺失";

    private static final String FIELD_DUPLICATE_FORMAT = "{}重复";

    private static final String DATA_EXPORT_FILE_NAME_FORMAT = "E-Tendering Data Export_{}.xlsx";

    private static final String BLOB_SAS_URL_FORMAT = "{}/{}/{}?{}";

    private static final String BLOB_NAME_FORMAT = "{}/{}/{}-{}.{}";

    private static final String FILE_SIZE_IS_GREATER_THAN_LIMIT = "File size[{}] is greater than limit[{}]";

    private static final String CUSTOMER_BLOB_NAME_FORMAT = "Customer_Masterdata/Customer_Masterdata_{}.csv";

    private static final String EMPLOYEE_BLOB_NAME_FORMAT = "Employee_Masterdata/Employee_Masterdata_{}.csv";

    private static final String CUSTOMER_DISTRIBUTOR_MAPPING_BLOB_NAME_FORMAT = "IAC_DT_Mapping/IAC_DT_Mapping_{}.csv";

    private static final String SALES_HIERARCHY_BLOB_NAME_FORMAT = "Sales_Hierarchy_Masterdata/Sales_Hierarchy_Masterdata_{}.csv";

    public static String getOrderByStatement(String sortField, String sort) {
        return StrUtil.format(ORDER_BY_FORMAT, sortField, sort);
    }

    public static String getOrderByFullStatement(String orderByStatement) {
        return StrUtil.format(ORDER_BY_FULL_FORMAT, orderByStatement);
    }

    public static String getFieldCannotBeNullStr(String field) {
        return StrUtil.format(FIELD_CANNOT_BE_NULL, field);
    }

    public static String getFieldCannotBeEmptyStr(String field) {
        return StrUtil.format(FIELD_CANNOT_BE_EMPTY, field);
    }

    public static String getFieldLengthIsOverLimitStr(String field) {
        return StrUtil.format(FIELD_LENGTH_IS_OVER_LIMIT, field);
    }

    public static String getFieldMustBeGreaterThanZeroStr(String field) {
        return StrUtil.format(FIELD_MUST_BE_GREATER_THAN_0, field);
    }

    public static String getPriceNotInRuleStr(BigDecimal price, String rule) {
        return StrUtil.format(PRICE_NOT_IN_RULE, price, rule);
    }

    public static String getUrlSource(String source) {
        return StrUtil.format(URL_SOURCE, source);
    }

    public static String getString1(String jsApiTicket, String nonceStr, String timestamp, String url) {
        // 注意这里参数名必须全部小写，且必须有序
        return StrUtil.format(STRING_1_FORMAT, jsApiTicket, nonceStr, timestamp, url);
    }

    public static String getUserHasRoleStr(String username, String roleName) {
        return StrUtil.format(USER_HAS_ROLE_FORMAT, username, roleName);
    }

    public static String getPhoneWrongFormatStr(String phone) {
        return StrUtil.format(WRONG_FORMAT, BaseConstant.PHONE_CN, phone);
    }

    public static String getEmailWrongFormatStr(String email) {
        return StrUtil.format(WRONG_FORMAT, BaseConstant.EMAIL_CN, email);
    }

    public static String getRequiredFieldMissingStr(String fieldName) {
        return StrUtil.format(REQUIRED_FIELD_MISSING_FORMAT, fieldName);
    }

    public static String getFieldDuplicateStr(String fieldName) {
        return StrUtil.format(FIELD_DUPLICATE_FORMAT, fieldName);
    }

    @SneakyThrows(Exception.class)
    public static String getDataExportFileName() {
        return URLEncoder.encode(StrUtil.format(DATA_EXPORT_FILE_NAME_FORMAT, DateUtil.format(LocalDateTime.now(), BaseConstant.BIDDING_SESSION_CODE_FORMAT)), StandardCharsets.UTF_8.displayName())
                .replaceAll("\\+", "%20");
    }

    public static String getBlobSasUrl(String host, String containerName, String blobName, String sasToken) {
        return StrUtil.format(BLOB_SAS_URL_FORMAT, host, containerName, blobName, sasToken);
    }

    public static String generateBlobName(String categoryFolderName, String typeFolderName, String suffix) {
        return StrUtil.format(BLOB_NAME_FORMAT, categoryFolderName, typeFolderName, Instant.now().getEpochSecond(), RandomUtil.randomString(5), StringUtils.defaultIfEmpty(suffix, "png"));
    }

    public static String getFileSizeIsGreaterThanLimit(String fileSize, String limitSize) {
        return StrUtil.format(FILE_SIZE_IS_GREATER_THAN_LIMIT, fileSize, limitSize);
    }

    public static String getCustomerBlobName() {
        return StrUtil.format(CUSTOMER_BLOB_NAME_FORMAT, DateUtil.format(LocalDateTime.now(), BaseConstant.DATA_HUB_BLOB_NAME_DATE_FORMAT));
    }

    public static String getEmployeeBlobName() {
        return StrUtil.format(EMPLOYEE_BLOB_NAME_FORMAT, DateUtil.format(LocalDateTime.now(), BaseConstant.DATA_HUB_BLOB_NAME_DATE_FORMAT));
    }

    public static String getCustomerDistributorMappingBlobName() {
        return StrUtil.format(CUSTOMER_DISTRIBUTOR_MAPPING_BLOB_NAME_FORMAT, DateUtil.format(LocalDateTime.now(), BaseConstant.DATA_HUB_BLOB_NAME_DATE_FORMAT));
    }

    public static String getSalesHierarchyBlobName() {
        return StrUtil.format(SALES_HIERARCHY_BLOB_NAME_FORMAT, DateUtil.format(LocalDateTime.now(), BaseConstant.DATA_HUB_BLOB_NAME_DATE_FORMAT));
    }
}
