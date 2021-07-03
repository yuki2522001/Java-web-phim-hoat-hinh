<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link href="/css/loginstyle.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.1/css/all.css">
<style>
.dv1 {
	
	transition: transform .2s; /* Animation */
	margin: 0 auto;
}
.card-body:hover {
	transform: scale(1.2);
}
.dv{
text-align: center;
color: white;
}
.mau{
color: blue;
}
</style>

<div class="col-9" style="background-color: black;">
	<jsp:include page="/comon/inform.jsp"></jsp:include>
	<div class="row p-2">
		<c:forEach var="item" items="${videos }">
			<%Boolean check =true; %>
			<div class="col-3 mt-2">
				<div class="card text-center">
					<div class="">
						<a href="DetailsServlet?vid=${item.videoId }">
						<img src="${empty item.poster ? 'images/do.png':item.poster }"
							width="213px" height="307px" alt="" class="dv1"></a>
						
					</div>
					<div class="row ml-2"  >
							<b style="text-align: center;">${item.title }</b>
						</div>
					
					<div class="row card-footer">
					
						<c:forEach var="itemlike" items="${checkLike }">
							<c:if test="${item.videoId eq itemlike.video.videoId }">
								<a href="LikeVideoServlet?videoId=${item.videoId }" class="btn btn-success col-6 mr-1 "><i class="fas fa-thumbs-down"></i></a>	
								<%check=false; %>	
							</c:if>							
						</c:forEach>
						<% if(check) { %>
							<a href="LikeVideoServlet?videoId=${item.videoId}" class="btn btn-success col-6 mr-1 "><i class="fas fa-thumbs-up"></i></a>	
						<% }%>
						<a href="ShareServlet?videoId=${item.videoId }" class="btn btn-success"><i class="fas fa-share-alt"></i></a>						
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
	<div class="row">
		<div class="col">
			<nav aria-label="Page navigation">
				<ul class="pagination justify-content-center">
					<li class="page-item"><a class="page-link"
						href="HomePage?pagenumber=1" aria-label="Previous"> <span
							aria-hidden="true">&laquo;</span> <span class="sr-only">Previous</span>
					</a></li>
					<li class="page-item ${number==1?'active':'' }"><a
						class="page-link" href="Homepage?pagenumber=1">1</a></li>
					<li class="page-item ${number==2?'active':''}"><a
						class="page-link" href="Homepage?pagenumber=2">2</a></li>
					<li class="page-item"><a class="page-link"
						href="Homepage?pagenumber=2" aria-label="Next"> <span
							aria-hidden="true">&raquo;</span> <span class="sr-only">Next</span>
					</a></li>
				</ul>
			</nav>
		</div>
	</div>
</div>
<div class="col-3"  style="background-color: black;">
	<div class="row mt-3 mb-3">
		<div class="col">
			<div class="card">
				<div class="card-header">
					<i aria-hidden="true"></i>Thể loại
				</div>
				<ul class="list-group list-group-flush"  style="background-color: dray;">
					<li class="list-group-item"><a href="./home3servlet">
							Anime</a></li>
					<li class="list-group-item">Phim viễn tưởng</li>
					<li class="list-group-item">Phim hài hước</li>
					<li class="list-group-item">Phim hành động</li>
					<li class="list-group-item">Phim tài liệu</li>
					<li class="list-group-item">Phim kinh dị</li>
					<li class="list-group-item">Phim tâm lí</li>
					<li class="list-group-item">Phim cổ trang</li>
				</ul>
			</div>
		</div>
	</div>
</div>
