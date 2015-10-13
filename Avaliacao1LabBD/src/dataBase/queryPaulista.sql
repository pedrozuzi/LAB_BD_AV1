create database paulista
go
use paulista

drop database  paulista

create table times(
codigoTime int not null,
nomeTime varchar(100) not null,
cidade varchar(100) not null,
estadio varchar(100) not null
primary key (codigoTime))

create table grupos(
id int identity primary key,
grupo varchar(1) check (grupo = 'A' or grupo = 'B'
				 or grupo = 'C' or grupo = 'D') not null,
codigoTime int not null
foreign key ( codigoTime ) references times(codigoTime)) 

create table jogos(
codigoJogo int not null,
codigoTimeA int not null,
codigoTimeB int not null,
golsTimeA int not null,
golsTimeB int not null,
data datetime not null	
primary key (codigoJogo))

select datename(w, getdate()) as Dia_da_Semana

insert into times values
( 1, 'Audax', 'São Paulo', 'José Liberatti' ),
( 2, 'Botafogo', 'Ribeirão Preto', 'Santa Cruz' ),
( 3, 'Bragantino', 'Bragança Paulista', 'Nabi Abi Chedid' ),
( 4, 'Capivariano', 'Capivari', 'Arena Capivari' ),
( 5, 'Corinthians', 'São Paulo', 'Arena Corinthians' ),
( 6, 'Ituano', 'Itu', 'Novelli Júnior' ),
( 7, 'Linense', 'Lins', 'Gilberto Siqueira Lopes' ),
( 8, 'Marília', 'Marília', 'Bento de Abreu' ),
( 9, 'Mogi Mirim', 'Mogi Mirim', 'Vail Chaves' ),
( 10, 'Palmeiras', 'São Paulo', 'Allians Parque' ),
( 11, 'Penapolense', 'Penápolis', 'Tenente Carriço' ),
( 12, 'Ponte Preta', 'Campinas', 'Moisés Lucarelli' ),
( 13, 'Portuguesa', 'São Paulo', 'Canindé' ),
( 14, 'Red Bull Brasil', 'Campinas', 'Moisés Lucarelli' ),
( 15, 'Rio Claro', 'Rio Claro', 'Augusto Schmidt Filho' ),
( 16, 'Santos', 'Santos', 'Vila Belmiro' ),
( 17, 'São Bento', 'Sorocaba', 'Walter Ribeiro' ),
( 18, 'São bernardo', 'São Bernardo do Campo', 'Primeiro de Maio' ),
( 19, 'São Paulo', 'São Paulo', 'Morumbi' ),
( 20, 'XV de Piracicaba', 'Piracicaba', 'Barão de Serra Negra' )
	

select * from times	order by newid()


drop procedure sp_sorteiogrupos

delete grupos
	
create procedure sp_sorteiogrupos(@id int)
as
	declare @tabela table (id int)
	declare @tabelaTimesChave table (grupo varchar(1), id int)
	
	insert into @tabelaTimesChave(id)
	select codigoTime from times 
	where codigoTime = 19 
	or codigoTime = 10 
	or codigoTime = 16 
	or codigoTime = 5 
	order by newid() 
	
	update @tabelaTimesChave set grupo = 'A' where id = 
	
	select * from @tabelaTimesChave 
	
	insert into grupos values
	('A', (select top 1 id from @tabelaTimesChave order by newid())),
	('B', (select top 1 id from @tabelaTimesChave order by newid())),
	('C', (select top 1 id from @tabelaTimesChave order by newid())),
	('D', (select top 1 id from @tabelaTimesChave order by newid()))
	
-----------------------------------------------------------------------------------------------
exec sp_sorteioGrupos 'A'

create procedure sp_sorteioGrupos(@grupo varchar(1))
as
	declare @cod int
	
	while ( (select count(codigoTime) from grupos) < 4 )
	begin
		set @cod = (select top 1 codigoTime from times order by newid())
		if not ( exists(select codigoTime from grupos where codigoTime = @cod) )
		insert into grupos values
		(@grupo, @cod)
	end
	
	select * from grupos
--------------------------------------------------------------------------------------------------	


create procedure sp_timesChave(@i int)
as
	declare @tabelaTimesChave table (id int)
	declare @cod int
	
	insert into @tabela(id)
	select codigoTime from times 
	where codigoTime = 19 
	or codigoTime = 10 
	or codigoTime = 16 
	or codigoTime = 5 
	order by newid()

	insert into grupos values
	('A', )
	
	
	
	
	

	if not ( exists(select codigoTime from times where codigoTime = 1 ) )
	begin
		print 'não existe'
	end	
		
select * from grupos



	
	insert into @tabela(id)
	select top 16 codigoTime from times 
	where codigoTime != 19 
	and codigoTime != 10 
	and codigoTime != 16 
	and codigoTime != 5
	order by newid() 
	
	--select * from @tabela 




exec sp_sorteiogrupos 1

declare @select int
set @select = (select top 1 codigoTime from times order by newid())
print @select

select top 20 codigoTime from times order by newid()

--select top 1 codigoTime from times order by newid()

