SELECT c.*, COUNT(p.client_id) AS project_count
FROM client c
LEFT JOIN project p ON c.id = p.client_id
GROUP BY c.id
HAVING COUNT(p.client_id) = (
    SELECT COUNT(client_id)
    FROM project
    GROUP BY client_id
    ORDER BY COUNT(client_id) DESC
    LIMIT 1
);