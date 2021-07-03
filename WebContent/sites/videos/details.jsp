<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link href="/css/loginstyle.css" rel="stylesheet" type="text/css">
<style>
.list-group{
background-image: linear-gradient(indigo, crimson, pink);
}
</style>
<div class="row">
	<div class="col-8">
		<div class="text-center mt-3">
			<div class="card-body">
			<jsp:include page="/comon/inform.jsp"></jsp:include>
				<div class="row">
					<iframe width="935" height="517" src="https://www.youtube.com/embed/${videos.description }" frameborder="0" allow="accelerometer; autoplay;
					 clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
				</div>
				<div class="row p-2">
					<h5 class="card-title">${videos.title }</h5> <br>
					<%-- <p class="card-text">${videos.description }</p> --%>
				</div>
				
				
			</div>
			<div class="card-footer text-right">
				<a href="LikeVideoServlet?videoId=${videos.videoId }" class="btn btn-primary">Like</a>
					 <a href="ShareServlet?videoId=${videos.videoId }"class="btn btn-info">Share</a>
			</div>
		</div>
	</div>
	<div class="col-4">
		<div class="list-group"><a href="DetailsServlet?vid=${videos.videoId }" class="list-group-item list-group-item-action">
					<div class="row">
						<div class="col-4"><img src="${videos.poster }" alt="" class="img-fluid">
							<h6 class="mb-1">${videos.videoId }</h6></div>
						<div class="col-7">
							<p class="mb-1">${videos.title }</p> <small class="text-muted">Donec id elit non mi porta.</small>
					</div>
				</div>
			</a>  
			 <a href="#" class="list-group-item list-group-item-action">
					<div class="row">
						<div class="col-4"><img src=" ./images/z4.png" alt="" class="img-fluid">
							<h6 class="mb-1">One Piece</h6></div>
						<div class="col-7">
							<p class="mb-1">One Piece, từng được xuất bản tại Việt Nam dưới tên gọi Đảo Hải Tặc là bộ manga dành cho lứa tuổi thiếu niên của tác giả Oda Eiichiro, được đăng định kì trên tạp chí Weekly Shōnen Jump, ra mắt lần đầu trên ấn bản số 34 vào ngày 19 tháng 7 năm 1997.</small>
					</div>
				</div>
			</a>   <a href="#" class="list-group-item list-group-item-action">
					<div class="row">
						<div class="col-4"><img src=" ./images/z7.png" alt="" class="img-fluid">
							<h6 class="mb-1">Pokemon</h6></div>
						<div class="col-7">
							<p class="mb-1">Pokémon hay còn được biết với tên trong tiếng Nhật là Pocket Monsters là một loạt phim hoạt hình được phát sóng trên truyền hình tại Nhật Bản từ ngày 1 tháng 4 năm 1997 trên TV Tokyo.</small>
					</div>
				</div>
			</a> <a href="#" class="list-group-item list-group-item-action">
					<div class="row">
						<div class="col-4"><img src=" ./images/z3.png" alt="" class="img-fluid">
							<h6 class="mb-1">Lạc vào khu rừng đom đóm</h6></div>
						<div class="col-7">
							<p class="mb-1">Lạc Vào Khu Rừng Đom Đóm) là bộ anime kể về một nữ sinh cấp ba luôn quét lá trên sân trường vào cuối chiều, lúc những phòng học mở toang cửa không còn học sinh.</p> <small class="text-muted">Donec id elit non mi porta.</small>
					</div>
				</div>
			</a></div>
	</div>
</div>
<br>
</div>