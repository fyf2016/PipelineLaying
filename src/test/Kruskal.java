package test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Kruskal {
	public static void main(String[] args){
		long starTime=System.currentTimeMillis();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("D:\\ReadDatas.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String,Integer> hashMap = new HashMap<>();
		Set Allnode = new HashSet();
		int sumWeights = 0;
		//1. 构造节点集合 node
		while (true)  
		{
			String s;
			try {
				s = br.readLine();
				if(s== null) break;
				else{
					String[] data = s.split(" ");
					hashMap.put(data[0], Integer.parseInt(data[1]));
					Allnode.add(data[0].charAt(0)+"");
					Allnode.add(data[0].charAt(1)+"");
					//System.out.println(s);Integer.parseInt(data[1]);
				} 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		//ArrayList parent = new ArrayList();
		int[] parent = new int[Allnode.size()];
//		//顶点的编号为0-6
		for(int i =0;i<parent.length;i++){
			parent[i] = -1;
		}
		ArrayList<Integer> lowerWeight = util.getLowerWeight(hashMap);
		Set startSet = new HashSet();
		Set tempSet = new HashSet();
		ArrayList nodes = new ArrayList();
		for(Object s:Allnode)
		{
			nodes.add((String)s);
		}
		for(int i=0;i<lowerWeight.size();i++)
		{
			
			ArrayList<String> fromValueGetKey = util.FromValueGetKey(hashMap, lowerWeight.get(i));
			String startNode = fromValueGetKey.get(0).charAt(0)+"";
			int startNum = util.getNumberFromSet(startNode,nodes);
			
			String endNode = fromValueGetKey.get(0).charAt(1)+"";
			int endNum = util.getNumberFromSet(endNode,nodes);
			int rootOfBegin = util.find(startNum, parent);			
			int rootOfend = util.find(endNum, parent);
			
			if(rootOfBegin!=rootOfend){	
			
				parent[rootOfBegin] = rootOfend;
				sumWeights += lowerWeight.get(i);
				System.out.println(startNode+"----"+endNode+"---"+lowerWeight.get(i));
			}		
			
		}
		System.out.println("总米数为:"+sumWeights);
		long endTime=System.currentTimeMillis();
		long Time=endTime-starTime;
		System.out.println("Kruskal算法(hashMap)的执行时间为 :"+Time+"ms");
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	}
}
