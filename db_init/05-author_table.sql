CREATE TABLE IF NOT EXISTS public.author (
	id serial,
	user_id integer NOT NULL,
	reference varchar NOT NULL,
	CONSTRAINT author_pk PRIMARY KEY (id),
	CONSTRAINT user_id_uq UNIQUE (user_id),
	CONSTRAINT reference_uq_2 UNIQUE (reference)
);

ALTER TABLE public.author OWNER TO prog_admin;
