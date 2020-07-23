<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'home.jsp' starting page</title>
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
  </head>
  
  <body>
	  	<!-- 左侧导航栏 -->
		<%@ include file="/static/common/left.jsp" %>
		
		<div id="content">
			
		</div>
		
		<!-- 底部导航条 -->
		<%@ include file="/static/common/footer.jsp"  %>
	    <script type="text/javascript" src="<%=path %>/static/js/bootstrap.js"></script>
  		
  		<script type="text/javascript">
  			//加载显示员工页面
  			function showUser(url){
  				//查询所有员工
  				$("#content").load("<%=path%>/"+url+" #content>*");
  			}
  			//加载添加员工
  			function showAdd(url){
  				$("#content").load("<%=path%>/"+url+" #content>*")
  			}
  			
  			//条件查询
  			$("#select").click(function(){
  				//用户输入
  				var uName = $("#uName").val();
  				var dId = $("#dId").val();
  				
  				//查询
  				location.href="<%=path%>/spring/user/list?uName="+uName+"&dId="+dId;
  			});
  			
  			//删除按钮点击事件
  			function isDelete(uId){
  				var flag = window.confirm("是否确认删除该用户?");
  				if(flag){
  					//使用ajax
  					$.ajax({
  						url		:		"<%=path%>/spring/user/del",
  						method	:		"post",
  						data	:		{"uId":uId},
  						success	:		function(data){
  							var json = eval('('+data+')');
  							if(json.status == 1){
  								alert(json.message);
  								location.href="<%=path%>/spring/user/list";
  							}else{
  								alert(json.message);
  							}
  						}
  					});
  				}
  			}
  			
  			//添加员工
  			$("#add").click(function(){
  				location.href="<%=path%>/spring/user/toAdd";
  			});
  		</script>
  
  </body>
</html>
