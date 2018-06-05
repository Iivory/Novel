<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<title>我的小说</title>
	<link rel="stylesheet" href="./css/bootstrap.min.css">  
	<script src="./js/jquery.min.js"></script>
	<script src="./js/bootstrap.min.js"></script>
</head>
<body>
	<div >
		<img src="./img/logo.jpg" width="100%" height="100px">
	</div>
	<div class="input-group input-group-lg" align="center">
			<input type="text" class="form-control" placeholder="请输入书名或作者名" height="100px" id="KeyWords" ">
			<button type="button" class="btn btn-default" onclick="search()">搜索</button>
	</div>
	

	<table class="table table-bordered">
		<thead>
			<tr>
				<th>序号</th>
				<th>书名</th>
				<th>作者</th>
				<th>类别</th>
				<th>状态</th>
				<th>最新章节</th>
				<th>字数</th>
				<th>更新时间</th>
				<th>来源网站</th>
				<th>操作</th>
			</tr>
		</thead>
		
		<!-- 表格数据 -->
		<tbody>
		<c:if test="${not empty page.novels }">
			<c:forEach items="${page.novels }" var="Novel" varStatus="status">
				<tr>
					<th>${status.count }</th>	
					<th><a href="./menuList?url=${Novel.lastchapterurl}">${Novel.bookname }</a></th>
					<th>${Novel.author }</th>
					<th>${Novel.type }</th>
					<th>${Novel.status }</th>
					<th><a href="${Novel.lastchapterurl }">${Novel.lastchapter }</a></th>
					<th>${Novel.size }</th>
					<th>${Novel.lastupdate }</th>
					<th>${Novel.source }</th>
					<th><a  href="./download?url=${Novel.lastchapterurl }" >下载</a></th>
				</tr>
			</c:forEach>
		</c:if>
		
		<!-- 分页处理 -->
			<tr>
				<c:if test="${page.currentPage > 1}"><td colspan="2"><a href="${pageContext.request.contextPath}/SearchNovels?keywords=${keywords}&currentPage=${page.prePage}">上一页</a><td>
				</c:if>
				<c:if test="${page.currentPage == 1 }"><td colspan="2">上一页<td>
				</c:if><td colspan="2">当前第${page.currentPage }页</td>
				<c:if test="${page.currentPage < page.totalPage}"><td colspan="2"><a href="${pageContext.request.contextPath}/SearchNovels?keywords=${keywords}&currentPage=${page.nextPage}">下一页</a><td>
				</c:if>
				<c:if test="${page.currentPage == page.totalPage}"><td colspan="2" >下一页<td>
				</c:if><td colspan="2">总共${page.totalPage }页</td>
			</tr>
		</tbody>
	</table>

</body>

<script type="text/javascript">
	function search(){
		var keywords = $("#KeyWords").val()
		window.location.href = "${pageContext.request.contextPath}/SearchNovels?keywords="+keywords;
	}
	


</script>
</html>