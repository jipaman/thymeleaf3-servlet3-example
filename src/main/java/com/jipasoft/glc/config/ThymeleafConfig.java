package com.jipasoft.glc.config;

import static com.jipasoft.glc.config.TemplateEngineUtil.storeTemplateEngine;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

@WebListener
public class ThymeleafConfig implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		TemplateEngine engine = templateEngine(sce.getServletContext());
		storeTemplateEngine(sce.getServletContext(), engine);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}

	private TemplateEngine templateEngine(ServletContext servletContext) {
		TemplateEngine engine = new TemplateEngine();
		engine.setTemplateResolver(templateResolver(servletContext));
		return engine;
	}

	private ITemplateResolver templateResolver(ServletContext servletContext) {
		ServletContextTemplateResolver resolver = new ServletContextTemplateResolver(servletContext);
		resolver.setPrefix("/WEB-INF/templates/");
		resolver.setTemplateMode(TemplateMode.HTML);
		return resolver;
	}
}
