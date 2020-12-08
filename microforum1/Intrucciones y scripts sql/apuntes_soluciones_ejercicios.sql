--select * from Hospital;
--select * from plantilla;
--select * from doctor order by apellido asc;
--select * from doctor order by apellido desc;
--select * from doctor order by 1;
--select * from doctor order by especialidad,salario;
--select * from doctor ;
--select * from emp  where oficio!='DIRECTOR' and apellido!='serra';

-- una consulta sin el *  es mas optima
--select * from emp  where oficio <> 'DIRECTOR';
--select * from emp  where  not oficio = 'DIRECTOR';
--select * from emp where dept_no=10 or dept_no=20 or dept_no=30 or dept_no=40;

--select * from emp where dept_no  in (10,20,30,40);
--select * from emp where dept_no  not in (10,20,30,40);
--like se usa  con  el  %
--select * from emp where apellido like 'rey%';
--campos calculados

--select apellido, salario + comision  as total from  emp order by total;
 --select apellido, salario + comision  as total from  emp where salario + comision > 300000;
 --unico de oracle  para unir , concatenar cadenas. En los alias se usan doble comillas en oracle.
 --select apellido || ',' || oficio  as "datos empleado" from  emp;
 -- distinct elimina los registros repetidos
 --select distinct oficio  from emp;
 --select oficio from emp;
 --select distinct oficio,dept_no  from emp order by dept_no;
 --diferencia entre  >= <=   y  between
 --select * from emp where salario>=200000 and salario <=300000;
 --select * from emp where salario between 200000 and 300000;
 --1.	Mostrar todos los datos de los empleados de nuestra tabla EMP
 --select * from emp;
 --2.	Mostrar el apellido, oficio, salario anual para todos los empleados.
 --select apellido,oficio,salario from emp;
 --3.	�dem del anterior, pero para aquellos empleados que su salario anual con extras supere los 2.200.000 Ptas.
 --select apellido,oficio,salario from emp where salario * 12 > 2200000;
 --4.	�dem del anterior, pero para aquellos empleados que sumen entre salario anual con extras y comisi�n los 3.000.000 millones.
   --select apellido,oficio,salario from emp where (salario * 12)+comision > 3000000;
  -- 5.	Mostrar todos los datos de empleados ordenados por departamento y dentro de este por oficio para tener una visi�n jer�rquica.
   --select * from emp order by dept_no,oficio;
   
    --6.Mostrar todas las salas para el hospital 45.
   
 --select * from sala inner join hospital where hospital_cod=45;******************
   
   --7.	Mostrar todos los enfermos nacidos antes de 1970.
   --select * from  enfermo where fecha_nac< '31/12/1969' ;
   --8.	Igual que el anterior, para los nacidos antes de 1970 ordenados por n�mero de inscripci�n descendente
  -- select * from  enfermo where fecha_nac< '31/12/1969' order by inscripcion desc ;
   
  -- 9.	Listar todos los datos de la plantilla del hospital del turno de ma�ana
   --select * from plantilla where turno='M';
   

--10.�dem del turno de noche.
--select * from plantilla where turno='N';

--11.Visualizar los empleados de la plantilla del turno de ma�ana que tengan un salario entre 200.000 y 225.000 Ptas.

--select * from plantilla where turno='M' and salario between 200000 and 225000;

--12.Visualizar los empleados de la tabla EMP que no se dieron de alta entre el 01/01/80 y el 12/12/82.	

   --select * from  emp  where FECHA_ALT   not between '01/01/80' and  '12/12/82';
   
-- 13.Mostrar los nombres de los departamentos situados en Madrid o en Barcelona.  
  --select * from dept where loc ='MADRID' OR loc ='BARCELONA' ;
  
  --*********************hoja 2*******************************
--1.Mostrar aquellos empleados con fecha de alta posterior al 1 de Julio de 1985.
--select * from emp where fecha_alt> '01/07/1985';

--2.Lo mismo que en el ejercicio 1 pero con salario entre 150000 y 400000.
--select * from emp where salario between 150000 and 400000;

--3.Igual que en el ejercicio 2, pero tambi�n incluimos  aquellos que no siendo analistas pertenecen al departamento 20.
--select * from emp where oficio!='analista' and dept_no=20;
--4.Mostrar aquellos empleados cuyo apellido termine en 'Z' ordenados por departamento, y dentro de este por antig�edad.
--select * from emp where apellido like'%Z' order by dept_no,fecha_alt;
--5.De los empleados del ejercicio 4 quitar aquellos que superen las 200000 Ptas. mensuales.

--6.Mostrar todos los empleados cuyo oficio no sea analista.

--7.Igual que el 6, pero mostr�ndolos de forma que se aprecien las diferencias de salario dentro de cada oficio.

--8.De los del 7, nos quedamos solo con aquellos cuyo n�mero de empleado no este entre 7600 y 7900.

--9.Mostrar los distintos nombres de sala.

--10.Mostrar que personal "No Interino" existe en cada sala de cada hospital, ordenado por hospital y sala.

--11.Seleccionar los distintos valores del sexo que tienen los enfermos.

--12.Seleccionar las distintas especialidades que ejercen los m�dicos, ordenados por especialidad y apellido.

--13.Seleccionar todos los empleados cuyo apellido comience por M

--14.Seleccionar todos los empleados que contengan en su apellido ER

--**********************ejemplos funciones de agrupacion***************
--select count (*) as personas, dept_no from emp group by dept_no;
--select count (*) as personas, oficio,dept_no from emp group by oficio,dept_no;
--diferencia entre where y having : where filta los datos de la tabla y having filtra los datos de la seleccion por lo tanto es mas rapido
--select count (*) as personas, dept_no from emp where dept_no in(10,20) group by dept_no;
 --select count (*) as personas, dept_no from emp  group by dept_no having dept_no in(10,20);
 --se pueden combinar los dos having y where
--select count (*) as personas, dept_no from emp where fecha_alt>'01/01/90' group by dept_no having count(*)>1 order by 1;
--****************************ejemplos funciones de combinacion*****************
--Insert into emp Values(1111,'nuevo','director',7919,'01/01/2011',0,0,99);
/*select distinct dept_no from emp;
select distinct dept_no from dept;*/
--el on quita el campo en el que combinan las dos tablas
--select apellido,dnombre from emp inner join dept on emp.dept_no=dept.dept_no
--mas rapido es si precedemos el nombre de la tabla porque le decimos donde buscar
--select emp.apellido,dept.dnombre,emp.dept_no from emp inner join dept on emp.dept_no=dept.dept_no
-- o poniendo un alias es mas comodo y rapido
--select e.apellido,d.dnombre,e.dept_no from emp e inner join dept d on e.dept_no=d.dept_no where e.salario>250000
--esta orden es mas lenta que inner join
--select emp.apellido,dept.dnombre from emp,dept where emp.dept_no=dept.dept_no order by dnombre;

