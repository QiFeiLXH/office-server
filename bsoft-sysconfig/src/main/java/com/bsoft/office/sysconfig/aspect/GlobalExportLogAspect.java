package com.bsoft.office.sysconfig.aspect;

import com.bsoft.exception.ServiceException;
import com.bsoft.office.common.condition.ExportLogParams;
import com.bsoft.office.system.manager.ExportLogManager;
import com.bsoft.office.system.vo.ExportLogVO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author Xuhui Lin
 * @Date 2020/6/4 15:58
 * @Description 系统导出日志切面，导出结束后执行保存导出记录
 */
@Aspect
@Component
public class GlobalExportLogAspect {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExportLogAspect.class);

    @Autowired
    private ExportLogManager exportLogManager;

    /***
      * 根据指定@RequiredExportLog注解切入，待切入点的导出方法执行前执行
     */
    @Before("@annotation(com.bsoft.office.common.annotation.RequiredExportLog)")
    public void beforeExport(JoinPoint point){
        // 获取切入点的方法参数与参数值
        Object[] args = point.getArgs();
        String methodName = point.getSignature().getName();
        logger.info("导出方法{}开始前，执行进入保存系统导出日志！",methodName);

        ExportLogParams params = null;
        ExportLogVO exportLogVO = new ExportLogVO();
        for (int i = 0; i < args.length; i++) {
            // 判断切入点的方法参数是否是待保存的参数对象，是则退出循环取该对象的属性值
            if (args[i] instanceof ExportLogParams) {
                params = (ExportLogParams)args[i];
                break;
            }
        }
        if (params != null) {
            exportLogVO.setSystem(params.getSystem());
            exportLogVO.setMenuId(params.getMenuId());
            exportLogVO.setPersonId(params.getPersonId());
            exportLogVO.setContext(params.getContext());
            exportLogManager.saveExportLog(exportLogVO);
        } else {
            throw new ServiceException("切入点方法(" + methodName + ")未添加指定系统保存参数对象");
        }
    }

}
