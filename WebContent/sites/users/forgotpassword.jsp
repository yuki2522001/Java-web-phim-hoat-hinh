<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="offset-4 col-4">
	<form action="" method="post">
		<div class="card mt-5">
		<jsp:include page="/comon/inform.jsp"></jsp:include>
			<div class="card-header">
				<b>Forgot password</b>
			</div>
			<div class="card-body">
				<div class="form-group">
				<div class="form-group">
					<label for="username">Username</label> <input type="text" 
						class="form-control" name="username" id="username">
				</div>
					<label for="email">Email</label> <input type="text"
						class="form-control" name="email" id="email"
						aria-describedby="email" placeholder="email"> <small
						id="email" class="form-text text-muted"></small>
				</div>			
			</div>
			<div class="card-footer text-muted">
				<button class="btn btn-success">Retrieve</button>
			</div>
			<div style="text-align: center">
						<a href="Homepage">Back Home</a>
					</div>
		</div>
	</form>
</div>