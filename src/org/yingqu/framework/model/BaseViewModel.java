package org.yingqu.framework.model;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 视图实体
* @author 作者 yingqu: 
* @version 创建时间：2014年6月15日 下午11:05:35 
* version 1.0
 */
public  interface BaseViewModel extends Model {
	public Integer getId();
	
	default public Map<String, Object> getParamsValues(List<String> params) {
		List<Field> list = new ArrayList<Field>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		this.fielsColection(this.getClass(), list);
		if (list.size() > 0) {
			list = list.parallelStream().filter(field -> {
				field.setAccessible(true);
				List<String> lp = params.parallelStream().filter(param -> {
					Objects.requireNonNull(param);
					return param.equals(field.getName());
				}).collect(Collectors.toList());
				return lp.size() == 1 ? true : false;
			}).collect(Collectors.toList());
		}
		list.forEach(item -> {
			item.setAccessible(true);
			try {
				Object value = item.get(this);
				Objects.requireNonNull(value);
				paramMap.put(item.getName(), value);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		return paramMap;
	}
}
