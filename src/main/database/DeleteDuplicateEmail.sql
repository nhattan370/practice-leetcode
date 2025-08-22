/*
 Input:
Person table:
+----+------------------+
| id | email            |
+----+------------------+
| 1  | john@example.com |
| 2  | bob@example.com  |
| 3  | john@example.com |
+----+------------------+
Output:
+----+------------------+
| id | email            |
+----+------------------+
| 1  | john@example.com |
| 2  | bob@example.com  |
+----+------------------+
Explanation: john@example.com is repeated two times. We keep the row with the smallest Id = 1.
 */
-- Solution 1
WITH cte AS (
    SELECT id, LAG(email) OVER(PARTITION BY email ORDER BY id) AS email_after
    FROM Person
)
DELETE p
FROM Person p
JOIN cte c ON p.id = c.id
WHERE p.email = c.email_after;


-- Solution 2: It's not good
DELETE p1
FROM Person p1
JOIN Person p2 ON p1.email = p2.email
WHERE p1.email = p2.email AND p1.id>p2.id

/*
    p1_id | p1_email        | p2_id | p2_email
    ------+-----------------+-------+-----------------
    1     | john@example.com| 1     | john@example.com
    1     | john@example.com| 3     | john@example.com
    2     | bob@example.com | 2     | bob@example.com
    3     | john@example.com| 1     | john@example.com
    3     | john@example.com| 3     | john@example.com
 */

-- Solution 3: Can't use subquery in DELETE or INSERT. Because data always change, so subquery change. So We must use derived table
DELETE
FROM Person
WHERE id NOT IN (SELECT `min` FROM (SELECT MIN(id) AS `min` FROM Person GROUP BY emal) AS t);
