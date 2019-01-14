<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="com.entity.Building" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<title>算法三级项目</title>  

	<script type="text/javascript" src="http://api.map.baidu.com/library/DistanceTool/1.2/src/DistanceTool_min.js">
	</script>
	<style type="text/css">  
		html{height:100%}  
		body{height:100%;margin:0px;padding:0px}  
		#container{height:100%}  
	</style>  
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=QWWNs21QZuW4DRQ6CG5u5ZSChVVH2gjQ">
	//v2.0版本的引用方式：src="http://api.map.baidu.com/api?v=2.0&ak=您的密钥"
	</script>
  </head>
  
  <body>  
		
		<div id="container"></div>
		<%
			HttpSession session2 = request.getSession();
			String[] route = (String[])session2.getAttribute("route");
		 %>
		
		</div>
 </body>
<script type="text/javascript"> 
	// 创建地图实例  
	var showLines = document.getElementById("container");
	var map = new BMap.Map("container");
	// 创建点坐标 
	var point = new BMap.Point(119.544183,39.907721);
	// 初始化地图，设置中心点坐标和地图级别 
	map.centerAndZoom(point, 18);
	 
	map.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放
	map.addControl(new BMap.NavigationControl());    
	map.addControl(new BMap.ScaleControl());    
	map.addControl(new BMap.OverviewMapControl());    
	map.addControl(new BMap.MapTypeControl());    
	map.setCurrentCity("秦皇岛"); // 仅当设置城市信息时，MapTypeControl的切换功能才能可用   
	var myDis = new BMapLib.DistanceTool(map);
	var flag = true;

	var lastRoute = [];
	var charNode = [];
	
	<%
        HttpSession session3 = request.getSession();
		ArrayList<Building> MsgList = (ArrayList<Building>)session3.getAttribute("message");
	%>
	           
   <%for(Building o:MsgList) {%>
   	  
   	  
  	//console.log("<%=o.getLetter()%>"+"<%=o.getPoint()%>"); 
   	var point<%=o.getLetter()%> = new BMap.Point(<%=o.getPoint()%>);
   	
   	
   	var marker<%=o.getLetter()%> = new BMap.Marker(point<%=o.getLetter()%>);  // 创建标注
	map.addOverlay(marker<%=o.getLetter()%>);               // 将标注添加到地图中
	marker<%=o.getLetter()%>.setAnimation(BMAP_ANIMATION_BOUNCE); //跳动的动画
	var label<%=o.getLetter()%> = new BMap.Label("<%=o.getName()%>",{offset:new BMap.Size(20,-10)});
	marker<%=o.getLetter()%>.setLabel(label<%=o.getLetter()%>);
   	
   <%} %>
				
	
	<% for(int i=0;i<route.length;i++){%>
		charNode.push(point<%=route[i]%>);
		//console.log("结点 :"+"<%=route[i]%>");
	<%}%>
	var  m = 0;
	function change()
	{
		var line = new Array(2);
		line[0] = charNode[m];
		line[1] = charNode[m+1];
		var polyline = new BMap.Polyline(line,
		 {strokeColor:"blue", strokeWeight:6, strokeOpacity:0.5});  //定义折线
		map.addOverlay(polyline);     //添加折线到地图上
		m+=2;
	}
	
	showLines.addEventListener('click', change);
	
</script>  
  
</html>