package oop0914;

import java.lang.*; // ← 자바의 기본 팩키지. 생략가능

public class Test01_wrapper {

	public static void main(String[] args) {
		
		// Wrapper class (포장클래스)
		// → 기본자료형을 참조형화 해놓은 클래스들 (클래스이름이 Wrapper가 아님)
		// → 대부분 java.lang 팩키지에 선언되어 있음
		/*
		 	기본형 			참조형(클래스)
		 	boolean			Boolean
		 	byte			Byte
		 	short			Short
		 	int				Integer
		 	long			Long
		 	float			Float
		 	double			Double
		 	char			Character
		 					   ↓
		 				  Wrapper class들
		 */
		/////////////////////////////////////////////////////////////
		
		boolean boo1=true;
		Boolean boo2=new Boolean("false");  //Deprecated 절판된 표현 (써도 되지만 추천하지 않음)
		Boolean boo3=true;
		
		System.out.println(boo1);
		System.out.println(boo2);
		System.out.println(boo3);
		System.out.println(boo3.toString()); //"true"
		/////////////////////////////////////////////////////////////
				
	    int in1=3;
	    Integer in2=new Integer("5");  //Deprecated
	    Integer in3=7;
	    
	    System.out.println(in1);
	    System.out.println(in2);
	    System.out.println(in3);

		System.out.println(in2.toString());		//"5"
		System.out.println(in3.doubleValue());	//7.0
		
		System.out.println(Integer.toBinaryString(15));	//2진수로 → "1111"
		System.out.println(Integer.toOctalString(15));	//8진수로 → "17"
		System.out.println(Integer.toHexString(15));	//16진수로 → "f"
		
		System.out.println(Integer.sum(2, 4)); //6
		System.out.println(Integer.max(2, 4)); //4
		System.out.println(Integer.min(2, 4)); //2
		
		//★★★
		System.out.println(Integer.parseInt("123")); //"123" → 123으로 변환
		
		//NumberFormatException Error 발생 - 형 변환에 맞지 않는 데이터 입력 시
		//System.out.println(Integer.parseInt("KOREA"));
		//////////////////////////////////////////////////////////////
				
		long lo1=3L;
		Long lo2=new Long(5);
		Long lo3=7L;
		
		double dou1=2.4;
		Double dou2=new Double("3.5");
		Double dou3=6.7;
	    //문)실수형 값들 중에서 정수의 합을 구하시오 (2+3+6)
		int hap=(int)dou1+dou2.intValue()+dou3.intValue();
		System.out.println(hap);
		
		//////////////////////////////////////////////////////////////
				
		char ch1='R';
		Character ch2='m';
		Character ch3=new Character('a');
		
		System.out.println(ch1);
		System.out.println(ch2);
		System.out.println(ch3);
		
		System.out.println(Character.isWhitespace(' '));
		System.out.println(Character.toLowerCase('R'));
		System.out.println(Character.toUpperCase('a'));
		
		
	}//main() end
}//class end