--select emp.apellido,dept.dnombre from emp left join dept on   emp.dept_no=dept.dept_no order by dnombre;
--select emp.apellido,dept.dnombre from emp  right join dept on   emp.dept_no=dept.dept_no order by dnombre;
-- saca los resultados de las dos tablas coincidan o no
--select emp.apellido,dept.dnombre from emp full join dept on   emp.dept_no=dept.dept_no order by dnombre;
--select emp.apellido,dept.dnombre from emp cross join dept;
--select emp.apellido,dept.dnombre from emp,dept where    emp.dept_no=dept.dept_no(+);
--select emp.apellido,dept.dnombre from emp,dept where emp.dept_no(+)=dept.dept_no;
-- funcion que devuelve el departamento y numero de personas por departamento
--select count(emp.emp_no) as personas,dept.dnombre from emp right join dept on emp.dept_no=dept.dept_no group by dept.dnombre;



-- ***********************consultas de union internas******************

--*1.	Seleccionar el apellido, oficio, salario, numero de departamento y su nombre de todos los empleados cuyo salario sea mayor de 300000
    --select apellido,oficio,salario,dept_no,dnombre from EMP left join DEPT on  EMP.DEPT_NO=DEPT.DEPT_NO where salario>300000;
--2.	Mostrar todos los nombres de Hospital con sus nombres de salas correspondientes.
        --select hospital.nombre,sala.nombre from hospital inner join sala on hospital.hospital_cod=sala.hospital_cod;
--3.	Calcular cuantos trabajadores de la empresa hay en cada ciudad.
        --select count(emp.apellido) as numero,dept.loc as ciudad from emp inner join dept on emp.dept_no=dept.dept_no group by loc;
--*4.	Visualizar cuantas personas realizan cada oficio en cada departamento mostrando el nombre del departamento.
        --select count(emp.apellido) as numero,dept.dnombre as nombre from emp inner join dept on emp.dept_no=dept.dept_no group by emp.oficio;

--*5.	Contar cuantas salas hay en cada hospital, mostrando el nombre de las salas y el nombre del hospital.
       /* select count(sala.nombre) as numero, sala.nombre as 'nombre de sala', hospital.nombre as 'nombre de hospital'
         from hospital inner join sala on  hospital.sala_cod=sala.sala_cod;*/
--*6.	Buscar aquellas ciudades con cuatro o mas personas trabajando.

        --SELECT COUNT(EMP_NO) AS PERSONAS , OFICIO FROM EMP GROUP BY OFICIO 

       /* select dept.loc, count(emp.emp_no) as "Personas" 
        from dept inner join emp 
        on dept.dept_no=emp.dept_no
        GROUP BY DEPT.LOC
        HAVING (count(emp.apellido))>3;*/ 
        
--7.	Encontrar el salario medio de los analistas, mostrando el n�mero de los empleados con oficio analista.
        --select avg(salario) as media,count(emp.oficio)  from emp where emp.oficio='analista';
--8.	Mostrar el n�mero de directores que existen por departamento.            
        -- select count(EMP.DIR) as direcciones,dept.dnombre from emp inner join dept on dept.dept_no=emp.dept_no  group by dept.dnombre;            
--9.	Calcular el valor medio de las camas que existen para cada nombre de sala. Indicar el nombre de cada sala y el c�digo de cada una de ellas.
        --select avg(sala.num_cama) as numero

--10.	Mostrar los doctores junto con el nombre de hospital en el que ejercen, la direcci�n y el tel�fono del mismo.

--11.	Mostrar los nombres de los hospitales junto con el mejor salario de los empleados de cada hospital.

--12.	Visualizar el Apellido de los empleados de la plantilla junto con el nombre de la sala, el nombre del hospital y el n�mero de camas libres de cada una de ellas.

--13.	Visualizar el n�mero de enfermeros, enfermeras e interinos que hay en la plantilla, ordenados por la funci�n.

--14.	Calcular el salario medio, Diferencia, M�ximo y M�nimo de cada oficio. Indicando el oficio y el n�mero de empleados de cada oficio.

--15.	Averiguar la combinaci�n de que salas podr�a haber por cada uno de los hospitales.

--******************consultas de jerarquia propias de oracle***********************************************

--select * from emp where dir=7839;
--select * from emp where emp_no=7839;

--select level,apellido  from emp  connect by  prior dir= emp_no start with apellido='ford' order by 1;
--select level,apellido  from emp  connect by   dir=prior  emp_no start with apellido='rey' order by 1;

/*
select  apellido from emp
union all
select apellido  from emp;
*/
/*
select apellido,'emp' as tabla
from emp
union all
select apellido ,'doctor'
from doctor;*/

/*
select apellido,'emp' as tabla
from emp
intersect
select apellido ,'doctor'
from doctor;
*/
--*****************ejercicios*********
--Select Level, apellido from emp connect by PRIOR dir = emp_no start with apellido = 'jimenez';
--Select Level, apellido from emp connect by dir = PRIOR emp_no start with apellido = 'jimenez' order by level;
--2.	Construir un listado Jer�rquico de todos los empleados que dependen de:	Negro
--Select Level, apellido from emp connect by dir = PRIOR emp_no start with apellido = 'negro' order by level;
--3.	Queremos saber cuantos individuos hay en cada nivel de jerarqu�a de la empresa.
--select level, count(level) "NUMERO EMP" from emp connect by dir = PRIOR emp_no start with apellido = 'rey' group by level;
--4.	Alonso ha cometido un grave error. Para averiguar si �l es el culpable, o alg�n superior queremos conocer toda la estructura de mandos hasta llegar a Alonso.
--select Level, apellido from emp connect by PRIOR dir = emp_no start with apellido = 'alonso' order by level;
--5.	Queremos un listado de los analistas y los que dependan de ellos.
--select level, oficio, apellido from emp connect by dir = PRIOR emp_no start with oficio = 'ANALISTA' order by oficio;
--1.	Calcular el n�mero de empleados que hay en cada nivel de la jerarqu�a de la empresa, el salario medio, m�ximo y m�nimo .
/*
SELECT LEVEL, COUNT(LEVEL) "NUMERO" 
,AVG(SALARIO) "MEDIA"
, MAX(SALARIO) "MAXIMO"
,MIN(SALARIO) "MINIMO"
 FROM EMP
CONNECT BY DIR = PRIOR EMP_NO
START WITH APELLIDO = 'rey'
GROUP BY LEVEL;
*/

--**************subconsultas*****************************************************************
--select * from emp where oficio=(select oficio from emp where apellido='jimenez');
--select * from emp where oficio=(select oficio from emp where apellido='jimenez') and fecha_alt>(select fecha_alt from emp where apellido='reg');
--select * from emp where oficio in (select oficio from emp where apellido='jimenez' or apellido='sala');
--select max(salario) as maximo ,apellido,oficio from emp group by apellido, oficio;
--select (select max(salario) from emp) as maximo ,apellido, oficio from emp;
--select * from emp where salario in (select salario from doctor);
--select * from emp where salario in (select salario from doctor) and oficio in(select especialidad from doctor);
--select * from emp where (salario,oficio) in (select salario,especialidad from doctor);
--select * from emp where dept_no=(select dept_no from dept where loc='madrid');
--esta es mas optima que la de arriba
--select emp.* from emp inner join dept on emp.dept_no=dept.dept_no where dept.loc='madrid';
--**************ejercicios******************
--*1.	Mostrar el numero de empleado, el apellido y la fecha de alta del empleado mas antiguo de la empresa
--select emp_no ,apellido,max(fecha_alt) from emp;
--*2.	Mostrar el n�mero de empleado, el apellido y la fecha de alta del empleado mas modernos de la empresa.
--select emp_no,apellido,fecha_alt from emp in (fecha_alt=max(fecha_alt));
--3.	Visualizar el apellido y el oficio de los empleados con el mismo oficio que Jim�nez.
--select apellido,oficio from emp where oficio=(select oficio from emp where apellido='jimenez');
--4.	Queremos saber el apellido, oficio, salario y n�mero de departamento de los empleados con salario mayor que el mejor salario del departamento 30.
--select apellido, oficio,salario, dept_no from emp where salario>(select max(salario) from emp where dept_no=30);


