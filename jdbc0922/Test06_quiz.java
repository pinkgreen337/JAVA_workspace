package jdbc0922;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test06_quiz {

	public static void main(String[] args) {
		// 문제) 학번 g1001이 수강신청한 과목을 과목코드별로 조회하시오
		/*	
				g1001  p001  OOP
				g1001  p003  JSP
				g1001  d001  웹표준
		 */
		
		String hakno="g1001";
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		   try {
	            String url     ="jdbc:oracle:thin:@localhost:1521:xe";
	            String user    ="system";
	            String password="1234";
	            String driver  ="oracle.jdbc.driver.OracleDriver"; //ojdbc8.jar
	            
	            //2)드라이버 로딩
	            Class.forName(driver);            
	            
	            //3)오라클 DB 서버 연결
	            con=DriverManager.getConnection(url, user, password);
	            
	            System.out.println("오라클DB 서버 연결 성공!!");  
	            StringBuilder sql=new StringBuilder();
	            
	            sql.append(" SELECT ST.hakno, GW.gcode, gname ");
	            sql.append(" FROM tb_student ST JOIN tb_sugang SU ");
	            sql.append(" ON ST.hakno=SU.hakno JOIN tb_gwamok GW ON SU.gcode=GW.gcode ");
	            sql.append(" WHERE ST.hakno=? ");
	            
	            pstmt=con.prepareStatement(sql.toString());            
	            pstmt.setString(1, hakno); 
	            
	            rs=pstmt.executeQuery();
	            
	            if(rs.next()) { 
	            	System.out.println("자료있음~~");       
	            	
	            	do {	
		            	System.out.print(rs.getString("hakno")+ " ");
		            	System.out.print(rs.getString("gcode")+ " ");
		            	System.out.print(rs.getString("gname")+ " ");
		            	System.out.println();
		            	
	            	}while(rs.next());
	            	
	            }else {
	            	System.out.println("자료없음!!");
	            }//if end            
	            
	        }catch (Exception e) {
	            System.out.println("오라클 DB 연결 실패 : " + e);
	        }finally {
	        	try {
	        		if(rs!=null) { rs.close(); }
	        	}catch (Exception e) {}
	        	
	        	try {
	        		if(pstmt!=null) {pstmt.close();}
	        	}catch (Exception e) {}
	        	
	        	try {
	        		if(con!=null) {con.close();}
	        	}catch (Exception e) {}
	        }//end
		   
		   System.out.println("END");
		
		
		
	}//main() end
}//class end
