package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import until.DBManager;

public class OrderDao {
	private static OrderDao instance = new OrderDao();

	private OrderDao() {
		// TODO Auto-generated constructor stub
	}

	public static OrderDao getInstance() {
		return instance;
	}

	public int orderInsert(List<CartBean> cartbean, String id) {
		// TODO Auto-generated method stub
		int Oseq = 0;
		Connection conn = null;
		conn = DBManager.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select max(oseq) from orders";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				Oseq = rs.getInt(1)+1;
			} //주문갯수 확인
			
			DBManager.close(conn, pstmt, rs);
            
			sql = "insert into orders(oseq,id)" 
					+ "values(orders_seq.nextval,?)";  
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);//주문넣기 //주문번호가 생성된다.
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			DBManager.close(conn, pstmt, rs);
			for (CartBean cartBean : cartbean) //돌면서 주문상세와 카트 업데이트가 된다.
			{
			orderinsertDetail(cartBean,Oseq);//85	
			}
			System.out.println("2");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Oseq;
	}

	public void orderinsertDetail(CartBean cartBean, int oseq) {  
		// TODO Auto-generated method stub               
		String sql="insert into order_detail(odseq,oseq,pseq,quantity)"
				+ "values(order_detail_seq.nextval,?,?,?)";    
		Connection conn = null;
		PreparedStatement pstmt =null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, oseq);
			pstmt.setInt(2, cartBean.getPseq());
			pstmt.setInt(3, cartBean.getQuantity());
			pstmt.executeUpdate();
			DBManager.close(conn, pstmt);
			
			System.out.println("3");
			conn = DBManager.getConnection();
			sql ="update cart set result = 2 where cseq = ?";
			pstmt =conn.prepareStatement(sql);
			pstmt.setInt(1, cartBean.getCseq());
			pstmt.executeUpdate();
			DBManager.close(conn, pstmt);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
	}
//주문번호로 주문리스트 뽑기
	public List<OrderBean> orderlist(String id, String result, int oseq) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<OrderBean> list = new ArrayList<OrderBean>();
		 String sql= "select * from order_view where id=?"
			+ "and result like '%'||?||'%' and oseq=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,id);
			pstmt.setString(2,"%");
			pstmt.setInt(3,oseq);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
			 OrderBean order = new OrderBean();
			 order.setOdseq(rs.getInt("odseq"));
			 order.setOseq(rs.getInt("oseq"));
			 order.setId(rs.getString("id"));
			 order.setMname(rs.getString("mname"));
			 order.setPname(rs.getString("pname"));
			 order.setIndate(rs.getTimestamp("indate"));
			 order.setPhone(rs.getString("phone"));
			 order.setZipNum(rs.getString("zip_Num"));
			 order.setAddress(rs.getString("address"));
			 order.setPrice2(rs.getInt("price2"));
			 order.setQuantity(rs.getInt("quantity"));
			 order.setResult(rs.getString("result"));
			 order.setPseq(rs.getInt("pseq"));
			 
			 list.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			DBManager.close(conn, pstmt, rs);
		}
		
		
		return list;
	}

	public List<Integer> selectOrderIng2(String id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		 String sql= "select distinct oseq from order_view "
				+ "where id=? order by oseq desc";
		 List<Integer> list= new ArrayList<Integer>();
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				int oseq = rs.getInt("oseq");
				list.add(oseq);
			}
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	public List<Integer> selectOrderIng(String id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		 String sql= "select distinct oseq from order_view "
				+ "where id=? and result='1' order by oseq desc";
		 List<Integer> list= new ArrayList<Integer>();
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				int oseq = rs.getInt("oseq");
				list.add(oseq);
			}
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	///////////////////////////////// 관리자용//////////////////////////////////////////
	///검색  주문
	public List<OrderBean>  admin_orderList(String key) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<OrderBean> list = new ArrayList<OrderBean>();
		 String sql= "select * from order_view where "
			+ "mname like '%'||?||'%' order by indate desc";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			if(key != null)
			{
			pstmt.setString(1,key);
			}
			else{
			pstmt.setString(1,"%");
			}
			rs = pstmt.executeQuery();
			while(rs.next())
			{
			 OrderBean order = new OrderBean();
			 order.setOdseq(rs.getInt("odseq"));
			 order.setOseq(rs.getInt("oseq"));
			 order.setId(rs.getString("id"));
			 order.setMname(rs.getString("mname"));
			 order.setPname(rs.getString("pname"));
			 order.setIndate(rs.getTimestamp("indate"));
			 order.setPhone(rs.getString("phone"));
			 order.setZipNum(rs.getString("zip_Num"));
			 order.setAddress(rs.getString("address"));
			 order.setPrice2(rs.getInt("price2"));
			 order.setQuantity(rs.getInt("quantity"));
			 order.setResult(rs.getString("result"));
			 order.setPseq(rs.getInt("pseq"));
			 
			 list.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			DBManager.close(conn, pstmt, rs);
		}
		
		
		return list;
	}
	public OrderBean  admin_orderdetail(int key) 
	{
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		OrderBean order = new OrderBean();
		String sql= "select * from order_view where odseq=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1,key);
			
			rs = pstmt.executeQuery();
			while(rs.next())
			{
			 
			 order.setOdseq(rs.getInt("odseq"));
			 order.setOseq(rs.getInt("oseq"));
			 order.setId(rs.getString("id"));
			 order.setMname(rs.getString("mname"));
			 order.setPname(rs.getString("pname"));
			 order.setIndate(rs.getTimestamp("indate"));
			 order.setPhone(rs.getString("phone"));
			 order.setZipNum(rs.getString("zip_Num"));
			 order.setAddress(rs.getString("address"));
			 order.setPrice2(rs.getInt("price2"));
			 order.setQuantity(rs.getInt("quantity"));
			 order.setResult(rs.getString("result"));
			 order.setPseq(rs.getInt("pseq"));
			 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			DBManager.close(conn, pstmt, rs);
		}
		
		
		return order;
	}
	//처리 미처리
	public void sadmin_save(int odseq) 
	{
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		OrderBean order = new OrderBean();
		String sql= "update order_view set result=2 where odseq=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, odseq);
			
			pstmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			DBManager.close(conn, pstmt);
		}
		
	}
	
}
