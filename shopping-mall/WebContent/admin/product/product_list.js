/**
 * 
 */
function go_serach() {
	
	var key = document.formm.key.value;
	if (document.formm.key.value.length != 0) {
		location.href = "NonageServlet?command=admin_product_list&key="+key; 
	} else {
		alert("�Է��Ͻÿ�");
		return false;
	}
}
function writecheck() {
	if (document.formm.name.value == 0) {
		alert("��ǰ���� �Է����ּ���");
		return false;
	}
	if (document.formm.price.value == 0) {
		alert("������ �Է����ּ���");
		return false;
	}
	if (document.formm.content.value == 0) {
		alert("������ �Է����ּ���");
		return false;
	}
}
function go_modify()
{
	var pseq = document.formm.pseq.value;
    location.href="NonageServlet?command=admin_product_modifyform&pseq="+pseq;	

}