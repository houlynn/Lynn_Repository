import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.management.relation.Role;

import org.yingqu.desktop.model.EndUser;
import org.yingqu.desktop.model.Menu;
import org.yingqu.desktop.model.OperateLog;
import org.yingqu.desktop.model.Permission;
import org.yingqu.desktop.model.SysIcon;
import org.yingqu.desktop.model.view.VDeptUser;
import org.yingqu.framework.model.BaseEntity;

import freemarker.core.Configurable;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;


public class FreeMarker {
	
	public Class clazz;



	public Template getTemplate(String tplName)
	{
		Configuration cfg=new Configuration();
		cfg.setClassForTemplateLoading(this.getClass(), "/ftl");
		Template template=null;
		try {
			template=cfg.getTemplate(tplName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return template;
	}
	public void printTemp(String tplName,Map<String,Object> root)
	{
		try {
			this.getTemplate(tplName).process(root,new PrintWriter( System.out));
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void printControllerTemp()
	{
		try {
			Map<String,Object> map=new HashMap<String, Object>();
			map.put("className", clazz.getSimpleName());
			FileWriter fos=new FileWriter(new File("H:\\CodeSrcounce\\Java\\bookMrg\\JunMing\\src\\code\\"+clazz.getSimpleName()+"Controller.java"));
			
			this.getTemplate("Controller.ftl").process(map,fos);
			fos.close();
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void printEboTemp()
	{
		try {
			Map<String,Object> map=new HashMap<String, Object>();
			map.put("className", clazz.getSimpleName());
			FileWriter fos=new FileWriter(new File("H:\\CodeSrcounce\\Java\\bookMrg\\JunMing\\src\\code\\"+clazz.getSimpleName()+"Ebo.java"));
			
			this.getTemplate("Ebo.ftl").process(map,fos);
			fos.close();
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void printEbiTemp()
	{
		try {
			Map<String,Object> map=new HashMap<String, Object>();
			map.put("className", clazz.getSimpleName());
			FileWriter fos=new FileWriter(new File("H:\\CodeSrcounce\\Java\\bookMrg\\JunMing\\src\\code\\"+clazz.getSimpleName()+"Ebi.java"));
			
			this.getTemplate("Ebi.ftl").process(map,fos);
			fos.close();
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void printRepertoryTemp()
	{
		try {
			Map<String,Object> map=new HashMap<String, Object>();
			map.put("className", clazz.getSimpleName());
			FileWriter fos=new FileWriter(new File("H:\\CodeSrcounce\\Java\\bookMrg\\JunMing\\src\\code\\"+clazz.getSimpleName()+"RepertoryImpl.java"));
			
			this.getTemplate("IRepertoryImpl.ftl").process(map,fos);
			fos.close();
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void printIRepertoryTemp()
	{
		try {
			Map<String,Object> map=new HashMap<String, Object>();
			map.put("className", clazz.getSimpleName());
			FileWriter fos=new FileWriter(new File("H:\\CodeSrcounce\\Java\\bookMrg\\JunMing\\src\\code\\"+clazz.getSimpleName()+"Repertory.java"));
			
			this.getTemplate("IRepertory.ftl").process(map,fos);
			fos.close();
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public static void main(String[] args) {

	FreeMarker freeMarker=new FreeMarker();
	freeMarker.clazz=OperateLog.class;
	freeMarker.printControllerTemp();
	freeMarker.printEbiTemp();
	freeMarker.printEboTemp();
	freeMarker.printIRepertoryTemp();
	freeMarker.printRepertoryTemp();
	
		
	}
	
}
