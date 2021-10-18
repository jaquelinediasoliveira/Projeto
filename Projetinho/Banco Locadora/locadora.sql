drop database Locadora;
create database Locadora charest=UTF8 collate utf8_general-ci;
use Locadora;

create table Cliente(
    cpf_passaporte varchar(11) integer primary key auto_increment,
    nome_completo varchar(60) not null,
    cep varchar(8) not null,
    email varchar (50) not null,
    data_nascimento Date not null,
);

create table Telefone(
    cpf integer not null,
    telefone varchar(15) not null,
    constraint fkTeleCli foreingn key (cpf) references Cliente (cpf)
    on delete cascade 
);

create table Habilitação(
    cpf_passaporte varchar(11) integer primary key auto_increment,
    habilitação varchar(12) not null
);

create table Filiais(
     id_loja integer primary key auto_increment,
     cep varchar (8)
);

create table Tipos(
    id_tipo integer primary key auto_increment,
    tipo varchar (10) not null
);

create table Carros(
    id_tipo integer primary key auto_increment,
    marca varchar(20) not null,
    modelo varchar(20) not null,
    cor varchar(10) not null,
    preco decimal(5,2) not null
);

create table Motos(
    id_tipo integer primary key auto_increment,
    marca varchar(20) not null,
    modelo varchar(20) not null,
    cor varchar(10) not null,
    preco decimal(5,2) not null
);

create table Caminhões(
    id_tipo integer primary key auto_increment,
    marca varchar(20) not null,
    modelo varchar(20) not null,
    cor varchar(10) not null,
    preco decimal(5,2) not null
);

create table Jatos(
    id_tipo integer primary key auto_increment,
    marca varchar(20) not null,
    modelo varchar(20) not null,
    cor varchar(10) not null,
    preco decimal(5,2) not null
);

create table Helicópteros(
    id_tipo integer primary key auto_increment,
    marca varchar(20) not null,
    modelo varchar(20) not null,
    cor varchar(10) not null,
    preco decimal(5,2) not null
);

create table Lanchas(
    id_tipo integer primary key auto_increment,
    marca varchar(20) not null,
    modelo varchar(20) not null,
    cor varchar(10) not null,
    preco decimal(5,2) not null
);

create table Jet ski(
    id_tipo integer primary key auto_increment,
    marca varchar(20) not null,
    modelo varchar(20) not null,
    cor varchar(10) not null,
    preco decimal(5,2) not null
);

create table Iates(
    id_tipo integer primary key auto_increment,
    marca varchar(20) not null,
    modelo varchar(20) not null,
    cor varchar(10) not null,
    preco decimal(5,2) not null
);

show tables;

-- Comandos DML para alimentar o banco de dados com registros

