CREATE TABLE IF NOT EXISTS public.subcriber_activity (
	id serial,
	"timestamp" timestamp NOT NULL DEFAULT current_timestamp,
	subscriber_id integer NOT NULL,
	book_id integer NOT NULL,
	action public.subscriber_action NOT NULL,
	CONSTRAINT subscriber_activity_pk PRIMARY KEY (id)
);

ALTER TABLE public.subcriber_activity OWNER TO prog_admin;