CREATE DATABASE IF NOT EXISTS library_management;
USE library_management;

DROP TABLE IF EXISTS Loans;
DROP TABLE IF EXISTS Books;
DROP TABLE IF EXISTS Authors;
DROP TABLE IF EXISTS Members;

CREATE TABLE IF NOT EXISTS Authors(
		author_id INT PRIMARY KEY,
        first_name VARCHAR(30) NOT NULL,
        last_name VARCHAR(30) NOT NULL,
        birth_year INTEGER
);

CREATE TABLE IF NOT EXISTS Members(
		member_id INT PRIMARY KEY,
        first_name VARCHAR(30) NOT NULL,
        last_name VARCHAR(30) NOT NULL,
        email VARCHAR(50),
        join_date DATE
);

CREATE TABLE IF NOT EXISTS Books(
		book_id INT PRIMARY KEY,
        title VARCHAR(60) NOT NULL,
        author_id INTEGER,
        genre VARCHAR(30),
        publish_year INT,
        copies_total INT,
        copies_available INT,
        FOREIGN KEY (author_id)
        REFERENCES Authors(author_id)
);

CREATE TABLE IF NOT EXISTS Loans(
		loan_id INT PRIMARY KEY,
        member_id INT,
        book_id INT,
        loan_date DATE,
        due_date DATE,
        return_date DATE,
        FOREIGN KEY (member_id)
        REFERENCES Members(member_id),
        FOREIGN KEY (book_id)
        REFERENCES Books(book_id)
);

INSERT INTO Authors(author_id, first_name, last_name, birth_year)
VALUES
(1, 'George', 'Orwell', 1903),
(2, 'Harper', 'Lee', 1926),
(3, 'Jane', 'Austen', 1775),
(4, 'F. Scott', 'Fitzgerald', 1896),
(5, 'Mary', 'Shelley', 1797);

INSERT INTO Members(member_id, first_name, last_name, email, join_date)
VALUES
(101, 'Alice', 'Johnson', 'alice.johnson@email.com', '2024-01-15'),
(102, 'Brian', 'Smith', 'brian.smith@email.com', '2024-02-10'),
(103, 'Carla', 'Gomez', 'carla.gomez@email.com', '2024-03-05'),
(104, 'David', 'Lee', 'david.lee@email.com', '2024-03-20');

INSERT INTO Books(book_id, title, author_id, genre, publish_year, copies_total, copies_available)
VALUES
(201, '1984', 1, 'Dystopian', 1949, 5, 3),
(202, 'To Kill a Mockingbird', 2, 'Fiction', 1960, 4, 2),
(203, 'Pride and Prejudice', 3, 'Romance', 1813, 6, 4),
(204, 'The Great Gatsby', 4, 'Fiction', 1925, 3, 1),
(205, 'Frankenstein', 5, 'Horror', 1818, 2, 2);

INSERT INTO Loans(loan_id, member_id, book_id, loan_date, due_date, return_date)
VALUES
(301, 101, 201, '2026-01-10', '2026-01-24', '2026-01-20'),
(302, 102, 202, '2026-02-01', '2026-02-15', NULL),
(303, 103, 204, '2026-02-08', '2026-02-22', NULL),
(304, 101, 203, '2026-02-11', '2026-02-25', '2026-02-18');

SELECT * FROM Authors;
SELECT * FROM Members;
SELECT * FROM Books;
SELECT * FROM Loans;

SELECT COUNT(*) FROM Authors;
SELECT COUNT(*) FROM Members;
SELECT COUNT(*) FROM Books;
SELECT COUNT(*) FROM Loans;

SELECT Books.title, Authors.last_name
FROM Books
JOIN Authors ON Books.author_id = Authors.author_id;

SELECT loan_id, member_id, book_id
FROM Loans;