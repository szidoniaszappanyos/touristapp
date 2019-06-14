CREATE TABLE tourist_user (

														id int NOT NULL PRIMARY KEY,
														last_name varchar(255),
														first_name varchar(255),
														email varchar(255),
														birth_date timestamp
);

CREATE TABLE users (

										 id int NOT NULL PRIMARY KEY,
										 tourist_user_id int UNIQUE REFERENCES tourist_user(id),
										 username varchar(255),
										 password varchar(255),
										 creation_date timestamp,
										 update_date timestamp
);

CREATE TABLE locations (

												 id int NOT NULL PRIMARY KEY,
												 name varchar(255),
												 adress varchar(255),
												 details varchar(255)


);

CREATE TABLE attraction_type(

												 id int NOT NULL PRIMARY KEY,
												 name varchar(255)

);

CREATE TABLE attraction(

												 id int NOT NULL PRIMARY KEY,
												 attraction_type_id int references attraction_type(id),
												 location_id int references locations(id),
												 name varchar(255),
												 details varchar(255),
												 duration bigint 

);

CREATE TABLE interests (

												 id int NOT NULL PRIMARY KEY,
												 tourist_user_id int References tourist_user(id),
                        attraction_type_id int references attraction_type(id)
);

CREATE TABLE picture (

											 id int NOT NULL PRIMARY KEY,
											 file_name varchar(255),
											 description varchar(255)


);

CREATE TABLE gallery (

											 id int NOT NULL PRIMARY KEY,
											 attraction_id int References attraction(id),
											 picture_id	int References picture(id)

);

CREATE TABLE daily_schedule (

															id int NOT NULL PRIMARY KEY,
															working_day varchar(255),
															opening_hours timestamp,
															closing_hours timestamp

);

CREATE TABLE weekly_schedule (
															 id int NOT NULL PRIMARY KEY,
															 monday int references daily_schedule(id),
															 tuesday int references daily_schedule(id),
															 wednesday int references daily_schedule(id),
															 thursday int references daily_schedule(id),
															 friday int references daily_schedule(id),
															 saturday int references daily_schedule(id),
															 sunday int references daily_schedule(id)
);

CREATE TABLE attraction_schedule (

																	 id int NOT NULL PRIMARY KEY,
																	 weekly_schedule_id int References weekly_schedule(id),
																	 attraction_id int References attraction(id)

);

CREATE TABLE visit (

										 id int NOT NULL PRIMARY KEY,
										 attraction_id int references attraction(id),
										 tourist_user_id int references tourist_user(id),
										 visit_date timestamp,
										 details varchar(255)

);
