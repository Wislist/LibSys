CREATE TABLE announce (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          date DATE NOT NULL,
                          annText TEXT NOT NULL
);
INSERT INTO announce (date, annText) VALUES ('2024-06-08', '这是一条公告');
CREATE TABLE complain (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          stu VARCHAR(255) NOT NULL,
                          msg TEXT NOT NULL
);
insert into complain(stu,msg) values('张三','你好');
insert into complain(stu,msg) values('李四','你好');

CREATE TABLE appeal (
                        id INT(11) NOT NULL AUTO_INCREMENT,
                        stu VARCHAR(255) NOT NULL,
                        msg TEXT NOT NULL,
                        PRIMARY KEY (id)
);
insert into appeal(stu,msg) values('李四','你好');