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

public class Prime {

	public static void main(String[] args) {
		long starTime=System.currentTimeMillis();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("D:\\ReadDatas.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String,Integer> hashMap = new HashMap<>();
		//1. 构造节点集合 node
		Set Allnode = new HashSet();
		Set node = new HashSet();
		ArrayList<Integer> Weight = new ArrayList();
		ArrayList<String> nextNodes = new ArrayList();
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
					//System.out.println(s);Integer.parseInt(data[1])
					
				} 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		//System.out.println(Allnode.size());
		String RandomNode = util.getRandomValueFromSet(Allnode);
		System.out.println("RandomNode为:"+RandomNode);
		node.add(RandomNode);
		nextNodes.add(RandomNode);
		String finalNode = "";
		int sum=0;
		while(node!=Allnode)
		{
			String finalOrder = util.getFinalOrder(hashMap, node, nextNodes,RandomNode);

			//System.out.println(finalOrder.length());
			if(finalOrder.length()>0)
			{
				RandomNode = finalOrder.split("---")[2];
				sum+=Integer.valueOf(finalOrder.split("---")[1]);
				System.out.println(finalOrder);
				node.add(RandomNode);
				nextNodes.add(RandomNode);
			}else{
				break;
			}
			
			
		}
		System.out.println("sum为:"+sum);
		long endTime=System.currentTimeMillis();
		long Time=endTime-starTime;
		System.out.println("Prime算法(hashMap)的执行时间为 :"+Time+"ms");
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
			
	}

}
