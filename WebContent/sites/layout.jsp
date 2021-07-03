<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!doctype html>
<html lang="en">

<head>
<title>${page.title }</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<base href="/PolyOEEE/" />
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>
	<main class="contaier" style="background-color: Gray">
	 	<header class="row">
			
			<img alt="" src="./images/zb.png" style="width: 1363px" height="500px">
			
		</header>
		<nav class="row pl-3">
			<nav class=" col navbar navbar-expand-sm navbar-dark bg-dark">
				<a class="navbar-brand" href="#">OE</a>
				<button class="navbar-toggler d-lg-none" type="button"
					data-toggle="collapse" data-target="#collapsibleNavId"
					aria-controls="collapsibleNavId" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="collapsibleNavId">
					<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
						<li class="nav-item active"><a class="nav-link" href="#">
								<i class="fa fa-home" aria-hidden="true"></i> <span
								class="sr-only">(current)</span>
						</a></li>
						<li class="nav-item"><a class="nav-link" href="Homepage"> <i
								class="fa fa-id-info" aria-hidden="true"></i> Home
						</a></li>
						<li class="nav-item"><a class="nav-link" href="Homepage"> <i
								class="fa fa-id-info" aria-hidden="true"></i> About Us
						</a></li>
						<li class="nav-item"><a class="nav-link" href="Homepage"> <i
								class="fa fa-id-card" aria-hidden="true"></i> Contact Us
						</a></li>
						<li class="nav-item"><a class="nav-link" href="Favorite"> <i
								class="fa fa-comments" aria-hidden="true"></i> My Favorites
						</a></li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="dropdownId"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
								<i class="fa fa-user" aria-hidden="true"></i> My Account
						</a>
							<div class="dropdown-menu" aria-labelledby="dropdownId">
								<c:if test="${ ! isLogin }">
									<a class="dropdown-item" href="Login">Login</a>
									<a class="dropdown-item" href="Forgotpassword">Forgot Passwork</a>
									<a class="dropdown-item" href="Registration">Registration</a>
								</c:if>
								<c:if test="${isLogin }">
									<a class="dropdown-item" href="Logoff">Logoff</a>
									<a class="dropdown-item" href="ChangePasswordServlet">Change Passwork</a>
									<a class="dropdown-item" href="EditProfileServlet">Edit Profile</a>
								</c:if>
							</div></li>
					</ul>
					<%-- <form class="form-inline my-2 my-lg-0">
					<fmt:setLocale value="${param.lang }" scope="request" />
						<a href="?lang=vi"><img alt="" width="70px" height="40px" src="./images/vn.png"></a>
					    <a href="?lang=en"><img alt="" width="70px" height="40px" src="./images/en.png"></a>	
					</form> --%>
				</div>
			</nav>
		</nav>
		<section class="row pl-5">
			<jsp:include page="${page.contentUrl }"></jsp:include>
		</section>
		 <div class="col text-center boder-top">
           <footer class="bg-light text-center text-lg-start">
                <!-- Grid container -->
               <!--  <div class="container p-4">
                    Grid row
                    <div class="row">
                        Grid column
                        <div class="col-lg-4 col-md-12 mb-4 mb-md-0">
                            <h5 class="text-left">Cytech</h5>
                            <div class="text-md-left">
                                <p>
                                    Giới thiệu <br> Tuyển dụng <br> Dịch vụ sửa chửa
                                </p>
                            </div>
                        </div>
                        Grid column

                        Grid column
                        <div class="col-lg-4 col-md-12 mb-4 mb-md-0">
                            <h5 class="text-left">Hỗ trợ khách hàng</h5>
                            <div class="text-md-left">
                                <p>
                                    Mua hàng từ xa <br> Quy định đổi trả <br> Quy định bảo hành <br>
                                </p>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-12 mb-4 mb-md-0">
                            <h5 class="text-left">Cytech</h5>
                            <div class="text-md-left">
                                <p>
                                    Nâng cấp phần cứng<br> Cài đặt phần mềm <br> Blog công nghệ<br>
                                </p>
                            </div>
                        </div>
                        Grid column
                    </div>
                    Grid row
                </div> -->
                <!-- Grid container -->

                <!-- Copyright -->
                <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2)">
                    <strong>FPT Poly &copy;2020. All right reserved</strong>
                    <a class="text-dark" href="https://mdbootstrap.com/"></a>
                </div>
                <!-- Copyright -->
            </footer>

        </div>

	</main>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
	<c:if test="${not empty page.scriptUrl}">
		<jsp:include page="${page.sciptUrl }"></jsp:include>
	</c:if>
</body>

</html>