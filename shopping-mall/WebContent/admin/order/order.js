/**
 * 
 */
function go_findorder() {
	if (document.formm.key.value.length == 0) {
		alert("이름을 잊력하시오");
		return false;
	} else {

		var key = document.formm.key.value;
        location.href="NonageServlet?command=admin_order_list&key="+key;
	}
}
function go_result()
{
	var odseq = document.formm.odseq.value;
	location.href="NonageServlet?command=admin_order_save&odseq="+odseq;
	
}
function go_qna()
{
	if(document.formm.key.value.length() != null)
		{
	var qseq = document.formm.key.value;
	location.href="NonageServlet?command=admin_qna_list&qseq="+qseq;
		}else
			{
			alert("입력하세요");
			return false;
			}
		}
function go_reply()
{
	var qseq = document.formm.qseq.value;
	location.href="NonageServlet?command=admin_qna_replyform&qseq="+qseq;

}