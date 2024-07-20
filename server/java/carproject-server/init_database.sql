create table sensor_data
(
    id          int auto_increment
        primary key,
    user        varchar(50)                        not null,
    data        mediumtext                         null,
    create_time datetime default CURRENT_TIMESTAMP not null
);
