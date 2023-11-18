
CREATE TYPE public.sex AS
ENUM ('MALE','FEMALE');
ALTER TYPE public.sex OWNER TO prog_admin;

CREATE TYPE public.topic AS
ENUM ('ROMANCE','COMEDY','OTHER');
ALTER TYPE public.topic OWNER TO prog_admin;