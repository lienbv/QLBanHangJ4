<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>

<div
	class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
	<h1 class="h2">Xác nhận đơn hàng</h1>
	<div class="btn-toolbar mb-2 ml-auto mb-md-0">
		<div class="btn-group mr-2"></div>
	</div>
</div>
<div class="col-sm-12">

	<div class="row">

		<ul class="nav nav-tabs" id="myTab" role="tablist">
			<li class="nav-item" role="presentation"><a
				class="nav-link active" id="home-tab" data-toggle="tab" href="#home"
				role="tab" aria-controls="home" aria-selected="true">Danh sách
					chưa xác nhận</a></li>
			<li class="nav-item" role="presentation"><a class="nav-link"
				id="profile-tab" data-toggle="tab" href="#profile" role="tab"
				aria-controls="profile" aria-selected="false">Danh sách đã xác
					nhận</a></li>
			<li class="nav-item" role="presentation"><a class="nav-link"
				id="contact-tab" data-toggle="tab" href="#contact" role="tab"
				aria-controls="contact" aria-selected="false">Danh sách đã hủy</a></li>
		</ul>
		<div class="tab-content" id="myTabContent" style="margin-right: 500px">
			<div class="tab-pane fade show active" id="home" role="tabpanel"
				aria-labelledby="home-tab">
					<table class="table table-bordered mb-5 mt-3">
						<thead>
							<tr class="text-center">

								<th>Id</th>
								<th>Tên sản phẩm</th>
								<th>Số lượng</th>
								<th>Giá tiền</th>
								<th>Hủy đơn hàng</th>
								<th>Xác nhận đơn hàng</th>
								<th>Xem chi tiết</th>
							</tr>

						</thead>
						<tbody>

							<c:forEach var="item" items="${listOrder_Waiting}">
								<tr>
									<td class="">${item.getProduct().getId() }</td>

									<td class="">${item.getProduct().getName() }</td>

									<td class="">${item.getAmount()}</td>

									<td class="">${item.getTotal()}</td>

									<td><button type="submit" class="btn btn-danger"
											onclick="showMess(${item.getId()})">
											<svg xmlns="http://www.w3.org/2000/svg" width="16"
												height="16" fill="currentColor" class="bi bi-trash-fill"
												viewBox="0 0 16 16">
                                    <path
													d="M2.5 1a1 1 0 0 0-1 1v1a1 1 0 0 0 1 1H3v9a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V4h.5a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H10a1 1 0 0 0-1-1H7a1 1 0 0 0-1 1H2.5zm3 4a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 .5-.5zM8 5a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7A.5.5 0 0 1 8 5zm3 .5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 1 0z" />
                                </svg>
										</button></td>
									<td>
										<form method="post"
											action="/ASMJ4/admin/List_Customer_Order/update?id=${item.id }&&id_product=${item.product.id}">
											<button type="submit"
												class="btn btn-sm btn-outline-secondary">Xác nhận
												đơn hàng</button>
										</form>
									</td>
									<td><a href="" type="button"
										class="btn btn-sm btn-outline-secondary">Xem chi tiết</a></td>
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

								<th>Id</th>
								<th>Tên sản phẩm</th>
								<th>Số lượng</th>
								<th>Giá tiền</th>
								<th>Xem chi tiết</th>
							</tr>

						</thead>
						<tbody>

							<c:forEach var="item" items="${listOrder_Confirm}">
								<tr>
									<td class="">${item.getProduct().getId() }</td>

									<td class="">${item.getProduct().getName() }</td>

									<td class="">${item.getAmount()}</td>

									<td class="">${item.getTotal()}</td>

									<td><a href="" type="button"
										class="btn btn-sm btn-outline-secondary">Xem chi tiết</a></td>
								</tr>

							</c:forEach>

						</tbody>
					</table>
				</form>
			</div>

			<div class="tab-pane fade" id="contact" role="tabpanel"
				aria-labelledby="contact-tab">
				<form action="/ASMJ4/waiting_Confirm_Cancel_Controller"
					method="post">

					<table class="table table-bordered mb-5 mt-3 ">
						<thead>
							<tr class="text-center">

								<th>Id</th>
								<th>Tên sản phẩm</th>
								<th>Số lượng</th>
								<th>Giá tiền</th>
							</tr>

						</thead>
						<tbody>

							<c:forEach var="item" items="${listOrder_Cancel}">
								<tr>
									<td class="">${item.getProduct().getId() }</td>

									<td class="">${item.getProduct().getName() }</td>

									<td class="">${item.getAmount()}</td>

									<td class="">${item.getTotal()}</td>

								</tr>

							</c:forEach>

						</tbody>
					</table>
				</form>
			</div>

		</div>



	</div>

</div>