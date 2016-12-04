/**
 * Author:  Jarretier Adrien <jarretier.adrien@gmail.com>
 * Created: Dec 1, 2016
 */

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
