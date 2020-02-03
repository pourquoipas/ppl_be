package org.gnius.hr.enterprise.filters;

import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.Provider;

import org.jboss.resteasy.plugins.interceptors.CorsFilter;

@Provider
public class CorsProvider implements Feature {
	@Override
    public boolean configure(FeatureContext context) {
        CorsFilter filter = new CorsFilter();
        filter.getAllowedOrigins().add("*");
        filter.setAllowedMethods("GET, POST, OPTIONS, HEAD, PUT, DELETE");
        filter.setAllowedHeaders("accept, content-type, origin");
        context.register(filter);
        return true;
    }
}
