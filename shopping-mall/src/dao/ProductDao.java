package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import until.DBManager;

public class ProductDao {
	private static ProductDao insatance = new ProductDao();

	private ProductDao() {
	}

	public static ProductDao getInstance() {
		return insatance;
	}

	// 상품리스트
	public List<ProductBean> ProductList(String kind) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		String sql = "select * from product where kind = ? order by pseq desc";
		List<ProductBean> list = new ArrayList<ProductBean>();
		conn = DBManager.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, kind);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ProductBean bean = new ProductBean();
				bean.setPseq(rs.getInt("pseq"));
				bean.setName(rs.getString("name"));
				bean.setKind(rs.getString("kind"));
				bean.setPrice1(rs.getInt("price1"));
				bean.setPrice2(rs.getInt("price2"));
				bean.setPrice3(rs.getInt("price3"));
				bean.setContent(rs.getString("content"));
				bean.setImage(rs.getString("image"));
				bean.setUseyn(rs.getString("useyn"));
				bean.setBestyn(rs.getString("bestyn"));
				bean.setIndate(rs.getTimestamp("indate"));
				list.add(bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return list;
	}

	// detail
	public ProductBean productdetail(String pseq) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		String sql = "select * from product where pseq = ? ";
		ProductBean bean = new ProductBean();
		conn = DBManager.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pseq);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				bean.setPseq(rs.getInt("pseq"));
				bean.setName(rs.getString("name"));
				bean.setKind(rs.getString("kind"));
				bean.setPrice1(rs.getInt("price1"));
				bean.setPrice2(rs.getInt("price2"));
				bean.setPrice3(rs.getInt("price3"));
				bean.setContent(rs.getString("content"));
				bean.setImage(rs.getString("image"));
				bean.setUseyn(rs.getString("useyn"));
				bean.setBestyn(rs.getString("bestyn"));
				bean.setIndate(rs.getTimestamp("indate"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return bean;
	}

	// ///////////////////////////////////////관리자용//////////////////////////////////////////////
	// 관리자 상품리스트
	 
	public List<ProductBean> admin_ProductList(String key,PageBean page) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		String sql = "select * from(select rownum rid, tt.* from"
				+ "(select * from product where name like '%'||?||'%' order by pseq desc) tt)"
				+ "where rid>=? and rid<=?";
		List<ProductBean> list = new ArrayList<ProductBean>();
		conn = DBManager.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			if (key == "") {
				pstmt.setString(1, "%");
			} else {
				pstmt.setString(1, key);
			}
			pstmt.setInt(2, page.getPagelow());
			pstmt.setInt(3, page.getPagecol());

			rs = pstmt.executeQuery();
			while (rs.next()) {
				ProductBean bean = new ProductBean();
				bean.setPseq(rs.getInt("pseq"));
				bean.setName(rs.getString("name"));
				bean.setKind(rs.getString("kind"));
				bean.setPrice1(rs.getInt("price1"));
				bean.setPrice2(rs.getInt("price2"));
				bean.setPrice3(rs.getInt("price3"));
				bean.setContent(rs.getString("content"));
				bean.setImage(rs.getString("image"));
				bean.setUseyn(rs.getString("useyn"));
				bean.setBestyn(rs.getString("bestyn"));
				bean.setIndate(rs.getTimestamp("indate"));
				list.add(bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return list;
	}

	public void productwrite(ProductBean bean) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		String sql = "insert into product(pseq,name,price2,content,image,indate,kind)"
				+ "values(product_seq.nextval,?,?,?,?,sysdate,?)";
		conn = DBManager.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getName());
			pstmt.setInt(2, bean.getPrice1());
			pstmt.setString(3, bean.getContent());
			pstmt.setString(4, bean.getImage());
			pstmt.setString(5, bean.getKind());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

	}
	//관리자 업데이트
	public void productupdate(ProductBean bean) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		String sql = "update product set name = ?, price2 = ?, content = ?,image = ?, kind=? where pseq = ?";
		conn = DBManager.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getName());
			pstmt.setInt(2, bean.getPrice1());
			pstmt.setString(3, bean.getContent());
			pstmt.setString(4, bean.getImage());
			pstmt.setString(5, bean.getKind());
			pstmt.setInt(6, bean.getPseq());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

	}
	//pagetotal
	public int total(String key) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		String sql ="select count(*) from product where name like '%'||?||'%' ";
		int total=0;
		conn = DBManager.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			if(key==null)
			{
				pstmt.setString(1, "%");
			}
			else
			{
				pstmt.setString(1, key);	
			}
			
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				total=rs.getInt(1);
			}
			
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			/*DBManager.close(conn, pstmt, rs);*/
		}

		return total;
	}
}