insert into Cliente(cpf_passaporte, nome_completo, endereço, email, data_nascimento) values("004.064.645-96","Sebastiana Patrícia Gonçalves","65903-210","ssebastianapatriciagoncalves@technocut.com.br","21\10\1945");
insert into Cliente(cpf_passaporte, nome_completo, endereço, email, data_nascimento) values("925.738.560-46","Simone Juliana Lopes","79004-570","ssimonejulianalopes@selaz.com.br","05\08\1949");
insert into Cliente(cpf_passaporte, nome_completo, endereço, email, data_nascimento) values("716.346.886-51","Giovana Elza dos Santos","40352-100","giovanaelzadossantos-92@apso.org.br","08\06\1978");
insert into Cliente(cpf_passaporte, nome_completo, endereço, email, data_nascimento) values("762.917.854-98","Rosângela Kamilly Caldeira","72425-093","rosangelakamillycaldeira..rosangelakamillycaldeira@vgl.com.br","25\09\1983");
insert into Cliente(cpf_passaporte, nome_completo, endereço, email, data_nascimento) values("499.108.990-51","Antonio Luiz Carlos Eduardo Teixeira","69902-136","antonioluizcarloseduardoteixeira__antonioluizcarloseduardoteixeira@sodexo.com","27\09\1946");
insert into Cliente(cpf_passaporte, nome_completo, endereço, email, data_nascimento) values("598.741.852-60","Danilo Giovanni Figueiredo","76876-088","danilogiovannifigueiredo__danilogiovannifigueiredo@ruilacos.com.br","11\10\1948");
insert into Cliente(cpf_passaporte, nome_completo, endereço, email, data_nascimento) values("216.886.773-99","Cauã Diogo Mendes","87103-272","cauadiogomendes..cauadiogomendes@mabeitex.com.br","02\03\1960");
insert into Cliente(cpf_passaporte, nome_completo, endereço, email, data_nascimento) values("183.711.623-75","Adriana Carolina Jesus","28633-480","adrianacarolinajesus__adrianacarolinajesus@mirafactoring.com.br","01\08\2003");
insert into Cliente(cpf_passaporte, nome_completo, endereço, email, data_nascimento) values("399.769.297-14","Nicole Tereza Camila Souza","85813-490","nnicoleterezacamilasouza@mailinator.com","23\04\1999");
insert into Cliente(cpf_passaporte, nome_completo, endereço, email, data_nascimento) values("113.187.729-23","Carolina Natália Aparício","77829-058","carolinanataliaaparicio_@skyzepp.com","20\05\1959");
insert into Cliente(cpf_passaporte, nome_completo, endereço, email, data_nascimento) values("829.886.906-00","Filipe Thiago da Silva","57604-105","ffilipethiagodasilva@accent.com.br","02\10\1995");
insert into Cliente(cpf_passaporte, nome_completo, endereço, email, data_nascimento) values("450.249.658-84","Fábio Bruno Tomás da Mota","29705-740","fabiobrunotomasdamota-75@zipmail.com.br","04\08\1945");
insert into Cliente(cpf_passaporte, nome_completo, endereço, email, data_nascimento) values("695.898.588-56","Benício Anderson Lorenzo da Rosa","29052-608","bbenicioandersonlorenzodarosa@nhrtaxiaereo.com","26\10\1973");
insert into Cliente(cpf_passaporte, nome_completo, endereço, email, data_nascimento) values("519.559.298-58","Carolina Esther Bárbara Souza","08750-350","carolinaestherbarbarasouza..carolinaestherbarbarasouza@estadao.com.br","22\09\1959");
insert into Cliente(cpf_passaporte, nome_completo, endereço, email, data_nascimento) values("103.712.316-63","Julia Adriana Tânia Corte Real","88161-362","juliaadrianataniacortereal-76@fertility.com.br","04\09\2003");
insert into Cliente(cpf_passaporte, nome_completo, endereço, email, data_nascimento) values("601.627.915-34","Elza Aline Mariane Assunção","64009-480","elzaalinemarianeassuncao-83@mabeitex.com.br","26\03\1979");
insert into Cliente(cpf_passaporte, nome_completo, endereço, email, data_nascimento) values("301.559.494-03","Clara Marli da Conceição","72880-616","claramarlidaconceicao_@bighost.com.br","05\03\1981");
insert into Cliente(cpf_passaporte, nome_completo, endereço, email, data_nascimento) values("069.079.276-08","Isaac Daniel Brito","88805-075","isaacdanielbrito__isaacdanielbrito@callan.com.br","03\12\1946");

