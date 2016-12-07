/**
 * Author:  Jarretier Adrien <jarretier.adrien@gmail.com>
 * Created: Dec 1, 2016
 */

-- lesson's of Bertrand François
INSERT INTO lesson (time_start, time_end, title, class_room_id, teacher_id) VALUES
('2016-12-04 14:30:00', '2016-12-04 16:30:00', 'Structure de données', (SELECT id from class_room WHERE building = 'Multimedia' AND room_nb = 104), (SELECT id from staff WHERE email = 'bertrand.francois@univ.fr'));

INSERT INTO lesson_participants (degree_id, lesson_id) VALUES
((SELECT id FROM degree WHERE name = 'L2 Informatique'), (SELECT id FROM lesson ORDER BY id DESC FETCH FIRST ROW ONLY) );


INSERT INTO lesson (time_start, time_end, title, class_room_id, teacher_id) VALUES
('2016-12-07 10:30:00', '2016-12-07 12:30:00', 'Base de données', (SELECT id from class_room WHERE building = 'Borel' AND room_nb = 12), (SELECT id from staff WHERE email = 'bertrand.francois@univ.fr'));

INSERT INTO lesson_participants (degree_id, lesson_id) VALUES
((SELECT id FROM degree WHERE name = 'L2 Informatique'), (SELECT id FROM lesson ORDER BY id DESC FETCH FIRST ROW ONLY) );


INSERT INTO lesson (time_start, time_end, title, class_room_id, teacher_id) VALUES
('2016-12-05 08:30:00', '2016-12-05 10:30:00', 'Base de données', (SELECT id from class_room WHERE building = 'Multimedia' AND room_nb = 206), (SELECT id from staff WHERE email = 'bertrand.francois@univ.fr'));

INSERT INTO lesson_participants (degree_id, lesson_id) VALUES
((SELECT id FROM degree WHERE name = 'L3 Informatique'), (SELECT id FROM lesson ORDER BY id DESC FETCH FIRST ROW ONLY) );

INSERT INTO lesson (time_start, time_end, title, class_room_id, teacher_id) VALUES
('2016-12-02 14:30:00', '2016-12-02 16:30:00', 'Numération et codage', (SELECT id from class_room WHERE building = 'Jean Jaures' AND room_nb = 128), (SELECT id from staff WHERE email = 'bertrand.francois@univ.fr'));

INSERT INTO lesson_participants (degree_id, lesson_id) VALUES
((SELECT id FROM degree WHERE name = 'L2 Informatique'), (SELECT id FROM lesson ORDER BY id DESC FETCH FIRST ROW ONLY) ),
((SELECT id FROM degree WHERE name = 'L2 Mathématiques'), (SELECT id FROM lesson ORDER BY id DESC FETCH FIRST ROW ONLY) );


INSERT INTO lesson (time_start, time_end, title, class_room_id, teacher_id) VALUES
('2016-12-02 08:00:00', '2016-12-02 10:30:00', 'Numération et codage', (SELECT id from class_room WHERE building = 'Jean Jaures' AND room_nb = 15), (SELECT id from staff WHERE email = 'bertrand.francois@univ.fr'));

INSERT INTO lesson_participants (degree_id, lesson_id) VALUES
((SELECT id FROM degree WHERE name = 'L1 Informatique'), (SELECT id FROM lesson ORDER BY id DESC FETCH FIRST ROW ONLY) ),
((SELECT id FROM degree WHERE name = 'L1 Mathématiques'), (SELECT id FROM lesson ORDER BY id DESC FETCH FIRST ROW ONLY) );

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- Lesson's of Bernard Claude

INSERT INTO lesson (time_start, time_end, title, class_room_id, teacher_id) VALUES
('2016-12-04 08:45:00', '2016-12-04 12:00:00', 'Circuit éléctrique', (SELECT id from class_room WHERE building = 'Borel' AND room_nb = 12), (SELECT id from staff WHERE email = 'bernard.claude@univ.fr'));

INSERT INTO lesson_participants (degree_id, lesson_id) VALUES
((SELECT id FROM degree WHERE name = 'L2 Informatique'), (SELECT id FROM lesson ORDER BY id DESC FETCH FIRST ROW ONLY));




INSERT INTO lesson (time_start, time_end, title, class_room_id, teacher_id) VALUES
('2016-12-10 09:45:00', '2016-12-10 12:00:00', 'Physique', (SELECT id from class_room WHERE building = 'Borel' AND room_nb = 215), (SELECT id from staff WHERE email = 'bernard.claude@univ.fr'));

INSERT INTO lesson_participants (degree_id, lesson_id) VALUES
((SELECT id FROM degree WHERE name = 'L2 Informatique'), (SELECT id FROM lesson ORDER BY id DESC FETCH FIRST ROW ONLY)),
((SELECT id FROM degree WHERE name = 'L2 Mathématiques'), (SELECT id FROM lesson ORDER BY id DESC FETCH FIRST ROW ONLY));



