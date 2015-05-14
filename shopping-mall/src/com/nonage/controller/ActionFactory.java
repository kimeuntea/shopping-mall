package com.nonage.controller;

import com.nonage.admin.controller.action.admin_LoginAction;
import com.nonage.admin.controller.action.admin_LoginFormAction;
import com.nonage.admin.controller.action.admin_OrderDetailAction;
import com.nonage.admin.controller.action.admin_QnaListAction;
import com.nonage.admin.controller.action.admin_OrderSaveAction;
import com.nonage.admin.controller.action.admin_ProductDetailAction;
import com.nonage.admin.controller.action.admin_ProductListAction;
import com.nonage.admin.controller.action.admin_ProductModifyAction;
import com.nonage.admin.controller.action.admin_ProductModifyFormAction;
import com.nonage.admin.controller.action.admin_ProductWriteAction;
import com.nonage.admin.controller.action.admin_ProductWriteFormAction;
import com.nonage.admin.controller.action.admin_OrderListAction;
import com.nonage.admin.controller.action.admin_QnaReplyAction;
import com.nonage.admin.controller.action.admin_QnaReplyFormAction;
import com.nonage.admin.controller.action.admin_QnaViewAction;
import com.nonage.admin.controller.action.admin_indexAction;
import com.nonage.admin.controller.action.admin_memberlistAction;
import com.nonage.controller.action.Action;
import com.nonage.controller.action.CartDeleteAction;
import com.nonage.controller.action.CartinsertAction;
import com.nonage.controller.action.CartlistAction;
import com.nonage.controller.action.CategoryAction;
import com.nonage.controller.action.ContractAction;
import com.nonage.controller.action.IdCheckFormAction;
import com.nonage.controller.action.JoinAction;
import com.nonage.controller.action.JoinFormAction;
import com.nonage.controller.action.LoginAction;
import com.nonage.controller.action.LoginFormAction;
import com.nonage.controller.action.LogoutAction;
import com.nonage.controller.action.MemberUpdateAction;
import com.nonage.controller.action.MemberUpdateForm_1Action;
import com.nonage.controller.action.MemberUpdateForm_2Action;
import com.nonage.controller.action.MypageAction;
import com.nonage.controller.action.OrderAllAction;
import com.nonage.controller.action.OrderDetailAction;
import com.nonage.controller.action.OrderInsertAction;
import com.nonage.controller.action.OrderListAction;
import com.nonage.controller.action.QnAWriteAction;
import com.nonage.controller.action.QnaListAction;
import com.nonage.controller.action.QnaModifyAction;
import com.nonage.controller.action.QnaModifyFormAction;
import com.nonage.controller.action.QnaViewAction;
import com.nonage.controller.action.QnaWriteFormAction;
import com.nonage.controller.action.findFormAction;
import com.nonage.controller.action.findidpwAction;
import com.nonage.controller.action.indexAction;
import com.nonage.controller.action.productViewAction;

public class ActionFactory {
	private static ActionFactory instance  = new ActionFactory();
	public ActionFactory() {
		// TODO Auto-generated constructor stub
		super();
	}
	public static ActionFactory getInstance()
	{
		return instance;
	}
	Action getAction(String command)
	{
		Action action =null;
		System.out.println("getAction :" + command);
	    //action = new 어떤 action;;
		if(command.equals("Contract"))//uri넘어온  command값
		{action = new ContractAction();} //이용할 action
		else if(command.equals("JoinForm"))
		{action = new JoinFormAction();}
		else if(command.equals("IdCheckForm"))
		{action = new IdCheckFormAction();}
		else if(command.equals("Join"))
		{action = new JoinAction();}
		else if(command.equals("Login"))
		{action = new LoginAction();}
		else if(command.equals("LoginForm"))
		{action = new LoginFormAction();}
		else if(command.equals("index"))
		{action = new indexAction();}
		else if(command.equals("Logout"))
		{action = new LogoutAction();}
		else if(command.equals("MemberUpdateForm_1"))
		{action = new MemberUpdateForm_1Action();}
		else if(command.equals("MemberUpdateForm_2"))
		{action = new MemberUpdateForm_2Action();}
		else if(command.equals("MemberUpdate"))
		{action = new MemberUpdateAction();}
		else if(command.equals("findForm"))
		{action = new findFormAction();}
		else if(command.equals("findidpw"))
		{action = new findidpwAction();}
		else if(command.equals("category"))
		{action = new CategoryAction();}
		else if(command.equals("productView"))
		{action = new productViewAction();}
		else if(command.equals("cartinsert"))
		{action = new CartinsertAction();}
		else if(command.equals("cartlist"))
		{action = new CartlistAction();}
		else if(command.equals("cart_delete"))
		{action = new CartDeleteAction();}
		else if(command.equals("orderinsert"))
		{action = new OrderInsertAction();}
		else if(command.equals("orderlist"))
		{action = new OrderListAction();}
		else if(command.equals("mypage"))
		{action = new MypageAction();}
		else if(command.equals("order_detail"))
		{action = new OrderDetailAction();}
		else if(command.equals("orderall"))
		{action = new OrderAllAction();}
		else if(command.equals("qna"))
		{action = new QnaListAction();}
		else if(command.equals("qnawriteform"))
		{action = new QnaWriteFormAction();} 
		else if(command.equals("qnawrite"))
		{action = new QnAWriteAction();}
		else if(command.equals("qnadetail"))
		{action = new QnaViewAction();}
		else if(command.equals("qnamodifyform"))
		{action = new QnaModifyFormAction();}
		else if(command.equals("qnamodify"))
		{action = new QnaModifyAction();}
		
		/*여기서부터는 관리자 쪽*/
		else if(command.equals("admin_LoginForm"))
		{action = new admin_LoginFormAction();}
		else if(command.equals("admin_Login"))
		{action = new admin_LoginAction();}
		else if(command.equals("admin_index"))
		{action = new admin_indexAction();}
		else if(command.equals("admin_member_list"))
		{action = new admin_memberlistAction();}
		else if(command.equals("admin_product_list")) 
		{action = new admin_ProductListAction();}
		else if(command.equals("admin_product_writeform"))
		{action = new admin_ProductWriteFormAction();}
		else if(command.equals("admin_product_write"))
		{action = new admin_ProductWriteAction();}
		else if(command.equals("admin_product_detail"))
		{action = new admin_ProductDetailAction();}
		else if(command.equals("admin_product_modifyform"))  
		{action = new admin_ProductModifyFormAction();}
		else if(command.equals("admin_modify"))
		{action = new admin_ProductModifyAction();}
		else if(command.equals("admin_order_list"))
		{action = new admin_OrderListAction();}
		else if(command.equals("admin_order_detail"))
		{action = new admin_OrderDetailAction();}
		else if(command.equals("admin_order_save"))
		{action = new admin_OrderSaveAction();}
		else if(command.equals("admin_qna_list"))
		{action = new admin_QnaListAction();}
		else if(command.equals("admin_qna_view"))
		{action = new admin_QnaViewAction();}
		else if(command.equals("admin_qna_replyform"))
		{action = new admin_QnaReplyFormAction();}
		else if(command.equals("admin_qna_reply"))
		{action = new admin_QnaReplyAction();}
		
		
		return action;
	}
}