--5.	Mostrar el apellido, la funci�n, sala o departamento de todos los empleados que trabajen en la empresa.

--6.	Averiguar el salario de todos los empleados de la empresa, de forma que se aprecien las diferencias entre ellos.

--7.	Mostrar apellidos y oficio de los empleados del departamento 20 cuyo trabajo sea el mismo que el de cualquier empleado de ventas.

--8.	Mostrar los empleados que tienen mejor salario que la media de los directores, no incluyendo al presidente.

--9.	Mostrar el apellido, funci�n, salario y c�digo de hospital de los empleados de la plantilla que siendo enfermeros o enfermeras pertenecen al hospital SAN CARLOS.

--10.	Visualizar los datos de los hospitales que tienen personal (Doctores) de cardiolog�a.

--11.	Visualizar el salario anual de los empleados de la plantilla del Hospital Provincial y General.

--12	Mostrar el apellido de los enfermos que nacieron antes que el Se�or Miller.

--13	Necesitamos un informe para evaluar c�mo van las cuentas generales de la empresa.  Para ello, necesitamos saber lo que cobra cada persona por cada oficio de manera detallada.  Necesitamos el m�ximo salario y el minimo por , la media salarial, el total de sueldos y el n�mero de trabajadores que hay en cada puesto de toda la base de datos.

--************Consultas de sentencia  o a nivel de fila********************
/*
Select 
Case  turno
When 'T' then 'TARDE'
When 'M' then 'MA�ANA'
Else 'NOCHE'
End as TURNO,APELLIDO
From PLANTILLA
*/
/*Select 
Case  
When salario>500000 then 'Buen sueldo'
When salario<250000 then 'Normal'
Else 'Bien'
End as SUELDO,APELLIDO
From plantilla*/

--*************CONSULTAS DE ACCION**********************

/*
Create table
Prueba (numero int);

Insert into Prueba
Select  emp_no  from  emp;
*/
/*
Insert  into tabla
(apellido,salario)
Values
(gutierrez,(select min(salario)from emp where oficio='vendedor' ));
*/

--Delete from prueba Where numero in (7919,7839);
--Truncate table prueba;
--Delete from prueba;

--Delete from emp Where dept_no=(select dept from dept where dnombre='produccion');
--Update  emp set  apellido='salas',oficio='vendedor' where apellido ='sala';
--*************ejercicios**************
--1.	Dar de alta con fecha actual al empleado Jos� Escriche Barrera como programador perteneciente al  departamento de producci�n.  Tendr� un salario base de 70000 pts/mes y no cobrara comisi�n, 
--insert into emp (oficio,fecha_alt) values ('Program','06/04/2011' );
--2.	Se quiere dar de alta un departamento de inform�tica situado en Fuenlabrada (Madrid).
--insert into dept (dept_no,dnombre,loc) values (50,'informatica','Fuenlabrada');
--3.	El departamento de ventas por motivos de peseteros se traslada a L�rida, realizar dicha modificaci�n.
--update dept set dnombre='lerida' where loc='barcelona';
--4.	En el departamento anterior se dan de alta dos empleados: Juli�n Romeral y Luis Alonso. 
-- Su salario base es el menor que cobre un empleado, y cobrar�n una comisi�n del 15% de su salario.
--insert into emp (apellido,salario,comision,dept_no) values('Romeral',(select min(salario) from emp),((select min(salario) from emp)*(15/100)),30);
--insert into emp (apellido,salario,comision,dept_no) values('Alonso',(select min(salario) from emp),((select min(salario) from emp)*(15/100)),30);
--5.	Modificar la comisi�n de los empleados de la empresa, de forma que todos tengan un incremento del 10% del salario.
--update emp set comision=10;
--6.	Incrementar un 5% el salario de los interinos de la plantilla que trabajen en el turno de noche.
--update plantilla set salario=salario + ((salario*5)/100) where funcion='interino' and T='N';
--7.	Incrementar en 5000 Pts. el salario de los empleados del departamento de ventas y del presidente,
--tomando en cuenta los que se dieron de alta antes que el presidente de la empresa.
--update emp set salario=salario+5000 where oficio='PRESIDENTE' and  dept_no=(select dept_no from emp inner join dept on emp.dept_no=dept.dept_no where loc='VENTAS');

--8.	Se tienen que desplazar cien camas del Hospital SAN CARLOS para un Hospital de Venezuela.  Actualizar el n�mero de camas del Hospital SAN CARLOS.

--9.	Subir el salario y la comisi�n en 100000 pesetas y veinticinco mil pesetas respectivamente a los empleados que se dieron de alta en este a�o.

--10.	Borrar todos los empleados dados de alta entre las fechas 01/01/80 y 31/12/82.

--11.	Modificar el salario de los empleados trabajen en la paz y est�n destinados a Psiquiatr�a.  Subirles el sueldo 20000 Ptas. m�s que al se�or Amigo R.

--12.	Insertar un empleado con valores null (por ejemplo la comisi�n o el oficio), y despu�s borrarlo buscando como valor dicho valor null creado.

--13.	Borrar los empleados cuyo nombre de departamento sea producci�n.

--14.	Borrar todos los registros de la tabla Emp de la forma m�s r�pida.

--****************vistas*********************
--Create view mivista as select * from dept 
--Select * from mivista;
--Insert into mivista valves(80,'mk','sonia');
--Alter view mivista;
--Para crear o reemplazar si existe.
--Create or replace view mivista;
--select * from all_views where name ='mivista';
--select * from all_view where view_name='mivista'
/*
create or replace view datosplantilla as
select p.apellido,h.nombre as hospital,s.nombre as sala from hospital h inner join plantilla p on h.hospital_cod=P.HOSPITAL_COD
inner join sala s
on h.hospital_cod=S.HOSPITAL_COD
and s.sala_cod=p.sala_cod;
*/
/*
insert into datosplantilla
(apellido)
values ('ruiz');
update datosplantilla set hospital ='ruber'
where hospital ='general';
delete from datosplantilla
where apellido ='millo'
*/
/*
create view datosdoctor
as
select doctor_no,apellido
,especialidad,sysdate as fecha
from doctor;
*/
--select * from datosdoctor
--*************ejercicio 6************************************
/*
create or replace view fecha_alta
as
select nvl('El se�or ' || apellido || ' con cargo ' || oficio || ' se dio  de alta el ' || to_char(fecha_alt,'day dd "de" month "de" yyyy')
|| ' en la empresa ' ,'sin datos') as "fechaalta" from emp;  
*/
/*
create or replace view
datosemp (ape,funcion)
as
select apellido,oficio
from emp
*/
--*********crear y modificar tablas************

