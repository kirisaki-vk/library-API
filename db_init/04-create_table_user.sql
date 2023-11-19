CREATE TABLE IF NOT EXISTS public."user" (
	id serial,
	name varchar NOT NULL,
	sex public.sex NOT NULL,
	CONSTRAINT user_pk PRIMARY KEY (id)
);

ALTER TABLE public."user" OWNER TO prog_admin;

INSERT INTO "user" (name, sex) VALUES
('Kirisaki_VK', 'MALE'),
('Chitoge Kirisaki', 'FEMALE'),
('Hana Kirisaki', 'FEMALE'),
('Kazuma Satou', 'MALE'),
('Kanade Tahibana', 'FEMALE'),
('Ram', 'FEMALE');