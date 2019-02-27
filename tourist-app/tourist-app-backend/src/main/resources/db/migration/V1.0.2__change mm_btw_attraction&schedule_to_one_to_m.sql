drop table attraction_schedule;
alter table attraction add column weekly_schedule_id int;
alter table attraction
ADD constraint attraction_weekly_schedule_id_fkey
FOREIGN KEY (weekly_schedule_id) REFERENCES weekly_schedule(id);