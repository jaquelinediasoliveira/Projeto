drop database if exists Locadora;
create database Locadora charset=utf8 collate utf8_general_ci;
use Locadora;

-- Geralmnte as tabelas de um BD Modelo Lógico são escritas no plural
-- Tamanho do cep aumentado apara 9
create table Filiais(
     id_loja integer primary key auto_increment,
     nome_filial varchar(20) not null,
     cep varchar (9) not null,
	 cidade varchar(30)
);



-- tipo de dados varchar "cpf_passaporte" não pode ser auto_increment
-- O tamanho do cpf foi aumantado para 15 pois caracteres como ". - " devem ser contados
create table Clientes(
	id_cliente integer primary key auto_increment,
    cpf varchar(20) unique not null,
	passaporte varchar(20) not null,
    nome_completo varchar(100) not null,
    telefone varchar(11) not null,
    cep varchar(9) not null,
    endereco varchar(100) not null,
    data_nascimento Date not null
);

create table funcionarios(
	id_funcionario integer primary key auto_increment,
    cpf varchar(20) not null,
	passaporte varchar(20) not null,
    nome_completo varchar(100) not null,
    telefone varchar(11) not null,
    cep varchar(9) not null,
    endereco varchar(100) not null,
    data_nascimento Date not null
);

create table usuarios(
	id_usuario integer primary key auto_increment,
	id_cliente integer unique,
	id_funcionario integer,
	email varchar(30) not null,
	senha varchar(30) not null,
	tipo_usuario boolean,
	logOn boolean,

	constraint fk_UserCli foreign key (id_cliente) references Clientes (id_cliente)
    on delete cascade

);

-- Os nomes dos campos relacionados devem ser os mesmos e com os mesmos tipos
create table Telefones(
    id_cliente integer not null,
    telefone varchar(15) not null,
    constraint fk_TeleCli foreign key (id_cliente) references Clientes (id_cliente)
    on delete cascade 
);

-- Nomes de tabelas e campos não poder possuir caracteres especiais "Habilitação"
create table Habilitacoes(
	id_cliente integer not null,
    cpf_passaporte varchar(15) not null,
    habilitacao varchar(12) not null,
	constraint fk_HabiCli foreign key (id_cliente) references Clientes (id_cliente)
    on delete cascade 
);

create table Tipos(
    id_tipo integer primary key not null auto_increment,
    tipo varchar (10) not null
);

-- Todos os veícuos possuem os mesmos campos "marca, modelo, cor e preço"
-- Desta forma podem ser uma tabela só, e diferenciando por um campo "id_tipo"
-- evitando redundâncias




create table Veiculos(
	placa varchar(10) not null primary key,
    id_tipo integer not null,
    marca varchar(20) not null,
    modelo varchar(20) not null,
    cor varchar(10) not null,
    preco decimal(5,2) not null,
	status_loc boolean not null,
	constraint fk_VeiculoTipo foreign key (id_tipo) references Tipos (id_tipo)
    on delete cascade
);



-- Comandos DML para alimentar o banco de dados com registros

-- Desta forma insira primeiro as filiais depois os clientes
insert into Filiais (nome_filial, cep, cidade) values
("LoCar Pedreira","13920-000","Pedreira"),
("LoCar Jaguariúna","13910-009","Jaguariúna");



create table Reservas(
	id_reserva integer primary key auto_increment,
	id_cliente integer not null,
    veiculo varchar(15),
	id_tipo integer not null,
    data_retirada datetime not null,
	data_devolucao_esperada datetime,
    data_devolucao_final datetime,
    id_loja integer not null, 
    constraint fk_VeiculoPlac foreign key (veiculo) references Veiculos (placa)
    on delete cascade,
    constraint fk_CpfCli foreign key (id_cliente) references Clientes (id_cliente)
    on delete cascade,
    constraint fk_IdFilial foreign key (id_loja) references Filiais (id_loja)
    on delete cascade
);

delimiter //

