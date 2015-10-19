create database paulista
go
use paulista


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

*/
-----------------------------------------------------------------------------------------------
--FUNCIONANDO--
exec sp_sorteioGrupos 

alter procedure sp_sorteioGrupos
as

truncate table grupos
    declare @grupo varchar(1)
	declare @cod int
	declare @id int
	delete grupos
	delete jogos
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
--teste
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

--teste
truncate table jogos

declare @data datetime
set @data = '09/10/2010'
exec sp_jogos @data

select * from jogos where codigoTimeA = 4
union
select * from jogos where codigoTimeB = 4

select * from jogos where data = '01/10/2010'
select * from jogos where codigoTimeA = 15
select * from jogos where data = '18/03/2015'
-----------------------------------------
--FUNCIONANDO

alter procedure sp_jogos(@data datetime)
as

declare @timeA int, @timeB int
declare @count int
set @count = 1
--enquanto não acontecer 10 jogos nesta data
while ( (select count(codigoJogo) from jogos where data = @data) < 10 )
begin
    --randomiza os 2 times
	set @timeA = (select cast(RAND()*20 as int)+1)
	set @timeB = (select cast(RAND()*20 as int)+1)

	--verifica se são o mesmo time
	while (@timeA = @timeB or

	--verifica se são do mesmo grupo
	((select id from grupos where codigoTime = @timeA) = (select id from grupos where codigoTime = @timeB)) or 

	--verifica se já joraram na data
	(exists(select codigoTimeA from jogos where (codigotimeA = @timeA) and data = @data) or
	exists(select codigoTimeA from jogos where (codigotimeA = @timeb) and data = @data) or
	exists(select codigoTimeB from jogos where (codigoTimeB = @timeA) and data = @data) or
	exists(select codigoTimeB from jogos where (codigoTimeB = @timeB) and data = @data) ) or

	--verica se ambos times já se enfrentaram  
	( exists(select codigoJogo from jogos where codigoTimeA = @timeA and codigoTimeB = @timeB) or
	exists(select codigoJogo from jogos where codigoTimeA = @timeB and codigoTimeB = @timeA)) 
	)
	begin
	    set @timeA = (select cast(RAND()*20 as int)+1)
		set @timeB = (select cast(RAND()*20 as int)+1)
		set @count = @count +1
		--print convert(varchar(5), @count)
		--Caso a query entre em loop pelo motivo de
		--o ultimo confronto, a ser sorteado na rodada,
		--não pode ser sorteado pq já ocorreu em outra data
		if(@count = 1500) --validação
		begin
			delete from jogos where data = @data
			set @count = (select count(codigoJogo) from jogos)
			DBCC CHECKIDENT ('jogos', RESEED, @count) --reseta o indice identity das chaves
			print 'resetado'
			set @count = 1
		end
	end
				insert into jogos values (@timeA, @timeb, 0, 0, @data) -- INSERIDO
				print 'inserido'
end

select * from jogos where data = @data
------------------------

------------------------ fim da sp
--teste
truncate table jogos
exec sp_datasJogos
select * from jogos


--------------------------
--FUNCIONANDO
alter procedure sp_datasJogos
as

truncate table jogos
declare @data date, @dataInicio date, @dataFim date

set @dataInicio = '01/02/2015'
set @dataFim = '22/03/2015'
set @data = @dataInicio

exec sp_jogos @dataInicio

while (@data < @dataFim)
begin
	if(datename(WEEKDAY, @data) like 'Domingo')
	begin
		set @data = (select dateadd(day,3,@data))
		exec sp_jogos @data
	end
	else
	begin
		set @data =(select dateadd(day,4,@data))
		exec sp_jogos @data
	end
end

-------------fim da sp

/*

	Para trazer apenas a linha 50:
SELECT top 1 NOME FROM
(SELECT TOP 50 NOME FROM PFUNC ORDER BY NOME) X
ORDER BY NOME DESC

Para trazer da 50 até a 70: (Obs.: 50 ATÉ 70 = 21)
SELECT * FROM (SELECT TOP 21 NOME FROM 
(SELECT TOP 70 NOME FROM PFUNC ORDER BY NOME) X
ORDER BY NOME DESC ) YY
ORDER BY NOME 


*/


		

select jg.codigoJogo, 
(select nomeTime from times where codigoTime = jg.codigoTimeA) as codigotimeA,
(select nomeTime from times where codigoTime = jg.codigoTimeB) as codigotimeB
 from jogos jg
 where jg.data = '01/02/2015' 


inner join times tm
on tm.codigotime = jg.codigotimea and
tm.codigotime = jg.codigotimeb
where jg.data = '01/02/2015' 
order by jg.codigojogo

select *from jogos