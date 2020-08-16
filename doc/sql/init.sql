drop database nbms_store_master;
drop database nbms_store_slave;
create database nbms_store_master;
create database nbms_store_slave;
use nbms_store_master;
drop table trade;
create table trade
(
    id                bigint auto_increment primary key,
    order_no          varchar(64)      null comment '订单号',
    status            varchar(16)      null comment '状态',
    product_name      varchar(256)     null comment '商品名称',
    merchant_order_no varchar(64)      not null comment '商户订单号',
    order_amount      bigint default 0 null comment '订单金额',
    order_from        varchar(16)      null comment '订单来源',
    merchant_name     varchar(128)     null comment '商家名称',
    merchant_no       varchar(64)      not null comment '商户编号',
    order_date_time   datetime         null comment '下单时间',
    order_period      int              null comment '订单有效期(单位秒)',
    expire_datetime   datetime         null comment '到期时间',
    create_date_time  datetime         not null comment '创建时间',
    editor            varchar(32)      null comment '修改者',
    creator           varchar(32)      null comment '创建者',
    edit_datetime     datetime         null comment '最后修改时间',
    remark            varchar(200)     null comment '支付备注'
);

use nbms_store_slave;
drop table trade;
create table trade
(
    id                bigint auto_increment primary key,
    order_no          varchar(64)      null comment '订单号',
    status            varchar(16)      null comment '状态',
    product_name      varchar(256)     null comment '商品名称',
    merchant_order_no varchar(64)      not null comment '商户订单号',
    order_amount      bigint default 0 null comment '订单金额',
    order_from        varchar(16)      null comment '订单来源',
    merchant_name     varchar(128)     null comment '商家名称',
    merchant_no       varchar(64)      not null comment '商户编号',
    order_date_time   datetime         null comment '下单时间',
    order_period      int              null comment '订单有效期(单位秒)',
    expire_datetime   datetime         null comment '到期时间',
    create_date_time  datetime         not null comment '创建时间',
    editor            varchar(32)      null comment '修改者',
    creator           varchar(32)      null comment '创建者',
    edit_datetime     datetime         null comment '最后修改时间',
    remark            varchar(200)     null comment '支付备注'
);