CREATE TRIGGER update_status_true AFTER INSERT ON reservas
FOR EACH ROW
BEGIN
	
    UPDATE veiculos SET status_loc = true WHERE placa = NEW.veiculo;
    
END;


CREATE TRIGGER novoGatilho AFTER UPDATE 
ON reservas
FOR EACH ROW 

BEGIN
	UPDATE veiculos SET status_loc = false WHERE placa = OLD.veiculo;

END;
//

delimiter ;

SET @@time_zone = 'SYSTEM';

-- Formato das datas alterado de dia/mes/ano para BD Ano-Mes-Dia
insert into Clientes(cpf, passaporte, nome_completo, cep, endereco,data_nascimento) values
("004.064.645-96",	" ",	"Sebastiana Patrícia Gonçalves",		"65903-210",		"Rua G,409,Riacho Doce",									"1945-10-21"),
("925.738.560-46",	" ",	"Simone Juliana Lopes",					"79004-570",		"Rua OP-XXI,674,Operário",									"1949-08-05"),
("716.346.886-51",	" ",	"Giovana Elza dos Santos",				"40352-100",		"Rua Major Mauro,692,São Carlos",							"1978-06-08"),
("762.917.854-98",	" ",	"Rosângela Kamilly Caldeira",			"72425-093",		"Rua Martins Junior,631,José de Alencar",					"1983-09-25"),
("499.108.990-51",	" ",	"Antonio Luiz Carlos Eduardo Teixeira",	"69902-136",		"Rua Arapari,100,Caçari",									"1946-09-27"),
("598.741.852-60",	" ",	"Danilo Giovanni Figueiredo",			"76876-088",		"Estrada Nova,225,Alto da Mangueira",						"1948-10-11"),
("216.886.773-99",	" ",	"Cauã Diogo Mendes",					"87103-272",		"Rua 4,967,Distrito Industrial II",							"1960-03-02"),
("183.711.623-75",	" ", 	"Adriana Carolina Jesus",				"28633-480",		"Rua Augusto Ferreira Paiva,716,Nova Suíça",				"2003-01-08"),
("399.769.297-14",	" ",	"Nicole Tereza Camila Souza",			"85813-490",		"Rua Manoel Lotério da Ressurreição,463,Aeroporto", 		"1999-04-23"),
("113.187.729-23",	" ",	"Carolina Natália Aparício",			"77829-058",		"Rua Rio Mutuca,917,Grande Terceiro",						"1959-05-20"),
("829.886.906-00",	" ",	"Filipe Thiago da Silva",				"57604-105",		"Rua Colibri,208,São Bento",								"1995-10-02"),
("450.249.658-84",	" ",	"Fábio Bruno Tomás da Mota",			"29705-740",		"Rua Severino Faustino,561,Santos Reis",					"1945-08-04"),
("695.898.588-56",	" ",	"Benício Anderson Lorenzo da Rosa",		"29052-608",		"Rua de Joaquim Batista Oliveira,884,Vila Alagoana",		"1973-10-26"),
("519.559.298-58",	" ",	"Carolina Esther Bárbara Souza",		"08750-350",		"Rua Morada do Sol,169,Conjunto Solar",						"1959-09-22"),
("103.712.316-63",	" ",	"Julia Adriana Tânia Corte Real",		"88161-362",		"Rua Dom Romualdo A. de Souza,748,Monte das Oliveiras",		"2003-04-09"),
("601.627.915-34",	" ",	"Elza Aline Mariane Assunção",			"64009-480",		"Rua Firmino Marciano da Silva,192,Vila Santa Catarina",	"1979-03-26"),
("301.559.494-03",	" ",	"Clara Marli da Conceição",				"72880-616",		"Rua Levino Fanzeres,556,Novo Parque",						"1981-03-05"),
("069.079.276-08",	" ",	"Isaac Daniel Brito",					"88805-075",		"Rua Cem 2,372,Centro",										"1946-12-03");

