-- Subquery
WITH cte AS (
    SELECT accepter_id AS id FROM RequestAccepted
    UNION ALL
    SELECT requester_id FROM RequestAccepted
), counter AS (
    SELECT id, count(id) AS num
    FROM cte
    GROUP BY id
)
SELECT id, num
FROM counter
WHERE num = (SELECT MAX(num) FROM counter);
-- Order limit
WITH cte AS (
    SELECT accepter_id AS id FROM RequestAccepted
    UNION ALL
    SELECT requester_id FROM RequestAccepted
)

SELECT id, COUNT(*) AS num
FROM cte
GROUP BY id
ORDER BY num DESC
    LIMIT 1 OFFSET 0