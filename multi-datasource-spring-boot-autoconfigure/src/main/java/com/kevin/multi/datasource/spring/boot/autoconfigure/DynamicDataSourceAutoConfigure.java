package com.kevin.multi.datasource.spring.boot.autoconfigure;

import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * 多数据源自动装配
 *
 * @author wangyong
 */
@Configuration
@EnableConfigurationProperties(DynamicDataSourceProperties.class)
@AutoConfigureBefore(DataSourceAutoConfiguration.class)
@ConditionalOnProperty(prefix = DynamicDataSourceProperties.prefix,
        name = "enabled", havingValue = "true", matchIfMissing = true)
public class DynamicDataSourceAutoConfigure {


    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = DynamicDataSourceProperties.prefix, value = "enable", havingValue = "true")
    DataSource dataSource(DynamicDataSourceProperties properties, Environment env) {
        DataSource dataSource = null;


        return dataSource;
    }


}
