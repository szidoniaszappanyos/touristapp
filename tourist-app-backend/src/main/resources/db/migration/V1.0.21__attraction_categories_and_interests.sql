ALTER TABLE interests ADD COLUMN stars SMALLINT DEFAULT 0;

create table attraction_type_category (category_id int8 not null, type_id int8 not null, primary key (type_id, category_id));
create table attraction_category (id int8 not null, category varchar(255), primary key (id));

alter table attraction_type_category add constraint FK6fugp0dak0sxr91e0a1g9gyin foreign key (type_id) references attraction_type;
alter table attraction_type_category add constraint FK35eb0euri3uhvdvh2t4h7yceb foreign key (category_id) references attraction_category;