# spring-boot-learning


-- Table: myapps.Employee

-- DROP TABLE IF EXISTS myapps."Employee";

CREATE TABLE IF NOT EXISTS myapps."Employee"
(
emp_id numeric NOT NULL,
emp_name character varying(30) COLLATE pg_catalog."default" NOT NULL,
emp_role character varying(30) COLLATE pg_catalog."default" NOT NULL,
CONSTRAINT "Employee_pkey" PRIMARY KEY (emp_id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS myapps."Employee"
OWNER to postgres;