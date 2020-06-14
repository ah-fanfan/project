<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<!-- head -->
<head>

</head>
<jsp:include page="structure/head.jsp"></jsp:include>

<!-- head end -->
<body>
	<div id="page-wrapper" class="page-loading">
		<!-- Preloader 页面加载动态效果-->
		<jsp:include page="structure/preloader.jsp"></jsp:include>
		<!-- END Preloader -->

		<!-- Page Container -->
		<div id="page-container"
			class="header-fixed-top sidebar-visible-lg-full">

			<!-- 右侧弹出设置 -->
			<jsp:include page="structure/alterSidebar.jsp"></jsp:include>
			<!-- END 右侧弹出设置 -->

			<!-- Main Sidebar包括Logo和左侧菜单和菜单下方版权声明 -->

			<jsp:include page="structure/left.jsp"></jsp:include>

			<!-- END Main Sidebar -->

			<!-- Main Container -->
			<div id="main-container">
				<!-- Header 包括顶部中间和顶部右侧 -->
				<jsp:include page="structure/rightHeader.jsp"></jsp:include>
				<!-- END Header -->
				<!-- Page content正文内容这里开始 -->
				<!-- Page content -->
				<!--
                        Available classes when #page-content-sidebar is used:

                        'inner-sidebar-left'      for a left inner sidebar
                        'inner-sidebar-right'     for a right inner sidebar
                    -->

				<div id="page-content" style="padding: 0px; margin-top: 60px;">
					<!--  
                        <img alt="image" src="img/placeholders/photos/body3.jpg"  style="width: 100%">
                          <img alt="image" src="img/placeholders/photos/body1.jpg"  style="width: 100%">
</div>
-->
					<div id="car"
						style="width: 600px; height: 400px; margin-top: 0px; margin-left: 80px;"></div>
					<div id="mark"
						style="width: 600px; height: 400px; margin-top: -400px; margin-left: 880px;"></div>

					<div id="share"
						style="width: 600px; height: 400px; margin-top: 60px; margin-left: 80px;"></div>
				


				</div>
				<!-- END Page Content -->
				<!-- END Page Content内容到这里结束 -->
				<!-- END Main Container -->
			</div>
			<!-- END Page Container -->
		</div>
	</div>
	<!-- END Page Wrapper -->
</body>
<script type="text/javascript">
//基于准备好的dom，初始化Echarts实例
var myChart=echarts.init(document.getElementById("car"));
var arr=new Array();
var arr1=new Array();
var index=0;var index1=0;

option = {
		  title: {
		        text: '车型销量排行榜',
		        subtext: '凡运汽车官网数据（台）',
		        left: 'center'
		    },
	    color: ['#3398DB'],
	    tooltip : {
	        trigger: 'axis',
	        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
	            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
	        }
	    },
	    grid: {
	        left: '3%',
	        right: '4%',
	        bottom: '3%',
	        containLabel: true
	    },
	    xAxis : [
	        {
	            type : 'category',
	            data : [
	            	  <c:forEach begin="1" end="${length}" var="n">
	            	  '${s[n-1]}',
	            	  </c:forEach>
	            ],
	            axisTick: {
	                alignWithLabel: true
	            }
	        }
	    ],
	    yAxis : [
	        {
	            type : 'value'
	        }
	    ],
	    series : [
	        {
	            name:'直接访问',
	            type:'bar',
	            barWidth: '60%',
	            data:[
		            <c:forEach begin="1" end="${length}" var="n">
		            ${a[n-1]},
		            </c:forEach>
	            ]
	        }
	    ]
	};

myChart.setOption(option);
</script>

