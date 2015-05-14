package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import until.DBManager;

public class QnADao {
	private static QnADao instance = new QnADao();

	private QnADao() {
		// TODO Auto-generated constructor stub
	}

	public static QnADao getInstance() {
		return instance;
	}

	public List<QnABean> qnalist() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<QnABean> list = new ArrayList<>();
		String sql = "select * from qna";
		conn = DBManager.getConnection();

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				QnABean bean = new QnABean();
				bean.setQseq(rs.getInt("qseq"));
				bean.setSubject(rs.getString("subject"));
				bean.setContent(rs.getString("content"));
				bean.setId(rs.getString("id"));
				bean.setReply(rs.getString("reply"));
				bean.setIndate(rs.getTimestamp("indate"));
				bean.setRep(rs.getString("rep"));
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

	public void qnawrite(QnABean bean) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = " insert into qna(qseq,subject,content,id,rep,indate)"
				+ "values(qna_seq.nextval, ?, ?, ?,default,sysdate)";
		conn = DBManager.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getSubject());
			pstmt.setString(2, bean.getContent());
			pstmt.setString(3, bean.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

	}

	// 상세보기
	public QnABean qnaview(int qseq) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from qna where qseq = ?";
		QnABean bean = new QnABean();

		conn = DBManager.getConnection();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qseq);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				bean.setQseq(rs.getInt("qseq"));
				bean.setSubject(rs.getString("subject"));
				bean.setContent(rs.getString("content"));
				bean.setId(rs.getString("id"));
				bean.setReply(rs.getString("reply"));
				bean.setIndate(rs.getTimestamp("indate"));
				bean.setRep(rs.getString("rep"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return bean;
	}

	// 수정하기
	public void qnamodify(QnABean bean) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "update qna set subject = ?,content=? where qseq = ? and id=?";
		conn = DBManager.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getSubject());
			pstmt.setString(2, bean.getContent());
			pstmt.setInt(3, bean.getQseq());
			pstmt.setString(4, bean.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

	}
	//////////////////////////관리자/////////////////////////////////
	public List<QnABean> admin_qnalist(String key) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<QnABean> list = new ArrayList<>();
		String sql = "select * from qna where id like '%'||?||'%' order by indate desc";
		conn = DBManager.getConnection();

		try {
			pstmt = conn.prepareStatement(sql);
			if(key ==null)
			{
				pstmt.setString(1, "%");
				
			}else
			{
				pstmt.setString(1, key);	
			}
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				QnABean bean = new QnABean();
				bean.setQseq(rs.getInt("qseq"));
				bean.setSubject(rs.getString("subject"));
				bean.setContent(rs.getString("content"));
				bean.setId(rs.getString("id"));
				bean.setReply(rs.getString("reply"));
				bean.setIndate(rs.getTimestamp("indate"));
				bean.setRep(rs.getString("rep"));
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
	// 상세보기
		public QnABean admin_qnaview(int qseq) {
			// TODO Auto-generated method stub
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "select * from qna where qseq = ?";
			QnABean bean = new QnABean();

			conn = DBManager.getConnection();

			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, qseq);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					bean.setQseq(rs.getInt("qseq"));
					bean.setSubject(rs.getString("subject"));
					bean.setContent(rs.getString("content"));
					bean.setId(rs.getString("id"));
					bean.setReply(rs.getString("reply"));
					bean.setIndate(rs.getTimestamp("indate"));
					bean.setRep(rs.getString("rep"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
			return bean;
		}
		public void admin_qnareply(int qseq, String reply) {
			// TODO Auto-generated method stub
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "update qna set reply = ?,rep='2' where qseq= ?";
			conn = DBManager.getConnection();
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,reply);
				pstmt.setInt(2, qseq);
				pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}

		}

}
