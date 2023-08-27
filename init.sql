CREATE DATABASE IF NOT EXISTS cheval;
USE cheval;

CREATE TABLE IF NOT EXISTS RACECHEVAL
(
    id int auto_increment,
    nom varchar(80),
    libelle varchar(80),
    description varchar(255),
    CONSTRAINT PK_RACE PRIMARY KEY (id)
    )ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS COURSE
(
    id int auto_increment,
    nom varchar(30),
    lieu varchar(30),
    date date,
    CONSTRAINT PK_COURSE PRIMARY KEY (id)

    )ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS CLIENT
(
    id int auto_increment,
    titre varchar(30),
    nom varchar(30),
    prenom varchar(30),
    rue varchar(55),
    copos varchar(5),
    ville varchar(50),
    adresseMessagerie varchar(80),
    CONSTRAINT PK_CLIENT_ID PRIMARY KEY (id)

    )ENGINE=INNODB;



CREATE TABLE IF NOT EXISTS CHEVAL
(
    id       int auto_increment,
    nom      varchar(80),
    sex      varchar(80),
    birthday date,
    race     int,
    client_id int,
    CONSTRAINT PK_CHEVAL PRIMARY KEY (id),
    CONSTRAINT FK_CHEVAL_RACE FOREIGN KEY (race)
    REFERENCES CLIENT(id),
    CONSTRAINT FK_CHEVAL_CLIENT FOREIGN KEY (client_id)
    REFERENCES RACECHEVAL (id)
    )ENGINE=INNODB;


CREATE TABLE IF NOT EXISTS PARTICIPATION
(
    id_cheval int,
    id_course int,
    classement int,
    CONSTRAINT PK_ID_CHEVAL_COURSE PRIMARY KEY (id_cheval, id_course),
    CONSTRAINT FK_ID_CHEVAL FOREIGN KEY (id_cheval)
    REFERENCES CHEVAL (id),
    CONSTRAINT FK_ID_COURSE FOREIGN KEY (id_course)
    REFERENCES COURSE (id)

    )ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS ACHETEUR
(
    client_id int,
    date_premiere_achat date,
    CONSTRAINT PK_CLIENT_ACHETEUR PRIMARY KEY (client_id),
    CONSTRAINT FK_CLIENT_ACHETEUR FOREIGN KEY (client_id)
    REFERENCES CLIENT(id)
    )ENGINE=INNODB;


CREATE TABLE IF NOT EXISTS VENDEUR
(
    client_id int,
    ca int,
    CONSTRAINT PK_CLIENT_VENDEUR PRIMARY KEY (client_id),
    CONSTRAINT FK_CLIENT_VENDEUR FOREIGN KEY (client_id)
    REFERENCES CLIENT(id)
    )ENGINE=INNODB

