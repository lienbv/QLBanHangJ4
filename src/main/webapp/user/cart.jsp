<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>

<div class="row py-2 ">
	<div class="col-sm-12">
		<h4 style="color: rgb(75, 73, 72);">Cart</h4>
		<div class="row bg-white px-0">

			<div class="col-sm-8 py-2">
				<c:if test="${!empty sessionScope.error}">
					<p>${sessionScope.error }</p>
				</c:if>
				<c:remove var="error" scope="session" />
				<c:if test="${!empty sessionScope.message}">
					<p>${sessionScope.message }</p>
				</c:if>
				<c:remove var="message" scope="session" />


				<c:if test="${ !empty sessionScope.listCart}">
					<table class="table table-white">
						<thead>
							<tr>
								<th scope="col">Img</th>
								<th scope="col">Product Name</th>
								<th scope="col">Total money</th>
								<th scope="col ml-1">Amount</th>
								<th scope="col">Action</th>

								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${sessionScope.listCart }">
								<tr>
									<td class="w-50"><img
										src="/ASMJ4/img/${item.value.getProduct().getImg1() } "
										class="rounded w-50 h-50 px-sm-1" alt=""></td>

									<td class="align-items-center pt-sm-5">${item.value.getProduct().getName() }</td>


									<td class="align-items-center pt-sm-5">${item.value.getProduct().getPrice() }</td>

									<!-- <td class="align-items-center pt-sm-5"> -->
									<form
										action="/ASMJ4/product_Detail/update_To_Cart?id=${item.key }"
										method="post">
										<td class="align-items-center pt-sm-5 row"><input
											type="number" name="amount"
											value="${item.value.getAmount() }" min="0" max=""></td>
										<td class="align-items-center pt-sm-5 row">
											<button type="submit" class="btn btn-danger">Update</button>
										</td>

									</form>
									<!-- </td> -->
									<td class="align-items-center pt-sm-5"><a type="button"
										class="btn btn-danger" href="/ASMJ4/product_Detail/delete_To_Cart?id=${item.key }">
									</a></td>


								</tr>



							</c:forEach>

							<div class="row mx-auto my-auto justify-content-center">


								<a href="/ASMJ4/home" class="btn btn-dark rounded-pill ">Continue
									shopping</a>
							</div>
						</tbody>
					</table>
				</c:if>

				<c:if test="${empty sessionScope.listCart}">

					<div class="row py-2">
						<div class="col-sm-12">

							<div class="row mx-auto justify-content-center">
								<img src="/ASMJ4/img/empty_cart.webp" class="" alt="">
							</div>
							<h5 class="text-center py-sm-3"
								style="color: rgb(171, 172, 173);">Không có sản phẩm nào
								trong giỏ hàng của bạn</h5>
							<div class="row mx-auto justify-content-center">
								<a href="/ASMJ4/home" class="btn btn-dark rounded-pill ">Continue
									shopping</a>
							</div>
						</div>

					</div>
				</c:if>


			</div>

			<div class="col-sm-4">

				<div class="card">
					<div class="card-header d-flex justify-content-between">
						<span>Total money</span> <span>${sessionScope.sum} VNĐ</span>
					</div>
					<div class="card-body mx-auto">
						<a href="/ASMJ4/order_Infor/show"
							class="btn btn-dark rounded-pill">PAY</a>
					</div>
				</div>
			</div>

		</div>


	</div>
</div>
<script type="text/javascript">
	function showMess(id) {
		var ques = confirm('Do you want to delete?');
		if (ques == true) {
        window.location.href= '/ASMJ4/product_Detail/delete_To_Cart?id='+id;
		} else {

		}
	}

</script>