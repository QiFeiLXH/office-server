package com.bsoft.office.sysconfig.manager.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.bsoft.logs.dto.RequestLogDTO;
import com.bsoft.message.logs.RequestLogMessage;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.jsonutil.JSONUtils;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.sysconfig.manager.RequestLogManager;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author: zy
 * @date: 2020/10/26
 * @description
 */
@Component
public class RequestLogManagerImpl implements RequestLogManager {

    private static final Logger logger = LoggerFactory.getLogger(RequestLogManagerImpl.class);

    @Reference
    private RequestLogMessage requestLogMessage;

    @Override
    public void sendMessage(RequestLogDTO requestLogDTO) {
        requestLogMessage.send(requestLogDTO);
    }

    @Override
    @Async
    public void generateOperlog(RequestLogDTO operlog,Integer type, Object keys, SerializeFilter[] filters, Throwable e) {
        if ("1".equals(type.toString())){//正常
            String result = JSONObject.toJSONString(keys,filters);
            if(result.length() > 2000){
                operlog.setResults(result.substring(0,2000));
            }else{
                operlog.setResults(result);
            }
        }else{//异常
            String result = stackTraceToString(e.getClass().getName(), e.getMessage(), e.getStackTrace());
            operlog.setResults(result);
        }
        requestLogMessage.send(operlog);
    }

    public String stackTraceToString(String exceptionName, String exceptionMessage, StackTraceElement[] elements) {
        StringBuffer strbuff = new StringBuffer();
        for (StackTraceElement stet : elements) {
            strbuff.append(stet + "\n");
        }
        String message = exceptionName + ":" + exceptionMessage + "\n\t" + strbuff.toString();
        if (message.length() > 2000){
            return message.substring(0,2000);
        }else{
            return message;
        }
    }
}
