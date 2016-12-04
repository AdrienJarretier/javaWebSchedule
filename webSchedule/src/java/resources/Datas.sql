
INSERT INTO class_room (building, room_nb, capacity)  VALUES 
('Borel', 12, 12),
('Borel', 215, 35),
('Jean Jaures', 128, 30),
('Multimedia', 104, 25),
('Multimedia', 206, 28);


INSERT INTO degree (name, students_count) VALUES 
('L2 informatique', 12),
('L1 Biologie', 35),
('L3 Mathématiques', 128),
('L2 PC', 104),
('L3 informatique', 28);


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
