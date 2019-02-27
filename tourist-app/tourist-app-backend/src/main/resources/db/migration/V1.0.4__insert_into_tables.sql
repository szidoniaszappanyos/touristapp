INSERT INTO locations(
	id, name, adress, details)
	VALUES (12,'Strada Universității' ,'5', '');

INSERT INTO picture(
	id, file_name, description)
	VALUES (12, 'Church of the Holy Trinity 1.pg', '');

INSERT INTO picture(
	id, file_name, description)
	VALUES (22, 'Church of the Holy Trinity 2.jpg', '');

INSERT INTO picture(
	id, file_name, description)
	VALUES (32, 'Church of the Holy Trinity 3.jpg', '');

INSERT INTO daily_schedule(
	id, working_day, opening_hours, closing_hours)
	VALUES (11, 'monday', '2019-01-01 10:00', '2019-01-01 10:00');

INSERT INTO daily_schedule(
	id, working_day, opening_hours, closing_hours)
	VALUES (21, 'tuesday', '2019-01-01 08:00', '2019-01-01 14:00');

INSERT INTO daily_schedule(
	id, working_day, opening_hours, closing_hours)
	VALUES (31, 'wednesday', '2019-01-01 08:00', '2019-01-01 14:00');

INSERT INTO daily_schedule(
	id, working_day, opening_hours, closing_hours)
	VALUES (51, 'friday', '2019-01-01 08:00', '2019-01-01 14:00');

INSERT INTO daily_schedule(
	id, working_day, opening_hours, closing_hours)
	VALUES (71,'sunday', '2019-01-01 08:00', '2019-01-01 19:00');

INSERT INTO weekly_schedule(
	id, monday, tuesday, wednesday, thursday, friday, saturday, sunday)
	VALUES (11, 11, 21, 31, 4, 51, 6, 71);

INSERT INTO attraction(
	id, attraction_type_id, location_id, name, details, weekly_schedule_id)
	VALUES (12, 1, 12, 'Church of the Holy Trinity', 'Romano Catholic church', 11);


INSERT INTO locations(
	id, name, adress, details)
	VALUES (13,'Strada Émile Zola' ,'2', '');

INSERT INTO picture(
	id, file_name, description)
	VALUES (13, 'The Franciscan Monastery and Church 1.pg', '');

INSERT INTO picture(
	id, file_name, description)
	VALUES (23, 'The Franciscan Monastery and Church 2.jpg', '');

INSERT INTO picture(
	id, file_name, description)
	VALUES (33, ' The Franciscan Monastery and Church 3.jpg', '');

INSERT INTO picture(
	id, file_name, description)
	VALUES (43, ' The Franciscan Monastery and Church 4.jpg', '');


INSERT INTO attraction(
	id, attraction_type_id, location_id, name, details, weekly_schedule_id)
	VALUES (11, 1, 13, 'The Franciscan Monastery and Church', 'Romano Catholic church', 11);