/*
Create table  clientes
(id_cliente int not null,nombre varchar2(30),apellido varchar2(30)
Default 'sin apellido' null);
*/
--insert into clientes (idcliente,nombre) values (2,'bbdd');
/*
alter table clientes 
add (dni varchar(9));
*/
/*
alter table clientes 
add( sexo char(1) 
default 'f' not null);
*/
--alter table clientes drop column sexo;
--alter table clientes add (fecha date);
--alter table clientes modify (fecha date default sysdate);
--select * from clientes;
--alter table clientes modify (nombre varchar2(5));
-- creamos clave primaria
--asi vemos todas las restricciones que hay
/*
select * from all_constraints;
alter table clientes
add constraint
pk_clientes
primary key
(id_cliente, nombre); 
*/
/*
select * from all_constraints;
alter table clientes
add constraint
u_clientes_nombre
unique
(nombre);
insert into clientes (id_cliente) values (9);
insert into clientes (id_cliente,nombre) values(15,'ccc') 
*/
--borramos restriccion
/*
alter table clientes
drop constraint 
pk_clientes;
select * from clientes;
*/
--create table pedidos (idpedido int,nombrepedido varchar(30),idcliente int);
--alter table pedidos add constraint fk_clientes_pedidos foreign key (idcliente) references clientes(idcliente);
--select * from all_constrains;
--insert into pedidos values (1,'mipedido',null);
--insert into pedidos values(2,'aa',2);
--delete from clientes where idcliente=2;
--alter table pedidos drop constraint u_clientes_nombre ;
/*
alter table pedidos
add constraint
fk_clientes_pedidos
foreign key(idcliente)
references clientes (idcliente)
on delete cascade;
*/
--alter table pedidos add (precio int , fecha date);

--alter table pedidos add constraint chk_pedidos_precio check(precio>0);
--alter table pedidos add constraint chk_pedidos_fecha check(fecha<=to_date('01/01/2011','dd/mm/yyyy'));
--Asi creamos secuencias  que son propias de oracle
--create sequence secuencia increment by 1 start with 1;
--nextval da el siguiente valor y currval el valor actual
--select secuencia.nextval from dual;
--select secuencia.currval from dual;
--***********************ejercicios***************************************
/*
create sequence misecuencia increment by 1 start with 1;
create table colegios (
Cod_colegio int constraint pk_cod_colegio primary key,			
Nombre	varchar2(20) not null,
Localidad varchar2(15),	
Provincia	varchar2(15),		
A�o_Construcci�n	date,
Coste_Construcci�n	int,
Cod_region	int constraint fk_Cod_region foreign key(Cod_region) references regiones (Cod_region),
Unico	int	 unique
);
*/
/*
create table profesores(
Cod_profe varchar2(10) constraint pk_Cod_profe primary key not null,			
Nombre	varchar2(10) not null, 
Apellido1 varchar2(10) ,	
Apellido2 varchar2(10),		
Edad int,
Localidad varchar2(10),
Provincia varchar2(10),
Salario	int	,
Cod_Colegio int constraint fk_Cod_colegio foreign key(Cod_colegio) references colegios (Cod_colegio)
);
*/
/*
create table regiones(
Cod_region int constraint pk_Cod_region primary key,			
Regiones varchar2(10) not null
);
*/
/*
create table alumnos(
DNI varchar2(10) constraint pk_DNI primary key not null,			
Nombre	varchar2(10) not null, 
Apellidos varchar2(10) ,	
Fecha_Ingreso date,
Fecha_nac date,
Localidad varchar2(15),
Provincia varchar2(30),
Cod_Colegio int  constraint  fk_Cod_colegio foreign key(Cod_colegio) references colegios (Cod_colegio),
);
*/
--alter table profesores add (sexo varchar2(1), fecha_nac date, estado_civil varchar2(1));
--alter table profesores drop column (Edad int);
--alter table alumnos add(sexo varchar2(1), direcci�n varchar2(20), estado_civil varchar2(1));
--alte table profesores drop constraint fk_Cod_colegio;
--alter table alumnos modify(sexo char(1)); 
--alter table profesores add constraint fk_Cod_colegio foreign key(Cod_colegio) references colegios (Cod_colegio) on delete cascade;
--alter table clientes modify (fecha_nac date default sysdate);
/*
insert into alumnos (nombre,apellidos,provincia,localidad) values ('Ana','Ortiz Ortega','Madrid','Madrid'); 
insert into alumnos (nombre,apellidos,provincia,localidad) values ('Javier','Chuko Palomo','Alicante','Arenales del sol');
insert into alumnos (nombre,apellidos,provincia,localidad) values ('Miguel','Torres Tormo','Barcelona','Llobregat');

insert into regiones (Cod_region,regiones) values ('1','Madrid'); 
insert into regiones (Cod_region,regiones) values ('2','Alicante');
insert into regiones (Cod_region,regiones) values ('3','Barcelona');


insert into profesores (Cod_region,regiones) values ('1','Madrid'); 
insert into profesores (Cod_region,regiones) values ('2','Alicante');
insert into profesores (Cod_region,regiones) values ('3','Barcelona');

insert into colegios (Cod_region,regiones) values ('1','Madrid'); 
insert into colegios (Cod_region,regiones) values ('2','Alicante');
insert into colegios (Cod_region,regiones) values ('3','Barcelona');
*/
--*************** bloques  pl/sql*********************
/*
Declare 
numero int;
Begin
	Numero:=-3;
	If(numero>0) then
		Dbms_output.put_line('positivo');
		Elsif(numero=0) then
			Dbms_output.put_line('cero');

		Else 
			Dbms_output.put_line('negarivo');
		End if;
End;
*/
/*
Declare 
numero int:=1;
Begin
    loop
		Dbms_output.put_line(numero);
        numero:=numero+1;
        if (numero>10) then
            exit;
        end if;
    end loop;        
End;	
*/
/*
declare
    numero int:=1;
begin
    while (numero <10) loop
        Dbms_output.put_line(numero);
        numero:=numero+1;
    end loop;
end;
*/
/*
begin
    for i in 1..10 loop
        Dbms_output.put_line(i);
    end loop;
end;
*/
/*
declare
numero1 int:=3;
numero2 int:=6;
numero3 int:=9; 
mayor int;
begin 
    if (numero1>numero2) || (numero1>numero3) then        
           Dbms_output.put_line('El mayor es:' || numero1);           
    elsif (numero2>numero1)  || (numero2>numero3) then
           Dbms_output.put_line('El mayor es:' || numero2); 
    elsif (numero3>numero1)  || (numero3>numero2) then
            Dbms_output.put_line('El mayor es:' || numero3);
    end if;
end;
*/
/*
declare
    num1 int:=3;
    num2 int:=6;
    num3 int:=9; 
    mayor int;
begin 
    mayor := greatest(num1,num2,num3);
    Dbms_output.put_line('El mayor es:' || mayor);  
end;
*/
/*
declare 
    maximo int;
    ape varchar2(30);
    ofi varchar2(30);
begin
    select max (salario) into maximo from emp;
    Dbms_output.put_line('Maximo salario:' || maximo);
    select apellido,oficio into ape,ofi from emp where salario=maximo;
    Dbms_output.put_line(' Apellido ' || ape || ' oficio ' || ofi);
end;
*/

