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
-- Name: benda_seni; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE benda_seni (
    nama_benda_seni character varying(50) NOT NULL,
    tahun_pembuatan integer,
    deskripsi character varying(200),
    nama_seniman character varying(50)
);


ALTER TABLE public.benda_seni OWNER TO postgres;

--
-- Name: dipamerkan; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE dipamerkan (
    nama_pagelaran character varying(50),
    nama_benda_seni character varying(50)
);


ALTER TABLE public.dipamerkan OWNER TO postgres;

--
-- Name: lukisan; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE lukisan (
    nama_benda_seni character varying(50),
    kategori character varying(30)
);


ALTER TABLE public.lukisan OWNER TO postgres;

--
-- Name: pagelaran; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE pagelaran (
    nama_pagelaran character varying(50) NOT NULL,
    bulan character varying(10)
);


ALTER TABLE public.pagelaran OWNER TO postgres;

--
-- Name: pahatan; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE pahatan (
    nama_benda_seni character varying(50),
    bahan_dasar character varying(30),
    panjang integer,
    lebar integer,
    tinggi integer
);


ALTER TABLE public.pahatan OWNER TO postgres;

--
-- Name: seniman; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE seniman (
    nama_seniman character varying(50) NOT NULL,
    negara_asal character varying(50)
);


ALTER TABLE public.seniman OWNER TO postgres;

