create database if not exists MyBookstore;
use MyBookstore;
drop table if exists `orders`;
create table `orders`
(
    `order_id`    int(10) not null,
    `user_id`     int(32) not null,
    `price` decimal(10, 2) default null,
    `time`        varchar(255)   default null,
    primary key (`order_id`)
);
alter table orders modify order_id int auto_increment;

drop table if exists `order_items`;
create table `order_items`
(
    `order_id`      int(10) not null,
    `order_item_id` int(10) not null,
    `book_id`       int(10)        default null,
    `name`          varchar(255)   default null,
    `number`        int(8)         default null,
    `total_price`   decimal(10, 2) default null,

    primary key (`order_item_id`),
    constraint fk_order_id foreign key (`order_id`) references `orders`(`order_id`)
);
alter table order_items modify order_item_id int auto_increment;

drop table if exists `users`;
create table `users`
(
    `id`          int(32) not null,
    `name`        varchar(255) default null,
    `icon`        varchar(511) default null,
    `description` varchar(255) default null,
    primary key (`id`)
);
alter table users modify id int auto_increment;

drop table if exists `user_auth`;
create table `user_auth`
(
    `user_id`   int(32)      not null,
    `username`  varchar(255) not null,
    `password`  varchar(255) not null,
    `user_type` int(11)      not null,
    constraint fk_userid foreign key (`user_id`) references `users`(`id`)
);

drop table if exists `books`;
create table `books`
(
    `id`          int(10) not null,
    `name`        varchar(255)   default null,
    `avatar`      varchar(511)   default null,
    `price`       decimal(10, 2) default null,
    `author`      varchar(255)   default null,
    `description` varchar(255)   default null,
    `date`        date   default null,
    primary key (`id`)
);
alter table books modify id int auto_increment;

drop table if exists `carts`;
create table `carts`
(
    `user_id` int(32) not null,
    `cart_item_id` int(32) not null,
    `book_id`      int(10) default null,
    `number`       int(10) default null,
    primary key (`cart_item_id`),
    constraint fk_book_id foreign key (`book_id`) references `books`(`id`)
);
alter table carts modify cart_item_id int auto_increment;


insert into users(id, name, icon, description) VALUE (1,'jerry','https://ts1.cn.mm.bing.net/th/id/R-C.3add92626dd4ee1135d626458c840234?rik=FcgOSv5brtpUnw&riu=http%3a%2f%2fpic8.photophoto.cn%2f20080804%2f0021033865098098_b.jpg&ehk=1GWvFQLNlsGizTHiEZ4hoBQPsPWZw3tw7ETVzsxcebM%3d&risl=&pid=ImgRaw&r=0','This is a clever mouse.');
insert into users(id, name, icon, description) VALUE (2,'tom','https://i.gtimg.cn/qqlive/img/jpgcache/files/qqvideo/hori/m/mz2mzmmuts9r75o.jpg','This is a funny cat.');
insert into user_auth(user_id, username, password, user_type) VALUE (1,'jerry','jerry123',1);
insert into user_auth(user_id, username, password, user_type) VALUE (2,'tom','tom123',1);

insert into books(id, name, avatar, price, author, description, date) VALUE (1,'程序设计思想与方法','https://ts1.cn.mm.bing.net/th/id/R-C.493bfdc07d196c4323417779c6340988?rik=Tgt7I86Eop2eNQ&riu=http%3a%2f%2ffile.ryjiaoyu.com%2fSmallCover%2f1608161d6690ae92dfdf&ehk=hAHjipI%2fmDTPaRgY9uZYBz9EYs2ivIzI1NddF0t5inA%3d&risl=&pid=ImgRaw&r=0',19.99,'翁惠玉，俞勇','This is a useful book to learn c++.',20200326);
insert into books(id, name, avatar, price, author, description, date) VALUE (2,'三体','https://ts1.cn.mm.bing.net/th/id/R-C.eaa4430d3c9b5e9594491cc29ada0f5c?rik=sI1v7tlAKAnMPg&riu=http%3a%2f%2fi9.qhimg.com%2fdr%2f270_500_%2ft01fd3a90e061edc3be.jpg&ehk=JB7FK3iNhjgSzS83nbCy6DNltm58AvnJh6omNiXjW18%3d&risl=&pid=ImgRaw&r=0',99.99,'刘慈欣','This is an interesting science fiction.',20230408);
insert into books(id, name, avatar, price, author, description, date) VALUE (3,'数据结构','https://ts1.cn.mm.bing.net/th/id/R-C.8f6363b8c53801147705e0cb3845a0af?rik=AENFXWIWlqbFMg&riu=http%3a%2f%2fabook.hep.com.cn%2fICourseFiles%2fMaterialsLibCovers%2fgroup2%2fM00%2f35%2f6A%2fwKhLoFivlyKAAwJcAAKX-ZaDj5g64..jpg&ehk=L3rulQFJt%2fNMCdmp1%2bmzXxTvJ3tKFzWym71OeS8tcjI%3d&risl=&pid=ImgRaw&r=0',49.99,'刘大勇等','This is a book to help you understand how data is saved in program.',20230417);
insert into orders(order_id, user_id, price, time) VALUE (1,1,998.00,'20230505');
insert into order_items(order_id, order_item_id, book_id,name, number, total_price) VALUE (1,1,1,'数据结构',3,56.00);
insert into order_items(order_id, order_item_id, book_id,name, number, total_price) VALUE (1,2,2,'三体',1,29.00);
insert into order_items(order_id, order_item_id, book_id,name, number, total_price) VALUE (1,3,3,'程序设计思想与方法',9,235.00);
insert into orders(order_id, user_id, price, time) VALUE (2,1,1145.14,'20230507');
insert into order_items(order_id, order_item_id, book_id,name, number, total_price) VALUE (2,4,1,'数据结构',4,98.00);
insert into order_items(order_id, order_item_id, book_id,name, number, total_price) VALUE (2,5,2,'三体',50,2222.00);
insert into order_items(order_id, order_item_id, book_id,name, number, total_price) VALUE (2,6,3,'程序设计思想与方法',3,14.00);
insert into carts(user_id, cart_item_id, book_id, number) VALUE (1,1,1,3);
insert into carts(user_id, cart_item_id, book_id, number) VALUE (1,2,3,1);
insert into carts(user_id, cart_item_id, book_id, number) VALUE (1,3,2,6);
insert into carts(user_id, cart_item_id, book_id, number) VALUE (2,4,3,12);
insert into carts(user_id, cart_item_id, book_id, number) VALUE (2,5,1,31);
# insert into carts(user_id, cart_item_id, book_id, number) VALUE (2,6,2,4);

