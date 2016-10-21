drop table address;
create table address (
		no number(4) primary key,
		id varchar2(6),
		name varchar2(20),
		phone varchar2(15),
		address varchar2(60)
);

drop sequence address_no_seq;
create sequence address_no_seq
start with 3;


DESCRIBE address;

insert into address values(1, 'id1', '�̸�1', '010-123-4567', '����� ���ı�');
insert into address values(address_no_seq.nextval, 'id'||address_no_seq.currval, '�̸�'||address_no_seq.currval, '010-1458-4751', '����� ������');

update address set address='FRANCE' where no > 5 and no <= 10;

delete from address where no in(1,3,5,7);



rollback;
commit;


select * 
from emp
where sal>1000 and sal<3000 and job = 'SALESMAN';


select * from emp;
select empno, ename, sal, job from emp where empno=7369;




