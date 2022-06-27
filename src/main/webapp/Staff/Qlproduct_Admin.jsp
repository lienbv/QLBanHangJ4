<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>

<div
	class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
	<h1 class="h2">Trang chủ</h1>
	<div class="btn-toolbar mb-2 ml-auto mb-md-0">
		<div class="btn-group mr-2">
			<a href="/ASMJ4/admin/addProduct" type="button"
				class="btn btn-sm btn-outline-secondary">Thêm sản phẩm</a>
		</div>
	</div>
</div>

<div class="col-sm-12">
	<div class="row">
		<c:forEach var="item" items="${lst_Product_Admin }">
               
			<div class="col-sm-3 py-2">
				<div class="card card-hover border-0 rounded">
					<div class="position-relative p-2">
						<div class="card-item__img"
							style="background-image: url(/ASMJ4/img/${item.img1});"></div>

						<div class="overlay">
							<div class="card-item__img2"
								style="background-image: url(/ASMJ4/img/${item.img2});"></div>
						</div>
					</div>
					<div class="row text-center mx-auto">
						<a type="button" class="btn btn-danger"
							onclick="showMess(${item.id})"> <svg
								xmlns="http://www.w3.org/2000/svg" width="16" height="16"
								fill="currentColor" class="bi bi-trash-fill" viewBox="0 0 16 16">
                                    <path
									d="M2.5 1a1 1 0 0 0-1 1v1a1 1 0 0 0 1 1H3v9a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V4h.5a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H10a1 1 0 0 0-1-1H7a1 1 0 0 0-1 1H2.5zm3 4a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 .5-.5zM8 5a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7A.5.5 0 0 1 8 5zm3 .5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 1 0z" />
                                </svg>
						</a> <a href="/ASMJ4/admin/editProduct?id=${item.id }"
							class="text-dark card-link"><i class="fas fa-pen"></i></a>

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
							<span class="mr-sm-4">Khuyến mãi ${item.promotion.percent }
								%</span>
						</div>

					</c:if>
				</div>
			</div>
		</c:forEach>

	</div>

</div>

<script type="text/javascript">
	function showMess(id) {
		var ques = confirm('Do you want to cancel?');
		if (ques == true) {

			window.location.href = '/ASMJ4/admin/deleteProduct?id='+ id;
		} else {

		}
	}
</script>







