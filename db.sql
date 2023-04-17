DROP TABLE USERS CASCADE CONSTRAINTS PURGE;
DROP TABLE DATOS CASCADE CONSTRAINTS PURGE;
DROP TABLE ITEM CASCADE CONSTRAINTS PURGE;
DROP TABLE ITEM_GENRE CASCADE CONSTRAINTS PURGE;
DROP TABLE INFO CASCADE CONSTRAINTS PURGE;
DROP TABLE GENRE CASCADE CONSTRAINTS PURGE;
DROP TABLE OCCUPATION CASCADE CONSTRAINTS PURGE;


CREATE TABLE info (
    users NUMBER,
    items NUMBER,
    ratings NUMBER
);

CREATE TABLE genre (
    id NUMBER PRIMARY KEY,
    genre VARCHAR2(100)
);


CREATE TABLE occupation (
    occupation_name VARCHAR2(100) PRIMARY KEY
);

CREATE TABLE item (
    id NUMBER PRIMARY KEY,
    title VARCHAR2(100),
    releasedate VARCHAR2(50),
    videorelease VARCHAR2(200),
    url VARCHAR2(300)
);



CREATE TABLE item_genre (
    item_id NUMBER REFERENCES item(id),
    genre_id NUMBER REFERENCES genre(id),
    PRIMARY KEY (item_id, genre_id)
);


CREATE TABLE users (
    id NUMBER PRIMARY KEY,
    age NUMBER,
    gender VARCHAR2(1),
    occupation_name VARCHAR2(100),
    zipcode VARCHAR(100),
    CONSTRAINT fk_occupation_name FOREIGN KEY (occupation_name) REFERENCES 
occupation(occupation_name)
);

CREATE TABLE datos (
    userid NUMBER,
    itemid NUMBER,
    rating NUMBER,
    timestamp VARCHAR2(100),
    CONSTRAINT fk_userid FOREIGN KEY (userid) REFERENCES users(id),
    CONSTRAINT fk_itemid FOREIGN KEY (itemid) REFERENCES item(id)
);


