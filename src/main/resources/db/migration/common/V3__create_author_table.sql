create table author (
                        id bigint not null auto_increment primary key,
                        first_name varchar(255),
                        last_name varchar(255)
) engine=InnoDB;

alter table book
    add constraint book_author_fk foreign key (author_id) references author (id);