CREATE TABLE IF NOT EXISTS public.book (
	id serial,
	title varchar NOT NULL,
	release_date date,
	available boolean NOT NULL DEFAULT 't',
	topic public.topic NOT NULL DEFAULT 'OTHER',
    page integer,
	author_id integer NOT NULL,
	CONSTRAINT book_pk PRIMARY KEY (id),
	CONSTRAINT author_id_uq UNIQUE (author_id)
);

ALTER TABLE public.book OWNER TO prog_admin;

INSERT INTO book (title, release_date, topic, page, author_id) VALUES
('Nisekoi', '2014-01-01', 'ROMANCE', 60, 1),
('Konosuba', '2016-01-14', 'COMEDY', 74, 2),
('Re:Zero', '2012-01-01', 'OTHER', 69, 3);