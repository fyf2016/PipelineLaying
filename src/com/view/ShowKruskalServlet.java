package com.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.KruskalService;
import com.service.impl.KruskalServiceImpl;

public class ShowKruskalServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		KruskalService ks = new KruskalServiceImpl();
		Object[] kruskalResult = ks.getKruskalResult();

		HttpSession session = request.getSession();
		session.setAttribute("Kruskal",kruskalResult);
	
		response.sendRedirect("/PipelineLaying/KruskalPage.jsp");
		

	}

	
}
