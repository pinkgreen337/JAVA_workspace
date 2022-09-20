import java.io.FileReader;

public class TypeTest {

	public static void main(String[] args) {
		// CMD 명령어 type 작성하기	(파일 내용 보기)
		// 결과확인 CMD 창에서 실습합니다
		// 모든 한글을 삭제한 실습
		
		// >javac TypeTest.java			컴파일하기
		// >java TypeTet 대상파일			자바클래스 실행하기

		String filename=args[0];
		FileReader fr=null;
		
		try {
			
			fr=new FileReader(filename);
			
			while(true) {
				int data=fr.read(); //2바이트 읽기
				if(data==-1) {
					break;
				}//if end
				System.out.printf("%c", data);
			}//while end
			
			
		}catch (Exception e) {
			System.out.println("File Not Found!!" + e);
		}finally {
			//자원 반납
			try {
				if(fr!=null) { fr.close(); }
			}catch (Exception e) {}
		}//end
		

	}//main() end
}//class end