--
-- Data for Name: benda_seni; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY benda_seni (nama_benda_seni, tahun_pembuatan, deskripsi, nama_seniman) FROM stdin;
Produk 599	2011	Karya seni bernomor 1862037	ERLENE
Karya 705	2007	Karya seni bernomor 1728655	ERLENE
Masterpiece 288	2001	Benda seni ini memiliki nomor 3737028	MAKEDA
Produk 310	2012	Karya seni bernomor 8006934	MAKEDA
Produk 174	2011	Karya seni bernomor 4614941	LAURENCE
Produk 759	2006	Karya seni bernomor 4561163	COURTNEY
Karya 664	2011	Karya seni bernomor 3984917	OLIN
Masterpiece 102	2003	Karya seni bernomor 1281925	SUSAN
Masterpiece 674	2009	Karya seni bernomor 7399405	SUSAN
Masterpiece 648	2011	Karya seni bernomor 8160968	CHRISTIE
Karya 796	2012	Benda seni ini memiliki nomor 3059919	PAT
Produk 298	2010	Benda seni ini memiliki nomor 9688404	PAT
Karya 501	2012	Benda seni ini memiliki nomor 2720533	DEJA
Produk 896	2006	Benda seni ini memiliki nomor 9344145	DEJA
Karya 639	2010	Benda seni ini memiliki nomor 7872075	DEJA
Masterpiece 399	2003	Benda seni ini memiliki nomor 5985060	JONIE
Masterpiece 205	2004	Karya seni bernomor 1839457	JONIE
Karya 666	2008	Benda seni ini memiliki nomor 8742383	BRADLY
Karya 774	2008	Karya seni bernomor 3645154	BRADLY
Karya 506	2005	Karya seni bernomor 9593087	BRADLY
Produk 651	2012	Benda seni ini memiliki nomor 7421910	KYLEE
Produk 796	2011	Benda seni ini memiliki nomor 0221491	KYLEE
Masterpiece 828	2012	Karya seni bernomor 5050965	TAWNY
Masterpiece 656	2001	Karya seni bernomor 2009773	TAWNY
Masterpiece 263	2010	Benda seni ini memiliki nomor 3994726	TAWNY
Karya 702	2005	Benda seni ini memiliki nomor 6454912	ANTIONETTE
Karya 144	2008	Karya seni bernomor 5744589	ANTIONETTE
Produk 618	2013	Karya seni bernomor 1967379	ANTIONETTE
Karya 947	2002	Karya seni bernomor 7563450	KELSIE
Masterpiece 760	2003	Benda seni ini memiliki nomor 3628323	KELSIE
Karya 051	2003	Karya seni bernomor 5520432	KELSIE
Karya 920	2008	Benda seni ini memiliki nomor 0730438	VANESSA
Produk 419	2006	Karya seni bernomor 5810618	VANESSA
Produk 729	2012	Benda seni ini memiliki nomor 0906479	FARAH
Produk 829	2007	Karya seni bernomor 3917660	YASMINE
Karya 112	2009	Benda seni ini memiliki nomor 2583474	TEODORA
Produk 388	2002	Karya seni bernomor 8384151	TISHA
Karya 759	2006	Benda seni ini memiliki nomor 7679284	TISHA
Karya 311	2010	Benda seni ini memiliki nomor 0492647	ZETTA
Masterpiece 424	2003	Benda seni ini memiliki nomor 9420144	MAMIE
Karya 853	2011	Karya seni bernomor 6778256	MAMIE
Karya 957	2003	Karya seni bernomor 2333400	MAMIE
Masterpiece 290	2009	Benda seni ini memiliki nomor 5000185	AMADO
Produk 401	2003	Karya seni bernomor 1648637	DERRICK
Produk 301	2003	Karya seni bernomor 7450009	DERRICK
Produk 699	2000	Benda seni ini memiliki nomor 7114540	ELDRIDGE
Masterpiece 816	2010	Benda seni ini memiliki nomor 6339631	ELDRIDGE
Karya 799	2010	Karya seni bernomor 8828324	ELDRIDGE
Produk 726	2001	Karya seni bernomor 0470273	HEIDY
Produk 144	2004	Karya seni bernomor 8399247	GWENDOLYN
Produk 761	2011	Benda seni ini memiliki nomor 2390198	LAINE
Karya 307	2006	Karya seni bernomor 6852947	LAINE
Produk 945	2007	Karya seni bernomor 0635509	ARNETTA
Produk 587	2005	Karya seni bernomor 6373013	ARNETTA
Masterpiece 853	2006	Benda seni ini memiliki nomor 4673135	SHERIKA
Karya 035	2011	Karya seni bernomor 1641078	SHERIKA
Produk 755	2013	Karya seni bernomor 4511508	SHERIKA
Produk 594	2000	Karya seni bernomor 6642574	PENNEY
Masterpiece 256	2004	Benda seni ini memiliki nomor 6170154	PENNEY
Karya 836	2004	Karya seni bernomor 7029524	PENNEY
Produk 681	2011	Benda seni ini memiliki nomor 9160193	DANIA
Karya 170	2006	Benda seni ini memiliki nomor 9090716	DANIA
Masterpiece 076	2001	Benda seni ini memiliki nomor 9868970	BRITTNEY
Masterpiece 580	2008	Karya seni bernomor 8768428	BRITTNEY
Masterpiece 953	2013	Karya seni bernomor 4368943	BRITTNEY
Karya 219	2004	Benda seni ini memiliki nomor 9354817	LANDON
Masterpiece 296	2002	Benda seni ini memiliki nomor 5153864	LANDON
Produk 994	2009	Karya seni bernomor 0195798	JACQUELYN
Masterpiece 770	2006	Karya seni bernomor 8823276	ANITA
Produk 070	2007	Benda seni ini memiliki nomor 5205761	ANITA
Karya 560	2010	Benda seni ini memiliki nomor 8935456	ANITA
Produk 303	2008	Karya seni bernomor 9506277	HARLAND
Masterpiece 092	2012	Karya seni bernomor 0257472	HARLAND
Masterpiece 280	2001	Benda seni ini memiliki nomor 6283845	DEMETRIA
Karya 165	2009	Benda seni ini memiliki nomor 4602105	MARGERY
Masterpiece 316	2006	Benda seni ini memiliki nomor 1266273	MARGERY
Masterpiece 065	2012	Karya seni bernomor 8029845	MARGERY
Masterpiece 660	2006	Benda seni ini memiliki nomor 8052726	GINNY
Produk 060	2004	Benda seni ini memiliki nomor 6473061	GINNY
Karya 611	2007	Benda seni ini memiliki nomor 6339871	GINNY
Karya 656	2003	Karya seni bernomor 8361867	JOYA
Karya 092	2006	Benda seni ini memiliki nomor 8279490	JOYA
Produk 738	2009	Benda seni ini memiliki nomor 4349437	JOYA
Karya 205	2005	Karya seni bernomor 7749792	GOLDA
Produk 532	2004	Benda seni ini memiliki nomor 2898594	JENETTE
Karya 735	2005	Benda seni ini memiliki nomor 7583777	JENETTE
Produk 199	2003	Benda seni ini memiliki nomor 3660143	JENETTE
Karya 857	2013	Karya seni bernomor 8329653	KAYLEEN
Produk 485	2005	Benda seni ini memiliki nomor 9550925	KAYLEEN
Karya 464	2006	Benda seni ini memiliki nomor 0654137	RICH
Masterpiece 649	2001	Karya seni bernomor 9150033	JUDIE
Masterpiece 136	2011	Benda seni ini memiliki nomor 4506634	JUDIE
Produk 085	2006	Karya seni bernomor 7886453	RUSSEL
Produk 128	2002	Karya seni bernomor 7811803	LETITIA
Karya 604	2008	Benda seni ini memiliki nomor 5308791	LETITIA
Masterpiece 654	2010	Karya seni bernomor 4168413	LETITIA
Produk 513	2007	Benda seni ini memiliki nomor 7551960	MAURO
Karya 854	2012	Karya seni bernomor 0728263	MAURO
Karya 039	2000	Karya seni bernomor 7489945	DEEANN
Produk 276	2010	Benda seni ini memiliki nomor 6511579	DEEANN
Karya 445	2010	Karya seni bernomor 2798400	TORA
Masterpiece 078	2010	Benda seni ini memiliki nomor 7676908	GEMMA
Produk 083	2011	Benda seni ini memiliki nomor 3927253	GEMMA
Produk 997	2005	Benda seni ini memiliki nomor 2205250	GEMMA
Karya 703	2004	Karya seni bernomor 5268084	CHASIDY
Produk 443	2002	Benda seni ini memiliki nomor 3021202	CHASIDY
Karya 321	2011	Karya seni bernomor 4030688	CHASIDY
Produk 409	2013	Karya seni bernomor 7295773	CARLEE
Karya 381	2003	Benda seni ini memiliki nomor 6485483	CARLEE
Karya 694	2004	Karya seni bernomor 6625356	CARLEE
Produk 953	2001	Karya seni bernomor 0746793	GEORGIANNA
Karya 106	2004	Benda seni ini memiliki nomor 1558427	GEORGIANNA
Karya 279	2003	Benda seni ini memiliki nomor 9039586	GEORGIANNA
Produk 498	2010	Benda seni ini memiliki nomor 5058628	RICKEY
Karya 943	2000	Benda seni ini memiliki nomor 7818111	RICKEY
Karya 793	2008	Benda seni ini memiliki nomor 4559910	CEDRICK
Karya 895	2003	Karya seni bernomor 7498545	MYRIAM
Karya 119	2010	Benda seni ini memiliki nomor 1694122	MYRIAM
Produk 467	2009	Karya seni bernomor 5694837	MYRIAM
Produk 474	2008	Benda seni ini memiliki nomor 6078492	NOELIA
Masterpiece 824	2004	Benda seni ini memiliki nomor 7868255	NOELIA
Karya 206	2005	Karya seni bernomor 1768143	NOELIA
Produk 510	2006	Karya seni bernomor 8968528	MARYELLEN
Masterpiece 455	2006	Karya seni bernomor 4819375	MARYELLEN
Karya 407	2003	Benda seni ini memiliki nomor 7192046	LOURA
Masterpiece 016	2006	Karya seni bernomor 2291252	LOURA
Masterpiece 802	2011	Karya seni bernomor 8932036	LOURA
Karya 080	2005	Benda seni ini memiliki nomor 3953102	MI
Produk 926	2001	Benda seni ini memiliki nomor 5783228	MI
Karya 915	2007	Benda seni ini memiliki nomor 5118496	LUCRETIA
Produk 087	2007	Karya seni bernomor 4445759	LUCRETIA
Karya 309	2001	Karya seni bernomor 8699118	MATHILDE
Produk 356	2002	Benda seni ini memiliki nomor 1953204	MATHILDE
Karya 474	2008	Karya seni bernomor 2937468	MATHILDE
Karya 547	2005	Benda seni ini memiliki nomor 1296616	GENARO
Masterpiece 089	2012	Benda seni ini memiliki nomor 6025299	GENARO
Masterpiece 764	2010	Karya seni bernomor 2001796	GENARO
Karya 502	2005	Karya seni bernomor 5224720	DELICIA
Produk 379	2007	Karya seni bernomor 4077312	CHANEL
Masterpiece 218	2007	Benda seni ini memiliki nomor 6039211	CHANEL
Karya 809	2001	Benda seni ini memiliki nomor 6886831	YUONNE
Masterpiece 327	2009	Benda seni ini memiliki nomor 3080090	YUONNE
Masterpiece 177	2009	Karya seni bernomor 0459765	YUONNE
Produk 545	2003	Benda seni ini memiliki nomor 0283456	LEIA
Karya 818	2013	Benda seni ini memiliki nomor 2153665	LAREE
Karya 304	2006	Karya seni bernomor 6353201	ROSANNA
Masterpiece 161	2000	Benda seni ini memiliki nomor 6748528	ROSANNA
Produk 108	2009	Benda seni ini memiliki nomor 1986791	ROSANNA
Masterpiece 581	2007	Benda seni ini memiliki nomor 5849567	THEO
Masterpiece 690	2001	Benda seni ini memiliki nomor 1655904	THEO
Masterpiece 174	2010	Benda seni ini memiliki nomor 5341445	CALLIE
Masterpiece 607	2001	Benda seni ini memiliki nomor 5397526	TYREE
Karya 199	2007	Karya seni bernomor 7825255	ALDO
Masterpiece 473	2013	Karya seni bernomor 8847465	ALDO
Produk 574	2005	Benda seni ini memiliki nomor 6134616	ALDO
Produk 563	2007	Karya seni bernomor 9870796	WARREN
Masterpiece 206	2002	Benda seni ini memiliki nomor 2176202	WARREN
Produk 424	2012	Karya seni bernomor 5470694	MILISSA
Produk 129	2004	Karya seni bernomor 9697606	RUSSELL
Karya 894	2003	Karya seni bernomor 3999462	RUSSELL
Produk 165	2011	Benda seni ini memiliki nomor 6344203	RUSSELL
Karya 592	2009	Benda seni ini memiliki nomor 2667765	FLOR
Karya 271	2009	Benda seni ini memiliki nomor 7532187	FLOR
Karya 698	2005	Benda seni ini memiliki nomor 3190646	YER
Produk 073	2005	Benda seni ini memiliki nomor 0495834	YER
Produk 745	2007	Benda seni ini memiliki nomor 7206034	YER
Karya 203	2013	Karya seni bernomor 0394309	KIRA
Karya 970	2007	Karya seni bernomor 5395329	KIRA
Produk 255	2004	Benda seni ini memiliki nomor 5432862	MARIO
Karya 058	2002	Karya seni bernomor 2730798	MARIO
Masterpiece 306	2013	Benda seni ini memiliki nomor 4590223	MARIO
Produk 396	2001	Karya seni bernomor 6705556	MAGNOLIA
Masterpiece 549	2002	Benda seni ini memiliki nomor 0615792	MAGNOLIA
Karya 640	2005	Karya seni bernomor 3053195	MAGNOLIA
Masterpiece 020	2012	Benda seni ini memiliki nomor 9486320	WINONA
Produk 320	2012	Benda seni ini memiliki nomor 4608621	WINONA
Masterpiece 462	2007	Benda seni ini memiliki nomor 8654228	WINONA
Masterpiece 794	2008	Karya seni bernomor 7000114	HERMINE
Masterpiece 232	2006	Karya seni bernomor 3034525	HERMINE
Karya 789	2013	Karya seni bernomor 9968930	HERMINE
Produk 494	2005	Benda seni ini memiliki nomor 7734080	SONYA
Karya 830	2010	Benda seni ini memiliki nomor 7720358	PERCY
Karya 175	2009	Karya seni bernomor 5124610	MA
Masterpiece 346	2011	Benda seni ini memiliki nomor 1416110	CHANTAL
Produk 870	2002	Benda seni ini memiliki nomor 0685977	CHANTAL
Produk 853	2007	Benda seni ini memiliki nomor 0173063	FELISHA
Karya 961	2003	Benda seni ini memiliki nomor 2392509	FELISHA
Karya 902	2013	Benda seni ini memiliki nomor 2240624	LUCIANA
Produk 922	2008	Benda seni ini memiliki nomor 3074319	VON
Karya 883	2001	Benda seni ini memiliki nomor 3597945	TESSA
Masterpiece 169	2010	Benda seni ini memiliki nomor 8482781	TESSA
Produk 047	2003	Benda seni ini memiliki nomor 8477058	DEBBIE
Karya 658	2012	Karya seni bernomor 3540386	MARGE
Karya 508	2013	Benda seni ini memiliki nomor 2743103	MARGE
Masterpiece 745	2000	Karya seni bernomor 4260783	EUN
Produk 267	2004	Karya seni bernomor 0820183	EUN
Masterpiece 812	2006	Karya seni bernomor 1859577	EUN
Karya 867	2001	Karya seni bernomor 9617541	TORI
Masterpiece 912	2007	Benda seni ini memiliki nomor 4155956	TORI
Karya 648	2011	Karya seni bernomor 7525199	MARTIN
Karya 348	2008	Benda seni ini memiliki nomor 6509636	MARTIN
Masterpiece 702	2000	Karya seni bernomor 7453810	MARTIN
Karya 026	2003	Karya seni bernomor 2201549	SUSAN
Karya 968	2003	Karya seni bernomor 6469069	SUSAN
Masterpiece 518	2006	Karya seni bernomor 2127020	SUSAN
Masterpiece 651	2012	Karya seni bernomor 1773135	CRISTI
Produk 924	2009	Benda seni ini memiliki nomor 7861417	CRISTI
Masterpiece 831	2005	Karya seni bernomor 0748017	NELDA
Karya 181	2010	Karya seni bernomor 7840855	NELDA
Produk 622	2001	Benda seni ini memiliki nomor 3080013	NELDA
Produk 955	2007	Benda seni ini memiliki nomor 9317224	ROYCE
Produk 760	2011	Karya seni bernomor 3311510	JC
Karya 973	2006	Benda seni ini memiliki nomor 3230560	JC
Karya 553	2002	Benda seni ini memiliki nomor 8686281	JC
Produk 163	2005	Karya seni bernomor 0572318	WALLY
Masterpiece 819	2007	Karya seni bernomor 8432593	ANISHA
Karya 029	2009	Benda seni ini memiliki nomor 0656808	ANISHA
Karya 453	2009	Karya seni bernomor 8356820	FARAH
Masterpiece 546	2002	Benda seni ini memiliki nomor 6054307	PALMIRA
Karya 250	2008	Karya seni bernomor 3071624	PALMIRA
Karya 979	2002	Karya seni bernomor 7984781	PALMIRA
Masterpiece 002	2006	Benda seni ini memiliki nomor 1895583	CODI
Karya 108	2002	Karya seni bernomor 3179303	TEODORA
Karya 599	2001	Karya seni bernomor 7385165	PEGGY
Karya 861	2009	Karya seni bernomor 7773207	PEGGY
Masterpiece 677	2009	Benda seni ini memiliki nomor 3496657	ZETTA
Produk 650	2010	Karya seni bernomor 6985921	NICOLE
Karya 617	2002	Benda seni ini memiliki nomor 6783758	DERRICK
Karya 126	2005	Karya seni bernomor 8537917	DERRICK
Produk 405	2007	Benda seni ini memiliki nomor 6581833	DERRICK
Produk 584	2003	Benda seni ini memiliki nomor 2927501	KIRBY
Karya 329	2000	Karya seni bernomor 7503708	KIRBY
Produk 996	2008	Karya seni bernomor 3856717	KIRBY
Produk 037	2008	Karya seni bernomor 2302133	DORCAS
Masterpiece 308	2001	Karya seni bernomor 0890894	DORCAS
Produk 190	2007	Benda seni ini memiliki nomor 7707121	HUGO
Masterpiece 933	2001	Benda seni ini memiliki nomor 2703204	HUGO
Produk 104	2002	Karya seni bernomor 1202998	HUGO
Produk 121	2000	Benda seni ini memiliki nomor 7915673	LINH
Karya 215	2003	Karya seni bernomor 5700842	LINH
Produk 196	2004	Benda seni ini memiliki nomor 8689547	LINH
Produk 801	2002	Karya seni bernomor 8481033	PARIS
Produk 421	2003	Karya seni bernomor 4882104	PARIS
Karya 384	2003	Benda seni ini memiliki nomor 1967977	PARIS
Produk 507	2011	Benda seni ini memiliki nomor 4959281	MARYALICE
Masterpiece 283	2008	Benda seni ini memiliki nomor 3634122	MELODI
Karya 417	2005	Karya seni bernomor 1098348	BRITTNEY
Produk 112	2005	Benda seni ini memiliki nomor 1549111	BRITTNEY
Produk 446	2002	Benda seni ini memiliki nomor 6147210	BRITTNEY
Karya 541	2001	Karya seni bernomor 2832666	ISAAC
Karya 019	2013	Karya seni bernomor 0213955	ISAAC
Masterpiece 970	2000	Karya seni bernomor 2535890	ANITA
Masterpiece 154	2012	Karya seni bernomor 6110693	RYANN
Karya 481	2013	Benda seni ini memiliki nomor 1128036	PAMULA
Karya 691	2011	Benda seni ini memiliki nomor 9951476	BETTYANN
Masterpiece 713	2013	Benda seni ini memiliki nomor 9521398	BETTYANN
Produk 193	2005	Benda seni ini memiliki nomor 2817828	ROBIN
Produk 845	2005	Karya seni bernomor 1389824	MAUD
Masterpiece 360	2007	Benda seni ini memiliki nomor 6962664	MAUD
Masterpiece 373	2012	Benda seni ini memiliki nomor 3175545	MARLENE
Produk 657	2000	Benda seni ini memiliki nomor 0844107	MARLENE
Karya 946	2013	Benda seni ini memiliki nomor 9347602	BETTYE
Masterpiece 629	2011	Karya seni bernomor 3775029	RAYMON
Masterpiece 554	2004	Karya seni bernomor 1795282	RAYMON
Karya 588	2013	Benda seni ini memiliki nomor 4538258	KRISTAL
Karya 847	2008	Benda seni ini memiliki nomor 3192800	KARON
Produk 670	2012	Karya seni bernomor 4407436	KARON
Karya 354	2002	Benda seni ini memiliki nomor 6165696	MALLORY
Karya 003	2006	Karya seni bernomor 6227044	MALLORY
Masterpiece 992	2013	Karya seni bernomor 2562409	MALLORY
Karya 368	2008	Karya seni bernomor 7445391	RYAN
Produk 678	2005	Benda seni ini memiliki nomor 7709181	RYAN
Karya 693	2007	Karya seni bernomor 1839835	SAMELLA
Karya 353	2007	Karya seni bernomor 4499798	SAMELLA
Masterpiece 238	2008	Benda seni ini memiliki nomor 2310025	SAMELLA
Karya 563	2006	Benda seni ini memiliki nomor 6785722	ISABELL
Produk 544	2002	Benda seni ini memiliki nomor 7876854	PHYLICIA
Produk 011	2004	Benda seni ini memiliki nomor 3875407	PHYLICIA
Karya 002	2011	Benda seni ini memiliki nomor 7101133	DEVORA
Masterpiece 886	2004	Karya seni bernomor 4688110	ELINOR
Produk 042	2006	Karya seni bernomor 0690812	ELINOR
Karya 139	2005	Benda seni ini memiliki nomor 6228062	CARLI
Masterpiece 071	2012	Karya seni bernomor 0364518	CARLI
Masterpiece 272	2004	Karya seni bernomor 8129902	CARLI
Produk 570	2009	Benda seni ini memiliki nomor 2435644	LAURIE
Masterpiece 090	2012	Benda seni ini memiliki nomor 3468395	LAURIE
Produk 224	2013	Benda seni ini memiliki nomor 0241610	MARIN
Produk 102	2000	Karya seni bernomor 6738103	MARIN
Karya 028	2010	Karya seni bernomor 2625237	MARIN
Masterpiece 848	2009	Karya seni bernomor 7989307	REANNA
Karya 138	2003	Karya seni bernomor 9750247	REANNA
Karya 057	2011	Benda seni ini memiliki nomor 7043052	REANNA
Masterpiece 700	2000	Karya seni bernomor 7531684	GENNIE
Masterpiece 632	2012	Karya seni bernomor 8205776	GENNIE
Produk 937	2012	Benda seni ini memiliki nomor 8397603	GENNIE
Produk 526	2009	Benda seni ini memiliki nomor 9770717	LUANNA
Karya 122	2008	Benda seni ini memiliki nomor 6026061	LUANNA
Masterpiece 870	2008	Karya seni bernomor 0016675	LUANNA
Produk 338	2000	Benda seni ini memiliki nomor 0690524	ELOY
Karya 967	2013	Karya seni bernomor 1970574	ELOY
Masterpiece 274	2010	Karya seni bernomor 3604196	ELOY
Masterpiece 837	2008	Benda seni ini memiliki nomor 2744185	WALDO
Masterpiece 847	2006	Benda seni ini memiliki nomor 7020884	WALDO
Produk 832	2004	Benda seni ini memiliki nomor 8131072	WALDO
Produk 050	2009	Karya seni bernomor 4220057	ANDREA
Karya 732	2006	Benda seni ini memiliki nomor 9906062	DARCI
Masterpiece 658	2000	Karya seni bernomor 9185983	DARCI
Karya 318	2010	Karya seni bernomor 2904301	DARCI
Produk 771	2012	Benda seni ini memiliki nomor 2552197	LUCRETIA
Karya 189	2012	Benda seni ini memiliki nomor 3114568	CHANDA
Masterpiece 250	2006	Benda seni ini memiliki nomor 4320720	JULIENNE
Karya 933	2010	Karya seni bernomor 1657223	JULIENNE
Karya 077	2006	Karya seni bernomor 7918252	DAVE
Produk 960	2002	Karya seni bernomor 0041194	DAVE
Masterpiece 370	2007	Karya seni bernomor 8996318	DAVE
Produk 483	2009	Karya seni bernomor 1962706	SEAN
Karya 404	2013	Benda seni ini memiliki nomor 9371385	LIN
Produk 762	2001	Benda seni ini memiliki nomor 3680813	TAKAKO
Produk 278	2010	Benda seni ini memiliki nomor 3081201	MERRI
Karya 676	2013	Benda seni ini memiliki nomor 5752880	LEONIDA
Karya 662	2013	Benda seni ini memiliki nomor 2772579	LEONIDA
Karya 704	2011	Karya seni bernomor 3175926	CONSTANCE
Produk 644	2008	Karya seni bernomor 2857730	CONSTANCE
Karya 049	2006	Benda seni ini memiliki nomor 6460579	MILISSA
Karya 950	2013	Karya seni bernomor 2598397	MILISSA
Masterpiece 006	2000	Benda seni ini memiliki nomor 1876225	PHILOMENA
Karya 455	2009	Karya seni bernomor 1289422	SUANNE
Produk 555	2009	Karya seni bernomor 5776667	SUANNE
Karya 462	2009	Benda seni ini memiliki nomor 0812066	NORMAND
Masterpiece 890	2010	Karya seni bernomor 7465575	NORMAND
Masterpiece 516	2006	Karya seni bernomor 3003354	NORMAND
Produk 192	2002	Benda seni ini memiliki nomor 0867754	KIRA
Karya 476	2003	Karya seni bernomor 5073472	KIRA
Karya 688	2000	Karya seni bernomor 8580431	KIRA
Karya 242	2008	Benda seni ini memiliki nomor 7516611	MARIO
Masterpiece 060	2002	Benda seni ini memiliki nomor 9315902	MARIO
Masterpiece 971	2007	Karya seni bernomor 1822946	TOD
Karya 088	2011	Benda seni ini memiliki nomor 3438649	TOD
Produk 454	2004	Karya seni bernomor 2232027	MONNIE
Produk 107	2002	Benda seni ini memiliki nomor 0458909	MONNIE
Karya 270	2000	Benda seni ini memiliki nomor 3607711	MONNIE
Karya 004	2008	Benda seni ini memiliki nomor 1593563	KENNA
Karya 874	2010	Karya seni bernomor 7911619	KENNA
Masterpiece 402	2012	Karya seni bernomor 8471531	TOMIKO
Masterpiece 033	2011	Karya seni bernomor 6959096	TOMIKO
Produk 358	2005	Karya seni bernomor 9068527	TOMIKO
Karya 660	2001	Benda seni ini memiliki nomor 4419618	BERNARD
Produk 075	2012	Benda seni ini memiliki nomor 2947435	BERNARD
Produk 589	2009	Karya seni bernomor 3514547	BERNARD
Produk 171	2002	Benda seni ini memiliki nomor 9112287	SHAMIKA
Produk 786	2007	Karya seni bernomor 7028231	SHAMIKA
Masterpiece 903	2013	Karya seni bernomor 7095128	SHAMIKA
Produk 691	2009	Karya seni bernomor 0585097	SALLIE
Produk 521	2008	Benda seni ini memiliki nomor 5150157	SALLIE
Karya 649	2011	Benda seni ini memiliki nomor 6607854	SALLIE
Produk 514	2008	Karya seni bernomor 6386516	SHANICE
Masterpiece 007	2009	Karya seni bernomor 4623529	JENNINE
Karya 243	2013	Benda seni ini memiliki nomor 7123151	JENNINE
Karya 471	2007	Benda seni ini memiliki nomor 6982389	DOMINGA
Karya 024	2003	Karya seni bernomor 7790755	WANITA
Karya 884	2009	Karya seni bernomor 6833412	TESSA
Karya 173	2010	Benda seni ini memiliki nomor 4342681	TESSA
Produk 752	2001	Benda seni ini memiliki nomor 9996849	MARGE
Produk 005	2009	Benda seni ini memiliki nomor 1278014	CLYDE
Masterpiece 347	2004	Benda seni ini memiliki nomor 3513280	NATASHA
Produk 363	2000	Benda seni ini memiliki nomor 4794700	NATASHA
Karya 888	2002	Karya seni bernomor 5601516	NATASHA
Karya 076	2004	Karya seni bernomor 7594220	TAMICA
Karya 386	2000	Karya seni bernomor 8045375	MAXIMO
Masterpiece 443	2009	Benda seni ini memiliki nomor 3108229	MAXIMO
Karya 868	2000	Karya seni bernomor 1589591	CORALEE
Masterpiece 896	2009	Karya seni bernomor 2151500	HYUN
Produk 787	2009	Karya seni bernomor 5124111	HYUN
Produk 306	2011	Benda seni ini memiliki nomor 4226417	THERSA
Karya 612	2008	Karya seni bernomor 6276232	THERSA
Karya 633	2005	Karya seni bernomor 4627830	CRISTY
Masterpiece 393	2005	Karya seni bernomor 8064827	CRISTY
Masterpiece 388	2002	Benda seni ini memiliki nomor 3065845	CRISTY
Masterpiece 420	2004	Karya seni bernomor 4014547	ANNAMARIA
Karya 244	2002	Karya seni bernomor 8127034	ANNAMARIA
Masterpiece 821	2012	Karya seni bernomor 6888257	DONN
Masterpiece 381	2004	Benda seni ini memiliki nomor 7642748	DONN
Produk 225	2005	Karya seni bernomor 7724533	DONN
Karya 647	2007	Karya seni bernomor 9780702	MARGRET
Masterpiece 609	2011	Benda seni ini memiliki nomor 9016886	TISHA
Produk 857	2011	Benda seni ini memiliki nomor 0828991	REMONA
Karya 740	2006	Benda seni ini memiliki nomor 9918152	REMONA
Karya 450	2012	Karya seni bernomor 5817140	ZETTA
Produk 808	2009	Karya seni bernomor 2109687	AGUSTIN
Karya 142	2008	Benda seni ini memiliki nomor 6862045	AGUSTIN
Produk 854	2000	Benda seni ini memiliki nomor 4359998	DERRICK
Masterpiece 365	2003	Karya seni bernomor 7503807	DERRICK
Produk 673	2005	Benda seni ini memiliki nomor 9917504	DERRICK
Karya 082	2003	Benda seni ini memiliki nomor 7179341	ELDRIDGE
Masterpiece 149	2008	Benda seni ini memiliki nomor 4885356	ELDRIDGE
Karya 134	2011	Karya seni bernomor 2861017	ELDRIDGE
Karya 989	2005	Benda seni ini memiliki nomor 4491591	DARA
Masterpiece 379	2010	Benda seni ini memiliki nomor 3634992	TATUM
Masterpiece 784	2008	Karya seni bernomor 2206435	HUGO
Masterpiece 324	2008	Benda seni ini memiliki nomor 3854256	HUGO
Karya 162	2000	Benda seni ini memiliki nomor 4869438	LINH
Masterpiece 344	2012	Benda seni ini memiliki nomor 2749407	LINH
Masterpiece 913	2000	Karya seni bernomor 6910081	LINH
Masterpiece 978	2006	Karya seni bernomor 2100366	PARIS
Masterpiece 662	2011	Karya seni bernomor 1286420	PARIS
Karya 890	2012	Benda seni ini memiliki nomor 1494883	GARY
Karya 336	2005	Benda seni ini memiliki nomor 7495506	GARY
Karya 795	2005	Benda seni ini memiliki nomor 3186877	ELYSE
Masterpiece 188	2001	Benda seni ini memiliki nomor 3249486	ELYSE
Karya 326	2013	Benda seni ini memiliki nomor 7919620	ELYSE
Masterpiece 901	2010	Benda seni ini memiliki nomor 6148375	BEVERLY
Masterpiece 598	2010	Karya seni bernomor 9975807	BEVERLY
Masterpiece 753	2013	Karya seni bernomor 6618661	BEVERLY
Produk 940	2009	Karya seni bernomor 2155463	EMELINE
Karya 118	2005	Karya seni bernomor 0215489	EMELINE
Masterpiece 560	2002	Karya seni bernomor 9980664	CHANTAY
Produk 490	2013	Karya seni bernomor 0500453	ANITA
Produk 522	2002	Karya seni bernomor 9922527	ALEXANDRIA
Masterpiece 577	2007	Benda seni ini memiliki nomor 1203531	HARLAND
Masterpiece 329	2002	Karya seni bernomor 1855942	HARLAND
Produk 697	2012	Karya seni bernomor 7111187	HARLAND
Masterpiece 219	2004	Karya seni bernomor 6797441	CARITA
Produk 502	2009	Benda seni ini memiliki nomor 2688721	CARITA
Masterpiece 930	2002	Benda seni ini memiliki nomor 9551405	SHAUNTA
Masterpiece 893	2008	Karya seni bernomor 0870011	SHAUNTA
Karya 936	2013	Benda seni ini memiliki nomor 8684779	TAMERA
Produk 623	2012	Benda seni ini memiliki nomor 5894101	TAMERA
Masterpiece 503	2004	Karya seni bernomor 5552206	TAMERA
Karya 280	2011	Benda seni ini memiliki nomor 8962706	MARGENE
Karya 265	2013	Benda seni ini memiliki nomor 2664344	MARGENE
Produk 627	2004	Karya seni bernomor 4655197	JENETTE
Karya 363	2007	Karya seni bernomor 2613483	JENETTE
Produk 203	2008	Karya seni bernomor 0927737	JENETTE
Masterpiece 332	2012	Karya seni bernomor 0081287	HWA
Karya 578	2006	Benda seni ini memiliki nomor 0539298	HWA
Masterpiece 465	2011	Karya seni bernomor 1690008	EDNA
Masterpiece 841	2006	Karya seni bernomor 4592472	EDNA
Produk 600	2009	Karya seni bernomor 4412645	JONAS
Karya 810	2000	Karya seni bernomor 0811189	JONAS
Masterpiece 182	2002	Karya seni bernomor 4333224	ANH
Masterpiece 270	2005	Benda seni ini memiliki nomor 9814443	ANH
Karya 390	2010	Benda seni ini memiliki nomor 5842599	HAYDEE
Masterpiece 989	2010	Karya seni bernomor 7457363	LETITIA
Masterpiece 224	2008	Benda seni ini memiliki nomor 7703647	LETITIA
Produk 146	2007	Benda seni ini memiliki nomor 5975399	CANDI
Karya 654	2009	Karya seni bernomor 4587795	CANDI
Masterpiece 080	2003	Karya seni bernomor 0630343	GRISELDA
Karya 379	2013	Benda seni ini memiliki nomor 8198350	GRISELDA
Masterpiece 565	2005	Karya seni bernomor 7899922	GRISELDA
Produk 777	2001	Karya seni bernomor 3993771	GEMMA
Produk 305	2007	Benda seni ini memiliki nomor 9272763	GEMMA
Karya 253	2008	Benda seni ini memiliki nomor 5513123	WESTON
Masterpiece 779	2005	Karya seni bernomor 8197016	WESTON
Karya 587	2004	Karya seni bernomor 9315213	TRUDI
Karya 290	2013	Benda seni ini memiliki nomor 8675113	TRUDI
Karya 897	2005	Karya seni bernomor 3975540	HYE
Masterpiece 320	2012	Benda seni ini memiliki nomor 8488806	HYE
Produk 043	2005	Karya seni bernomor 1082169	HYE
Produk 020	2011	Karya seni bernomor 7586315	LADY
Produk 811	2006	Benda seni ini memiliki nomor 1450120	LADY
Masterpiece 775	2001	Karya seni bernomor 9168676	LADY
Produk 248	2000	Benda seni ini memiliki nomor 8358455	KELLY
Masterpiece 210	2001	Karya seni bernomor 1271649	ORPHA
Masterpiece 171	2007	Benda seni ini memiliki nomor 6999902	CEDRICK
Produk 952	2011	Karya seni bernomor 1917183	DIANE
Masterpiece 531	2000	Karya seni bernomor 5520167	DIANE
Karya 823	2006	Benda seni ini memiliki nomor 7881693	EFREN
Produk 394	2011	Karya seni bernomor 5687780	EFREN
Produk 890	2002	Karya seni bernomor 8845555	RICHELLE
Produk 930	2002	Karya seni bernomor 2765995	LUANNA
Produk 328	2001	Karya seni bernomor 7608032	LUANNA
Karya 248	2003	Karya seni bernomor 6334969	TENNILLE
Produk 665	2013	Karya seni bernomor 6479143	TENNILLE
Produk 347	2010	Benda seni ini memiliki nomor 0872705	WALDO
Masterpiece 294	2003	Benda seni ini memiliki nomor 9614414	JACLYN
Masterpiece 740	2001	Benda seni ini memiliki nomor 7130418	JACLYN
Produk 780	2011	Karya seni bernomor 5240672	CHANDA
Karya 510	2000	Karya seni bernomor 2745450	CHANDA
Masterpiece 747	2010	Karya seni bernomor 4868175	CHANDA
Produk 895	2013	Karya seni bernomor 1044749	DELICIA
Masterpiece 699	2009	Karya seni bernomor 4326017	YUKIKO
Produk 119	2008	Benda seni ini memiliki nomor 3697979	YUKIKO
Produk 573	2002	Karya seni bernomor 0471639	YUKIKO
Karya 093	2012	Karya seni bernomor 2843809	MODESTO
Produk 893	2010	Karya seni bernomor 1000066	MODESTO
Produk 223	2005	Karya seni bernomor 2347907	MODESTO
Produk 251	2012	Benda seni ini memiliki nomor 3777360	ERICA
Produk 841	2002	Karya seni bernomor 8167072	ERICA
Produk 416	2006	Karya seni bernomor 8328279	KIA
Produk 118	2009	Benda seni ini memiliki nomor 5708242	CALLIE
Karya 748	2003	Benda seni ini memiliki nomor 7738154	CALLIE
Karya 780	2009	Karya seni bernomor 1624627	CARMA
Karya 288	2002	Benda seni ini memiliki nomor 0487956	CARMA
Karya 550	2002	Benda seni ini memiliki nomor 6303309	CARMA
Produk 061	2010	Benda seni ini memiliki nomor 9092172	WARREN
Masterpiece 613	2013	Benda seni ini memiliki nomor 1492089	WARREN
Karya 191	2001	Karya seni bernomor 4933873	WARREN
Masterpiece 342	2010	Karya seni bernomor 0548280	RACHAL
Masterpiece 038	2013	Karya seni bernomor 8642818	RACHAL
Produk 162	2002	Benda seni ini memiliki nomor 9163945	RACHAL
\.


