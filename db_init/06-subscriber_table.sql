CREATE TABLE IF NOT EXISTS public.subscriber (
	id serial,
	reference varchar NOT NULL,
	user_id integer NOT NULL,
	CONSTRAINT subscriber_pk PRIMARY KEY (id),
	CONSTRAINT user_id_uq_1 UNIQUE (user_id),
	CONSTRAINT reference_uq_1 UNIQUE (reference)
);

ALTER TABLE public.subscriber OWNER TO prog_admin;