/*insert into Telefones values
("004.064.645-96","19-7898-7987"),
("925.738.560-46","19-7898-7954"),
("716.346.886-51","19-7898-6546"),
("762.917.854-98","19-7898-7987"),
("499.108.990-51","19-7898-2313"),
("598.741.852-60","19-7898-4565"),
("216.886.773-99","19-7898-7987"),
("183.711.623-75","19-7898-7555"),
("183.711.623-75","19-7898-8888"),
("399.769.297-14","19-7898-7333"),
("113.187.729-23","19-7898-7555"),
("829.886.906-00","19-7898-7777"),
("450.249.658-84","19-7898-7987"),
("695.898.588-56","19-7898-7333"),
("519.559.298-58","19-7898-1233"),
("103.712.316-63","19-7898-7111"),
("601.627.915-34","19-7898-7222"),
("601.627.915-34","19-7898-7778"),
("301.559.494-03","19-7898-7335"),
("069.079.276-08","19-7898-7789");*/

insert into Habilitacoes values
("004.064.645-96","B"),
("925.738.560-46","B"),
("716.346.886-51","B"),
("762.917.854-98","B"),
("499.108.990-51","B"),
("598.741.852-60","B"),
("216.886.773-99","B"),
("183.711.623-75","A"),
("183.711.623-75","B"),
("399.769.297-14","B"),
("113.187.729-23","B"),
("829.886.906-00","B"),
("450.249.658-84","B"),
("695.898.588-56","C"),
("519.559.298-58","B"),
("103.712.316-63","B"),
("601.627.915-34","A"),
("601.627.915-34","D"),
("301.559.494-03","B"),
("069.079.276-08","D");

-- Agora primeiro cadastramos os tipos e depois os veículos vinculados aos tipos
insert into Tipos (tipo) values
("Carro"),
("Moto"),
("Caminhão"),
("Jato"),
("Helicóptero"),
("Lancha"),
("Jet ski"),
("Iate");


insert into usuarios (id_cliente, id_funcionario, email, senha, tipo_usuario, logOn) values (
	1, null, "sebastiana@gmail.com", "123456", false , false); 

