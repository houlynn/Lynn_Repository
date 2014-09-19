package org.yingqu.framework.model.modelHandler;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.yingqu.desktop.model.EndUser;
import org.yingqu.desktop.model.OperateLog;
import org.yingqu.desktop.security.SecurityUserHolder;
import org.yingqu.framework.annotation.IgnoreBusinessLog;
import org.yingqu.framework.constant.OperateLogType;
import org.yingqu.framework.controllers.SimpleBaseController;
import org.yingqu.framework.ebi.SimpleEbi;
import org.yingqu.framework.log.AppLoggerFactory;
import org.yingqu.framework.model.Model;
import org.yingqu.framework.utils.EntityUtil;
import org.yingqu.framework.utils.ModelUtil;
import org.yingqu.framework.utils.PropUtil;
import org.apache.log4j.Logger;
import org.hibernate.event.spi.PostDeleteEvent;
import org.hibernate.event.spi.PostInsertEvent;
import org.hibernate.event.spi.PostUpdateEvent;
import org.hibernate.event.spi.PreDeleteEvent;
import org.hibernate.event.spi.PreInsertEvent;
import org.hibernate.event.spi.PreUpdateEvent;
import org.hibernate.persister.entity.EntityPersister;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * 记录业务操作日志模型事件处理器
* @author 作者 yingqu: 
* @version 创建时间：2014年7月4日 下午7:01:06 
* version 1.0
 */
//@Service
public class OperateLogModelHandler extends ModelHandler{
    private static final Logger LOG = AppLoggerFactory.getyingquLogger(OperateLogModelHandler.class);
    private static final boolean CREATE;
    private static final boolean DELETE;
    private static final boolean UPDATE;
  
    protected OperateLogModelHandler()
    {
    	LOG.info("OperateLogModelHandler create success");	
    }
    static{
        CREATE=PropUtil.getBooleanProperty("log.create");
        DELETE=PropUtil.getBooleanProperty("log.delete");
        UPDATE=PropUtil.getBooleanProperty("log.update");
        if(CREATE){
            LOG.info("启用添加数据日志");
            LOG.info("Enable create data log");
        }else{
            LOG.info("禁用添加数据日志");
            LOG.info("Disable create data log");
        }
        if(DELETE){
            LOG.info("启用删除数据日志");
            LOG.info("Enable delete data log");
        }else{
            LOG.info("禁用删除数据日志");
            LOG.info("Disable delete data log");
        }
        if(UPDATE){
            LOG.info("启用更新数据日志");
            LOG.info("Enable update data log");
        }else{
            LOG.info("禁用更新数据日志");
            LOG.info("Disable update data log");
        }
    }
    @Autowired
    private SimpleEbi<OperateLog> ebi;
    public SimpleEbi<OperateLog> getEbi() {
		return ebi;
	}

	public void setEbi(SimpleEbi<OperateLog> ebi) {
		this.ebi = ebi;
	}

	/**
     * 注册模型处理器
     */
    @PostConstruct
    public void init(){
       // ModelListener.addModelHandler(this);
        LOG.info(("注册模型处理器: "+this.getClass().getName()+"监听器"));
    }
    
    /**
     * 将日志加入BufferLogCollector定义的内存缓冲区
     * @param model
     * @param type 
     */
    private void saveLog(Model model, String type){
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
            //operateLog.setOperatingTime( new Date());
            operateLog.setOperatingType(type);
            operateLog.setOperatingModel(model.getDescription());
        	String pkName=ModelUtil.getClassPkName(model.getClass());
    		String pkValue=(String) EntityUtil.getPropertyValue(model, pkName);
    		//将日志持久化到数据库存中
            operateLog.setOperatingID(pkValue);
            try {
				ebi.save(operateLog);
			} catch (Exception e) {
				e.printStackTrace();
				 LOG.error("写入日志错误！", e);
			}
          
        }
    }

	@Override
	public void onPostInsert(PostInsertEvent event) {
		// TODO Auto-generated method stub
		if(event.getEntity() instanceof Model&&event.getEntity().getClass().isAnnotationPresent(IgnoreBusinessLog.class)&&CREATE)
		{
			Model model=(Model) event.getEntity();
			 saveLog(model, OperateLogType.ADD);
			 LOG.debug("记录模型创建日志: "+model);
		}
		
	}

	@Override
	public boolean requiresPostCommitHanding(EntityPersister event) {
		// TODO Auto-generated method stub
		  LOG.debug("提交: "+event.getEntityName());
		return false;
	}

	@Override
	public boolean onPreInsert(PreInsertEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onPostUpdate(PostUpdateEvent event) {
		// TODO Auto-generated method stub
		if(event.getEntity() instanceof Model&&event.getEntity().getClass().isAnnotationPresent(IgnoreBusinessLog.class)&&UPDATE)
		{
			Model model=(Model) event.getEntity();
			 saveLog(model, OperateLogType.UPDATE);
			  LOG.debug("记录模型修改日志: "+model);
		}
		
	}

	
	@Override
	public boolean onPreDelete(PreDeleteEvent arg0) {
		// TODO Auto-generated method stub
		return super.onPreDelete(arg0);
	}

	@Override
	public boolean onPreUpdate(PreUpdateEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onPostDelete(PostDeleteEvent event) {
		// TODO Auto-generated method stub
		if(event.getEntity() instanceof Model&&event.getEntity().getClass().isAnnotationPresent(IgnoreBusinessLog.class)&&DELETE)
		{
			 Model model=(Model) event.getEntity();
			 saveLog(model, OperateLogType.DELETE);
			 LOG.debug("记录模型删除日志: "+model);
		}
		
	}

}
