package com.bsoft.office.sysconfig.filter;

import com.bsoft.office.sysconfig.constant.CryptoConstant;
import com.bsoft.office.sysconfig.decrypt.RequestDecrypter;
import lombok.SneakyThrows;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

public class DecryptFilter implements Filter {
    private Integer cryptFlag;

    public DecryptFilter(Integer cryptFlag) {
        this.cryptFlag = cryptFlag;
    }

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @SneakyThrows
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String uri = httpServletRequest.getRequestURI().toLowerCase();
        boolean check = !ServletFileUpload.isMultipartContent(httpServletRequest)// 文件上传请求
                && this.cryptFlag == 1;// 加解密标志0不加解密 1加解密
        for (String path : CryptoConstant.PATH) {
            if (uri.endsWith(path)) { // 跳过加解密的请求
                check = false;
            }
        }
        if (check) {
            RequestDecrypter.decryptGet(httpServletRequest); // get请求解密
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
