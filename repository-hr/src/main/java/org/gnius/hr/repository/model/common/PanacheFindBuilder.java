package org.gnius.hr.repository.model.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.gnius.hr.util.StringUtils;

public class PanacheFindBuilder {
	
	private List<String> and;
	private Map<String, Object> params;

	public PanacheFindBuilder() {
		and = new ArrayList<String>();
		params = new HashMap<String, Object>();
	}
	
	public PanacheFindBuilder addConst(String queryPart) {
		and.add(queryPart);
		return this;
	}
	
	public PanacheFindBuilder add(String queryPart, String paramName, Object value) {
		if (value != null) {
			and.add(queryPart);
			params.put(paramName, value);
		}
		return this;
	}
	
	public String getQuery() {
		StringBuilder rv = new StringBuilder();
		String cong = "";
		for (String s : and) {	
			rv.append(cong).append(s); 
			cong = " and ";
		}
		return rv.toString();
	}
	public Map<String, Object> getParams() {
		return params;
	}
	
	
	public PanacheFindBuilder addEq(String field, Object value, boolean requireNull) {
		return add(field, " = ", field + "_eq", value, requireNull);
	}
	public PanacheFindBuilder addLike(String field, String value, boolean requireNull) {
		return add(field, " LIKE ", field + "_like", StringUtils.sqlLikeParam(value), requireNull);
	}
	public PanacheFindBuilder addGe(String field, Object value, boolean requireNull) {
		return add(field, " >= ", field + "_ge", value, requireNull);
	}
	public PanacheFindBuilder addLe(String field, Object value, boolean requireNull) {
		return add(field, " <= ", field + "_le", value, requireNull);
	}
	
	private PanacheFindBuilder add(String field, String operator, String paramName, Object value, boolean requireNull) {
		if (value != null) {
			return add(field + operator + ":" + paramName, paramName, value);
		} else if (requireNull) {
			and.add(field + " IS NULL ");
		}
		return this;
	}
}
