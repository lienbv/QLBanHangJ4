<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>

<div class="row py-2 ">
	<div class="col-sm-12">

		<div class="row bg-white px-0">
			<div class="col-sm-3">
				<div class="row">
					<div class="col-sm-12">
						<div>
							<ul class="list-group mb-5">
								<c:forEach var="item" items="${lstCategory }">
									<li class="list-group-item"><a type="button"
										href="/ASMJ4/product/category?id=${item.id }">${item.name}</a></li>
								</c:forEach>
							</ul>

						</div>

						<ul class="list-group">
							<li class="list-group-item"><a href="/ASMJ4/product/price_Max">Giá từ cao nhất</a></li>
							<li class="list-group-item"><a href="/ASMJ4/product/price_Min">Giá từ thấp nhất</a></li>
							<li class="list-group-item"><a href="/ASMJ4/product/bestSaler">Sản phẩm giảm giá</a></li>
						</ul>

					</div>
				</div>

			</div>
			<div class="col-sm-9">
				<div class="row">

					<c:forEach var="item" items="${lst_Product }">

						<div class="col-sm-4 py-2">
							<div class="card card-hover border-0 rounded">
								<div class="position-relative p-2">
									<div class="card-item__img"
										style="background-image: url(/ASMJ4/img/${item.img1});">
									</div>

									<div class="overlay">
										<div class="card-item__img2"
											style="background-image: url(/ASMJ4/img/${item.img2});">
										</div>
									</div>
								</div>
								<div class="viewadd position-absolute ">
									<a href="/ASMJ4/product/edit?id=${item.id }" type="button"
										class="btn">Xem thêm</a>

								</div>

							</div>
							<div class="text-center card-contend py-2">
								<a href="#" type="button" class="name_product my-0">${item.name}</a>
								<div class="mx-auto">
									<span class="price_old mr-sm-4">350000</span> <span
										class="price_new">${item.price}</span>
								</div>
								<c:if test="${item.promotion.percent==0 }">

								</c:if>
								<c:if test="${item.promotion.percent !=0 }">
									<div class="mx-auto">
										<span class="mr-sm-4">Khuyến mãi
											${item.promotion.percent } %</span>
									</div>

								</c:if>
							</div>
						</div>
					</c:forEach>



				</div>

			</div>



		</div>

	</div>
</div>

<div class="row justify-content-center">
	<nav aria-label="Page navigation example">
		<ul class="pagination">
			<li class="page-item"><a class="page-link" href="#"
				aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
			</a></li>
			<li class="page-item"><a class="page-link" href="#">1</a></li>
			<li class="page-item"><a class="page-link" href="#">2</a></li>
			<li class="page-item"><a class="page-link" href="#">3</a></li>
			<li class="page-item"><a class="page-link" href="#"
				aria-label="Next"> <span aria-hidden="true">&raquo;</span>
			</a></li>
		</ul>
	</nav>
</div>