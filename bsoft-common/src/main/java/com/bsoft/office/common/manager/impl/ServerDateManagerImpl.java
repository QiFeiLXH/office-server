package com.bsoft.office.common.manager.impl;

import com.bsoft.common.service.ServerDateService;
import com.bsoft.office.common.manager.ServerDateManager;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

import java.sql.Date;

/**
 * @Author: xucl
 * @DateTime: 2020/11/23 13:10
 * @Description:
 */
@Component
public class ServerDateManagerImpl implements ServerDateManager {
    @Reference
    private ServerDateService serverDateService;

    @Override
    public Date getServerDate() {
        return serverDateService.getServerDate();
    }

    @Override
    public java.util.Date getServerDateTime() {
        return serverDateService.getServerDateTime();
    }
}
