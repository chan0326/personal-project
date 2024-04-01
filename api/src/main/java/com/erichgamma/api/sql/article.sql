DROP PROCEDURE IF EXISTS insertLoop;
CREATE PROCEDURE insertLoop()
BEGIN
    DECLARE i INT DEFAULT 1;
    WHILE i <= 50
        DO
            INSERT INTO articles(id, title, content, writer, register_date)
            VALUES (i, concat('title', i), concat('content', i), i, concat('registerDate', i));
            SET i = i + 1;
END WHILE;
END;

CALL insertLoop;
select * from articles;


DROP PROCEDURE IF EXISTS insertLoop;
CREATE PROCEDURE insertLoop()
BEGIN
    DECLARE i INT DEFAULT 1;
    WHILE i <= 10
        DO
            INSERT INTO users(id, username, password, name, phone,job)
            VALUES (i, concat('username', i), concat('password', i), concat('name', i), concat('phone', i),concat('job', i));
            SET i = i + 1;
        END WHILE;
END;

CALL insertLoop;
select * from users;