<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
 <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="http://www.ifengxue.com/ifengxue/favicon.ico">

	<!-- 章节标题 -->
    <title>-章节内容-小说搜搜-免费且无广告的小说阅读网</title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">
    <style>
    	body {
    		background-color:#E5E4DB;
    	}
    	.content {
    		font-size:16px;
    		background-color:#F6F4EC;
    		color:#333;
    		padding:20px;
    		border-radius:5px;
    		-webkit-border-radiu:5px;
    	}
    	.jumbotron {
    		padding-top:10px;
    		padding-bottom:10px;
    		background-color:#F5F5F5;
    	}
    </style>
  </head>
<body>
	<div class="jumbotron">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<a href="./Search">回到搜索页</a>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<h3 style="text-align:center;">${chapter.title }</h3>
		<!-- 章节内容区域 -->
		<div class="content">
		${chapter.content }
		</div>
		<!-- 前一章 章节列表 后一章 链接区域 -->
		<div style="text-align:center;">
			<a href="./chapter?url=${chapter.prevous }&baseUrl=${baseUrl}">上一章&nbsp;&nbsp;</a>
			<a href="./menuList?url=${baseUrl }">章节目录</a>
			<a href="./chapter?url=${chapter.next }&baseUrl=${baseUrl}">&nbsp;&nbsp;下一章</a>
		</div>
	</div>
	<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
       <script src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js"></script>
    <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath }/js/jquery.base64.js"></script>
</body>
</html>