<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="offset-4 col-4">
	<form action="" method="post">
		<div class="card">
			<div class="card-header">
				<b> Login to System</b>

			</div>
			<div class="card-body">
			<jsp:include page="/comon/inform.jsp"></jsp:include>
				<div class="form-group">
					<label for="username">Username</label> <input type="text"
						class="form-control" name="username" id="username"
						aria-describedby="helpId" placeholder=""> <small
						id="usernameHelperId" class="form-text text-muted">Nhập
						vào username</small>
				</div>
				<div class="form-group">
					<label for="password">Password</label> <input type="password"
						class="form-control" name="password" id="password"
						aria-describedby="helpId" placeholder=""> <small
						id="passwordHelperId" class="form-text text-muted">Nhập
						vào password</small>
				</div>
			</div>
			<div class="form-check form-check-inline ml-4">
				<label for=""><input type="checkbox" class="form-check-input"
					name="remember">Remember me?</label>
			</div>
			<div class="card-footer text-muted">
				<button class="btn btn-success">Login</button>
			</div>
		</div>
	</form>
</div>