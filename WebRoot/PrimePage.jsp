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
    
    <title>Prime算法</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/normalize2.css" />
	<link rel="stylesheet" type="text/css" href="css/demo.css" />
	<link rel="stylesheet" type="text/css" href="css/component1.css" />
	<link rel="stylesheet" type="text/css" href="./css/waves.min.css?v=0.7.2">
	<script src="js/modernizr-2.6.2.min.js"></script>
	<style>
		.container{
			background:url("images/view2.jpg") no-repeat;
			background-size:100% 100%;
		}
		body{
			height:100%;
		}
		#colored-button .btn {
            color: #fff;
        }
        .container > section{
        	
        }
        
		.container > header h1{
			color:#000;
		}
		.container > section p {
			color:#000;
			opacity: 1;
			font-weight:500;
		}
        #colored-button a,
        #colored-button a:hover {
            background: #01BCFF;
        }

        #colored-button button,
        #colored-button button:hover {
            background: #1bb556;
        }

        #colored-button input,
        #colored-button input:hover {
            background: #ff4f0f;
        }
        #bt{
        	background: #01BCFF;
        }
        #map{
        	background:#ff4f0f;
        }
        #output{
        	background:#1bb556;
        }
        #result{
        	color:#fff;
       	    position: absolute;
		    left: 50%;
		    top: 48%;
        	
        }
	</style>
  </head>
  
  <body>
    <body>
		<div class="container">

			<header>
				<h1>Prime算法 <span>强大的Prime算法</span></h1>	
				<!-- <nav class="codrops-demos">
					<a class="current-demo" href="index.html">Demo 1</a>
					<a href="index2.html">Demo 2</a>
				</nav> -->
			</header>
			<section>
				<p>prime算法的基本思想:<br><br>

					1. 清空生成树，任取一个顶点加入生成树<br>

					2. 在那些一个端点在生成树里，另一个端点不在生成树里的边中，选取一条权最小的边，将它和另一<br>   &emsp;个端点加进生成树<br>

					3. 重复步骤2，直到所有的顶点都进入了生成树为止，此时的生成树就是最小生成树<br><br>
					
					Prime算法适用性和时间复杂度:<br><br>

					Prime算法求最小生成树时候，和边数无关，只和定点的数量相关，所以适合求稠密网<br>
					的最小生成树，时间复杂度为O（n*n）。
				</p>
				
					<button class="btn float-button-light waves-effect waves-button waves-float waves-light" id="bt" onclick="getResult()">
					获取结果
					</button>
					
					<button class="btn float-button-light waves-effect waves-button waves-float waves-light" id="map" onclick="GoToMap()">
					路线显示
					</button>
					
					<a class="btn float-buttons waves-effect waves-button waves-float" id="output" href="/PipelineLaying/OutputDataServlet?flag=Prime">
					导出数据
					</a>
				
				<%
	            	HttpSession session3 = request.getSession();
					ArrayList<Building> MsgList = (ArrayList<Building>)session3.getAttribute("message");
	             %>
	           
	             <p>
	             	<%for(Building o:MsgList) {%>
	             		<%=o.getName() %><br>
	             	<%} %>
	             </p>
				
				  
				<p id="result"></p>
				
			</section>
			<div class="component">
				<div id="cn-overlay" class="cn-overlay"></div>
				<!-- End Nav Structure -->
			</div>
		</div><!-- /container -->
		<script src="js/polyfills.js"></script>
		<script src="js/demo1.js"></script>
		<script>
			
			<%
				HttpSession session4 = request.getSession();
				Object[] primeResult = (Object[])session4.getAttribute("Prime");
				String RandomNode = (String)primeResult[0];
				String[] finalWays = (String[])primeResult[1];
				long Time = (long) primeResult[2];
				int sum = 0;
				for(String s:finalWays)
				{
					sum+=Integer.valueOf(s.split("---")[1]);
				}
			%>
			var PrimeWays = [];
			<%for(int i=0;i<finalWays.length;i++){%>
				PrimeWays[<%=i%>] = "<%=finalWays[i]%>";
			 <%}%>
			function getResult()
			{
				var rs = document.getElementById("result");
				var s = "";
				var sum = "";
				var BeginNode = "";
				var Time = "";
				for(var i=0;i<PrimeWays.length;i++)
				{
				 	s+= PrimeWays[i]+"<br>";
				}
				BeginNode ="Prime算法第一次选择的随机结点为: "+ "<%=RandomNode%>"+"<br>";
				sum = "最小权值和为:"+"<%=sum%>"+"<br>";
				Time = "本次Prime算法的执行时间为:"+"<%=Time%>"+"ms";
				rs.innerHTML =BeginNode+s+sum+Time;
				
			}
			
			function GoToMap()
			{
				window.location.href = "/PipelineLaying/ShowMapServlet?flag=Prime";
			}
		</script>
		<script type="text/javascript" src="./js/waves.min.js?v=0.7.1"></script>
    <script src="./js/jquery.js"></script>
    <script type="text/javascript">
        Waves.attach('.flat-buttons', ['waves-button']);
        Waves.attach('.float-buttons', ['waves-button', 'waves-float']);
        Waves.attach('.float-button-light', ['waves-button', 'waves-float', 'waves-light']);
    </script>
    
    <script type="text/javascript">
        var currentRoute = false;
        $(document).on('ready', function () {

            // Init Waves
            Waves.init();
            Waves.attach('.drag-ripple', 'waves-block', true);
            Waves.attach('#bg-pattern', null, true);
            Waves.init();
            // $(window).on('hashchange', routing);
            /**
             * Example source code click
             */
            $('#example .top-button').on('click', function () {
                var type = $(this).data('code');
                $('#source-code .box .code').addClass('hide');
                $('#source-code .box #code-' + type).removeClass('hide');
                $('#source-code').removeClass('hide');
                setTimeout(function () {
                    $('#source-code').addClass('show');
                }, 50);
            });
            $('#source-code .top-button').on('click', function () {

                $('#source-code').removeClass('show');

                setTimeout(function () {
                    $('#source-code .box .code').addClass('hide');
                    $('#source-code').addClass('hide');
                }, 500);
            });
        });

    </script>
  </body>
</html>
