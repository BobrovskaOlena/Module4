select id,(extract(year from age(p.finish_date, p.start_date))*12+
extract(month from age(p.finish_date,p.start_date))) as months from project p
where (extract(year from age(p.finish_date, p.start_date))*12+
extract(month from age(p.finish_date,p.start_date))) in (
select (extract(year from age(p2.finish_date, p2.start_date))*12+
extract(month from age(p2.finish_date,p2.start_date))) as months from project p2
order by months desc limit 1);