create table user(
                     id varchar(20) COLLATE utf8mb4_general_ci NOT NULL  PRIMARY KEY,
                     password  varchar(20) COLLATE utf8mb4_general_ci NOT NULL,
                     interset char(8) COLLATE utf8mb4_general_ci NOT NULL,
                     name varchar(20) COLLATE utf8mb4_general_ci NOT NULL,
                     age decimal(2,0) NOT NULL,
                     sex char(2) COLLATE utf8mb4_general_ci NOT NULL,
                     phone_number decimal(11,0) NOT NULL,
                     CONSTRAINT user_chk_1 CHECK ((sex = '男') or (sex = '女'))
);
create table scenic_spot(
                            name varchar(50) COLLATE utf8mb4_general_ci NOT NULL  PRIMARY KEY,
                            locate_x int NOT NULL ,
                            locate_y int NOT NULL ,
                            during char(7) COLLATE utf8mb4_general_ci NOT NULL,
                            price char(1) COLLATE utf8mb4_general_ci NOT NULL,
                            classification char(8) COLLATE utf8mb4_general_ci NOT NULL,
                            CONSTRAINT scenic_spot_chk_1 CHECK ((price = '1') or (price = '0')),
                            CONSTRAINT uk_locate_x_locate_y UNIQUE(locate_x ,locate_y)
);
create table Tourism_intention(
                                  usr_id varchar(20) COLLATE utf8mb4_general_ci   ,
                                  scenicspot_name varchar(50) COLLATE utf8mb4_general_ci  ,
                                  PRIMARY KEY(usr_id,scenicspot_name),
                                  foreign key (usr_id) references user(id),
                                  foreign key (scenicspot_name) references scenic_spot(name)
);
create table route(
                      id int primary key auto_increment,
                      route varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
                      CONSTRAINT uk_route UNIQUE(route)
);
create table review(
                       route_id int ,
                       usr_id varchar(20) COLLATE utf8mb4_general_ci  ,
                       time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       score int ,
                       review_text varchar(200) COLLATE utf8mb4_general_ci NOT NULL,
                       PRIMARY KEY(route_id,usr_id,time),
                       foreign key (route_id) references route(id),
                       foreign key (usr_id) references user(id)
);
create table log(
                    usr_id varchar(20) COLLATE utf8mb4_general_ci  ,
                    time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                    log_text varchar(200) COLLATE utf8mb4_general_ci NOT NULL,
                    PRIMARY KEY(usr_id,time),
                    foreign key (usr_id) references user(id)
);
create table guide(
                      usr_id varchar(20) COLLATE utf8mb4_general_ci  ,
                      time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                      guide_text varchar(200) COLLATE utf8mb4_general_ci NOT NULL,
                      route_id int,
                      PRIMARY KEY(usr_id,time),
                      foreign key (usr_id) references user(id),
                      foreign key (route_id) references route(id)
);