-- DROP DATABASE IF EXISTS basic_db;

/* CREATE DATABASE IF NOT EXISTS basic_db
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'English_India.1252'
    LC_CTYPE = 'English_India.1252'
    LOCALE_PROVIDER = 'libc'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;
*/

-- DROP TABLE IF EXISTS public.employees;

/* CREATE TABLE IF NOT EXISTS public.employees
(
    emp_id bigint NOT NULL,
    email_id character varying(255) COLLATE pg_catalog."default" NOT NULL,
    first_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    last_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT employees_pkey PRIMARY KEY (emp_id),
    CONSTRAINT uk_qftatm5oorav2hj3mvoyrlh7o UNIQUE (email_id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.employees
    OWNER to postgres;

INSERT INTO public.employees(emp_id, email_id, first_name, last_name) VALUES (1, 'ramesh@gmail.com', 'ramesh', 'f');
INSERT INTO public.employees(emp_id, email_id, first_name, last_name) VALUES (2, 'manis@gmail.com', 'manis', 'p');

*/
