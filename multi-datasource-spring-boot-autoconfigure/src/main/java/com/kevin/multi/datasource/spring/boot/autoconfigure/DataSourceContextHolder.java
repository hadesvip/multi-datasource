package com.kevin.multi.datasource.spring.boot.autoconfigure;

/**
 * dataSource上下文
 *
 * @author wangyong
 */
public class DataSourceContextHolder {

    private static final ThreadLocal<DataSourceTypeEnum> CONTEXT_HOLDER = new ThreadLocal<>();

    /**
     * 设置数据源
     *
     * @param dataSourceType 数据源类型
     */
    public static void setDataSource(DataSourceTypeEnum dataSourceType) {
        CONTEXT_HOLDER.set(dataSourceType);
    }


    /**
     * 获取数据源类型
     */
    public static DataSourceTypeEnum getDataSourceType() {
        DataSourceTypeEnum datasourceType = CONTEXT_HOLDER.get();
        return datasourceType == null ? DataSourceTypeEnum.MASTER : datasourceType;
    }

    /**
     * 清楚数据源类型
     */
    public static void clearDataSourceType() {
        CONTEXT_HOLDER.remove();
    }


}
