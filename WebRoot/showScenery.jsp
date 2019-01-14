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
    
    <title>节点信息展示</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="css/htmleaf-demo.css">
	<style type="text/css">
		.demo{min-height: 600px;margin-top: 30px;}
		.box-bg{
		    overflow: hidden;
		}
		.box{
		    position:relative;
		    margin-top:50px;
		}
		.box .pic{
		    position: relative;
		    z-index: 1;
		    transform-origin: 95% 50% 0;
		    transition: all 0.5s ease 0s;
		}
		.box .pic:after{
		    content: "";
		    position: absolute;
		    top: 50%;
		    left:95%;
		    width: 8px;
		    height: 8px;
		    border-radius: 50%;
		    background: rgba(0, 0, 0, 0.8);
		    box-shadow: 0 0 1px rgba(255, 255, 255, 0.9);
		    margin: -4px 0 0 -4px;
		}
		.box:hover .pic{
		    transform:rotate(-140deg);
		}
		.box .pic img{
		    width:100%;
		    height:auto;
		    border-radius:50%;
		}
		.box .content{
		    position: absolute;
		    top: 0;
		    width: 100%;
		    height: 100%;
		    border-radius: 50%;
		    padding: 70px 20px;
		    background: #b9607e;
		}
		.box .title{
		    text-align:center;
		    margin-bottom:5%;
		    text-transform:uppercase;
		}
		.box .title a{
		    color:#fff;
		    transition: all 0.3s ease 0s;
		}
		.box .title a:hover{
		    color:#333;
		}
		.box .description{
		    color:#fff;
		    text-align:center;
		    text-transform:uppercase;
		}
		@media only screen and (max-width: 990px) {
		    .box{
		        margin-bottom:20px;
		    }
		}
	</style>

  </head>
  
  <body>
    <div class="htmleaf-container">
		<header class="htmleaf-header">
			<h1>管道铺设途经各建筑的信息展示<span>信息简介</span></h1>
			<div class="htmleaf-links">
				<a class="htmleaf-icon icon-htmleaf-home-outline" href="/PipelineLaying/" title="主页" ><span> 主页</span></a>
				<a class="htmleaf-icon icon-htmleaf-arrow-forward-outline" href="/PipelineLaying/" title="返回主页" target="_blank"><span> 返回主页</span></a>
			</div>
		</header>
		<div class="demo box-bg">
	        <div class="container">
	            <div class="row">
	            
	            <%
	            	HttpSession session3 = request.getSession();
					ArrayList<Building> MsgList = (ArrayList<Building>)session3.getAttribute("message");
	             %>
	           
	             <%for(Building o:MsgList) {%>
	             	  <div class="col-md-4 col-sm-6">
	                    <div class="box">
	                        <div class="pic">
	                            <img src="<%=o.getImgUrl() %>" alt=""/>
	                        </div>
	                        <div class="content">
	                            <h3 class="title"><a href="#"><%=o.getName()%></a></h3>
	                            <p class="description"><%=o.getMessage()%></p>
	                        </div>
	                    </div>
	                </div>
	             	
	             <%} %>
	           
	            </div>
	        </div>
	    </div>
	</div>
  </body>
</html>