--EXCEPCIONES TOO_MANY_ROWS   Y   NO_DATA_FOUND
/**********explicitos*****
declare
    ape varchar2(30);
begin
    select apellido into ape from emp where upper(oficio)='PRESIDENTE';
    Dbms_output.put_line('Apellido:' || ape);
exception 
    when TOO_MANY_ROWS then
        Dbms_output.put_line('Demasiadas filas');
    when NO_DATA_FOUND then
        Dbms_output.put_line('Sin datos');
end;
*/
/*
declare
    ape varchar2(30);
    cursor consulta is
    select apellido from emp
    where oficio='VENDEDOR';
begin
    open consulta;
    loop
        fetch consulta into ape;
            if (consulta%notfound) then
                exit;
            else
                dbms_output.put_line('apellido:' || ape);
            end if;    
    end loop;
    close consulta;
end;   
*/ 
/*
declare 
    ape varchar2(30);
    cursor consulta is
    select apellido from emp
    where oficio='VENDEDOR';
begin
    open consulta;
    loop
        fetch consulta into ape;            
                dbms_output.put_line('apellido:' || ape);
        exit when consulta%notfound;       
    end loop;
    close consulta;
end;   
*/
--******ejercicios************************************************
--***ejercicio 1****implicito***********
/*
declare
   numero int;
begin
    select count(hospital_cod) into numero from hospital;
 if ( mod(numero, 2)=0) then 
    dbms_output.put_line('Es par:' || numero);
 else 
    dbms_output.put_line('Es impar:' || numero);
 end if;         
end;   
*/

--****ejercicio 1 explicito****
/*
declare
   numero int;
   cursor consulta is select count(hospital_cod) from hospital;   
begin
open consulta;
loop
fetch consulta into numero;
exit when consulta%notfound;

  if ( mod(numero, 2)=0) then 
    dbms_output.put_line('Es par:' || numero);
 else 
    dbms_output.put_line('Es impar:' || numero);
 end if;
 end loop;
 close consulta;         
end;   
*/

/*************************************************no* vale **********
select max(salario) from plantilla
select * from plantilla;
declare
    ape varchar2(50);
    t  varchar2(50)
    cursor consulta is
    select apellido  into ape from plantilla when max(salario)=(select salario from plantilla) ;
    select apellido  into t from plantilla when max(salario)=(select salario from plantilla) ;
begin 
    open consulta 
        fetch consulta into ape
        dbms_output.put_line('Apellido: ' || ape);
      if t='T'
        dbms_output.put_line('Turno: ' || 'Tarde');
      else  
        dbms_output.put_line('Turno: ' || 'Ma�ana');
      end if        
 
    exception 
        when TOO_MANY_ROWS then
             Dbms_output.put_line('Demasiadas filas');
        when NO_DATA_FOUND then
             Dbms_output.put_line('Sin datos');          
    close consulta    
end;   
*/
/******ejercicio 2 ****implicito**************************************/
/*
declare
 maximo int;
 apellido varchar2(30);
 turno varchar2(30);
begin
       select max(salario) into maximo from plantilla;
       select apellido,
       decode(turno,'T' ,'Tarde','N' , 'noche' ,'M', 'ma�ana')
       into apellido,turno from plantilla where salario=maximo;       
       dbms_output.put_line (apellido || ',' || turno);       
end;
*/
--**********ejercico3******************
/*
declare 
        fecha date;
        anyo int;
        contador int :=1;
        dia int;
begin
        fecha:= sysdate;
        anyo:=to_number(to_char(fecha,'yyyy'));
        while (contador <=50) loop
            fecha :=to_date('01/02/' || anyo,'dd/mm/yyyy');
            anyo:=anyo-1;
            fecha:=last_day(fecha);
            dia:=to_number(to_char(fecha,'dd'));
            contador:=contador + 1;
            if (dia=29) then
                dbms_output.put_line ('bisiesto:' || anyo);
            end if;
         end loop;
end;
*/
--*****************************REGISTROS*****
/*******mira apunte.doc
DECLARE 
	Numero int;
	Type registro IS RECORD
		(numero int 
    ,apellido varchar2(30)
    ,oficio varchar2(30));
    mitipo registro;
begin
	select  emp_no,apellido,oficio
	into mitipo from emp
	where emp_no=7839;
	obms_output.put_line('apellido:'|| mitipo.apellido
    || ',oficio:' || mitipo.oficio);
end;
*/

/*
DECLARE 
	Type filadept is table
	Of  dept%ROWTYPE   index by binary_integer;
	arraydept  filadept;
begin
    select * into arraydept(1) from dept where dept_no=10;
    select * into arraydept(2) from dept where dept_no=20;
    DBMS_OUTPUT.PUT_LINE (arraydept(1).loc);
    DBMS_OUTPUT.PUT_LINE (arraydept(2).loc);
End;
*/
-- *********misma consulta con cursores*********************
/******************************************************
declare 
    type filadept is table of dept%rowtype index by binary_integer;
    arraydept filadept;
    contador int :=1;
    cursor micursor is select * from dept;
begin    
    open micursor;
        loop
            fetch micursor into arraydept (CONTADOR);
                exit when micursor%notfound;
                contador:=contador+1;
        end loop;
    close micursor;    
    contador:=contador-1;
    for i in 1..contador loop
        if(arraydept.exists(i)) then
            DBMS_OUTPUT.PUT_LINE (arraydept(i).dnombre);
        end if;   
            
    end loop;    
end;    
*********************************************************/
--***procedimientos**************************************
/*
Create or replace procedure
        buscarEmpleado_id(numero emp.emp_no%type)
    As
    Begin
	    Declare
		    Ape varchar2(30);
	    begin
		    Select apellido into ape from emp where emp_no=numero;
		    DBMS_OUTPUT.PUT_LINE(ape);
    End;
End;

*/
--Execute buscarempleado_id(7566);

--*****para borrar ****
/*
Create or replace procedure
        deleteEmpleado(numero emp.emp_no%type)
    As    
    begin
        delete from emp where emp_no=numero;
        if sql%notfound then
               DBMS_OUTPUT.PUT_LINE('no borrado');
        else
               DBMS_OUTPUT.PUT_LINE('borrado');
        end if;             
    end;
*/
/*
Create or replace procedure
        mostraroficioemp(p_oficio emp.oficio%type)
    As    
    begin
        declare
            ape emp.apellido%type;
            cursor consulta is
            select apellido from emp
            where upper (oficio) =upper(p_oficio);   
         begin 
            open consulta;
            loop
                fetch consulta into ape;
                exit when consulta%notfound;
                DBMS_OUTPUT.PUT_LINE(ape);
            end loop;
            close consulta;
         end;                
    end;
    */
