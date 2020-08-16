package com.kevin.multi.datasource.spring.boot.autoconfigure;

/**
 * 数据源类型
 *
 * @author wangyong
 */
public enum DataSourceTypeEnum {

    /**
     * 读库
     */
    MASTER,

    /**
     * 写库
     */
    SLAVE;



}
