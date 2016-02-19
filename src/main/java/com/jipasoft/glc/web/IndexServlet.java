package com.jipasoft.glc.web;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import com.jipasoft.glc.config.TemplateEngineUtil;

@WebServlet("/")
public class IndexServlet extends HttpServlet {

	/**
	 *
	 */
	private static final long serialVersionUID = 8246035742563751896L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(request.getServletContext());
		WebContext context = new WebContext(request, response, request.getServletContext());
		context.setVariable("recipient", "World!");
		engine.process("index.html", context, response.getWriter());
	}
}
