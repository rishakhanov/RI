create table carbody(
	id serial primary key,
	name varchar(200)
);

create table engine(
	id serial primary key,
	name varchar(200)
);

create table transmission(
	id serial primary key,
	name varchar(200)
);

create table car(
	id serial primary key,
	name varchar(200),
	id_carbody int references carbody(id),
	id_engine int references engine(id),
	id_transmission int references transmission(id)
);

--select * from car
--select * from carbody
--select * from engine
--select * from transmission

insert into carbody(name) values ('mercedes_body');
insert into carbody(name) values ('audi_body');
insert into carbody(name) values ('bmw');
insert into carbody(name) values ('renault');
insert into carbody(name) values ('ford_body');
insert into engine(name) values ('mercedes_engine');
insert into engine(name) values ('audi_engine');
insert into engine(name) values ('bmw_engine');
insert into engine(name) values ('renault_engine');
insert into engine(name) values ('ford_engine');
insert into transmission(name) values ('mercedes_transmission');
insert into transmission(name) values ('audi_transmission');
insert into transmission(name) values ('bmw_transmission');
insert into transmission(name) values ('renault_transmission');
insert into transmission(name) values ('ford_transmission');
insert into car(name, id_carbody, id_engine, id_transmission) values ('mercedes', 1, 1, 1);
insert into car(name, id_carbody, id_engine, id_transmission) values ('audi', 2, 2, 2);
insert into car(name, id_carbody, id_engine, id_transmission) values ('bmw', 3, 3, 3);

--1. Вывести список всех машин и все привязанные к ним детали.
select c.name, cb.name, e.name, t.name from car as c 
left outer join carbody as cb on c.id_carbody=cb.id
left outer join engine as e on c.id_engine=e.id
left outer join transmission as t on c.id_transmission=t.id;

--2. Вывести отдельно детали, которые не используются в машине, кузова, двигатели, коробки передач.
select c.name, cb.name from carbody as cb left outer join car as c on c.id_carbody=cb.id where c.id is null;
select c.name, e.name from engine as e left outer join car as c on c.id_engine=e.id where c.id is null;
select c.name, t.name from transmission as t left outer join car as c on c.id_transmission=t.id where c.id is null;