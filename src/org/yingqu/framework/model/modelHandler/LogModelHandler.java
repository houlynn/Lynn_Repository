package org.yingqu.framework.model.modelHandler;

import javax.annotation.PostConstruct;

import org.yingqu.desktop.ebi.OperateLogEbi;
import org.yingqu.desktop.model.OperateLog;
import org.yingqu.framework.annotation.IgnoreBusinessLog;
import org.yingqu.framework.constant.OperateLogType;
import org.yingqu.framework.ebi.SimpleEbi;
import org.yingqu.framework.log.AppLoggerFactory;
import org.yingqu.framework.model.Model;
import org.yingqu.framework.utils.PropUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 记录业务操作日志模型事件处理器
* @author 作者 yingqu: 
* @version 创建时间：2014年7月4日 下午7:01:06 
* version 1.0
 */
@Service
public class LogModelHandler extends ModelHandler{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = AppLoggerFactory.getyingquLogger(LogModelHandler.class);
    public static final boolean CREATE;
    public static final boolean DELETE;
    public static final boolean UPDATE;
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
    	ModelInterceptor.addModelHandler(this);
        LOG.info(("注册模型处理器: "+this.getClass().getName()+"监听器"));
    }
    
    
    @Override
	public void prePersist(Model model) {
		// TODO Auto-generated method stub
		super.prePersist(model);
	}

	@Override
	public void postPersist(Model model) {
		// TODO Auto-generated method stub
		super.postPersist(model);
	}

	@Override
	public void preRemove(Model model) {
		// TODO Auto-generated method stub
		super.preRemove(model);
	}

	@Override
	public void postRemove(Model model) {
		// TODO Auto-generated method stub
		if(!model.getClass().isAnnotationPresent(IgnoreBusinessLog.class)&&DELETE)
		{
			 OperateLogEbi operateLogEbi=(OperateLogEbi)ebi;
			 operateLogEbi.saveLog(model, OperateLogType.DELETE);
			 LOG.info("记录模型删除日志: "+model.getClass().getSimpleName()+":("+model.getDescription()+")");
		}
	}

	@Override
	public void preUpdate(Model model) {
		// TODO Auto-generated method stub
		super.preUpdate(model);
	}

	@Override
	public void postUpdate(Model model) {
		// TODO Auto-generated method stub
		if(!model.getClass().isAnnotationPresent(IgnoreBusinessLog.class)&&UPDATE)
		{
			 OperateLogEbi operateLogEbi=(OperateLogEbi)ebi;
			 operateLogEbi.saveLog(model, OperateLogType.UPDATE);
			  LOG.info("记录模型修改日志: "+model.getClass().getSimpleName()+":("+model.getDescription()+")");
		}
	}

	@Override
	public void postLoad(Model model) {
		// TODO Auto-generated method stub
		super.postLoad(model);
	}

	@Override
	public void postSave(Model model) {
		// TODO Auto-generated method stub
		if(!model.getClass().isAnnotationPresent(IgnoreBusinessLog.class)&&CREATE){
			 OperateLogEbi operateLogEbi=(OperateLogEbi)ebi;
			 try {
				operateLogEbi.saveLog(model,OperateLogType.ADD);
			} catch (Exception e) {
				  LOG.info("记录模型创建日志失败！: "+model.getClass().getSimpleName()+":("+model.getDescription()+")");
				LOG.error(e);
				e.printStackTrace();
			}
	            LOG.info("记录模型创建日志: "+model.getClass().getSimpleName()+":("+model.getDescription()+")");
	        }
}

	@Override
	public void preSave(Model model) {
		// TODO Auto-generated method stub
		super.preSave(model);
	}


}