INSERT INTO lesson (time_start, time_end, title, class_room_id, teacher_id) VALUES
('2017-12-05 09:45:00', '2017-12-05 12:00:00', 'Chimie', (SELECT id from class_room WHERE building = 'Jean Jaures' AND room_nb = 128), (SELECT id from staff WHERE email = 'bernard.claude@univ.fr'));

INSERT INTO lesson_participants (degree_id, lesson_id) VALUES
((SELECT id FROM degree WHERE name = 'L2 Mathématiques'), (SELECT id FROM lesson ORDER BY id DESC FETCH FIRST ROW ONLY));



INSERT INTO lesson (time_start, time_end, title, class_room_id, teacher_id) VALUES
('2016-12-02 13:45:00', '2016-12-02 15:00:00', 'Electronique', (SELECT id from class_room WHERE building = 'Multimedia' AND room_nb = 206), (SELECT id from staff WHERE email = 'bernard.claude@univ.fr'));

INSERT INTO lesson_participants (degree_id, lesson_id) VALUES
((SELECT id FROM degree WHERE name = 'L3 Informatique'), (SELECT id FROM lesson ORDER BY id DESC FETCH FIRST ROW ONLY));
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- Lesson's of Hoche Geneviève



INSERT INTO lesson (time_start, time_end, title, class_room_id, teacher_id) VALUES
('2016-12-07 15:45:00', '2016-12-07 18:00:00', 'Anglais', (SELECT id from class_room WHERE building = 'Borel' AND room_nb = 12), (SELECT id from staff WHERE email = 'hoche.genevieve@univ.fr'));

INSERT INTO lesson_participants (degree_id, lesson_id) VALUES
((SELECT id FROM degree WHERE name = 'L1 Mathématiques'), (SELECT id FROM lesson ORDER BY id DESC FETCH FIRST ROW ONLY) ),
((SELECT id FROM degree WHERE name = 'L1 Informatique'), (SELECT id FROM lesson ORDER BY id DESC FETCH FIRST ROW ONLY) );



INSERT INTO lesson (time_start, time_end, title, class_room_id, teacher_id) VALUES
('2016-12-07 09:45:00', '2016-12-07 12:00:00', 'Anglais : Expression écrite', (SELECT id from class_room WHERE building = 'Borel' AND room_nb = 215), (SELECT id from staff WHERE email = 'hoche.genevieve@univ.fr'));

INSERT INTO lesson_participants (degree_id, lesson_id) VALUES
((SELECT id FROM degree WHERE name = 'L2 Informatique'), (SELECT id FROM lesson ORDER BY id DESC FETCH FIRST ROW ONLY) );



INSERT INTO lesson (time_start, time_end, title, class_room_id, teacher_id) VALUES
('2016-12-10 15:45:00', '2016-12-10 18:00:00', 'Anglais : Orale', (SELECT id from class_room WHERE building = 'Jean Jaures' AND room_nb = 15), (SELECT id from staff WHERE email = 'hoche.genevieve@univ.fr'));

INSERT INTO lesson_participants (degree_id, lesson_id) VALUES
((SELECT id FROM degree WHERE name = 'L2 Informatique'), (SELECT id FROM lesson ORDER BY id DESC FETCH FIRST ROW ONLY) ),
((SELECT id FROM degree WHERE name = 'L2 Mathématiques'), (SELECT id FROM lesson ORDER BY id DESC FETCH FIRST ROW ONLY) );




INSERT INTO lesson (time_start, time_end, title, class_room_id, teacher_id) VALUES
('2016-12-10 08:45:00', '2016-12-10 11:00:00', 'Anglais : compréhension', (SELECT id from class_room WHERE building = 'Multimedia' AND room_nb = 206), (SELECT id from staff WHERE email = 'hoche.genevieve@univ.fr'));

INSERT INTO lesson_participants (degree_id, lesson_id) VALUES
((SELECT id FROM degree WHERE name = 'L1 Mathématiques'), (SELECT id FROM lesson ORDER BY id DESC FETCH FIRST ROW ONLY) );



----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- Lesson's of Salma Juliette 

INSERT INTO lesson (time_start, time_end, title, class_room_id, teacher_id) VALUES
('2016-12-06 13:45:00', '2016-12-06 15:15:00', 'Analyse fonctionnelle', (SELECT id from class_room WHERE building = 'Jean Jaures' AND room_nb = 128), (SELECT id from staff WHERE email = 'salma.juliette@univ.fr'));

INSERT INTO lesson_participants (degree_id, lesson_id) VALUES
((SELECT id FROM degree WHERE name = 'L3 Informatique'), (SELECT id FROM lesson ORDER BY id DESC FETCH FIRST ROW ONLY));



INSERT INTO lesson (time_start, time_end, title, class_room_id, teacher_id) VALUES
('2016-12-06 09:00:00', '2016-12-06 11:15:00', 'Analyse graphique', (SELECT id from class_room WHERE building = 'Multimedia' AND room_nb = 104), (SELECT id from staff WHERE email = 'salma.juliette@univ.fr'));

