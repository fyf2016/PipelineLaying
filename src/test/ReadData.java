package test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ReadData {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new FileReader("D:\\ReadDatas.txt"));
		Map<String,Integer> hashmap = new HashMap<>();
		//1. 构造节点集合 node
		Set node = new HashSet();
		while (true) 
		{
			String s = br.readLine();
			if(s== null) break;
			else{
				String[] data = s.split(" ");
				node.add(data[0].charAt(0)+"");
				node.add(data[0].charAt(1)+"");
				hashmap.put(data[0], Integer.parseInt(data[1]));
				//System.out.println(s);Integer.parseInt(data[1])
			} 
			
		}
		
	    // Prim算法:
		String RandomNode = util.getRandomValueFromSet(node);
		
		
		System.out.println(RandomNode);
		
		Set CombineEdge =  hashmap.keySet();
		Map<String,Integer> LastOrderEdge = new HashMap<>();
		List<Integer> Weights = new ArrayList<Integer>();
		Iterator it1 = CombineEdge.iterator();
		String beginNode = "";
		while(it1.hasNext())
		{
			String key = (String)it1.next();
			if(key.indexOf(RandomNode)!=-1)
			{
				int value = hashmap.get(key);
				Weights.add(value);
			}
		}
		
		Comparator c = new Comparator<Integer>(){
			public int compare(Integer o1, Integer o2) {				
				if((int)o1>(int)o2)		
					return 1;						
				else 
					return -1;			
			}
		};
		Weights.sort(c);
		ArrayList<String> Combine = util.FromValueGetKey(hashmap,  Weights.get(0));
		beginNode = Combine.get(0).charAt(1-Combine.get(0).indexOf(RandomNode))+"";
		LastOrderEdge.put(Combine.get(0), Weights.get(0));
		
		
		Set ks = LastOrderEdge.keySet();
		Iterator it = ks.iterator();
		while(it.hasNext())
		{
			Object k = it.next();
			//System.out.println(LastOrderEdge.containsKey(k));
			Object v = LastOrderEdge.get(k);
		//	System.out.println(k+"---"+v);
		}
		System.out.println("beginNode为"+beginNode);
//		String finalOrder = util.getFinalOrder(hashmap, RandomNode);
//		System.out.println(finalOrder.split("---")[2]);
//		node.remove(RandomNode);
//		
		
		while(!node.isEmpty())
		{
			String finalOrder = util.getFinalOrder(hashmap,node, Combine, RandomNode);
			hashmap.remove(finalOrder.split("---")[0]);
			node.remove(RandomNode);
			beginNode = finalOrder.split("---")[2];
			RandomNode = beginNode;
			System.out.println(finalOrder);
		}
		//hashmap.remove("AB");
//		Set ks2 = hashmap.keySet();
//		Iterator it2 = ks2.iterator();
//		while(it2.hasNext())
//		{
//			Object k = it2.next();
//			System.out.println(hashmap.containsKey("AB"));
//			Object v = hashmap.get(k);
//			System.out.println(k+"---"+v);
//		}
//		Iterator nodes = node.iterator();
//		while(nodes.hasNext())
//		{
//			System.out.println(nodes.next());
//		}
				
	}

}