--
-- Data for Name: dipamerkan; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY dipamerkan (nama_pagelaran, nama_benda_seni) FROM stdin;
Pameran 277	Masterpiece 288
Pameran 277	Masterpiece 288
Pameran 277	Produk 310
Expo 829	Produk 310
Expo 829	Produk 310
Pagelaran 242	Produk 896
Expo 922	Produk 896
Expo 922	Karya 774
Pameran 625	Produk 796
Pameran 625	Produk 796
Pameran 625	Karya 920
Pameran 167	Karya 759
Pameran 167	Karya 759
Pagelaran 468	Karya 759
Pagelaran 468	Karya 311
Pameran 938	Karya 799
Pameran 839	Karya 799
Pameran 839	Karya 799
Pagelaran 210	Karya 307
Pagelaran 210	Karya 307
Pagelaran 210	Produk 587
Pagelaran 312	Produk 587
Pagelaran 312	Produk 755
Pameran 836	Produk 755
Pameran 836	Masterpiece 076
Pameran 836	Karya 560
Pameran 899	Masterpiece 092
Pameran 710	Karya 092
Pameran 601	Karya 092
Pagelaran 039	Masterpiece 649
Pagelaran 039	Masterpiece 649
Pagelaran 039	Masterpiece 649
Pameran 724	Karya 039
Pameran 724	Masterpiece 078
Pagelaran 399	Karya 321
Pagelaran 399	Karya 321
Pagelaran 399	Karya 694
Expo 159	Karya 793
Expo 062	Karya 793
Expo 062	Karya 793
Expo 352	Masterpiece 455
Expo 352	Karya 309
Expo 352	Karya 309
Pagelaran 657	Karya 547
Pagelaran 462	Karya 547
Pagelaran 462	Masterpiece 327
Pagelaran 462	Masterpiece 327
Pameran 769	Masterpiece 327
Expo 303	Masterpiece 690
Expo 303	Masterpiece 690
Expo 303	Masterpiece 690
Pameran 183	Masterpiece 473
Pameran 183	Produk 574
Pagelaran 617	Karya 592
Pagelaran 617	Karya 592
Pagelaran 617	Karya 592
Pameran 216	Karya 698
Pameran 216	Karya 698
Pagelaran 884	Produk 073
Pameran 406	Produk 073
Pameran 406	Produk 396
Pagelaran 051	Produk 396
Pameran 175	Produk 396
Pameran 175	Karya 789
Pameran 175	Produk 494
Pameran 969	Produk 494
Pameran 969	Karya 830
Pameran 969	Masterpiece 169
Expo 087	Karya 658
Expo 087	Karya 658
Expo 347	Karya 658
Pameran 337	Masterpiece 912
Pameran 337	Karya 181
Expo 655	Karya 181
Expo 655	Karya 553
Pameran 568	Karya 553
Pameran 568	Karya 553
Pameran 568	Karya 979
Expo 550	Karya 979
Pagelaran 942	Karya 861
Pameran 314	Masterpiece 677
Pameran 314	Masterpiece 677
Pameran 314	Karya 617
Expo 341	Karya 617
Pagelaran 203	Karya 617
Pagelaran 203	Produk 584
Pameran 524	Produk 584
Pameran 524	Masterpiece 933
Pameran 834	Karya 417
Pameran 834	Masterpiece 154
Pagelaran 644	Karya 946
Pagelaran 644	Karya 946
Pagelaran 644	Karya 946
Pameran 477	Karya 354
Pameran 477	Karya 354
Pameran 477	Karya 354
Pagelaran 682	Karya 693
Pagelaran 828	Karya 693
Pagelaran 606	Karya 693
Pameran 167	Karya 353
Pagelaran 681	Karya 353
Pagelaran 681	Masterpiece 071
Expo 878	Masterpiece 071
Expo 878	Masterpiece 700
Pameran 609	Masterpiece 700
Pagelaran 312	Produk 937
Pagelaran 782	Produk 937
Pagelaran 782	Produk 832
Pagelaran 782	Produk 960
Expo 519	Produk 762
Expo 768	Karya 950
Expo 768	Karya 950
Expo 768	Karya 950
Pagelaran 486	Karya 462
Pagelaran 486	Karya 688
Pameran 395	Masterpiece 060
Pameran 395	Masterpiece 060
Pameran 395	Karya 004
Pameran 966	Produk 075
Pameran 966	Masterpiece 903
Expo 885	Masterpiece 903
Expo 885	Karya 649
Expo 885	Karya 649
Expo 718	Produk 514
Expo 718	Produk 514
Expo 997	Produk 514
Expo 997	Karya 884
Expo 997	Karya 884
Pagelaran 235	Karya 884
Pagelaran 235	Masterpiece 347
Pagelaran 235	Masterpiece 896
Expo 352	Masterpiece 896
Expo 352	Masterpiece 393
Expo 712	Masterpiece 393
Pagelaran 988	Masterpiece 393
Pagelaran 988	Masterpiece 388
Pagelaran 951	Masterpiece 381
Pagelaran 951	Masterpiece 381
Pameran 183	Masterpiece 381
Expo 814	Masterpiece 609
Expo 814	Masterpiece 609
Expo 814	Masterpiece 609
Pameran 216	Produk 854
Pameran 216	Produk 854
Pameran 216	Produk 673
Expo 871	Produk 673
Expo 871	Masterpiece 324
Expo 871	Masterpiece 324
Expo 699	Karya 336
Expo 699	Karya 336
Expo 699	Produk 490
Expo 943	Masterpiece 329
Pameran 406	Karya 936
Pameran 406	Karya 936
Pameran 406	Karya 280
Expo 977	Karya 280
Expo 977	Karya 280
Pameran 969	Produk 203
Pameran 969	Masterpiece 465
Pameran 031	Masterpiece 465
Pameran 031	Produk 600
Pameran 632	Produk 600
Pameran 632	Karya 390
Pameran 964	Karya 654
Pameran 906	Karya 654
Pameran 906	Masterpiece 565
Pameran 906	Masterpiece 565
Expo 270	Masterpiece 565
Expo 270	Karya 897
Expo 270	Karya 897
Expo 945	Karya 897
Expo 945	Masterpiece 531
Expo 655	Masterpiece 531
Expo 000	Masterpiece 294
Expo 000	Masterpiece 294
Pameran 204	Produk 893
Pameran 204	Karya 748
Pameran 457	Masterpiece 342
Pameran 457	Masterpiece 342
Pagelaran 062	Masterpiece 342
Pagelaran 062	Produk 174
Pagelaran 062	Masterpiece 648
Pagelaran 203	Masterpiece 648
Pagelaran 203	Masterpiece 648
Pagelaran 702	Produk 896
Pagelaran 702	Produk 896
Pagelaran 702	Produk 896
Pameran 571	Karya 666
Pameran 571	Karya 666
Pameran 571	Karya 666
Expo 021	Masterpiece 828
Expo 021	Masterpiece 828
Pagelaran 682	Masterpiece 828
Pagelaran 682	Produk 419
Pagelaran 602	Produk 419
Pagelaran 602	Produk 419
Pameran 510	Karya 311
Pagelaran 828	Karya 311
Pagelaran 828	Karya 311
Pagelaran 251	Karya 853
Pagelaran 251	Karya 853
Pagelaran 251	Produk 699
Pagelaran 066	Produk 699
Pagelaran 066	Produk 699
Pagelaran 538	Produk 945
Pagelaran 538	Karya 035
Pagelaran 892	Produk 594
Pagelaran 892	Produk 594
Pagelaran 892	Produk 594
Pameran 839	Produk 681
Pameran 839	Produk 681
Pagelaran 379	Produk 681
Pagelaran 023	Produk 070
Expo 947	Produk 060
Expo 947	Produk 060
Pameran 836	Karya 205
Pameran 836	Karya 205
Pameran 601	Karya 205
Pameran 601	Produk 532
Pameran 601	Karya 735
Pameran 408	Produk 485
Pameran 408	Produk 485
Pameran 408	Produk 485
Pagelaran 399	Karya 039
Expo 159	Karya 039
Pameran 507	Produk 997
Pameran 507	Produk 997
Pameran 507	Produk 997
Pameran 520	Karya 694
Pameran 520	Karya 943
Expo 381	Karya 119
Expo 617	Karya 119
Expo 617	Karya 407
Expo 617	Karya 547
Expo 303	Masterpiece 218
Expo 303	Masterpiece 177
Pameran 183	Masterpiece 177
Pameran 183	Karya 818
Pameran 514	Masterpiece 581
Pameran 514	Masterpiece 581
Pameran 514	Masterpiece 581
Pagelaran 617	Masterpiece 206
Pagelaran 617	Masterpiece 206
Pagelaran 617	Masterpiece 206
Expo 230	Produk 424
Expo 230	Produk 424
Expo 230	Produk 745
Expo 699	Produk 745
Pameran 406	Karya 058
Pameran 406	Karya 058
Expo 841	Karya 058
Expo 841	Produk 396
Pagelaran 024	Produk 396
Pagelaran 024	Produk 396
Pagelaran 024	Masterpiece 020
Pameran 860	Produk 494
Pameran 860	Masterpiece 169
Pagelaran 415	Masterpiece 169
Pagelaran 415	Masterpiece 169
Pameran 632	Produk 267
Pameran 910	Produk 267
Pameran 910	Produk 267
Pameran 910	Masterpiece 912
Expo 980	Masterpiece 912
Pameran 811	Karya 648
Expo 197	Karya 648
Expo 197	Karya 348
Pameran 459	Produk 622
Pameran 453	Produk 622
Pameran 453	Karya 250
Pameran 453	Karya 250
Pameran 542	Karya 126
Expo 983	Karya 126
Expo 983	Produk 996
Expo 244	Produk 121
Pagelaran 203	Produk 121
Pagelaran 377	Produk 121
Pameran 834	Produk 421
Pameran 834	Produk 421
Pameran 834	Produk 421
Pameran 558	Karya 541
Pameran 558	Karya 541
Pameran 823	Karya 541
Pagelaran 602	Karya 019
Pagelaran 602	Karya 019
Pameran 033	Masterpiece 360
Pameran 033	Masterpiece 360
Pameran 033	Masterpiece 360
Pagelaran 411	Produk 670
Pagelaran 411	Produk 670
Pameran 417	Masterpiece 992
Pameran 417	Masterpiece 238
Pameran 417	Karya 002
Expo 553	Karya 002
Pameran 839	Karya 028
Pameran 839	Karya 028
Pagelaran 379	Masterpiece 870
Pagelaran 379	Produk 338
Pagelaran 379	Produk 338
Pameran 444	Karya 732
Pameran 444	Karya 732
Pameran 444	Karya 732
Pagelaran 720	Karya 189
Pagelaran 720	Karya 189
Pagelaran 554	Karya 676
Pagelaran 554	Karya 676
Pagelaran 554	Karya 676
Pameran 525	Karya 704
Pameran 525	Masterpiece 006
Pameran 525	Masterpiece 006
Pameran 710	Karya 455
Pameran 710	Karya 455
Pameran 242	Karya 688
Pameran 242	Masterpiece 971
Pameran 242	Produk 454
Pagelaran 469	Produk 454
Pagelaran 469	Karya 270
Pagelaran 486	Produk 075
Pagelaran 486	Produk 514
Pameran 966	Produk 514
Expo 718	Karya 024
Expo 997	Karya 888
Expo 997	Masterpiece 443
Pameran 507	Masterpiece 443
Pagelaran 462	Karya 633
Pagelaran 462	Masterpiece 420
Pagelaran 462	Masterpiece 821
Expo 381	Masterpiece 609
Expo 303	Masterpiece 609
Pameran 379	Masterpiece 609
Pameran 118	Masterpiece 365
Pagelaran 884	Masterpiece 365
Pameran 605	Karya 082
Pameran 605	Karya 162
Expo 943	Karya 162
Expo 943	Karya 336
Expo 943	Masterpiece 560
Pameran 969	Masterpiece 560
Pameran 969	Masterpiece 560
Pameran 969	Masterpiece 329
Pameran 655	Masterpiece 930
Pameran 655	Masterpiece 930
Pameran 655	Produk 203
Pameran 959	Produk 203
Pameran 782	Produk 203
Pameran 811	Karya 390
Pameran 811	Karya 390
Pameran 811	Produk 305
Pameran 968	Masterpiece 779
Pameran 897	Masterpiece 210
Pameran 897	Masterpiece 210
Expo 550	Produk 890
Expo 550	Produk 890
Pagelaran 942	Masterpiece 747
Expo 603	Produk 251
Pagelaran 520	Produk 251
Pameran 314	Produk 251
Pagelaran 062	Produk 118
Pagelaran 062	Produk 118
Expo 244	Produk 118
Pameran 524	Karya 748
Pagelaran 844	Karya 748
Pagelaran 844	Karya 748
Pagelaran 122	Produk 599
Pagelaran 122	Produk 599
Pagelaran 122	Produk 599
Pagelaran 682	Masterpiece 102
Pagelaran 682	Masterpiece 102
Pagelaran 682	Produk 896
Expo 829	Produk 896
Expo 829	Produk 896
Pameran 690	Masterpiece 205
Pameran 690	Masterpiece 656
Expo 588	Produk 419
Expo 588	Produk 419
Pagelaran 066	Produk 829
Pagelaran 066	Produk 301
Pagelaran 066	Produk 301
Pagelaran 468	Produk 301
Pagelaran 468	Produk 587
Pagelaran 468	Produk 587
Pagelaran 404	Masterpiece 256
Pagelaran 404	Masterpiece 256
Pagelaran 681	Masterpiece 580
Expo 878	Masterpiece 580
Expo 878	Masterpiece 770
Pagelaran 379	Masterpiece 092
Pagelaran 379	Masterpiece 092
Pagelaran 379	Masterpiece 092
Pameran 411	Masterpiece 660
Pameran 411	Karya 611
Pagelaran 191	Karya 205
Pagelaran 191	Produk 199
Pagelaran 191	Produk 199
Pagelaran 554	Produk 199
Pagelaran 554	Masterpiece 649
Pagelaran 554	Masterpiece 649
Pameran 836	Masterpiece 136
Expo 768	Masterpiece 136
Expo 768	Masterpiece 136
Expo 768	Masterpiece 654
Expo 469	Masterpiece 654
Expo 469	Produk 276
Pameran 724	Produk 276
Pameran 724	Produk 443
Pameran 724	Produk 443
Pameran 395	Karya 793
Pameran 395	Karya 793
Expo 718	Karya 793
Expo 227	Produk 510
Expo 531	Masterpiece 016
Expo 531	Produk 087
Pameran 320	Produk 087
Pameran 320	Produk 356
Pameran 320	Produk 356
Pagelaran 516	Produk 356
Pagelaran 516	Karya 474
Pameran 183	Karya 809
Pameran 183	Karya 809
Pameran 183	Masterpiece 177
Pameran 514	Karya 199
Pagelaran 574	Karya 199
Pagelaran 574	Karya 199
Pagelaran 569	Masterpiece 473
Pameran 347	Masterpiece 473
Pameran 347	Karya 592
Pagelaran 209	Masterpiece 306
Pagelaran 209	Masterpiece 306
Pagelaran 415	Masterpiece 462
Pagelaran 415	Karya 830
Pagelaran 415	Karya 883
Pameran 909	Karya 883
Expo 193	Karya 658
Expo 193	Karya 658
Pameran 910	Karya 348
Pameran 910	Karya 348
Pameran 910	Masterpiece 518
Pameran 337	Masterpiece 518
Expo 945	Produk 924
Expo 945	Karya 029
Expo 945	Karya 029
Expo 483	Karya 029
Expo 483	Karya 108
Pameran 897	Karya 108
Pameran 897	Karya 108
Pameran 897	Produk 584
Pameran 279	Karya 215
Pameran 279	Produk 801
Pameran 279	Masterpiece 970
Pameran 542	Masterpiece 970
Pameran 542	Masterpiece 970
Expo 983	Masterpiece 154
Expo 983	Masterpiece 154
Expo 983	Masterpiece 360
Pameran 581	Masterpiece 360
Pameran 581	Masterpiece 373
Pameran 581	Masterpiece 629
Pameran 999	Masterpiece 629
Pameran 999	Masterpiece 629
Pameran 999	Karya 693
Expo 473	Karya 693
Expo 473	Karya 693
Expo 473	Masterpiece 886
Pameran 477	Masterpiece 886
Pameran 477	Masterpiece 886
Pameran 477	Masterpiece 071
Pagelaran 578	Masterpiece 071
Pagelaran 578	Masterpiece 071
Pagelaran 578	Karya 057
Pameran 277	Karya 057
Pameran 277	Karya 057
Expo 647	Masterpiece 632
Expo 647	Masterpiece 632
Expo 647	Masterpiece 870
Pagelaran 828	Masterpiece 870
Pagelaran 828	Masterpiece 870
Pagelaran 411	Produk 050
Pagelaran 411	Produk 050
Pagelaran 411	Masterpiece 658
Pagelaran 606	Masterpiece 658
Pagelaran 606	Karya 189
Pagelaran 538	Karya 676
Pagelaran 538	Karya 676
Pagelaran 538	Karya 662
Expo 719	Karya 662
Expo 719	Karya 662
Pameran 839	Masterpiece 516
Expo 568	Masterpiece 516
Expo 568	Masterpiece 516
Expo 568	Produk 192
Pagelaran 191	Karya 270
Pagelaran 191	Produk 358
Pagelaran 191	Produk 358
Expo 747	Produk 358
Pagelaran 232	Masterpiece 903
Pagelaran 232	Produk 514
Pagelaran 232	Produk 514
Pameran 836	Produk 514
Pameran 836	Masterpiece 347
Pameran 836	Masterpiece 347
Pagelaran 196	Masterpiece 347
Expo 178	Masterpiece 896
Expo 178	Masterpiece 821
Expo 178	Karya 450
Pameran 395	Produk 808
Expo 143	Produk 808
Expo 143	Produk 808
Pagelaran 698	Masterpiece 784
Pagelaran 698	Karya 162
Expo 062	Karya 162
Expo 062	Karya 162
Expo 062	Masterpiece 901
Pameran 848	Masterpiece 901
Pameran 848	Masterpiece 901
Pameran 430	Masterpiece 329
Pameran 430	Masterpiece 329
Pameran 430	Masterpiece 329
Expo 866	Masterpiece 219
Expo 866	Masterpiece 503
Expo 866	Masterpiece 332
Pameran 373	Karya 390
Pameran 373	Masterpiece 565
Pagelaran 951	Produk 777
Pagelaran 951	Produk 777
Pagelaran 951	Karya 587
Pameran 769	Karya 897
Pameran 183	Karya 897
Pagelaran 492	Karya 897
Pagelaran 492	Produk 811
Pagelaran 574	Produk 811
Pameran 143	Produk 811
Pameran 143	Masterpiece 775
Expo 230	Produk 890
Expo 699	Produk 890
Expo 699	Produk 780
Expo 841	Produk 780
Expo 841	Masterpiece 747
Expo 841	Masterpiece 747
Pagelaran 450	Masterpiece 747
Pagelaran 450	Produk 895
Pagelaran 450	Produk 251
Pagelaran 415	Produk 251
Pagelaran 415	Produk 251
Pameran 909	Produk 061
Pameran 909	Produk 061
Expo 193	Karya 191
Expo 193	Produk 310
Pameran 910	Produk 310
Pameran 910	Masterpiece 674
Expo 945	Masterpiece 674
Expo 527	Karya 796
Expo 527	Karya 796
Pameran 968	Masterpiece 205
Pameran 796	Karya 666
Pameran 796	Karya 666
Pameran 796	Produk 796
Expo 000	Produk 796
Expo 000	Masterpiece 263
Expo 000	Masterpiece 263
Expo 983	Masterpiece 263
Pameran 471	Produk 419
Pameran 471	Produk 419
Pameran 471	Produk 829
Pameran 457	Produk 388
Pameran 457	Produk 388
Pagelaran 203	Produk 388
Pagelaran 203	Karya 759
Pagelaran 417	Karya 759
Pameran 342	Karya 957
Pameran 715	Karya 957
Pameran 715	Produk 144
Pameran 091	Produk 144
Pameran 091	Produk 144
Expo 021	Produk 594
Expo 021	Produk 594
Pagelaran 682	Masterpiece 076
Pagelaran 682	Masterpiece 580
Pameran 870	Karya 560
Pameran 870	Masterpiece 660
Pameran 870	Masterpiece 660
Pameran 510	Masterpiece 660
Pagelaran 546	Karya 611
Pagelaran 546	Karya 611
Pameran 690	Karya 656
Pameran 341	Karya 735
Pameran 417	Karya 735
Pameran 417	Karya 735
Pameran 417	Produk 128
Expo 719	Produk 128
Pameran 286	Produk 128
Pameran 286	Produk 083
Pameran 286	Produk 083
Pameran 839	Karya 279
Expo 878	Karya 279
Expo 878	Karya 279
Expo 057	Masterpiece 824
Expo 568	Produk 926
Pagelaran 998	Produk 926
Pagelaran 998	Produk 926
Expo 947	Masterpiece 089
Pameran 899	Produk 545
Expo 768	Produk 545
Expo 768	Produk 545
Pameran 198	Produk 108
Pameran 198	Masterpiece 690
Pagelaran 811	Masterpiece 690
Pagelaran 811	Masterpiece 690
Pameran 395	Produk 563
Pameran 395	Produk 745
Pameran 395	Produk 745
Pameran 966	Karya 970
Pameran 966	Produk 396
Expo 997	Karya 640
Expo 712	Karya 640
Pameran 320	Produk 494
Pagelaran 516	Produk 494
Expo 814	Produk 494
Expo 814	Produk 870
Pameran 216	Produk 870
Pameran 406	Produk 870
Pameran 406	Produk 853
Pameran 969	Produk 853
Expo 087	Karya 658
Expo 087	Karya 648
Expo 087	Karya 648
Expo 193	Karya 648
Expo 193	Karya 181
Pameran 232	Produk 760
Pameran 232	Produk 760
Pameran 232	Produk 760
Pameran 337	Masterpiece 819
Pameran 337	Masterpiece 819
Pameran 337	Masterpiece 819
Pagelaran 041	Karya 108
Pagelaran 041	Karya 108
Pagelaran 041	Produk 650
Pameran 796	Produk 584
Pameran 459	Produk 996
Pameran 459	Masterpiece 933
Pameran 459	Masterpiece 933
Pameran 279	Masterpiece 933
Pameran 279	Masterpiece 283
Expo 603	Masterpiece 283
Pameran 085	Karya 691
Pameran 085	Karya 588
Pameran 085	Karya 588
Pameran 471	Karya 588
Pameran 457	Masterpiece 238
Pameran 457	Masterpiece 238
Pameran 457	Masterpiece 238
Pagelaran 203	Produk 570
Pagelaran 417	Karya 028
Pameran 261	Karya 028
Pameran 261	Karya 028
Pameran 261	Karya 122
Pameran 558	Karya 732
Pameran 558	Produk 771
Expo 662	Produk 771
Expo 662	Produk 771
Pagelaran 578	Karya 077
Pameran 277	Karya 077
Pameran 277	Produk 960
Expo 647	Produk 960
Expo 647	Produk 960
Expo 647	Produk 644
Pagelaran 251	Masterpiece 890
Pameran 625	Masterpiece 890
Expo 719	Produk 107
Expo 719	Produk 107
Pameran 286	Produk 171
Pameran 286	Produk 171
Pameran 286	Produk 171
Pameran 938	Produk 521
Pagelaran 379	Produk 521
Pagelaran 379	Produk 521
Pagelaran 210	Karya 173
Pagelaran 210	Produk 005
Pameran 805	Produk 306
Pameran 805	Masterpiece 821
Pameran 805	Masterpiece 821
Pagelaran 782	Masterpiece 821
Pagelaran 782	Karya 647
Pameran 710	Produk 854
Pameran 710	Karya 989
Pameran 242	Masterpiece 784
Expo 721	Masterpiece 188
Expo 721	Karya 118
Expo 721	Masterpiece 577
Pameran 408	Masterpiece 893
Pameran 408	Karya 936
Pameran 408	Produk 623
Pameran 485	Karya 578
Pameran 485	Produk 600
Pameran 485	Produk 600
Pameran 966	Masterpiece 270
Expo 143	Masterpiece 270
Expo 997	Masterpiece 270
Expo 352	Karya 654
Expo 352	Karya 897
Expo 352	Karya 897
Expo 866	Karya 897
Expo 866	Masterpiece 320
Pameran 373	Masterpiece 320
Expo 617	Karya 823
Expo 617	Masterpiece 294
Expo 617	Masterpiece 294
Expo 102	Karya 510
Expo 102	Produk 223
Expo 102	Produk 223
Pagelaran 574	Produk 223
Pagelaran 574	Masterpiece 613
Pagelaran 574	Produk 174
Pameran 379	Produk 174
Pameran 379	Karya 796
Expo 230	Karya 796
Expo 230	Karya 796
Pagelaran 281	Produk 651
Pagelaran 281	Produk 651
Pameran 175	Produk 651
Pagelaran 209	Karya 947
Pagelaran 475	Karya 947
Pagelaran 475	Karya 112
Pagelaran 475	Karya 112
Pameran 782	Masterpiece 290
Pameran 782	Masterpiece 290
Pameran 705	Masterpiece 290
Pameran 705	Produk 144
Pagelaran 324	Produk 587
Expo 527	Produk 587
Expo 527	Karya 836
Expo 527	Karya 836
Pagelaran 041	Karya 836
Pagelaran 041	Masterpiece 580
Pameran 568	Masterpiece 092
Pameran 568	Masterpiece 065
Pameran 568	Masterpiece 065
Expo 550	Karya 092
Expo 550	Masterpiece 649
Expo 550	Karya 039
Pameran 453	Karya 039
Pameran 453	Karya 039
Pameran 453	Masterpiece 078
Expo 983	Produk 443
Expo 983	Karya 321
Pameran 314	Karya 321
Pagelaran 706	Karya 321
Pameran 524	Produk 498
Pameran 524	Masterpiece 455
Pameran 834	Masterpiece 455
Pameran 834	Masterpiece 455
Pameran 091	Karya 474
Pagelaran 122	Masterpiece 327
Pagelaran 122	Masterpiece 327
Pagelaran 122	Masterpiece 174
Pameran 477	Masterpiece 174
Pameran 277	Masterpiece 174
Pameran 277	Karya 894
Pameran 277	Karya 058
Pameran 870	Karya 058
Pameran 870	Karya 058
Pameran 870	Produk 396
Pameran 510	Produk 320
Pameran 510	Produk 320
Pameran 033	Produk 320
Pameran 033	Masterpiece 794
Expo 693	Karya 789
Expo 693	Karya 789
Expo 588	Karya 789
Expo 588	Produk 870
Pameran 268	Masterpiece 169
Pameran 268	Masterpiece 912
Pagelaran 066	Karya 026
Pagelaran 066	Karya 026
Pagelaran 404	Karya 026
Pagelaran 404	Produk 760
Pameran 839	Produk 760
Pameran 839	Produk 760
Pameran 190	Karya 029
Pameran 609	Karya 029
Pameran 609	Karya 861
Pameran 609	Produk 037
Pagelaran 312	Produk 037
Expo 367	Produk 037
Expo 367	Produk 121
Expo 367	Produk 121
Expo 519	Produk 121
Expo 519	Masterpiece 283
Expo 519	Masterpiece 283
Pagelaran 196	Masterpiece 283
Pameran 242	Karya 691
Pameran 242	Masterpiece 373
Expo 768	Karya 588
Expo 768	Karya 368
Pameran 408	Produk 042
Pameran 408	Masterpiece 272
Pagelaran 198	Masterpiece 272
Pagelaran 198	Masterpiece 272
Pagelaran 198	Masterpiece 848
Pagelaran 960	Masterpiece 848
Pagelaran 960	Masterpiece 848
Pameran 833	Masterpiece 870
Pameran 833	Masterpiece 870
Pameran 833	Karya 967
Expo 062	Karya 967
Expo 062	Masterpiece 847
Expo 352	Masterpiece 847
Expo 352	Masterpiece 847
Pameran 507	Karya 077
Pameran 507	Karya 077
Pameran 507	Karya 077
Pameran 520	Karya 662
Pagelaran 951	Karya 662
Pameran 183	Produk 644
Pagelaran 617	Produk 644
Pagelaran 884	Masterpiece 006
Pagelaran 884	Masterpiece 006
Pagelaran 884	Masterpiece 006
Pameran 406	Masterpiece 060
Pameran 406	Produk 107
Expo 841	Produk 107
Expo 841	Produk 107
Expo 841	Produk 358
Pameran 860	Produk 514
Pameran 860	Produk 514
Pameran 860	Produk 005
Expo 087	Karya 076
Pameran 964	Produk 306
Pameran 964	Karya 633
Pameran 964	Karya 244
Pameran 782	Karya 244
Pameran 782	Karya 740
Pameran 782	Karya 989
Pameran 811	Karya 989
Pameran 811	Karya 989
Pameran 811	Masterpiece 784
Expo 945	Masterpiece 784
Pameran 968	Masterpiece 784
Pameran 968	Karya 795
Expo 649	Karya 795
Expo 649	Masterpiece 753
Pameran 459	Masterpiece 753
Pagelaran 942	Masterpiece 753
Expo 603	Produk 502
Expo 603	Produk 203
Expo 603	Produk 203
Pameran 453	Karya 390
Pameran 453	Produk 305
Pameran 453	Karya 897
Pagelaran 062	Karya 897
Pagelaran 062	Karya 897
Pagelaran 203	Produk 020
Pagelaran 203	Karya 823
Pagelaran 203	Produk 780
Pameran 834	Produk 780
Expo 473	Produk 780
Expo 662	Masterpiece 747
Pagelaran 682	Produk 251
Pagelaran 682	Produk 251
Pagelaran 682	Karya 748
Pameran 277	Masterpiece 613
Pameran 033	Masterpiece 613
Pameran 341	Masterpiece 038
Pameran 341	Masterpiece 102
Pagelaran 411	Masterpiece 399
Pagelaran 411	Masterpiece 399
Pagelaran 411	Masterpiece 399
Pagelaran 538	Masterpiece 656
Pameran 286	Masterpiece 760
Expo 037	Masterpiece 760
Expo 037	Produk 388
Expo 037	Produk 388
Pagelaran 681	Produk 388
Pagelaran 681	Karya 853
Pagelaran 681	Karya 853
Expo 878	Produk 699
Expo 878	Produk 699
Pameran 609	Karya 307
Pameran 609	Karya 307
Pagelaran 023	Karya 307
Pagelaran 023	Karya 170
Pagelaran 023	Karya 170
Pameran 805	Karya 219
Pameran 805	Masterpiece 296
Pameran 805	Masterpiece 296
Pagelaran 076	Masterpiece 296
Pagelaran 076	Masterpiece 065
Expo 519	Masterpiece 065
Expo 519	Produk 060
Expo 519	Produk 060
Pagelaran 469	Produk 060
Pagelaran 469	Karya 092
Pagelaran 469	Karya 464
Expo 178	Masterpiece 649
Expo 178	Masterpiece 649
Pagelaran 198	Karya 445
Pagelaran 698	Produk 409
Pagelaran 698	Produk 409
Pagelaran 698	Produk 409
Expo 227	Karya 381
Expo 227	Karya 381
Expo 227	Karya 381
Expo 712	Karya 279
Expo 712	Produk 510
Expo 457	Produk 510
Pameran 507	Produk 510
Pameran 507	Karya 407
Pameran 848	Karya 309
Pameran 848	Masterpiece 218
Pameran 848	Masterpiece 327
Pameran 520	Masterpiece 327
Pagelaran 988	Masterpiece 607
Pagelaran 988	Produk 424
Pagelaran 462	Produk 424
Pagelaran 462	Produk 424
Pagelaran 462	Karya 203
Expo 521	Karya 203
Expo 521	Masterpiece 549
Pameran 379	Masterpiece 549
Pameran 379	Masterpiece 549
Pameran 216	Masterpiece 462
Pameran 216	Masterpiece 794
Pagelaran 884	Masterpiece 794
Pagelaran 884	Produk 494
Expo 943	Produk 494
Expo 943	Karya 902
Expo 943	Karya 902
Pagelaran 051	Masterpiece 812
Pagelaran 051	Produk 924
Pameran 969	Produk 163
Pagelaran 415	Produk 163
Pameran 162	Produk 163
Pameran 162	Karya 029
Pameran 162	Karya 029
Expo 193	Karya 029
Expo 193	Produk 650
Pagelaran 770	Produk 650
Expo 980	Produk 650
Expo 980	Produk 190
Expo 980	Produk 421
Expo 511	Produk 507
Expo 511	Produk 507
Pagelaran 041	Karya 541
Pagelaran 041	Karya 541
Pagelaran 041	Karya 541
Expo 197	Produk 193
Pameran 279	Produk 193
Expo 603	Produk 193
Pameran 085	Karya 588
Pameran 085	Karya 003
Expo 244	Karya 353
Expo 244	Masterpiece 272
Expo 244	Masterpiece 272
Pagelaran 203	Masterpiece 272
Pagelaran 203	Produk 224
Pagelaran 203	Produk 224
Pagelaran 702	Produk 224
Pameran 212	Masterpiece 700
Pagelaran 844	Masterpiece 700
Pagelaran 844	Masterpiece 700
Pameran 091	Produk 526
Pameran 091	Produk 526
Pameran 091	Produk 526
Pagelaran 644	Produk 338
Pagelaran 644	Masterpiece 847
Pameran 477	Masterpiece 847
Pameran 510	Masterpiece 847
Pameran 510	Masterpiece 658
Pagelaran 242	Produk 771
Pagelaran 242	Produk 960
Pagelaran 251	Produk 483
Pagelaran 251	Karya 049
Pagelaran 251	Karya 455
Pameran 690	Karya 455
Pameran 690	Produk 192
Pagelaran 066	Produk 192
Pameran 286	Produk 192
Pameran 286	Karya 242
Pameran 286	Karya 242
Expo 026	Karya 874
Pameran 839	Karya 874
Pameran 839	Masterpiece 903
Pameran 190	Produk 691
Pameran 190	Masterpiece 007
Pameran 190	Karya 471
Pagelaran 720	Karya 471
Pagelaran 720	Karya 471
Pagelaran 720	Karya 884
Pagelaran 782	Karya 386
Pagelaran 956	Karya 386
Pagelaran 956	Masterpiece 443
Pagelaran 956	Produk 787
Pameran 242	Masterpiece 821
Expo 178	Masterpiece 821
Pameran 395	Karya 142
Expo 143	Karya 082
Pameran 833	Karya 082
Pameran 833	Masterpiece 784
Pameran 833	Masterpiece 784
Expo 457	Masterpiece 978
Expo 457	Masterpiece 662
\.


