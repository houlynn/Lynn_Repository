package org.yingqu.framework.model.vo;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.yingqu.framework.model.BaseEntity;

public abstract class  PModel {
	
	@JsonIgnore
	private Class<? extends BaseEntity> clazz;

	public Class<? extends BaseEntity> getClazz() {
		return clazz;
	}

	public void setClazz(Class<? extends BaseEntity> clazz) {
		this.clazz = clazz;
	}

	
}
