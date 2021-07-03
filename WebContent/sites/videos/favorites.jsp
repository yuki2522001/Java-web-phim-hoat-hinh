<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link href="/css/loginstyle.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.1/css/all.css">
<div class="col">
	<div class="row p-2">
		<c:forEach var="item" items="${favList }">
			<div class="col-3 mt-2">
				<div class="card">
					<div class="card-header"></div>
					<div class="card-body">
						<img src="${empty item.video.poster ? 'images/ii.png': item.video.poster }" class="img-fluid" alt="">
						<div class="row">
							<b>${item.video.title }</b>
						</div>
					</div>
					<div class="card-footer text-muted">
						<a href="Favorite/Unlike?videoId=${item.favoritedId }" class="fas fa-thumbs-down">Unlike</a> 
						<a href="" class="btn btn-info"><i class="fas fa-share-alt"></i></a> 
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
	<div class="row">
		<div class="col">
			<nav aria-label="Page navigation">
				<ul class="pagination justify-content-center">
					<li class="page-item disabled"><a class="page-link" href="#"
						aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							<span class="sr-only">Previous</span>
					</a></li>
					<li class="page-item active"><a class="page-link" href="#">&lt;</a></li>
					<li class="page-item"><a class="page-link" href="#">&gt;</a></li>
					<li class="page-item"><a class="page-link" href="#"
						aria-label="Next"> <span aria-hidden="true">&raquo;</span> <span
							class="sr-only">Next</span>
					</a></li>
				</ul>
			</nav>
		</div>
	</div>
</div>