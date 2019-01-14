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
    
    <title>Kruskal算法</title>
    
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
			background:url("images/view3.jpg") no-repeat;
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
		    top: 46%;
        	
        }
	
	</style>
  </head>
  
  <body>
    <body>
		<div class="container">

			<header>
				<h1>Kruskal算法 <span>强大的Kruskal算法</span></h1>	
			</header>
			<section>
				<p>kruskal算法的基本思想:<br><br>

					1.首先将G的n个顶点看成n个孤立的连通分支（n个孤立点）并将所有的边按权从小大排序。<br>

					2.按照边权值递增顺序，如果加入边后存在环则这条边不加，直到形成连通图<br><br>
					Kruskal算法适用性和时间复杂度:<br><br>
					Kruskal算法是对图的边进行访问，所以Kruskal算法的时间复杂度只和边又关系，其时<br>间复杂度为O（eloge）。
					
				</p>
				<button class="btn float-button-light waves-effect waves-button waves-float waves-light" id="bt" onclick="getResult()">
					获取结果
					</button>
					
					<button class="btn float-button-light waves-effect waves-button waves-float waves-light" id="map" onclick="GoToMap()">
					路线显示
					</button>
					
					<a class="btn float-buttons waves-effect waves-button waves-float" id="output" href="/PipelineLaying/OutputDataServlet?flag=Kruskal">
					导出数据
					</a>
				<p>	
				<%
	            	HttpSession session3 = request.getSession();
					ArrayList<Building> MsgList = (ArrayList<Building>)session3.getAttribute("message");
	             %>
	           
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
				Object[] objResult = (Object[])session4.getAttribute("Kruskal");
				String[] KruskalResult = (String[])objResult[0];
				long Time = (long) objResult[1];
				int sum = 0;
				for(String s:KruskalResult)
				{
					sum+=Integer.valueOf(s.split("---")[2]);
				}
			
			%>
			var KruskalWays = [];
			<%for(int i=0;i<KruskalResult.length;i++){%>
				KruskalWays[<%=i%>] = "<%=KruskalResult[i]%>";
			 <%}%>
			function getResult()
			{
				var rs = document.getElementById("result");
				var s = "";
				var sum = "";
				var BeginNode = "";
				var Time = "";
				for(var i=0;i<KruskalWays.length;i++)
				{
				 	s+= KruskalWays[i]+"<br>";
				}
				
				sum = "最小权值和为:"+"<%=sum%>"+"<br>";
				Time = "本次Kruskal算法的执行时间为:"+"<%=Time%>"+"ms";
				rs.innerHTML =s+sum+Time;
				
			}
			
			function GoToMap()
			{
				window.location.href = "/PipelineLaying/ShowMapServlet?flag=Kruskal";
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
