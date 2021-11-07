create table book (
                      id bigint not null auto_increment primary key,
                      isbn varchar(255),
                      publisher varchar(255),
                      title varchar(255),
                      author_id BIGINT
) engine=InnoDB;