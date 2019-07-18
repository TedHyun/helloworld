package frame.spring.vo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.sql.DataSource;

public class LoginDAO {
		
		private static LoginDAO instance = new LoginDAO();
		
		public static LoginDAO getInstance() {
			return instance;
		}
		private LoginDAO() {}
		
		private Connection conn = null;
		private PreparedStatement pstmt = null;
		private ResultSet rs = null;
		private String sql;
		
		public Connection getConnection() throws Exception {
			try {
			Context ctx = new InitialContext();
			Context env = (Context)ctx.lookup("java:comp/env");
			DataSource ds = (DataSource)env.lookup("jdbc/xe");
			conn = ds.getConnection();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} 
			return conn;
		}
		public int Logincheck(String id,String passwd) {
			int x =-1;
			String dbpasswd = null;
			try {	
					conn= getConnection();
					String sql = "select * from member where id= ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, id);
					rs = pstmt.executeQuery();
					if(rs.next()){
						dbpasswd= rs.getString("passwd"); 
						if(dbpasswd.equals(passwd)) {
							x= 1;} //인증 성공
						else {
							x= 0;} //비밀번호 틀림
					}else
						x= -1;//해당 아이디 없음
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if(rs != null) {try {rs.close();}catch(SQLException s) {}}	  
				if(pstmt != null) {try {pstmt.close();}catch(SQLException s) {}}
			    if(conn != null) {try {conn.close();}catch(SQLException s) {}}
				}
			return x;
		}
}
