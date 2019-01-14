package com.view;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.OutputDataDAO;
import com.dao.impl.OutputDataDAOImpl;
import com.service.KruskalService;
import com.service.PrimeService;
import com.service.impl.KruskalServiceImpl;
import com.service.impl.PrimeServiceImpl;

public class ShowMapServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		String flag = request.getParameter("flag");
	
		if("Prime".equals(flag))
		{
			Object[] primeResult = (Object[])session.getAttribute("Prime");
			String RandomNode = (String)primeResult[0];
			String[] finalWays = (String[])primeResult[1];
			String[] routes = new String[finalWays.length*2];
			ArrayList table = new ArrayList();
			
			for(int i=0;i<finalWays.length;i++)
			{
					if(finalWays[i]!=null)
					{
						table.add(finalWays[i].split("---")[0].charAt(0)+"");
						table.add(finalWays[i].split("---")[0].charAt(1)+"");
					}
					
			}
			
			for(int j=0;j<table.size();j++)
			{
				routes[j] = (String)table.get(j);
			}
	
			session.setAttribute("route",routes);
			
			
		}
		if("Kruskal".equals(flag))
		{	
			Object[] objResult = (Object[])session.getAttribute("Kruskal");
			//String[] KruskalResult = (String[])session.getAttribute("Kruskal");
			String[] KruskalResult = (String[])objResult[0];
			String[] routes = new String[KruskalResult.length*2];
			ArrayList table = new ArrayList();
			
			for(int i=0;i<KruskalResult.length;i++)
			{
					if(KruskalResult[i]!=null)
					{
						table.add(KruskalResult[i].split("---")[0]);
						table.add(KruskalResult[i].split("---")[1]);
					}
					
			}
			
			for(int j=0;j<table.size();j++)
			{
				routes[j] = (String)table.get(j);
			}
			
			session.setAttribute("route",routes);
		}
		response.sendRedirect("/PipelineLaying/map.jsp");
	}

	
}
