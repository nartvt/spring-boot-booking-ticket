drop database MovieDatabase;

create database MovieDatabase;
USE MovieDatabase;

CREATE TABLE  Movie(
    movieId int AUTO_INCREMENT,
    movieName varchar(100) not null,
    moviePicture varchar(255) not null,
    trailer varchar(255) not null,
    description varchar(255) not null,
    movieDuration INT not null,
    movieReleaseDate TIMESTAMP not null,
    review varchar(255),
    primary key(movieId)
);

CREATE TABLE   Showtimes(
    showtimeId int AUTO_INCREMENT,
    roomId int not null,
    movieId int not null,
    showDay TIMESTAMP NULL,
    showDate TIMESTAMP NULL,
    ticketFare FLOAT not null,
    PRIMARY KEY(showtimeId)
);

CREATE TABLE SeatType(
    seatTypeId int AUTO_INCREMENT,
    seatTypeName varchar(50) not null,
    roomId int not null,
    description varchar(200) not null,
    primary key(seatTypeId)
    
);

CREATE TABLE   Seat(
    seatId int AUTO_INCREMENT,
    seatName varchar(50) not null,
    roomId int not null,
    seatTypeId int not null,
    primary key(seatId)   
);
CREATE TABLE   MovieTicket(
    ticketId int AUTO_INCREMENT,
    showtimeId int not null,
    seatId int not null,
    userId int not null,
    totalAmount int not null,
    bookingDate TIMESTAMP null,
    PRIMARY KEY(ticketId)  
);
CREATE TABLE   Cineplex(
     cineplexId int AUTO_INCREMENT,
     cineplexName varchar(100) not null,
     cineplexLogo varchar(255) not null,
     PRIMARY KEY(cineplexId)
 );

CREATE TABLE   CinemaMovie(
    movieId int not null,
    cinemaId int not null,     
    PRIMARY KEY (movieId,cinemaId)
);

CREATE TABLE   Cinema(
    cinemaId int AUTO_INCREMENT,
    cinemaName varchar(100) not null,
    cinemaAddress varchar(100) not null,
    cinemaPhone varchar(10) not null,
    cinemaInfo varchar(100) not null,
    cinemaImage varchar(255) not null,
    cineplexId int not null,
    PRIMARY KEY (cinemaId)
);
CREATE TABLE   CinemaRoom(
    roomId int AUTO_INCREMENT,
    roomName varchar(255) not null,
    seatAmount int not null,
    cinemaId int not null,
    PRIMARY KEY(roomId)    
);
 CREATE TABLE   Role(
     roleId int AUTO_INCREMENT,
     roleName varchar(50) not null,
     description varchar(100),
     PRIMARY key(roleId)
 );

CREATE TABLE User(
    userId int AUTO_INCREMENT,
    userName varchar(50) not null,
    email varchar(50) NOT null,
    password varchar(255) not null,
    address varchar(100) not null,
    phoneNumber varchar(10) not null,
    avatar varchar(100),
    roleId int not null,
    PRIMARY KEY(userId)
);
INSERT INTO  Role(roleName,description) VALUES("ROLE_ADMIN","ADMIN");
INSERT INTO  Role(roleName,description) VALUES("ROLE_USER","ADMIN");

ALTER TABLE Showtimes ADD CONSTRAINT FK_SHOWTIME_MOVIE  FOREIGN KEY (movieId) REFERENCES Movie(movieId);
ALTER TABLE Showtimes ADD CONSTRAINT FK_SHOWTIME_ROOM  FOREIGN KEY (roomId) REFERENCES CinemaRoom(roomId);

ALTER TABLE SeatType ADD CONSTRAINT FK_SEAT_TYPE_ROOM  FOREIGN KEY (roomId) REFERENCES CinemaRoom(roomId);

ALTER TABLE Seat ADD CONSTRAINT fk_Seat_CinemaRoom FOREIGN KEY (roomId) REFERENCES CinemaRoom(roomId);
ALTER TABLE Seat ADD CONSTRAINT fk_seat_seatType FOREIGN KEY (seatTypeId) REFERENCES SeatType(seatTypeId);


ALTER TABLE MovieTicket ADD CONSTRAINT FK_TICKET_SHOWTIMES FOREIGN KEY (showtimeId) REFERENCES Showtimes(showtimeId);
ALTER TABLE MovieTicket ADD CONSTRAINT FK_TICKET_SEAT FOREIGN KEY (seatId) REFERENCES Seat(seatId);
ALTER TABLE MovieTicket ADD CONSTRAINT FK_TICKET_User FOREIGN KEY (userId) REFERENCES User(userId);


ALTER TABLE CinemaMovie ADD CONSTRAINT FK_CINEMAMOVIE_CINEMA FOREIGN KEY (cinemaId) REFERENCES Cinema(cinemaId);
ALTER TABLE CinemaMovie ADD CONSTRAINT FK_CINEMAMOVIE_MOVIE FOREIGN KEY (movieId) REFERENCES Movie(movieId);


ALTER TABLE Cinema ADD CONSTRAINT FK_CINEMA_CINEPLEX FOREIGN KEY (cineplexId) REFERENCES Cineplex(cineplexId);

ALTER TABLE CinemaRoom ADD CONSTRAINT FK_ROOM_CINEMA FOREIGN KEY (cinemaId) REFERENCES Cinema(cinemaId);

ALTER TABLE User ADD CONSTRAINT fk_user_role FOREIGN KEY (roleId) REFERENCES Role(roleId);

