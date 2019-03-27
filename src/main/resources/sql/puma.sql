DROP TABLE verify;
DROP TABLE invite;
DROP TABLE good;
DROP TABLE moment;
DROP TABLE user;
DROP TABLE team;
CREATE table team
(
  teamId       INT AUTO_INCREMENT PRIMARY KEY,
  teamName     VARCHAR(45),
  introduction VARCHAR(200) NOT NULL,
  bagSum       INT          NOT NULL DEFAULT 0

)
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE user
(
  userId           VARCHAR(45) NOT NULL PRIMARY KEY,
  userName         VARCHAR(45) NOT NULL,
  teamId           INT                  DEFAULT -1 REFERENCES team (teamId) ON DELETE SET NULL,
  registrationDate DATE        NOT NULL,
  score            INT         NOT NULL DEFAULT 0,
  bag              INT         NOT NULL DEFAULT 0,
  postcard         INT         NOT NULL DEFAULT 0,
  voucher          INT         NOT NULL DEFAULT 0,
  avatarUrl        VARCHAR(300)         DEFAULT NULL,
  pku              BOOLEAN     NOT NULL DEFAULT 0
)
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE moment
(
  momentId   INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  momentDate DATETIME     NOT NULL,
  bag        INT                   DEFAULT 0,
  content    VARCHAR(200)          DEFAULT NULL,
  imageUrl   VARCHAR(300) NULL,
  position   VARCHAR(100)          DEFAULT NULL,
  ssyd     BOOLEAN      NOT NULL DEFAULT 0,
  userId     VARCHAR(45)  NOT NULL REFERENCES user (userId) ON DELETE CASCADE,
  good       INT                   DEFAULT 0
)
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE good
(
  userId   VARCHAR(45) NOT NULL REFERENCES user (userId) ON DELETE CASCADE,
  momentId INT         NOT NULL REFERENCES moment (momentId) ON DELETE CASCADE,
  PRIMARY KEY (userId, momentId)
)
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE invite
(
  alpha VARCHAR(45) NOT NULL REFERENCES user (userId) ON DELETE CASCADE,
  beta  VARCHAR(45) NOT NULL REFERENCES user (userId) ON DELETE CASCADE,
  code  VARCHAR(45) NOT NULL,
  PRIMARY KEY (alpha, beta)
)
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE verify
(
  userId VARCHAR(45) NOT NULL REFERENCES user (userId) ON DELETE CASCADE,
  code   VARCHAR(45) NOT NULL,
  PRIMARY KEY (userId, code)
)
  DEFAULT CHARSET = utf8mb4;

INSERT INTO team(teamId, teamName, introduction)
VALUES (0, 'puma', 'mapku');
INSERT INTO user(userId, userName, registrationDate, teamId)
VALUES ('test', 'lisong', '1926-8-15', 0);