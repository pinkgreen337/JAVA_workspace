--sungjuk테이블 행추가

insert into sungjuk(sno,uname,kor,eng,mat,addr,wdate)
values (sungjuk_seq.nextval,'손흥민',99,87,97,'Seoul',sysdate)

--오라클 콘솔창 예쁘게 출력

set linesize 1000;
col uname for a10; --col 칼럼명 for 20자
col addr for a10;

select *
from sungjuk
order by sno desc;

--문제) 주소가 서울인 행들의 국영수 평균값을 구하시오
--     (단, 소수점은 반올림해서 둘째자리값까지 표현)
1)주소가 서울인 행 조회하기
select addr, uname, kor, eng, mat 
from sungjuk
where addr='Seoul';

2)주소가 서울인 행을 대상으로 국영수 평균 구하기
select avg(kor), avg(eng), avg(mat)
from sungjuk
where addr='Seoul';

3)주소가 서울인 행을 대상으로 국영수 평균구하고 반올림해서 소수점 둘째자리까지 표현
select round(avg(kor),2), round(avg(eng),2), round(avg(mat),2)
from sungjuk
where addr='Seoul';

4)주소가 서울인 행을 대상으로 국영수 평균구하고 반올림해서 소수점 둘째자리까지 표현하고 칼럼명 변경
select round(avg(kor),2) as avg_kor,
round(avg(eng),2) as avg_eng, 
round(avg(mat),2) as avg_mat
from sungjuk
where addr='Seoul';



--문제) 이름에 '나' 문자 있는 행을 조회하시오
select *
from sungjuk
where uname like '%나%';


--// 문제) 학번 g1001이 수강신청한 과목을 과목코드별로 조회하시오
		/*	
				g1001  p001  OOP
				g1001  p003  JSP
				g1001  d001  웹표준
		 */
1)
select SU.hakno, SU.gcode, GW.gname
from tb_sugang SU join tb_gwamok GW
on SU.gcode=GW.gcode;

2)
select SU.hakno, SU.gcode, GW.gname
from tb_sugang SU join tb_gwamok GW
on SU.gcode=GW.gcode
where SU.hakno='g1001'
order by SU.gcode;

--문제) sungjuk 테이블에서 이름순으로 정렬 후 행번호 4~6행만 조회하시오
1)
select sno, uname, kor, eng, mat, addr, tot, aver, wdate,
rownum from sungjuk order by uname ;

2)
select sno, uname, kor, eng, mat, addr, tot, aver, wdate, rownum as rnum
from (
		select sno, uname, kor, eng, mat, addr, tot, aver, wdate
		from sungjuk order by uname ) AA;

3)
select sno, uname, kor, eng, mat, addr, tot, aver, wdate, rnum
from (
        select sno, uname, kor, eng, mat, addr, tot, aver, wdate, rownum as rnum
        from (
               select sno, uname, kor, eng, mat, addr, tot, aver, wdate
               from sungjuk order by uname
              ) AA
     ) BB
where rnum>=4 and rnum<=6;







