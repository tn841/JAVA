DROP TABLE userinfo;

CREATE TABLE userinfo (
  userId varchar2(12) PRIMARY KEY,
  password varchar2(12) NOT NULL,
  name varchar2(20) NOT NULL,
  email varchar2(50)
);

INSERT INTO userinfo VALUES('guard', 'guard', '±è°æÈ£', 'guard@naver.com');

desc userinfo;


update userinfo set EMAIL; where userid = 'ddd';

update address set address='FRANCE' where no > 5 and no <= 10;