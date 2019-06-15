--create tables for tour and ratings
CREATE TABLE tour ( id int NOT NULL PRIMARY KEY,
                    distance int,
                    duration int,
                    cost double precision,
                    art int,
                    amusement int,
                    recreation int,
                    historic int
);

CREATE TABLE attraction_tour( id int not null primary key,
                               tour_id int not null ,
                                attraction_id int not null );

ALTER TABLE attraction_tour ADD CONSTRAINT fk_attraction_tour_1 FOREIGN KEY (tour_id) REFERENCES tour(id);
ALTER TABLE attraction_tour ADD CONSTRAINT fk_attraction_tour_2 FOREIGN KEY (attraction_id) REFERENCES attraction(id);

CREATE TABLE rating (
    id int not null primary key,
    rating int,
    user_id int,
    tour_id int
);

ALTER TABLE rating ADD CONSTRAINT fk_rating_1 FOREIGN KEY (tour_id) REFERENCES tour(id);
ALTER TABLE rating ADD CONSTRAINT fk_rating_2 FOREIGN KEY (user_id) REFERENCES tourist_user(id);
