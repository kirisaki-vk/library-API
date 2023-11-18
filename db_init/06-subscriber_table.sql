CREATE TABLE IF NOT EXISTS public.subscriber (
	id uuid NOT NULL DEFAULT gen_random_uuid(),
	reference varchar NOT NULL,
	user_id uuid NOT NULL,
	CONSTRAINT subscriber_pk PRIMARY KEY (id),
	CONSTRAINT user_id_uq_1 UNIQUE (user_id),
	CONSTRAINT reference_uq_1 UNIQUE (reference)
);

ALTER TABLE public.subscriber OWNER TO prog_admin;