--
-- Data for Name: lukisan; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY lukisan (nama_benda_seni, kategori) FROM stdin;
Masterpiece 674	Abstrak
Karya 501	Dekoratif
Masterpiece 399	Dekoratif
Masterpiece 205	Impresionis
Karya 702	Dekoratif
Karya 144	Surealis
Karya 112	Abstrak
Produk 388	Dekoratif
Karya 853	Dekoratif
Produk 144	Naturalis
Karya 307	Abstrak
Produk 594	Surealis
Karya 836	Klasik
Karya 219	Naturalis
Masterpiece 316	Naturalis
Karya 205	Surealis
Produk 128	Impresionis
Produk 276	Naturalis
Produk 083	Klasik
Karya 703	Impresionis
Karya 321	Realist
Produk 498	Klasik
Karya 793	Dekoratif
Masterpiece 824	Dekoratif
Masterpiece 802	Dekoratif
Karya 309	Realist
Karya 474	Abstrak
Masterpiece 327	Abstrak
Karya 818	Impresionis
Produk 574	Klasik
Karya 698	Realist
Karya 970	Naturalis
Produk 396	Impresionis
Masterpiece 794	Realist
Karya 830	Surealis
Produk 870	Dekoratif
Karya 883	Klasik
Produk 267	Naturalis
Karya 648	Abstrak
Masterpiece 651	Abstrak
Masterpiece 819	Dekoratif
Karya 453	Dekoratif
Masterpiece 677	Naturalis
Produk 190	Realist
Karya 384	Naturalis
Produk 310	Dekoratif
Produk 298	Naturalis
Masterpiece 263	Surealis
Karya 051	Dekoratif
Produk 726	Klasik
Produk 945	Surealis
Masterpiece 076	Naturalis
Produk 070	Realist
Karya 611	Impresionis
Karya 735	Naturalis
Karya 106	Abstrak
Karya 943	Klasik
Karya 119	Impresionis
Produk 467	Surealis
Produk 474	Dekoratif
Karya 915	Surealis
Produk 379	Surealis
Produk 108	Impresionis
Masterpiece 607	Surealis
Produk 563	Klasik
Produk 745	Klasik
Masterpiece 306	Impresionis
Karya 789	Klasik
Karya 175	Realist
Karya 961	Dekoratif
Karya 902	Dekoratif
Masterpiece 169	Klasik
Masterpiece 812	Realist
Karya 181	Impresionis
Produk 955	Surealis
Karya 553	Dekoratif
Produk 163	Impresionis
Masterpiece 546	Dekoratif
Karya 250	Klasik
Masterpiece 002	Impresionis
Produk 405	Dekoratif
Masterpiece 933	Naturalis
Produk 801	Abstrak
Masterpiece 283	Dekoratif
Masterpiece 288	Abstrak
Masterpiece 648	Dekoratif
Karya 639	Realist
Masterpiece 656	Impresionis
Produk 618	Surealis
Karya 920	Realist
Masterpiece 424	Surealis
Produk 401	Surealis
Karya 799	Realist
Masterpiece 256	Dekoratif
Masterpiece 770	Abstrak
Produk 738	Dekoratif
Masterpiece 136	Naturalis
Masterpiece 078	Dekoratif
Produk 443	Dekoratif
Masterpiece 016	Dekoratif
Masterpiece 764	Abstrak
Karya 809	Surealis
Karya 304	Abstrak
Masterpiece 206	Impresionis
Karya 592	Realist
Produk 073	Impresionis
Karya 640	Impresionis
Karya 026	Surealis
Produk 924	Klasik
Masterpiece 831	Klasik
Karya 979	Realist
Karya 617	Abstrak
Produk 584	Dekoratif
Karya 329	Realist
Produk 196	Surealis
Produk 507	Realist
Produk 112	Impresionis
Produk 599	Dekoratif
Karya 705	Dekoratif
Produk 174	Naturalis
Karya 664	Dekoratif
Produk 651	Abstrak
Masterpiece 828	Realist
Karya 947	Abstrak
Masterpiece 760	Abstrak
Karya 759	Abstrak
Karya 311	Surealis
Karya 957	Naturalis
Produk 699	Dekoratif
Produk 587	Realist
Produk 755	Abstrak
Produk 060	Realist
Karya 656	Abstrak
Karya 857	Surealis
Produk 513	Surealis
Produk 926	Abstrak
Masterpiece 161	Realist
Karya 199	Naturalis
Masterpiece 473	Klasik
Karya 894	Realist
Produk 922	Dekoratif
Karya 508	Impresionis
Karya 348	Klasik
Karya 108	Realist
Produk 446	Realist
Karya 774	Abstrak
Produk 729	Dekoratif
Produk 829	Realist
Masterpiece 290	Dekoratif
Karya 170	Surealis
Masterpiece 580	Naturalis
Produk 994	Abstrak
Masterpiece 092	Surealis
Produk 199	Abstrak
Masterpiece 654	Impresionis
Produk 409	Klasik
Produk 953	Surealis
Masterpiece 455	Abstrak
Karya 502	Naturalis
Masterpiece 690	Realist
Produk 255	Naturalis
Masterpiece 462	Surealis
Masterpiece 346	Naturalis
Masterpiece 912	Naturalis
Produk 037	Abstrak
Produk 421	Naturalis
Produk 761	Naturalis
Karya 092	Abstrak
Masterpiece 649	Dekoratif
Karya 694	Realist
Produk 087	Surealis
Produk 545	Abstrak
Produk 129	Impresionis
Karya 203	Klasik
Karya 058	Naturalis
Karya 658	Realist
Karya 973	Klasik
Karya 029	Realist
Karya 126	Abstrak
Produk 121	Dekoratif
Produk 759	Klasik
Produk 796	Naturalis
Masterpiece 953	Surealis
Karya 165	Abstrak
Karya 464	Impresionis
Karya 854	Naturalis
Karya 895	Klasik
Masterpiece 089	Klasik
Masterpiece 218	Surealis
Masterpiece 174	Abstrak
Karya 968	Klasik
Karya 599	Dekoratif
Karya 541	Abstrak
Masterpiece 102	Realist
Masterpiece 816	Impresionis
Masterpiece 853	Surealis
Produk 303	Surealis
Masterpiece 660	Klasik
Produk 997	Klasik
Produk 510	Naturalis
Masterpiece 177	Realist
Produk 494	Naturalis
Masterpiece 308	Impresionis
Produk 301	Surealis
Masterpiece 020	Impresionis
Masterpiece 518	Realist
Produk 622	Impresionis
Karya 861	Dekoratif
Produk 650	Impresionis
Karya 035	Dekoratif
Masterpiece 296	Impresionis
Produk 085	Dekoratif
Karya 206	Klasik
Karya 547	Surealis
Masterpiece 581	Realist
Produk 424	Realist
Produk 047	Klasik
Karya 445	Klasik
Karya 407	Naturalis
Karya 271	Naturalis
Produk 320	Surealis
Produk 853	Naturalis
Produk 104	Abstrak
Karya 417	Abstrak
Karya 796	Abstrak
Produk 896	Impresionis
Produk 419	Impresionis
Karya 279	Abstrak
Masterpiece 232	Realist
Karya 867	Surealis
Karya 506	Realist
Produk 485	Realist
Karya 039	Naturalis
Karya 381	Klasik
Produk 165	Abstrak
Karya 215	Realist
Karya 666	Dekoratif
Karya 560	Realist
Masterpiece 549	Surealis
Masterpiece 280	Naturalis
Karya 080	Klasik
Masterpiece 702	Realist
Produk 760	Surealis
Produk 532	Impresionis
Produk 356	Surealis
Karya 453	Naturalis
Produk 996	Abstrak
Produk 681	Naturalis
Masterpiece 745	Abstrak
Karya 604	Klasik
\.


