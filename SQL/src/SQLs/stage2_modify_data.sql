USE library_management;

ALTER TABLE Members CHANGE COLUMN email email_address VARCHAR(60);

ALTER TABLE Books DROP COLUMN genre;

ALTER TABLE Books ADD COLUMN shelf_location VARCHAR(10);

ALTER TABLE Members ADD COLUMN membership_level VARCHAR(20);

ALTER TABLE Loans ADD COLUMN loan_status VARCHAR(20);

SELECT * FROM Members;