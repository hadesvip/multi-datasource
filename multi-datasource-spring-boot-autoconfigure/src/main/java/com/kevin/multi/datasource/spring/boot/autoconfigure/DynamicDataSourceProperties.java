package com.kevin.multi.datasource.spring.boot.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 动态数据源配置
 *
 * @author wangyong
 */
@ConfigurationProperties(prefix = DynamicDataSourceProperties.prefix)
public class DynamicDataSourceProperties {

    public static final String prefix = "spring.datasource.dynamic";


}
