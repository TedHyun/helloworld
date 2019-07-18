 package test.bean.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import test.bean.vo.MemberVO;

import java.sql.DriverManager;
public class MemberDAO {
	private static MemberDAO instance = new MemberDAO();
	public static MemberDAO getInstance() {
		return instance;	
	}
	private MemberDAO() {
	}
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private Connection getConnection() {
		try {
			Context ctx = new InitialContext(); // context.xml Á¤º¸ È¹µæ
			Context env = (Context)ctx.lookup("java:comp/env");
			DataSource ds = (DataSource)env.lookup("jdbc/xe");
			conn = ds.getConnection();
		}
		catch (Exception e){
			e.printStackTrace();		
		}
		return conn;	
	}
	
	public boolean loginCheck(String id , String pw) {
		boolean result =false;
		try {
			conn = getConnection();
			String sql = "select * from test2 where id=? and pw= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if(rs != null) {
				try {rs.close();}catch(SQLException s) {}
				}	
			if(pstmt != null) {
				try {pstmt.close();}catch(SQLException s) {}
				}		
			if(conn != null) {
				try {conn.close();}catch(SQLException s) {}
				}
		}
		return result;
	}
	public void insertMember(MemberVO vo) {
		try {
			conn = getConnection();
			String sql="insert into test2 values(?,?,?,?,sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,vo.getId());
			pstmt.setString(2,vo.getPw());
			pstmt.setString(3,vo.getName());
			pstmt.setInt(4,vo.getAge());
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			
		}finally {
			if(pstmt != null) {
				try {pstmt.close();}catch(SQLException s) {}
				}		
			if(conn != null) {
				try {conn.close();}catch(SQLException s) {}
				}	
		}	
	}

	public ArrayList<MemberVO> getAllMember(){
		ArrayList<MemberVO> list = null;
		try {
			conn = getConnection();
			String sql = "select * from test2";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = new ArrayList<MemberVO>();
			while(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setPw(rs.getString("pw"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setReg(rs.getTimestamp("reg"));
				list.add(vo);
				
			}
	}catch(Exception e){
		e.printStackTrace();
	}finally {
		if(rs != null) {
			try {rs.close();}catch(SQLException s) {}
			}	
		if(pstmt != null) {
			try {pstmt.close();}catch(SQLException s) {}
			}		
		if(conn != null) {
			try {conn.close();}catch(SQLException s) {}
			}
		}
	return list;
	}
}
