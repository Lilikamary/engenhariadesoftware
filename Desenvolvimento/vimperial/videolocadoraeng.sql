PGDMP         /                w           videolocadoraeng    9.6.11    11.1 W    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false            �           1262    16393    videolocadoraeng    DATABASE     �   CREATE DATABASE videolocadoraeng WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Portuguese_Brazil.1252' LC_CTYPE = 'Portuguese_Brazil.1252';
     DROP DATABASE videolocadoraeng;
             postgres    false            �            1259    16394    cliente    TABLE     �   CREATE TABLE public.cliente (
    codcliente integer NOT NULL,
    nome text,
    cpf text,
    datanascimento text,
    email text,
    localtrabalho text,
    sexo text,
    endereco integer,
    ativo text,
    telefone text
);
    DROP TABLE public.cliente;
       public         postgres    false            �            1259    16400    cliente_codcliente_seq    SEQUENCE        CREATE SEQUENCE public.cliente_codcliente_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.cliente_codcliente_seq;
       public       postgres    false    185            �           0    0    cliente_codcliente_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.cliente_codcliente_seq OWNED BY public.cliente.codcliente;
            public       postgres    false    186            �            1259    16402 
   dependente    TABLE     �   CREATE TABLE public.dependente (
    coddependente integer NOT NULL,
    nome text,
    tipodependente text,
    email text,
    cliente integer
);
    DROP TABLE public.dependente;
       public         postgres    false            �            1259    16408    dependente_coddependente_seq    SEQUENCE     �   CREATE SEQUENCE public.dependente_coddependente_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 3   DROP SEQUENCE public.dependente_coddependente_seq;
       public       postgres    false    187            �           0    0    dependente_coddependente_seq    SEQUENCE OWNED BY     ]   ALTER SEQUENCE public.dependente_coddependente_seq OWNED BY public.dependente.coddependente;
            public       postgres    false    188            �            1259    16410    distribuidora    TABLE     �   CREATE TABLE public.distribuidora (
    coddistribuidora integer NOT NULL,
    razaosocial text,
    responsavel text,
    endereco integer,
    telefone text
);
 !   DROP TABLE public.distribuidora;
       public         postgres    false            �            1259    16416 "   distribuidora_coddistribuidora_seq    SEQUENCE     �   CREATE SEQUENCE public.distribuidora_coddistribuidora_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 9   DROP SEQUENCE public.distribuidora_coddistribuidora_seq;
       public       postgres    false    189            �           0    0 "   distribuidora_coddistribuidora_seq    SEQUENCE OWNED BY     i   ALTER SEQUENCE public.distribuidora_coddistribuidora_seq OWNED BY public.distribuidora.coddistribuidora;
            public       postgres    false    190            �            1259    16418    endereco    TABLE     �   CREATE TABLE public.endereco (
    codendereco integer NOT NULL,
    logradouro text,
    numero text,
    bairro text,
    cidade text,
    cep text
);
    DROP TABLE public.endereco;
       public         postgres    false            �            1259    16424    endereco_codendereco_seq    SEQUENCE     �   CREATE SEQUENCE public.endereco_codendereco_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public.endereco_codendereco_seq;
       public       postgres    false    191            �           0    0    endereco_codendereco_seq    SEQUENCE OWNED BY     U   ALTER SEQUENCE public.endereco_codendereco_seq OWNED BY public.endereco.codendereco;
            public       postgres    false    192            �            1259    16426    filme    TABLE     &  CREATE TABLE public.filme (
    codfilme integer NOT NULL,
    titulooriginal text,
    tituloportugues text,
    direcao text,
    genero text,
    paisproducao text,
    ano text,
    duracao text,
    sinopse text,
    distribuidora integer,
    quantidade integer,
    tipomidia integer
);
    DROP TABLE public.filme;
       public         postgres    false            �            1259    16432    filme_codfilme_seq    SEQUENCE     {   CREATE SEQUENCE public.filme_codfilme_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.filme_codfilme_seq;
       public       postgres    false    193            �           0    0    filme_codfilme_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.filme_codfilme_seq OWNED BY public.filme.codfilme;
            public       postgres    false    194            �            1259    16563    locacao    TABLE     �   CREATE TABLE public.locacao (
    codlocacao integer NOT NULL,
    cliente integer,
    datadevolucao date,
    datalocacao date,
    multa integer
);
    DROP TABLE public.locacao;
       public         postgres    false            �            1259    16572    locacao_codlocacao_seq    SEQUENCE        CREATE SEQUENCE public.locacao_codlocacao_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.locacao_codlocacao_seq;
       public       postgres    false    201            �           0    0    locacao_codlocacao_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.locacao_codlocacao_seq OWNED BY public.locacao.codlocacao;
            public       postgres    false    204            �            1259    16566    locacaoitem    TABLE       CREATE TABLE public.locacaoitem (
    codlocacaoitem integer NOT NULL,
    locacao integer,
    filme integer,
    valormulta double precision,
    valorlocacao double precision,
    valortotal double precision,
    datalocacaoitem date,
    datadevolucaoitem date
);
    DROP TABLE public.locacaoitem;
       public         postgres    false            �            1259    16578    locacaoitem_codlocacaoitem_seq    SEQUENCE     �   CREATE SEQUENCE public.locacaoitem_codlocacaoitem_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 5   DROP SEQUENCE public.locacaoitem_codlocacaoitem_seq;
       public       postgres    false    202            �           0    0    locacaoitem_codlocacaoitem_seq    SEQUENCE OWNED BY     a   ALTER SEQUENCE public.locacaoitem_codlocacaoitem_seq OWNED BY public.locacaoitem.codlocacaoitem;
            public       postgres    false    205            �            1259    16569 	   pagamento    TABLE     �   CREATE TABLE public.pagamento (
    codpagamento integer NOT NULL,
    locacao integer,
    valortotal double precision,
    tipopagamento integer,
    valorrecebido double precision,
    troco double precision
);
    DROP TABLE public.pagamento;
       public         postgres    false            �            1259    16584    pagamento_codpagamento_seq    SEQUENCE     �   CREATE SEQUENCE public.pagamento_codpagamento_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE public.pagamento_codpagamento_seq;
       public       postgres    false    203            �           0    0    pagamento_codpagamento_seq    SEQUENCE OWNED BY     Y   ALTER SEQUENCE public.pagamento_codpagamento_seq OWNED BY public.pagamento.codpagamento;
            public       postgres    false    206            �            1259    16434    telefone    TABLE     V   CREATE TABLE public.telefone (
    codtelefone integer NOT NULL,
    telefone text
);
    DROP TABLE public.telefone;
       public         postgres    false            �            1259    16440    telefone_codtelefone_seq    SEQUENCE     �   CREATE SEQUENCE public.telefone_codtelefone_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public.telefone_codtelefone_seq;
       public       postgres    false    195            �           0    0    telefone_codtelefone_seq    SEQUENCE OWNED BY     U   ALTER SEQUENCE public.telefone_codtelefone_seq OWNED BY public.telefone.codtelefone;
            public       postgres    false    196            �            1259    16530 	   tipomidia    TABLE     U   CREATE TABLE public.tipomidia (
    codmidia integer NOT NULL,
    tipomidia text
);
    DROP TABLE public.tipomidia;
       public         postgres    false            �            1259    16533    tipomidia_codmidia_seq    SEQUENCE        CREATE SEQUENCE public.tipomidia_codmidia_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.tipomidia_codmidia_seq;
       public       postgres    false    197            �           0    0    tipomidia_codmidia_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.tipomidia_codmidia_seq OWNED BY public.tipomidia.codmidia;
            public       postgres    false    198            �            1259    16551    tipopagamento    TABLE     e   CREATE TABLE public.tipopagamento (
    codtipopagamento integer NOT NULL,
    tipopagamento text
);
 !   DROP TABLE public.tipopagamento;
       public         postgres    false            �            1259    16554 "   tipopagamento_codtipopagamento_seq    SEQUENCE     �   CREATE SEQUENCE public.tipopagamento_codtipopagamento_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 9   DROP SEQUENCE public.tipopagamento_codtipopagamento_seq;
       public       postgres    false    199            �           0    0 "   tipopagamento_codtipopagamento_seq    SEQUENCE OWNED BY     i   ALTER SEQUENCE public.tipopagamento_codtipopagamento_seq OWNED BY public.tipopagamento.codtipopagamento;
            public       postgres    false    200                       2604    16442    cliente codcliente    DEFAULT     x   ALTER TABLE ONLY public.cliente ALTER COLUMN codcliente SET DEFAULT nextval('public.cliente_codcliente_seq'::regclass);
 A   ALTER TABLE public.cliente ALTER COLUMN codcliente DROP DEFAULT;
       public       postgres    false    186    185                       2604    16443    dependente coddependente    DEFAULT     �   ALTER TABLE ONLY public.dependente ALTER COLUMN coddependente SET DEFAULT nextval('public.dependente_coddependente_seq'::regclass);
 G   ALTER TABLE public.dependente ALTER COLUMN coddependente DROP DEFAULT;
       public       postgres    false    188    187                       2604    16444    distribuidora coddistribuidora    DEFAULT     �   ALTER TABLE ONLY public.distribuidora ALTER COLUMN coddistribuidora SET DEFAULT nextval('public.distribuidora_coddistribuidora_seq'::regclass);
 M   ALTER TABLE public.distribuidora ALTER COLUMN coddistribuidora DROP DEFAULT;
       public       postgres    false    190    189                       2604    16445    endereco codendereco    DEFAULT     |   ALTER TABLE ONLY public.endereco ALTER COLUMN codendereco SET DEFAULT nextval('public.endereco_codendereco_seq'::regclass);
 C   ALTER TABLE public.endereco ALTER COLUMN codendereco DROP DEFAULT;
       public       postgres    false    192    191                       2604    16446    filme codfilme    DEFAULT     p   ALTER TABLE ONLY public.filme ALTER COLUMN codfilme SET DEFAULT nextval('public.filme_codfilme_seq'::regclass);
 =   ALTER TABLE public.filme ALTER COLUMN codfilme DROP DEFAULT;
       public       postgres    false    194    193                       2604    16574    locacao codlocacao    DEFAULT     x   ALTER TABLE ONLY public.locacao ALTER COLUMN codlocacao SET DEFAULT nextval('public.locacao_codlocacao_seq'::regclass);
 A   ALTER TABLE public.locacao ALTER COLUMN codlocacao DROP DEFAULT;
       public       postgres    false    204    201                       2604    16580    locacaoitem codlocacaoitem    DEFAULT     �   ALTER TABLE ONLY public.locacaoitem ALTER COLUMN codlocacaoitem SET DEFAULT nextval('public.locacaoitem_codlocacaoitem_seq'::regclass);
 I   ALTER TABLE public.locacaoitem ALTER COLUMN codlocacaoitem DROP DEFAULT;
       public       postgres    false    205    202                       2604    16586    pagamento codpagamento    DEFAULT     �   ALTER TABLE ONLY public.pagamento ALTER COLUMN codpagamento SET DEFAULT nextval('public.pagamento_codpagamento_seq'::regclass);
 E   ALTER TABLE public.pagamento ALTER COLUMN codpagamento DROP DEFAULT;
       public       postgres    false    206    203                       2604    16447    telefone codtelefone    DEFAULT     |   ALTER TABLE ONLY public.telefone ALTER COLUMN codtelefone SET DEFAULT nextval('public.telefone_codtelefone_seq'::regclass);
 C   ALTER TABLE public.telefone ALTER COLUMN codtelefone DROP DEFAULT;
       public       postgres    false    196    195                       2604    16535    tipomidia codmidia    DEFAULT     x   ALTER TABLE ONLY public.tipomidia ALTER COLUMN codmidia SET DEFAULT nextval('public.tipomidia_codmidia_seq'::regclass);
 A   ALTER TABLE public.tipomidia ALTER COLUMN codmidia DROP DEFAULT;
       public       postgres    false    198    197                       2604    16556    tipopagamento codtipopagamento    DEFAULT     �   ALTER TABLE ONLY public.tipopagamento ALTER COLUMN codtipopagamento SET DEFAULT nextval('public.tipopagamento_codtipopagamento_seq'::regclass);
 M   ALTER TABLE public.tipopagamento ALTER COLUMN codtipopagamento DROP DEFAULT;
       public       postgres    false    200    199            �          0    16394    cliente 
   TABLE DATA                  COPY public.cliente (codcliente, nome, cpf, datanascimento, email, localtrabalho, sexo, endereco, ativo, telefone) FROM stdin;
    public       postgres    false    185   �a       �          0    16402 
   dependente 
   TABLE DATA               Y   COPY public.dependente (coddependente, nome, tipodependente, email, cliente) FROM stdin;
    public       postgres    false    187   b       �          0    16410    distribuidora 
   TABLE DATA               g   COPY public.distribuidora (coddistribuidora, razaosocial, responsavel, endereco, telefone) FROM stdin;
    public       postgres    false    189   9b       �          0    16418    endereco 
   TABLE DATA               X   COPY public.endereco (codendereco, logradouro, numero, bairro, cidade, cep) FROM stdin;
    public       postgres    false    191   Vb       �          0    16426    filme 
   TABLE DATA               �   COPY public.filme (codfilme, titulooriginal, tituloportugues, direcao, genero, paisproducao, ano, duracao, sinopse, distribuidora, quantidade, tipomidia) FROM stdin;
    public       postgres    false    193   sb       �          0    16563    locacao 
   TABLE DATA               Y   COPY public.locacao (codlocacao, cliente, datadevolucao, datalocacao, multa) FROM stdin;
    public       postgres    false    201   �b       �          0    16566    locacaoitem 
   TABLE DATA               �   COPY public.locacaoitem (codlocacaoitem, locacao, filme, valormulta, valorlocacao, valortotal, datalocacaoitem, datadevolucaoitem) FROM stdin;
    public       postgres    false    202   �b       �          0    16569 	   pagamento 
   TABLE DATA               k   COPY public.pagamento (codpagamento, locacao, valortotal, tipopagamento, valorrecebido, troco) FROM stdin;
    public       postgres    false    203   �b       �          0    16434    telefone 
   TABLE DATA               9   COPY public.telefone (codtelefone, telefone) FROM stdin;
    public       postgres    false    195   �b       �          0    16530 	   tipomidia 
   TABLE DATA               8   COPY public.tipomidia (codmidia, tipomidia) FROM stdin;
    public       postgres    false    197   c       �          0    16551    tipopagamento 
   TABLE DATA               H   COPY public.tipopagamento (codtipopagamento, tipopagamento) FROM stdin;
    public       postgres    false    199   !c       �           0    0    cliente_codcliente_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.cliente_codcliente_seq', 9, true);
            public       postgres    false    186            �           0    0    dependente_coddependente_seq    SEQUENCE SET     J   SELECT pg_catalog.setval('public.dependente_coddependente_seq', 3, true);
            public       postgres    false    188            �           0    0 "   distribuidora_coddistribuidora_seq    SEQUENCE SET     P   SELECT pg_catalog.setval('public.distribuidora_coddistribuidora_seq', 3, true);
            public       postgres    false    190            �           0    0    endereco_codendereco_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.endereco_codendereco_seq', 4, true);
            public       postgres    false    192            �           0    0    filme_codfilme_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.filme_codfilme_seq', 5, true);
            public       postgres    false    194            �           0    0    locacao_codlocacao_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.locacao_codlocacao_seq', 1, false);
            public       postgres    false    204            �           0    0    locacaoitem_codlocacaoitem_seq    SEQUENCE SET     M   SELECT pg_catalog.setval('public.locacaoitem_codlocacaoitem_seq', 1, false);
            public       postgres    false    205            �           0    0    pagamento_codpagamento_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public.pagamento_codpagamento_seq', 1, false);
            public       postgres    false    206            �           0    0    telefone_codtelefone_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.telefone_codtelefone_seq', 4, true);
            public       postgres    false    196            �           0    0    tipomidia_codmidia_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.tipomidia_codmidia_seq', 1, true);
            public       postgres    false    198            �           0    0 "   tipopagamento_codtipopagamento_seq    SEQUENCE SET     Q   SELECT pg_catalog.setval('public.tipopagamento_codtipopagamento_seq', 1, false);
            public       postgres    false    200            "           2606    16449    cliente pk_cliente 
   CONSTRAINT     X   ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT pk_cliente PRIMARY KEY (codcliente);
 <   ALTER TABLE ONLY public.cliente DROP CONSTRAINT pk_cliente;
       public         postgres    false    185            %           2606    16451    dependente pk_dependente 
   CONSTRAINT     a   ALTER TABLE ONLY public.dependente
    ADD CONSTRAINT pk_dependente PRIMARY KEY (coddependente);
 B   ALTER TABLE ONLY public.dependente DROP CONSTRAINT pk_dependente;
       public         postgres    false    187            (           2606    16453    distribuidora pk_distribuidora 
   CONSTRAINT     j   ALTER TABLE ONLY public.distribuidora
    ADD CONSTRAINT pk_distribuidora PRIMARY KEY (coddistribuidora);
 H   ALTER TABLE ONLY public.distribuidora DROP CONSTRAINT pk_distribuidora;
       public         postgres    false    189            *           2606    16455    endereco pk_endereco 
   CONSTRAINT     [   ALTER TABLE ONLY public.endereco
    ADD CONSTRAINT pk_endereco PRIMARY KEY (codendereco);
 >   ALTER TABLE ONLY public.endereco DROP CONSTRAINT pk_endereco;
       public         postgres    false    191            .           2606    16457    filme pk_filme 
   CONSTRAINT     R   ALTER TABLE ONLY public.filme
    ADD CONSTRAINT pk_filme PRIMARY KEY (codfilme);
 8   ALTER TABLE ONLY public.filme DROP CONSTRAINT pk_filme;
       public         postgres    false    193            2           2606    16544    tipomidia pk_midia 
   CONSTRAINT     V   ALTER TABLE ONLY public.tipomidia
    ADD CONSTRAINT pk_midia PRIMARY KEY (codmidia);
 <   ALTER TABLE ONLY public.tipomidia DROP CONSTRAINT pk_midia;
       public         postgres    false    197            0           2606    16459    telefone pk_telefone 
   CONSTRAINT     [   ALTER TABLE ONLY public.telefone
    ADD CONSTRAINT pk_telefone PRIMARY KEY (codtelefone);
 >   ALTER TABLE ONLY public.telefone DROP CONSTRAINT pk_telefone;
       public         postgres    false    195            #           1259    16501    fki_cliente    INDEX     E   CREATE INDEX fki_cliente ON public.dependente USING btree (cliente);
    DROP INDEX public.fki_cliente;
       public         postgres    false    187            +           1259    16529    fki_distribuidorafilme    INDEX     Q   CREATE INDEX fki_distribuidorafilme ON public.filme USING btree (distribuidora);
 *   DROP INDEX public.fki_distribuidorafilme;
       public         postgres    false    193                        1259    16489    fki_endereco    INDEX     D   CREATE INDEX fki_endereco ON public.cliente USING btree (endereco);
     DROP INDEX public.fki_endereco;
       public         postgres    false    185            &           1259    16699    fki_fk_enderecodistribuidora    INDEX     Z   CREATE INDEX fki_fk_enderecodistribuidora ON public.distribuidora USING btree (endereco);
 0   DROP INDEX public.fki_fk_enderecodistribuidora;
       public         postgres    false    189            ,           1259    16550    fki_fk_tipomidia    INDEX     G   CREATE INDEX fki_fk_tipomidia ON public.filme USING btree (tipomidia);
 $   DROP INDEX public.fki_fk_tipomidia;
       public         postgres    false    193            4           2606    16496    dependente fk_cliente    FK CONSTRAINT     ~   ALTER TABLE ONLY public.dependente
    ADD CONSTRAINT fk_cliente FOREIGN KEY (cliente) REFERENCES public.cliente(codcliente);
 ?   ALTER TABLE ONLY public.dependente DROP CONSTRAINT fk_cliente;
       public       postgres    false    185    2082    187            6           2606    16524    filme fk_distribuidorafilme    FK CONSTRAINT     �   ALTER TABLE ONLY public.filme
    ADD CONSTRAINT fk_distribuidorafilme FOREIGN KEY (distribuidora) REFERENCES public.distribuidora(coddistribuidora);
 E   ALTER TABLE ONLY public.filme DROP CONSTRAINT fk_distribuidorafilme;
       public       postgres    false    2088    189    193            3           2606    16484    cliente fk_endereco    FK CONSTRAINT        ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT fk_endereco FOREIGN KEY (endereco) REFERENCES public.endereco(codendereco);
 =   ALTER TABLE ONLY public.cliente DROP CONSTRAINT fk_endereco;
       public       postgres    false    185    191    2090            5           2606    16694 &   distribuidora fk_enderecodistribuidora    FK CONSTRAINT     �   ALTER TABLE ONLY public.distribuidora
    ADD CONSTRAINT fk_enderecodistribuidora FOREIGN KEY (endereco) REFERENCES public.endereco(codendereco);
 P   ALTER TABLE ONLY public.distribuidora DROP CONSTRAINT fk_enderecodistribuidora;
       public       postgres    false    2090    191    189            7           2606    16545    filme fk_tipomidia    FK CONSTRAINT     �   ALTER TABLE ONLY public.filme
    ADD CONSTRAINT fk_tipomidia FOREIGN KEY (tipomidia) REFERENCES public.tipomidia(codmidia) ON UPDATE CASCADE ON DELETE CASCADE;
 <   ALTER TABLE ONLY public.filme DROP CONSTRAINT fk_tipomidia;
       public       postgres    false    193    197    2098            �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �     