SELECT ID,"name", birthday, "level", salary
FROM worker
WHERE salary = (SELECT MAX(salary) FROM worker);