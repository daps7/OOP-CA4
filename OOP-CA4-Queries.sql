CREATE DATABASE expense_record; --Creating Database
USE expense_record;
CREATE TABLE expenses (
    expenseID INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR() NOT NULL,
    category VARCHAR(50) NOT NULL,
    amount DOUBLE NOT NULL,
    dateIncurred DATE NOT NULL
);

CREATE TABLE income (
    incomeID INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(50) NOT NULL,
    amount DOUBLE NOT NULL,
    dateEarned DATE NOT NULL
);
