
CREATE TYPE public.sex AS
ENUM ('MALE','FEMALE');
ALTER TYPE public.sex OWNER TO prog_admin;

CREATE TYPE public.topic AS
ENUM ('ROMANCE','COMEDY','OTHER');
ALTER TYPE public.topic OWNER TO prog_admin;

CREATE TYPE public.subscriber_action AS
ENUM ('BOOK_BORROW','BOOK_RENDER');
ALTER TYPE public.subscriber_action OWNER TO prog_admin;