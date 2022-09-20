package oop0920;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Test05_sungjuk {

	public static void main(String[] args) {
		// 문제) 성적프로그램
		// 성적 입력 자료(sungjuk.txt)를 가져와서, 성적 결과 파일 완성하기(result.txt)
		/*
		  	1) 입력 데이터 파일 : sungjuk.txt
		  	
		  	2) 결과 파일 : result.txt
		  	       ----------------------------------------------
								성 / 적 / 결 /과
              -------------------------------------------------------
              이름     국어   영어  수학   평균  등수   결과
              -------------------------------------------------------
			  라일락    100  100  100   100   1    합격 ********** 장학생
              진달래     50   55   60    55   4    불합격 *****
              개나리     95   95   35    75   3    재시험 *******
			  무궁화     80   85   90    85   2    합격 ********
              홍길동     60   40   30    43   5    불합격 ****
              ------------------------------------------------------		  	
		 */
		String[] name= {"라일락", "진달래", "개나리", "무궁화", "홍길동"};
		
		int[] kor= {100, 50, 95, 80, 60};
	
		int[] eng= {100, 55, 95, 85, 40};
		
		int[] mat= {100, 60, 35, 90, 30};
	
		for(int i=0; i<5; i++) {
			System.out.print(name[i] + kor[i] + eng[i] + mat[i]);
		}
		
		/*
		int[] aver= {0,0,0,0,0};
		for(int i=0; i<5; i++) {
			aver[i]=(kor[i]+eng[i]+mat[i])/3;
		}
		System.out.println(aver[i]);
		*/
		
		 
		String inName  = "I:/java202207/sungjuk.txt";
		String outName = "I:/java202207/result.txt";
		
		FileReader fr=null;
		BufferedReader br=null;
		
		FileWriter fw=null;
		PrintWriter out=null;
		
		
		try {
			
		}catch (Exception e) {
			System.out.println("성적 프로그램 읽고, 쓰기 실패 : " + e);
		}finally {
			try {
				if(br!=null) { br.close(); }
			}catch (Exception e) {}
			try {
				if(out!=null) { out.close(); }
			}catch (Exception e) {}
			try {
				if(fw!=null) { fw.close(); }
			}catch (Exception e) {}
		}//end

	}//main() end
}//class end
