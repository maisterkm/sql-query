INSERT INTO COURSE (name, description)
VALUES
  ('Discrete Math', 'Prof. Cristian, 80 hours'),
  ('Mathematical analysis', 'Prof. Markus, 120 hours'),
  ('Statistic', 'Prof. Rey, 70 hours');

SELECT * FROM COURSE;

INSERT INTO GROUPS (name)
VALUES
  ('SR-01'),
  ('SR-02'),
  ('SR-03');

SELECT * FROM GROUPS;

INSERT INTO STUDENTS (group_id, first_name, last_name)
VALUES
  (1, 'first_name_1', 'last_name_1'),
  (1, 'first_name_2', 'last_name_2'),
  (1, 'first_name_3', 'last_name_3'),
  (1, 'first_name_4', 'last_name_4'),
  (1, 'first_name_5', 'last_name_5'),
  (1, 'first_name_6', 'last_name_6'),
  (1, 'first_name_7', 'last_name_7'),
  (1, 'first_name_8', 'last_name_8'),
  (1, 'first_name_9', 'last_name_9'),
  (1, 'first_name_10', 'last_name_10'),
  (1, 'first_name_11', 'last_name_11'),
  (1, 'first_name_12', 'last_name_12'),
  (2, 'first_name_13', 'last_name_13'),
  (2, 'first_name_14', 'last_name_14'),
  (2, 'first_name_15', 'last_name_15'),
  (2, 'first_name_16', 'last_name_16'),
  (2, 'first_name_17', 'last_name_17'),
  (2, 'first_name_18', 'last_name_18'),
  (2, 'first_name_19', 'last_name_19'),
  (3, 'first_name_20', 'last_name_20'),
  (3, 'first_name_21', 'last_name_21'),
  (3, 'first_name_22', 'last_name_22'),
  (3, 'first_name_23', 'last_name_23'),
  (3, 'first_name_24', 'last_name_24'),
  (3, 'first_name_25', 'last_name_25'),
  (3, 'first_name_26', 'last_name_26'),
  (3, 'first_name_27', 'last_name_27'),
  (3, 'first_name_28', 'last_name_28'),
  (3, 'first_name_29', 'last_name_29');

SELECT * FROM STUDENTS;

INSERT INTO ATTENDANCEOFCOURSES (student_id, course_id)
VALUES
  (1, 1),
  (2, 1),
  (3, 1),
  (4, 1),
  (5, 1),
  (6, 1),
  (7, 1),
  (8, 1),
  (9, 1),
  (10, 1),
  (11, 1),
  (12, 1),
  (13, 2),
  (14, 2),
  (15, 2),
  (16, 2),
  (17, 2),
  (18, 2),
  (19, 2),
  (20, 3),
  (21, 3),
  (22, 3),
  (23, 3),
  (24, 3),
  (25, 3),
  (26, 3),
  (27, 3),
  (28, 3),
  (29, 3);

SELECT * FROM ATTENDANCEOFCOURSES;