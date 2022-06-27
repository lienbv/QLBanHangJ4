<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>

<div class="row no-gutters">
	<div class="col-md-5 card-hover">
		<div class="card-item__img-modal"
			style="background-image: url(/ASMJ4/img/${product.img1});"></div>
		<div class="overlay">
			<div class="card-item__img2-modal"
				style="background-image: url(/ASMJ4/img/${product.img2});"></div>
		</div>
	</div>
	<div class="col-md-7">
		<form action="/ASMJ4/product_Detail/add_To_Cart?id=${product.id}"
			method="post">
			<div class="card-body" style="border-radius: 0px;">

				<h5 class="card-title">${product.name }</h5>
				<h6>350.000</h6>
				<p class="card-text">${product.description}</p>
				<p class="card-text">Số lượng còn hàng: ${product.amount}</p>

				<p class="card-text">Màu sắc: ${product.color}</p>
				<c:if test="${product.promotion.percent==0 }">

				</c:if>
				<c:if test="${product.promotion.percent!=0 }">
					<p class="card-text">Khuyến mãi: ${product.promotion.percent} %</p>

				</c:if>
			<%-- 	<c:if test="${product.amount > 0 }"> --%>
					<p class="card-text">
						<button type="submit" class="btn btn-dark">Add cart</button>
					</p>
	<%-- 			</c:if> --%>
			<%-- 	<c:if test="${product.amount = 0 }">
					<span>Sản phẩm này đã hết hàng</span>
					<p class="card-text">
						<button type="submit" disabled="disabled" class="btn btn-dark">Add
							cart</button>
					</p>
				</c:if> --%>

			</div>
	</div>

	</form>
</div>