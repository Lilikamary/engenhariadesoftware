PGDMP         6                w           videolocadoraeng    9.6.11    11.1 :    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
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
    telefone integer
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
    telefone integer,
    endereco integer
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
            public       postgres    false    192            �            1259    16426    filme    TABLE     �   CREATE TABLE public.filme (
    codfilme integer NOT NULL,
    titulooriginal text,
    tituloportugues text,
    direcao text,
    genero text,
    paisproducao text,
    ano text,
    duracao text,
    sinopse text,
    distribuidora integer
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
            public       postgres    false    194            �            1259    16434    telefone    TABLE     V   CREATE TABLE public.telefone (
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
            public       postgres    false    196            �           2604    16442    cliente codcliente    DEFAULT     x   ALTER TABLE ONLY public.cliente ALTER COLUMN codcliente SET DEFAULT nextval('public.cliente_codcliente_seq'::regclass);
 A   ALTER TABLE public.cliente ALTER COLUMN codcliente DROP DEFAULT;
       public       postgres    false    186    185            �           2604    16443    dependente coddependente    DEFAULT     �   ALTER TABLE ONLY public.dependente ALTER COLUMN coddependente SET DEFAULT nextval('public.dependente_coddependente_seq'::regclass);
 G   ALTER TABLE public.dependente ALTER COLUMN coddependente DROP DEFAULT;
       public       postgres    false    188    187            �           2604    16444    distribuidora coddistribuidora    DEFAULT     �   ALTER TABLE ONLY public.distribuidora ALTER COLUMN coddistribuidora SET DEFAULT nextval('public.distribuidora_coddistribuidora_seq'::regclass);
 M   ALTER TABLE public.distribuidora ALTER COLUMN coddistribuidora DROP DEFAULT;
       public       postgres    false    190    189            �           2604    16445    endereco codendereco    DEFAULT     |   ALTER TABLE ONLY public.endereco ALTER COLUMN codendereco SET DEFAULT nextval('public.endereco_codendereco_seq'::regclass);
 C   ALTER TABLE public.endereco ALTER COLUMN codendereco DROP DEFAULT;
       public       postgres    false    192    191            �           2604    16446    filme codfilme    DEFAULT     p   ALTER TABLE ONLY public.filme ALTER COLUMN codfilme SET DEFAULT nextval('public.filme_codfilme_seq'::regclass);
 =   ALTER TABLE public.filme ALTER COLUMN codfilme DROP DEFAULT;
       public       postgres    false    194    193            �           2604    16447    telefone codtelefone    DEFAULT     |   ALTER TABLE ONLY public.telefone ALTER COLUMN codtelefone SET DEFAULT nextval('public.telefone_codtelefone_seq'::regclass);
 C   ALTER TABLE public.telefone ALTER COLUMN codtelefone DROP DEFAULT;
       public       postgres    false    196    195            �          0    16394    cliente 
   TABLE DATA               x   COPY public.cliente (codcliente, nome, cpf, datanascimento, email, localtrabalho, sexo, endereco, telefone) FROM stdin;
    public       postgres    false    185   }A       �          0    16402 
   dependente 
   TABLE DATA               Y   COPY public.dependente (coddependente, nome, tipodependente, email, cliente) FROM stdin;
    public       postgres    false    187   �A       �          0    16410    distribuidora 
   TABLE DATA               g   COPY public.distribuidora (coddistribuidora, razaosocial, responsavel, telefone, endereco) FROM stdin;
    public       postgres    false    189   �A       �          0    16418    endereco 
   TABLE DATA               X   COPY public.endereco (codendereco, logradouro, numero, bairro, cidade, cep) FROM stdin;
    public       postgres    false    191   �A       �          0    16426    filme 
   TABLE DATA               �   COPY public.filme (codfilme, titulooriginal, tituloportugues, direcao, genero, paisproducao, ano, duracao, sinopse, distribuidora) FROM stdin;
    public       postgres    false    193   MB       �          0    16434    telefone 
   TABLE DATA               9   COPY public.telefone (codtelefone, telefone) FROM stdin;
    public       postgres    false    195   jB       �           0    0    cliente_codcliente_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.cliente_codcliente_seq', 6, true);
            public       postgres    false    186            �           0    0    dependente_coddependente_seq    SEQUENCE SET     J   SELECT pg_catalog.setval('public.dependente_coddependente_seq', 2, true);
            public       postgres    false    188            �           0    0 "   distribuidora_coddistribuidora_seq    SEQUENCE SET     P   SELECT pg_catalog.setval('public.distribuidora_coddistribuidora_seq', 2, true);
            public       postgres    false    190            �           0    0    endereco_codendereco_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.endereco_codendereco_seq', 3, true);
            public       postgres    false    192            �           0    0    filme_codfilme_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.filme_codfilme_seq', 4, true);
            public       postgres    false    194            �           0    0    telefone_codtelefone_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.telefone_codtelefone_seq', 4, true);
            public       postgres    false    196            �           2606    16449    cliente pk_cliente 
   CONSTRAINT     X   ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT pk_cliente PRIMARY KEY (codcliente);
 <   ALTER TABLE ONLY public.cliente DROP CONSTRAINT pk_cliente;
       public         postgres    false    185                       2606    16451    dependente pk_dependente 
   CONSTRAINT     a   ALTER TABLE ONLY public.dependente
    ADD CONSTRAINT pk_dependente PRIMARY KEY (coddependente);
 B   ALTER TABLE ONLY public.dependente DROP CONSTRAINT pk_dependente;
       public         postgres    false    187                       2606    16453    distribuidora pk_distribuidora 
   CONSTRAINT     j   ALTER TABLE ONLY public.distribuidora
    ADD CONSTRAINT pk_distribuidora PRIMARY KEY (coddistribuidora);
 H   ALTER TABLE ONLY public.distribuidora DROP CONSTRAINT pk_distribuidora;
       public         postgres    false    189                       2606    16455    endereco pk_endereco 
   CONSTRAINT     [   ALTER TABLE ONLY public.endereco
    ADD CONSTRAINT pk_endereco PRIMARY KEY (codendereco);
 >   ALTER TABLE ONLY public.endereco DROP CONSTRAINT pk_endereco;
       public         postgres    false    191            
           2606    16457    filme pk_filme 
   CONSTRAINT     R   ALTER TABLE ONLY public.filme
    ADD CONSTRAINT pk_filme PRIMARY KEY (codfilme);
 8   ALTER TABLE ONLY public.filme DROP CONSTRAINT pk_filme;
       public         postgres    false    193                       2606    16459    telefone pk_telefone 
   CONSTRAINT     [   ALTER TABLE ONLY public.telefone
    ADD CONSTRAINT pk_telefone PRIMARY KEY (codtelefone);
 >   ALTER TABLE ONLY public.telefone DROP CONSTRAINT pk_telefone;
       public         postgres    false    195            �           1259    16501    fki_cliente    INDEX     E   CREATE INDEX fki_cliente ON public.dependente USING btree (cliente);
    DROP INDEX public.fki_cliente;
       public         postgres    false    187                       1259    16529    fki_distribuidorafilme    INDEX     Q   CREATE INDEX fki_distribuidorafilme ON public.filme USING btree (distribuidora);
 *   DROP INDEX public.fki_distribuidorafilme;
       public         postgres    false    193            �           1259    16489    fki_endereco    INDEX     D   CREATE INDEX fki_endereco ON public.cliente USING btree (endereco);
     DROP INDEX public.fki_endereco;
       public         postgres    false    185                       1259    16523    fki_enderecodistribuidora    INDEX     W   CREATE INDEX fki_enderecodistribuidora ON public.distribuidora USING btree (endereco);
 -   DROP INDEX public.fki_enderecodistribuidora;
       public         postgres    false    189            �           1259    16495    fki_telefone    INDEX     D   CREATE INDEX fki_telefone ON public.cliente USING btree (telefone);
     DROP INDEX public.fki_telefone;
       public         postgres    false    185                       1259    16517    fki_telefonedistribuidora    INDEX     W   CREATE INDEX fki_telefonedistribuidora ON public.distribuidora USING btree (telefone);
 -   DROP INDEX public.fki_telefonedistribuidora;
       public         postgres    false    189                       2606    16496    dependente fk_cliente    FK CONSTRAINT     ~   ALTER TABLE ONLY public.dependente
    ADD CONSTRAINT fk_cliente FOREIGN KEY (cliente) REFERENCES public.cliente(codcliente);
 ?   ALTER TABLE ONLY public.dependente DROP CONSTRAINT fk_cliente;
       public       postgres    false    185    2046    187                       2606    16524    filme fk_distribuidorafilme    FK CONSTRAINT     �   ALTER TABLE ONLY public.filme
    ADD CONSTRAINT fk_distribuidorafilme FOREIGN KEY (distribuidora) REFERENCES public.distribuidora(coddistribuidora);
 E   ALTER TABLE ONLY public.filme DROP CONSTRAINT fk_distribuidorafilme;
       public       postgres    false    193    189    2053                       2606    16484    cliente fk_endereco    FK CONSTRAINT        ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT fk_endereco FOREIGN KEY (endereco) REFERENCES public.endereco(codendereco);
 =   ALTER TABLE ONLY public.cliente DROP CONSTRAINT fk_endereco;
       public       postgres    false    2055    191    185                       2606    16518 &   distribuidora fk_enderecodistribuidora    FK CONSTRAINT     �   ALTER TABLE ONLY public.distribuidora
    ADD CONSTRAINT fk_enderecodistribuidora FOREIGN KEY (endereco) REFERENCES public.endereco(codendereco);
 P   ALTER TABLE ONLY public.distribuidora DROP CONSTRAINT fk_enderecodistribuidora;
       public       postgres    false    2055    191    189                       2606    16490    cliente fk_telefone    FK CONSTRAINT        ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT fk_telefone FOREIGN KEY (telefone) REFERENCES public.telefone(codtelefone);
 =   ALTER TABLE ONLY public.cliente DROP CONSTRAINT fk_telefone;
       public       postgres    false    195    2060    185                       2606    16512 &   distribuidora fk_telefonedistribuidora    FK CONSTRAINT     �   ALTER TABLE ONLY public.distribuidora
    ADD CONSTRAINT fk_telefonedistribuidora FOREIGN KEY (telefone) REFERENCES public.telefone(codtelefone);
 P   ALTER TABLE ONLY public.distribuidora DROP CONSTRAINT fk_telefonedistribuidora;
       public       postgres    false    189    2060    195            �   4   x�3�L�H�H�L��I�J��N��I�J��R�@��� /�ӘӘ+F��� ~�      �      x������ � �      �      x������ � �      �   B   x�3�*MT04�"�Լ��|N���ĤDNs �2�)055�t��/�H�M��9���,F��� Q�      �      x������ � �      �      x�3�46333474�2A0c���� A�v     