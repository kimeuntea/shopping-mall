/**
 * 
 */
function go_cart() {
	if (document.formm.quantity.value == 0) {
		alert("1���̻� ��� �����մϴ�.");
		return false;
	}
	document.formm.action = "NonageServlet?command=cartinsert";// ��ư���� Ŭ����
	document.formm.submit();// �ؾ����� �Ѿ
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
			alert("���� �˴ϴ�." + count);
		}
	}
	if (count == 0) {
		alert("üũ�ϼ���");
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