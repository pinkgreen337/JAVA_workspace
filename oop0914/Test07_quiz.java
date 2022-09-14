package oop0914;

import java.util.Scanner;

public class Test07_quiz {

	public static void main(String[] args) {
		// 연습문제
		
		//문1)주민번호의 각 숫자의 합을 구하시오 (Character클래스와 charAt()함수 이용)
        //   8+9+1+2+3+0+1+2+3+4+5+6+7
		//String jumin="8912301234567";
		
		String input;
		int result=0;
		
		Scanner scanner=new Scanner("8912301234567");
		System.out.println("문자열을 입력하세요 : 8912301234567");
		input=scanner.nextLine();
		
		for(int i=0; i<input.length(); i++) {
			result+=(input.charAt(i)-'0');
		}
		
		System.out.println(input+"의 각 숫자의 합:"+result);
		
		
		
		//문2)대소문자를 서로 바꿔서 출력하시오 (Character클래스와 charAt()함수 이용)
        //   gONE wITH tHE wIND
        String str="Gone With The Wind";
		String result2="";
		for(char c : str.toCharArray()) {
			if(Character.isUpperCase(c)) {//대문자
				result2+=Character.toLowerCase(c);
			}else if(Character.isLowerCase(c)) {//소문자
				result2+=Character.toUpperCase(c);
			}else {
				result2+=c;
			}
		}
		System.out.println("--------------------------");
		System.out.println(result2);
        
		
	}//main() end
}//class end
