-- disable foreign key check
SET GLOBAL FOREIGN_KEY_CHECKS=0;
CREATE DATABASE IF NOT EXISTS MovieDatabase;
USE MovieDatabase;
CREATE TABLE IF NOT EXISTS  Movie(
    movieId varchar(10) not null,
    movieName varchar(100) not null,
    moviePicture varchar(255) not null,
    trailer varchar(255) not null,
    description varchar(255) not null,
    movieDuration INT not null,
    movieReleaseDate TIMESTAMP not null,
    review varchar(255),
    primary key(movieId)
);
SET time_zone='+00:00';

CREATE TABLE IF NOT EXISTS  Showtimes(
    showtimeId varchar(10) not null,
    roomId varchar(10) not null,
    movieId varchar(10) not null,
    showDay TIMESTAMP NULL,
    showDate TIMESTAMP NULL,
    moviePrice FLOAT not null,
    PRIMARY KEY(showtimeId),
    CONSTRAINT FK_SHOWTIME_MOVIE  FOREIGN KEY (movieId) REFERENCES Movie(movieId),
    CONSTRAINT FK_SHOWTIME_ROOM  FOREIGN KEY (roomId) REFERENCES CinemaRoom(roomId)
);

CREATE TABLE IF NOT EXISTS  SeatType(
    seatTypeId varchar(10) not null,
    seatTypeName varchar(50) not null,
    roomId varchar(10) not null,
    description varchar(200) not null,
    primary key(seatTypeId),
    CONSTRAINT FK_SEAT_TYPE_ROOM  FOREIGN KEY (roomId) REFERENCES CinemaRoom(roomId),
);

CREATE TABLE IF NOT EXISTS  Seat(
    seatId varchar(10) not null,
    seatName varchar(50) not null,
    roomId varchar(10) not null,
    seatTypeId varchar(10) not null,
    primary key(seatId),
    CONSTRAINT fk_Seat_CinemaRoom FOREIGN KEY (roomId) REFERENCES CinemaRoom(roomId),
    CONSTRAINT fk_seat_seatType FOREIGN KEY (seatTypeId) REFERENCES SeatType(seatTypeId)
);
CREATE TABLE IF NOT EXISTS  MovieTicket(
    ticketId varchar(10) not null,
    showtimeId varchar(10) not null,
    seatId varchar(5) not null,
    userId varchar(10) not null,
    ticketPrice int not null,
    bookingDate TIMESTAMP null,
    PRIMARY KEY(ticketId),
    CONSTRAINT FK_TICKET_SHOWTIMES FOREIGN KEY (showtimeId) REFERENCES Showtimes(showtimeId),
    CONSTRAINT FK_TICKET_Seat FOREIGN KEY (seatId) REFERENCES Seat(seatId),
    CONSTRAINT FK_TICKET_User FOREIGN KEY (userId) REFERENCES User(userId),
);
CREATE TABLE IF NOT EXISTS  Cineplex(
     cineplexId varchar(10) not null,
     cineplexName varchar(100) not null,
     cineplexLogo varchar(255) not null,
     PRIMARY KEY(cineplexId)
 );
CREATE TABLE IF NOT EXISTS  Cinema(
    cinemaId varchar(10) not null,
    cinemaName varchar(100) not null,
    cinemaAddress varchar(100) not null,
    cinemaPhone varchar(10) not null,
    cinemaInfo varchar(100) not null,
    cinemaImage varchar(255) not null,
    cineplexId varchar(10) not null,
    PRIMARY KEY (cinemaId),
    CONSTRAINT FK_CINEMA_CINEPLEX FOREIGN KEY (cineplexId) REFERENCES Cineplex(cineplexId)
);
CREATE TABLE IF NOT EXISTS  CinemaRoom(
    roomId varchar(10) not null,
    roomName varchar(255) not null,
    seatAmount int not null,
    cinemaId varchar(10) not null,
    PRIMARY KEY(roomId),
    CONSTRAINT FK_ROOM_CINEMA FOREIGN KEY (cinemaId) REFERENCES Cinema(cinemaId)
);
 CREATE TABLE IF NOT EXISTS  Permission(
     permissionId VARCHAR(10) not null,
     permissionName varchar(50) not null,
     description varchar(100),
     PRIMARY key(permissionId)
 );

CREATE TABLE IF NOT EXISTS  User(
    userId varchar(10) not null,
    userName varchar(50) not null,
    email varchar(50) NOT null,
    password varchar(255) not null,
    address varchar(100) not null,
    phoneNumber varchar(10) not null,
    avatar varchar(100),
    permissionId varchar(10) not null,
    PRIMARY KEY(userId),
    CONSTRAINT fk_user_permission FOREIGN KEY (permissionId) REFERENCES Permission(permissionId)
);

-- enable foreign key check
SET GLOBAL FOREIGN_KEY_CHECKS=1;