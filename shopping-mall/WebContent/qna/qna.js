/**
 * 
 */
function check() {
	if (document.formm.subject.value.length == 0) {
		alert("������ �Է��ϼ���");
		document.formm.subject.focus();
		return false;
	}
	if (document.formm.content.value.length == 0) {
		alert("������ �Է��ϼ���");
		document.formm.content.focus();
		return false;
	}
}