<%@ page language="java" session="true"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>

<div class="row py-2 ">
	<div class="col-sm-12">
		<div class="row bg-white px-0 justify-content-center">
		<div class="col-sm-5">
	<label class="text-center py-sm-2" style="padding-left: 40%;">Register</label>
	<div class="alert alert-success" role="alert">
		<h4 class="alert-heading"></h4>
		<c:if test="${!empty sessionScope.successRegister}">
			<p>${sessionScope.successRegister }</p>
		</c:if>
		<c:remove var="successRegister" scope="session" />

		<c:if test="${ !empty sessionScope.messageEmail }">
			<p>${sessionScope.messageEmail }</p>
		</c:if>
		<c:remove var="messageEmail" scope="session" />
		<c:if test="${ !empty sessionScope.erorrEmail }">
			<p>${sessionScope.erorrEmail }</p>
		</c:if>
		<c:remove var="erorrEmail" scope="session" />

		<p class="mb-0"></p>
	</div>
	<form action="/ASMJ4/admin/Staff/store" method="post">
		<div class="form-group">
			<label for="fullname">Fullname</label> <input type="text"
				class="form-control" name="fullname" id="fullname"
				aria-describedby="fullname">
			<c:if test="${!empty sessionScope.fullname_null}">
				<p>${sessionScope.fullname_null }</p>
			</c:if>
			<c:remove var="fullname_null" scope="session" />

		</div>
		<div class="form-group">
			<label for="usename">Username</label> <input name="username"
				type="text" class="form-control" minlength="5" maxlength="15"
				id="usename" required="required" aria-describedby="usename">
			<c:if test="${!empty sessionScope.errorUsername}">
				<p>${sessionScope.errorUsername }</p>
			</c:if>
			<c:remove var="errorUsernames" scope="session" />
			<c:if test="${!empty sessionScope.user_null}">
				<p>${sessionScope.user_null }</p>
			</c:if>
			<c:remove var="user_null" scope="session" />
		</div>
		<div class="form-group">
			<label for="email">Email</label> <input type="email"
				class="form-control" name="email" required="required" minlength="5"
				maxlength="50" id="email" aria-describedby="email"> <small
				id="emailHelp" class="form-text text-muted">We'll never
				share your email with anyone else.</small>
			<c:if test="${!empty sessionScope.email_null}">
				<p>${sessionScope.email_null }</p>
			</c:if>
			<c:remove var="email_null" scope="session" />

			<c:if test="${!empty sessionScope.email_matches}">
				<p>${sessionScope.email_matches }</p>
			</c:if>
			<c:remove var="email_matches" scope="session" />
		</div>
		<div class="form-group">
			<label for="pass">Password</label> <input required="required"
				minlength="5" maxlength="15" name="password" type="password"
				class="form-control" id="pass">
			<c:if test="${!empty sessionScope.pass_null}">
				<p>${sessionScope.pass_null }</p>
			</c:if>
			<c:remove var="pass_null" scope="session" />
		</div>
		<div class="form-group">
			<label for="pass">Repeat Password</label> <input type="password"
				required="required" minlength="5" name="confirm" maxlength="15"
				placeholder="Repeat Password" id="repeatPass"
				onchange="checkPass();" class="form-control">
			<c:if test="${!empty sessionScope.repass_null}">
				<p>${sessionScope.repass_null }</p>
			</c:if>
			<c:remove var="repass_null" scope="session" />

			<c:if test="${!empty sessionScope.confirm_pass}">
				<p>${sessionScope.confirm_pass }</p>
			</c:if>
			<c:remove var="confirm_pass" scope="session" />
		</div>

		<div class="form-group">
			<label for="sdt">Phone number</label> <input required="required"
				name="phoneNumber" type="text" id="exampleInputPhoneNume1"
				onchange="checkFormPhone()" required class="form-control" id="sdt"
				aria-describedby="sdt">
			<c:if test="${!empty sessionScope.errorPhoneNumber}">
				<p>${sessionScope.errorPhoneNumber }</p>
			</c:if>
			<c:remove var="errorPhoneNumber" scope="session" />
			<c:if test="${!empty sessionScope.phone_null}">
				<p>${sessionScope.phone_null }</p>
			</c:if>
			<c:remove var="phone_null" scope="session" />

			<c:if test="${!empty sessionScope.phone_matches}">
				<p>${sessionScope.phone_matches }</p>
			</c:if>
			<c:remove var="phone_matches" scope="session" />
		</div>

		<div class="form-group">
			<label for="address">Address</label> <input required="required"
				name="address" type="text" class="form-control" id="address"
				aria-describedby="address">
			<c:if test="${!empty sessionScope.address_null}">
				<p>${sessionScope.address_null }</p>
			</c:if>
			<c:remove var="address_null" scope="session" />
		</div>

		<div class="form-group">
			<button type="submit" id="button" class="btn btn-dark col-sm-12"
				style="border: 1px solid black;">Register</button>

		</div>
	</form>

</div>
		</div>
	</div>
</div>


