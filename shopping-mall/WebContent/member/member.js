/**
 * 
 */
function formcheck() {
	var id = document.frm.id.value;
	if (id.length <= 4 || id.length > 9) {
		alert("���̵� 4���̻� 9������ �Է����ּ���");
		document.frm.id.focus();
		return false;
	}
	var reid = document.frm.reid.value;
	if (document.frm.reid.value.length ==0) {
		alert("�ߺ�üũ �Ͻñ�ٶ��ϴ�.");
		document.frm.id.focus();
		return false;
	}
	var pwd = document.frm.pwd.value;
	if (pwd.length <= 4 || pwd.length > 9) {
		alert("��й�ȣ�� 4���̻� 9������ �Է����ּ��� ");
		document.frm.pwd.focus();
		return false;
	}
	if (document.frm.pwd_1.value != document.frm.pwd.value) {
		alert("��й�ȣ�� �����ʽ��ϴ�.");
		document.frm.pwd_1.focus();
		return false;
	}
	if (document.frm.name.value.length == 0) {
		alert("�̸��� �Է����ּ���.");
		document.frm.name.focus();
		return false;
	}
	if (document.frm.name.address.length == 0) {
		alert("�ּҸ� �Է����ּ���.");
		document.frm.address.focus();
		return false;
	}
	if (document.frm.phone.value.length == 0) {
		alert("��ȣ��  �Է����ּ���.");
		document.frm.phone.focus();
		return false;
	}
	alert("ȸ�������� ���ϵ帳�ϴ�.");
	return true;
}
// �ߺ�üũ
function idcheck() {
	if (document.frm.id.value.length == 0) {
		alert("���̵��� �Է����ּ���.");
		document.frm.id.focus();
		return false;
	}

	var id = document.frm.id.value;
	var url = "NonageServlet?command=IdCheckForm&id=" + id;
	var name = "";
	var feature = "width=100 , height=100";
	window.open(url, name, feature);
}
// �α����� �Ƶں��
function login() {
	if (document.frmmm.id.value.length == 0) {
		alert("���̵� �� �Է��Ͻÿ�");
		document.frmmm.id.focus();
		return false;
	}
	if (document.frmmm.pwd.value.length == 0) {
		alert("����� �Է��Ͻÿ�");
		document.frmmm.pwd.focus();
		return false;
	}
}
function U_fcheck() {
	var pwd = document.U_f.pwd.value;
	if (pwd.length <= 4 || pwd.length > 9) {
		alert("��й�ȣ�� 4���̻� 9������ �Է����ּ��� ");
		document.frm.pwd.focus();
		return false;
	}
}
// ���̵� ã��
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