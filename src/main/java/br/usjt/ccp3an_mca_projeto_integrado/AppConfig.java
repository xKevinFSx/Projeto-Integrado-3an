package br.usjt.ccp3an_mca_projeto_integrado;

import br.usjt.ccp3an_mca_projeto_integrado.controller.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class AppConfig implements WebMvcConfigurer {
	
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(
                new LoginInterceptor()).
                addPathPatterns("/**").
                excludePathPatterns("/login", "/fazerLogin", "/css/**");
    }
    
    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
    		"classpath:/META-INF/resources/", "classpath:/resources/",
    		"classpath:/static/", "classpath:/public/", "classpath:/static/fileServer" };
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	if (!registry.hasMappingForPattern("/webjars/**")) {
    		registry.addResourceHandler("/webjars/**").addResourceLocations(
    				"classpath:/META-INF/resources/webjars/");
    	}
    	if (!registry.hasMappingForPattern("/**")) {
    		registry.addResourceHandler("/**").addResourceLocations(
    				CLASSPATH_RESOURCE_LOCATIONS);
    	}
    }

}
