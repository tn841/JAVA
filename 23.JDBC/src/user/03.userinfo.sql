DROP TABLE userinfo;
CREATE TABLE userinfo (userId varchar2(12) PRIMARY KEY,password varchar2(12) NOT NULL,name varchar2(20) NOT NULL,email varchar2(50));
INSERT INTO userinfo VALUES('guard', 'guard', '±Ë∞Ê»£', 'guard@naver.com');