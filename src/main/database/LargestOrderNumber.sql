/*
 Orders table:
+--------------+-----------------+
| order_number | customer_number |
+--------------+-----------------+
| 1            | 1               |
| 2            | 2               |
| 3            | 3               |
| 4            | 3               |
+--------------+-----------------+
Output:
+-----------------+
| customer_number |
+-----------------+
| 3               |
+-----------------+
Explanation:
The customer with number 3 has two orders, which is greater than either customer 1 or 2 because each of them only has one order.
So the result is customer_number 3.
 */
 --Solution 1: Subquery and create cte
WITH cte AS(
    SELECT customer_number, COUNT(*) AS count_order
    FROM Orders
    GROUP BY customer_number
)
SELECT customer_number
FROM cte
WHERE count_order = (SELECT MAX(count_order) FROM cte)
-- Solution 2: Doing direction
SELECT customer_number
FROM Orders
GROUP BY customer_number
ORDER BY COUNT(*) DESC
    LIMIT 1 OFFSET 0