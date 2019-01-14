package com.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.dao.ReadDataDAO;
import com.dao.impl.ReadDataDAOImpl;
import com.service.KruskalService;
import com.util.CaculateUtil;

public class KruskalServiceImpl implements KruskalService {

	@Override
	public Object[] getKruskalResult() {
		long starTime=System.currentTimeMillis();
		//调用ReadDataDAOImpl读取文本中的矩阵数据
		ReadDataDAO reader = new ReadDataDAOImpl();
		Object[] readerData = reader.getData();
		
		//用hashMap 和 Set集合 分别存放  矩阵数据 和 矩阵中的结点
		//haspMap 存放的格式为  key---value  对应   路径---权值
		Map<String,Integer> hashMap = (Map<String,Integer>)readerData[0];
		Set Allnode = (HashSet)readerData[1];
		
		Object[] finalrResult= new Object[2];
		String[] result = new String[Allnode.size()-1];
		
		int[] parent = new int[Allnode.size()];
		//顶点的编号为0-6
		for(int i =0;i<parent.length;i++){
			parent[i] = -1;
		}
		//获取排序后的权值集合
		ArrayList<Integer> lowerWeight = CaculateUtil.getLowerWeight(hashMap);
		Set startSet = new HashSet();
		Set tempSet = new HashSet();
		ArrayList nodes = new ArrayList();
		ArrayList finalWays = new ArrayList();
		for(Object s:Allnode)
		{
			nodes.add((String)s);
		}
		for(int i=0;i<lowerWeight.size();i++)
		{
			//通过权值value来获取反向获取key
			ArrayList<String> fromValueGetKey = CaculateUtil.FromValueGetKey(hashMap, lowerWeight.get(i));
			
			//将结点字符转化为对应的数字 , 例如 A 转换为 1 , B 转化为 2
			String startNode = fromValueGetKey.get(0).charAt(0)+"";
			int startNum = CaculateUtil.getNumberFromSet(startNode,nodes);
			String endNode = fromValueGetKey.get(0).charAt(1)+"";
			int endNum = CaculateUtil.getNumberFromSet(endNode,nodes);
			
			//并查集判断是否构成环
			int rootOfBegin = CaculateUtil.find(startNum, parent);			
			int rootOfend = CaculateUtil.find(endNum, parent);
			//如果查询到的两结点双亲不同
			if(rootOfBegin!=rootOfend){	
			
				parent[rootOfBegin] = rootOfend;
				
				finalWays.add(startNode+"---"+endNode+"---"+lowerWeight.get(i));
			
			}		
			
		}	
		for(int j=0;j<result.length;j++)
		{
			result[j] = (String)finalWays.get(j);
		}
		finalrResult[0] = result;
		long endTime=System.currentTimeMillis();
		long Time=endTime-starTime;
		finalrResult[1] = Time;
		System.out.println("Kruskal算法(hashMap)的执行时间为 :"+Time+"ms");
		return finalrResult;
	}

}
