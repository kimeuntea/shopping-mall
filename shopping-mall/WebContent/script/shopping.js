/**
 * 
 */
function RegisterCheck() {

	if (document.frm.radio[0].checked != true) {
		alert('����� �����ϼž߸� �մϴ�.');
		return false;
	}
	if (document.frm.radio[0].checked == true) {
		document.frm.submit();
	} else if (document.frm.radio[1].checked == true) {
		alert('����� �����ϼž߸� �մϴ�.');
		return false;
	}
}

function cancle() {
	self.close();
}
function findwindow1() {
	if (document.namephone.name.value.length == 0) {
		alert("�̸��� �Է����ּ���.");
		document.namephone.name.focus();
		return false;
	}
	if (document.namephone.phone.value.length == 0) {
		alert("��ȣ�� �Է����ּ���.");
		document.namephone.phone.focus();
		return false;
	}
}

function findwindow2() {
	if (document.idphone.id.value.length == 0) {
		alert("���̵� �Է����ּ���.");
		document.idphone.id.focus();
		return false;
	}
	if (document.idphone.phone.value.length == 0) {
		alert("��ȣ�� �Է����ּ���.");
		document.idphone.phone.focus();
		return false;
	}
}
