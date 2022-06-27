<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>



<ul class="nav nav-tabs" id="myTab" role="tablist">
	<li class="nav-item" role="presentation"><a
		class="nav-link active" id="home-tab" data-toggle="tab" href="#home"
		role="tab" aria-controls="home" aria-selected="true">Chưa xác nhận</a></li>
	<li class="nav-item" role="presentation"><a class="nav-link"
		id="profile-tab" data-toggle="tab" href="#profile" role="tab"
		aria-controls="profile" aria-selected="false">Đã xác nhận</a></li>
	<li class="nav-item" role="presentation"><a class="nav-link"
		id="contact-tab" data-toggle="tab" href="#contact" role="tab"
		aria-controls="contact" aria-selected="false">Đã hủy</a></li>
</ul>
<div class="tab-content" id="myTabContent">
	<div class="tab-pane fade show active" id="home" role="tabpanel"
		aria-labelledby="home-tab">
		<form action="/ASMJ4/waiting_Confirm_Cancel_Controller" method="post">

			<table class="table table-bordered mb-5 mt-3">
				<thead>
					<tr class="text-center">
						<th>Img</th>
						<th>Tên sản phẩm</th>
						<th>Số lượng</th>
						<th>Giá tiền</th>
						<th>Hủy đơn hàng</th>
					</tr>

				</thead>
				<tbody>

					<c:forEach var="item" items="${listOrder_Waiting}">
						<tr>
							<td class="w-50"><img
								src="/ASMJ4/img/${item.getProduct().getImg1() }"
								class="rounded w-50 h-50 px-sm-1" alt=""></td>

							<td class="">${item.getProduct().getName() }</td>

							<td class="">${item.getAmount()}</td>

							<td class="">${item.getTotal()}</td>

							<td><button type="submit" class="btn btn-danger"
									onclick="showMess(${item.getId()})">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-trash-fill"
										viewBox="0 0 16 16">
                                    <path
											d="M2.5 1a1 1 0 0 0-1 1v1a1 1 0 0 0 1 1H3v9a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V4h.5a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H10a1 1 0 0 0-1-1H7a1 1 0 0 0-1 1H2.5zm3 4a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 .5-.5zM8 5a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7A.5.5 0 0 1 8 5zm3 .5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 1 0z" />
                                </svg>
								</button></td>
						</tr>

					</c:forEach>

				</tbody>
			</table>
		</form>
	</div>
	<div class="tab-pane fade" id="profile" role="tabpanel"
		aria-labelledby="profile-tab">
		<table class="table table-bordered mb-5 mt-3">
			<thead>
				<tr class="text-center">
					<th>Img</th>
					<th>Tên sản phẩm</th>
					<th>Số lượng</th>
					<th>Giá tiền</th>
				</tr>

			</thead>
			<tbody>

				<c:forEach var="item" items="${listOrder_Confirm}">
					<tr>
						<td class="w-50"><img
							src="/ASMJ4/img/${item.getProduct().getImg1() }"
							class="rounded w-50 h-50 px-sm-1" alt=""></td>

						<td class="">${item.getProduct().getName() }</td>

						<td class="">${item.getAmount()}</td>

						<td class="">${item.getTotal()}</td>


					</tr>

				</c:forEach>

			</tbody>
		</table>
	</div>
	<div class="tab-pane fade" id="contact" role="tabpanel"
		aria-labelledby="contact-tab">
		<table class="table table-bordered mb-5 mt-3">
			<thead>
				<tr class="text-center">
					<th>Img</th>
					<th>Tên sản phẩm</th>
					<th>Số lượng</th>
					<th>Giá tiền</th>
				</tr>

			</thead>
			<tbody>

				<c:forEach var="item" items="${listOrder_Cancel}">
					<tr>
						<td class="w-50"><img
							src="/ASMJ4/img/${item.getProduct().getImg1() }"
							class="rounded w-50 h-50 px-sm-1" alt=""></td>

						<td class="">${item.getProduct().getName() }</td>

						<td class="">${item.getAmount()}</td>

						<td class="">${item.getTotal()}</td>


					</tr>

				</c:forEach>

			</tbody>
		</table>
	</div>
</div>


<script type="text/javascript">
	function showMess(id) {
		var ques = confirm('Do you want to cancel?');
		if (ques == true) {

			window.location.href = '/ASMJ4/waiting_Confirm_Cancel_Controller/cancel?id='
					+ id;
		} else {

		}
	}
</script>
