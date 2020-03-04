CREATE DATABASE IF NOT EXISTS pr CHARACTER SET  utf8mb4 COLLATE = utf8mb4_general_ci;

CREATE TABLE site_url
(
   id INT unsigned not null auto_increment primary key,
   name text,
   url text NOT NULL,
   description text,
   is_deleted bit DEFAULT 0,
   date_format varchar(100) DEFAULT 'EEE, d MMM yyyy HH:mm:ss zzz' NOT NULL,
   language varchar(2) DEFAULT 'RU' NOT NULL,
   payment_level varchar(20) DEFAULT 'FREE' NOT NULL
);

CREATE TABLE category
(
   id INT unsigned not null auto_increment primary key,
   name text NOT NULL,
   cat_type varchar(100) NOT NULL,
   parent  INT UNSIGNED NULL,
   FOREIGN KEY (parent) REFERENCES category (id),
   is_deleted bit DEFAULT 0
);

CREATE TABLE event
(
   id INT unsigned not null auto_increment primary key,
   created_date timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL,
   download_date timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL,
   job_site varchar(100),
   job_site_id varchar(100),
   title text NOT NULL,
   link text,
   short_text longtext  CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
   text longtext,
   category  INT UNSIGNED NULL,
   FOREIGN KEY (category) REFERENCES category (id),
   budget text,
   is_executive_selected bit DEFAULT 0,
   is_for_professional bit DEFAULT 0,
   is_deleted bit DEFAULT 0,
   send_by_email bit DEFAULT 0 NOT NULL,
   budget_from int,
   budget_to int,
   budget_currency varchar(10),
   budget_is_per_hour bit,
   budget_from_USD int,
   budget_to_USD int,
   notes longtext,
   status varchar(20) DEFAULT 'NOT_VIEWED' NOT NULL,
   rank int DEFAULT 0 NOT NULL
);

ALTER TABLE event add site_url_id INT UNSIGNED NOT NULL default 1;
ALTER TABLE event add FOREIGN KEY (site_url_id) REFERENCES site_url (id);
ALTER TABLE event ADD INDEX (title(10), short_text(20));




INSERT INTO site_url (id,name,url,description,is_deleted,date_format,language,payment_level) VALUES (2,'Деде','http://dede.com.ua/kyiv/week/rss/','s',0,'dd MMM yyyy hh:mm:ss','RU','FREE');
INSERT INTO site_url (id,name,url,description,is_deleted,date_format,language,payment_level) VALUES (3,'Facebook','http://facebook.com/',null,0,'dd MMM yyyy hh:mm:ss','UK','FREE');



INSERT INTO event (created_date,download_date,job_site,job_site_id,title,link,short_text,text,category,budget,is_executive_selected,is_for_professional,is_deleted,send_by_email,budget_from,budget_to,budget_currency,budget_is_per_hour,budget_from_USD,budget_to_USD,notes,status,rank,site_url_id,facebook_place_id,facebook_place_name,event_start_date,event_end_date,period) VALUES ({ts '2019-05-31 03:21:55.'},{ts '2019-05-31 03:21:55.'},'https://www.facebook.com',null,'Тренодії пам’яті Кіри Муратової. Євгеній Громов у БЗЗ','https://www.facebook.com/events/677502566032675/?acontext=%7B%22ref%22%3A51%2C%22source%22%3A5%2C%22action_history%22%3A[%7B%22surface%22%3A%22page%22%2C%22mechanism%22%3A%22main_list%22%2C%22extra_data%22%3A%22%5C%22[]%5C%22%22%7D]%2C%22has_source%22%3Atrue%7D',null,null,null,null,null,null,0,0,null,null,null,null,null,null,null,'NOT_VIEWED',1,3,'1526894164035364',null,{ts '2019-06-07 04:00:00.'},null,0);


CREATE TABLE app_role (
  id INT unsigned not null auto_increment primary key,
  description varchar(255) DEFAULT NULL,
  role_name varchar(255) DEFAULT NULL
);

CREATE TABLE app_user (
  id INT unsigned not null auto_increment primary key,
  first_name varchar(255) NOT NULL,
  last_name varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  username varchar(255) NOT NULL
);

CREATE TABLE user_role (
   app_user  INT UNSIGNED NULL,
   FOREIGN KEY (app_user) REFERENCES app_user (id),
   app_role  INT UNSIGNED NULL,
   FOREIGN KEY (app_role) REFERENCES app_role (id)
);


INSERT INTO app_role (id, role_name, description) VALUES (1, 'STANDARD_USER', 'Standard User - Has no admin rights');
INSERT INTO app_role (id, role_name, description) VALUES (2, 'ADMIN_USER', 'Admin User - Has permission to perform admin tasks');

-- USER
-- non-encrypted password: jwtpass
INSERT INTO app_user (id, first_name, last_name, password, username) VALUES (1, 'John', 'Doe', '$2a$10$qtH0F1m488673KwgAfFXEOWxsoZSeHqqlB/8BTt3a6gsI5c2mdlfe', 'john.doe');
INSERT INTO app_user (id, first_name, last_name, password, username) VALUES (2, 'Admin', 'Admin', '$2a$10$qtH0F1m488673KwgAfFXEOWxsoZSeHqqlB/8BTt3a6gsI5c2mdlfe', 'admin.admin');


INSERT INTO user_role(app_user, app_role) VALUES(1,1);
INSERT INTO user_role(app_user, app_role) VALUES(2,1);
INSERT INTO user_role(app_user, app_role) VALUES(2,2);
