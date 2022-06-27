<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>

<div class="col-sm-8 mx-auto border border-dark my-3 rounded">
	<h3 class="my-5 text-center">Thêm sản phẩm</h3>
	<form action="/ASMJ4/admin/addProduct" class="mb-3" method="post"
		enctype="multipart/form-data">
		<div class="row">
			<div class="col-sm-12">
				<div class="row">
					<div class="col-sm-6">

						<div class="mb-3">
							<label for="exampleInputImg" class="form-label">Chọn ảnh</label>
							<input type="file" name="img1" class="form-control"
								id="exampleInputImg1" onchange="return fileValid()"
								accept="image/png, image/gif, image/jpeg, imge/webp" /> <label
								for="" class="error"></label>
						</div>

					</div>
					<div class="col-sm-6">

						<div class="mb-3">
							<label for="exampleInputImg" class="form-label">Chọn ảnh</label>
							<input type="file" name="img2" class="form-control"
								id="exampleInputImg2" onchange="return fileValid2()"
								accept="image/png, image/gif, image/jpeg, image/webp " /> <label
								for="" class="error"></label>
						</div>
					</div>

				</div>

			</div>
		</div>
		<div class="mb-3">
			<label for="exampleInputTitle" class="form-label">Tên sản
				phẩm</label> <input required type="text" name="name" class="form-control"
				id="exampleInputTitle" aria-describedby="emailHelp"> <label
				for="" class="error" style="color: red;"></label>
		</div>
		<div class="mb-3">
			<label for="exampleInputTitle" class="form-label">Giá sản
				phẩm</label> <input min="1000" required type="number" name="gia" class="form-control"
				id="exampleInputTitle" aria-describedby="emailHelp"> <label
				for="" class="error" style="color: red;"></label>
				<c:if test="${!empty sessionScope.gia}">
				<p>${sessionScope.gia }</p>
			</c:if>
			<c:remove var="gia" scope="session" />
		</div>
		<div class="mb-3">
			<label for="sl" class="form-label">Số lượng </label> <input required
				type="number" name="amount" min="1" max="1000" class="form-control"
				id="sl" aria-describedby="emailHelp"> <label for=""
				class="error" style="color: red;"></label>
			<c:if test="${!empty sessionScope.soluong}">
				<p>${sessionScope.soluong }</p>
			</c:if>
			<c:remove var="soluong" scope="session" />
		</div>
		<div class="mb-3">
			<label for="mota" class="form-label">Mô tả </label> <input required
				type="text" name="mota" class="form-control" id="mota"
				aria-describedby="emailHelp"> <label for="" class="error"
				style="color: red;"></label>
		</div>
		<div class="form-group mb-3">
			<label for="inputState">Loại hàng</label> <select name="category"
				id="inputState" class="form-control">
				<c:forEach var="o" items="${listCC }">
					<option value="${o.id }">${o.name }</option>
				</c:forEach>
			</select>
		</div>
		<div class="form-group mb-3">
			<label for="inputState">Khuyến mãi</label> <select id="inputState"
				name="promotion" class="form-control">
				<c:forEach var="o" items="${listPromotion }">
					<option value="${o.getId() }">${o.getPercent()}</option>
				</c:forEach>
			</select>
		</div>
		<div class="form-group mb-3">
			<label for="inputState">Size</label> <select id="inputState"
				name="size" class="form-control">
				<option value="S" selected="selected">S</option>
				<option value="M">M</option>
				<option value="L">L</option>
				<option value="Xl">XL</option>
			</select>
		</div>
		<div class="form-group mb-3">
			<label for="color">Color</label> <select id="color" name="color"
				class="form-control">
				<option value="white" selected="selected">White</option>
				<option value="yellow">Yellow</option>
				<option value="black">Black</option>
				<option value="gray">Gray</option>
			</select>
		</div>

		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
</div>

<script>
	function fileValid() {
		var fileInput = document.getElementById('exampleInputImg1');
		var filePath = fileInput.value;
		var allowedExtendsion = /(\.png|\.jpeg|\.jpg)$/i;

		if (!allowedExtendsion.exec(filePath)) {
			alert("Vui lòng nhập định dạng ảnh .png, .jpge, .jpg");
			document.getElementById('exampleInputImg1').style.borderColor = "red";
			fileInput.value = '';
			return false;
		} else {
			document.getElementById('exampleInputImg1').style.borderColor = "green";
			loadFile();
		}
	}
	function fileValid2() {
		var fileInput = document.getElementById('exampleInputImg2');
		var filePath = fileInput.value;
		var allowedExtendsion = /(\.png|\.jpeg|\.jpg)$/i;

		if (!allowedExtendsion.exec(filePath)) {
			alert("Vui lòng nhập định dạng ảnh .png, .jpge, .jpg");
			document.getElementById('exampleInputImg2').style.borderColor = "red";
			fileInput.value = '';
			return false;
		} else {
			document.getElementById('exampleInputImg2').style.borderColor = "green";
			loadFile();
		}
	}

	function loadFile() {
		var output = document.getElementById('output');
		output.src = URL.createObjectURL(event.target.files[0]);
		output.onload = function() {
			URL.revokeObjectURL(output.src)
		}
	};
</script>

