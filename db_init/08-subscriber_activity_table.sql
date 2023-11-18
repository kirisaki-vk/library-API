CREATE TABLE IF NOT EXISTS public.subcriber_activity (
	id uuid NOT NULL DEFAULT gen_random_uuid(),
	"timestamp" timestamp NOT NULL DEFAULT current_timestamp,
	subscriber_id uuid NOT NULL,
	book_id uuid NOT NULL,
	action public.subscriber_action NOT NULL,
	CONSTRAINT subscriber_activity_pk PRIMARY KEY (id)
);

ALTER TABLE public.subcriber_activity OWNER TO prog_admin;