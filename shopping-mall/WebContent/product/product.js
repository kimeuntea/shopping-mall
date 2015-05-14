/**
 * 
 */
function go_cart() {
	if (document.formm.quantity.value == 0) {
		alert("1개이상 담기 가능합니다.");
		return false;
	}
	document.formm.action = "NonageServlet?command=cartinsert";// 버튼으로 클리시
	document.formm.submit();// 해야지만 넘어감
}

function go_cart_delete() {
	var count = 0;

	if (document.formm.cseq.length == undefined) {
		if (document.formm.cseq.checked == true) {
			count++;
		}
	}

	for (var i = 0; i < document.formm.cseq.length; i++) {
		//alert("" + document.formm.cseq[i].checked);
		if (document.formm.cseq[i].checked == true) {
			count++;
			alert("삭제 됩니다." + count);
		}
	}
	if (count == 0) {
		alert("체크하세요");
	} else {
		document.formm.action = "NonageServlet?command=cart_delete";
		document.formm.submit();
	}
}
function go_insert_order()
{
document.formm.action="NonageServlet?command=orderinsert";
document.formm.submit();
}
function go_order()
{
document.formm.action="NonageServlet?command=orderinsert";
document.formm.submit();
}