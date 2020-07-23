<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="x" %>
<!-- 左侧导航 -->
<ul class="nav nav-pills nav-stacked" style="width:250px;font-weight:bolder;">
	
 	<li>
 		<a href="javascript:void(0)" onclick="showUser('spring/user/list')">员工列表</a>
 	</li>
 	<li>
 		<a href="javascript:void(0)" onclick="showAdd('spring/user/toAdd')">添加员工</a>
 	</li>
</ul>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.12.4.js"></script>
