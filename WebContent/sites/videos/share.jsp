<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<main class="container">
	<section class="row">
		<div class="offset-3 col-6">
			<form action="./ShareServlet" method="post">
				<input type="hidden" name="videoId" value="${videoId }" />
				<div class="card">
					<div class="card-header">Send Video to Your Friends</div>
					<div class="card-body">
					<jsp:include page="/comon/inform.jsp"></jsp:include>
						<div class="row">
							<div class="col">
								<div class="form-group">
									<label for="email">Your Friends emails:</label> <input
										type="text" class="form-control" name="email" id="email"
										aria-describedby="emailHelperId" placeholder="Email">
									<small id="emailHelperId" class="form-text text-muted">
										Nhập Email</small>
								</div>
							</div>
						</div>

					</div>
					<div class="card-footer">
						<button class="btn btn-success">Send</button>
					</div>
				</div>
			</form>
		</div>
	</section>
</main>