<script>
var myChart=echarts.init(document.getElementById("mark"));
option = {
	    title: {
	        text: '品牌市场销量排行榜',
	        subtext: '凡运汽车官网数据',
	        left: 'center'
	    },
	    tooltip: {
	        trigger: 'item',
	        formatter: '{a} <br/>{b} : {c} ({d}%)'
	    },
	    legend: {
	        // orient: 'vertical',
	        // top: 'middle',
	        bottom: 10,
	        left: 'center',
	        data: [
	        	 <c:forEach begin="1" end="${m_length}" var="n">
           	  '${ma[n-1]}',
           	  </c:forEach>
	        ]
	    },
	    series: [
	        {
	            type: 'pie',
	            radius: '65%',
	            center: ['50%', '50%'],
	            selectedMode: 'single',
	            data: [
	            	
	            	 <c:forEach begin="1" end="${m_length}" var="n">
	            	 {value: ${m[n-1]}, name: '${ma[n-1]}'},
	              	  </c:forEach>
	            ],
	            emphasis: {
	                itemStyle: {
	                    shadowBlur: 10,
	                    shadowOffsetX: 0,
	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
	                }
	            }
	        }
	    ]
	};
	myChart.setOption(option);
</script>


<script type="text/javascript">
var myChart=echarts.init(document.getElementById("share"));
option = {
	    title: {
	        text: '车型月销量排行榜',
	        subtext: '凡运汽车官网数据（万元）'
	    },
	    tooltip: {
	        trigger: 'axis'
	    },
	    legend: {
	        data: ['小型车', '紧凑型车', '中型车', 'SUV']
	    },
	    grid: {
	        left: '3%',
	        right: '4%',
	        bottom: '3%',
	        containLabel: true
	    },
	    toolbox: {
	        feature: {
	            saveAsImage: {}
	        }
	    },
	    xAxis: {
	        type: 'category',
	        boundaryGap: false,
	        data: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月']
	    },
	    yAxis: {
	        type: 'value'
	    },
	    series: [
	        {
	            name: '小型车',
	            type: 'line',
	            stack: '总量',
	            data: [ ${z[0][0]},${z[1][0]},${z[2][0]},${z[3][0]},${z[4][0]},${z[5][0]},${z[6][0]},${z[7][0]},${z[8][0]},${z[9][0]},${z[10][0]},${z[11][0]}]
	        },
	        {
	            name: '紧凑型车',
	            type: 'line',
	            stack: '总量',
	            data: [${z[0][1]},${z[1][1]},${z[2][1]},${z[3][1]},${z[4][1]},${z[5][1]},${z[6][1]},${z[7][1]},${z[8][1]},${z[9][1]},${z[10][1]},${z[11][1]}]
	        },
	        {
	            name: '中型车',
	            type: 'line',
	            stack: '总量',
	            data: [${z[0][2]},${z[1][2]},${z[2][2]},${z[3][2]},${z[4][2]},${z[5][2]},${z[6][2]},${z[7][2]},${z[8][2]},${z[9][2]},${z[10][2]},${z[11][2]}]
	        },
	        {
	            name: 'SUV',
	            type: 'line',
	            stack: '总量',
	            data: [ ${z[0][3]},${z[1][3]},${z[2][3]},${z[3][3]},${z[4][3]},${z[5][3]},${z[6][3]},${z[7][3]},${z[8][3]},${z[9][3]},${z[10][3]},${z[11][3]}]
	        }
	      
	    ]
	};

myChart.setOption(option);

</script>

<script type="text/javascript">
var myChart=echarts.init(document.getElementById("stock"));
option = {
	    title: {
	        text: '库存车型数据',
	        subtext: '凡运汽车官网数据（台）',
	        left: 'center'
	    },
	    tooltip: {
	        trigger: 'item',
	        formatter: '{a} <br/>{b} : {c} ({d}%)'
	    },
	    legend: {
	        orient: 'vertical',
	        left: 'left',
	        data: [
	       	 <c:forEach begin="1" end="${t_length}" var="n">
          	  '${st[n-1]}',
          	  </c:forEach>
	        ]
	    },
	    series: [
	        {
	            name: '访问来源',
	            type: 'pie',
	            radius: '55%',
	            center: ['50%', '60%'],
	            data: [
	           	 <c:forEach begin="1" end="${t_length}" var="n">
	           	 {value: ${t[n-1]}, name: '${st[n-1]}'},
	           	  </c:forEach>
	               
	            ],
	            emphasis: {
	                itemStyle: {
	                    shadowBlur: 10,
	                    shadowOffsetX: 0,
	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
	                }
	            }
	        }
	    ]
	};

myChart.setOption(option);

</script>

</html>