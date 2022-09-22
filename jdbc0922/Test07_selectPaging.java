package jdbc0922;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test07_selectPaging {

	public static void main(String[] args) {
		// 페이징
		// 문제) sungjuk 테이블에서 이름순으로 정렬 후 행번호 4~6행만 조회하시오
		int start=4; //시작 행번호
		int end=6;	 //끝 행번호
		
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
	            
	            sql.append(" select sno, uname, kor, eng, mat, addr, tot, aver, wdate, rnum ");
	            sql.append(" from (\r\n"
	            		+ "        select sno, uname, kor, eng, mat, addr, tot, aver, wdate, rownum as rnum\r\n"
	            		+ "        from (\r\n"
	            		+ "               select sno, uname, kor, eng, mat, addr, tot, aver, wdate\r\n"
	            		+ "               from sungjuk order by uname\r\n"
	            		+ "              ) AA\r\n"
	            		+ "     ) BB\r\n"
	            		+ "where rnum>=? and rnum<=? ");
	         
	            
	            
	            pstmt=con.prepareStatement(sql.toString());
	            pstmt.setInt(1, start);
	            pstmt.setInt(2, end);
	                       
	            rs=pstmt.executeQuery(); 
	            
	            if(rs.next()) { 
	            	System.out.println("자료있음~~");       
	            	do {
	            		System.out.print(rs.getInt("rnum")+ " ");
		            	System.out.print(rs.getString("uname")+ " ");
		            	System.out.print(rs.getInt("kor")+ " ");
		            	System.out.print(rs.getInt("eng")+ " ");
		            	System.out.print(rs.getInt("mat")+ " ");
		            	System.out.print(rs.getInt("tot")+ " ");
		            	System.out.print(rs.getInt("aver")+ " ");
		            	System.out.print(rs.getString("addr")+ " ");
		            	System.out.print(rs.getString("wdate")+ " ");
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
