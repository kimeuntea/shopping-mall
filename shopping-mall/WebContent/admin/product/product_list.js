/**
 * 
 */
function go_serach() {
	
	var key = document.formm.key.value;
	if (document.formm.key.value.length != 0) {
		location.href = "NonageServlet?command=admin_product_list&key="+key; 
	} else {
		alert("입력하시오");
		return false;
	}
}
function writecheck() {
	if (document.formm.name.value == 0) {
		alert("상품명을 입력해주세요");
		return false;
	}
	if (document.formm.price.value == 0) {
		alert("가격을 입력해주세요");
		return false;
	}
	if (document.formm.content.value == 0) {
		alert("설명을 입력해주세요");
		return false;
	}
}
function go_modify()
{
	var pseq = document.formm.pseq.value;
    location.href="NonageServlet?command=admin_product_modifyform&pseq="+pseq;	

}