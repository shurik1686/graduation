DELETE FROM USER_ROLES;
DELETE FROM USERS;
DELETE FROM RESTAURANT;
DELETE FROM RESTAURANT_MENU;
DELETE FROM VOTE;

ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO USERS (name, email, password)
VALUES ('User', 'user@yandex.ru', 'password'),
       ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO USER_ROLES (role, user_id)
VALUES ('USER', 100000),
       ('ADMIN', 100001),
       ('USER', 100001);

INSERT INTO RESTAURANT (NAME)
VALUES ('Помидор'),
       ('Крутли'),
       ('Березка');

INSERT INTO RESTAURANT_MENU (RESTAURANT_ID, DATE, NAME, PRICE)
VALUES (100002, '2021-01-07 0:00:00', 'Бургер', '100'),
       (100002, '2021-01-07 0:00:00', 'Шаурма', '102'),
       (100002, '2021-01-07 0:00:00', 'Пица', '101'),
       (100003, '2021-01-07 0:00:00', 'Салат', '370'),
       (100003, '2021-01-07 0:00:00', 'Сэндвич', '300'),
       (100003, '2021-01-07 0:00:00', 'Хот Дог', '312'),
       (100004, '2021-01-07 0:00:00', 'Тако', '421'),
       (100004, '2021-01-07 0:00:00', 'Рол', '423');

INSERT INTO VOTE (DATE_TIME, RESTAURANT_ID, USER_ID)
VALUES ('2021-01-07 0:00:00', 100002, 100000),
       ('2021-01-07 0:00:00', 100004, 100001);
