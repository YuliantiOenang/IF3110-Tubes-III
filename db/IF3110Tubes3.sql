--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: customer Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE SEQUENCE no_customer_seq;

CREATE TABLE customer (
	no_customer integer NOT NULL DEFAULT nextval('no_customer_seq'),
	nama character varying(35) NOT NULL,
	kota character varying(35) DEFAULT NULL,
	kodepos integer DEFAULT NULL,
	email character varying(35) NOT NULL,
	hp integer DEFAULT NULL,
	password character varying(15) NOT NULL,
	username character varying(12) NOT NULL,
	provinsi character varying(50) DEFAULT NULL,
	alamat character varying(100) DEFAULT NULL,
	card_number character varying(16) NOT NULL
);

ALTER TABLE public.customer OWNER TO postgres;

ALTER SEQUENCE no_customer_seq OWNED by customer.no_customer;
--
-- Name: kartu_kredit; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE kartu_kredit (
	card_number character varying(16) NOT NULL,
	card_name character varying(50) NOT NULL
);


ALTER TABLE public.kartu_kredit OWNER TO postgres;

--
-- Name: keranjang; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE keranjang (
	id_customer integer NOT NULL,
	id_alat integer NOT NULL,
	jumlah integer NOT NULL,
	pesan character varying(50) NOT NULL
);


ALTER TABLE public.keranjang OWNER TO postgres;

--
-- Name: peralatan; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE SEQUENCE no_alat_seq;

CREATE TABLE peralatan (	
	no_alat integer NOT NULL DEFAULT nextval('no_alat_seq'),
	nama character varying(25) DEFAULT NULL,
	kategori character varying(20) DEFAULT NULL,
	jumlah integer DEFAULT NULL,
	harga integer DEFAULT NULL,
	deskripsi character varying(100),
	foto character varying(50) DEFAULT NULL,
	status character varying(20) DEFAULT NULL
);

ALTER TABLE public.peralatan OWNER TO postgres;

ALTER SEQUENCE no_alat_seq OWNED by peralatan.no_alat;

--
-- Name: terbayar; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE terbayar (
	id_barang integer NOT NULL,
	jumlah integer NOT NULL,
	id_costumer integer NOT NULL,
	pesan character varying(50) NOT NULL
);


ALTER TABLE public.terbayar OWNER TO postgres;

--
-- Data for Name: benda_seni; Type: TABLE DATA; Schema: public; Owner: postgres
--

--
-- Data for Name: dipamerkan; Type: TABLE DATA; Schema: public; Owner: postgres
--


--
-- Data for Name: lukisan; Type: TABLE DATA; Schema: public; Owner: postgres
--


--
-- Data for Name: pagelaran; Type: TABLE DATA; Schema: public; Owner: postgres
--


--
-- Data for Name: pahatan; Type: TABLE DATA; Schema: public; Owner: postgres
--


--
-- Data for Name: seniman; Type: TABLE DATA; Schema: public; Owner: postgres
--

--
-- SET PRIMARY KEY
--

--
-- Name: customer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY customer
    ADD CONSTRAINT custome_pkey PRIMARY KEY (no_customer);

--
-- Name: peralatan_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY peralatan
    ADD CONSTRAINT peralatan_pkey PRIMARY KEY (no_alat);


--
-- Name: benda_seni_nama_seniman_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

--ALTER TABLE ONLY benda_seni
--    ADD CONSTRAINT benda_seni_nama_seniman_fkey FOREIGN KEY (nama_seniman) REFERENCES seniman(nama_seniman);


--
-- Name: dipamerkan_nama_benda_seni_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

--ALTER TABLE ONLY dipamerkan
--    ADD CONSTRAINT dipamerkan_nama_benda_seni_fkey FOREIGN KEY (nama_benda_seni) REFERENCES benda_seni(nama_benda_seni);


--
-- Name: dipamerkan_nama_pagelaran_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

--ALTER TABLE ONLY dipamerkan
--    ADD CONSTRAINT dipamerkan_nama_pagelaran_fkey FOREIGN KEY (nama_pagelaran) REFERENCES pagelaran(nama_pagelaran);


--
-- Name: lukisan_nama_benda_seni_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

--ALTER TABLE ONLY lukisan
--    ADD CONSTRAINT lukisan_nama_benda_seni_fkey FOREIGN KEY (nama_benda_seni) REFERENCES benda_seni(nama_benda_seni);


--
-- Name: pahatan_nama_benda_seni_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

--ALTER TABLE ONLY pahatan
--    ADD CONSTRAINT pahatan_nama_benda_seni_fkey FOREIGN KEY (nama_benda_seni) REFERENCES benda_seni(nama_benda_seni);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

