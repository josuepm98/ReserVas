CREATE SCHEMA `reservas` ;

CREATE TABLE `reservas`.`categoria` (
  `nombre` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`nombre`));
  
INSERT INTO `reservas`.`categoria` VALUES ('Peluqueria');
INSERT INTO `reservas`.`categoria` VALUES ('Spa');
INSERT INTO `reservas`.`categoria` VALUES ('Restaurante');
INSERT INTO `reservas`.`categoria` VALUES ('Gimnasio');
INSERT INTO `reservas`.`categoria` VALUES ('Medico');

CREATE TABLE `reservas`.`usuario` (
  `nombreUser` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `nombre` VARCHAR(255) NOT NULL,
  `apellidos` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `img` VARCHAR(255) NOT NULL DEFAULT 'src/main/resources/imagenes/Default.jpg',
  PRIMARY KEY (`nombreUser`));
  
CREATE TABLE `reservas`.`cliente` (
  `nombreUser` VARCHAR(255) NOT NULL,
  `fechaNac` DATE NOT NULL,
  PRIMARY KEY (`nombreUser`),
  CONSTRAINT `cliente_usuario`
    FOREIGN KEY (`nombreUser`)
    REFERENCES `reservas`.`usuario` (`nombreUser`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `reservas`.`empresa` (
  `nombreUser` VARCHAR(255) NOT NULL,
  `direccion` VARCHAR(255) NOT NULL,
  `categoria` VARCHAR(255) NOT NULL,
  `inicioJornada` VARCHAR(255) NULL,
  `finJornada` VARCHAR(255) NULL,
  `tiempoServicio` VARCHAR(255) NULL,
  PRIMARY KEY (`nombreUser`),
  INDEX `tablaEmpresa_categoria_idx` (`categoria` ASC) VISIBLE,
  CONSTRAINT `tablaEmpresa_categoria`
    FOREIGN KEY (`categoria`)
    REFERENCES `reservas`.`categoria` (`nombre`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `empresa_usuario`
    FOREIGN KEY (`nombreUser`)
    REFERENCES `reservas`.`usuario` (`nombreUser`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

INSERT INTO `reservas`.`usuario` (`nombreUser`, `password`, `nombre`, `apellidos`, `email`) VALUES ('clienteJose', 'cGBbJaKU33UhK4d6b72Y8w==', 'Jose', 'Jose Jose', 'jose@gmail.com');
INSERT INTO `reservas`.`usuario` (`nombreUser`, `password`, `nombre`, `apellidos`, `email`) VALUES ('clienteJosue', 'cGBbJaKU33UhK4d6b72Y8w==', 'Josue', 'Josue Josue', 'josue@gmail.com');
INSERT INTO `reservas`.`usuario` (`nombreUser`, `password`, `nombre`, `apellidos`, `email`) VALUES ('clienteJoaquin', 'cGBbJaKU33UhK4d6b72Y8w==', 'Joaquin', 'Joaquin Joaquin', 'joaquin@gmail.com');
INSERT INTO `reservas`.`usuario` (`nombreUser`, `password`, `nombre`, `apellidos`, `email`) VALUES ('clienteSameh', 'cGBbJaKU33UhK4d6b72Y8w==', 'Sameh', 'Sameh Sameh', 'sameh@gmail.com');

INSERT INTO `reservas`.`cliente` (`nombreUser`, `fechaNac`) VALUES ('clienteJose', '2000-05-10');
INSERT INTO `reservas`.`cliente` (`nombreUser`, `fechaNac`) VALUES ('clienteJosue', '2000-05-10');
INSERT INTO `reservas`.`cliente` (`nombreUser`, `fechaNac`) VALUES ('clienteJoaquin', '2000-05-10');
INSERT INTO `reservas`.`cliente` (`nombreUser`, `fechaNac`) VALUES ('clienteSameh', '2000-05-10');

INSERT INTO `reservas`.`usuario` (`nombreUser`, `password`, `nombre`, `apellidos`, `email`) VALUES ('empresaPeluqueria', 'cGBbJaKU33UhK4d6b72Y8w==', 'Peluqueria', 'Peluqueria Peluqueria', 'peluqueria@gmail.com');
INSERT INTO `reservas`.`usuario` (`nombreUser`, `password`, `nombre`, `apellidos`, `email`) VALUES ('empresaSpa1', 'cGBbJaKU33UhK4d6b72Y8w==', 'Spa1', 'Spa1 Spa1', 'spa1@gmail.com');
INSERT INTO `reservas`.`usuario` (`nombreUser`, `password`, `nombre`, `apellidos`, `email`) VALUES ('empresaSpa2', 'cGBbJaKU33UhK4d6b72Y8w==', 'Spa2', 'Spa2 Spa2', 'spa2@gmail.com');
INSERT INTO `reservas`.`usuario` (`nombreUser`, `password`, `nombre`, `apellidos`, `email`) VALUES ('empresaSpa3', 'cGBbJaKU33UhK4d6b72Y8w==', 'Spa3', 'Spa3 Spa3', 'spa3@gmail.com');
INSERT INTO `reservas`.`usuario` (`nombreUser`, `password`, `nombre`, `apellidos`, `email`) VALUES ('empresaRestaurante', 'cGBbJaKU33UhK4d6b72Y8w==', 'Restaurante', 'Restaurante Restaurante', 'restaurante@gmail.com');
INSERT INTO `reservas`.`usuario` (`nombreUser`, `password`, `nombre`, `apellidos`, `email`) VALUES ('empresaGimnasio1', 'cGBbJaKU33UhK4d6b72Y8w==', 'Gimnasio1', 'Gimnasio1 Gimnasio1', 'gimnasio1@gmail.com');
INSERT INTO `reservas`.`usuario` (`nombreUser`, `password`, `nombre`, `apellidos`, `email`) VALUES ('empresaGimnasio2', 'cGBbJaKU33UhK4d6b72Y8w==', 'Gimnasio2', 'Gimnasio2 Gimnasio2', 'gimnasio2@gmail.com');

INSERT INTO `reservas`.`empresa` (`nombreUser`, `direccion`, `categoria`) VALUES ('empresaPeluqueria', 'San Vicente', 'Peluqueria');
INSERT INTO `reservas`.`empresa` (`nombreUser`, `direccion`, `categoria`) VALUES ('empresaSpa1', 'Alicante', 'Spa');
INSERT INTO `reservas`.`empresa` (`nombreUser`, `direccion`, `categoria`) VALUES ('empresaSpa2', 'Aspe', 'Spa');
INSERT INTO `reservas`.`empresa` (`nombreUser`, `direccion`, `categoria`) VALUES ('empresaSpa3', 'Torrevieja', 'Spa');
INSERT INTO `reservas`.`empresa` (`nombreUser`, `direccion`, `categoria`) VALUES ('empresaRestaurante', 'Aspe', 'Restaurante');
INSERT INTO `reservas`.`empresa` (`nombreUser`, `direccion`, `categoria`) VALUES ('empresaGimnasio1', 'Alicante', 'Gimnasio');
INSERT INTO `reservas`.`empresa` (`nombreUser`, `direccion`, `categoria`) VALUES ('empresaGimnasio2', 'Elda', 'Gimnasio');

CREATE TABLE `reservas`.`servicio` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(255) NOT NULL,
  `direccion` VARCHAR(255) NOT NULL,
  `precio` DOUBLE NOT NULL,
  `fecha` DATE NOT NULL,
  `horaInicio` VARCHAR(255) NOT NULL,
  `horaFin` VARCHAR(255) NOT NULL,
  `estado` VARCHAR(255) NOT NULL,
  `empresa` VARCHAR(255) NOT NULL,
  `cliente` VARCHAR(255) NULL,
  PRIMARY KEY (`id`, `empresa`),
  INDEX `tablaServicio_empresa_idx` (`empresa` ASC) VISIBLE,
  INDEX `tablaServicio_cliente_idx` (`cliente` ASC) VISIBLE,
  CONSTRAINT `tablaServicio_empresa`
    FOREIGN KEY (`empresa`)
    REFERENCES `reservas`.`empresa` (`nombreUser`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `tablaServicio_cliente`
    FOREIGN KEY (`cliente`)
    REFERENCES `reservas`.`cliente` (`nombreUser`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
    
INSERT INTO `reservas`.`servicio` (id, nombre, direccion, precio, fecha, horaInicio, horaFin, estado, empresa,
cliente) VALUES (null, 'Corte de pelo', 'San Vicente', 11.5, '2021-06-20', '09:00', '09:30', 'LIBRE', 'empresaPeluqueria', null);

INSERT INTO `reservas`.`servicio` (id, nombre, direccion, precio, fecha, horaInicio, horaFin, estado, empresa,
cliente) VALUES (null, 'Corte de pelo', 'San Vicente', 11.5, '2021-06-20', '09:30', '10:00', 'RESERVADO', 'empresaPeluqueria', 'clienteJose');

INSERT INTO `reservas`.`servicio` (id, nombre, direccion, precio, fecha, horaInicio, horaFin, estado, empresa,
cliente) VALUES (null, 'Corte de pelo', 'San Vicente', 11.5, '2021-06-20', '10:00', '10:30', 'LIBRE', 'empresaPeluqueria', null);

INSERT INTO `reservas`.`servicio` (id, nombre, direccion, precio, fecha, horaInicio, horaFin, estado, empresa,
cliente) VALUES (null, 'Corte de pelo', 'San Vicente', 11.5, '2021-06-20', '10:30', '11:00', 'RESERVADO', 'empresaPeluqueria', 'clienteJosue');

INSERT INTO `reservas`.`servicio` (id, nombre, direccion, precio, fecha, horaInicio, horaFin, estado, empresa,
cliente) VALUES (null, 'Corte de pelo', 'San Vicente', 11.5, '2021-06-20', '11:00', '11:30', 'LIBRE', 'empresaPeluqueria', null);

INSERT INTO `reservas`.`servicio` (id, nombre, direccion, precio, fecha, horaInicio, horaFin, estado, empresa,
cliente) VALUES (null, 'Corte de pelo', 'San Vicente', 11.5, '2021-06-20', '11:30', '12:00', 'LIBRE', 'empresaPeluqueria', null);


INSERT INTO `reservas`.`servicio` (id, nombre, direccion, precio, fecha, horaInicio, horaFin, estado, empresa,
cliente) VALUES (null, 'Masaje', 'Alicante', 20, '2021-06-20', '09:00', '10:00', 'PLAN', 'empresaSpa1', null);

INSERT INTO `reservas`.`servicio` (id, nombre, direccion, precio, fecha, horaInicio, horaFin, estado, empresa,
cliente) VALUES (null, 'Masaje', 'Alicante', 20, '2021-06-20', '10:00', '11:00', 'PLAN', 'empresaSpa1', null);


INSERT INTO `reservas`.`servicio` (id, nombre, direccion, precio, fecha, horaInicio, horaFin, estado, empresa,
cliente) VALUES (null, 'Masaje', 'Aspe', 25, '2021-06-20', '11:00', '12:00', 'PLAN', 'empresaSpa2', null);

INSERT INTO `reservas`.`servicio` (id, nombre, direccion, precio, fecha, horaInicio, horaFin, estado, empresa,
cliente) VALUES (null, 'Masaje', 'Aspe', 25, '2021-06-20', '12:00', '13:00', 'RESERVADO', 'empresaSpa2', 'clienteSameh');


INSERT INTO `reservas`.`servicio` (id, nombre, direccion, precio, fecha, horaInicio, horaFin, estado, empresa,
cliente) VALUES (null, 'Masaje', 'Torrevieja', 30, '2021-06-20', '19:00', '20:00', 'PLAN', 'empresaSpa3', null);


INSERT INTO `reservas`.`servicio` (id, nombre, direccion, precio, fecha, horaInicio, horaFin, estado, empresa,
cliente) VALUES (null, 'Comida', 'Aspe', 0, '2021-06-20', '13:00', '15:00', 'PLAN', 'empresaRestaurante', null);


INSERT INTO `reservas`.`servicio` (id, nombre, direccion, precio, fecha, horaInicio, horaFin, estado, empresa,
cliente) VALUES (null, 'Gimnasio', 'Alicante', 3, '2021-06-20', '07:00', '08:00', 'RESERVADO', 'empresaGimnasio1', 'clienteJosue');

INSERT INTO `reservas`.`servicio` (id, nombre, direccion, precio, fecha, horaInicio, horaFin, estado, empresa,
cliente) VALUES (null, 'Gimnasio', 'Alicante', 3, '2021-06-20', '08:00', '09:00', 'PLAN', 'empresaGimnasio1', null);

INSERT INTO `reservas`.`servicio` (id, nombre, direccion, precio, fecha, horaInicio, horaFin, estado, empresa,
cliente) VALUES (null, 'Gimnasio', 'Alicante', 3, '2021-06-20', '09:00', '10:00', 'LIBRE', 'empresaGimnasio1', null);

INSERT INTO `reservas`.`servicio` (id, nombre, direccion, precio, fecha, horaInicio, horaFin, estado, empresa,
cliente) VALUES (null, 'Gimnasio', 'Alicante', 3, '2021-06-20', '10:00', '11:00', 'PLAN', 'empresaGimnasio1', null);

INSERT INTO `reservas`.`servicio` (id, nombre, direccion, precio, fecha, horaInicio, horaFin, estado, empresa,
cliente) VALUES (null, 'Gimnasio', 'Alicante', 3, '2021-06-20', '11:00', '12:00', 'PLAN', 'empresaGimnasio1', null);

CREATE TABLE `reservas`.`planes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `servicio_id` INT NOT NULL,
  `nombre` VARCHAR(255) NOT NULL,
  `descripcion` VARCHAR(255) NOT NULL,
  `precioTotal` DOUBLE NOT NULL,
  `estado` VARCHAR(255) NOT NULL,
  `cliente` VARCHAR(255) NULL,
  `img` VARCHAR(255) NOT NULL DEFAULT 'src/main/resources/imagenes/Default.jpg',
  PRIMARY KEY (`id`, `servicio_id`),
  INDEX `servicio_id_idx` (`servicio_id` ASC) VISIBLE,
  INDEX `tablaPlan_cliente_idx` (`cliente` ASC) VISIBLE,
  CONSTRAINT `servicio_id`
    FOREIGN KEY (`servicio_id`)
    REFERENCES `reservas`.`servicio` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
 CONSTRAINT `tablaPlan_cliente`
    FOREIGN KEY (`cliente`)
    REFERENCES `reservas`.`cliente` (`nombreUser`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
    
INSERT INTO `reservas`.`planes` (`id`, `servicio_id`, `nombre`, `descripcion`, `precioTotal`, `estado`, `cliente`) VALUES ('1', '7', 'Plan de spas', 'Disfruta de un día de relajación completo', '75', 'LIBRE', null);
INSERT INTO `reservas`.`planes` (`id`, `servicio_id`, `nombre`, `descripcion`, `precioTotal`, `estado`, `cliente`) VALUES ('1', '9', 'Plan de spas', 'Disfruta de un día de relajación completo', '75', 'LIBRE', null);
INSERT INTO `reservas`.`planes` (`id`, `servicio_id`, `nombre`, `descripcion`, `precioTotal`, `estado`, `cliente`) VALUES ('1', '11', 'Plan de spas', 'Disfruta de un día de relajación completo', '75', 'LIBRE', null);


INSERT INTO `reservas`.`planes` (`id`, `servicio_id`, `nombre`, `descripcion`, `precioTotal`, `estado`, `cliente`) VALUES ('2', '14', 'Día de actividad', '¡Llena tu día de acividades y aumenta tu energía!', '0', 'LIBRE', null);
INSERT INTO `reservas`.`planes` (`id`, `servicio_id`, `nombre`, `descripcion`, `precioTotal`, `estado`, `cliente`) VALUES ('2', '8', 'Día de actividad', '¡Llena tu día de acividades y aumenta tu energía!', '0', 'LIBRE', null);
INSERT INTO `reservas`.`planes` (`id`, `servicio_id`, `nombre`, `descripcion`, `precioTotal`, `estado`, `cliente`) VALUES ('2', '12', 'Día de actividad', '¡Llena tu día de acividades y aumenta tu energía!', '0', 'LIBRE', null);


INSERT INTO `reservas`.`planes` (`id`, `servicio_id`, `nombre`, `descripcion`, `precioTotal`, `estado`, `cliente`) VALUES ('3', '16', 'Fuerza máxima', 'Un día con extra de ejercicio, ¿te vas a rendir?', '6', 'LIBRE', null);
INSERT INTO `reservas`.`planes` (`id`, `servicio_id`, `nombre`, `descripcion`, `precioTotal`, `estado`, `cliente`) VALUES ('3', '17', 'Fuerza máxima', 'Un día con extra de ejercicio, ¿te vas a rendir?', '6', 'LIBRE', null);

