/**
 * 
 */
function RegisterCheck() {

	if (document.frm.radio[0].checked != true) {
		alert('약관에 동의하셔야만 합니다.');
		return false;
	}
	if (document.frm.radio[0].checked == true) {
		document.frm.submit();
	} else if (document.frm.radio[1].checked == true) {
		alert('약관에 동의하셔야만 합니다.');
		return false;
	}
}

function cancle() {
	self.close();
}
function findwindow1() {
	if (document.namephone.name.value.length == 0) {
		alert("이름을 입력해주세요.");
		document.namephone.name.focus();
		return false;
	}
	if (document.namephone.phone.value.length == 0) {
		alert("번호를 입력해주세요.");
		document.namephone.phone.focus();
		return false;
	}
}

function findwindow2() {
	if (document.idphone.id.value.length == 0) {
		alert("아이디를 입력해주세요.");
		document.idphone.id.focus();
		return false;
	}
	if (document.idphone.phone.value.length == 0) {
		alert("번호를 입력해주세요.");
		document.idphone.phone.focus();
		return false;
	}
}
