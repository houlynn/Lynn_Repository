package org.yingqu.desktop.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.yingqu.framework.controllers.SimpleBaseController;
import org.yingqu.framework.model.BaseEntity;
import org.yingqu.framework.utils.DateUtil;
import org.yingqu.framework.utils.EntityUtil;
import org.yingqu.framework.utils.PropUtil;
import org.yingqu.framework.utils.StringUtil;
import org.springframework.web.multipart.MultipartFile;
public class ProcessFieldsUploadUtil {
	private static final Integer BUFFER_SIZE=16*1024;
	
	//上传文件处理
	public static void processFieldsUpload(HttpServletRequest request,BaseEntity model, MultipartFile icon,String uploadField){
		upload(model, icon,uploadField);
	}
	
	public static String  processFieldsUpload(MultipartFile icon,String saveConfig){
		return  upload(icon,saveConfig);
	}
	
	private static void upload(BaseEntity model, MultipartFile icon,String uploadField) {
		//前台会穿三个参数
		/**
		 * 1.字段名：得到文件流对象
		 * 2.字段名FileName  文件名称
		 * 3.字段名ContextType 文件类型
		 */
		String fileName=icon.getName();
		InputStream ins=null;;
		try {
			ins = icon.getInputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(StringUtil.isNotEmpty(fileName)&&ins!=null&&StringUtil.isNotEmpty(icon.getOriginalFilename()))
		{
		String toUploadDir=PropUtil.get("menu.upload.path")+"/"+DateUtil.formatDate(new Date());
		File dir=new File(SimpleBaseController.webrootAbsPath+toUploadDir);
		if(!dir.exists()){
			//logger.info("创建文件目录"+toUploadDir);
			dir.mkdirs();
		}		
		fileName=UUID.randomUUID()+"."+icon.getOriginalFilename();
		String rootPath=toUploadDir+"/"+fileName;
		File dst=new File(SimpleBaseController.webrootAbsPath+rootPath);
		copy(ins, dst, false);
		EntityUtil.invokeSetMethod(model, uploadField, new Object[]{rootPath});
		}
	}
	
	private static String upload( MultipartFile icon,String saveConfig) {
		//前台会穿三个参数
		/**
		 * 1.字段名：得到文件流对象
		 * 2.字段名FileName  文件名称
		 * 3.字段名ContextType 文件类型
		 */
		String fileName=icon.getName();
		InputStream ins=null;;
		try {
			ins = icon.getInputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(StringUtil.isNotEmpty(fileName)&&ins!=null&&StringUtil.isNotEmpty(icon.getOriginalFilename()))
		{
		String toUploadDir=PropUtil.get(saveConfig)+"/"+DateUtil.formatDate(new Date());
		File dir=new File(SimpleBaseController.webrootAbsPath+toUploadDir);
		if(!dir.exists()){
			//logger.info("创建文件目录"+toUploadDir);
			dir.mkdirs();
		}		
		fileName=UUID.randomUUID()+"."+icon.getOriginalFilename();
		String rootPath=toUploadDir+"/"+fileName;
		File dst=new File(SimpleBaseController.webrootAbsPath+rootPath);
		copy(ins, dst, false);
		return rootPath;
		}
		return null;
	}
	
	/**
	 * 写出文件的方法
	 * @param src 前台传的file对象
	 * @param dst 目标的文件对象
	 * @param overwrite 是否覆盖
	 */
	private  static void copy(InputStream in, File dst, boolean overwrite)  {
		 try  {
	            if(dst.exists() && overwrite) {
	                dst.delete();
	            }
	           OutputStream out = null ;
	            try  {                
	               out = new BufferedOutputStream(new FileOutputStream(dst),BUFFER_SIZE);
	                byte [] buffer = new byte [BUFFER_SIZE];
	                while (in.read(buffer) > 0 )  {
	                   out.write(buffer);
	               } 
	            } finally  {
	                if ( null != in)  {
	                   in.close();
	               } 
	                if ( null != out)  {
	                   out.close();
	               } 
	            } 
	         } catch (Exception e)  {
	            e.printStackTrace();
	        } 
	}
	
	
	public static void upload(BaseEntity model, MultipartFile icon,String uploadField,String config) {
		//前台会穿三个参数
		/**
		 * 1.字段名：得到文件流对象
		 * 2.字段名FileName  文件名称
		 * 3.字段名ContextType 文件类型
		 */
		String fileName=icon.getName();
		InputStream ins=null;;
		try {
			ins = icon.getInputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(StringUtil.isNotEmpty(fileName)&&ins!=null&&StringUtil.isNotEmpty(icon.getOriginalFilename()))
		{
		String toUploadDir=PropUtil.get(config)+"/"+DateUtil.formatDate(new Date());
		File dir=new File(SimpleBaseController.webrootAbsPath+toUploadDir);
		if(!dir.exists()){
			//logger.info("创建文件目录"+toUploadDir);
			dir.mkdirs();
		}		
		fileName=UUID.randomUUID()+"."+icon.getOriginalFilename();
		String rootPath=toUploadDir+"/"+fileName;
		File dst=new File(SimpleBaseController.webrootAbsPath+rootPath);
		copy(ins, dst, false);
		EntityUtil.invokeSetMethod(model, uploadField, new Object[]{rootPath});
		}
	} 
	
}

