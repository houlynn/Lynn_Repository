package org.yingqu.framework.model;
import java.util.LinkedList;
import java.util.List;
import org.yingqu.framework.log.AppLoggerFactory;
import org.yingqu.framework.model.modelHandler.ModelHandler;
import org.apache.log4j.Logger;
import org.hibernate.event.spi.PostDeleteEvent;
import org.hibernate.event.spi.PostDeleteEventListener;
import org.hibernate.event.spi.PostInsertEvent;
import org.hibernate.event.spi.PostInsertEventListener;
import org.hibernate.event.spi.PostUpdateEvent;
import org.hibernate.event.spi.PostUpdateEventListener;
import org.hibernate.event.spi.PreDeleteEvent;
import org.hibernate.event.spi.PreDeleteEventListener;
import org.hibernate.event.spi.PreInsertEvent;
import org.hibernate.event.spi.PreInsertEventListener;
import org.hibernate.event.spi.PreUpdateEvent;
import org.hibernate.event.spi.PreUpdateEventListener;
import org.hibernate.persister.entity.EntityPersister;
/**
 * 模型监听事件调度器
 * 可注册与反注册多个ModelHandler的实现
 * 相应事件发生的时候，改调度器负责转发给所有注册的ModelHandler
* @author 作者 yingqu: 
* @version 创建时间：2014年7月4日 下午6:50:01 
* version 1.0
 */
public class ModelListener implements  PostInsertEventListener, PreInsertEventListener,PostUpdateEventListener,PreUpdateEventListener , PostDeleteEventListener,PreDeleteEventListener {
    private static final Logger LOG = AppLoggerFactory.getyingquLogger(ModelListener.class);
    private static final List<ModelHandler> modelHandlers = new LinkedList<>();
    public static void addModelHandler(ModelHandler modelHandler){
        LOG.info("注册模型事件处理器："+modelHandler.getClass().getName());
        modelHandlers.add(modelHandler);
    }
    public static void removeModelHandler(ModelHandler modelHandler){
        LOG.info("移除模型事件处理器："+modelHandler.getClass().getName());
        modelHandlers.remove(modelHandler);
    }
	@Override
	public boolean onPreDelete(PreDeleteEvent event) {
		// TODO Auto-generated method stub
		 LOG.info("onPreDelete "+event.getEntity());
		 for(ModelHandler modelHandler :modelHandlers )
		 {
			 modelHandler.onPreDelete(event);
		 }
		return false;
	}
	@Override
	public void onPostDelete(PostDeleteEvent event) {
		// TODO Auto-generated method stub
		 LOG.info("onPostDelete "+event.getEntity());
		 for(ModelHandler modelHandler :modelHandlers )
		 {
			 modelHandler.onPostDelete(event);
		 }
	}
	@Override
	public boolean onPreUpdate(PreUpdateEvent event) {
		// TODO Auto-generated method stub
		 LOG.info("onPreUpdate "+event.getEntity());
		 for(ModelHandler modelHandler :modelHandlers )
		 {
			 modelHandler.onPreUpdate(event);
		 }
		return false;
	}
	@Override
	public void onPostUpdate(PostUpdateEvent event) {
		// TODO Auto-generated method stub
		 LOG.info("onPostUpdate "+event.getEntity());
		 for(ModelHandler modelHandler :modelHandlers )
		 {
			 modelHandler.onPostUpdate(event);
		 }
	}
	@Override
	public boolean onPreInsert(PreInsertEvent event) {
		// TODO Auto-generated method stub
		 LOG.info("onPreInsert "+event.getEntity());
		 for(ModelHandler modelHandler :modelHandlers )
		 {
			 modelHandler.onPreInsert(event);
		 }
		
		return false;
	}
	@Override
	public void onPostInsert(PostInsertEvent event) {
		// TODO Auto-generated method stub
		 LOG.info("onPostInsert "+event.getEntity());
		 for(ModelHandler modelHandler :modelHandlers )
		 {
			 modelHandler.onPostInsert(event);
		 }
	}
	@Override
	public boolean requiresPostCommitHanding(EntityPersister event) {
		// TODO Auto-generated method stub
		 LOG.info("requiresPostCommitHanding "+event.getEntityName());
		 for(ModelHandler modelHandler :modelHandlers )
		 {
			 modelHandler.requiresPostCommitHanding(event);
		 }
		return false;
	}
}