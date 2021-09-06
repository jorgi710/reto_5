create schema DB_RETO_5;
USE DB_RETO_5;

create table sede(
	sed_id int(11) primary key,
    sed_nombre char(50) not null,
	sed_direccion char(50) null,
    sed_telefono char(15)

    );
    
insert into sede values (101,"Norte","Calle 66 # 24-65","6678945");
insert into sede values (102,"Sur","Carrera 100 # 45-67","5569874");
insert into sede values (103,"Libertadores","Av. 9 # 78-23","3356245");
insert into sede values (104,"Champagna","Calle 34 # 43-65","4659878");
insert into sede values (105,"Cambulos","Carrea 1 # 45-23","3255648");

create table cargo(
	car_id int(11) not null primary key,
    car_nombre  char(50) null,
    car_descripcion char(200) null
);

insert into cargo values(1,"Médico","Líder del equipo y tiene la responsabilidad de tomar las decisiones que afectan al cuidado del paciente, incluyendo el diagnóstico y el tratamiento, así como la supervisión del resto del equipo.");
insert into cargo values(2,"Residente"," Médico licenciado que se está formando como especialista después de licenciarse en la facultad de medicina.");
insert into cargo values(3,"Enfermera titulada","Personal administra los fármacos a los pacientes y supervisa y evalúa sus necesidades físicas y emocionales.");
insert into cargo values(4,"Enfermera en práctica","Trabajan en estrecha colaboración con el médico para coordinar el cuidado diario del paciente.");
insert into cargo values(5,"Defensor del paciente","Son miembros del personal administrativo del hospital cuya función es ayudar a los pacientes que reciben atención allí.");
insert into cargo values(6,"Auxiliares de enfermería","Son técnicos que ayudan a las enfermeras en el cuidado de los pacientes. Sus obligaciones pueden incluir: La obtención de las constantes vitales (medir la tensión arterial y la temperatura.");
insert into cargo values(7,"Fisioterapeuta","Valoran y tratan a las personas que tienen dificultades funcionales; por ejemplo, para caminar, cambiar de posición, o ir de la cama a la silla.");
insert into cargo values(8,"Asesor","Se encarga de atender de primera mano al paciente para que inicie su proceso en el sistema de salud, entre otras funciones originar los turnos de las consultas.");

create table paciente(
	pac_cedula int(11) not null primary key,
    pac_apellido char(30) null,
    pac_nombre char(30) null,
    pac_genero char(1) null,
    pac_edad int(11)
    
);

insert into paciente values (1112482728,"Rada","Jennifer","F",19);
insert into paciente values (31322858,"Albán","Elissa","F",35);
insert into paciente values (1144182152,"Losada","Stephania","F",22);
insert into paciente values (1144138193,"Prado","Johathan","M",23);
insert into paciente values (1130679339,"Osorio","Yimy","F",25);
insert into paciente values (67018365,"Cortes","Jhon","M",38);
insert into paciente values (1059448353,"Arcila","Angélica","F",21);
insert into paciente values (1144128511,"Bustamante","Eliana","F",24);
insert into paciente values (1130643373,"Montaño","Robert","M",23);
insert into paciente values (38680509,"Osorio","Juan","M",54);
insert into paciente values (1107074369,"Cruz","David","M",23);
insert into paciente values (1143841231,"Murillo","Julieth","F",24);

create table empleado(
  emp_cedula INT(11) NOT NULL primary key,
  emp_apellidos CHAR(30) NULL,
  emp_nombres CHAR(30) NULL,
  id_cargo INT(11) NULL,
  id_sede INT(11) NULL,
  foreign key(id_cargo) references cargo(car_id),
  foreign key(id_sede) references sede(sed_id)
);

insert into empleado values (68031918,"Pérez","Luis",1,101);
insert into empleado values (12349349,"Díaz","José",1,103);
insert into empleado values (55819135,"Castro","Mateo",8,102);
insert into empleado values (67477886,"Daza","Martha",8,102);
insert into empleado values (29095159,"Bravo","Diana",2,101);
insert into empleado values (9664055,"Saavedra","Diego",2,103);
insert into empleado values (28495554,"Sánchez","María",7,102);
insert into empleado values (67802388,"Carabalí","Julio",5,102);
insert into empleado values (61783485,"Fernández","Yiemi",4,101);
insert into empleado values (53673042,"Cabezas","Patricia",3,103);
insert into empleado values (28822236,"Benalcázar","Daniela",4,101);
insert into empleado values (19644289,"Tello","Marcela",3,103);

create table turno(
  tur_numero INT(11) not null primary key,
  tur_fecha DATETIME NULL,
  id_asesor INT(11) NULL,
  foreign key (id_asesor) references empleado(emp_cedula) 
);

insert into turno values (1,"2020/03/16 18:30:20",55819135);
insert into turno values (2,"2020/03/17 14:30:20",67477886);
insert into turno values (3,"2020/03/17 18:30:20",55819135);
insert into turno values (4,"2020/03/18 11:30:20",67477886);
insert into turno values (5,"2020/03/18 18:30:20",55819135);
insert into turno values (6,"2020/03/19 18:30:20",55819135);
insert into turno values (7,"2020/03/20 17:30:20",67477886);
insert into turno values (8,"2020/03/20 18:30:20",55819135);
insert into turno values (9,"2020/03/21 17:30:20",67477886);
insert into turno values (10,"2020/03/21 18:30:20",55819135);
insert into turno values (11,"2020/03/22 17:30:20",67477886);
insert into turno values (12,"2020/03/22 18:30:20",67477886);

create table consulta(
con_numero INT(11) NOT NULL primary key,
con_fecha DATETIME NULL,
con_observacion CHAR(200) NULL,
medico_id INT(11) NULL,
paciente_id INT(11) NULL,
tur_numero INT(11) NULL,
foreign key(medico_id) references empleado(emp_cedula),
foreign key(paciente_id) references paciente(pac_cedula),
foreign key(tur_numero) references turno(tur_numero)
);

insert into consulta values(101,"2020/03/16 18:30:20","Exámenes",68031918,1107074369,1);
insert into consulta values(102,"2020/03/17 14:30:20","Laboratorio",12349349,1143841231,2);
insert into consulta values(103,"2020/03/17 18:30:20","Radiografía",12349349,1112482728,3);
insert into consulta values(104,"2020/03/18 11:30:20","Control",12349349,31322858,4);
insert into consulta values(105,"2020/03/18 18:30:20","Laboratorio",68031918,1144182152,5);
insert into consulta values(106,"2020/03/19 18:30:20","Control",68031918,1144138193,6);
insert into consulta values(107,"2020/03/20 17:30:20","Exámenes",12349349,1130679339,7);
insert into consulta values(108,"2020/03/20 18:30:20","Control",68031918,67018365,8);
insert into consulta values(109,"2020/03/21 17:30:20","Laboratorio",68031918,1059448353,9);
insert into consulta values(110,"2020/03/21 18:30:20","Exámenes",12349349,1144128511,10);
insert into consulta values(111,"2020/03/22 17:30:20","Control",68031918,67018365,11);
insert into consulta values(112,"2020/03/22 18:30:20","Laboratorio",12349349,38680509,12);
