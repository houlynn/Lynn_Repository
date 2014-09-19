package org.yingqu.framework.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;

import org.yingqu.framework.constant.ExtFieldType;

/**
 * 描述实体字段的注解
* @author 作者 yingqu: 
* @version 创建时间：2014年6月7日 上午11:00:48 
* version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)  
public @interface FieldInfo {
	public String name() default ""; //字段名称
	public ExtFieldType type() default ExtFieldType.STRING; //字段类型
	public boolean visible()default false;//是否作为视图字段
	public int width() default 120;
	public boolean nullAble() default true;
	public String regexType()default"required";
	public int index() default 0;
    public boolean 	mobileField() default false;
    
	
	
}
