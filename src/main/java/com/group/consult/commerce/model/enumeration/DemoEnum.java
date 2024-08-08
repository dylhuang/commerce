package com.group.consult.commerce.model.enumeration;

/**
 * DemoEnum Enumeration
 *
 * @author Huang, Dylan Bo
 * @since 2024/08/07
 */
public enum DemoEnum {

    /**
     * ONE
     */
    ONE("10", "DEMO ONE"),

    /**
     * TWO
     */
    TWO("20", "DEMO TWO"),

    /**
     * THREE
     */
    THREE("30", "DEMO THREE");

    private String key;

    private String value;

    private DemoEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Obtain enumeration through key
     *
     * @param key key
     * @return enumeration
     */
    public static DemoEnum getDemoEnumByKey(String key) {
        for (DemoEnum enum_ : values()) {
            if (enum_.getKey().equals(key)) {
                return enum_;
            }
        }
        return null;
    }

    /**
     * Obtain enumeration value through key
     *
     * @param key key
     * @return value
     */
    public static String getValueByKey(String key) {
        for (DemoEnum enum_ : values()) {
            if (enum_.getKey().equals(key)) {
                return enum_.getValue();
            }
        }
        return null;
    }
}
