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
   10011, '��ǰ�÷�����',
   '�ѱ��ڸ� �ȳ����',4000.123,to_date('06/12/24','yy/mm/dd'));
INSERT INTO s_product VALUES (
   10012, '���������',
   '����� ����3��',3000.1234,to_date('2006/12/24','yyyy/mm/dd'));
INSERT INTO s_product VALUES (
   10021, '�������̵���������',
   '��ȭ���ó׸�����',3000,to_date('2006/12/24','yyyy/mm/dd'));
INSERT INTO s_product VALUES (
   10022, '�������̵���������2',
   '��ȭ���ó׸�����2',4000.5,sysdate);

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