--execute mostraroficioemp('vendedor');

--con parametros de entrada y salida (no confundir con funciones)
/*Create or replace procedure
        parametrosalida(p_emp emp.emp_no%type, p_salario out int)
    As    
    begin
        select salario into p_salario from emp where emp_no=p_emp;
    end;
*/
--***********lo ejecutamos el procedimiento creado anteriormente con un bloque*****
/*
  declare
    v_sal int;  
  begin
        parametrosalida(7839,v_sal);
        DBMS_OUTPUT.PUT_LINE(v_sal);
  end;   
*/ 
--***************Ejercicios de procedimientos********************
--PROCEDIMIENTOS ALMACENADOS

--1)	Recuperar todos los empleados que se dieron de alta entre una determinada fecha inicial y fecha final y que pertenecen a un determinado departamento.
/*
Create or replace procedure
        mostrar_empleados(fecha_inicial  emp.fecha_alt%type,fecha_fin  emp.fecha_alt%type)
    As    
    begin
        declare            
            select * from emp where ('1/1/2000')<fecha_alt || fecha_alt<('1/1/2012');   
         end;                
    end;
*/
--2)	Crear un procedimiento que recupere el nombre, el n�mero de departamento y n�mero de  personas a partir del n�mero de departamento.


/*Create or replace procedure
        buscarnomnum_id(numero emp.dept_no%type)
    As    
	    Declare
		    cadena1 varchar2(50) ;
            cadena2 int;
            cadena3 int;
	    begin
		    Select apellido into cadena1,dept_no into cadena2,count(dept_no) into cadena3 from emp where dept_no=numero; 
		    DBMS_OUTPUT.PUT_LINE (cadena);
        End;
*/

--3)	Crear un procedimiento igual que el anterior, pero que recupere tambi�n las personas que trabajan en dicho departamento, pas�ndole como par�metro el nombre.



--4)	Crear procedimiento que inserte un empleado.

/*
Create or replace procedure
        insertar_empleado(numero emp.emp_no%type, apellido emp.apellido%type,oficio emp.oficio%type,dir emp.dir%type,fecha_alt emp.fecha_alt%type,salario emp.salario%type,comision emp.comision%type,dept_no emp.dept_no%type);
    As    
	    Declare
		    cadena1 varchar2(50) ;
            cadena2 int;
            cadena3 int;
	    begin
		    insert  
		    DBMS_OUTPUT.PUT_LINE (cadena);
        End;
*/

--5)	Crear un procedimiento que modifique los datos de un departamento, pasando como par�metro para la modificaci�n el n�mero de departamento.  

--6)	Crear un procedimiento que sea un buscador, pasaremos todo o parte del apellido y nos mostrar� todos los datos de una FILA del empleado, es decir, utilizar ROWTYPE).

--7)	Crear un procedimiento en el que pasaremos como par�metro el Apellido de un empleado.  El procedimiento devolver� los subordinados del empleado escrito, si el empleado no existe en la base de datos, informaremos de ello, si el empleado no tiene subordinados, lo informaremos con un mensaje y mostraremos su jefe.  Mostrar el n�mero de empleado, Apellido, Oficio y nombre del departamento de los subordinados.

--8)	Crear procedimiento que borre un empleado dando como argumento el apellido de un empleado.  Si al pasarle el apellido la eliminaci�n pudiese borrar m�s de un registro, no realizaremos la acci�n y mostraremos un mensaje informativo con la advertencia.

/*9)	Crear un procedimiento en el que pasaremos como argumento el apellido de un empleado y me devolver� el n�mero de vacaciones que se ha tomado el empleado desde que ingres� en la empresa dependiendo de su categor�a.
Mostrar� el apellido, el oficio, la fecha de alta y fecha actual y el n�mero de 
vacaciones.

El PRESIDENTE rey tiene 40 dias de vacaciones y lleva en la empresa 12 a�os, con un total de 480 dias de vacaciones

VACACIONES A�O POR CATEGORIA:
�	Presidente: 40 d�as
�	Empleado: 15 d�as
�	Analista: 22 d�as
�	Resto: 25 d�as
*/
--10)	Crear un procedimiento en el que pasaremos como parametro el n�mero de empleado.  Dicho procedimiento deber� mostrarme los a�os y meses que al usuario le restan por trabajar hasta el d�a de su jubilaci�n, teniendo en cuenta que nuestra empresa solamente contrata gente con 20 a�os al entrar en la empresa.

--****************Funciones*****************************
--*****************creacion de funcion**********
/*
create or replace function
contar (ofi varchar2) return int
Is
numero int;
Begin
    select count (*) into numero from emp where upper(oficio)=upper(ofi);
    Return numero;
End;
*/
--******************llamada funcion******************
/*
declare 
    num int;
begin
    num:=system.contar('vendedor');
    DBMS_output.put_line(num);
end;
*/
   --***********otro ejemplo******creacion de funcion**********
/*
create or replace function
contar (ofi varchar2) return consulta
Is
cursor consulta is select * from dept;;
Begin
    select count (*) into numero from emp where upper(oficio)=upper(ofi);
    Return numero;
End;
*/


--****************paquetes**************
/*
Create or replace package 
Paqueteempleados
Is
Procedure eliminarempleado(v_emp int);
Function maximosalario return int;
Apellido emp.apellido%type;
End paqueteempleados;
*/
/*
begin
    paqueteempleados.apellido:='gutierrez';
end;
*/
/*
Create or replace package body 
Paqueteempleados
Is
    Procedure eliminarempleado(v_emp int)
    as
    begin
        delete from emp where emp_no=v_emp;
    end;
    function maximosalario return int
    as
        v_salario int;
    begin
        select max(salario) into v_salario from emp;
        return v_salario;
    end;
end;
*/
/*
begin 
    dbms_output.put_line(paqueteempleados.maximosalario);
    paqueteempleados.eliminarempleado(7907);
end;
*/
/************************************
create or replace package pk_sobrecarga
is
    procedure mostrarempleados(v_dept int);
    procedure mostrarempleados(v_nombre varchar2);
end;

create or replace package body pk_sobrecarga
is
    procedure mostrarempleados(v_dept int)
    as
    v_emp emp%rowtype;
    cursor consulta is
    select * from emp where dept_no=v_dept;
    begin 
    open consulta;
    loop
    fetch  consulta into v_emp;
    exit when consulta%notfound;
    dbms_output.put_line(v_emp.apellido);
    end loop;
    close consulta;    
    
    end;
    procedure mostrarempleados(v_nombre varchar2)
    as
    v_emp emp%rowtype;
    cursor consulta is
    select * from emp where dept_no=(select dept_no from dept where upper(dnombre)=upper(v_nombre));
    begin 
        open consulta;
        loop
            fetch  consulta into v_emp;
            exit when consulta%notfound;
            dbms_output.put_line(v_emp.apellido);
        end loop;
        close consulta;    
    end;  
    
end;


begin 
pk_sobrecarga.mostrarempleados(10);
pk_sobrecarga.mostrarempleados('ventas');
end;
****************************************************/
/********************trigger en oracle*****/
--of columna va en el before after o instead of y es opcional
/*
create or replace trigger cambiodept
after update
on dept
for each row
declare
    v_dept dept.dept_no%type;
begin
    v_dept:=:new.dept_no; 
    dbms_output.put_line('departamento cambiado:' || v_dept);
    update emp set dept_no=v_dept
    where dept_no=:old.dept_no;
end;
*/


