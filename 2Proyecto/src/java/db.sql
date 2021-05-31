drop database if exists cinema;
create database cinema;
use cinema;

drop table if exists `usuarios`;
create table `usuarios` (
    `id_usuario` varchar(9) not null,
    `clave` varchar(4) not null,
    `rol` int not null,
    primary key (`id_usuario`)
);

drop table if exists `administrador`;
create table `administrador` (
    `id_administrador` varchar(9) not null,
    `usuario_id` varchar(9) not null,
    `nombre` varchar(50) not null,    
    `email` varchar(50) not null,
    `telefono` varchar(8) default null,
    primary key (`id_administrador`),
    constraint `usuario_fk_admin` foreign key (`usuario_id`) references `usuarios` (`id_usuario`),
    constraint email_uk unique (`email`),
    constraint tel_uk unique (`telefono`)    
);

drop table if exists `cliente`;
create table `cliente` (
    `id_cliente` varchar(9) not null,
    `usuario_id` varchar(9) not null,
    `nombre` varchar(50) not null,    
    `email` varchar(50) not null,
    `telefono` varchar(8) default null,
    `tarjeta` varchar(16) not null,
    primary key (`id_cliente`),
    constraint `usuario_fk_cliente` foreign key (`usuario_id`) references `usuarios` (`id_usuario`),
    constraint email_uk unique (`email`),
    constraint tel_uk unique (`telefono`)
);

drop table if exists `peliculas`;
create table `peliculas` (
    `id_pelicula` varchar(3) not null,
    `nombre` varchar(50) not null,  
    primary key (`id_pelicula`)
);

drop table if exists `salas`;
create table `salas` (
    `id_sala` varchar(3) not null,
    `nombre` varchar(10) not null,  
    primary key (`id_sala`)
);

drop table if exists `proyecciones`;
create table `proyecciones` (
    `id_proyeccion` varchar(5) not null,
    `sala_id` varchar(3) not null, 
    `pelicula_id` varchar(3) not null,
    `fecha` date not null,
    primary key (`id_proyeccion`),
    constraint `proy_fk_sala` foreign key (`sala_id`) references `salas` (`id_sala`),
    constraint `proy_fk_peli` foreign key (`pelicula_id`) references `peliculas` (`id_pelicula`)
);


drop table if exists `tiquetes`;
create table `tiquetes` (
    `proyeccion_id` varchar(5) not null,
    `butaca` varchar(2) not null,
    `precio` int not null,
    `id_comprador` varchar(9) not null, 
    `cliente_id` varchar(9),
    primary key (`proyeccion_id`, `butaca`),
    constraint `tiq_fk_asiento` foreign key (`proyeccion_id`) references `proyecciones` (`id_proyeccion`),
    constraint `tiq_fk_cliente` foreign key (`cliente_id`) references `cliente` (`id_cliente`)
);



drop procedure if exists `proc_cliente_tiq`;
delimiter //
create procedure `proc_cliente_tiq`(`Pcomprador` varchar(9))
begin
    if `Pcomprador` in (select `id_cliente` from `cliente`) then 
        update `tiquetes`
        set `cliente_id` = `Pcomprador`
        where `id_comprador` = `Pcomprador`;
    end if;
end//
delimiter ;

insert into `usuarios`(`id_usuario`, `clave`, `rol`) values ('1111', 'qqqq', 1);
insert into `usuarios`(`id_usuario`, `clave`, `rol`) values ('2222', 'aaaa', 2);

insert into `administrador`(`id_administrador`, `usuario_id`, `nombre`, `email`, `telefono`)
    values
    ('1111', '1111', 'Joaquin', 'joaquin@cine.com', '12345611');
insert into `cliente`(`id_cliente`, `usuario_id`, `nombre`, `email`, `telefono`, `tarjeta`)
    values ('2222', '2222', 'Genaro', 'genaro@cine.com', '12345611', '9090123487127443');

-- insert into `peliculas`(`id_pelicula`, `nombre`) values ('P01', 'John Wick 3: Parabellum');

-- insert into `salas`(`id_sala`, `nombre`) values ('S01', 'Sala 1');

-- insert into `proyecciones`( `id_proyeccion`, `sala_id`, `pelicula_id`, `fecha`)
    -- values ('PR01', 'S01', 'P01', CURDATE());

-- insert into `tiquetes`(`id_tiquetes`, `proyeccion_id`, `butaca`, `precio`, `id_comprador`)
    -- values ('T01', 'PR01', 'B01', 3500, '2222');
-- call `proc_cliente_tiq`('2222');

-- insert into `tiquetes`(`id_tiquetes`, `proyeccion_id`, `butaca`, `precio`, `id_comprador`)
    -- values ('T02', 'PR01', 'B16', 3500, '3312');
-- call `proc_cliente_tiq`('3312');





