package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.BuildingDAO;
import com.entity.Building;
import com.util.JDBCUtil;

public class BuildingDAOImpl implements BuildingDAO {

	@Override
	public List<Building> queryAll() {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Building> buildings = new ArrayList<Building>();
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select * from building";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next())
			{
				Building building = new Building();
				building.setId(rs.getInt(1));
				building.setName(rs.getString(2));
				building.setPoint(rs.getString(3));
				building.setMessage(rs.getString(4));
				building.setImgUrl(rs.getString(5));
				building.setLetter(rs.getString(6));
				
				buildings.add(building);
				
			}
			return buildings;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally{
			JDBCUtil.close(rs, ps, null);
		}

	}

}
