create table Movie(
    movieId varchar(10) not null,
    movieName varchar(100) not null,
    moviePicture varchar(255) not null,
    trailer varchar(255) not null,
    description varchar(255) not null,
    movieDuration INT not null,
    movieReleaseDate TIMESTAMP not null,
    review varchar(255)
    primary key(movieId)
);
create table Showtimes(
    showtimeId varchar(10) not null,
    roomId varchar(10) not null,
    movieId varchar(10) not null,
    showDay TIMESTAMP NOT NULL,
    showDate TIMESTAMP NOT null,
    moviePrice FLOAT not null,
    PRIMARY KEY(showtimeId),
    CONSTRAINT FK_SHOWTIME_MOVIE  FOREIGN KEY (showtimeId) REFERENCES Movie(movieId)
    
);

create table MovieTicket(
    ticketId varchar(10) not null,
    showtimeId varchar(10) not null,
    cinemaSeat varchar(5) not null,
    personId varchar(10) not null,
    amount FLOAT not null,
    bookingDate TIMESTAMP not null,
    PRIMARY KEY(ticketId),
    CONSTRAINT FK_TICKET_SHOWTIMES FOREIGN KEY (showtimeId) REFERENCES Showtimes(showtimeId)
);
create table Cineplex(
     cineplexId varchar(10) not null,
     cineplexName varchar(100) not null,
     cineplexLogo varchar(255) not null,
     PRIMARY KEY(cineplexId)
 );
create table Cinema(
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
create table RoomShowTime(
    roomId varchar(10) not null,
    roomName varchar(255) not null,
    seats int not null,
    cinemaId varchar(10) not null,
    PRIMARY KEY(roomId),
    CONSTRAINT FK_ROOM_CINEMA FOREIGN KEY (cinemaId) REFERENCES Cinema(cinemaId)
);
 