--
-- Data for Name: pagelaran; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY pagelaran (nama_pagelaran, bulan) FROM stdin;
Pagelaran 122	Februari
Pagelaran 100	Februari
Pagelaran 644	Januari
Pameran 823	Januari
Pameran 477	Maret
Pagelaran 578	Desember
Expo 021	September
Pagelaran 682	November
Expo 281	Januari
Pameran 277	Agustus
Pagelaran 602	Juli
Expo 936	November
Pameran 870	Juni
Expo 829	Mei
Pameran 510	Juni
Expo 647	November
Pagelaran 828	Juli
Pagelaran 546	Mei
Pameran 033	September
Pagelaran 242	November
Expo 693	Agustus
Pameran 576	Juni
Pagelaran 251	Mei
Pameran 690	November
Pameran 341	Mei
Pagelaran 411	Oktober
Pagelaran 606	Agustus
Expo 922	April
Expo 588	Maret
Pameran 625	Desember
Pameran 268	Januari
Pagelaran 066	April
Pameran 417	Oktober
Pameran 167	Maret
Pagelaran 538	Desember
Pagelaran 879	Februari
Pagelaran 468	Juli
Pagelaran 404	Januari
Pagelaran 892	April
Expo 719	Juni
Pameran 286	Maret
Expo 553	Desember
Expo 037	September
Pagelaran 681	Juni
Expo 026	April
Pameran 938	April
Pameran 839	Januari
Expo 878	Agustus
Pameran 190	Juli
Expo 057	Februari
Pagelaran 379	September
Pameran 411	Juni
Pameran 609	Februari
Expo 568	Januari
Pagelaran 210	Mei
Pagelaran 191	Maret
Pagelaran 023	September
Pameran 444	Januari
Pagelaran 720	Maret
Pameran 124	Juni
Pameran 805	Agustus
Pagelaran 312	Maret
Expo 747	Agustus
Pagelaran 998	Juni
Pagelaran 554	Mei
Pagelaran 076	Maret
Expo 947	Mei
Expo 367	Juni
Pagelaran 782	Maret
Pagelaran 232	Oktober
Pameran 836	September
Pagelaran 956	Desember
Pameran 899	Juni
Expo 519	November
Pameran 525	Agustus
Pagelaran 196	November
Pameran 710	Oktober
Pameran 242	September
Pagelaran 469	Januari
Pameran 601	April
Expo 768	Februari
Pameran 198	Desember
Expo 721	Desember
Pagelaran 811	Juli
Pagelaran 039	Maret
Expo 178	Agustus
Pameran 410	Januari
Pameran 408	Januari
Pagelaran 486	November
Pameran 207	Desember
Expo 469	Desember
Pameran 485	Januari
Pameran 724	September
Pameran 395	Januari
Pagelaran 399	Juli
Pagelaran 198	Februari
Pameran 966	November
Expo 885	Mei
Expo 143	September
Pameran 199	Agustus
Pagelaran 960	Juli
Pagelaran 698	Agustus
Expo 718	Oktober
Pagelaran 614	Januari
Expo 159	Januari
Expo 997	Oktober
Pagelaran 235	Agustus
Pameran 833	Mei
Expo 227	Agustus
Expo 062	Juni
Expo 352	Oktober
Expo 712	April
Expo 457	November
Pameran 507	Agustus
Pameran 848	Maret
Expo 531	Januari
Pameran 430	September
Expo 866	November
Pameran 320	Mei
Pameran 520	April
Pagelaran 657	Oktober
Pagelaran 988	Februari
Pagelaran 462	Juni
Pameran 373	Februari
Expo 381	Juli
Expo 206	Juni
Pameran 335	September
Pagelaran 516	Mei
Pagelaran 951	Mei
Expo 617	Juli
Pameran 769	Maret
Expo 521	Juni
Expo 303	Januari
Pameran 183	Februari
Expo 512	Mei
Pameran 514	September
Pagelaran 492	November
Expo 814	April
Expo 102	Agustus
Pagelaran 574	Juni
Pameran 379	September
Pameran 118	Mei
Pagelaran 617	Februari
Pameran 143	Desember
Pameran 216	April
Pameran 119	Februari
Expo 230	Januari
Pagelaran 884	April
Pagelaran 569	Januari
Pameran 605	April
Expo 871	Mei
Expo 699	Oktober
Expo 943	Januari
Pagelaran 281	Desember
Pameran 406	Agustus
Pameran 347	Juni
Pameran 674	Januari
Expo 977	November
Pameran 559	Maret
Expo 841	Juni
Pagelaran 051	November
Pameran 175	Oktober
Pameran 969	Mei
Pagelaran 024	Februari
Pagelaran 209	Juni
Pagelaran 450	Mei
Pameran 655	Juli
Pameran 860	Oktober
Pagelaran 763	November
Pagelaran 415	Oktober
Pameran 031	Juni
Pameran 959	September
Expo 087	Mei
Pagelaran 475	Agustus
Pameran 632	September
Pameran 162	April
Pameran 909	November
Pameran 964	Desember
Pagelaran 797	Oktober
Expo 193	September
Pagelaran 770	Juni
Pameran 782	Januari
Expo 347	Juli
Pameran 906	Mei
Pameran 910	Desember
Pameran 705	Maret
Pameran 232	Maret
Expo 980	Maret
Expo 270	Juli
Pagelaran 588	Desember
Pameran 337	Mei
Pameran 811	Februari
Expo 511	Maret
Expo 945	Agustus
Pameran 130	Oktober
Pagelaran 324	Mei
Expo 527	Juni
Pagelaran 041	April
Expo 483	Desember
Pameran 968	Februari
Expo 655	Juni
Expo 197	September
Pameran 897	Desember
Pagelaran 420	Januari
Pameran 568	Agustus
Expo 649	September
Pagelaran 412	Agustus
Pameran 796	Maret
Pameran 459	September
Expo 550	Juli
Expo 000	Juni
Pameran 279	Agustus
Expo 989	Agustus
Pagelaran 215	Februari
Pagelaran 942	Mei
Pameran 204	Juli
Expo 603	Januari
Pameran 453	Juli
Pameran 542	Maret
Pagelaran 520	November
Expo 983	September
Pameran 314	September
Pameran 085	Juni
Expo 341	September
Pameran 471	Januari
Pameran 457	Mei
Pagelaran 062	Februari
Expo 256	Maret
Pameran 581	April
Pagelaran 706	Januari
Expo 244	Februari
Expo 269	September
Pagelaran 203	Oktober
Pameran 896	Maret
Pagelaran 417	Juli
Pameran 261	Juni
Pameran 524	Oktober
Pameran 999	September
Pagelaran 702	Mei
Pameran 212	April
Pagelaran 844	September
Pagelaran 377	Desember
Pameran 834	Maret
Pameran 342	Januari
Pameran 715	September
Pameran 558	April
Expo 473	November
Pameran 091	November
Pameran 571	Oktober
Expo 662	Juli
\.


