package com.service.impl;

import java.sql.Connection;
import java.util.List;

import com.dao.BuildingDAO;
import com.dao.impl.BuildingDAOImpl;
import com.entity.Building;
import com.service.BuildingService;
import com.util.JDBCUtil;
import com.util.TransactionManager;

public class BuildingServiceImpl implements BuildingService {

	private BuildingDAO buildingDAO = new BuildingDAOImpl();
	@Override
	public List<Building> findMesg(Building building) {
	
		try{
			TransactionManager.begin();
			List<Building> buildings = buildingDAO.queryAll();
			TransactionManager.commit();
			return buildings;	
		}catch(Exception e){
			e.printStackTrace();
			TransactionManager.rollback();
		}
		return null;
	}

}
