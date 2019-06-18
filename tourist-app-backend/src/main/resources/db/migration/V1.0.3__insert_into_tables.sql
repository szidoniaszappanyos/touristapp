INSERT INTO tourist_user(
	id, last_name, first_name, email, birth_date)
	VALUES (1, 'John', 'Doe', 'john.doe@yahoo.com', '1990-08-07');

INSERT INTO users(
	id, tourist_user_id, username, password, creation_date, update_date)
	VALUES (1, 1, 'john.doe','doe', '2018-10-25', '2019-01-01');

INSERT INTO locations(
	id, name, adress, details)
	VALUES (1,'Piaţa Unirii' ,'16', '');

INSERT INTO attraction_type(
	id, name)
	VALUES (1,'church' );

INSERT INTO interests(
	id, tourist_user_id, attraction_type_id)
	VALUES (1, 1, 1);

INSERT INTO picture(
	id, file_name, description)
	VALUES (1, 'st. michael church 1.jpg', '');

INSERT INTO picture(
	id, file_name, description)
	VALUES (2, 'st. michael church 2.jpg', '');

INSERT INTO picture(
	id, file_name, description)
	VALUES (3, 'st. michael church 3.jpg', '');

INSERT INTO daily_schedule(
	id, working_day, opening_hours, closing_hours)
	VALUES (1, 'monday', '2019-01-01 10:00+00', '2019-01-01 19:00+00');

INSERT INTO daily_schedule(
	id, working_day, opening_hours, closing_hours)
	VALUES (2, 'tuesday', '2019-01-01 10:00+00', '2019-01-01 19:00+00');

INSERT INTO daily_schedule(
	id, working_day, opening_hours, closing_hours)
	VALUES (3, 'wednesday', '2019-01-01 10:00+00', '2019-01-01 19:00+00');

INSERT INTO daily_schedule(
	id, working_day, opening_hours, closing_hours)
	VALUES (4, 'thursday', '2019-01-01 10:00+00', '2019-01-01 19:00+00');

INSERT INTO daily_schedule(
	id, working_day, opening_hours, closing_hours)
	VALUES (5, 'friday', '2019-01-01 10:00+00', '2019-01-01 19:00+00');

INSERT INTO daily_schedule(
	id, working_day, opening_hours, closing_hours)
	VALUES (6, 'saturday', '2019-01-01 10:00+00', '2019-01-01 19:00+00');

INSERT INTO daily_schedule(
	id, working_day, opening_hours, closing_hours)
	VALUES (7,'sunday', '2019-01-01 10:00+00', '2019-01-01 19:00+00');

INSERT INTO weekly_schedule(
	id, monday, tuesday, wednesday, thursday, friday, saturday, sunday)
	VALUES (1, 1, 2, 3, 4, 5, 6, 7);

INSERT INTO attraction(
	id, attraction_type_id, location_id, name, details, weekly_schedule_id)
	VALUES (1, 1, 1, 'St. Michael Church', 'Romano Catholic church', 1);

