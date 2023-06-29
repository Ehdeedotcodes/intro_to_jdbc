# intro_to_jdbc
A jdbc repo to get started with connection to mysql database using java
reuse code for future projects 
# create mysql database to query
here I am using student as my database
# db creation query
CREATE DATABASE student;
# create tables for DB
here amd using two tables, one for student list and one for grades
# create student list table
CREATE TABLE student_ls (id INT PRIMARY KEY, name VARCHAR(20), department VARCHAR(20), institution VARCHAR(20), email VARCHAR(30))
# create grades table
CREATE TABLE grades (stud_id INT PRIMARY KEY, gpa_one DECIMAL(3,2), gpa_two DECIMAL(3,2))