--
-- Data for Name: pahatan; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY pahatan (nama_benda_seni, bahan_dasar, panjang, lebar, tinggi) FROM stdin;
Produk 657	Pualam	51	28	79
Karya 003	Batu bata	70	87	22
Produk 011	Pualam	4	75	78
Masterpiece 272	Kaca	73	9	37
Produk 224	Kaca	63	53	11
Masterpiece 632	Tanah liat	68	51	74
Karya 122	Plastisin	61	46	95
Masterpiece 274	Plastisin	26	1	47
Masterpiece 658	Pualam	100	39	28
Produk 483	Plastisin	90	72	32
Karya 404	Plastisin	86	11	36
Karya 676	Kaca	60	15	27
Masterpiece 890	Tanah liat	66	34	30
Produk 454	Pualam	29	65	17
Produk 107	Plastisin	21	83	5
Masterpiece 033	Plastisin	34	2	18
Masterpiece 903	Tanah liat	71	80	3
Karya 471	Batu bata	69	94	43
Karya 888	Kaca	18	12	40
Masterpiece 443	Tanah liat	96	22	63
Karya 244	Batu bata	78	49	58
Produk 808	Pualam	95	63	22
Karya 134	Kaca	44	68	82
Masterpiece 978	Kaca	34	66	94
Masterpiece 753	Pualam	4	3	59
Produk 522	Kaca	27	39	64
Masterpiece 329	Tanah liat	66	48	47
Karya 936	Plastisin	24	20	17
Masterpiece 465	Tanah liat	16	42	23
Karya 390	Plastisin	79	74	33
Karya 654	Tanah liat	11	23	25
Masterpiece 080	Tanah liat	7	22	50
Karya 897	Plastisin	4	48	73
Masterpiece 171	Plastisin	59	64	57
Produk 394	Plastisin	60	14	72
Karya 510	Kaca	14	82	26
Karya 093	Plastisin	42	41	60
Karya 550	Plastisin	69	81	83
Karya 191	Kaca	35	46	58
Masterpiece 342	Tanah liat	7	93	78
Masterpiece 154	Pualam	53	96	3
Karya 481	Kaca	67	34	35
Masterpiece 373	Kaca	73	33	95
Karya 354	Plastisin	23	34	55
Produk 544	Plastisin	52	2	11
Masterpiece 090	Tanah liat	98	70	13
Karya 028	Kaca	100	83	59
Masterpiece 632	Tanah liat	29	45	42
Karya 967	Pualam	25	47	82
Masterpiece 274	Pualam	17	18	42
Karya 732	Tanah liat	60	36	70
Karya 077	Kaca	26	35	89
Produk 762	Kaca	70	75	86
Karya 676	Kaca	42	24	63
Masterpiece 006	Batu bata	46	69	5
Karya 688	Batu bata	62	41	59
Karya 270	Plastisin	11	33	90
Produk 358	Pualam	29	43	13
Karya 660	Kaca	48	26	50
Masterpiece 007	Pualam	38	61	60
Karya 884	Kaca	50	13	77
Produk 752	Kaca	50	82	52
Karya 888	Plastisin	15	65	20
Karya 386	Pualam	22	11	17
Karya 633	Pualam	43	62	64
Produk 857	Pualam	4	3	18
Karya 740	Pualam	87	26	7
Karya 142	Pualam	6	100	1
Produk 673	Kaca	81	2	26
Karya 162	Plastisin	11	46	32
Masterpiece 978	Tanah liat	56	65	26
Masterpiece 188	Plastisin	64	14	20
Karya 326	Tanah liat	34	93	76
Masterpiece 753	Plastisin	68	19	80
Produk 490	Batu bata	55	4	70
Masterpiece 930	Pualam	97	45	35
Karya 936	Plastisin	98	27	58
Karya 578	Tanah liat	43	55	31
Masterpiece 182	Kaca	83	90	6
Masterpiece 270	Kaca	80	17	67
Produk 777	Pualam	18	40	63
Karya 253	Kaca	63	64	88
Karya 290	Plastisin	19	77	57
Produk 020	Kaca	49	97	93
Masterpiece 210	Tanah liat	9	71	60
Produk 890	Plastisin	17	2	69
Masterpiece 294	Plastisin	85	56	65
Karya 093	Pualam	73	78	61
Karya 550	Plastisin	93	13	12
Masterpiece 613	Tanah liat	61	41	73
Karya 481	Batu bata	51	5	22
Masterpiece 554	Kaca	20	82	62
Karya 693	Pualam	11	39	21
Karya 563	Batu bata	19	21	63
Produk 570	Pualam	3	36	10
Karya 057	Plastisin	13	30	48
Masterpiece 870	Plastisin	82	83	5
Produk 832	Kaca	8	12	84
Karya 933	Pualam	8	59	7
Karya 676	Tanah liat	10	58	70
Karya 049	Plastisin	30	22	28
Karya 455	Batu bata	31	18	6
Masterpiece 890	Tanah liat	55	91	23
Karya 688	Tanah liat	82	81	91
Masterpiece 971	Tanah liat	87	85	14
Karya 088	Kaca	7	92	31
Masterpiece 033	Plastisin	55	73	96
Produk 358	Plastisin	63	45	94
Karya 649	Tanah liat	52	83	21
Karya 173	Batu bata	54	66	33
Karya 386	Pualam	17	87	47
Karya 612	Tanah liat	88	9	73
Karya 244	Pualam	58	45	62
Produk 225	Tanah liat	22	92	13
Produk 854	Plastisin	54	74	80
Masterpiece 784	Batu bata	55	49	6
Masterpiece 188	Kaca	75	82	98
Masterpiece 598	Plastisin	54	56	68
Produk 697	Batu bata	67	96	80
Masterpiece 930	Kaca	68	73	27
Masterpiece 893	Pualam	65	46	31
Karya 280	Kaca	21	23	35
Masterpiece 465	Batu bata	12	100	28
Masterpiece 182	Kaca	59	99	48
Karya 654	Batu bata	52	27	80
Produk 777	Pualam	48	100	46
Masterpiece 320	Kaca	75	73	67
Masterpiece 775	Batu bata	74	24	7
Karya 823	Tanah liat	77	20	27
Produk 328	Batu bata	47	52	95
Produk 665	Plastisin	71	92	56
Produk 780	Pualam	96	88	36
Karya 510	Plastisin	53	58	35
Produk 573	Pualam	10	91	23
Karya 093	Batu bata	62	17	10
Karya 550	Kaca	30	24	80
Karya 191	Pualam	44	73	11
Karya 481	Kaca	22	20	57
Karya 946	Kaca	70	72	18
Karya 354	Plastisin	62	21	1
Karya 693	Batu bata	25	63	51
Karya 563	Kaca	19	24	65
Masterpiece 090	Plastisin	5	15	75
Produk 224	Pualam	85	72	59
Masterpiece 848	Pualam	95	42	75
Masterpiece 700	Plastisin	80	12	10
Produk 526	Tanah liat	54	99	85
Karya 967	Batu bata	42	66	53
Produk 050	Pualam	65	27	71
Karya 318	Pualam	34	70	19
Karya 077	Batu bata	98	62	5
Produk 483	Tanah liat	34	40	56
Produk 644	Batu bata	29	80	77
Karya 476	Plastisin	32	80	99
Produk 454	Batu bata	42	10	47
Karya 874	Plastisin	96	19	84
Produk 171	Batu bata	91	5	84
Produk 691	Pualam	97	3	61
Karya 024	Tanah liat	82	69	51
Karya 888	Pualam	27	1	79
Karya 633	Batu bata	19	76	38
Masterpiece 388	Plastisin	65	33	43
Masterpiece 420	Kaca	51	38	8
Karya 450	Batu bata	39	63	98
Produk 854	Plastisin	28	36	70
Masterpiece 784	Tanah liat	74	88	33
Karya 162	Pualam	11	47	89
Masterpiece 188	Kaca	59	86	46
Masterpiece 577	Batu bata	28	5	88
Masterpiece 219	Plastisin	68	72	38
Masterpiece 503	Batu bata	77	15	97
Karya 578	Tanah liat	91	49	74
Karya 390	Plastisin	92	80	1
Produk 777	Batu bata	20	28	54
Masterpiece 320	Tanah liat	97	71	67
Produk 952	Plastisin	37	24	46
Produk 394	Tanah liat	17	10	71
Produk 328	Tanah liat	91	87	27
Produk 665	Tanah liat	31	55	78
Produk 119	Pualam	15	67	56
Produk 118	Pualam	89	91	1
Karya 748	Tanah liat	80	55	14
Masterpiece 038	Batu bata	89	36	38
Produk 845	Tanah liat	37	3	18
Masterpiece 373	Batu bata	75	11	11
Karya 946	Tanah liat	35	9	71
Karya 368	Batu bata	30	15	71
Produk 678	Batu bata	33	36	86
Masterpiece 886	Batu bata	11	22	61
Karya 028	Batu bata	22	91	54
Masterpiece 848	Kaca	26	78	10
Produk 526	Batu bata	31	37	69
Masterpiece 837	Batu bata	42	51	22
Karya 318	Kaca	78	20	84
Produk 483	Kaca	50	42	76
Karya 662	Kaca	25	94	50
Karya 049	Plastisin	47	54	6
Masterpiece 006	Tanah liat	97	60	22
Produk 192	Batu bata	37	91	100
Karya 242	Plastisin	2	27	17
Karya 004	Batu bata	48	72	90
Produk 171	Tanah liat	22	17	59
Masterpiece 903	Pualam	28	1	8
Produk 514	Pualam	6	93	72
Karya 024	Batu bata	92	67	27
Karya 173	Plastisin	34	51	10
Produk 005	Pualam	98	14	94
Masterpiece 443	Batu bata	43	43	74
Masterpiece 896	Pualam	50	19	99
Masterpiece 381	Tanah liat	79	30	72
Karya 142	Batu bata	24	80	32
Karya 082	Pualam	90	6	32
Masterpiece 324	Kaca	70	33	64
Karya 795	Batu bata	63	48	78
Produk 490	Batu bata	49	8	12
Masterpiece 329	Kaca	29	5	52
Masterpiece 893	Tanah liat	85	77	16
Karya 363	Batu bata	91	3	68
Produk 203	Plastisin	41	79	7
Karya 578	Tanah liat	31	36	11
Masterpiece 989	Batu bata	57	46	41
Masterpiece 224	Batu bata	72	3	51
Karya 587	Pualam	63	10	84
Karya 897	Kaca	75	68	4
Produk 952	Kaca	18	40	40
Masterpiece 294	Batu bata	70	27	28
Karya 093	Tanah liat	96	83	40
Produk 416	Kaca	46	31	80
Masterpiece 613	Pualam	15	79	67
Masterpiece 038	Pualam	96	81	4
Produk 162	Plastisin	75	67	22
Produk 845	Plastisin	78	18	94
Produk 657	Plastisin	5	12	93
Masterpiece 629	Pualam	79	26	15
Karya 588	Tanah liat	51	9	40
Produk 678	Tanah liat	19	8	4
Masterpiece 886	Tanah liat	28	78	85
Karya 028	Batu bata	34	46	28
Produk 338	Batu bata	63	55	12
Masterpiece 658	Tanah liat	35	76	5
Karya 404	Tanah liat	61	38	81
Masterpiece 006	Plastisin	42	7	10
Karya 455	Plastisin	1	42	82
Masterpiece 971	Kaca	86	79	91
Karya 270	Kaca	47	79	83
Produk 786	Pualam	97	13	69
Karya 243	Tanah liat	90	74	2
Produk 005	Batu bata	42	99	67
Masterpiece 896	Tanah liat	28	63	6
Masterpiece 388	Plastisin	83	60	12
\.


