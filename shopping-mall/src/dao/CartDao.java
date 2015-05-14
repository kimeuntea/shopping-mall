package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import until.DBManager;

public class CartDao {
	private static CartDao instance = new CartDao();
	private CartDao() {}
	public static CartDao getInstance() {
    return instance;
	}
	
	//장바구니 insert
	public void cartinsert(CartBean bean)
	{
		Connection conn = null;
		PreparedStatement pstmt=null;
		String sql = "insert into cart(cseq,id,quantity,pseq)"
				+ "values(cart_seq.nextval,?,?,?)";
		conn = DBManager.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getId());
			pstmt.setInt(2, bean.getQuantity());
			pstmt.setInt(3, bean.getPseq());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			DBManager.close(conn, pstmt);
		}

	}
	//cartlist
	public List<CartBean> cartlist(String id)
	{
		Connection conn = null;
		PreparedStatement pstmt=null;
		ResultSet rs =null;
		String sql = "select * from cart_view where id = ?";
		List<CartBean>list= new ArrayList<CartBean>();
		conn = DBManager.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            
             while(rs.next())
             {
            	CartBean bean = new CartBean();
            	bean.setCseq(rs.getInt("cseq"));
            	bean.setId(rs.getString("id"));
            	bean.setPseq(rs.getInt("pseq"));
            	bean.setPname(rs.getString("pname"));
            	bean.setMname(rs.getString("mname"));
            	bean.setPrice1(rs.getInt("price2"));
            	bean.setQuantity(rs.getInt("quantity"));
            	bean.setResult(rs.getString("result"));
            	bean.setIndate(rs.getTimestamp("indate"));
            	list.add(bean);
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
	//삭제하기
	public void cartdelete(int cseq)
	{
		Connection conn = null;
		PreparedStatement pstmt=null;
		String sql = "delete cart where cseq = ?";
		conn = DBManager.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cseq);
			
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
