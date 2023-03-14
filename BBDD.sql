declare

begin

end;







declare
tel varchar2(60);
variable varchar2(160);
consulta varchar2(9000);
CURSOR C1 IS 
select E.idpelicula  from pedidos E, peliculas TAIT where  E.idpelicula LIKE fnc_comas_porcentajes(TAIT.idpelicula)  and TAIT.idpelicula = '2';
--EXECUTE IMMEDIATE consulta;
--PKG_SINVES_COMUN.FNC_PASA_A_NUMERO(TAIT.anum_numero) ;
begin
--variable:='''%PKG_SINVES_COMUN.FNC_PASA_A_NUMERO(TAIT.anum_numero)%''';
--variable:=F_REVERSE_CADENA(PKG_SINVES_COMUN.FNC_PASA_A_NUMERO(TAIT.anum_numero));
-- v_telefono_reverse := F_REVERSE_CADENA(v_telefono);
OPEN C1;
   LOOP
      FETCH C1 INTO tel;
      EXIT WHEN C1%NOTFOUND;
      DBMS_OUTPUT.PUT_LINE(tel);
   END LOOP;
  CLOSE C1;
--DBMS_OUTPUT.PUT_LINE(TAIT.anum_numero);
--DBMS_OUTPUT.PUT_LINE(ape);
end;




create or replace function fnc_comas_porcentajes(ades_Dominios in varchar2) return varchar2 is
begin
    return '''' || '%' ||ades_dominios|| '%' ||'''';
end; 



set serveroutput on;
declare
consulta varchar2(80);
BEGIN  
    --consulta:='select apellido  from EMP';
    --EXECUTE IMMEDIATE consulta;
    DBMS_OUTPUT.PUT_LINE('nombre');    
END;


declare
contiene varchar2(10);
ape varchar2(10);
BEGIN
   contiene:='1';
    if(contiene='1') then
        select apellido into ape from EMP e where e.salario like '%50000%';
        
    end if ;
    DBMS_OUTPUT.PUT_LINE(ape);
END;
select apellido  from EMP where salario like '%50000%';

DBMS_OUTPUT.PUT_LINE('ape');










--****************paquetes**************
/*
Create or replace package 
Paqueteempleados
Is
Procedure eliminarempleado(v_emp int);
Function maximosalario return number;
Apellido emp.apellido%type;
End paqueteempleados;


Create or replace package body 
Paqueteempleados
Is
    Procedure eliminarempleado(v_emp int);
    --as
    begin
        delete from emp where emp_no=v_emp;
    end;     
    
    Function maximosalario return number
    as
        v_salario number;
    begin
        select max(salario) into v_salario from emp;
        return v_salario;
    end maximosalario;    
end;

*/



















/*
create or replace procedure
                buscarEmpleado_id(numero emp.emp_no%type)
            As
            Begin
                Declare
                    Ape varchar2(30);
                begin
                    Select apellido into ape from emp where emp_no=numero;
                    DBMS_OUTPUT.PUT_LINE(ape);
                 
            End;
End buscarEmpleado_id;



Create or replace procedure
        deleteEmpleado(numero emp.emp_no%type)
    As    
    Begin
        delete from emp where emp_no=numero;
        if sql%notfound then
               DBMS_OUTPUT.PUT_LINE('no borrado');
        else
               DBMS_OUTPUT.PUT_LINE('borrado');
        end if;             
End deleteEmpleado;
    

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
    end mostraroficioemp;

--PROCEDIMIENTOS ALMACENADOS


Create or replace procedure
        mostrar_empleados(fecha_inicial  emp.fecha_alt%type,fecha_fin  emp.fecha_alt%type)
    As    
    begin
        declare    
        ape varchar2(50) ;
        begin             
            select apellido into ape from emp where '1/1/2000' < fecha_inicial AND fecha_fin < '1/1/2012';  
         end;                
    end mostrar_empleados;



Create or replace procedure
        buscarnomnum_id(numero emp.dept_no%type)
    As  
    begin
	    declare
		    cadena1 varchar2(30);
            cadena2 int;
            cadena3 int;
	    begin		  
            select apellido, dept_no, count(dept_no) into  cadena1,  cadena2,  cadena3 from emp where dept_no=numero;		    
        end;
    end buscarnomnum_id;
    */
