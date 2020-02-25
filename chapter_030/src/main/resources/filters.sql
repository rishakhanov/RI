--create table type(
--	id serial primary key,
--	name varchar(2000)
--);

--create table product(
--	id serial primary key,
--	name varchar(2000),
--	type_id integer references type(id),
--	expired_date timestamp, 
--	price float8
--);

--insert into type(name) values ('СЫР');
--insert into type(name) values ('МОЛОКО');
--insert into type(name) values ('ХЛЕБ');

--select * from type;
--select * from product;

--insert into product(name, type_id, expired_date, price) values ('Сметанковый', 1, '2020-04-01 04:05:06', 2000.05);
--insert into product(name, type_id, expired_date, price) values ('Топленый', 1, '2020-03-01 04:05:06', 3100.00);
--insert into product(name, type_id, expired_date, price) values ('Костромской', 1, '2020-05-01 04:05:06', 4000.00);
--insert into product(name, type_id, expired_date, price) values ('Сыр мороженое', 1, '2020-05-01 04:05:06', 100.00);
--insert into product(name, type_id, expired_date, price) values ('Деревенское', 2, '2020-06-01 04:05:06', 500.00);
--insert into product(name, type_id, expired_date, price) values ('Колхозное', 2, '2020-03-01 04:05:06', 300.00);
--insert into product(name, type_id, expired_date, price) values ('Домашнее', 2, '2020-04-01 04:05:06', 600.00);
--insert into product(name, type_id, expired_date, price) values ('Молоко мороженое', 2, '2020-03-01 04:05:06', 400.00);
--insert into product(name, type_id, expired_date, price) values ('Белый', 3, '2020-03-01 04:05:06', 200.00);
--insert into product(name, type_id, expired_date, price) values ('Черный', 3, '2020-04-01 04:05:06', 250.99);
--insert into product(name, type_id, expired_date, price) values ('Кормовой', 3, '2020-05-01 04:05:06', 100.00);
--insert into product(name, type_id, expired_date, price) values ('n4', 3, '2020-03-01 04:05:06', 204.00);
--insert into product(name, type_id, expired_date, price) values ('n5', 3, '2020-04-01 04:05:06', 25.99);
--insert into product(name, type_id, expired_date, price) values ('n6', 3, '2020-05-01 04:05:06', 26.00);
--insert into product(name, type_id, expired_date, price) values ('n7', 3, '2020-03-01 04:05:06', 27.00);
--insert into product(name, type_id, expired_date, price) values ('n8', 3, '2020-04-01 04:05:06', 28.99);
--insert into product(name, type_id, expired_date, price) values ('n9', 3, '2020-05-01 04:05:06', 29.00);
--insert into product(name, type_id, expired_date, price) values ('n10', 3, '2020-03-01 04:05:06', 30.00);
--insert into product(name, type_id, expired_date, price) values ('n11', 3, '2020-04-01 04:05:06', 31.99);
--insert into product(name, type_id, expired_date, price) values ('n12', 3, '2020-05-01 04:05:06', 32.00);




--1. запрос получение всех продуктов с типом "СЫР":
select p.name, t.name, p.expired_date, p.price from product as p
inner join type as t on p.type_id = t.id
where t.name = 'СЫР';


--2. запрос получения всех продуктов, у кого в имени есть слово "мороженное"
select p.name, t.name, p.expired_date, p.price from product as p
inner join type as t on p.type_id = t.id
where p.name like '%мороженое%';

--3. запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.
select p.name, t.name, p.expired_date, p.price from product as p
inner join type as t on p.type_id = t.id
where p.expired_date between '2020-02-29 23:59:59' and '2020-04-01 00:00:00';

--4. запрос, который выводит самый дорогой продукт.
select p.name, t.name, p.expired_date, p.price from product as p
inner join type as t on p.type_id = t.id
order by p.price desc
limit 1

--select max(p.price) from product as p;

--5. запрос, который выводит количество всех продуктов определенного типа.
select count(p.id) from product as p
inner join type as t on p.type_id = t.id
where t.name = 'СЫР';

--6. запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
select p.name, t.name, p.expired_date, p.price from product as p
inner join type as t on p.type_id = t.id
where t.name = 'СЫР' or t.name = 'МОЛОКО';

--7. запрос, который выводит тип продуктов, которых осталось меньше 10 штук.  
select t.name from type as t
inner join product as p on t.id = p.type_id
group by t.name
having count(p.id) < 10;

--8. вывести все продукты и их тип.
select p.name, t.name, p.expired_date, p.price from product as p
inner join type as t on p.type_id = t.id;


