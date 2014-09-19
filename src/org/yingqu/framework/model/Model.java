package org.yingqu.framework.model;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Transient;

import org.yingqu.framework.annotation.DefaultOrder;
import org.yingqu.framework.annotation.FieldInfo;


/**
 * 
* @author 作者 yingqu: 
* @version 创建时间：2014年6月7日 上午12:04:26 
* version 1.0
 */

public interface Model extends Serializable {
	public String toString();
	public default String defaultOrderString(){
		if(this.getClass().isAnnotationPresent(DefaultOrder.class))
		{
			DefaultOrder order=this.getClass().getAnnotation(DefaultOrder.class);
			return " 	order by "+order.value()+" desc";
		}
		return "";
	}
	public  String getDescription();
	default List<Field> fielsColection(final Class<?> clazz,  final List<Field> list) {
		for (Field field : clazz.getDeclaredFields()) {
			list.add(field);
		}
		if (clazz.getSuperclass() != Object.class) {
			this.fielsColection(clazz.getSuperclass(), list);
		}
		return list;
	}
	default List<Field> fielsColection(final List<Field> list) {
		for (Field field : this.getClass().getDeclaredFields()) {
			list.add(field);
		}
		return list;
	}
	default String SelfreflectionAll()
	{
		StringBuffer buf = new StringBuffer();
		buf.append(this.getClass().getSimpleName() + " : ");
		String str = "";
		str += this.getClass() + " : ";
		buf.append(str);
		List<Field> list = new ArrayList<Field>();
		this.fielsColection(this.getClass(), list);
		for(Field field : list)
		{
			field.setAccessible(true);
			Object value=null;
			String fieldInfoDesc=null;
			buf.append("FieldType:("+field.getType().getSimpleName()+") ");
			if(field.getType()==this.getClass())
			{
				buf.append("  value=continue");
				continue;
			}
			if(field.isAnnotationPresent(FieldInfo.class))
			{
				FieldInfo fieldInfo=field.getAnnotation(FieldInfo.class);
				fieldInfoDesc= fieldInfo.name();
			}
			try {
				value=field.get(this);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			buf.append(field.getName()+"[ "+fieldInfoDesc+"]" + "=" + value+" " );
		}
		return buf.toString();
	}
	default String Selfreflection()
	{
		StringBuffer buf = new StringBuffer();
		buf.append(this.getClass().getSimpleName() + " : ");
		String str = "";
		str += this.getClass() + " : ";
		buf.append(str);
		List<Field> list = new ArrayList<Field>();
		this.fielsColection( list);
		for(Field field : list)
		{
			field.setAccessible(true);
			Object value=null;
			String fieldInfoDesc=null;
			buf.append("FieldType:("+field.getType().getSimpleName()+") ");
			if(field.getType()==this.getClass())
			{
				buf.append("  value=continue");
				continue;
			}
			if(field.isAnnotationPresent(FieldInfo.class))
			{
				FieldInfo fieldInfo=field.getAnnotation(FieldInfo.class);
				fieldInfoDesc= fieldInfo.name();
			}
			try {
				value=field.get(this);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			buf.append(field.getName()+"[ "+fieldInfoDesc+"]" + "=" + value+" " );
		}
		return buf.toString();
	}
}