insert into Carros(id_tipo, marca, modelo, cor, preco) values("1","Daewoo","Nubira CDX 2.0 16V Aut.","Vermelho","150,00");
insert into Carros(id_tipo, marca, modelo, cor, preco) values("1","Lexus","CT200h  1.8 16V HIBRID Aut.","Bege","150,00");
insert into Carros(id_tipo, marca, modelo, cor, preco) values("1","Miura","Picape BG-Truck CD Turbo Diesel","Amarelo","150,00");
insert into Carros(id_tipo, marca, modelo, cor, preco) values("1","Matra","Pick-Up CD 4x4 Curto/Longo 2.5 TDI Dies.","Cinza","150,00");
insert into Carros(id_tipo, marca, modelo, cor, preco) values("1","VW - VolksWagen","Fox PRIME/Hghi. IMOTION 1.6 T.Flex 8V 5p","Vermelho","150,00");
insert into Carros(id_tipo, marca, modelo, cor, preco) values("1","Cross Lander","CL-330 2.8 132cv 4x4 TB Int. Diesel","Vermelho","150,00");
insert into Carros(id_tipo, marca, modelo, cor, preco) values("1","Matra","Pick-Up CD 4x2 Curto/Longo 2.5 TDI Dies.","Azul","150,00");
insert into Carros(id_tipo, marca, modelo, cor, preco) values("1","Volvo","V70 R 2.5 300cv AWD Mec.","Azul","150,00");
insert into Carros(id_tipo, marca, modelo, cor, preco) values("1","Agrale","MARRU","Laranja","150,00");
insert into Carros(id_tipo, marca, modelo, cor, preco) values("1","Fyber","Buggy 2000W 1.6 8V","Marrom","150,00");
insert into Carros(id_tipo, marca, modelo, cor, preco) values("1","Hyundai","i30 Serie Limitada 1.8 16V Aut. 5p","Marrom","150,00");
insert into Carros(id_tipo, marca, modelo, cor, preco) values("1","Saab","9000 CD 2.3 Turbo","Verde","150,00");
insert into Carros(id_tipo, marca, modelo, cor, preco) values("1","HAFEI","Towner Passageiro 1.0 8V 48cv 7L 5p","Azul","150,00");
insert into Carros(id_tipo, marca, modelo, cor, preco) values("1","Hyundai","Sonata GLS 2.7 V6 24V 179cv 4p Aut.","Amarelo","150,00");
insert into Carros(id_tipo, marca, modelo, cor, preco) values("1","Rolls-Royce","Phantom 6.7 V12 Aut.","Prata","150,00");

insert into Motos(id_tipo, marca, modelo, cor, preco) values("1","Honda","CG 150","Prata","100,00");
insert into Motos(id_tipo, marca, modelo, cor, preco) values("1","Honda","CG 125","Vermelha","100,00");
insert into Motos(id_tipo, marca, modelo, cor, preco) values("1","Honda","Biz","Preta","100,00");
insert into Motos(id_tipo, marca, modelo, cor, preco) values("1","Honda","NXR 150","Laranja","100,00");
insert into Motos(id_tipo, marca, modelo, cor, preco) values("1","Honda","Pop 100","Azul","100,00");
insert into Motos(id_tipo, marca, modelo, cor, preco) values("1","Yamaha","YBR 125","Cinza","100,00");
insert into Motos(id_tipo, marca, modelo, cor, preco) values("1","Honda","CB 300R","Amarela","100,00");
insert into Motos(id_tipo, marca, modelo, cor, preco) values("1","Honda ","XRE 300","Branca","100,00");
insert into Motos(id_tipo, marca, modelo, cor, preco) values("1","Yamaha","Fazer 250","Prata","100,00");
insert into Motos(id_tipo, marca, modelo, cor, preco) values("1","Yamaha","T115 Crypton","Verde","100,00");
insert into Motos(id_tipo, marca, modelo, cor, preco) values("1","Honda","Lead 110","Cinza","100,00");
insert into Motos(id_tipo, marca, modelo, cor, preco) values("1","Yamaha ","XTZ 125","Roxa","100,00");
insert into Motos(id_tipo, marca, modelo, cor, preco) values("1","Yamaha"," XTZ 250","Rosa","100,00");
insert into Motos(id_tipo, marca, modelo, cor, preco) values("1","Suzuki","Intruder 125","Azul","100,00");
insert into Motos(id_tipo, marca, modelo, cor, preco) values("1","Dafra","Riva 150","Vermelho","100,00");

