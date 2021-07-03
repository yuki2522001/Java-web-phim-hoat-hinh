<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="offset-3 col-6">
	<form action="" method="post">
	${Routes.SITE_REGISTRATION_PAGE }
		<div class="card">
			<div class="card-header">
				<b>Regisstration</b>
			</div>
			<div class="card-body">
			<jsp:include page="/comon/inform.jsp"></jsp:include>
				<div class="row">
					<div class="col">
						<div class="form-group">
							<label for="username">Username</label> <input type="text"
								class="form-control" name="username" id="username"
								value="${user.username }" aria-describedby="helpId"
								placeholder="username"> <small id="usernameHid"
								class="form-text text-muted"></small>
						</div>
						<div class="form-group">
							<label for="fullname">Fullname</label> <input type="text"
								class="form-control" name="fullname" id="fullname"
								value="${user.fullname }" aria-describedby="fullnameHid"
								placeholder="fullname"> <small id="helpId"
								class="form-text text-muted"></small>
						</div>
					</div>
					<div class="col">
						<div class="form-group">
							<label for="password">Password</label> <input type="password"
								class="form-control" name="password" id="password"
								placeholder="password">
						</div>
						<div class="form-group">
							<label for="email">Email</label> <input type="text"
								class="form-control" name="email" id="email"
								value="${user.email }" aria-describedby="helpId"
								placeholder="email"> <small id="emailHid"
								class="form-text text-muted"></small>
						</div>
					</div>
				</div>
			</div>
			<div class="card-footer text-muted">
				<button class="btn btn-success">Sign up</button>
			</div>
			<div style="text-align: center">
						<a href="Homepage">Back Home</a>
					</div>
		</div>
	</form>
</div>