create table Servicios(
numero_servicio serial primary key,
placa_vehiculo varchar(10) not null,
marca_modelo_vehiculo varchar (20) not null,
nombre_apellido_cliente varchar(60) not null,
contacto_cliente varchar (8) not null,
dpi_cliente varchar (13) not null,
fecha_servicio date,
servicio_elegido varchar (15) not null,
tipo_de_pago varchar (20) not null
);

select * from Servicios;
drop table Servicios;