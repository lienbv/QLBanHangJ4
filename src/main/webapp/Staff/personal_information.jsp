<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>

<div class="row py-2 ">
	<div class="col-sm-12 px-0">

		<div class="row bg-white px-0 mx-auto">
			<div class="col-sm-3 bg-light col-xs-12 " style="min-height: 300px;">
				<div class="nav flex-column nav-pills" id="v-pills-tab"
					role="tablist" aria-orientation="vertical">
					<a class="nav-link active text-dark" id="v-pills-home-tab"
						data-toggle="pill" href="#v-pills-home" role="tab"
						aria-controls="v-pills-home" aria-selected="true">Thông tin cá
						nhân</a> <a class="nav-link text-dark" id="v-pills-profile-tab"
						data-toggle="pill" href="#v-pills-profile" role="tab"
						aria-controls="v-pills-profile" aria-selected="false">Thay đổi
						mật khẩu</a>

				</div>
			</div>
			<div class="col-sm-9 col-xs-12 mx-auto px-0">
				<div class="tab-content" id="v-pills-tabContent">
					<div class="tab-pane fade show active" id="v-pills-home"
						role="tabpanel" aria-labelledby="v-pills-home-tab">
						<h4 class="text-center" style="color: rgb(75, 73, 72);">Thông
							tin cá nhân</h4>
							
						<div class="col-sm-12">
						<c:if test="${!empty sessionScope.successUpdateProfile}">
										<p>${sessionScope.successUpdateProfile }</p>
									</c:if>
									<c:remove var="successUpdateProfile" scope="session" />
							<form action="/ASMJ4/admin/profile_Infor/update?id=${customer.id }" method="post" class="bg-light">
								<img name="img" class=" rounded shadow my-sm-4"
									src="/ASMJ4/img/${customer.img}" alt="">

								<div class="form-group">
									<label for="fullname">Fullname</label> <input name="fullname"
										value="${customer.fullname }" type="text" class="form-control"
										id="fullname" aria-describedby="fullname">

								</div>
								<div class="form-group">
									<label for="email">Email</label> <input name="email"
										value="${customer.email }" type="email" class="form-control"
										id="email" aria-describedby="emailHelp">

								</div>
								<div class="form-group">
									<label for="address">Address</label> <input
										value="${customer.address }" name="address" type="text"
										class="form-control" id="address" aria-describedby="emailHelp">

								</div>
								<div class="form-group">
									<label for="phone">Phone number</label> <input
										value="${customer.phoneNumber }" name="phone" type="text"
										class="form-control" minlength="10" maxlength="10" id="phone"
										aria-describedby="phone">
									<c:if test="${!empty sessionScope.errorPhone}">
										<p>${sessionScope.errorPhone }</p>
									</c:if>
									<c:remove var="errorPhone" scope="session" />
								</div>

								<div class="form-group">
									<button type="submit" class="btn btn-dark ">Update</button>
								</div>

							</form>

						</div>
					</div>
					

					<div class="tab-pane fade px-sm-2" id="v-pills-profile"
						role="tabpanel" aria-labelledby="v-pills-profile-tab">
						<h4 class="text-center py-sm-2" style="color: rgb(75, 73, 72);">Change
							password</h4>
						<form action="/ASMJ4/admin/profile_Infor/changePassword?id=${customer.id }" method="post" class="bg-light">

							<div class="form-group">
								<label for="pass_old">Password old</label> <input
									name="pass_old" type="password" minlength="5" maxlength="10" required="required" class="form-control" id="pass_old"
									aria-describedby="pass_old">

							</div>
							<div class="form-group">
								<label for="pass_new">Password new</label> <input
									name="passf_new" type="password" minlength="5" maxlength="10" required="required" class="form-control" id="pass_new"
									aria-describedby="pass_new">

							</div>
							<div class="form-group">
								<label for="confirmPass">Confirm Password</label> <input
									name="confirmPass" onchange="checkPassChange()" type="password" minlength="5" maxlength="10" required="required" class="form-control" id="comfirmPass"
									aria-describedby="comfirmPass">

								<div class="form-group">
									<button type="submit" id="buttonChange" class="btn btn-dark ">Submit</button>
									<!-- <button type="submit" class="btn btn-dark ">Hủy</button> -->
								</div>
						</form>
					</div>

				</div>
			</div>
		</div>

	</div>
</div>
</div>