<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>

<div class="row py-2 ">
	<div class="col-sm-12">
		<div class="row bg-white px-0 justify-content-center">
			<div class="col-sm-5">
				<label class="text-center py-sm-2" style="padding-left: 40%;">Register</label>
				<div class="alert alert-success" role="alert">
					<h4 class="alert-heading"></h4>
					<c:if test="${!empty sessionScope.success_category}">
						<p>${sessionScope.success_category }</p>
					</c:if>
					<c:remove var="success_category" scope="session" />

					<p class="mb-0"></p>
				</div>
				<form action="/ASMJ4/admin/category/store" method="post">
					<div class="form-group">
						<label for="fullname">Tên loại sản phẩm</label> <input type="text"
							class="form-control" name="fullname" id="fullname"
							aria-describedby="fullname">
						<c:if test="${!empty sessionScope.name_category}">
							<p>${sessionScope.name_category }</p>
						</c:if>
						<c:remove var="name_category" scope="session" />

					</div>
					<div class="form-group">
						<button type="submit" id="button" class="btn btn-dark col-sm-12"
							style="border: 1px solid black;">Create</button>

					</div>
				</form>

			</div>
		</div>
	</div>
</div>


