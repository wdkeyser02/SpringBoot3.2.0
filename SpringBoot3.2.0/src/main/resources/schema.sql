-- Users
create table if not exists users
(
	username varchar(200) not null primary key,
	password varchar(500) not null,
	enabled boolean not null
);

-- Authorities
create table if not exists authorities
(
	username varchar(200) not null,
	authority varchar(50) not null,
	constraint fk_authorities_users foreign key (username) references users (username),
	constraint username_authority UNIQUE (username, authority)
);

-- Insert new Users & Authorities
-- INSERT users VALUES("user", "{bcrypt}$2a$14$tEnq90/CcR320dWQ.NdQLuj326PmgLzMGmFkUUOHQrbjPWplKK67i", true); --Password = 'password'
-- INSERT users VALUES("admin", "{bcrypt}$2a$14$tJANh4xMR7qNjwwftmoZjezhp6rP.RVUtIFXFBF6maQvqGXwvM4JS", true); --Password = 'password'
-- INSERT users VALUES("user1", "{bcrypt}$2a$14$tEnq90/CcR320dWQ.NdQLuj326PmgLzMGmFkUUOHQrbjPWplKK67i", true); --Password = 'password'
-- INSERT users VALUES("user2", "{bcrypt}$2a$14$tEnq90/CcR320dWQ.NdQLuj326PmgLzMGmFkUUOHQrbjPWplKK67i", true); --Password = 'password'
-- INSERT users VALUES("user3", "{bcrypt}$2a$14$tEnq90/CcR320dWQ.NdQLuj326PmgLzMGmFkUUOHQrbjPWplKK67i", true); --Password = 'password'
-- INSERT authorities VALUES("user", "ROLE_USER");
-- INSERT authorities VALUES("admin", "ROLE_USER");
-- INSERT authorities VALUES("admin", "ROLE_ADMIN");
-- INSERT authorities VALUES("user1", "ROLE_USER");
-- INSERT authorities VALUES("user2", "ROLE_USER");
-- INSERT authorities VALUES("user3", "ROLE_USER");