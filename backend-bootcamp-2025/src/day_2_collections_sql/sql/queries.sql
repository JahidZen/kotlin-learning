drop table if exists posts;
drop table if exists users;

-- Create table of users
create table users(
                      id SERIAL primary key, -- incrementing id number by serial
                      name varchar(100),
                      email varchar(200) unique
);


-- creating posts table
create table posts (
                       id serial primary key,
                       users_id integer references users(id),
                       title varchar(300),
                       content text
);

-- Inserting data into users table
insert into users(name, email)
values('Alice', 'alice@gmail.com');

insert into users(name, email)
values('Bob', 'bob@gmail.com');

insert into users(name, email)
values('Charlie', 'charlie@gmail.com');
select * from users;


-- inserting data into posts table
insert into posts(users_id, title, content)
values(1, 'Alice post 1', 'This is Alice''s first post');

insert into posts(users_id, title, content)
values(1, 'Alice post 2', 'Alice studies in Harvard University');

insert into posts(users_id, title, content)
values(2, 'Bob post 1', 'I''m becoming so fat 😭');
-- it selects all columns and rows on the table
select * from posts;


-- Query 2: Select all posts written by Alice
select * from posts
where users_id = 1;


-- Query 3: INNER JOIN users and posts
select
    users.name,
    posts.title,
    posts.content
from posts
         inner join users
                    on posts.users_id = users.id;


-- query 4: Left join
select
    users.name,
    posts.title,
    posts.content
from users
         left join posts
                   on users.id = posts.users_id;

-- LEFT JOIN returns all users from the left table (users),
-- even if they do not have any matching rows in the posts table.
-- If a user has no posts, the post-related columns are returned as NULL.
--
-- That is why Charlie appears in the LEFT JOIN result with NULL values
-- for title and content.
--
-- Charlie does NOT appear in the INNER JOIN result because INNER JOIN
-- only returns rows where there is a match in both tables.
-- Since Charlie has no posts, there is no matching row in the posts table,
-- so he is excluded.
--
-- Key point: LEFT JOIN keeps all rows from the left table (users).

select * from users;



