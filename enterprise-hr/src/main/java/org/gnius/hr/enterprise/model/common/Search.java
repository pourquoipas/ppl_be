package org.gnius.hr.enterprise.model.common;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class Search<T extends BaseEntity> {
	public T eq;
	public T like;
	public T ge;
	public T le;
	
	public String order;
	
	public Page page;

}
