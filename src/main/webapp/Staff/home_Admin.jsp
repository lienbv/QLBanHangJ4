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
<link rel="stylesheet" href="/ASMJ4/css/admin.css">
<link rel="stylesheet" href="/ASMJ4/css/layout.css">
</head>
<body>

	<nav
		class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
		<a class="navbar-brand col-md-3 col-lg-2 mr-0 px-3" href="/ASMJ4/admin/home_admin">Vibee</a>
		<button class="navbar-toggler position-absolute d-md-none collapsed"
			type="button" data-toggle="collapse" data-target="#sidebarMenu"
			aria-controls="sidebarMenu" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<input class="form-control form-control-dark w-100" type="text"
			placeholder="Search" aria-label="Search">

			<div class="nav-item dropdown">
								<c:if test="${sessionScope.acountStaff != null}">
									<a class="nav-link dropdown-toggle text-white" href=""
										id="userDropdown" data-toggle="dropdown" aria-haspopup="true"
										aria-expanded="false"> <i class="fas fa-user"></i>${sessionScope.acountStaff.fullname }
									</a>
									<div
										class="dropdown-menu dropdown-menu-right dropdown-secondary dropdown-responsive"
										aria-labelledby="userDropdown">
										<a class="dropdown-item" href="/ASMJ4/profile_Infor/index">Thông tin cá nhân</a>
										 <a class="dropdown-item" href="/ASMJ4/logout">Đăng xuất</a>

									</div>
								</c:if>
								<c:if test="${sessionScope.acountStaff == null}">
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

	</nav>

	<div class="container-fluid">
		<div class="row">
			<nav id="sidebarMenu"
				class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
				<div class="sidebar-sticky pt-3">
					<ul class="nav flex-column">
						<li class="nav-item"><a class="nav-link active" href="#">
								<span data-feather="home"></span> Trang chủ <span
								class="sr-only">(current)</span>
						</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/ASMJ4/admin/List_Customer_Order/index"> <span
								data-feather="shopping-cart"></span> Danh sách mua hàng <span
								class="badge badge-danger rounded-pill">
								${count}
								</span>
						</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/ASMJ4/admin/waiting_Confirm_Cancel_Controller/index">
								<span data-feather="users"></span> Tình trạng hàng
						</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/ASMJ4/admin/Staff/index">
								<span data-feather="users"></span> Quản lí Staff-Customer
						</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/ASMJ4/admin/category/index">
								<span data-feather="users"></span> Quản lí loại sản phẩm
						</a></li>
					</ul>
				</div>
			</nav>

			<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
				<jsp:include page="${viewAdmin}"></jsp:include>
			</main>
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

</body>
</html>