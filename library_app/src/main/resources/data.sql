-- SQL-dialect for PostgreSQL

-- start Docker PostgreSQL in container: just copy-paste in terminal text below
-- docker run -p 5432:5432 --name postgres -d -it -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=library_db postgres:15

create table person (
    id int primary key generated by default as identity,
    name varchar(100) not null,
    yearofbirth int not null check ( yearofbirth > 1950 )
);

create table book (
    book_id int primary key generated by default as identity,
    person_id int references person(id) on delete set null,
    name varchar(100) not null,
    author varchar (100) not null,
    year int not null
);

insert into person (name, yearofbirth) VALUES ('Andrii Hlybchenko 0.', 1998);
insert into person (name, yearofbirth) VALUES ('Sehii Cherednichenko S.', 1997);
insert into person (name, yearofbirth) VALUES ('Elizaveta Dashko A.', 2000);
insert into person (name, yearofbirth) VALUES ('Bohdan Chernetskii S.', 1992);
insert into person (name, yearofbirth) VALUES ('Aleksandr Karatanov V.', 1986);
insert into person (name, yearofbirth) VALUES ('Dmitro Verhuz V.', 2000);
insert into person (name, yearofbirth) VALUES ('Maryna Galanskya A.', 2000);
insert into person (name, yearofbirth) VALUES ('Evhenyi Stryuk O.', 2008);
insert into person (name, yearofbirth) VALUES ('Stanislav Lindover P.', 1972);
insert into person (name, yearofbirth) VALUES ('Oleksandra Kovalenko O.', 1999);
insert into person (name, yearofbirth) VALUES ('Victoria Artemenko A.', 2001);
insert into person (name, yearofbirth) VALUES ('Volodymyr Zelenskyy O.', 1978);
insert into person (name, yearofbirth) VALUES ('Barack Obama H.', 1961);
insert into person (name, yearofbirth) VALUES ('Elon Musk R.', 1971);

insert into book (person_id, name, author, "year") VALUES (1, 'Kobzar (poetry collection)', 'Taras Shevchenko H.', 1840);
insert into book (person_id, name, author, "year") VALUES (null, 'Nineteen Eighty-Four', 'George Orwell', 1949);
insert into book (person_id, name, author, "year") VALUES (2, 'Divine Comedy', 'Dante Alighieri', 1720);
insert into book (person_id, name, author, "year") VALUES (4, 'Frankenstein; or, The Modern Prometheus ', 'Mary Shelley', 1818);
insert into book (person_id, name, author, "year") VALUES (11, 'Kallocain', 'Karin Boye', 1940);
insert into book (person_id, name, author, "year") VALUES (1, 'Atlas Shrugged', 'Ayn Rand', 1957);
insert into book (person_id, name, author, "year") VALUES (3, 'Fahrenheit 451', 'Ray Bradbury', 1953);
insert into book (person_id, name, author, "year") VALUES (5, 'The Great Gatsby', 'Scott Fitzgerald F.', 1925);
insert into book (person_id, name, author, "year") VALUES (null, 'Crime and Punishment', 'Fyodor Dostoevsky M,', 1866);
insert into book (person_id, name, author, "year") VALUES (6, 'Moby-Dick', 'Herman Melville', 1851);
insert into book (person_id, name, author, "year") VALUES (8, 'Dracula', 'Bram Stoker', 1897);
insert into book (person_id, name, author, "year") VALUES (null, 'The Lord of the Rings', 'J. R. R. Tolkien', 1954);
insert into book (person_id, name, author, "year") VALUES (10, 'The Adventures of Huckleberry Finn', 'Mark Twain ', 1884);
insert into book (person_id, name, author, "year") VALUES (3, 'The Iliad', 'Homer', -800);
insert into book (person_id, name, author, "year") VALUES (9, 'Animal Farm ', 'George Orwell', 1945);
insert into book (person_id, name, author, "year") VALUES (14, 'The Castle', 'Franz Kafka', 1920);
insert into book (person_id, name, author, "year") VALUES (null, 'The Art of War', 'Sun Tzu', -5000);