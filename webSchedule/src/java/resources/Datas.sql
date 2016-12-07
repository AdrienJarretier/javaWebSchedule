
INSERT INTO class_room (building, room_nb, capacity)  VALUES 
('Borel', 12, 150),
('Borel', 215, 35),

('Jean Jaures', 128, 30),
('Jean Jaurès', 15, 100),

('Multimedia', 104, 50),
('Multimedia', 206, 28);


INSERT INTO degree (name, students_count) VALUES 
('L1 informatique', 30),
('L2 informatique', 12),
('L3 informatique', 28),

('L1 Mathématiques', 128),
('L2 Mathématiques', 115);



/*
java code :

StaffDao staffDao = new StaffDao();

staffDao.addStaff("bertrand.françois@univ.fr", "François", "Bertrand", "psswdFra", false);
staffDao.addStaff("gallard.julien@univ.fr", "Julien", "Gallard", "psswdJul", false);
staffDao.addStaff("bernard.claude@univ.fr", "Claude", "Bernard", "psswdCla", false);
staffDao.addStaff("salma.juliette@univ.fr", "Juliette", "Salma", "psswdJul", false);
staffDao.addStaff("hoche.genevieve@univ.fr", "Geneviève", "Hoche", "psswdGen", false);
staffDao.addStaff("pilo.jaques@univ.fr", "Jacques", "Pilo", "psswdJac", true);
*/
