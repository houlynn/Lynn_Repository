package org.yingqu.desktop.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.yingqu.framework.controllers.SimpleBaseController;
import org.yingqu.framework.core.utils.MD5Util;
import org.yingqu.framework.log.AppLoggerFactory;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;


/**
 *  系统初始化监听器
* @author 作者 yingqu: 
* @version 创建时间：2014年6月7日 下午10:18:15 
* version 1.0
 */
public class DesktopContextLintener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sc) {
		// TODO Auto-generated method stub
		SimpleBaseController.appName=	sc.getServletContext().getContextPath();
		SimpleBaseController.webrootAbsPath=sc.getServletContext().getRealPath("/");
		SimpleBaseController.absClassPath=DesktopContextLintener.class.getResource("/").getPath().substring(1);
		System.out.println(SimpleBaseController.webrootAbsPath);
		System.out.println(SimpleBaseController.absClassPath);
		
	}

}
