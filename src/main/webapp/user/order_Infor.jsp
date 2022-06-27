<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>

<div class="row ">
	<div class="col-sm-12 ">

		<div class="row px-0">

			<div class="col-sm-7 py-sm-4 border-right"
				style="background-color: FFFFFF;">
				<h4 style="color: rgb(10, 10, 10);">VIBEE</h4>
				<p>Thông tin giao hàng</p>


				<div class="form-group">
					<label for="fullname">Fullname</label> <input name="fullname"
						value="${customer.fullname }" type="text" class="form-control"
						id="fullname">

				</div>
				<div class="form-group">
					<label for="email">Email</label> <input name="txtEmail"
						value="${customer.email }" type="email" class="form-control"
						minlength="4" id="email" aria-describedby="emailHelp">

				</div>
				<div class="form-group">
					<label for="address">Address</label> <input name="address"
						value="${customer.address }" type="text" class="form-control"
						id="address" aria-describedby="address">

				</div>
				<div class="form-group">
					<label for="phone">Phone number</label> <input name="phone"
						value="${customer.phoneNumber }" type="text" class="form-control"
						id="phone" aria-describedby="phone">

				</div>
				<div class="form-group">
					<label for="ship">Phương thức vận chuyển</label>
					<div class="form-check  py-sm-2 border rounded pl-sm-5">
						<input class="form-check-input" type="radio" name="exampleRadios"
							id="exampleRadios1" value="option1" checked> <label
							class="form-check-label" for="exampleRadios1"> Delivery </label>
					</div>

				</div>

				<div class="form-group">
					<label for="pay">Phương thức thanh toán</label>
					<div class="form-check py-sm-2 border rounded pl-sm-5">
						<input class="form-check-input" type="radio" name="exampleRadios1"
							id="exampleRadios2" value="option2" checked> <label
							class="form-check-label" for="exampleRadios2"> Thanh toán
							khi nhận hàng </label>
					</div>

				</div>
				<form action="/ASMJ4/order_Infor/show" method="post" name=""
					class="">
					<div class="form-group pt-sm-2">
						<button type="submit" class="btn btn-dark ">Hoàn tất hóa
							đơn</button>
					</div>

				</form>
				<a href="/ASMJ4/product_Detail/cart" class="text-dark">Giỏ
					hàng</a>

			</div>
			<div class="col-sm-5"
				style="background-color: rgba(243, 243, 243, 0.726);">
		<!-- 		<form action="/ASMJ4/order_Infor/cart"> -->
							<c:forEach var="item" items="${sessionScope.listCart }">
					<div class="row">
						<div class="col-sm-12">
								<div class="row border-bottom">
									<div class="col-sm-8 pt-sm-4 pb-sm-2">
										<div class="row">
											<div class="col-sm-12 ">
												<div class="row">
													<div class="col-sm-4 pt-sm-3  pb-sm-2 pr-sm-5">
														<img
															src="/ASMJ4/img/${item.value.getProduct().getImg1() }"
															style="width: 100%; height: 100%;" alt="">

													</div>
													<div class="col-sm-6  pb-sm-2 pt-sm-4">
														<p>${item.value.getProduct().getName() }</p>

													</div>
													<div class="col-sm-2  pb-sm-2 pt-sm-4">
														<p>${item.value.getAmount() }</p>

													</div>
												</div>
											</div>
										</div>
									</div>
									<div class="col-sm-4 pb-sm-2 pt-sm-4">
										<p class=" pb-sm-2 pt-sm-4">${item.value.total() }</p>
									</div>
								</div>

							
						</div>

					</div>

					</c:forEach>

					<div class="row">
						<div class="col-sm-12">
							<div class="row border-bottom">
								<div class="col-sm-8 pt-sm-4 pb-sm-2">
									<p>Tạm tính</p>
									<p>Phí vận chuyển </p>
								</div>
								<div class="col-sm-4  pt-sm-4 pb-sm-2">
									<p>${sessionScope.sumTT}</p>
									<p>40.000</p>
								</div>
							</div>
						</div>

					</div>
					<div class="row">
						<div class="col-sm-12">
							<div class="row border-bottom">
								<div class="col-sm-8 pt-sm-4 pb-sm-2">
									<h5>Tổng</h5>
								</div>
								<c:if test="${sessionScope.sumTT >= 1000000 }">
								<div class="col-sm-4  pt-sm-4 pb-sm-2">
									<h5>${sessionScope.sumTT }</h5>
								</div>
								
								</c:if>
								<c:if test="${sessionScope.sumTT < 1000000 }">
								<div class="col-sm-4  pt-sm-4 pb-sm-2">
									<h5>${sessionScope.TongTT }</h5>
								</div>
								
								</c:if>
							</div>
						</div>

					</div>
			</div>
		</div>

	</div>
</div>

