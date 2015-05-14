/**
 * 
 */
function check() {
	if (document.formm.subject.value.length == 0) {
		alert("제목을 입력하세요");
		document.formm.subject.focus();
		return false;
	}
	if (document.formm.content.value.length == 0) {
		alert("내용을 입력하세요");
		document.formm.content.focus();
		return false;
	}
}