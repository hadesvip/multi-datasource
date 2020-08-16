package com.kevin.multi.datasource.spring.boot.autoconfigure;

import java.lang.annotation.*;

/**
 * 动态设置数据源 (write-主库，增删改操作，read-从库，查询操作)
 *
 * @author wangyong
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
@Documented
public @interface DataSource {

    DataSourceTypeEnum value() default DataSourceTypeEnum.MASTER;

}
