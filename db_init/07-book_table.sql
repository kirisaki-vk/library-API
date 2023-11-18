CREATE TABLE IF NOT EXISTS public.book (
	id uuid NOT NULL DEFAULT gen_random_uuid(),
	title varchar NOT NULL,
	release_date date,
	available boolean NOT NULL DEFAULT 't',
	topic public.topic NOT NULL DEFAULT 'OTHER',
    page integer,
	author_id uuid NOT NULL,
	CONSTRAINT book_pk PRIMARY KEY (id),
	CONSTRAINT author_id_uq UNIQUE (author_id)
);

ALTER TABLE public.book OWNER TO prog_admin;

