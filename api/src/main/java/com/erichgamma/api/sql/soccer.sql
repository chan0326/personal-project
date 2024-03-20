-- soccer JPA 버전
CREATE TABLE stadium
(

    id           INTEGER,
    stadium_name varchar(40),
    hometeam_id  varchar(10),
    seat_count   INTEGER,
    address      varchar(60),
    ddd          varchar(10),
    tel          varchar(10),
    PRIMARY KEY (id)
);

CREATE TABLE team
(
    id          INTEGER,
    stadium_id  INTEGER,
    region_name varchar(10),
    team_name   varchar(40),
    e_team_name varchar(50),
    orig_yyy    varchar(10),
    zip_code1   varchar(10),
    zip_code2   varchar(10),
    address     varchar(80),
    ddd         varchar(10),
    tel         varchar(10),
    fax         varchar(10),
    homepage    varchar(50),
    owner       varchar(10),
    PRIMARY KEY (id),
    FOREIGN KEY (stadium_id) references stadium(id)

);
CREATE TABLE schedule
(
    id          INTEGER,
    gubun       varchar(10),
    hometeam_id varchar(10),
    awayteam_id varchar(10),
    home_score  INTEGER,
    away_score  INTEGER,
    stadium_id  INTEGER,
    PRIMARY KEY (id),
    FOREIGN KEY (stadium_id) references stadium(id)
);
CREATE TABLE player
(
    id            INTEGER,
    player_name   varchar(20),
    e_player_name varchar(40),
    nickname      varchar(30),
    join_yyyy     varchar(10),
    pdsition      varchar(10),
    back_no       INTEGER,
    nation        varchar(20),
    birth_date    DATE,
    solar         varchar(10),
    height        INTEGER,
    weight        INTEGER,
    team_id       INTEGER,
    PRIMARY KEY (id),
    FOREIGN KEY (team_id) references team(id)
);
DROP TABLE IF EXISTS player;
DROP TABLE IF EXISTS team;
DROP TABLE IF EXISTS stadium;
DROP TABLE IF EXISTS schedule;