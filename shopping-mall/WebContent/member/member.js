/**
 * 
 */
function formcheck() {
	var id = document.frm.id.value;
	if (id.length <= 4 || id.length > 9) {
		alert("아이디를 4자이상 9자이하 입력해주세요");
		document.frm.id.focus();
		return false;
	}
	var reid = document.frm.reid.value;
	if (document.frm.reid.value.length ==0) {
		alert("중복체크 하시기바랍니다.");
		document.frm.id.focus();
		return false;
	}
	var pwd = document.frm.pwd.value;
	if (pwd.length <= 4 || pwd.length > 9) {
		alert("비밀번호를 4자이상 9자이하 입력해주세요 ");
		document.frm.pwd.focus();
		return false;
	}
	if (document.frm.pwd_1.value != document.frm.pwd.value) {
		alert("비밀번호와 같지않습니다.");
		document.frm.pwd_1.focus();
		return false;
	}
	if (document.frm.name.value.length == 0) {
		alert("이름을 입력해주세요.");
		document.frm.name.focus();
		return false;
	}
	if (document.frm.name.address.length == 0) {
		alert("주소를 입력해주세요.");
		document.frm.address.focus();
		return false;
	}
	if (document.frm.phone.value.length == 0) {
		alert("번호를  입력해주세요.");
		document.frm.phone.focus();
		return false;
	}
	alert("회원가입을 축하드립니다.");
	return true;
}
// 중복체크
function idcheck() {
	if (document.frm.id.value.length == 0) {
		alert("아이디를을 입력해주세요.");
		document.frm.id.focus();
		return false;
	}

	var id = document.frm.id.value;
	var url = "NonageServlet?command=IdCheckForm&id=" + id;
	var name = "";
	var feature = "width=100 , height=100";
	window.open(url, name, feature);
}
// 로그인폼 아뒤비번
function login() {
	if (document.frmmm.id.value.length == 0) {
		alert("아이디 를 입력하시오");
		document.frmmm.id.focus();
		return false;
	}
	if (document.frmmm.pwd.value.length == 0) {
		alert("비번을 입력하시오");
		document.frmmm.pwd.focus();
		return false;
	}
}
function U_fcheck() {
	var pwd = document.U_f.pwd.value;
	if (pwd.length <= 4 || pwd.length > 9) {
		alert("비밀번호를 4자이상 9자이하 입력해주세요 ");
		document.frm.pwd.focus();
		return false;
	}
}
// 아이디 찾기
function find_idpw() {
	var url = "NonageServlet?command=findForm";
	var name = "find";
	var feature = "width=100 , height=100";
	window.open(url, name, feature);
}


/*
 * 
 * 
 * 
 * 
 * zipcode()
 */