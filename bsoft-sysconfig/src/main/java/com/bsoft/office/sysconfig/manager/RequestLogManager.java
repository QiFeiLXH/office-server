package com.bsoft.office.sysconfig.manager;

import com.alibaba.fastjson.serializer.SerializeFilter;
import com.bsoft.logs.dto.RequestLogDTO;

/**
 * @author: zy
 * @date: 2020/10/26
 * @description
 */
public interface RequestLogManager {

    void sendMessage(RequestLogDTO requestLogDTO);

    void generateOperlog(RequestLogDTO operLog,Integer type, Object keys, SerializeFilter[] filters, Throwable e);
}
