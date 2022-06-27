<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>

<div class="col-sm-8 mx-auto border border-dark my-3 rounded">
	<h3 class="my-5 text-center">Chỉnh sửa sản phẩm</h3>
	<form action="/ASMJ4/admin/updateProduct?id=${product.id}" class="mb-3"
		method="post" enctype="multipart/form-data">
		<div class="row">
			<div class="col-sm-12">
				<div class="row">
					<div class="col-sm-6">

						<div class="mb-3">
							<input type="image" src="/ASMJ4/img/${product.img1 }"
								value="${product.img1}" style="width: 230px; height: 200px;"
								class="form-control" id="exampleImg">
						</div>
						<div class="mb-3">
							<label for="exampleInputImg" class="form-label">Chọn ảnh</label>
							<input type="file" value="${product.img1}" name="img1"
								class="form-control" id="exampleInputImg"
								onchange="return fileValid()"
								accept="img/png, img/gif, img/jpeg, img/webp" /> <label for=""
								class="error"></label>
						</div>

					</div>
					<div class="col-sm-6">

						<div class="mb-3">
							<input type="image" src="/ASMJ4/img/${product.img2}"
								value="${product.img2 }" style="width: 230px; height: 200px;"
								class="form-control" id="exampleImg">
						</div>
						<div class="mb-3">
							<label for="exampleInputImg" class="form-label">Chọn ảnh</label>
							<input type="file" value="${product.img2 }" name="img2"
								class="form-control" id="exampleInputImg2"
								onchange="return fileValid2()"
								accept="img/png, img/gif, img/jpeg, img/webp " /> <label for=""
								class="error"></label>
						</div>
					</div>

				</div>

			</div>
		</div>
		<div class="mb-3">
			<label for="exampleInputTitle" class="form-label">Tên sản
				phẩm</label> <input required type="text" value="${product.name }"
				name="name" class="form-control" id="exampleInputTitle"
				aria-describedby="emailHelp"> <label for="" class="error"
				style="color: red;"></label>
		</div>
		<div class="mb-3">
			<label for="exampleInputTitle" class="form-label">Giá sản
				phẩm</label> <input required type="text" name="gia" value="${product.price}"
				class="form-control" id="exampleInputTitle"
				aria-describedby="emailHelp"> <label for="" class="error"
				style="color: red;"></label>
		</div>
		<div class="mb-3">
			<label for="sl" class="form-label">Số lượng </label> <input required
				type="text" name="amount" value="${product.amount}"
				class="form-control" id="sl" aria-describedby="emailHelp"> <label
				for="" class="error" style="color: red;"></label>
		</div>
		<div class="mb-3">
			<label for="mota" class="form-label">Mô tả </label> <input required
				type="text" name="mota" value="${product.description}"
				class="form-control" id="mota" aria-describedby="emailHelp">
			<label for="" class="error" style="color: red;"></label>
		</div>
		<div class="form-group mb-3">
			<label for="inputState">Loại hàng</label> <select name="category"
				id="inputState" class="form-control">
				<c:forEach var="o" items="${listCC }">
					<option value="${o.id }"
						<c:if test="${o.name == product.category.name}">selected="selected"</c:if>>
						${o.name }</option>
				</c:forEach>
			</select>
		</div>
		<div class="form-group mb-3">
			<label for="inputState">Khuyến mãi</label> <select id="inputState"
				name="promotion" class="form-control">
				<c:forEach var="o" items="${listPromotion }">
					<option value="${o.id }"
						<c:if test="${o.percent == product.promotion.percent}">selected="selected"</c:if>>
						${o.percent }</option>
				</c:forEach>
			</select>
		</div>
		<div class="form-group mb-3">
			<label for="inputState">Size</label> <select id="inputState"
				name="size" class="form-control">
				<c:if test="${product.size == 'S' }">
					<option value="S" selected="selected">S</option>
					<option value="M">M</option>
					<option value="L">L</option>
					<option value="Xl">XL</option>
				</c:if>
				<c:if test="${product.size == 'M' }">
					<option value="S">S</option>
					<option value="M" selected="selected">M</option>
					<option value="L">L</option>
					<option value="Xl">XL</option>
				</c:if>
				<c:if test="${product.size == 'L' }">
					<option value="S">S</option>
					<option value="M">M</option>
					<option value="L" selected="selected">L</option>
					<option value="Xl">XL</option>
				</c:if>
				<c:if test="${product.size == 'XL' }">
					<option value="S">S</option>
					<option value="M">M</option>
					<option value="L">L</option>
					<option value="Xl" selected="selected">XL</option>
				</c:if>

			</select>
		</div>
		<div class="mb-3">
			<label for="promotion" class="form-label">Giá sản phẩm sau
				khuyến mãi</label> <input required type="text"
				value="${product.giaPromotion()}" class="form-control"
				id="promotion" aria-describedby="emailHelp"> <label for=""
				class="error" style="color: red;"></label>
		</div>

		<div class="mb-3">
			<label for="color">Color</label> <select id="color" name="color"
				class="form-control">
				<c:if test="${product.color == 'white' }">
					<option value="white" selected="selected">White</option>
					<option value="yellow">Yellow</option>
					<option value="black">Black</option>
					<option value="gray">Gray</option>

				</c:if>
				<c:if test="${product.color == 'yellow' }">
					<option value="white">White</option>
					<option value="yellow" selected="selected">Yellow</option>
					<option value="black">Black</option>
					<option value="gray">Gray</option>

				</c:if>
				<c:if test="${product.color == 'black' }">
					<option value="white">White</option>
					<option value="yellow">Yellow</option>
					<option value="black" selected="selected">Black</option>
					<option value="gray">Gray</option>

				</c:if>
				<c:if test="${product.color == 'gray' }">
					<option value="white">White</option>
					<option value="yellow">Yellow</option>
					<option value="black">Black</option>
					<option value="gray" selected="selected">Gray</option>

				</c:if>
			</select>
		</div>

		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
</div>

<script>
	function fileValid() {
		var fileInput = document.getElementById('exampleInputImg');
		var filePath = fileInput.value;
		var allowedExtendsion = /(\.png|\.jpeg|\.jpg)$/i;

		if (!allowedExtendsion.exec(filePath)) {
			alert("Vui lòng nhập định dạng ảnh .png, .jpge, .jpg");
			document.getElementById('exampleInputImg').style.borderColor = "red";
			fileInput.value = '';
			return false;
		} else {
			document.getElementById('exampleInputImg').style.borderColor = "green";
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

