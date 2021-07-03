<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="col mt-4">
	<jsp:include page="/comon/inform.jsp"></jsp:include>
	<ul class="nav nav-tabs" id="myTab" role="tablist">
		<li class="nav-item" role="presentation"><a
			class="nav-link active" id="favorite-tab" data-toggle="tab"
			href="#favorite" role="tab" aria-controls="favorite"
			aria-selected="true">Favorites</a></li>
		<li class="nav-item" role="presentation"><a class="nav-link"
			id="favoriteuser-tab" data-toggle="tab" href="#favoriteuser"
			role="tab" aria-controls="favoriteuser" aria-selected="false">Favorites
				Users</a></li>
		<li class="nav-item" role="presentation"><a class="nav-link"
			id="favoritesend-tab" data-toggle="tab" href="#favoritesend"
			role="tab" aria-controls="favoritesend" aria-selected="false">Shared
				Friends</a></li>
	</ul>
	<div class="tab-content" id="myTabContent">
		<div class="tab-pane fade" id="favorite" role="tabpanel"
			aria-labelledby="favorite-tab">
			<table class="table table-stripe">
				<tr>
					<td>Video Title</td>
					<td>Favourite</td>
					<td>Latest Date</td>
					<td>Oldest Date</td>
				</tr>
				<c:forEach var="item" items="${favList }">
					<tr>
						<td>${item.videoTitle }</td>
						<td>${item.favoriteCount }</td>
						<td>${item.newsDate }</td>
						<td>${item.oldesDate }</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="tab-pane fade" id="favoriteuser" role="tabpanel"
			aria-labelledby="favoriteuser-tab">
			<div class="row mt-3 ml-1">
				<div class="col-2">
					<form>
						<label for="">Video Title?</label>
				</div>
				<div class="col-8">
					<fieldset>
						<div class="form-group">

							<select id="videoUserId" class="form-control" name="videoUserId">
								<c:forEach var="item" items="${vidlist}">
									<option value="${item.videoId}"
										${item.videoId == videoUserId?'selected':'' }>
										${item.title}</option>
								</c:forEach>
							</select>
					</fieldset>
				</div>
				<div class="col-2">
					<button class="btn btn-info">Report</button>
				</div>
				</form>
			</div>
			<table class="table table-stripe">
				<tr>
					<td>Username</td>
					<td>Fullname</td>
					<td>Email</td>
					<td>Favorite Date</td>
				</tr>
				<c:forEach var="item" items="${favUsers}">
					<tr>
						<td>${item.username }</td>
						<td>${item.fullname}</td>
						<td>${item.email }</td>
						<td>${item.favoriteDate }</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="tab-pane fade" id="favoritesend" role="tabpanel"
			aria-labelledby="favoritesend-tab">
			<div class="row mt-3 ml-1">
				<div class="col-2">
					<form>
						<label for="">Video Title?</label>
				</div>
				<div class="col-6">
					<fieldset>
						<div class="form-group">
							<select id="disabledSelect" class="form-control" name="videoShareId">
								<c:forEach var="item" items="${sidlist}">
									<option value="${item.videoId}"
										${item.videoId == videoShareId?'selected':'' }>
										${item.title}</option>
								</c:forEach>
							</select>
					</fieldset>
				</div>
				<div class="col-2">
					<button class="btn btn-info">Report</button>
				</div>
				</form>
			</div>
			<table class="table table-stripe">
				<tr>
					<td>Sender Name</td>
					<td>Sender Email</td>
					<td>Receiver</td>
					<td>Sent Date</td>
				</tr>
				<c:forEach var="item" items="${favShare}">
					<tr>
						<td>${item.lastname }</td>
						<td>${item.email}</td>
						 <td>${item.emails }</td> 
						<td>${item.sharedDate }</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>