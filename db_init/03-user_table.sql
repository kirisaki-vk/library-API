CREATE TABLE IF NOT EXISTS public."user" (
	id uuid NOT NULL DEFAULT gen_random_uuid(),
	name varchar NOT NULL,
	sex public.sex NOT NULL,
	CONSTRAINT user_pk PRIMARY KEY (id)
);

ALTER TABLE public."user" OWNER TO prog_admin;