package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import until.DBManager;


public class MemberDao {
	private static MemberDao instance = new MemberDao();
	public static MemberDao getInstance ()
	{return instance;}
	private  MemberDao() {
		// TODO Auto-generated constructor stub
		super();}
	//id 찾기
		public String findid(String name,String phone)
		{
			PreparedStatement pstmt =null;
			ResultSet rs =null;
			Connection conn=null;
			String sql="select id from member where name = ? and phone = ?";
			String result = "";
			
			conn = DBManager.getConnection();
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,name);
				pstmt.setString(2,phone);
				rs = pstmt.executeQuery();
				
				if(rs.next())
				{
				result = rs.getString("id");
				}else
				{
					result = null;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally
			{
				DBManager.close(conn, pstmt, rs);
			}
			
			return result;
		}
	
	//비번 찾기
				public String findpw(String id,String phone)
				{
					PreparedStatement pstmt =null;
					ResultSet rs =null;
					Connection conn=null;
					String sql="select pwd from member where id = ? and phone = ?";
					String result = "";
					
					conn = DBManager.getConnection();
					try {
						pstmt = conn.prepareStatement(sql);
						pstmt.setString(1,id);
						pstmt.setString(2,phone);
						rs = pstmt.executeQuery();
						if(rs.next())
						{
						result = rs.getString("pwd");
						}else
						{
							result =null;
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally
					{
						DBManager.close(conn, pstmt, rs);
					}
					
					return result;
				}
	
	//상세보기 && 정보수정하기
			public MemberBean getByid(String id)
			{
				PreparedStatement pstmt =null;
				ResultSet rs =null;
				Connection conn=null;
				MemberBean bean = new MemberBean();
				String sql="select * from member where id = ?";
				conn = DBManager.getConnection();
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1,id);
					rs = pstmt.executeQuery();
					
					while(rs.next())
					{
						bean.setId(rs.getString("id"));
						bean.setPwd(rs.getString("pwd"));
						bean.setName(rs.getString("name"));
						bean.setEmail(rs.getString("email"));
						bean.setZipcode(rs.getString("zip_num"));
						bean.setAddress(rs.getString("address"));
						bean.setPhone(rs.getString("phone"));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally
				{
					DBManager.close(conn, pstmt, rs);
				}
				
				return bean;
			}
	//login 
		public int login(String id,String pwd)
		{
			PreparedStatement pstmt =null;
			ResultSet rs =null;
			Connection conn=null;
			String sql="select * from member where id = ?";
			int result = -1;
			conn = DBManager.getConnection();
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,id);
				rs = pstmt.executeQuery();
				
				if(rs.next())
				{
					if(pwd.equals(rs.getString("pwd")))
					{
						return result = 1;
					}else
					{
						result = 0;
					}
				}else
				{
					result = -1;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally
			{
				DBManager.close(conn, pstmt, rs);
			}
			
			return result;
		}
		//관리자login 
				public int admin_login(String id,String pwd)
				{
					PreparedStatement pstmt =null;
					ResultSet rs =null;
					Connection conn=null;
					String sql="select * from worker where id = ?";
					int result = -1;
					conn = DBManager.getConnection();
					try {
						pstmt = conn.prepareStatement(sql);
						pstmt.setString(1,id);
						rs = pstmt.executeQuery();
						
						if(rs.next())
						{
							if(pwd.equals(rs.getString("pwd")))
							{
								return result = 1;
							}else
							{
								result = 0;
							}
						}else
						{
							result = -1;
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally
					{
						DBManager.close(conn, pstmt, rs);
					}
					
					return result;
				}
	//id중복체크 
	public int idcheck(String id)
	{
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		Connection conn=null;
		System.out.println("요기");
		String sql="select * from member where id = ?";
		int result = 0;
		
		conn = DBManager.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				result = 1;
			}else
			{
				result = -1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			DBManager.close(conn, pstmt, rs);
		}
		
		return result;
	}
	//회원가입
	public void join(MemberBean bean)
	{
		PreparedStatement pstmt =null;
		Connection conn=null;
		String sql="insert into member(id,pwd,name,email,zip_num,address,phone,useyn,indate)"
				+ "values(?,?,?,?,?,?,?,default,sysdate)";
		
		conn = DBManager.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getId());
			pstmt.setString(2, bean.getPwd());
			pstmt.setString(3, bean.getName());
			pstmt.setString(4, bean.getEmail());
			pstmt.setString(5, bean.getZipcode());
			pstmt.setString(6, bean.getAddress());
			pstmt.setString(7, bean.getPhone());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			DBManager.close(conn, pstmt);
		}
		
	}
	//회원정보 수정
		public void memberUpdate(MemberBean bean)
		{
			
			PreparedStatement pstmt =null;
			Connection conn=null;
			String sql="update member set pwd = ? , email = ?, zip_num = ?, address = ?,"
					+ "phone = ? where id = ?";
			
			conn = DBManager.getConnection();
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, bean.getPwd());
				pstmt.setString(2, bean.getEmail());
				pstmt.setString(3, bean.getZipcode());
				pstmt.setString(4, bean.getAddress());
				pstmt.setString(5, bean.getPhone());
				pstmt.setString(6, bean.getId());
				
				pstmt.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally
			{
				DBManager.close(conn, pstmt);
			}
			
		}
		//관리자  $$ 이름으로 회원정보검색
				public List<MemberBean> memberlist(String key)
				{
					PreparedStatement pstmt =null;
					ResultSet rs =null;
					Connection conn=null;
					String sql="select *from member where name like '%'||?||'%'"
							+ "order by indate desc";
					List<MemberBean> list = new ArrayList<>();
					
					conn = DBManager.getConnection();
					try {
						pstmt = conn.prepareStatement(sql);
						if(key == "")
						{
							pstmt.setString(1,"%");	
						}else

						{
							pstmt.setString(1,key);	
						}
		
						rs = pstmt.executeQuery();
						
						while(rs.next())
						{
							MemberBean bean = new MemberBean();
							bean.setName(rs.getString("name"));
							bean.setId(rs.getString("id"));
							bean.setAddress(rs.getString("address"));
							bean.setDate(rs.getTimestamp("indate"));
							bean.setPhone(rs.getString("phone"));
							bean.setEmail(rs.getString("email"));
							
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
}
