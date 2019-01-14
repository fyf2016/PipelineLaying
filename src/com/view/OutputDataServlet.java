package com.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.OutputDataDAO;
import com.dao.impl.OutputDataDAOImpl;
import com.service.KruskalService;
import com.service.PrimeService;


public class OutputDataServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String flag = request.getParameter("flag");
	
		OutputDataDAO outData = new OutputDataDAOImpl();
		if("Prime".equals(flag))
		{
			
			
			HttpSession session4 = request.getSession();
			Object[] primeResult = (Object[])session4.getAttribute("Prime");
			String[] finalWays = (String[])primeResult[1];
			outData.exportData(finalWays);
			response.sendRedirect("/PipelineLaying/PrimePage.jsp");
		}
		if("Kruskal".equals(flag))
		{
			
			
			HttpSession session4 = request.getSession();
			
			Object[] objResult = (Object[])session4.getAttribute("Kruskal");
		
			String[] KruskalResult = (String[])objResult[0];
			
			outData.exportData(KruskalResult);
			response.sendRedirect("/PipelineLaying/KruskalPage.jsp");
		}
		
	}

	

}
