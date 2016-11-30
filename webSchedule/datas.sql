
INSERT INTO class_room (building, room_nb, capacity)  VALUES 
('Borel', 12, 12),
('Borel', 215, 35),
('Jean Jaures', 128, 30),
('Multimedia', 104, 25),
('Multimedia', 206, 28);


INSERT INTO degree (name, student_counts) VALUES 
('L2 informatique', 12),
('L1 Biologie', 35),
('L3 Mathématiques', 128),
('L2 PC', 104),
('L3 informatique', 28);


INSERT INTO staff (email, first_name, last_name, password, is_admin) VALUES 
('bertrand.françois@univ.fr', 'François', 'Bertrand', null, false),
('gallard.julien@univ.fr', 'Julien', 'Gallard', null, false),
('bernard.claude@univ.fr', 'Claude', 'Bernard', null, false),
('salma.juliette@univ.fr', 'Juliette', 'Salma', null, false),
('hoche.genevieve@univ.fr', 'Geneviève', 'Hoche', null, false),
('pilo.jaques@univ.fr', 'Jacques', 'Pilo', null, true);



INSERT INTO lesson (time_start, time_end, title, class_room_id, teacher_id) VALUES
('2016-11-24 14:30:00', '2016-11-24 16:30:00', 'Structure de données', (SELECT id from class_room WHERE building = 'Multimedia' AND room_nb = 104), (SELECT id from staff WHERE email = 'bertrand.françois@univ.fr'));

INSERT INTO lesson_participants (degree_id, lesson_id) VALUES
((SELECT id FROM degree WHERE name = 'L2 informatique'), (SELECT id FROM lesson ORDER BY id DESC FETCH FIRST ROW ONLY) );




INSERT INTO lesson (time_start, time_end, title, class_room_id, teacher_id) VALUES
('2016-12-04 08:45:00', '2016-12-04 12:00:00', 'Chimie moléculaire', (SELECT id from class_room WHERE building = 'Borel' AND room_nb = 12), (SELECT id from staff WHERE email = 'bernard.claude@univ.fr'));

INSERT INTO lesson_participants (degree_id, lesson_id) VALUES
((SELECT id FROM degree WHERE name = 'L2 PC'), (SELECT id FROM lesson ORDER BY id DESC FETCH FIRST ROW ONLY));




INSERT INTO lesson (time_start, time_end, title, class_room_id, teacher_id) VALUES
('2016-10-17 15:45:00', '2016-10-17 18:00:00', 'Biologie cellulaire', (SELECT id from class_room WHERE building = 'Borel' AND room_nb = 12), (SELECT id from staff WHERE email = 'hoche.genevieve@univ.fr'));

INSERT INTO lesson_participants (degree_id, lesson_id) VALUES
((SELECT id FROM degree WHERE name = 'L1 Biologie'), (SELECT id FROM lesson ORDER BY id DESC FETCH FIRST ROW ONLY) );




INSERT INTO lesson (time_start, time_end, title, class_room_id, teacher_id) VALUES
('2016-10-23 13:45:00', '2016-10-23 15:15:00', 'Analyse fonctionnelle', (SELECT id from class_room WHERE building = 'Jean Jaures' AND room_nb = 128), (SELECT id from staff WHERE email = 'salma.juliette@univ.fr'));

INSERT INTO lesson_participants (degree_id, lesson_id) VALUES
((SELECT id FROM degree WHERE name = 'L3 Mathématiques'), (SELECT id FROM lesson ORDER BY id DESC FETCH FIRST ROW ONLY));




INSERT INTO lesson (time_start, time_end, title, class_room_id, teacher_id) VALUES
('2016-10-23 13:45:00', '2016-10-23 15:15:00', 'Théorie des graphes', (SELECT id from class_room WHERE building = 'Multimedia' AND room_nb = 206), (SELECT id from staff WHERE email = 'gallard.julien@univ.fr'));

INSERT INTO lesson_participants (degree_id, lesson_id) VALUES
((SELECT id FROM degree WHERE name = 'L3 informatique' AND name = 'L3 Mathématiques'), (SELECT id FROM lesson ORDER BY id DESC FETCH FIRST ROW ONLY));