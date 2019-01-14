package test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class util {
	public static String getRandomValueFromSet(Set set) {
		Random rand =new Random();
		int random = rand.nextInt(set.size());
        System.out.println("Random为:"+random);
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
	
	public static String getFinalOrder(Map<String,Integer> hashmap,Set node,ArrayList<String> preNode,String RandomNode)
	{
		List<Integer> Weights = new ArrayList<Integer>();
		//Map<String,Integer> LastOrderEdge = new HashMap<>();
		Set ks =  hashmap.keySet();
		Iterator it = ks.iterator();
		String rs = "";
		String beginNode = "";
		String nextNode ="";
		while(it.hasNext())
		{
			String k = (String)it.next();
			for(int i=0;i<preNode.size();i++)
			{
				if(k.indexOf(preNode.get(i))!=-1)
				{
					String AnotherNode = k.charAt(1-k.indexOf(preNode.get(i)))+"";
					
					if(node.contains(preNode.get(i)) && !node.contains(AnotherNode))
					{
						int v = (int)hashmap.get(k);
						Weights.add(v);
					}
				}
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
		//System.out.println(Weights.size());
		if(Weights.size()!=0)
		{
			ArrayList<String> Combine = util.FromValueGetKey(hashmap,  Weights.get(0));
			for(String s:preNode)
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
	
//	public static List<Integer> getOrderWeight(Map<String,Integer> hashmap,Set node,String RandomNode)
//	{
//		List<Integer> Weights = new ArrayList<Integer>();
//		//Map<String,Integer> LastOrderEdge = new HashMap<>();
//		Set ks =  hashmap.keySet();
//		Iterator it = ks.iterator();
//		String rs = "";
//		String beginNode = "";
//		while(it.hasNext())
//		{
//			String k = (String)it.next();
//			if(k.indexOf(RandomNode)!=-1)
//			{
//				String AnotherNode = k.charAt(1-k.indexOf(RandomNode))+"";
//				if(node.contains(RandomNode) && !node.contains(AnotherNode))
//				{
//					int v = (int)hashmap.get(k);
//					Weights.add(v);
//				}
//			}
//		}
//		Comparator c = new Comparator<Integer>(){
//			public int compare(Integer o1, Integer o2) {				
//				if((int)o1>(int)o2)		
//					return 1;						
//				else 
//					return -1;			
//			}
//		};
//		Weights.sort(c);
//		
//		return Weights;	
//	}
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
