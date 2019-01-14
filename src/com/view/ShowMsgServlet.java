package com.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.Building;
import com.service.BuildingService;
import com.service.impl.BuildingServiceImpl;

public class ShowMsgServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BuildingService buildingService = new BuildingServiceImpl();
		Building building = new Building();
		List<Building> buildingMsg = buildingService.findMesg(building);
		HttpSession session = request.getSession();
		session.setAttribute("message",buildingMsg);
		response.sendRedirect("/PipelineLaying/showScenery.jsp");

	}

	

}