--prueba el trigger

--update dept set dept_no=21  where dept_no=10;

/*
create or replace trigger cambiodept
after update of dept_no
on dept
for each row
declare
    v_dept dept.dept_no%type;
begin
    v_dept:=:new.dept_no; 
    dbms_output.put_line('departamento cambiado:' || v_dept);
    update emp set dept_no=v_dept
    where dept_no=:old.dept_no;
end;
*/

--impedir que se borre el presidente
/*
create or replace trigger controlpresi
before delete
on emp
for each row
declare
    v_ofi emp.oficio%type;
begin
    v_ofi:=:old.oficio;
    if(upper(v_ofi)='presidente') then 
        dbms_output.put_line('presidente prohibido');
        --lanza excepciones y deshace los cambios
        raise_application_error(-20000,'el presi no se toca');
    end if;    
end;
*/
--delete from emp where emp_no=7839
--select * from emp where emp_no=7839
/*
create or replace view vista_emp_doctor
as 
select emp_no,salario from emp
union
select doctor_no,salario from doctor;
*/
/*
create or replace trigger controlvista
instead of update

on vista_emp_doctor
for each row

declare 
v_emp int;
begin
    select emp_no into v_emp from emp where emp_no=:new.emp_no;
    if (v_emp is null) then
        update doctor set salario=:new.salario where doctor_no=v_emp;
    else
        update emp set salario=:new.salario where emp_no=v_emp;
    end if;
end;
*/
/*
create or replace trigger controlpresi
before delete
on emp
for each row
when (old.oficio='presidente')
begin
    raise_application_error(-20000,'presi no se toca');
end;
*/

/*
create or replace trigger controlsalario
before insert
on emp
for each row
declare
v_salario int;
begin
    select salario into v_salario from emp where emp_no=:new.dir;
    if (:new.salario>v_salario) then
        raise_application_error(-20000,'salario superior');
    end if;
end;
*/

--insert into emp values (1111,'nuevo','vendedor',7919,sysdate,500000,0,10);
/***** mientras se hacen cambios en una tabla se bloquea y no deja acceder a ella ni**************
create or replace trigger controlsalario
before update
on emp
for each row
declare
v_salario int;
begin
    select salario into v_salario from emp where emp_no=:new.dir;
    if (:new.salario>v_salario) then
        raise_application_error(-20000,'salario superior');
    end if;
end;
*/
--update emp set salario=500000 where emp_no=7907;
/*
create or replace package
pk_variables
is
    director int ;
    salario int;
end;


create or replace trigger controlsalario
before update
on emp
for each row
begin
    pk_variables.director:=:new.dir;
    pk_variables.salarioemp:=:new.salario;
end;

*/


/*
create or replace trigger controlsalario2
after update
on emp
declare
v_salario int;
begin

select salario into v_salario from emp where emp_no=pk_variables.director;
    if (pk_variables.salarioemp>v_salario) then
        raise_application_error(-20000,'salario no valido');
    end if;
end;
*/

/****************************Examen*******************************************/
/*
CREATE BATABASE HOUSEPARLA
CREATE TABLE CLIENTES
(COD_CLIENTE int not null 
,APELLIDOS varchar2(30) not null
,NOMBRE varchar2(30)
,DNI varchar2(30)
,TELEFONOI int
,TELEFONOII int
,DIRECCION varchar2(30)
,POBLACION varchar2(30)

ADD CONSTRAINT PK_COD_CLIENTE
PRIMARY KEY (COD_CLIENTE)
ADD CONSTRAINT RESTRICCION_POBLACION CHECK (UPPER(POBLACION) IN ('PARLA','HUMANES','GETAFE','PINTO','FUENLABRADA'));
ADD  CONSTRAINT RESTRICCION_TELEFONO CHECK (TELEFONOI=91*);
)

CREATE TABLE PISOS
(MOD_PISO varchar2(30) not null 
,FINALIZACION_CONSTRUCCION date 
,PRECIO INT
,PRECIO_IVA INT
ADD CONSTRAINT RESTRICCION_PRECIO_PISO CHECK (PRECIO<180000 AND PRECIO>220000);
add constraint FK_ PISOS(MOD_PISO) references VENTA_PISOS(MOD_PISO)

)

CREATE TABLE VENTA_PISOS
(COD_CLIENTE int not null 
,FECHA_VENTA date not null
,MOD_PISO varchar2(30)
,COD_PISO int
ADD CONSTRAINT PK_COD_CLIENTE PRIMARY KEY (COD_PISO)

)

CREATE TABLE CHALET
(MOD_CHALET int not null 
,FINALIZACION_CONSTRUCCION DATE not null
,PRECIO INT
,PRECIO_IVA INT
ADD CONSTRAINT RESTRICCION_PRECIO_CHALET CHECK (PRECIO<250000 AND PRECIO>400000);
ADD CONSTRAINT RESTRICCION_FINALIZACION CHECK (EXTRACT(YEAR,FINALIZACION_CONSTRUCCION)-EXTRACT (YEAR,SYSDATE)>0);

add constraint FK_CHALETS foreign key(MOD_CHALET) references VENTA_CHALET(MOD_CHALET)

)

CREATE TABLE VENTA_CHALET
(COD_CLIENTE int not null 
,FECHA_VENTA date
,MOD_CHALET varchar2(30)
,COD_CHALET int
ADD CONSTRAINT PK_COD_CHALET PRIMARY KEY (COD_CHALET)
)

INSERT INTO CLIENTES VALUES (1, 'Gomez Perez', 'Nora', '53127183K', '915556655','656565665','C/ Alfonso XIII','PARLA');
INSERT INTO CLIENTES VALUES (2, 'Pons Lopez', 'Monica', '52369874G', '916758898','666885544','C/ Tierra N�21','HUMANES');
INSERT INTO CLIENTES VALUES (3, 'Lopez Ortega', 'Ana', '53265897B', '916914771','654123145','C/ Humanes N�32','HUMANES');
INSERT INTO CLIENTES VALUES (4, 'L�pez Allengue', 'Anselmo', '56123654Z', '915456565','646685843','C/ Hita N�2','GETAFE');
INSERT INTO CLIENTES VALUES (5, 'Calderon', 'Angel', '00011185R', '9187889514','685456644','C/ Olmos','PARLA');
INSERT INTO CLIENTES VALUES (6, 'Fernandez', 'Jose', '51236986F', '917895566','661457899','C/ Parla','FUENLABRADA');
INSERT INTO CLIENTES VALUES (7, 'Sonia Lopez', 'Esther', '53127183T', '916758898','666885544','C/ Santander','PINTO'); 
INSERT INTO CLIENTES VALUES (8, 'Arteaga Martin', 'Ines', '58963217Y', '915546585','654316846','Avenida de Espa�a, 9','PINTO');
INSERT INTO CLIENTES VALUES (9, 'Baro Ollero', 'Victor', '56211758F', '918956645','666667894','C/ Juan Carlos','PARLA');
INSERT INTO CLIENTES VALUES (10, 'Rubio Galindo', 'Ascension', '52369874G', '916721546','654897213','C/ Felipe II','PARLA');

INSERT INTO PISOS VALUES ('BLOQUE NORTE', '21-08-2013', 180000, 195500);
INSERT INTO PISOS VALUES ('BLOQUE SUR', '11-12-2012', 200000, 217190);


INSERT INTO VENTA_PISOS VALUES (1, '12/12/2009', 'BLOQUE SUR', 'PORTAL 1 9�A');
INSERT INTO VENTA_PISOS VALUES (7, '21-11-2008', 'BLOQUE SUR', 'PORTAL 3 1�B');
INSERT INTO VENTA_PISOS VALUES (2, '20-10-2008', 'BLOQUE NORTE', 'PORTAL 3 1�C');
INSERT INTO VENTA_PISOS VALUES (3, '12-11-2009', 'BLOQUE SUR', 'PORTAL 8.1�A');
INSERT INTO VENTA_PISOS VALUES (5, '30-09-2009', 'BLOQUE SUR', 'PORTAL 8.1�B');


INSERT INTO CHALET VALUES ('CHALET A', '21-08-2012', 250000, 270840);
INSERT INTO CHALET VALUES ('CHALET B', '16-11-2013', 319000, 339220);
INSERT INTO CHALET VALUES ('CHALET C', '01-01-2016', 350390, 390580);

INSERT INTO VENTA_CHALET VALUES (6, '03-09-2008', 'CHALET B', 'NUMERO 1');
INSERT INTO VENTA_CHALET VALUES (8, '16-12-2007', 'CHALET B', 'NUMERO 2');
INSERT INTO VENTA_CHALET VALUES (4, '12-08-2009', 'CHALET A', 'NUMERO 3');
INSERT INTO VENTA_CHALET VALUES (9, '25-12-2008', 'CHALET B', 'NUMERO 6');
INSERT INTO VENTA_CHALET VALUES (10, '31-01-2009', 'CHALET C', 'NUMERO 8');

COMMIT;
*/


