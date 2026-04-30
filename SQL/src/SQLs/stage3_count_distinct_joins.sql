USE library_management;

SELECT Books.title, Authors.last_name FROM
Books
LEFT JOIN Authors
ON Books.author_id = Authors.author_id;

SELECT count(*) FROM
Loans;

SELECT count(DISTINCT member_id) FROM
Loans;

SELECT DISTINCT shelf_location FROM Books;

SELECT Members.first_name, Loans.loan_id FROM
Members
RIGHT JOIN Loans
ON Members.member_id = Loans.member_id;