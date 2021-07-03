<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="col mt-4">
<jsp:include page="/comon/inform.jsp"></jsp:include>
	<ul class="nav nav-tabs" id="myTab" role="tablist">
		<li class="nav-item" role="presentation"><a
			class="nav-link active" id="videoediting-tab" data-toggle="tab"
			href="#videoediting" role="tab" aria-controls="videoediting"
			aria-selected="true">User Editing</a></li>
		<li class="nav-item" role="presentation"><a class="nav-link"
			id="videolist-tab" data-toggle="tab" href="#videolist" role="tab"
			aria-controls="videolist" aria-selected="false">User List</a></li>
	</ul>
	<div class="tab-content" id="myTabContent">
		<div class="tab-pane fade show active" id="videoediting"
			role="tabpanel" aria-labelledby="videoediting-tab">
			<form action="" method="post">
				<div class="card">

					<div class="card-body">
						<div class="row">
							<div class="col">
								<div class="form-group">
									<label for="username">Username</label> <input type="text"
										class="form-control" name="username" id="username" value="${user.username }"
										aria-describedby="usernameHid" placeholder=""> <small
										id="usernameHid" class="form-text text-muted"></small>
								</div>
								<div class="form-group">
									<label for="fullname">Fullname</label> <input type="text"
										class="form-control" name="fullname" id="fullname" value="${user.fullname }"
										aria-describedby="fullnameHid" placeholder=""> <small
										id="fullnameHid" class="form-text text-muted"></small>
								</div>
								<div class="form-check form-check-inline">
									<label for=""><input type="radio" name="active"
										id="status" class="form-check-input" value="true" ${user.admin?'checked':'' } >Admin</label>
									<label for=""><input type="radio" name="active"
										id="status" class="form-check-input" value="false" ${!user.admin?'checked':'' }>User</label>
								</div>
							</div>
							<div class="col">
								<div class="form-group">
									<label for="Password">Password</label> <input type="password"
										class="form-control" name="password" id="password"
										placeholder="">
								</div>
								<div class="form-group">
									<label for="email">Email</label> <input type="text"
										class="form-control" name="email" id="email" value="${user.email }"
										aria-describedby="emailHid" placeholder=""> <small
										id="emailHid" class="form-text text-muted"></small>
								</div>
							</div>
						</div>
					</div>
					<div class="card-footer text-muted">
						<button class="btn btn-primary" formaction="UsersManagementServlet/create">Create</button>
						<button class="btn btn-warning" formaction="UsersManagementServlet/update">Update</button>
						<button class="btn btn-danger" formaction="UsersManagementServlet/delete">Delete</button>
						<button class="btn btn-info" formaction="UsersManagementServlet/reset">Reset</button>
					</div>
				</div>
			</form>
		</div>
		<div class="tab-pane fade" id="videolist" role="tabpanel"
			aria-labelledby="videolist-tab">
			<table class="table table-stripe">
				<tr>
					<td>Userrname</td>
					<td>Fullname</td>
					<td>Email</td>
					<td>Role</td>
					<td>&nbsp;</td>
				</tr>
				<c:forEach var="item" items="${users}">
					<tr>
						<td>${item.username}</td>
						<td>${item.fullname}</td>
						<td>${item.email}</td>
						<td>${item.admin?'Nam':'Nữ'}</td>
						<td>
							<a href="/PolyOEEE/UsersManagementServlet/edit?username=${item.username}">Edit</a>
							<a href="/PolyOEEE/UsersManagementServlet/delete?username=${item.username}">Delete</a>
						</td>
					</tr>					
					</c:forEach>
			</table>
		</div>
	</div>
</div>