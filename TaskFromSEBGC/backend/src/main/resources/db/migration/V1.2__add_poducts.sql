INSERT INTO products (title, description) VALUES
('Current Account', 'Income > 0 & Age > 17'),
('Current Account Plus', 'Income > 40000 & Age > 17'),
('Junior Saver Account', 'Age < 18'),
('Student Account', 'Student = Yes & Age > 17'),
('Senior Account', 'Age >= 65'),
('Debit Card', 'Income < 12001 & Age > 17'),
('Credit Card', 'Income > 12000 & Age > 17'),
('Gold Credit', 'Card Income > 40000 & Age > 17')

-- INSERT INTO products (title, min_age, max_age, min_income, max_income, is_student, description) VALUES
-- ('Current Account', 18, 64, 1, null,  false,'Income > 0 & Age > 17'),
-- ('Current Account Plus', 18, 64, 4001, null, false, 'Income > 40000 & Age > 17'),
-- ('Junior Saver Account', 0, 17, null, null, false, 'Age < 18'),
-- ('Student Account', 18, 64, null, null, true, 'Student = Yes & Age > 17'),
-- ('Senior Account', 65, null, null, null, false, 'Age >= 65'),
-- ('Debit Card', 18, 64, 0, 1200, false, 'Income < 12001 & Age > 17'),
-- ('Credit Card', 18, 64, 1201, 4000, false, 'Income > 12000 & Age > 17'),
-- ('Gold Credit', 18, 64, 4001, null, false, 'Card Income > 40000 & Age > 17')