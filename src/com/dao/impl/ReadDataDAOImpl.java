package com.dao.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.dao.ReadDataDAO;

public class ReadDataDAOImpl implements ReadDataDAO {

	@Override
	public Object[] getData() {
		BufferedReader br = null;
		try {
			//ReadDatas -- 完整结点   ReadDatas2--去掉L结点    ReadDatas3 -- 去掉H结点
			br = new BufferedReader(new FileReader("D:\\ReadDatas3.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String,Integer> hashMap = new HashMap<>();
		Set Allnode = new HashSet();
		Object[] objs = new Object[2];
		
		while (true)  
		{
			String s;
			try {
				s = br.readLine();
				if(s== null) break;
				else{
					String[] data = s.split(" ");
					Allnode.add(data[0].charAt(0)+"");
					Allnode.add(data[0].charAt(1)+"");
					hashMap.put(data[0], Integer.parseInt(data[1]));
					objs[0] = hashMap;
					objs[1] = Allnode;
				} 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objs;
	}

}
