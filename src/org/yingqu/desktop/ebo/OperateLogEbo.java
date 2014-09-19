package org.yingqu.desktop.ebo;


import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

import org.yingqu.desktop.ebi.OperateLogEbi;
import org.yingqu.desktop.model.EndUser;
import org.yingqu.desktop.model.OperateLog;
import org.yingqu.desktop.security.SecurityUserHolder;
import org.yingqu.framework.annotation.IgnoreBusinessLog;
import org.yingqu.framework.controllers.SimpleBaseController;
import org.yingqu.framework.ebo.SimpleEbo;
import org.yingqu.framework.log.AppLoggerFactory;
import org.yingqu.framework.model.Model;
import org.yingqu.framework.utils.DateUtil;
import org.yingqu.framework.utils.EntityUtil;
import org.yingqu.framework.utils.ModelUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class OperateLogEbo extends SimpleEbo<OperateLog> implements OperateLogEbi {
	 private static final Logger LOG = AppLoggerFactory.getyingquLogger(OperateLogEbo.class);
	protected OperateLogEbo() {
		super(OperateLog.class);
		// TODO Auto-generated constructor stub
	}
	/**
     * 将日志加入BufferLogCollector定义的内存缓冲区
     * @param model
     * @param type 
     */
    public void saveLog(Model model, String type){
        //判断模型是否已经指定忽略记录增删改日志
        if(!model.getClass().isAnnotationPresent(IgnoreBusinessLog.class)){
        	EndUser user=SecurityUserHolder.getCurrentUser();
            String ip=SecurityUserHolder.getCurrentUserLoginIp();
            OperateLog operateLog=new OperateLog();
            if(user != null){
                operateLog.setUsername(user.getUsername());
            }
            operateLog.setLoginIP(ip);
            try {
                operateLog.setServerIP(InetAddress.getLocalHost().getHostAddress());
            } catch (UnknownHostException ex) {
                LOG.error("无法获取服务器IP", ex);
            }
            operateLog.setAppName(SimpleBaseController.appName);
            operateLog.setOperatingTime(DateUtil.formatDateTime(new Date()));
            operateLog.setCreateTime(DateUtil.formatDateTime(new Date()));
            operateLog.setModifyTime(DateUtil.formatDateTime(new Date()));
            operateLog.setUpdateTime(DateUtil.formatDateTime(new Date()));
            operateLog.setModifyUser(SecurityUserHolder.getCurrentUser().getUserCode());
            operateLog.setCreateUser(SecurityUserHolder.getCurrentUser().getUserCode());
            operateLog.setCreateDept(SecurityUserHolder.getCurrentDept().getDeptCode());
            operateLog.setModifyDept(SecurityUserHolder.getCurrentDept().getDeptCode());
            operateLog.setOperatingModel(model.getClass().getName());
            operateLog.setOperatingType(type);
        	String pkName=ModelUtil.getClassPkName(model.getClass());
    		String pkValue=(String) EntityUtil.getPropertyValue(model, pkName); 	
    		//将日志持久化到数据库存中
            operateLog.setOperatingID(pkValue);
            try {
            	this.save(operateLog);
            	 LOG.info("写入日志成功！ "+operateLog.getOperatingID()+"-"+ operateLog.getDescription());
			} catch (Exception e) {
				e.printStackTrace();
				 LOG.error("写入日志错误！", e);
			}
          
        }
    }
}
