SELECT p.id, SUM(w.salary *
    (extract(year from age(p.finish_date, p.start_date))*12 +
    extract(month from age(p.finish_date,p.start_date)))) AS project_cost
FROM project p
JOIN project_worker pw ON p.id = pw.project_id
JOIN worker w ON pw.worker_id = w.id
GROUP BY p.id
ORDER BY project_cost DESC;