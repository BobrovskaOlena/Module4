SELECT p.id, SUM(w.salary * round((
      (DATE_PART('year', finish_date) - DATE_PART('year', start_date)) * 365 +
      (DATE_PART('month', finish_date) - DATE_PART('month', start_date)) * 30 +
      DATE_PART('day', finish_date) - DATE_PART('day', start_date)
    ) / 30)) AS project_cost
FROM project p
JOIN project_worker pw ON p.id = pw.project_id
JOIN worker w ON pw.worker_id = w.id
GROUP BY p.id
ORDER BY project_cost DESC;