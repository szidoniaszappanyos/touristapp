INSERT INTO locations(
	id, name, adress, details)
	VALUES (14,'Piața Avram Iancu' ,'1', '');

INSERT INTO picture(
	id, file_name, description)
	VALUES (14, 'Assumption Cathedral 1.pg', '');

INSERT INTO picture(
	id, file_name, description)
	VALUES (24, 'Assumption Cathedral 2.jpg', '');

INSERT INTO picture(
	id, file_name, description)
	VALUES (34, 'Assumption Cathedral 3.jpg', '');

INSERT INTO daily_schedule(
	id, working_day, opening_hours, closing_hours)
	VALUES (14, 'monday', '2019-01-01 08:00+00', '2019-01-01 16:00+00');

INSERT INTO daily_schedule(
	id, working_day, opening_hours, closing_hours)
	VALUES (24, 'tuesday', '2019-01-01 08:00+00', '2019-01-01 16:00+00');

INSERT INTO daily_schedule(
	id, working_day, opening_hours, closing_hours)
	VALUES (34, 'wednesday', '2019-01-01 08:00+00', '2019-01-01 14:00+00');

INSERT INTO daily_schedule(
	id, working_day, opening_hours, closing_hours)
	VALUES (44, 'thursday', '2019-01-01 08:00+00', '2019-01-01 16:00+00');

INSERT INTO daily_schedule(
	id, working_day, opening_hours, closing_hours)
	VALUES (54, 'friday', '2019-01-01 10:00+00', '2019-01-01 19:00+00');

INSERT INTO daily_schedule(
	id, working_day, opening_hours, closing_hours)
	VALUES (64,'saturday', '2019-01-01 08:00+00', '2019-01-01 19:00+00');

INSERT INTO daily_schedule(
	id, working_day, opening_hours, closing_hours)
	VALUES (74,'sunday', '2019-01-01 08:00+00', '2019-01-01 19:00+00');

INSERT INTO weekly_schedule(
	id, monday, tuesday, wednesday, thursday, friday, saturday, sunday)
	VALUES (14, 14, 24, 34, 44, 54, 64, 74);

INSERT INTO attraction(
	id, attraction_type_id, location_id, name, details, weekly_schedule_id)
	VALUES (14, 1, 14, 'Assumption Cathedral', 'Romanian Orthodox church', 14);


