
INSERT INTO locations(
 id, name, address, details)
 VALUES (249,'Cetățuia' ,'', '46.773879 23.582829');

INSERT INTO attraction(
 id, attraction_type_id, location_id, name, details, weekly_schedule_id, cost)
 VALUES (249, 6, 249, 'Monument of the Heroes of the Nation','The Cross of Cetatuia, designed by Archbishop Virgil Salvanu,' ||
  ' was built between 2000-2002 on Cetatuia Hill in Cluj-Napoca and has a height of almost 23 m and the monument''s weight is 60 tons.',null, 0 );

INSERT INTO locations(
 id, name, address, details)
 VALUES (250,' Piața Muzeului  ' ,'2', '46.771830 23.587456');

INSERT INTO attraction(
 id, attraction_type_id, location_id, name, details, weekly_schedule_id, cost)
 VALUES (250, 6, 250, 'Obeliscul Carolina', '', null, 0);

INSERT INTO locations(
 id, name, address, details)
 VALUES (251,'Piața Avram Iancu, Cluj-Napoca' ,'nr. 11', '46.772035 23.597012');

INSERT INTO attraction(
 id, attraction_type_id, location_id, name, details, weekly_schedule_id, cost)
 VALUES (251, 7, 251, 'Palace of the Orthodox Archdiocese', 'Built in 1887, the palace initially served as the ' ||
  'headquarters for the Forest Administration. The building was donated to the Romanian Orthodox Church with the ' ||
   'completion of the Orthodox Cathedral in Avram Iancu Square.', null, 0);

INSERT INTO locations(
 id, name, address, details)
 VALUES (245,'Strada George Barițiu 4, Cluj-Napoca 400000' ,'', '46.774169 23.588107');

INSERT INTO attraction(
 id, attraction_type_id, location_id, name, details, weekly_schedule_id, cost)
 VALUES (245, 7, 245, 'Babos Palace', '
The edifice located on King Ferdinand Street, no. 38, is a prominent representative of the Belle Époque architecture ' ||
 'in Cluj. The palace is built in a V-like shape and is one of the 4 palaces on the Great Bridge over Somes.', null,0);

INSERT INTO locations(
 id, name, address, details)
 VALUES (246,' Piața Unirii 30, Cluj-Napoca' ,'', '46.770536 23.590435');

INSERT INTO attraction(
 id, attraction_type_id, location_id, name, details, weekly_schedule_id, cost)
 VALUES (246, 7, 246, 'Banffy Palace', 'Probably one of the most famous and easily recognized palaces of Cluj, Banffy Palace is also one of the most' ||
 ' representative Baroque buildings in Cluj, but also from Transylvania.', 11, 0);

INSERT INTO locations(
 id, name, address, details)
 VALUES (247,' I.C. Brătianu,  22 ' ,'', '46.768954 23.594677');

INSERT INTO attraction(
 id, attraction_type_id, location_id, name, details, weekly_schedule_id, cost)
 VALUES (247, 7, 247, ' Béldi Palace', 'Located on I.C. Brătianu, at no. 22, Béldi Palace ' ||
  'currently houses the French Institute of Cluj.', 1,0);


INSERT INTO locations(
 id, name, address, details)
 VALUES (248,' Horea 1' ,'', '46.774809 23.587420');

INSERT INTO attraction(
 id, attraction_type_id, location_id, name, details, weekly_schedule_id, cost)
 VALUES (248, 7, 248, 'Berde Palace ', '
A prominent representative of the Belle Époque period in Cluj, the Berde Palace was erected in the context of the' ||
 ' modernization of the Mari Street of the city (Nagy utca) at the end of the 19th century.', 13, 0);

