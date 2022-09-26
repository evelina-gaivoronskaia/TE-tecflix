BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS movie;
DROP TABLE IF EXISTS account;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE movie (
    movie_id SERIAL,
    genre VARCHAR(25) NOT NULL,
    release_year VARCHAR(15) NOT NULL,
    director VARCHAR(30) NOT NULL,
    title VARCHAR(50) NOT NULL,
    summary VARCHAR(200) NOT NULL,
    movie_img TEXT,
    
    CONSTRAINT PK_movie PRIMARY KEY (movie_id)
);

CREATE TABLE account (
    account_id SERIAL,
    user_id int,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email_address VARCHAR(100) NOT NULL,
    time_zone VARCHAR(10) NOT NULL,
    email_list BOOLEAN NOT NULL,
    
    CONSTRAINT PK_account PRIMARY KEY (account_id),
    CONSTRAINT FK_account_users FOREIGN KEY (user_id) REFERENCES users (user_id)
);

COMMIT TRANSACTION;
