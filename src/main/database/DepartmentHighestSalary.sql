/*
 Table: Employee

+--------------+---------+
| Column Name  | Type    |
+--------------+---------+
| id           | int     |
| name         | varchar |
| salary       | int     |
| departmentId | int     |
+--------------+---------+
id is the primary key (column with unique values) for this table.
departmentId is a foreign key (reference columns) of the ID from the Department table.
Each row of this table indicates the ID, name, and salary of an employee. It also contains the ID of their department.


Table: Department

+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| name        | varchar |
+-------------+---------+
id is the primary key (column with unique values) for this table. It is guaranteed that department name is not NULL.
Each row of this table indicates the ID of a department and its name.
 */


-- Solution 1
SELECT d.name AS Department, e.name AS Employee, e.salary AS Salary
FROM Employee e
         JOIN Department d ON e.departmentId = d.id
WHERE Salary = (
    SELECT MAX(e1.salary)
    FROM Employee e1
    WHERE e1.departmentId = e.departmentId
)
-- Solution 2: More efficient
WITH cte AS(
    SELECT d.name AS Department, e.name AS Employee, e.salary AS Salary, RANK() OVER(PARTITION BY e.departmentId ORDER BY salary DESC) AS `rank`
    FROM Employee e
    JOIN Department d ON e.departmentId = d.id
)
SELECT Department, Employee, Salary
FROM cte
WHERE `rank` = 1;