--
-- Data for Name: seniman; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY seniman (nama_seniman, negara_asal) FROM stdin;
NICKI	Sweden
WES	Malta
CYRIL	Niger
CORDELIA	Nigeria
ROBT	Mali
TESSA	Denmark
STEPHAINE	East Timor
DEBBIE	Senegal
ALESHIA	Lebanon
ASHANTI	United Kingdom
ERLENE	Liberia
BIBI	Rwanda
MELVINA	Bulgaria
MARGE	Luxembourg
MAKEDA	Virgin Islands (U.S.)
AYAKO	Gibraltar
CLEMENTE	Central African Republic
CLYDE	Mayotte
EUN	Tunisia
WHITNEY	Germany
LINDSY	Comoros
TORI	Zambia
LAURENCE	Barbados
NATASHA	San Marino
COURTNEY	Guinea-Bissau
OLIN	Cambodia
BESS	Indonesia
MARTIN	Lesotho
LISSA	Saint Lucia
STACEY	Honduras
CHRISTIA	Seychelles
LEANNA	Syria
PRUDENCE	Mauritania
TAMICA	Greece
DOYLE	Cape Verde
SUSAN	Puerto Rico
CHRISTIE	Finland
AGRIPINA	Madagascar
KENNETH	Wallis and Futuna Islands
MAXIMO	Slovak Republic
CHRISSY	Anguilla
MITZI	Italy
EARL	Romania
PAT	Trinidad and Tobago
MINA	Bangladesh
CRISTI	Sao Tome and Principe
VITA	Uganda
CORALEE	Great Britain (UK)
MONIQUE	Latvia
NELDA	French Polynesia
DEJA	San Marino
JONIE	Morocco
TIFFANY	Guyana
ANGELO	Jordan
BRADLY	Bouvet Island
HYUN	Norfolk Island
GASTON	Netherlands
KYLEE	Solomon Islands
ROYCE	Hong Kong
SPENCER	Barbados
TAWNY	Poland
ANTIONETTE	Argentina
JC	Gambia
THERSA	China
DARLEEN	Japan
YVETTE	Guinea-Bissau
KELSIE	Niger
WALLY	Cape Verde
ERIN	Neutral Zone
BERNADETTE	Australia
MAJORIE	Haiti
BEBE	Turks and Caicos Islands
CRISTY	Kazakhstan
ARIEL	Saudi Arabia
MERVIN	Turkmenistan
ANISHA	India
VANESSA	Senegal
NOREEN	Cocos (Keeling) Islands
JUNIOR	Ecuador
ANNAMARIA	Lithuania
JAZMINE	Senegal
ANDREAS	Belize
FARAH	India
TREVOR	Guyana
DONN	Martinique
ALLYN	Panama
WILEY	Togo
ESTRELLA	Morocco
YASMINE	St. Helena
MAYME	Bhutan
PALMIRA	Macau
MARGRET	Hungary
CODI	Great Britain (UK)
MERRIE	Bouvet Island
TEODORA	Bhutan
JOANA	Austria
TISHA	Brazil
REMONA	Congo
PEGGY	Mexico
CHERIE	Thailand
ADENA	Aruba
TANISHA	Liberia
ZETTA	Turkmenistan
LIZZIE	Sri Lanka
VIOLETA	Sudan
MAMIE	Vanuatu
NICOLE	Mexico
ARACELI	Netherlands
CONCETTA	Netherlands
AGUSTIN	Tokelau
JOHANA	Pitcairn
KATELYNN	Bermuda
LOVETTA	Turkey
AMADO	Vanuatu
DERRICK	Cayman Islands
ALVERA	Malawi
CLEMENTINE	Monaco
DUANE	Namibia
CALEB	Bosnia and Herzegovina
MAGALI	Chile
KIRBY	Paraguay
LUISE	Romania
KENDALL	Tajikistan
ELDRIDGE	Virgin Islands (British)
MARYLN	San Marino
MITCHELL	Bhutan
DORCAS	Netherlands Antilles
LIANNE	New Zealand (Aotearoa)
RUTHIE	Nigeria
HEIDY	Korea (South)
DARA	Austria
TATUM	St. Pierre and Miquelon
GWENDOLYN	Afghanistan
HUGO	Yugoslavia
LILY	Equatorial Guinea
LAINE	Malta
LINH	Virgin Islands (British)
PARIS	S. Georgia and S. Sandwich Isls.
SHEILAH	Wallis and Futuna Islands
CLASSIE	Cuba
GARY	Dominican Republic
MARYALICE	Mali
CLEOTILDE	Guinea
ARNETTA	Ireland
GERTIE	United States
SHERIKA	Angola
ELYSE	Belgium
RICKY	Indonesia
FIDELIA	Saint Vincent and the Grenadines
MELODI	Italy
BEVERLY	Thailand
EHTEL	Korea (South)
PENNEY	Pitcairn
ARDIS	Azerbaijan
ZENA	Guinea
HERLINDA	East Timor
EMELINE	San Marino
DANIA	Tokelau
BRITTNEY	Belize
NELLA	Puerto Rico
MARCI	Slovak Republic
LANDON	Maldives
ISAAC	Belarus
GLADYS	Pakistan
CHANTAY	Paraguay
ELISE	Albania
JONATHAN	Switzerland
JACQUELYN	Guam
NICKIE	Liberia
ANITA	Congo
SHERI	Turkey
STEVIE	Iceland
JOHNA	Brunei Darussalam
ALEXANDRIA	Heard and McDonald Islands
JULE	American Samoa
HARLAND	Gibraltar
ZITA	Cayman Islands
DEMETRIA	Kuwait
WINNIFRED	Belize
RYANN	Philippines
CARITA	Liberia
PAMULA	Morocco
HAYLEY	New Caledonia
TREENA	Cyprus
MARGERY	Sudan
CLEMENT	Guam
KEISHA	Chad
SHAUNTA	Puerto Rico
BETTYANN	Mayotte
NANA	Zambia
TAMERA	Iceland
GINNY	Maldives
ROLAND	South Africa
ROBIN	Algeria
DEENA	S. Georgia and S. Sandwich Isls.
LATONIA	Burkina Faso
JOYA	Georgia
MAUD	S. Georgia and S. Sandwich Isls.
MARGENE	Saint Lucia
TARAH	Malawi
ELIZABETH	Spain
REID	Neutral Zone
LUISA	Slovak Republic
SEBRINA	Guatemala
GOLDA	Martinique
MARLENE	Greece
KELSI	Tuvalu
DAWNE	Belarus
JENETTE	Turkey
BETTYE	Portugal
RAYMON	Guyana
CHERYL	Hong Kong
TRACEE	Viet Nam
KAYLEEN	Eritrea
GAIL	Turks and Caicos Islands
HWA	Lesotho
SHARELL	Denmark
SHIRLY	Jordan
RICH	Puerto Rico
KRISTAL	Turkmenistan
EDNA	Samoa
EILEEN	Macau
GONZALO	Hong Kong
JONAS	Portugal
FREDRICKA	Cameroon
RUBEN	Netherlands
KARON	Switzerland
JUDIE	Myanmar
HOLLI	El Salvador
MARVIN	Vatican City State (Holy See)
TRINA	El Salvador
ANH	Malta
NETA	Tuvalu
RUSSEL	United States
MALLORY	French Polynesia
HAYDEE	Mali
TAWANA	Christmas Island
RYAN	Mali
LLOYD	Nauru
MABEL	United Kingdom
ALBA	Brunei Darussalam
PETE	Sao Tome and Principe
JANELL	Austria
LETITIA	Ecuador
VELDA	Uzbekistan
RAQUEL	Lithuania
MAURO	Costa Rica
SAMELLA	Burkina Faso
ISABELL	Micronesia
DEEANN	Macau
MAGDA	Tuvalu
CANDI	Samoa
ANNEMARIE	Congo
REFUGIO	Ireland
GRISELDA	St. Pierre and Miquelon
PHYLICIA	Saint Vincent and the Grenadines
ROSENDA	Northern Mariana Islands
TORA	Georgia
AUDRIE	Heard and McDonald Islands
CHERRYL	S. Georgia and S. Sandwich Isls.
GEMMA	American Samoa
ANGLA	Zaire
DEVORA	Germany
JUNKO	Netherlands Antilles
ELINOR	Chad
LYNNE	Turkey
WESTON	Chile
CHASIDY	United Arab Emirates
TRUDI	Indonesia
CARLEE	Uzbekistan
BRYANT	Liberia
HYE	Germany
GEORGIANNA	Ethiopia
CARLI	Svalbard and Jan Mayen Islands
ANIKA	Ghana
JOSHUA	Great Britain (UK)
ISELA	Zimbabwe
TOWANDA	French Polynesia
MARQUERITE	Belarus
LAURIE	Virgin Islands (U.S.)
LADY	Bosnia and Herzegovina
RICKEY	Sierra Leone
LATARSHA	Nepal
KELLY	Suriname
MARIN	Taiwan
ORPHA	Switzerland
JENE	Macedonia
REANNA	Afghanistan
LATINA	Northern Mariana Islands
MICHEL	Finland
CEDRICK	Canada
NICHELLE	Argentina
AILENE	Nigeria
DIANE	Nicaragua
ELEONOR	Greenland
GENNIE	Anguilla
MYRIAM	Tunisia
NOELIA	Switzerland
EFREN	Mauritania
CHANTELL	Kyrgyzstan
CORY	Zimbabwe
RICHELLE	Myanmar
BAMBI	Mali
LUANNA	Niue
MARYELLEN	Netherlands Antilles
GEORGIANN	Guam
TENNILLE	Yugoslavia
TAWANNA	Czechoslovakia (former)
WALTER	Mozambique
CARISSA	San Marino
LOU	United States
LOURA	Virgin Islands (U.S.)
ELOY	Laos
JENNIFER	Anguilla
ROCKY	Wallis and Futuna Islands
LELA	Saudi Arabia
WALDO	Peru
SHAROLYN	Guinea-Bissau
IONE	Argentina
MI	Bahamas
BLYTHE	Niger
NAPOLEON	Colombia
WILLY	Cyprus
ANDREA	S. Georgia and S. Sandwich Isls.
LEISA	Austria
DARCI	Singapore
JACLYN	Cote D'Ivoire (Ivory Coast)
LUCRETIA	Andorra
DIANNA	Maldives
MATHILDE	Sweden
SHEMIKA	Maldives
CHUN	Northern Mariana Islands
MARCELO	Kiribati
SHERITA	Rwanda
THERESIA	Guinea-Bissau
CHANDA	Norfolk Island
EDISON	Madagascar
GENARO	Denmark
DANNY	Jamaica
DEON	Bahamas
DELICIA	Benin
LATRISHA	Anguilla
JULIENNE	Sweden
CHANEL	Sudan
EMA	Christmas Island
LORRIANE	Northern Mariana Islands
YUONNE	Italy
DAVE	Zambia
GERARD	Gambia
YUKIKO	British Indian Ocean Territory
LEIA	Seychelles
TABETHA	Vatican City State (Holy See)
CELESTA	France
DIERDRE	Pakistan
JERMAINE	Iceland
SEAN	Palau
LITA	Lesotho
IVELISSE	Bouvet Island
MODESTO	Romania
EMILIO	Egypt
LAREE	Neutral Zone
CALVIN	Iraq
KASSIE	Cook Islands
ERICA	Cocos (Keeling) Islands
LIN	Slovak Republic
BETSY	Antigua and Barbuda
RUTH	Tajikistan
ROSANNA	Nepal
AURORE	Slovenia
ANIBAL	Liberia
TWILA	Morocco
TAKAKO	Algeria
KIA	Cocos (Keeling) Islands
MERRI	Zimbabwe
VANITA	New Zealand (Aotearoa)
RAVEN	Anguilla
THEO	Bulgaria
CALLIE	Benin
VELLA	Viet Nam
HERMELINDA	Albania
SHIRLEE	Tuvalu
TYREE	Saint Vincent and the Grenadines
KELLIE	Brazil
LEONIDA	Micronesia
CARMA	Neutral Zone
TWANNA	USSR (former)
HIEDI	Antarctica
LORINE	Pakistan
BRIANNA	Greenland
ALDO	Somalia
CONSTANCE	Chile
NOLAN	Paraguay
PEARLY	Samoa
CLAUDINE	American Samoa
WARREN	France
EMORY	Trinidad and Tobago
MARLINE	Saint Kitts and Nevis
JEANELLE	Hong Kong
MILISSA	Syria
TRACEY	Marshall Islands
RENATO	Austria
ANNIE	Iceland
RACHAL	East Timor
CAMMIE	Marshall Islands
LAWANNA	Myanmar
RUSSELL	Luxembourg
PHILOMENA	Antigua and Barbuda
ALETHIA	Mauritius
FLOR	Armenia
OMAR	Swaziland
JUDITH	Belgium
SCOTTIE	Jamaica
SUANNE	Niger
JAMISON	Angola
YER	Austria
CLAUDE	Greece
SELMA	Afghanistan
JOSPEH	China
DRUCILLA	Algeria
JAMA	Uruguay
PRESTON	Bosnia and Herzegovina
NORMAND	Japan
DONNIE	Djibouti
KIRA	Argentina
DESIREE	Palau
CAROLL	Faroe Islands
LAQUANDA	Sudan
AYANNA	Sierra Leone
ELLIOTT	Palau
HSIU	Germany
PURA	Zaire
BERNA	Germany
MARIO	Barbados
ROMELIA	Dominican Republic
JA	Syria
TOD	Fiji
MONNIE	Belgium
MARISSA	Togo
MAGNOLIA	Belize
DYLAN	Montserrat
STEPHNIE	Northern Mariana Islands
KENNA	Guam
AMY	Namibia
GLENN	Svalbard and Jan Mayen Islands
ANGELINA	Malaysia
MINTA	Swaziland
DEANGELO	Norway
TOMIKO	Virgin Islands (U.S.)
WINONA	Bouvet Island
HALEY	Togo
OLIVE	Finland
BERNARD	South Africa
ASLEY	Tanzania
MALCOLM	New Zealand (Aotearoa)
FARRAH	Rwanda
BURMA	Uruguay
HERMINE	Macau
SONYA	Uruguay
YOLANDA	Guinea
ELIDA	Czechoslovakia (former)
JACINDA	Botswana
SHAMIKA	Dominica
TAMEIKA	Ukraine
TELMA	Thailand
ROSANNE	Oman
ADRIANA	Congo
PERCY	Niue
WILBUR	France
JEANIE	Marshall Islands
GERTRUDE	Macau
SALLIE	Syria
MA	Heard and McDonald Islands
SHANICE	Virgin Islands (British)
FERMINA	Djibouti
FILIBERTO	Chile
LOREN	Micronesia
DOROTHA	Cook Islands
NIGEL	Lesotho
FLORINE	Suriname
JOHNETTA	China
JENNINE	France
CHANTAL	United Kingdom
FERN	Azerbaijan
LETHA	Kenya
VERNITA	French Polynesia
DOMINGA	Liberia
FELISHA	Western Sahara
LOREAN	South Africa
ILIANA	Netherlands Antilles
YOSHIKO	Jordan
CHARLA	Cape Verde
ADRIENNE	Kenya
CAROLYNN	Paraguay
VERLENE	Sri Lanka
LUCIANA	South Africa
WANITA	Italy
KEELY	S. Georgia and S. Sandwich Isls.
CARMELITA	British Indian Ocean Territory
ANGELICA	Netherlands Antilles
VON	Chad
\.


