CREATE TABLE IF NOT EXISTS public."user" (
	id serial,
	name varchar NOT NULL,
	sex public.sex NOT NULL,
	CONSTRAINT user_pk PRIMARY KEY (id)
);

ALTER TABLE public."user" OWNER TO prog_admin;