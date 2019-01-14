<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管线铺设辅助系统</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel=stylesheet href="css/style.css">
	<style type="text/css">
		#nav_box{
			font-family:"微软雅黑";
		}
	</style>
  </head>
  
  <body>
   <div class=wrap id=wrap>
		<div class=wrapper>
			<div class=header>
				<div class="head clearfix">
					<div class=logo_box>
						
					</div>
					<div class=nav_box id=nav_box>
						<ul>
							<li>
								<a href='/PipelineLaying/' clickid=guanwang_navigation_homepage>主页</a>
							<li>
								<a href='/PipelineLaying/ShowMsgServlet' target=_blank clickid=guanwang_navigation_productcenter>铺设途经建筑</a>
							<li>
								<a href='/PipelineLaying/ShowPrimeServlet' target=_blank clickid=guanwang_navigation_customer>Prime 算法</a>
							<li>
							<a href='/PipelineLaying/ShowKruskalServlet' target=_blank clickid=guanwang_navigation_yangtai>Kruskal 算法</a>
						</ul>
						<span class=ic_line></span></div>
				</div>
			</div>
			<div class=page_wp id=page_wp>
				<div class="page page_1"><span class="page_bg scale_box"></span>
					<div class=img_box><img src="" alt=""></div>
					<div class="txt_box scale_box">
						<h2>管线铺设辅助系统</h2>
						<p class=txt_brief>从现在开始，你就会感觉到它与以往是如此不同。先进的而又强大的算法，精彩的周边场景信息展示，最优的铺设方案，这一切，都让铺设更加方便。</div>
				</div>
				<div class="page page_2"><span class="page_bg scale_box"></span>
					<div class=img_box><img src="" alt=""></div>
					<div class="txt_box scale_box">
						<h2>强大的算法可以带你穿越时空</h2>
						<p class=txt_brief>我们对效率的渴望从未停止，一起来寻找最优的方案。铺设系统采用的算法强大，占用更少的资源提供更高的效率支持，这一切只源于我们对技术的无尽追求。</div>
				</div>
				<div class="page page_3"><span class="page_bg scale_box"></span>
					<div class=img_box><img src="" alt=""></div>
					<div class="txt_box scale_box">
						<h2>与你一起探索最优的铺设方案</h2>
						<p class=txt_brief>本系统以生动的方式呈现更多内容，让你在体验极速的同时，拥有更多选择。我们呈现铺设途径中更多的信息,给你更多的启迪和考虑。</div>
				</div>
				<div class="page page_4"><span class="page_bg scale_box"></span>
					<div class=img_box><img src="" alt=""></div>
					<div class="light_wp scale_box"><span class=light_box><i class=light_1></i> <i class=light_2></i> <i class=light_3></i> <i class=light_4></i> <i class=light_5></i></span></div><span class="meteor_box scale_box"></span>
					<div class="txt_box scale_box">
						<h2>详细精准的方案等待你去发现</h2>
						<p class=txt_brief>当你使用本系统时，也许另一个人也和你一样，在寻找最优的铺设方案。这些只是开始，使用越久，越能发现我们的创新和诚心。</div>
				</div>
			</div>
			<div class="star_wp scale_box" id=star_wp><span class=star_bg></span> <span class=star_box></span></div><canvas id=canvas></canvas>
			<div class="btns_wp scale_box">
				<a class="btn_download JS-btn-download" href="/PipelineLaying/">立即体验</a>
			</div>
			<div class=btn_control id=btn_control>
				<a href=javascript:; class=cur></a>
				<a href=javascript:;></a>
				<a href=javascript:;></a>
				<a href=javascript:;></a>
			</div>
			<div class=footer>
				<div class=foot>
					<p>计算机一班算法小组</p>
				</div>
			</div>
		</div>
	</div>
	<script src="./js/vendors.js"></script>
	<script src="./js/index.js"></script>
  </body>
</html>
