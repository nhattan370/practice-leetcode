/*
 Example 1:

Input:
Insurance table:
+-----+----------+----------+-----+-----+
| pid | tiv_2015 | tiv_2016 | lat | lon |
+-----+----------+----------+-----+-----+
| 1   | 10       | 5        | 10  | 10  |
| 2   | 20       | 20       | 20  | 20  |
| 3   | 10       | 30       | 20  | 20  |
| 4   | 10       | 40       | 40  | 40  |
+-----+----------+----------+-----+-----+
Output:
+----------+
| tiv_2016 |
+----------+
| 45.00    |
+----------+
Explanation:
The first record in the table, like the last record, meets both of the two criteria.
The tiv_2015 value 10 is the same as the third and fourth records, and its location is unique.

The second record does not meet any of the two criteria. Its tiv_2015 is not like any other policyholders and its location is the same as the third record, which makes the third record fail, too.
So, the result is the sum of tiv_2016 of the first and last record, which is 45.
 */

-- Solution 1: Count the appearances of tiv_2015 and lat,lon
WITH cte AS(
    SELECT tiv_2015, tiv_2016,
           COUNT(*) OVER(PARTITION BY tiv_2015) AS count_tiv_2015,
        COUNT(*) OVER(PARTITION BY lat, lon) AS count_lat_lon
    FROM Insurance
)
SELECT ROUND(SUM(tiv_2016),2) AS tiv_2016
FROM cte
WHERE count_tiv_2015>1 AND count_lat_lon = 1;
-- Solution 2: JOIN table, the faster way
WITH count_tiv AS (
    SELECT tiv_2015, COUNT(*) AS cnt
    FROM Insurance
    GROUP BY tiv_2015
),
     count_loc AS (
         SELECT lat, lon, COUNT(*) AS cnt
         FROM Insurance
         GROUP BY lat, lon
     )
SELECT ROUND(SUM(i.tiv_2016), 2) AS tiv_2016
FROM Insurance i
         JOIN count_tiv ct ON i.tiv_2015 = ct.tiv_2015
         JOIN count_loc cl ON i.lat = cl.lat AND i.lon = cl.lon
WHERE ct.cnt > 1
  AND cl.cnt = 1;