-- E agora sim adiciona os veículos, adicionei placa a todos os veículos
insert into Veiculos(placa, id_tipo, marca, modelo, cor, preco, status_loc) values
("ASC-4568","1","Daewoo","Nubira CDX 2.0 16V Aut.","Vermelho","150,00", false),
("ASF-4568","1","Lexus","CT200h  1.8 16V HIBRID Aut.","Bege","150,00", false),
("OKS-4324","1","Miura","Picape BG-Truck CD Turbo Diesel","Amarelo","150,00", false),
("ASC-4234","1","Matra","Pick-Up CD 4x4 Curto/Longo 2.5 TDI Dies.","Cinza","150,00", false),
("IIS-6456","1","VW - VolksWagen","Fox PRIME/Hghi. IMOTION 1.6 T.Flex 8V 5p","Vermelho","150,00", false),
("SAD-5466","1","Cross Lander","CL-330 2.8 132cv 4x4 TB Int. Diesel","Vermelho","150,00", false),
("ADD-5466","1","Matra","Pick-Up CD 4x2 Curto/Longo 2.5 TDI Dies.","Azul","150,00", false),
("DFE-4566","1","Volvo","V70 R 2.5 300cv AWD Mec.","Azul","150,00", false),
("ASC-5677","1","Agrale","MARRU","Laranja","150,00", false),
("ASC-8678","1","Fyber","Buggy 2000W 1.6 8V","Marrom","150,00", false),
("DGG-4353","1","Hyundai","i30 Serie Limitada 1.8 16V Aut. 5p","Marrom","150,00", false),
("SDD-4568","1","Saab","9000 CD 2.3 Turbo","Verde","150,00", false),
("SDF-3455","1","HAFEI","Towner Passageiro 1.0 8V 48cv 7L 5p","Azul","150,00", false),
("SER-4536","1","Hyundai","Sonata GLS 2.7 V6 24V 179cv 4p Aut.","Amarelo","150,00", false),
("GFD-5465","1","Rolls-Royce","Phantom 6.7 V12 Aut.","Prata","150,00", false),
("ASC-4128","2","Honda","CG 150","Prata","100,00", false),
("ASF-4128","2","Honda","CG 125","Vermelha","100,00", false),
("OKS-4124","2","Honda","Biz","Preta","100,00", false),
("ASC-4124","2","Honda","NXR 150","Laranja","100,00", false),
("IIS-6126","2","Honda","Pop 100","Azul","100,00", false),
("SAD-5126","2","Yamaha","YBR 125","Cinza","100,00", false),
("ADD-5126","2","Honda","CB 300R","Amarela","100,00", false),
("DFE-4126","2","Honda ","XRE 300","Branca","100,00", false),
("ASC-5127","2","Yamaha","Fazer 250","Prata","100,00", false),
("ASC-8128","2","Yamaha","T115 Crypton","Verde","100,00", false),
("DGG-4123","2","Honda","Lead 110","Cinza","100,00", false),
("SDD-4128","2","Yamaha ","XTZ 125","Roxa","100,00", false),
("SDF-3125","2","Yamaha"," XTZ 250","Rosa","100,00", false),
("SER-4126","2","Suzuki","Intruder 125","Azul","100,00", false),
("GFD-5125","2","Dafra","Riva 150","Vermelho","100,00", false),
("ASC-4138","3","Volvo","FH 540","Azul","200,00", false),
("ASF-4138","3","Scania","R450","Preto","200,00", false),
("OKS-4134","3","DAF","XF","Prata","200,00", false),
("ASC-4134","3","Volvo","FH 460 ","Cinza","200,00", false),
("IIS-6136","3","Mercedes-Benz","Actros 2651","Vermelho","200,00", false),
("SAD-5136","3","DAF","XF 105 510","Azul","200,00", false),
("ADD-5136","3","Scania","R 500","Marrom","200,00", false),
("DFE-4136","3","Mercedes-Benz","Actros 2546","Roxo","200,00", false),
("ASC-5137","3","Mercedes-Benz","Axor 2544","Laranja","200,00", false),
("ASC-8138","3","Mercedes-Benz","Axor 3344","Verde","200,00", false),
("DGG-4133","3","Volvo","FH 500","Bege","200,00", false),
("SDD-4138","3","Volkswagen","Meteor","Prata","200,00", false),
("SDF-3135","3","DAF"," XF105 Super Space","Amarelo","200,00", false),
("SER-4136","3","Iveco","Hi-Way","Vermelho","200,00", false),
("GFD-5135","3","Volkswagen","MAN TGX 29480","Rosa","200,00", false),
("ASC-4258","4","Embraer","Praetor 500/600","Branco","1000,00", false),
("ASF-4258","4","Dassault","Falcon 2000","Preto","1000,00", false),
("OKS-4254","4","Cessna","Citation Longitude","Cinza","1000,00", false),
("ASC-4254","4","Gulfstream Aerospace","Gulfstream G550","Prata","1000,00", false),
("IIS-6256","4","Bombarbier Aerospace","Global 6000","Azul","1000,00", false),
("SAD-5256","4","Dassault","Falcon 8X","Roxo","1000,00", false),
("ADD-5256","4","Bombardier Aerospace","Global 6500","Vermelho","1000,00", false),
("DFE-4256","4","Gulfstream","Gulfstream G700","Amarela","1000,00", false),
("ASC-5257","4","Bombardier Aerospace"," Global 7500","Rosa","1000,00", false),
("ASC-8258","4","Cessna","Citation X+","Dourado","1000,00", false),
("DGG-4253","5","Aero Products","A-3","Prata","800,00", false),
("SDD-4258","5","Aero Products","A-1","Preto","800,00", false),
("SDF-3255","5","Aero","HC-2 Heli Baby-COMBAT","Cinza","800,00", false),
("SER-4256","5","Aero","HC-3","Branco","800,00", false),
("GFD-5255","5","Aero","HC-4","Roxo","800,00", false),
("ASC-4438","5","Brantly","B-1","Dourado","800,00", false),
("ASF-4438","5","Cicaré","CH-16","Verde","800,00", false),
("OKS-4434","5","Denel","(Atlas) Rooivalk","Amarelo","800,00", false),
("ASC-4434","5","GKN","Westland Sea King","Azul","800,00", false),
("IIS-6436","5","Kamov","Ka-226","Roxo","800,00", false),
("SAD-5436","6","Fibrafort","Focker 215","Prata","700,00", false),
("ADD-5436","6","Fibrafort","Focker 280","Branco","700,00", false),
("DFE-4436","6","Cimitarra","Cimitarra 340","Preto","700,00", false),
("ASC-5437","6","Schaefer Yachts"," Phantom 300","Cinza","700,00", false),
("ASC-8438","6","Fibrafort"," Focker 255","Bege","700,00", false),
("DGG-4433","6","Carbrasmar","Carbrasmar 32","Amarelo","700,00", false),
("SDD-4438","6","Ferretti"," Ferretti 530","Vermelho","700,00", false),
("SDF-3435","6","Schaefer Yachts","Phantom 290","Azul","700,00", false),
("SER-4436","6","Brunswick Group","Bayliner 310","Rosa","700,00", false),
("GFD-5435","6","Intermarine","Intermarine 42","Dourado","700,00", false),
("ASC-4338","6","Seadoo","GTX 215","Preto","500,00", false),
("ASF-4338","6","Seadoo","GTI 130","Cinza","500,00", false),
("OKS-4334","6","Honda","Aquatrax","Branca","500,00", false),
("ASC-4334","6","Kawasaki"," 800 SX-R","Verde","500,00", false),
("IIS-6336","6","Seadoo","RXT-X","Laranja","500,00", false),
("SAD-5336","6","Yamaha","Waverunner FZ R","Vermelho","500,00", false),
("ADD-5336","6","Yamaha","Waverunner VX R","Roxo","500,00", false),
("DFE-4336","6","Yamaha","FX Cruiser SHO","Rosa","500,00", false),
("ASC-5337","6","Kawasaki","300 LX Ultra","Verde-Limão","500,00", false),
("ASC-8338","6","HSR","Benelli Series-R Race Edition","Azul-Marinho","500,00", false),
("DGG-4333","7","Lürssen","Azzam","Branco","5000,00", false),
("SDD-4338","7","Mariotti Yachts","Fulk Al Salamah","Bege","5000,00", false),
("SDF-3335","7","Blohm Voss","Eclipse","Branco-Gelo","5000,00", false),
("SER-4336","7","Platinum Yachts","Dubai","Preto","5000,00", false),
("GFD-5335","7","Lürssen","Dilbar","Cinza","5000,00", false),
("ASC-4788","7","Lürssen","Al Saïd","Vermelho","5000,00", false),
("ASF-4788","7","Lürssen","A +","Amarelo","5000,00", false),
("OKS-4784","7","Helsingør Værft","Prince Abdulaziz","Dourado","5000,00", false),
("ASC-4784","7","Samuda Brothers","El Mahrousa","Marrom","5000,00", false),
("IIS-6786","7","Lürssen","Nord","Marfim","5000,00", false);

insert into Reservas (id_cliente, veiculo, id_tipo, data_retirada, id_loja) values
(1, "ASC-4568", 1, "2021-05-05 16:25", 1); 



select * from Filiais;
select * from Clientes;
select * from Telefones;
select * from Habilitacoes;
select * from Tipos;
select * from Veiculos;

show tables;
/*
select c.nome_completo, c.id_cliente from clientes c inner join usuarios u ON c.id_cliente = u.id_cliente
where u.email = "sebastiana@gmail.com" and u.senha = "123456"; */