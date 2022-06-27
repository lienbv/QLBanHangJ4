// check name
function is_fullname(fullname) {
	var nameregex = /^[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\s\W|_]+$/;
	if (fullname.match(nameregex)) {
		return true;
	}
	else {
		return false;
	}
}

function checkFormName() {
	var name = document.getElementById('fullname').value;
	if (is_fullname(name) == false) {
		document.getElementById('fullname').style.borderColor = "red";
		alert("Tên không đúng định dạng, hãy thử lại!");
		document.getElementById("button").disabled = true;
		document.getElementById("button1").disabled = true;
	} else {
		document.getElementById('fullname').style.borderColor = "green";
		document.getElementById("button").disabled = false;
		document.getElementById("button1").disabled = false;
	}
}

// check số điện thoại
function is_phone(phonenumber) {
	var phoneregex = /^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$/;
	if (phonenumber.match(phoneregex)) {
		return true;
	}
	else {
		return false;
	}
}

function checkFormPhone() {
	var phone = document.getElementById('exampleInputPhoneNume1').value;
	if (is_phone(phone) == false) {
		document.getElementById('exampleInputPhoneNume1').style.borderColor = "red";
		alert("Số điện thoại không đúng định dạng, hãy thử lại!");
		document.getElementById("button").disabled = true;
	} else {
		document.getElementById('exampleInputPhoneNume1').style.borderColor = "green";
		document.getElementById("button").disabled = false;
	}
}

var checkPass = function() {
	if (document.getElementById("pass").value == document.getElementById("repeatPass").value) {
		document.getElementById("button").disabled = false;
		document.getElementById("pass").style.borderColor = "green";
		document.getElementById("repeatPass").style.borderColor = "green";

	} else {
		alert("Không trùng với mật khẩu đã nhập mời nhập lại");
		document.getElementById("pass").style.borderColor = "red";
		document.getElementById("repeatPass").style.borderColor = "red";
		document.getElementById("button").disabled = true;
	}
}
var checkPassChange = function() {
	if (document.getElementById("pass_new").value == document.getElementById("comfirmPass").value) {
		document.getElementById("buttonChange").disabled = false;
		document.getElementById("pass_new").style.borderColor = "green";
		document.getElementById("comfirmPass").style.borderColor = "green";

	} else {
		alert("Không trùng với mật khẩu đã nhập mời nhập lại");
		document.getElementById("pass_new").style.borderColor = "red";
		document.getElementById("comfirmPass").style.borderColor = "red";
		document.getElementById("buttonChange").disabled = true;
	}
}


function checkNumber() {
	var sl = document.getElementById('exampleFormControlQuan').value;
	if (sl < 0) {
		document.getElementById('QuanHelp').innerHTML = "Số lượng không hợp lệ";
		document.getElementById('exampleFormControlQuan').style.borderColor = "red";
		document.getElementById('button1').disabled = true;
	} else {
		document.getElementById('QuanHelp').innerHTML = "";
		document.getElementById('exampleFormControlQuan').style.borderColor = "green";
		document.getElementById('button1').disabled = false;
	}
}

var urlName = location.href;
var errorlogin = urlName.search("errorLogin");
var successLogin = urlName.search("successLogin");
var errorPass = urlName.search("errorPass");

if (errorlogin > 0) {
	alert("Chưa có tài khoản, hãy thử lại");
}else if(successLogin>0){
	alert("Đăng nhập thành công");
}else if(errorPass>0){
	alert("Mật khẩu không khớp");
}

