/*****************************************************************************/
/*2.Consultas de Acci�n
A-*/
--UPDATE  PISOS SET  PRECIO=PRECIO * 0,03, PRECIO_IVA=PRECIO_IVA * 0,03 WHERE MOD_PISO='BLOQUE SUR'
--B-
--UPDATE  PISOS SET  PRECIO=PRECIO + 600, PRECIO_IVA=PRECIO_IVA + 600 WHERE MOD_CHALET='CHALET A'
--C-
--DELETE  FROM CLIENTES WHERE DNI='53127183K'

3.Creaci�n de Vistas
--A
/*
create or replace view fecha as
SELECT * FROM CHALET WHERE (FINALIZACION_CONSTRUCCION>(SELECT FINALIZACION_CONSTRUCCION FROM CHALET WHERE MOD_CHALET='CHALET B'))
*/
--B
/*create or replace view fecha as
SELECT MOD_CHALET,PRECIO_IVA FROM VENTA_CHALET INNER JOIN CHALET 
UNION
SELECT MOD_PISO,PRECIO_IVA FROM VENTA_PISOS INNER JOIN PISOS*/
--C
--create or replace view fecha as
--SELECT PRECIO,APELLIDOS,NOMBRE,FECHA_VENTA,FINALIZACION_CONSTRUCCION FROM CHALET INNER JOIN VENTA_CHALET INNER JOIN CLIENTES 

--D
--create or replace view fecha as
--SELECT NOMBRE,FECHA_VENTA,FINALIZACION_CONSTRUCCION,MOD_PISO,MOD_CHALET,PISOS.PRECIO + CHALET.PRECIO FROM CLIENTES INNER JOIN VENTA_CHALET INNER JOIN PISOS 

--4.Funciones de Agrupaci�n
--A
--SELECT AVG(PRECIO), SUM(PRECIO) FROM VENTA_PISOS INNER JOIN PISOS
--B
--SELECT COUNT(APELLIDO) FROM CLIENTES GROUP BY POBLACION

--5.	Procedimientos y funciones

--a)Crear una funci�n que nos devuelva el IVA (16%) de un piso o chalet, enviando el modelo de piso o chalet.


/*
b)Crear un procedimiento en el que pasaremos como par�metro el modelo de Chalet y nos devolver� el n�mero de a�os,
 meses y d�as que faltan para la finalizaci�n de la construcci�n.
*/
/*
CREATE OR REPLACE PROCEDURE TIEMPO_FIN_OBRA (MODELO MOD_CHALET)
DECLARE
    FECHA DATE;
    DIFERENCIA INT
    ANNO INT
    MES INT
    DIA
BEGIN
    SELECT FECHA=FINALIZACION_CONTRUCCION FROM CHALET WHERE MOD_CHALET=MODELO
    DIFERENCIA=MONTHS_BETWEEN (FECHA, SYSDATE)
    ANNO=DIFERENCIA/12
    MES=DIFERENCIA MOD 12    
    DBMS_OUTPUT.PUT_LINE ('FALTAN' + ANNO + 'A�OS' + 'Y' + MES + 'MESES');    
END;
*/
/*
c)Crear un procedimiento  almacenado que muestre los apellidos de los registros de una poblaci�n.
*/
/*
CREATE OR REPLACE PROCEDURE APELLIDOS (POBLA POBLACION)
DECLARE
APE
BEGIN
    SELECT APE=APELLIDOS FROM CLIENTES WHERE POBLA=POBLACION        
END;
*/
/*
d)Crear un procedimiento para realizar una venta de chalet.  Pasaremos como argumentos el Nombre del Cliente, el modelo del Chalet
 y el c�digo del Chalet.
*/
/*
CREATE OR REPLACE PROCEDURE VENTA (NOM MOMBRE,MODELO MOD_CHALET,COD COD_CHALET)
DECLARE
APE
BEGIN
    SELECT COD_CLIENTE FROM VENTA_CHALET WHERE NOM=NOMBRE       
    INSERT INTO VENTA_CHALET VALUES (COD_CLIENTE, SYSDATE , MOD_CHALET, COD_CHALET);
END;
*/
/*
e)Crear un procedimiento en el que pasaremos el nombre del cliente y nos mostrar� las ventas que le hemos realizado.  Devolveremos
 en un par�metro de salida el precio del conjunto de sus ventas.
*/
/*
f)Crear un paquete que contenga procedimientos para eliminar, modificar e insertar un piso.  El procedimiento para insertar un piso
 recibir� el nombre del cliente.  El procedimiento para eliminar un piso estar� sobrecargado y podr� recibir el c�digo del cliente o el
  c�digo del piso.
*/
/*
g)Crear un procedimiento que almacenar� los apellidos y el tipo de piso comprado en una variable de tipo tabla toda la informaci�n.
 Mostrar los datos almacenados en esta variable.
*/

 

