DROP TABLE IF EXISTS USER;

CREATE TABLE USER (

  id INTEGER AUTO_INCREMENT PRIMARY KEY,
  EMAIL_ADDRESS VARCHAR2(255)

);

ALTER TABLE USER ADD CONSTRAINT EMAIL_UNIQUE UNIQUE(EMAIL_ADDRESS);