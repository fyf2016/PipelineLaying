package com.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.dao.ReadDataDAO;
import com.dao.impl.ReadDataDAOImpl;
import com.service.PrimeService;
import com.util.CaculateUtil;
/**
 * 用于获取Prime算法得出的结果
 *
 */
public class PrimeServiceImpl implements PrimeService {

	@Override
	public Object[] getPrimeResult() {
		long starTime=System.currentTimeMillis();
		//调用ReadDataDAOImpl读取文本中的矩阵数据
		ReadDataDAO reader = new ReadDataDAOImpl();
		Object[] readerData = reader.getData();
		
		//用hashMap 和 Set集合 分别存放  矩阵数据 和 矩阵中的结点
		//haspMap 存放的格式为  key---value  对应   路径---权值
		Map<String,Integer> hashMap = (Map<String,Integer>)readerData[0];
		Set Allnode = (HashSet)readerData[1];
		
		//node--集合   作用: 每次添加一个结点到其中并与Allnode比较
		Set node = new HashSet();
		//Weight  作用: 存放每条边的权值 
		ArrayList<Integer> Weight = new ArrayList();
		//nextNodes  作用: 辅助集合, 用于 筛选最小权值的边
		ArrayList<String> nextNodes = new ArrayList();

		// 定义存放返回结果的变量
		int index = 0;
		Object[] finalPlans = new Object[3];
		String finalNode = "";
		String[] ways = new String[Allnode.size()-1];
		
		//获取随机结点
		String RandomNode = CaculateUtil.getRandomValueFromSet(Allnode);
		//将随机结点添加到node集合
		node.add(RandomNode);
		nextNodes.add(RandomNode);
		//将随机结点添加到返回值数组中
		finalPlans[0] = RandomNode;
		//while--- 直到所有的顶点都进入了生成树
		while(node!=Allnode)
		{
			//第一次循环RandomNode为外部传入的随机结点, 之后RandomNode被赋值为算法得出的下一个结点
			String finalOrder = CaculateUtil.getFinalOrder(hashMap, node, nextNodes,RandomNode);
			if(finalOrder.length()>0)
			{
				RandomNode = finalOrder.split("---")[2];
				if(index<=(Allnode.size()-1))
				{
					ways[index] = finalOrder.split("---")[0]+"---"+finalOrder.split("---")[1];
					index++;
				}
				
				node.add(RandomNode);
				nextNodes.add(RandomNode);
				
			}else{
				break;
			}		
			
		}
		finalPlans[1] = ways;
		long endTime=System.currentTimeMillis();
		long Time=endTime-starTime;
		finalPlans[2] = Time;
		System.out.println("Prime算法(hashMap)的执行时间为 :"+Time+"ms");
		return finalPlans;
	}

}
