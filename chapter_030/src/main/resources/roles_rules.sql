--create database users_roles;

--create table roles (
--	id serial primary key,
--	roles varchar(2000)
--);

--create table users(
--	id serial primary key,
--	name varchar(2000),
--	roles_id integer references roles(id)
--);

--create table rules (
--	id serial primary key,
--	rules text
--);

--create table roles_rules (
--	id serial primary key,
--	roles_id int references roles(id),
--	rules_id int references rules(id)
--);

--create table categories (
--	id serial primary key,
--	categories varchar(2000)
--);

--create table states (
--	id serial primary key,
--	states varchar(2000)
--);

--create table items (
--	id serial primary key,
--	items text,
--	users_id int references users(id),
--	categories_id int references categories(id),
--	states_id int references states(id)
--);

--create table comments (
--	id serial primary key,
--	comments text,
--	items_id int references items(id)
--);

--insert into roles(roles) values ('role1');
--insert into rules(rules) values ('rule1');
--insert into roles_rules(roles_id, rules_id) values (1, 1);
--insert into categories(categories) values ('cat1');
--insert into states(states) values ('state1');
--insert into users(name, roles_id) values ('user1', 1); 
--insert into items (items, users_id, categories_id, states_id) values ('item1', 1, 1, 1);
--insert into comments(comments, items_id) values ('comment1', 1);