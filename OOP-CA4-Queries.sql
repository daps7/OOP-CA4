CREATE DATABASE expense_record; --Database Creation
USE expense_record;
--Creation of tables (income and expense)
CREATE TABLE income (
    incomeID INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    amount DOUBLE NOT NULL,
    dateEarned DATE NOT NULL
);

CREATE TABLE expenses (
    expenseID INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    category VARCHAR(255) NOT NULL,
    amount DOUBLE NOT NULL,
    dateIncurred DATE NOT NULL
);

-- Sample Data
INSERT INTO income (title, amount, dateEarned) VALUES 
('Babysitting', 60, '2025-01-05'),
('Bar work', 100, '2025-01-07');

INSERT INTO expenses (title, category, amount, dateIncurred) VALUES 
('Weekly shop', 'Groceries', 47.50, '2025-01-07'),
('Gym membership', 'Fitness', 30, '2025-01-09');
