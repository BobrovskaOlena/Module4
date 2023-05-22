WITH durations AS (
  SELECT id,
    round((
      (DATE_PART('year', finish_date) - DATE_PART('year', start_date)) * 365 +
      (DATE_PART('month', finish_date) - DATE_PART('month', start_date)) * 30 +
      DATE_PART('day', finish_date) - DATE_PART('day', start_date)
    ) / 30) AS duration_months
  FROM project
)
SELECT id, duration_months
FROM durations
WHERE duration_months = (
  SELECT max(duration_months)
  FROM durations
);