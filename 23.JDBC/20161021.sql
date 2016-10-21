drop table s_product;

CREATE TABLE s_product
(
 id                         NUMBER(7) primary key,
 name                       VARCHAR2(50),
 short_desc                 VARCHAR2(255),
 price 			    NUMBER(10,3),
 ipgo_date		    DATE
 );
 
 INSERT INTO s_product VALUES (
   10011, '명품플러스원',
   '한글자막 안내기능',4000.123,to_date('06/12/24','yy/mm/dd'));
INSERT INTO s_product VALUES (
   10012, '장수명브라운관',
   '브라운관 수명3배',3000.1234,to_date('2006/12/24','yyyy/mm/dd'));
INSERT INTO s_product VALUES (
   10021, '액정와이드프로젝션',
   '고화질시네마비젼',3000,to_date('2006/12/24','yyyy/mm/dd'));
INSERT INTO s_product VALUES (
   10022, '액정와이드프로젝션2',
   '고화질시네마비젼2',4000.5,sysdate);

commit;

select * from S_PRODUCT;

desc S_PRODUCT;


select * from emp;

CREATE SEQUENCE emp_no_seq
START WITH 1;

 CREATE SEQUENCE  "USER21"."ADDRESS_NO_SEQ"  
 MINVALUE 1 
 MAXVALUE 9999999999999999999999999999 
 INCREMENT BY 1 
 START WITH 23 
 CACHE 20 
 NOORDER  
 NOCYCLE ;