insert into Caminhões(id_tipo, marca, modelo, cor, preco) values("1","Volvo","FH 540","Azul","200,00");
insert into Caminhões(id_tipo, marca, modelo, cor, preco) values("1","Scania","R450","Preto","200,00");
insert into Caminhões(id_tipo, marca, modelo, cor, preco) values("1","DAF","XF","Prata","200,00");
insert into Caminhões(id_tipo, marca, modelo, cor, preco) values("1","Volvo","FH 460 ","Cinza","200,00");
insert into Caminhões(id_tipo, marca, modelo, cor, preco) values("1","Mercedes-Benz","Actros 2651","Vermelho","200,00");
insert into Caminhões(id_tipo, marca, modelo, cor, preco) values("1","DAF","XF 105 510","Azul","200,00");
insert into Caminhões(id_tipo, marca, modelo, cor, preco) values("1","Scania","R 500","Marrom","200,00");
insert into Caminhões(id_tipo, marca, modelo, cor, preco) values("1","Mercedes-Benz","Actros 2546","Roxo","200,00");
insert into Caminhões(id_tipo, marca, modelo, cor, preco) values("1","Mercedes-Benz","Axor 2544","Laranja","200,00");
insert into Caminhões(id_tipo, marca, modelo, cor, preco) values("1","Mercedes-Benz","Axor 3344","Verde","200,00");
insert into Caminhões(id_tipo, marca, modelo, cor, preco) values("1","Volvo","FH 500","Bege","200,00");
insert into Caminhões(id_tipo, marca, modelo, cor, preco) values("1","Volkswagen","Meteor","Prata","200,00");
insert into Caminhões(id_tipo, marca, modelo, cor, preco) values("1","DAF"," XF105 Super Space","Amarelo","200,00");
insert into Caminhões(id_tipo, marca, modelo, cor, preco) values("1","Iveco","Hi-Way","Vermelho","200,00");
insert into Caminhões(id_tipo, marca, modelo, cor, preco) values("1","Volkswagen","MAN TGX 29480","Rosa","200,00");

insert into Jatos(id_tipo, marca, modelo, cor, preco) values("2","Embraer","Praetor 500/600","Branco","1000,00");
insert into Jatos(id_tipo, marca, modelo, cor, preco) values("2","Dassault","Falcon 2000","Preto","1000,00");
insert into Jatos(id_tipo, marca, modelo, cor, preco) values("2","Cessna","Citation Longitude","Cinza","1000,00");
insert into Jatos(id_tipo, marca, modelo, cor, preco) values("2","Gulfstream Aerospace","Gulfstream G550","Prata","1000,00");
insert into Jatos(id_tipo, marca, modelo, cor, preco) values("2","Bombarbier Aerospace","Global 6000","Azul","1000,00");
insert into Jatos(id_tipo, marca, modelo, cor, preco) values("2","Dassault","Falcon 8X","Roxo","1000,00");
insert into Jatos(id_tipo, marca, modelo, cor, preco) values("2","Bombardier Aerospace","Global 6500","Vermelho","1000,00");
insert into Jatos(id_tipo, marca, modelo, cor, preco) values("2","Gulfstream","Gulfstream G700","Amarela","1000,00");
insert into Jatos(id_tipo, marca, modelo, cor, preco) values("2","Bombardier Aerospace"," Global 7500","Rosa","1000,00");
insert into Jatos(id_tipo, marca, modelo, cor, preco) values("2","Cessna","Citation X+","Dourado","1000,00");

insert into Helicópteros(id_tipo, marca, modelo, cor, preco) values("2","Aero Products","A-3","Prata","800,00");
insert into Helicópteros(id_tipo, marca, modelo, cor, preco) values("2","Aero Products","A-1","Preto","800,00");
insert into Helicópteros(id_tipo, marca, modelo, cor, preco) values("2","Aero","HC-2 Heli Baby-COMBAT","Cinza","800,00");
insert into Helicópteros(id_tipo, marca, modelo, cor, preco) values("2","Aero","HC-3","Branco","800,00");
insert into Helicópteros(id_tipo, marca, modelo, cor, preco) values("2","Aero","HC-4","Roxo","800,00");
insert into Helicópteros(id_tipo, marca, modelo, cor, preco) values("2","Brantly","B-1","Dourado","800,00");
insert into Helicópteros(id_tipo, marca, modelo, cor, preco) values("2","Cicaré","CH-16","Verde","800,00");
insert into Helicópteros(id_tipo, marca, modelo, cor, preco) values("2","Denel","(Atlas) Rooivalk","Amarelo","800,00");
insert into Helicópteros(id_tipo, marca, modelo, cor, preco) values("2","GKN","Westland Sea King","Azul","800,00");
insert into Helicópteros(id_tipo, marca, modelo, cor, preco) values("2","Kamov","Ka-226","Roxo","800,00");

