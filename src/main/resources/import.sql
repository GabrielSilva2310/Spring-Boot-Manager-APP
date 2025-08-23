
INSERT INTO tb_user (name, email, password, business_name) VALUES ('Gabriel Silva', 'gabriel@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', null);
INSERT INTO tb_user (name, email, password, business_name) VALUES ('Client1', 'client1@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', 'Company1');
INSERT INTO tb_user (name, email, password, business_name) VALUES ('Client2', 'client2@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', 'Company2');



INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');
INSERT INTO tb_role (authority) VALUES ('ROLE_CLIENT');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1,1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2,2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3,2);




