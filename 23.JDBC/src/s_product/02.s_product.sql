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
/*   
INSERT INTO s_product VALUES (?,?,?,?,to_date(?,'yyyy/mm/dd'));   
INSERT INTO s_product VALUES (?,?,?,?,?);
*/  

commit;

select * from s_product;


create sequence s_product_id_seq
start with 8000;

INSERT INTO s_product VALUES (s_product_id_seq.nextval,'�̸�','����',1000,sysdate);


     ��    