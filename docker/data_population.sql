insert into exercise (id, name)
values (uuid_generate_v4(), 'Bench Press'),
       (uuid_generate_v4(), 'Push Press');


insert into "user" (id, first_name, last_name, username, password)
values (uuid_generate_v4(), 'gabriel', 'poleze', 'gabriel.poleze@gmail.com', '$2a$10$u18niEc0dMMNzWMMEb28Se.1Oya9sVgJLrmn9WlGPsH7PpkDRsK..');

insert into auth_user_group (id, user_id, auth_group_id)
values (uuid_generate_v4(),
        (select id from "user" where username = 'gabriel.poleze@gmail.com'),
        (select id from auth_group where name = 'admin'));