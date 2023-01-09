-- SQL-dialect fpr PostgreSQL

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
    year int not null check ( year > 1500 )
);

insert into person (name, yearofbirth) VALUES ('Andrii Hlybchenko 0.', 1998);
insert into person (name, yearofbirth) VALUES ('Sehii Cherednichenko 0.', 1997);
insert into person (name, yearofbirth) VALUES ('Elizaveta Dashko A.', 2000);
insert into person (name, yearofbirth) VALUES ('Bohdan Chernetskii S.', 1992);
insert into person (name, yearofbirth) VALUES ('Aleksandr Karatanov V.', 1986);

insert into book (person_id, name, author, "year") VALUES (1, 'Kobzar (poetry collection)', 'Taras Hryhorovych Shevchenko', 1840);
insert into book (person_id, name, author, "year") VALUES (null, 'Nineteen Eighty-Four', 'George Orwell', 1949);
insert into book (person_id, name, author, "year") VALUES (2, 'Divine Comedy', 'Dante Alighieri', 1720);
insert into book (person_id, name, author, "year") VALUES (4, 'Frankenstein; or, The Modern Prometheus ', 'Mary Shelley', 1818);
insert into book (person_id, name, author, "year") VALUES (1, 'Kallocain', 'Karin Boye', 1940);
insert into book (person_id, name, author, "year") VALUES (1, 'Atlas Shrugged', 'Ayn Rand', 1957);
insert into book (person_id, name, author, "year") VALUES (3, 'Fahrenheit 451', 'Ray Bradbury', 1953);