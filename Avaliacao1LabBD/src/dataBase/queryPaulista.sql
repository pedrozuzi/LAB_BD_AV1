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
id int,
grupo varchar(1) check (grupo = 'A' or grupo = 'B'
				 or grupo = 'C' or grupo = 'D') not null,
codigoTime int not null
primary key(id,codigoTime)
foreign key ( codigoTime ) references times(codigoTime)) 

create table jogos(
codigoJogo int identity not null,
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
	
	--------------------
select * from times	order by newid()
select * from grupos
select * from jogos

drop procedure sp_sorteiogrupos

delete grupos
	
-----------------------------------------------------------
/**
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
	
	update @tabelaTimesChave set grupo = 'B' where id = select * from @tabelaTimesChave 
	
	insert into grupos values
	('A', (select top 1 id from @tabelaTimesChave order by newid())),
	('B', (select top 1 id from @tabelaTimesChave order by newid())),
	('C', (select top 1 id from @tabelaTimesChave order by newid())),
	('D', (select top 1 id from @tabelaTimesChave order by newid()))
	
-----------------------------------------------------------------------------------------------
exec sp_sorteioGrupos 'C'

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

----
*/
-----------------------------------------------------------------------------------------------
--FUNCIONANDO--
exec sp_sorteioGrupos 

alter procedure sp_sorteioGrupos
as
    declare @grupo varchar(1)
	declare @cod int
	declare @id int
	
	set @grupo = 'A'
	set @id = 1
	--cabeça de grupo

	while ( (select count(codigoTime) from grupos) < 4 )
	begin

		set @cod = (select top 1 codigoTime from times where nomeTime like 'São Paulo' or
	    nomeTime like 'Santos' or nomeTime like 'Palmeiras' or nomeTime like 'Corinthians' order by newid())

		if not ( exists(select codigoTime from grupos where codigoTime = @cod) )
		begin
			insert into grupos values (@id,@grupo, @cod)

			if(@grupo like 'A')
			begin
				set @grupo = 'B'
				set @id = 2
			end
			else if(@grupo like 'B')
			begin
				set @grupo = 'C'
				set @id = 3
			end
			else if(@grupo like 'C')
			begin
				set @grupo = 'D'
				set @id = 4
			end
			else if(@grupo like 'D')
			begin
				set @grupo = 'A'
				set @id = 1
			end
		end

	end

	--grupo

	while ( (select count(codigoTime) from grupos) < 20 )
	begin
		set @cod = (select top 1 codigoTime from times order by newid())
		if not ( exists(select codigoTime from grupos where codigoTime = @cod) )
		begin
		   insert into grupos values (@id,@grupo, @cod)

		   	if(@grupo like 'A')
			begin
				set @grupo = 'B'
				set @id = 2
			end
			else if(@grupo like 'B')
			begin
				set @grupo = 'C'
				set @id = 3
			end
			else if(@grupo like 'C')
			begin
				set @grupo = 'D'
				set @id = 4
			end
			else if(@grupo like 'D')
			begin
				set @grupo = 'A'
				set @id = 1
			end
		end
	end

	select * from grupos 
	

----------------------fim da sp

	select * from grupos where grupo like 'A'
	select * from grupos where grupo like 'B'
	select * from grupos where grupo like 'C'
	select * from grupos where grupo like 'D'

	 truncate table grupos
--------------------------------------------------------------------------------------------------	
--cada time joga 1 vez por rodada
-- o time não pode jogar com os times do seu grupo
--cada time deve joga com todos os times que possa jogar
--10 jogos por rodada
-- 15 rodadas
--quarta e domingo são dias de jogo
--criar as rodadas


truncate table jogos

declare @data datetime
set @data = '12/10/2010'
exec sp_jogos @data

select * from jogos where data = '10/10/2010'
select * from jogos where data = '11/10/2010'
select * from jogos where data = '12/10/2010'
-----------------------------------------
--FUNCIONANDO
alter procedure sp_jogos(@data datetime)
as
declare @pivo int
declare @timeA int, @timeB int

set @pivo = 1

--enquanto não acontecer 10 jogos nesta data
while ( (select count(codigoJogo) from jogos where data = @data) < 10 )
begin

    --randomiza os 2 times e verifica se não são iguais
	set @timeA = (select top 1 codigoTime from times order by newid())
	set @timeB = (select top 1 codigoTime from times order by newid())
	while (@timeA = @timeB)
	begin
		set @timeB = (select top 1 codigoTime from times order by newid())
	end

	--verifica se são do mesmo grupo
	if not((select id from grupos where codigoTime = @timeA) like (select id from grupos where codigoTime = @timeB) )
	begin -- grupos diferentes

		--verifica se já jogaram
		if  not( exists(select codigoTimeA from jogos where codigotimeA = @timeA and data = @data) or
		 exists(select codigoTimeB from jogos where codigotimeB = @timeB and data=@data) )
		begin -- Ainda não jogou na data
			
			--verica se ambos times já se enfrentaram  (FALTANDO)
			if  not( exists(select codigoJogo from jogos where codigoTimeA = @timeA and codigoTimeB = @timeB) or
			exists(select codigoJogo from jogos where codigoTimeA = @timeB and codigoTimeB = @timeA) )
			begin --não se enfrentaram
				insert into jogos values (@timeA, @timeb, 0, 0, @data) -- INSERIDO
				print 'inserido'
			end
			else
			begin--já se enfrentaram
				print 'já se enfrentaram'
			end		

		end
		else -- já jogou na data
		begin
			print 'já jogou na data'
		end

	end
	else 
	begin --mesmo grupo
		print 'mesmo grupo'
	end
	--7 e 12 a, 7a 2b
end

select * from jogos where data = @data

------------------------ fim da sp


/*
alter procedure sp_test()
as
    declare @tabela table(grupo varchar(1), id int, asd int )
    declare @tabelaTimesChave table (grupo varchar(1), id int)
	
	insert into @tabela (id) select top 4 codigoTime from times where nomeTime like 'São Paulo' or
	nomeTime like 'Santos' or nomeTime like 'Palmeiras' or nomeTime like 'Corinthians' order by NEWID()
	select * from @tabela

	insert into @tabelaTimesChave (id) select top 16 codigoTime from times where nomeTime not like 'São Paulo' and
	nomeTime not like 'Santos' and nomeTime not like 'Palmeiras' and nomeTime not like 'Corinthians' order by NEWID()
	select * from @tabelaTimesChave


	insert into grupos values
	('A', (select top 1 id from(select top 1 id from @tabela) as tab)),
	('B', (select top 1 id from @tabela order by (select top 2 id from @tabela) desc)),
	('C', (select top 1 id from @tabela order by (select top 3 id from @tabela) desc)),
	('D', (select top 1 id from @tabela order by (select top 4 id from @tabela) desc))

	select * from grupos

	/**
	
	insert into grupos values
	('A', (select top 1 id from(select top 1 id from @tabela) as tab)),
	('B', (select top 2 id from(select top 2 id from @tabela order by asd desc) as tab)),
	('C', (select top 3 id from(select top 3 id from @tabela order by asd desc) as tab)),
	('D', (select top 4 id from(select top 4 id from @tabela order by asd desc) as tab))
	*/

	Para trazer apenas a linha 50:
SELECT top 1 NOME FROM
(SELECT TOP 50 NOME FROM PFUNC ORDER BY NOME) X
ORDER BY NOME DESC

Para trazer da 50 até a 70: (Obs.: 50 ATÉ 70 = 21)
SELECT * FROM (SELECT TOP 21 NOME FROM 
(SELECT TOP 70 NOME FROM PFUNC ORDER BY NOME) X
ORDER BY NOME DESC ) YY
ORDER BY NOME 

	--uniqueidentifier
 truncate table grupos
---------


exec sp_test
*/