--
-- Name: benda_seni_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY benda_seni
    ADD CONSTRAINT benda_seni_pkey PRIMARY KEY (nama_benda_seni);


--
-- Name: pagelaran_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY pagelaran
    ADD CONSTRAINT pagelaran_pkey PRIMARY KEY (nama_pagelaran);


--
-- Name: seniman_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY seniman
    ADD CONSTRAINT seniman_pkey PRIMARY KEY (nama_seniman);


--
-- Name: benda_seni_nama_seniman_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY benda_seni
    ADD CONSTRAINT benda_seni_nama_seniman_fkey FOREIGN KEY (nama_seniman) REFERENCES seniman(nama_seniman);


--
-- Name: dipamerkan_nama_benda_seni_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY dipamerkan
    ADD CONSTRAINT dipamerkan_nama_benda_seni_fkey FOREIGN KEY (nama_benda_seni) REFERENCES benda_seni(nama_benda_seni);


--
-- Name: dipamerkan_nama_pagelaran_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY dipamerkan
    ADD CONSTRAINT dipamerkan_nama_pagelaran_fkey FOREIGN KEY (nama_pagelaran) REFERENCES pagelaran(nama_pagelaran);


--
-- Name: lukisan_nama_benda_seni_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY lukisan
    ADD CONSTRAINT lukisan_nama_benda_seni_fkey FOREIGN KEY (nama_benda_seni) REFERENCES benda_seni(nama_benda_seni);


--
-- Name: pahatan_nama_benda_seni_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pahatan
    ADD CONSTRAINT pahatan_nama_benda_seni_fkey FOREIGN KEY (nama_benda_seni) REFERENCES benda_seni(nama_benda_seni);


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

