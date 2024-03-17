insert into users (username, password, surname, nickname, enabled)
values ('user', '{bcrypt}$2a$10$XlkdPQQhYcolx8bgp6nL3uNvDs8ZwDXA4KFaDencZsIhjMQO3j5lq', 'surname', 'nickname', true);
INSERT INTO users (username, password, surname, nickname, enabled)
values ('guest', '{bcrypt}$2a$10$XlkdPQQhYcolx8bgp6nL3uNvDs8ZwDXA4KFaDencZsIhjMQO3j5lq', 'surname', 'nickname', true);
insert into users (username, password, surname, nickname, enabled)
values ('admin', '{bcrypt}$2a$10$XlkdPQQhYcolx8bgp6nL3uNvDs8ZwDXA4KFaDencZsIhjMQO3j5lq', 'surname', 'nickname', true);


INSERT INTO authorities (username, authority)
values ('user', 'ROLE_USER');
insert into authorities (username, authority)
values ('admin', 'ROLE_USER');
insert into authorities (username, authority)
values ('admin', 'ROLE_ADMIN');
insert into authorities (username, authority)
values ('guest', 'ROLE_GUEST');