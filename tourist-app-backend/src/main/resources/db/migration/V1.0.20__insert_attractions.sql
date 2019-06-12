INSERT INTO attraction_type(
	id, name)
	VALUES (9,'museum' );

INSERT INTO locations(
 id, name, address, details)
 VALUES (266,'Strada Cireșilor 19, Cluj-Napoca 400487' ,'', '46.757945 23.586750');

INSERT INTO attraction(
 id, attraction_type_id, location_id, name, details, weekly_schedule_id, cost)
 VALUES (266, 9, 266, 'Astronomical Observatory','',11, 10 );

INSERT INTO locations(
 id, name, address, details)
 VALUES (267,'Clinicilor Street 5-7, Cluj-Napoca' ,'', '46.763930 23.580264');

INSERT INTO attraction(
 id, attraction_type_id, location_id, name, details, weekly_schedule_id, cost)
 VALUES (267, 9, 267, 'Zoological Museum', '', 13, 15);

INSERT INTO locations(
 id, name, address, details)
 VALUES (268,'Strada Sextil Pușcariu 1, Cluj-Napoca 400111' ,'', '46.771098 23.587534');

INSERT INTO attraction(
 id, attraction_type_id, location_id, name, details, weekly_schedule_id, cost)
 VALUES (268, 9, 268, 'Casa Matia from Cluj', '', 16, 7);

INSERT INTO locations(
 id, name, address, details)
 VALUES (269,'Strada Constantin Daicoviciu 2, Cluj-Napoca' ,'', '46.771579 23.586324');

INSERT INTO attraction(
 id, attraction_type_id, location_id, name, details, weekly_schedule_id, cost)
 VALUES (269, 9, 269, 'Muzeul Național de Istorie a Transilvaniei', 'The National History Museum of Transylvania, from ' ||
  'Cluj-Napoca, located on Constantin Daicoviciu Street no. 2, in the building known as the Petrechevich-Horvath House ' ||
   'is the continuation of the first association', 14,0);

INSERT INTO locations(
 id, name, address, details)
 VALUES (270,'Memorandumului Street 21, Cluj-Napoca 400114' ,'', '46.769221 23.586426');

INSERT INTO attraction(
 id, attraction_type_id, location_id, name, details, weekly_schedule_id, cost)
 VALUES (270, 9, 270, 'Ethnographic Museum of Transylvania', '
The Ethnographic Museum of Transylvania is a museum in Cluj-Napoca. The museum was founded on June 16, 1922, and was ' ||
 'one of the cultural achievements of the period following the Great Union on 1 December 1918.', 12, 0);

INSERT INTO locations(
 id, name, address, details)
 VALUES (271,'Strada Avram Iancu 2, Cluj-Napoca 400000' ,'', '46.766163 23.588396');

INSERT INTO attraction(
 id, attraction_type_id, location_id, name, details, weekly_schedule_id, cost)
 VALUES (271, 9, 271, 'The Museum', '', 1,0);



