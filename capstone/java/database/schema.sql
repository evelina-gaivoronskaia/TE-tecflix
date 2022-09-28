BEGIN TRANSACTION;

DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS movie CASCADE;
DROP TABLE IF EXISTS account CASCADE;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE movie (
    movie_id SERIAL,
    --genre_name VARCHAR(100) NOT NULL,
    release_date VARCHAR(15) NOT NULL,
    --director VARCHAR(100) NOT NULL,
    title VARCHAR(50) NOT NULL,
    summary VARCHAR(1000) NOT NULL,
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

CREATE TABLE genre (
    genre_id int NOT NULL,
    genre_name varchar(50) NOT NULL,
	CONSTRAINT PK_genre PRIMARY KEY(genre_id)
);

CREATE TABLE movie_genre (
    movie_id int NOT NULL,
    genre_id int NOT NULL,
	CONSTRAINT PK_movie_genre PRIMARY KEY(movie_id, genre_id),
    CONSTRAINT FK_movie_genre_movie FOREIGN KEY(movie_id) REFERENCES movie(movie_id),
    CONSTRAINT FK_movie_genre_genre FOREIGN KEY(genre_id) REFERENCES genre(genre_id)
);

INSERT INTO genre (genre_id, genre_name) VALUES (28, 'Action');
INSERT INTO genre (genre_id, genre_name) VALUES (12, 'Adventure');
INSERT INTO genre (genre_id, genre_name) VALUES (16, 'Animation');
INSERT INTO genre (genre_id, genre_name) VALUES (35, 'Comedy');
INSERT INTO genre (genre_id, genre_name) VALUES (80, 'Crime');
INSERT INTO genre (genre_id, genre_name) VALUES (99, 'Documentary');
INSERT INTO genre (genre_id, genre_name) VALUES (18, 'Drama');
INSERT INTO genre (genre_id, genre_name) VALUES (10751, 'Family');
INSERT INTO genre (genre_id, genre_name) VALUES (14, 'Fantasy');
INSERT INTO genre (genre_id, genre_name) VALUES (36, 'History');
INSERT INTO genre (genre_id, genre_name) VALUES (27, 'Horror');
INSERT INTO genre (genre_id, genre_name) VALUES (10402, 'Music');
INSERT INTO genre (genre_id, genre_name) VALUES (9648, 'Mystery');
INSERT INTO genre (genre_id, genre_name) VALUES (10749, 'Romance');
INSERT INTO genre (genre_id, genre_name) VALUES (878, 'Science Fiction');
INSERT INTO genre (genre_id, genre_name) VALUES (10770, 'TV Movie');
INSERT INTO genre (genre_id, genre_name) VALUES (53, 'Thriller');
INSERT INTO genre (genre_id, genre_name) VALUES (10752, 'War');
INSERT INTO genre (genre_id, genre_name) VALUES (37, 'Western');

--INSERT INTO movie (genre, release_year, director, title, summary, movie_img) VALUES ('crime', '1995', 'David Fincher', 'Se7en', 'When retiring police Detective William Somerset tackles a final case with the aid of newly transferred David Mills, they discover a number of elaborate and grizzly murders. They soon realize they are dealing with a serial killer who is targeting people he thinks represent one of the seven deadly sins. Somerset also befriends Mills wife, Tracy, who is pregnant and afraid to raise her child in the crime-riddled city.', 'https://upload.wikimedia.org/wikipedia/en/6/68/Seven_%28movie%29_poster.jpg');
--INSERT INTO movie (genre, release_year, director, title, summary, movie_img) VALUES ('crime', '1972', 'Francis Ford Coppola', 'The Godfather', 'The aging patriarch of an organized crime dynasty in postwar New York City transfers control of his clandestine empire to his reluctant youngest son.', 'https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_UY98_CR1,0,67,98_AL_.jpg');
--INSERT INTO movie (genre, release_year, director, title, summary, movie_img) VALUES ('crime', '2000', 'Mary Harron', 'American Psycho', 'A wealthy New York City investment banking executive, Patrick Bateman, hides his alternate psychopathic ego from his co-workers and friends as he delves deeper into his violent, hedonistic fantasies.', 'https://m.media-amazon.com/images/M/MV5BZTM2ZGJmNjQtN2UyOS00NjcxLWFjMDktMDE2NzMyNTZlZTBiXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_UX67_CR0,0,67,98_AL_.jpg');
--INSERT INTO movie (genre, release_year, director, title, summary, movie_img) VALUES ('drama', '2022', 'Darren Aronofsky', 'The Whale', 'A reclusive English teacher living with severe obesity attempts to reconnect with his estranged teenage daughter for one last chance at redemption.', 'https://m.media-amazon.com/images/M/MV5BZTMzY2I4MmYtOWEzMi00MTE4LWJmZjctODQ0NzYyMjk1NWMzXkEyXkFqcGdeQXVyMjQwMDg0Ng@@._V1_UY98_CR31,0,67,98_AL_.jpg');
--INSERT INTO movie (genre, release_year, director, title, summary, movie_img) VALUES ('drama', '1994', 'Frank Darabont', 'The Shawshank Redemption', 'Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.', 'https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_UX67_CR0,0,67,98_AL_.jpg');
--INSERT INTO movie (genre, release_year, director, title, summary, movie_img) VALUES ('drama', '1999', 'David Fincher', 'Fight Club', 'An insomniac office worker and a devil-may-care soap maker form an underground fight club that evolves into much more.', 'https://m.media-amazon.com/images/M/MV5BNDIzNDU0YzEtYzE5Ni00ZjlkLTk5ZjgtNjM3NWE4YzA3Nzk3XkEyXkFqcGdeQXVyMjUzOTY1NTc@._V1_UX67_CR0,0,67,98_AL_.jpg');
--INSERT INTO movie (genre, release_year, director, title, summary, movie_img) VALUES ('comedy', '2008', 'Adam Mckay', 'Step Brothers', 'Two aimless middle-aged losers still living at home are forced against their will to become roommates when their parents marry.', 'https://m.media-amazon.com/images/M/MV5BODViZDg3ZjYtMzhiYS00YTVkLTk4MzktYWUxMTlkYjc1NjdlXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_UY209_CR0,0,140,209_AL_.jpg');
--INSERT INTO movie (genre, release_year, director, title, summary, movie_img) VALUES ('comedy', '2004', 'Keenan Ivory Wayans', 'White Chicks', 'Two disgraced FBI agents go way undercover in an effort to protect hotel heiresses the Wilson sisters from a kidnapping plot.', 'https://m.media-amazon.com/images/M/MV5BMTY3OTg2OTM3OV5BMl5BanBnXkFtZTYwNzY5OTA3._V1_UY209_CR0,0,140,209_AL_.jpg');
--INSERT INTO movie (genre, release_year, director, title, summary, movie_img) VALUES ('comedy', '2009', 'Todd Phillips', 'The Hangover', 'Three buddies wake up from a bachelor party in Las Vegas, with no memory of the previous night and the bachelor missing. They make their way around the city in order to find their friend before his wedding.', 'https://m.media-amazon.com/images/M/MV5BNGQwZjg5YmYtY2VkNC00NzliLTljYTctNzI5NmU3MjE2ODQzXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_UY209_CR0,0,140,209_AL_.jpg');
--INSERT INTO movie (genre, release_year, director, title, summary, movie_img) VALUES ('horror', '2022', 'Hanna Bergholm', 'Hatching', 'A young gymnast, who tries desperately to please her demanding mother, discovers a strange egg. She hides it and keeps it warm, but when it hatches, what emerges shocks them all.', 'https://m.media-amazon.com/images/M/MV5BZGNiNDQ2OTAtZWYwOS00ZGVlLThmNmItM2NlMDU5M2QxNzUyXkEyXkFqcGdeQXVyMTM1MTE1NDMx._V1_UY209_CR0,0,140,209_AL_.jpg');
--INSERT INTO movie (genre, release_year, director, title, summary, movie_img) VALUES ('horror', '2021', 'Scott Dickerson', 'The Black Phone', 'After being abducted by a child killer and locked in a soundproof basement, a 13-year-old boy starts receiving calls on a disconnected phone from the killers previous victims.', 'https://m.media-amazon.com/images/M/MV5BMWQxOGJlNTUtYTc1YS00NDkyLWExZjItMTFiYWEzMjAzYTdjXkEyXkFqcGdeQXVyNjk1Njg5NTA@._V1_UY209_CR13,0,140,209_AL_.jpg');
--INSERT INTO movie (genre, release_year, director, title, summary, movie_img) VALUES ('horror', '2017', 'Andy Muschietti', 'It', 'In the summer of 1989, a group of bullied kids band together to destroy a shape-shifting monster, which disguises itself as a clown and preys on the children of Derry, their small Maine town.', 'https://m.media-amazon.com/images/M/MV5BZDVkZmI0YzAtNzdjYi00ZjhhLWE1ODEtMWMzMWMzNDA0NmQ4XkEyXkFqcGdeQXVyNzYzODM3Mzg@._V1_UX140_CR0,0,140,209_AL_.jpg');
--INSERT INTO movie (genre, release_year, director, title, summary, movie_img) VALUES ('drama', '2009', 'Ken Loach', 'Looking for Eric', 'Ever since his wife left him, Eric Bishops life has fallen apart. His two teen sons have little regard for him, his job at the post office is increasingly unfulfilling and he ends up in the hospital after a car crash. One night, he smokes marijuana and has a vision of his favorite Manchester United soccer player: Eric Cantona. With the help of his idol and his daughter, Eric tries to get his life straightened out.', 'https://www.movieflavor.com/images/a0/a0e36ae9ccb8a1750d74d3c6224a5557.jpeg');
--INSERT INTO movie (genre, release_year, director, title, summary, movie_img) VALUES ('sci-fi', '1991', 'James Cameron', 'Terminator 2: Judgement Day', 'A cyborg, identical to the one who failed to kill Sarah Connor, must now protect her ten-year-old son John from a more advanced and powerful cyborg.', 'https://m.media-amazon.com/images/M/MV5BMGU2NzRmZjUtOGUxYS00ZjdjLWEwZWItY2NlM2JhNjkxNTFmXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_UY209_CR0,0,140,209_AL_.jpg');
--INSERT INTO movie (genre, release_year, director, title, summary, movie_img) VALUES ('sci-fi','1999', 'Lana Wachowski & Lilly Wachowski', 'The Matrix', 'When a beautiful stranger leads computer hacker Neo to a forbidding underworld, he discovers the shocking truth--the life he knows is the elaborate deception of an evil cyber-intelligence.', 'https://m.media-amazon.com/images/M/MV5BNzQzOTk3OTAtNDQ0Zi00ZTVkLWI0MTEtMDllZjNkYzNjNTc4L2ltYWdlXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_UX140_CR0,0,140,209_AL_.jpg');
--INSERT INTO movie (genre, release_year, director, title, summary, movie_img) VALUES ('sci-fi', '2017', 'Denis Villeneuve', 'Blade runner 2049', 'Young Blade Runner Ks discovery of a long-buried secret leads him to track down former Blade Runner Rick Deckard, who has been missing for thirty years.', 'https://m.media-amazon.com/images/M/MV5BNzA1Njg4NzYxOV5BMl5BanBnXkFtZTgwODk5NjU3MzI@._V1_UY209_CR0,0,140,209_AL_.jpg');
--INSERT INTO movie (genre, release_year, director, title, summary, movie_img) VALUES ('action', '2009', 'James Cameron', 'Avatar', 'A paraplegic Marine dispatched to the moon Pandora on a unique mission becomes torn between following his orders and protecting the world he feels is his home.', 'https://m.media-amazon.com/images/M/MV5BNjA3NGExZDktNDlhZC00NjYyLTgwNmUtZWUzMDYwMTZjZWUyXkEyXkFqcGdeQXVyMTU1MDM3NDk0._V1_UY209_CR0,0,140,209_AL_.jpg');
--INSERT INTO movie (genre, release_year, director, title, summary, movie_img) VALUES ('action', '2019', 'Anthony & Joe Russo', 'Avengers: Endgame', 'After the devastating events of Avengers: Infinity War (2018), the universe is in ruins. With the help of remaining allies, the Avengers assemble once more in order to reverse Thanos actions and restore balance to the universe.', 'https://m.media-amazon.com/images/M/MV5BMTc5MDE2ODcwNV5BMl5BanBnXkFtZTgwMzI2NzQ2NzM@._V1_UY209_CR0,0,140,209_AL_.jpg');
--INSERT INTO movie (genre, release_year, director, title, summary, movie_img) VALUES ('action', '2022', 'Matt Reeves', 'The Batman', 'When a sadistic serial killer begins murdering key political figures in Gotham, Batman is forced to investigate the citys hidden corruption and question his familys involvement.', 'https://m.media-amazon.com/images/M/MV5BMDdmMTBiNTYtMDIzNi00NGVlLWIzMDYtZTk3MTQ3NGQxZGEwXkEyXkFqcGdeQXVyMzMwOTU5MDk@._V1_UY209_CR0,0,140,209_AL_.jpg');
--INSERT INTO movie (genre, release_year, director, title, summary, movie_img) VALUES ('animation', '2022', 'Kyle Balda, Brad Ableson, Jonathan del Val', 'Minions: The Rise of Gru', 'The untold story of one twelve-year-olds dream to become the worlds greatest supervillain.', 'https://m.media-amazon.com/images/M/MV5BZDQyODUwM2MtNzA0YS00ZjdmLTgzMjItZWRjN2YyYWE5ZTNjXkEyXkFqcGdeQXVyMTI2MzY1MjM1._V1_UX67_CR0,0,67,98_AL_.jpg');
--INSERT INTO movie (genre, release_year, director, title, summary, movie_img) VALUES ('animation', '2007', 'Brad Bird, Jan Pinkava', 'Ratatouille', 'A rat who can cook makes an unusual alliance with a young kitchen worker at a famous Paris restaurant.', 'https://m.media-amazon.com/images/M/MV5BMTMzODU0NTkxMF5BMl5BanBnXkFtZTcwMjQ4MzMzMw@@._V1_UX67_CR0,0,67,98_AL_.jpg');
--INSERT INTO movie (genre, release_year, director, title, summary, movie_img) VALUES ('animation', '2016', 'Ron Clements, John Musker, Don Hall, Chris Williams', 'Moana', 'In Ancient Polynesia, when a terrible curse incurred by the Demigod Maui reaches Moanas island, she answers the Oceans call to seek out the Demigod to set things right.', 'https://m.media-amazon.com/images/M/MV5BMjI4MzU5NTExNF5BMl5BanBnXkFtZTgwNzY1MTEwMDI@._V1_UX67_CR0,0,67,98_AL_.jpg');
--INSERT INTO movie (genre, release_year, director, title, summary, movie_img) VALUES ('war', '2019', 'Sam Mendes', '1917', 'April 6th, 1917. As an infantry battalion assembles to wage war deep in enemy territory, two soldiers are assigned to race against time and deliver a message that will stop 1,600 men from walking straight into a deadly trap.', 'https://m.media-amazon.com/images/M/MV5BOTdmNTFjNDEtNzg0My00ZjkxLTg1ZDAtZTdkMDc2ZmFiNWQ1XkEyXkFqcGdeQXVyNTAzNzgwNTg@._V1_UX140_CR0,0,140,209_AL_.jpg');
--INSERT INTO movie (genre, release_year, director, title, summary, movie_img) VALUES ('war', '1998', 'Steven Spielberg', 'Saving Private Ryan', 'Following the Normandy Landings, a group of U.S. soldiers go behind enemy lines to retrieve a paratrooper whose brothers have been killed in action.', 'https://m.media-amazon.com/images/M/MV5BZjhkMDM4MWItZTVjOC00ZDRhLThmYTAtM2I5NzBmNmNlMzI1XkEyXkFqcGdeQXVyNDYyMDk5MTU@._V1_UY209_CR1,0,140,209_AL_.jpg');
--INSERT INTO movie (genre, release_year, director, title, summary, movie_img) VALUES ('war', '1987', 'Stanley Kubrick', 'Full Metal Jacket', 'A pragmatic U.S. Marine observes the dehumanizing effects the Vietnam War has on his fellow recruits from their brutal boot camp training to the bloody street fighting in Hue.', 'https://m.media-amazon.com/images/M/MV5BNzkxODk0NjEtYjc4Mi00ZDI0LTgyYjEtYzc1NDkxY2YzYTgyXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_UX140_CR0,0,140,209_AL_.jpg');
--INSERT INTO movie (genre, release_year, director, title, summary, movie_img) VALUES ('comedy', '2010', 'Dennis Dugan', 'Grown Ups', 'After their high school basketball coach passes away, five good friends and former teammates reunite for a Fourth of July holiday weekend.', 'https://m.media-amazon.com/images/M/MV5BMjA0ODYwNzU5Nl5BMl5BanBnXkFtZTcwNTI1MTgxMw@@._V1_UY209_CR0,0,140,209_AL_.jpg');

--ROLLBACK;
COMMIT TRANSACTION;
