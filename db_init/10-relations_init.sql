ALTER TABLE public.admin ADD CONSTRAINT user_id FOREIGN KEY (user_id)
REFERENCES public."user" (id) MATCH SIMPLE
ON DELETE CASCADE ON UPDATE NO ACTION;

ALTER TABLE public.author ADD CONSTRAINT user_id_fk FOREIGN KEY (user_id)
REFERENCES public."user" (id) MATCH SIMPLE
ON DELETE CASCADE ON UPDATE NO ACTION;

ALTER TABLE public.subscriber ADD CONSTRAINT user_id_fk FOREIGN KEY (user_id)
REFERENCES public."user" (id) MATCH SIMPLE
ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE public.book ADD CONSTRAINT author_id_fk FOREIGN KEY (author_id)
REFERENCES public.author (id) MATCH SIMPLE
ON DELETE CASCADE ON UPDATE NO ACTION;

ALTER TABLE public.subcriber_activity ADD CONSTRAINT subscriber_id_fk FOREIGN KEY (subscriber_id)
REFERENCES public.subscriber (id) MATCH SIMPLE
ON DELETE CASCADE ON UPDATE NO ACTION;

ALTER TABLE public.subcriber_activity ADD CONSTRAINT book_id_fk FOREIGN KEY (book_id)
REFERENCES public.book (id) MATCH SIMPLE
ON DELETE CASCADE ON UPDATE NO ACTION;