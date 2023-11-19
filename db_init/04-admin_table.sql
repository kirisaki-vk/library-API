CREATE TABLE IF NOT EXISTS public.admin (
	id serial,
	reference varchar NOT NULL,
	user_id integer NOT NULL,
	CONSTRAINT admin_pk PRIMARY KEY (id),
	CONSTRAINT unique_user_id UNIQUE (user_id),
	CONSTRAINT reference_uq UNIQUE (reference)
);

ALTER TABLE public.admin OWNER TO prog_admin;
