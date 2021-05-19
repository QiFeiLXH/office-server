package com.bsoft.office.common.manager;

/**
 * @Author: xucl
 * @DateTime: 2020/11/23 13:09
 * @Description:
 */
public interface ServerDateManager {
    /**
     * @Description: 获取服务器当前日期
     * @return java.sql.Date 服务器当前日期
     */
    public java.sql.Date getServerDate();
    /**
     * @Description: 获取服务器当前日期和时间（包含时分秒）
     * @return java.sql.Date 服务器当前日期和时间
     */
    public java.util.Date getServerDateTime();
}
