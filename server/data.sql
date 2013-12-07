--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.1
-- Dumped by pg_dump version 9.3.1
-- Started on 2013-12-07 10:13:21

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 174 (class 3079 OID 11750)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 1955 (class 0 OID 0)
-- Dependencies: 174
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 170 (class 1259 OID 16430)
-- Name: barang_; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE barang_ (
    idbarang integer,
    namabarang text,
    harga integer,
    kategori text,
    jumlah integer,
    deskripsi text
);


ALTER TABLE public.barang_ OWNER TO postgres;

--
-- TOC entry 171 (class 1259 OID 16436)
-- Name: creditcard_; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE creditcard_ (
    number text,
    name text,
    expiredata text
);


ALTER TABLE public.creditcard_ OWNER TO postgres;

--
-- TOC entry 172 (class 1259 OID 16442)
-- Name: transactionlog_; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE transactionlog_ (
    namabarang text,
    harga integer,
    jumlah integer,
    username text,
    kategori text,
    detailpesanan text
);


ALTER TABLE public.transactionlog_ OWNER TO postgres;

--
-- TOC entry 173 (class 1259 OID 16448)
-- Name: user_; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE user_ (
    username text,
    password text,
    email text,
    namalengkap text,
    nohp text,
    provinsi text,
    kabupaten text,
    alamat text,
    kodepos text,
    nocredit text
);


ALTER TABLE public.user_ OWNER TO postgres;

--
-- TOC entry 1944 (class 0 OID 16430)
-- Dependencies: 170
-- Data for Name: barang_; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY barang_ (idbarang, namabarang, harga, kategori, jumlah, deskripsi) FROM stdin;
1	DagingSapi	80000	Daging	13	\N
3	ChickenNugget	30000	Frozen Food	15	\N
4	BayamItali	5000	Sayuran	14	\N
6	DagingYak	85000	Daging	12	\N
7	BerasTajMurah	100	Beras	0	\N
8	BerasHCSR04	22000	Beras	7	\N
9	BerasRaskin	20000	Beras	12	\N
10	DagingAyam	122000	Daging	2	\N
11	DagingDomba	92000	Daging	8	\N
12	PetaiCHINA	2500	Sayuran	6	\N
13	SeledriHongkong	4500	Sayuran	12	\N
14	TimunAustralia	14500	Sayuran	5	\N
15	SOZZZZZZIS	32000	Frozen Food	25	\N
16	FIESTANIGGA	22000	Frozen Food	15	\N
17	BAKSOSOGOOD	28000	Frozen Food	42	\N
18	Beras A-KING	200	Beras	22	\N
\N	BerasBaru	15000	Beras	2	\N
\N	BerasCarrefour	20000	Beras	5	\N
\N	BerasTajMahal	25000	Beras	3	\N
\N	IceCream	10000	Frozen Food	5	\N
\.


--
-- TOC entry 1945 (class 0 OID 16436)
-- Dependencies: 171
-- Data for Name: creditcard_; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY creditcard_ (number, name, expiredata) FROM stdin;
12341234	budi lagi	2014-04-07
12345678	ini budi	2014-04-07
\.


--
-- TOC entry 1946 (class 0 OID 16442)
-- Dependencies: 172
-- Data for Name: transactionlog_; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY transactionlog_ (namabarang, harga, jumlah, username, kategori, detailpesanan) FROM stdin;
DagingSapi	80000	3	budie	Daging	\N
DagingSapi	80000	2	budie	Daging	\N
IceCream	10000	3	budie	Snack	\N
IceCream	10000	4	budie	Snack	\N
ChickenNugget	30000	1	budie	Frozen Food	\N
ChickenNugget	30000	1	budie	Frozen Food	\N
BayamItali	5000	7	budie	Sayuran	\N
BerasCarrefour	12000	2	budie	Beras	\N
DagingYak	85000	7	budie	Daging	\N
DagingYak	85000	5	budie	Daging	\N
DagingYak	85000	5	budie	Daging	\N
BerasCarrefour	12000	3	budie	Beras	\N
BerasTajMahal	25000	5	budie	Beras	\N
DagingSapi	80000	2	budie	Daging	\N
DagingAyam	122000	3	budie	Daging	\N
BayamItali	5000	2	budie	Sayuran	\N
PetaiCHINA	2500	3	budie	Sayuran	\N
ChickenNugget	30000	2	budie	Frozen Food	\N
BerasCarrefour	12000	1	Boci	Beras	\N
BayamItali	5000	1	budie	Sayuran	\N
BerasTajMurah	100	1	buudi	Beras	\N
BerasTajMurah	100	1	buudi	Beras	\N
BerasTajMurah	100	1	buudi	Beras	\N
BerasTajMurah	100	2	buudi	Beras	\N
DagingSapi	80000	1	buudi	Daging	\N
DagingSapi	80000	1	buudi	Daging	\N
\.


--
-- TOC entry 1947 (class 0 OID 16448)
-- Dependencies: 173
-- Data for Name: user_; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY user_ (username, password, email, namalengkap, nohp, provinsi, kabupaten, alamat, kodepos, nocredit) FROM stdin;
aditya	12341234	adt@adit.com	adit ya	1234123048	aksjdfkansd	kansdknf	kjjdinfoa	2134123	12341234
admin	admin	\N	\N	\N	\N	\N	\N	\N	\N
budie	12345678	budie@gmail.com	budi budi	2134	Jawa Barat	Bandung	Bandung	4001	\N
budih	12341234	budie@budi.com	budi handoko	12345	lalala	lalala	lalala	4444	12341234
buudi	password	budi@budi.com	Budi Ini	08181818132	Jawa Barat	Bandung	Gataw	4444	NULL
cobabro	12341234	coba@bro.com	coba bro	081508150815	Jambi	Jambi	Jambi	3000	\N
cobadulu	12345678	coba@dulu.com	coba dulu	01234	SULAWESI	sulawesi	sulawesi	7000	12341234
cobalagi	12341234	cobalagi@lagi.com	coba dong	085708570857	Jambi	Jambi	Jambi	31365	\N
lalayeye	12345678	lala@yeye.com	lala yeye	981379134	asdfgs	asdgs	adfhgs	345	\N
testtest	12341234	test@test.com	test test	0102030405	jawa	jawa	jawa	1234	\N
username1	12345678	username@username.com	username satu	12344312	Jawa Barat	Jawa	Jawa	1000	\N
yanti	1234512345	yanti@yanti.com	yanti yanti	08080909	Kalimantan Barat	Jakarta	Jalan layang no 44	5000	12341234
yoibro	12345678	yoi@bro.com	yoi bro	0101010101	lalala	yeyeye	layelaye	000	\N
\.


--
-- TOC entry 1954 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2013-12-07 10:13:21

--
-- PostgreSQL database dump complete
--