insert into Lanchas(id_tipo, marca, modelo, cor, preco) values("3","Fibrafort","Focker 215","Prata","700,00");
insert into Lanchas(id_tipo, marca, modelo, cor, preco) values("3","Fibrafort","Focker 280","Branco","700,00");
insert into Lanchas(id_tipo, marca, modelo, cor, preco) values("3","Cimitarra","Cimitarra 340","Preto","700,00");
insert into Lanchas(id_tipo, marca, modelo, cor, preco) values("3","Schaefer Yachts"," Phantom 300","Cinza","700,00");
insert into Lanchas(id_tipo, marca, modelo, cor, preco) values("3","Fibrafort"," Focker 255","Bege","700,00");
insert into Lanchas(id_tipo, marca, modelo, cor, preco) values("3","Carbrasmar","Carbrasmar 32","Amarelo","700,00");
insert into Lanchas(id_tipo, marca, modelo, cor, preco) values("3","Ferretti"," Ferretti 530","Vermelho","700,00");
insert into Lanchas(id_tipo, marca, modelo, cor, preco) values("3","Schaefer Yachts","Phantom 290","Azul","700,00");
insert into Lanchas(id_tipo, marca, modelo, cor, preco) values("3","Brunswick Group","Bayliner 310","Rosa","700,00");
insert into Lanchas(id_tipo, marca, modelo, cor, preco) values("3","Intermarine","Intermarine 42","Dourado","700,00");

insert into Jet ski(id_tipo, marca, modelo, cor, preco) values("3","Seadoo","GTX 215","Preto","500,00");
insert into Jet ski(id_tipo, marca, modelo, cor, preco) values("3","Seadoo","GTI 130","Cinza","500,00");
insert into Jet ski(id_tipo, marca, modelo, cor, preco) values("3","Honda","Aquatrax","Branca","500,00");
insert into Jet ski(id_tipo, marca, modelo, cor, preco) values("3","Kawasaki"," 800 SX-R","Verde","500,00");
insert into Jet ski(id_tipo, marca, modelo, cor, preco) values("3","Seadoo","RXT-X","Laranja","500,00");
insert into Jet ski(id_tipo, marca, modelo, cor, preco) values("3","Yamaha","Waverunner FZ R","Vermelho","500,00");
insert into Jet ski(id_tipo, marca, modelo, cor, preco) values("3","Yamaha","Waverunner VX R","Roxo","500,00");
insert into Jet ski(id_tipo, marca, modelo, cor, preco) values("3","Yamaha","FX Cruiser SHO","Rosa","500,00");
insert into Jet ski(id_tipo, marca, modelo, cor, preco) values("3","Kawasaki","300 LX Ultra","Verde-Limão","500,00");
insert into Jet ski(id_tipo, marca, modelo, cor, preco) values("3","HSR","Benelli Series-R Race Edition","Azul-Marinho","500,00");

insert into Iates(id_tipo, marca, modelo, cor, preco) values("3","Lürssen","Azzam","Branco","5000,00");
insert into Iates(id_tipo, marca, modelo, cor, preco) values("3","Mariotti Yachts","Fulk Al Salamah","Bege","5000,00");
insert into Iates(id_tipo, marca, modelo, cor, preco) values("3","Blohm Voss","Eclipse","Branco-Gelo","5000,00");
insert into Iates(id_tipo, marca, modelo, cor, preco) values("3","Platinum Yachts","Dubai","Preto","5000,00");
insert into Iates(id_tipo, marca, modelo, cor, preco) values("3","Lürssen","Dilbar","Cinza","5000,00");
insert into Iates(id_tipo, marca, modelo, cor, preco) values("3","Lürssen","Al Saïd","Vermelho","5000,00");
insert into Iates(id_tipo, marca, modelo, cor, preco) values("3","Lürssen","A +","Amarelo","5000,00");
insert into Iates(id_tipo, marca, modelo, cor, preco) values("3","Helsingør Værft","Prince Abdulaziz","Dourado","5000,00");
insert into Iates(id_tipo, marca, modelo, cor, preco) values("3","Samuda Brothers","El Mahrousa","Marrom","5000,00");
insert into Iates(id_tipo, marca, modelo, cor, preco) values("3","Lürssen","Nord","Marfim","5000,00");