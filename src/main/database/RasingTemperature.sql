/*
 Input:
Weather table:
+----+------------+-------------+
| id | recordDate | temperature |
+----+------------+-------------+
| 1  | 2015-01-01 | 10          |
| 2  | 2015-01-02 | 25          |
| 3  | 2015-01-03 | 20          |
| 4  | 2015-01-04 | 30          |
+----+------------+-------------+
Output:
+----+
| id |
+----+
| 2  |
| 4  |
+----+
 */

--  Solution 1: Window function
WITH cte AS(
    SELECT id, temperature,
    LAG(temperature) OVER(ORDER BY recordDate) AS temp_prev_date,
    DATEDIFF(recordDate, LAG(recordDate) OVER(ORDER BY recordDate)) AS date_diff
    FROM Weather
)
SELECT id
FROM Cte
WHERE temperature > temp_prev_date AND date_diff=1;
-- Solution 2: Self-join
SELECT w1.id AS id
FROM Weather w1
         JOIN Weather w2 ON w2.recordDate = DATE_SUB(w1.recordDate, INTERVAL 1 DAY)
WHERE w1.temperature > w2.temperature