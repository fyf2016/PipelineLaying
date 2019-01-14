package com.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class CaculateUtil {
	// 为Prime算法生成随机结点
	public static String getRandomValueFromSet(Set set) {
		Random rand =new Random();
		int random = rand.nextInt(set.size());
        //System.out.println("Random为:"+random);
        int i = 0;
        //Iterator number = set.iterator();
        for (Object value: set) {
 
    		if(i==random){
                return (String)value;
            }
            i++;
        	    
        }
        return null;
    }
	
	
	// 从哈希表中通过值反向获取key
	public static ArrayList<String> FromValueGetKey(Map map,Integer value) 
	{		
		Set set = map.entrySet();		
		ArrayList<String> arr = new ArrayList<String>();		
		Iterator it = set.iterator();
		while (it.hasNext()) 
		{			
			Map.Entry entry = (Map.Entry) it.next();
			if ((int)entry.getValue()==value) 
			{
				String s = (String) entry.getKey();				
				arr.add(s);			
						
			}		
			
		}
		return arr;	
	}
	
	// Prime算法 获取下一条路径  格式: 路径名---权值---下个结点
	public static String getFinalOrder(Map<String,Integer> hashmap,Set node,ArrayList<String> nextNodes,String RandomNode)
	{
		List<Integer> Weights = new ArrayList<Integer>();
		Set ks =  hashmap.keySet();
		Iterator it = ks.iterator();
		String rs = "";
		String beginNode = "";
		while(it.hasNext())
		{
			String k = (String)it.next();
			for(int i=0;i<nextNodes.size();i++)
			{
				if(k.indexOf(nextNodes.get(i))!=-1)
				{
					//获取另一个结点, 例如 已有A结点从"AB"中获取 "B"结点
					String AnotherNode = k.charAt(1-k.indexOf(nextNodes.get(i)))+"";
					//如果当前边的 一个端点在生成树里，另一个端点不在生成树里
					if(node.contains(nextNodes.get(i)) && !node.contains(AnotherNode))
					{
						int v = (int)hashmap.get(k);
						Weights.add(v);
					}
				}
			}
			
		}
		//定义排序规则
		Comparator c = new Comparator<Integer>(){
			public int compare(Integer o1, Integer o2) {				
				if((int)o1>(int)o2)		
					return 1;						
				else 
					return -1;			
			}
		};
		//对权值数组从小到大排序
		Weights.sort(c);
		
		//编辑返回值内容和格式
		if(Weights.size()!=0)
		{
			ArrayList<String> Combine = CaculateUtil.FromValueGetKey(hashmap,  Weights.get(0));
			for(String s:nextNodes)
			{
				if(Combine.get(0).indexOf(s)!=-1)
				{
					beginNode = Combine.get(0).charAt(1-Combine.get(0).indexOf(s))+"";
				}
			}
			
			rs = Combine.get(0)+"---"+Weights.get(0)+"---"+beginNode;
		}
		
		
		return rs;
		
	}
	//kruskal算法所用:
	public static ArrayList<Integer> getLowerWeight(Map<String,Integer> hashMap)
	{
		ArrayList<Integer> Weight = new ArrayList();
		Set ks = hashMap.keySet();
		Iterator it = ks.iterator();
		while(it.hasNext())
		{
			String k = (String)it.next();
			int v = (int)hashMap.get(k);
			Weight.add(v);
		}
		Comparator c = new Comparator<Integer>(){
			public int compare(Integer o1, Integer o2) {				
				if((int)o1>(int)o2)		
					return 1;						
				else 
					return -1;			
			}
		};
		Weight.sort(c);
		return Weight;
		
	}
	//查并集的查找, 查找双亲结点
	public static int find(int index,int[] parent){
		while(parent[index] > 0  ){
			index = parent[index];
		}
		return index;
	}
	
	public static int getNumberFromSet(String s,ArrayList<String> nodes)
	{

		if(nodes.indexOf(s)!=-1)
		{
			return nodes.indexOf(s);
		}
		return 999;
		
	}

	
}
