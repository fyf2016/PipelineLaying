package com.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.PrimeService;
import com.service.impl.PrimeServiceImpl;

public class ShowPrimeServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		PrimeService ps = new PrimeServiceImpl();
		Object[] primeResult = ps.getPrimeResult();
		HttpSession session = request.getSession();
		session.setAttribute("Prime",primeResult);
	
		response.sendRedirect("/PipelineLaying/PrimePage.jsp");
		

	}

	
}