INSERT INTO lesson_participants (degree_id, lesson_id) VALUES
((SELECT id FROM degree WHERE name = 'L2 Informatique'), (SELECT id FROM lesson ORDER BY id DESC FETCH FIRST ROW ONLY)),
((SELECT id FROM degree WHERE name = 'L2 Mathématiques'), (SELECT id FROM lesson ORDER BY id DESC FETCH FIRST ROW ONLY));



INSERT INTO lesson (time_start, time_end, title, class_room_id, teacher_id) VALUES
('2016-12-03 09:00:00', '2016-12-03 11:15:00', 'Algèbre', (SELECT id from class_room WHERE building = 'Multimedia' AND room_nb = 206), (SELECT id from staff WHERE email = 'salma.juliette@univ.fr'));

INSERT INTO lesson_participants (degree_id, lesson_id) VALUES
((SELECT id FROM degree WHERE name = 'L1 Informatique'), (SELECT id FROM lesson ORDER BY id DESC FETCH FIRST ROW ONLY)),
((SELECT id FROM degree WHERE name = 'L1 Mathématiques'), (SELECT id FROM lesson ORDER BY id DESC FETCH FIRST ROW ONLY));



INSERT INTO lesson (time_start, time_end, title, class_room_id, teacher_id) VALUES
('2016-12-03 14:00:00', '2016-12-03 15:15:00', 'Analyse fonctionnelle', (SELECT id from class_room WHERE building = 'Borel' AND room_nb = 12), (SELECT id from staff WHERE email = 'salma.juliette@univ.fr'));

INSERT INTO lesson_participants (degree_id, lesson_id) VALUES
((SELECT id FROM degree WHERE name = 'L3 Informatique'), (SELECT id FROM lesson ORDER BY id DESC FETCH FIRST ROW ONLY));

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- Lesson's of Gallard Julien 

INSERT INTO lesson (time_start, time_end, title, class_room_id, teacher_id) VALUES
('2016-12-03 13:45:00', '2016-12-03 15:15:00', 'Théorie des graphes', (SELECT id from class_room WHERE building = 'Multimedia' AND room_nb = 206), (SELECT id from staff WHERE email = 'gallard.julien@univ.fr'));

INSERT INTO lesson_participants (degree_id, lesson_id) VALUES
((SELECT id FROM degree WHERE name = 'L2 Informatique'), (SELECT id FROM lesson ORDER BY id DESC FETCH FIRST ROW ONLY)),
((SELECT id FROM degree WHERE name = 'L2 Mathématiques'), (SELECT id FROM lesson ORDER BY id DESC FETCH FIRST ROW ONLY));


INSERT INTO lesson (time_start, time_end, title, class_room_id, teacher_id) VALUES
('2016-12-08 13:45:00', '2016-12-08 15:15:00', 'Projet UML', (SELECT id from class_room WHERE building = 'Multimedia' AND room_nb = 104), (SELECT id from staff WHERE email = 'gallard.julien@univ.fr'));

INSERT INTO lesson_participants (degree_id, lesson_id) VALUES
((SELECT id FROM degree WHERE name = 'L3 Informatique'), (SELECT id FROM lesson ORDER BY id DESC FETCH FIRST ROW ONLY));


INSERT INTO lesson (time_start, time_end, title, class_room_id, teacher_id) VALUES
('2016-12-08 08:45:00', '2016-12-08 12:15:00', 'Langage : Java', (SELECT id from class_room WHERE building = 'Borel' AND room_nb = 12), (SELECT id from staff WHERE email = 'gallard.julien@univ.fr'));

INSERT INTO lesson_participants (degree_id, lesson_id) VALUES
((SELECT id FROM degree WHERE name = 'L2 Informatique'), (SELECT id FROM lesson ORDER BY id DESC FETCH FIRST ROW ONLY)),
((SELECT id FROM degree WHERE name = 'L2 Mathématiques'), (SELECT id FROM lesson ORDER BY id DESC FETCH FIRST ROW ONLY));


INSERT INTO lesson (time_start, time_end, title, class_room_id, teacher_id) VALUES
('2016-12-09 13:45:00', '2016-12-09 15:15:00', 'Langage : python', (SELECT id from class_room WHERE building = 'Jean Jaures' AND room_nb = 128), (SELECT id from staff WHERE email = 'gallard.julien@univ.fr'));

INSERT INTO lesson_participants (degree_id, lesson_id) VALUES
((SELECT id FROM degree WHERE name = 'L1 Informatique'), (SELECT id FROM lesson ORDER BY id DESC FETCH FIRST ROW ONLY)),
((SELECT id FROM degree WHERE name = 'L1 Mathématiques'), (SELECT id FROM lesson ORDER BY id DESC FETCH FIRST ROW ONLY));





