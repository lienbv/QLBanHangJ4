<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>

<div
	class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
	<h1 class="h2">Xác nhận đơn hàng</h1>
	<div class="btn-toolbar mb-2 ml-auto mb-md-0">
		<div class="btn-group mr-2">
			<a href="/ASMJ4/admin/Staff/create" type="button"
				class="btn btn-sm btn-outline-secondary">Thêm Staff</a>
		</div>
	</div>
</div>
<div class="col-sm-12">

	<div class="row">

		<ul class="nav nav-tabs" id="myTab" role="tablist">
			<li class="nav-item" role="presentation"><a
				class="nav-link active" id="home-tab" data-toggle="tab" href="#home"
				role="tab" aria-controls="home" aria-selected="true">Danh sách
					Nhân viên</a></li>
			<li class="nav-item" role="presentation"><a class="nav-link"
				id="profile-tab" data-toggle="tab" href="#profile" role="tab"
				aria-controls="profile" aria-selected="false">Danh sách khách
					hàng</a></li>
		</ul>
		<div class="tab-content" id="myTabContent" style="margin-right: 500px">
			<div class="tab-pane fade show active" id="home" role="tabpanel"
				aria-labelledby="home-tab">
				<table class="table table-bordered mb-5 mt-3">
					<thead>
						<tr class="text-center">

							<th>Tên</th>
							<th>User</th>
							<th>Email</th>
							<th>Số điện thoại</th>
							<th>Địa chỉ</th>
							<th>Action</th>
						</tr>

					</thead>
					<tbody>

						<c:forEach var="item" items="${list_Staff}">
							<tr>
								<td class="">${item.fullname}</td>

								<td class="">${item.username}</td>

								<td class="">${item.email}</td>

								<td class="">${item.phoneNumber}</td>

								<td class="">${item.address}</td>

								<td><a onclick="showDelete(${item.id})" type="button"
									class="btn btn-sm btn-outline-secondary"><svg
											xmlns="http://www.w3.org/2000/svg" width="16" height="16"
											fill="currentColor" class="bi bi-trash-fill"
											viewBox="0 0 16 16">
                                    <path
												d="M2.5 1a1 1 0 0 0-1 1v1a1 1 0 0 0 1 1H3v9a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V4h.5a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H10a1 1 0 0 0-1-1H7a1 1 0 0 0-1 1H2.5zm3 4a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 .5-.5zM8 5a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7A.5.5 0 0 1 8 5zm3 .5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 1 0z" />
                                </svg></a></td>
							</tr>

						</c:forEach>

					</tbody>
				</table>
			</div>
			<div class="tab-pane fade" id="profile" role="tabpanel"
				aria-labelledby="profile-tab">
				<form action="/ASMJ4/waiting_Confirm_Cancel_Controller"
					method="post">
					<table class="table table-bordered mb-5 mt-3">
						<thead>
							<tr class="text-center">

								<th>Tên</th>
								<th>User</th>
								<th>Email</th>
								<th>Số điện thoại</th>
								<th>Địa chỉ</th>
							</tr>

						</thead>
						<tbody>

							<c:forEach var="item" items="${list_Customer}">
								<tr>
									<td class="">${item.fullname}</td>

									<td class="">${item.username}</td>

									<td class="">${item.email}</td>

									<td class="">${item.phoneNumber}</td>

									<td class="">${item.address}</td>
								</tr>

							</c:forEach>

						</tbody>
					</table>
				</form>
			</div>

		</div>



	</div>

</div>
<script type="text/javascript">
	function showDelete(id) {
		var ques = confirm('Do you want to cancel?');
		if (ques == true) {

			window.location.href = '/ASMJ4/admin/Staff/delete?id='+ id;
		} else {

		}
	}
</script>


