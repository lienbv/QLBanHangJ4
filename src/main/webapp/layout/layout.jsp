<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="/ASMJ4/fonts/fontawesome-free-5.15.4-web/css/all.min.css">
<link rel="stylesheet" href="/ASMJ4/css/layout.css">
</head>
<body>
	<div class="container-fluid ">
		<nav
			class="navbar navbar-expand-sm navbar-dark fixed-top bg-dark flex-md-nowrap px-0 shadow">
			<div class="container">
				<a class="navbar-brand" href="/ASMJ4/home">VIBEE</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarsExample07" aria-controls="navbarsExample07"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarsExample07">
					<form class="form-inline my-2 my-md-0 ">
						<input class="form-control type=" text" placeholder="Search"
							aria-label="Search">
					</form>
					<ul class="navbar-nav ml-auto">
						<li class="nav-item active"><a class="nav-link"
							href="/ASMJ4/home"> <i class="fas fa-house-damage"
								aria-hidden="true"></i> <span class="sr-only">(current)</span>
						</a></li>
						<li class="nav-item dropdown">
							<a class="nav-link"
							href="/ASMJ4/product/index"> <i class="fas fa-house-damage"
								aria-hidden="true"></i> <span class="sr-only">(current)</span>
						</a>
						</li>
						<li class="nav-item"><a class="nav-link"
							href="/ASMJ4/product_Detail/cart"><i
								class="fa fa-cart-plus" aria-hidden="true"></i></a></li>


						<li class="nav-item dropdown">
							<div class="nav-item dropdown">
								<c:if test="${sessionScope.acountKH != null}">
									<a class="nav-link dropdown-toggle text-white" href=""
										id="userDropdown" data-toggle="dropdown" aria-haspopup="true"
										aria-expanded="false"> <i class="fas fa-user"></i>${sessionScope.acountKH.fullname }
									</a>
									<div
										class="dropdown-menu dropdown-menu-right dropdown-secondary dropdown-responsive"
										aria-labelledby="userDropdown">
										<a class="dropdown-item" href="/ASMJ4/profile_Infor/index">Thông tin cá nhân</a> <a
											class="dropdown-item"
											href="/ASMJ4/waiting_Confirm_Cancel_Controller">Thông
											tin đặt hàng</a> <a class="dropdown-item" href="/ASMJ4/logout">Đăng xuất</a>

									</div>
								</c:if>
								<c:if test="${sessionScope.acountKH == null}">
									<a class="nav-link dropdown-toggle text-white" href=""
										id="userDropdown" data-toggle="dropdown" aria-haspopup="true"
										aria-expanded="false"> <i class="fas fa-user"></i> Tài
										khoản
									</a>
									<div
										class="dropdown-menu dropdown-menu-right dropdown-secondary dropdown-responsive"
										aria-labelledby="userDropdown">
										<a class="dropdown-item" href="/ASMJ4/user/login">Đăng
											nhập</a>

									</div>
								</c:if>
							</div>
						</li>
					</ul>

				</div>

			</div>
		</nav>

		<div class="container px-0">
			<div class="row py-sm-2">
				<div class="col-sm-12 ">
					<div class="row pl-0 pt-sm-5">
						<div class="col-sm-8 pr-1 pl-0">
							<div id="carouselExampleIndicators" class="carousel slide"
								data-ride="carousel">
								<ol class="carousel-indicators">
									<li data-target="#carouselExampleIndicators" data-slide-to="0"
										class="active"></li>
									<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
									<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
								</ol>
								<div class="carousel-inner">
									<div class="carousel-item active">
										<img
											src="/ASMJ4/img/0523158452a3e8ba309588cdf95d9357.png.webp"
											class="d-block w-100 " alt="...">
									</div>
									<div class="carousel-item">
										<img
											src="/ASMJ4/img/59785fc7d7303bd465ec34bf12f21638.png.webp"
											class="d-block w-100" alt="...">
									</div>
									<div class="carousel-item">
										<img
											src="/ASMJ4/img/950f7b17402baed2cd7511ed7e5136bf.png.webp"
											class="d-block w-100" alt="...">
									</div>
								</div>
								<button class="carousel-control-prev" type="button"
									style="border: none; background-color: transparent;"
									data-target="#carouselExampleIndicators" data-slide="prev">
									<span class="carousel-control-prev-icon" aria-hidden="true"></span>
									<span class="sr-only">Previous</span>
								</button>
								<button class="carousel-control-next" type="button"
									style="border: none; background-color: transparent;"
									data-target="#carouselExampleIndicators" data-slide="next">
									<span class="carousel-control-next-icon" aria-hidden="true"></span>
									<span class="sr-only">Next</span>
								</button>
							</div>
						</div>
						<div class="col-sm-4  pl-1 py-0 pr-0">
							<img
								src="/ASMJ4/img/060951ff0fb2bf617ab8cb2b814984bc.png.webp"
								class="d-block w-100 h-100 " alt="...">
						</div>

					</div>

				</div>

			</div>

			<jsp:include page="${view}"></jsp:include>

		</div>
		<!-- Footer -->
		<div class="row bg-dark py-5">
			<div class="col-sm-12">
				<div class="container justify-content-center ">
					<div class="row ">
						<div class="col-sm-3 text-white py-2">
							<p>Danh muc</p>
							<p>Tim kiem</p>
							<p>Chinh sach doi tra</p>
							<p>Chinh sach bao han</p>
						</div>
						<div class="col-sm-3 text-white py-2">
							<p>Danh muc</p>
							<p>Tim kiem</p>
							<p>Chinh sach doi tra</p>
							<p>Chinh sach bao han</p>
						</div>
						<div class="col-sm-3 text-white py-2">
							<p>Danh muc</p>
							<p>Tim kiem</p>
							<p>Chinh sach doi tra</p>
							<p>Chinh sach bao han</p>
						</div>
						<div class="col-sm-3 text-white py-2">
							<p>Danh muc</p>
							<p>Tim kiem</p>
							<p>Chinh sach doi tra</p>
							<p>Chinh sach bao han</p>
						</div>
					</div>

				</div>
			</div>
		</div>

	</div>

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
		<script type="text/javascript"
    src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/11.4.2/sweetalert2.all.min.js"></script>
   <script type="text/javascript" src="/ASMJ4/js/register.js"></script>

</body>
</html>