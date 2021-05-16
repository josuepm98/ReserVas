CREATE SCHEMA `reservas` ;

CREATE TABLE `reservas`.`categoria` (
  `nombre` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`nombre`));
  
INSERT INTO `reservas`.`categoria` VALUES ('Peluqueria');
INSERT INTO `reservas`.`categoria` VALUES ('Spa');
INSERT INTO `reservas`.`categoria` VALUES ('Restaurante');
INSERT INTO `reservas`.`categoria` VALUES ('Gimnasio');
INSERT INTO `reservas`.`categoria` VALUES ('Medico');
INSERT INTO `reservas`.`categoria` VALUES ('Psicologo');
INSERT INTO `reservas`.`categoria` VALUES ('Mascotas');
INSERT INTO `reservas`.`categoria` VALUES ('Depilacion');
INSERT INTO `reservas`.`categoria` VALUES ('Excursion');

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
INSERT INTO `reservas`.`usuario` (`nombreUser`, `password`, `nombre`, `apellidos`, `email`) VALUES ('clienteDario', 'cGBbJaKU33UhK4d6b72Y8w==', 'Dario', 'Dario Dario', 'dario@gmail.com');
INSERT INTO `reservas`.`usuario` (`nombreUser`, `password`, `nombre`, `apellidos`, `email`) VALUES ('clienteFele', 'cGBbJaKU33UhK4d6b72Y8w==', 'Fele', 'Fele Fele', 'fele@gmail.com');
INSERT INTO `reservas`.`usuario` (`nombreUser`, `password`, `nombre`, `apellidos`, `email`) VALUES ('clientePaula', 'cGBbJaKU33UhK4d6b72Y8w==', 'Paula', 'Paula Paula', 'paula@gmail.com');
INSERT INTO `reservas`.`usuario` (`nombreUser`, `password`, `nombre`, `apellidos`, `email`) VALUES ('cliente1', 'cGBbJaKU33UhK4d6b72Y8w==', 'Cliente1', 'Cliente1 Cliente1', 'cliente1@gmail.com');
INSERT INTO `reservas`.`usuario` (`nombreUser`, `password`, `nombre`, `apellidos`, `email`) VALUES ('cliente2', 'cGBbJaKU33UhK4d6b72Y8w==', 'Cliente2', 'Cliente2 Cliente2', 'cliente2@gmail.com');
INSERT INTO `reservas`.`usuario` (`nombreUser`, `password`, `nombre`, `apellidos`, `email`) VALUES ('cliente3', 'cGBbJaKU33UhK4d6b72Y8w==', 'Cliente3', 'Cliente3 Cliente3', 'cliente3@gmail.com');
INSERT INTO `reservas`.`usuario` (`nombreUser`, `password`, `nombre`, `apellidos`, `email`) VALUES ('cliente4', 'cGBbJaKU33UhK4d6b72Y8w==', 'Cliente4', 'Cliente4 Cliente4', 'cliente4@gmail.com');
INSERT INTO `reservas`.`usuario` (`nombreUser`, `password`, `nombre`, `apellidos`, `email`) VALUES ('cliente5', 'cGBbJaKU33UhK4d6b72Y8w==', 'Cliente5', 'Cliente5 Cliente5', 'cliente5@gmail.com');
INSERT INTO `reservas`.`usuario` (`nombreUser`, `password`, `nombre`, `apellidos`, `email`) VALUES ('cliente6', 'cGBbJaKU33UhK4d6b72Y8w==', 'Cliente6', 'Cliente6 Cliente6', 'cliente6@gmail.com');
INSERT INTO `reservas`.`usuario` (`nombreUser`, `password`, `nombre`, `apellidos`, `email`) VALUES ('cliente7', 'cGBbJaKU33UhK4d6b72Y8w==', 'Cliente7', 'Cliente7 Cliente7', 'cliente7@gmail.com');
INSERT INTO `reservas`.`usuario` (`nombreUser`, `password`, `nombre`, `apellidos`, `email`) VALUES ('cliente8', 'cGBbJaKU33UhK4d6b72Y8w==', 'Cliente8', 'Cliente8 Cliente8', 'cliente8@gmail.com');
INSERT INTO `reservas`.`usuario` (`nombreUser`, `password`, `nombre`, `apellidos`, `email`) VALUES ('cliente9', 'cGBbJaKU33UhK4d6b72Y8w==', 'Cliente9', 'Cliente9 Cliente9', 'cliente9@gmail.com');
INSERT INTO `reservas`.`usuario` (`nombreUser`, `password`, `nombre`, `apellidos`, `email`) VALUES ('cliente10', 'cGBbJaKU33UhK4d6b72Y8w==', 'Cliente10', 'Cliente10 Cliente10', 'cliente10@gmail.com');

INSERT INTO `reservas`.`cliente` (`nombreUser`, `fechaNac`) VALUES ('clienteJose', '2000-05-10');
INSERT INTO `reservas`.`cliente` (`nombreUser`, `fechaNac`) VALUES ('clienteJosue', '2000-05-10');
INSERT INTO `reservas`.`cliente` (`nombreUser`, `fechaNac`) VALUES ('clienteJoaquin', '2000-05-10');
INSERT INTO `reservas`.`cliente` (`nombreUser`, `fechaNac`) VALUES ('clienteSameh', '2000-05-10');
INSERT INTO `reservas`.`cliente` (`nombreUser`, `fechaNac`) VALUES ('clienteDario', '2000-05-20');
INSERT INTO `reservas`.`cliente` (`nombreUser`, `fechaNac`) VALUES ('clienteFele', '1998-03-10');
INSERT INTO `reservas`.`cliente` (`nombreUser`, `fechaNac`) VALUES ('clientePaula', '1996-08-15');
INSERT INTO `reservas`.`cliente` (`nombreUser`, `fechaNac`) VALUES ('cliente1', '2000-02-10');
INSERT INTO `reservas`.`cliente` (`nombreUser`, `fechaNac`) VALUES ('cliente2', '2000-09-10');
INSERT INTO `reservas`.`cliente` (`nombreUser`, `fechaNac`) VALUES ('cliente3', '2000-10-06');
INSERT INTO `reservas`.`cliente` (`nombreUser`, `fechaNac`) VALUES ('cliente4', '2000-01-08');
INSERT INTO `reservas`.`cliente` (`nombreUser`, `fechaNac`) VALUES ('cliente5', '1980-12-22');
INSERT INTO `reservas`.`cliente` (`nombreUser`, `fechaNac`) VALUES ('cliente6', '1998-01-01');
INSERT INTO `reservas`.`cliente` (`nombreUser`, `fechaNac`) VALUES ('cliente7', '1992-02-19');
INSERT INTO `reservas`.`cliente` (`nombreUser`, `fechaNac`) VALUES ('cliente8', '1975-06-17');
INSERT INTO `reservas`.`cliente` (`nombreUser`, `fechaNac`) VALUES ('cliente9', '1990-09-11');
INSERT INTO `reservas`.`cliente` (`nombreUser`, `fechaNac`) VALUES ('cliente10', '2000-07-07');

INSERT INTO `reservas`.`usuario` (`nombreUser`, `password`, `nombre`, `apellidos`, `email`) VALUES ('empresaPeluqueria', 'cGBbJaKU33UhK4d6b72Y8w==', 'Peluqueria', 'Peluqueria Peluqueria', 'peluqueria@gmail.com');
INSERT INTO `reservas`.`usuario` (`nombreUser`, `password`, `nombre`, `apellidos`, `email`) VALUES ('empresaPeluqueria1', 'cGBbJaKU33UhK4d6b72Y8w==', 'Peluqueria1', 'Peluqueria1 Peluqueria1', 'peluqueria1@gmail.com');
INSERT INTO `reservas`.`usuario` (`nombreUser`, `password`, `nombre`, `apellidos`, `email`) VALUES ('empresaPeluqueria2', 'cGBbJaKU33UhK4d6b72Y8w==', 'Peluqueria2', 'Peluqueria2 Peluqueria2', 'peluqueria2@gmail.com');
INSERT INTO `reservas`.`usuario` (`nombreUser`, `password`, `nombre`, `apellidos`, `email`) VALUES ('empresaPeluqueria3', 'cGBbJaKU33UhK4d6b72Y8w==', 'Peluqueria3', 'Peluqueria3 Peluqueria3', 'peluqueria3@gmail.com');
INSERT INTO `reservas`.`usuario` (`nombreUser`, `password`, `nombre`, `apellidos`, `email`) VALUES ('empresaSpa1', 'cGBbJaKU33UhK4d6b72Y8w==', 'Spa1', 'Spa1 Spa1', 'spa1@gmail.com');
INSERT INTO `reservas`.`usuario` (`nombreUser`, `password`, `nombre`, `apellidos`, `email`) VALUES ('empresaSpa2', 'cGBbJaKU33UhK4d6b72Y8w==', 'Spa2', 'Spa2 Spa2', 'spa2@gmail.com');
INSERT INTO `reservas`.`usuario` (`nombreUser`, `password`, `nombre`, `apellidos`, `email`) VALUES ('empresaSpa3', 'cGBbJaKU33UhK4d6b72Y8w==', 'Spa3', 'Spa3 Spa3', 'spa3@gmail.com');
INSERT INTO `reservas`.`usuario` (`nombreUser`, `password`, `nombre`, `apellidos`, `email`) VALUES ('empresaRestaurante', 'cGBbJaKU33UhK4d6b72Y8w==', 'Restaurante', 'Restaurante Restaurante', 'restaurante@gmail.com');
INSERT INTO `reservas`.`usuario` (`nombreUser`, `password`, `nombre`, `apellidos`, `email`, `img`) VALUES ('empresaRestaurante1', 'cGBbJaKU33UhK4d6b72Y8w==', 'Restaurante1', 'Restaurante1 Restaurante1', 'restaurante1@gmail.com', 'https://firebasestorage.googleapis.com/v0/b/taes-imagenes.appspot.com/o/restaurante1.jpg?alt=media&token=1934ba25-2f1c-4257-8812-c9ca0f9c951c');
INSERT INTO `reservas`.`usuario` (`nombreUser`, `password`, `nombre`, `apellidos`, `email`, `img`) VALUES ('empresaRestaurante2', 'cGBbJaKU33UhK4d6b72Y8w==', 'Restaurante2', 'Restaurante2 Restaurante2', 'restaurante2@gmail.com', 'https://firebasestorage.googleapis.com/v0/b/taes-imagenes.appspot.com/o/restaurante2.jpeg?alt=media&token=705042fe-f201-469d-aa83-6aac2e1fb033');
INSERT INTO `reservas`.`usuario` (`nombreUser`, `password`, `nombre`, `apellidos`, `email`, `img`) VALUES ('empresaRestaurante3', 'cGBbJaKU33UhK4d6b72Y8w==', 'Restaurante3', 'Restaurante3 Restaurante3', 'restaurante3@gmail.com', 'https://firebasestorage.googleapis.com/v0/b/taes-imagenes.appspot.com/o/restaurante3.jpg?alt=media&token=1afb70e1-1d9b-44e4-bc0a-555bf849f2f1');
INSERT INTO `reservas`.`usuario` (`nombreUser`, `password`, `nombre`, `apellidos`, `email`) VALUES ('empresaGimnasio1', 'cGBbJaKU33UhK4d6b72Y8w==', 'Gimnasio1', 'Gimnasio1 Gimnasio1', 'gimnasio1@gmail.com');
INSERT INTO `reservas`.`usuario` (`nombreUser`, `password`, `nombre`, `apellidos`, `email`) VALUES ('empresaGimnasio2', 'cGBbJaKU33UhK4d6b72Y8w==', 'Gimnasio2', 'Gimnasio2 Gimnasio2', 'gimnasio2@gmail.com');
INSERT INTO `reservas`.`usuario` (`nombreUser`, `password`, `nombre`, `apellidos`, `email`, `img`) VALUES ('empresaMedico1', 'cGBbJaKU33UhK4d6b72Y8w==', 'Medico1', 'Medico1 Medico1', 'medico1@gmail.com', 'https://firebasestorage.googleapis.com/v0/b/taes-imagenes.appspot.com/o/medico1.jpg?alt=media&token=7f6da578-5350-4cfe-acb6-76352d390531');
INSERT INTO `reservas`.`usuario` (`nombreUser`, `password`, `nombre`, `apellidos`, `email`) VALUES ('empresaPsicologo1', 'cGBbJaKU33UhK4d6b72Y8w==', 'Psicologo1', 'Psicologo1 Psicologo1', 'psicologo1@gmail.com');
INSERT INTO `reservas`.`usuario` (`nombreUser`, `password`, `nombre`, `apellidos`, `email`) VALUES ('empresaPsicologo2', 'cGBbJaKU33UhK4d6b72Y8w==', 'Psicologo2', 'Psicologo2 Psicologo2', 'psicologo2@gmail.com');
INSERT INTO `reservas`.`usuario` (`nombreUser`, `password`, `nombre`, `apellidos`, `email`, `img`) VALUES ('empresaMascotas1', 'cGBbJaKU33UhK4d6b72Y8w==', 'Mascotas1', 'Mascotas1 Mascotas1', 'mascotas1@gmail.com', 'https://firebasestorage.googleapis.com/v0/b/taes-imagenes.appspot.com/o/mascotas1.png?alt=media&token=0b833827-c162-426d-a54e-42ba8e6c1ecc');
INSERT INTO `reservas`.`usuario` (`nombreUser`, `password`, `nombre`, `apellidos`, `email`, `img`) VALUES ('empresaMascotas2', 'cGBbJaKU33UhK4d6b72Y8w==', 'Mascotas2', 'Mascotas2 Mascotas2', 'mascotas2@gmail.com', 'https://firebasestorage.googleapis.com/v0/b/taes-imagenes.appspot.com/o/mascotas2.jpeg?alt=media&token=6b9f5b78-cd74-4799-a738-5ae6adfb2515');
INSERT INTO `reservas`.`usuario` (`nombreUser`, `password`, `nombre`, `apellidos`, `email`) VALUES ('empresaDepilacion1', 'cGBbJaKU33UhK4d6b72Y8w==', 'Depilacion1', 'Depilacion1 Depilacion1', 'depilacion1@gmail.com');
INSERT INTO `reservas`.`usuario` (`nombreUser`, `password`, `nombre`, `apellidos`, `email`) VALUES ('empresaExcursion1', 'cGBbJaKU33UhK4d6b72Y8w==', 'Excursion1', 'Excursion1 Excursion1', 'excursion1@gmail.com');
INSERT INTO `reservas`.`usuario` (`nombreUser`, `password`, `nombre`, `apellidos`, `email`) VALUES ('empresaExcursion2', 'cGBbJaKU33UhK4d6b72Y8w==', 'Excursion2', 'Excursion2 Excursion2', 'excursion2@gmail.com');

INSERT INTO `reservas`.`empresa` (`nombreUser`, `direccion`, `categoria`) VALUES ('empresaPeluqueria', 'San Vicente', 'Peluqueria');
INSERT INTO `reservas`.`empresa` (`nombreUser`, `direccion`, `categoria`) VALUES ('empresaPeluqueria1', 'Granada', 'Peluqueria');
INSERT INTO `reservas`.`empresa` (`nombreUser`, `direccion`, `categoria`) VALUES ('empresaPeluqueria2', 'Murcia', 'Peluqueria');
INSERT INTO `reservas`.`empresa` (`nombreUser`, `direccion`, `categoria`) VALUES ('empresaPeluqueria3', 'Novelda', 'Peluqueria');
INSERT INTO `reservas`.`empresa` (`nombreUser`, `direccion`, `categoria`) VALUES ('empresaSpa1', 'Alicante', 'Spa');
INSERT INTO `reservas`.`empresa` (`nombreUser`, `direccion`, `categoria`) VALUES ('empresaSpa2', 'Aspe', 'Spa');
INSERT INTO `reservas`.`empresa` (`nombreUser`, `direccion`, `categoria`) VALUES ('empresaSpa3', 'Torrevieja', 'Spa');
INSERT INTO `reservas`.`empresa` (`nombreUser`, `direccion`, `categoria`) VALUES ('empresaRestaurante', 'Aspe', 'Restaurante');
INSERT INTO `reservas`.`empresa` (`nombreUser`, `direccion`, `categoria`) VALUES ('empresaRestaurante1', 'Monforte', 'Restaurante');
INSERT INTO `reservas`.`empresa` (`nombreUser`, `direccion`, `categoria`) VALUES ('empresaRestaurante2', 'Elda', 'Restaurante');
INSERT INTO `reservas`.`empresa` (`nombreUser`, `direccion`, `categoria`) VALUES ('empresaRestaurante3', 'Petrer', 'Restaurante');
INSERT INTO `reservas`.`empresa` (`nombreUser`, `direccion`, `categoria`) VALUES ('empresaGimnasio1', 'Alicante', 'Gimnasio');
INSERT INTO `reservas`.`empresa` (`nombreUser`, `direccion`, `categoria`) VALUES ('empresaGimnasio2', 'Elda', 'Gimnasio');
INSERT INTO `reservas`.`empresa` (`nombreUser`, `direccion`, `categoria`) VALUES ('empresaMedico1', 'Polonia', 'Medico');
INSERT INTO `reservas`.`empresa` (`nombreUser`, `direccion`, `categoria`) VALUES ('empresaPsicologo1', 'Barcelona', 'Psicologo');
INSERT INTO `reservas`.`empresa` (`nombreUser`, `direccion`, `categoria`) VALUES ('empresaPsicologo2', 'Madrid', 'Psicologo');
INSERT INTO `reservas`.`empresa` (`nombreUser`, `direccion`, `categoria`) VALUES ('empresaMascotas1', 'Aspe', 'Mascotas');
INSERT INTO `reservas`.`empresa` (`nombreUser`, `direccion`, `categoria`) VALUES ('empresaMascotas2', 'Torrevieja', 'Mascotas');
INSERT INTO `reservas`.`empresa` (`nombreUser`, `direccion`, `categoria`) VALUES ('empresaDepilacion1', 'Mexico', 'Depilacion');
INSERT INTO `reservas`.`empresa` (`nombreUser`, `direccion`, `categoria`) VALUES ('empresaExcursion1', 'Denia', 'Excursion');
INSERT INTO `reservas`.`empresa` (`nombreUser`, `direccion`, `categoria`) VALUES ('empresaExcursion2', 'Villena', 'Excursion');

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
    
INSERT INTO `reservas`.`servicio` (id, nombre, direccion, precio, fecha, horaInicio, horaFin, estado, empresa, cliente) VALUES 
	(1, 'Corte de pelo', 'San Vicente', 11.5, '2021-06-22', '09:00', '09:30', 'LIBRE', 'empresaPeluqueria', null),
	(2, 'Corte de pelo', 'San Vicente', 11.5, '2021-06-22', '09:30', '10:00', 'RESERVADO', 'empresaPeluqueria', 'clienteJose'),
    (3, 'Corte de pelo', 'San Vicente', 11.5, '2021-06-22', '10:00', '10:30', 'LIBRE', 'empresaPeluqueria', null),
    (4, 'Corte de pelo', 'San Vicente', 11.5, '2021-06-22', '10:30', '11:00', 'RESERVADO', 'empresaPeluqueria', 'clienteJosue'),
    (5, 'Corte de pelo', 'San Vicente', 11.5, '2021-06-22', '11:00', '11:30', 'LIBRE', 'empresaPeluqueria', null),
    (6, 'Corte de pelo', 'San Vicente', 11.5, '2021-06-22', '11:30', '12:00', 'LIBRE', 'empresaPeluqueria', null),
    (7, 'Corte de pelo', 'San Vicente', 11.5, '2021-06-22', '12:00', '12:30', 'LIBRE', 'empresaPeluqueria', null),
    (8, 'Corte de pelo', 'San Vicente', 11.5, '2021-06-22', '12:30', '13:00', 'LIBRE', 'empresaPeluqueria', null),
    (9, 'Corte de pelo', 'San Vicente', 11.5, '2021-06-23', '09:00', '09:30', 'LIBRE', 'empresaPeluqueria', null),
	(10, 'Corte de pelo', 'San Vicente', 11.5, '2021-06-23', '09:30', '10:00', 'LIBRE', 'empresaPeluqueria', null),
    (11, 'Corte de pelo', 'San Vicente', 11.5, '2021-06-23', '10:00', '10:30', 'LIBRE', 'empresaPeluqueria', null),
    (12, 'Corte de pelo', 'San Vicente', 11.5, '2021-06-23', '10:30', '11:00', 'LIBRE', 'empresaPeluqueria', null),
    (13, 'Corte de pelo', 'San Vicente', 11.5, '2021-06-23', '11:00', '11:30', 'LIBRE', 'empresaPeluqueria', null),
    (14, 'Corte de pelo', 'San Vicente', 11.5, '2021-06-23', '11:30', '12:00', 'LIBRE', 'empresaPeluqueria', null),
    (15, 'Corte de pelo', 'San Vicente', 11.5, '2021-06-23', '12:00', '12:30', 'LIBRE', 'empresaPeluqueria', null),
    (16, 'Corte de pelo', 'San Vicente', 11.5, '2021-06-23', '12:30', '13:00', 'LIBRE', 'empresaPeluqueria', null),
    (17, 'Corte de pelo', 'San Vicente', 11.5, '2021-06-24', '09:00', '09:30', 'LIBRE', 'empresaPeluqueria', null),
	(18, 'Corte de pelo', 'San Vicente', 11.5, '2021-06-24', '09:30', '10:00', 'LIBRE', 'empresaPeluqueria', null),
    (19, 'Corte de pelo', 'San Vicente', 11.5, '2021-06-24', '10:00', '10:30', 'LIBRE', 'empresaPeluqueria', null),
    (20, 'Corte de pelo', 'San Vicente', 11.5, '2021-06-24', '10:30', '11:00', 'LIBRE', 'empresaPeluqueria', null),
    (21, 'Corte de pelo', 'San Vicente', 11.5, '2021-06-24', '11:00', '11:30', 'LIBRE', 'empresaPeluqueria', null),
    (22, 'Corte de pelo', 'San Vicente', 11.5, '2021-06-24', '11:30', '12:00', 'LIBRE', 'empresaPeluqueria', null),
    (23, 'Corte de pelo', 'San Vicente', 11.5, '2021-06-24', '12:00', '12:30', 'LIBRE', 'empresaPeluqueria', null),
    (24, 'Corte de pelo', 'San Vicente', 11.5, '2021-06-24', '12:30', '13:00', 'LIBRE', 'empresaPeluqueria', null),
    (25, 'Corte de pelo', 'San Vicente', 11.5, '2021-06-25', '09:00', '09:30', 'LIBRE', 'empresaPeluqueria', null),
	(26, 'Corte de pelo', 'San Vicente', 11.5, '2021-06-25', '09:30', '10:00', 'LIBRE', 'empresaPeluqueria', null),
    (27, 'Corte de pelo', 'San Vicente', 11.5, '2021-06-25', '10:00', '10:30', 'LIBRE', 'empresaPeluqueria', null),
    (28, 'Corte de pelo', 'San Vicente', 11.5, '2021-06-25', '10:30', '11:00', 'LIBRE', 'empresaPeluqueria', null),
    (29, 'Corte de pelo', 'San Vicente', 11.5, '2021-06-25', '11:00', '11:30', 'LIBRE', 'empresaPeluqueria', null),
    (30, 'Corte de pelo', 'San Vicente', 11.5, '2021-06-25', '11:30', '12:00', 'LIBRE', 'empresaPeluqueria', null),
    (31, 'Corte de pelo', 'San Vicente', 11.5, '2021-06-25', '12:00', '12:30', 'LIBRE', 'empresaPeluqueria', null),
    (32, 'Corte de pelo', 'San Vicente', 11.5, '2021-06-25', '12:30', '13:00', 'LIBRE', 'empresaPeluqueria', null),
    (33, 'Corte de pelo', 'San Vicente', 11.5, '2021-06-26', '09:00', '09:30', 'LIBRE', 'empresaPeluqueria', null),
	(34, 'Corte de pelo', 'San Vicente', 11.5, '2021-06-26', '09:30', '10:00', 'LIBRE', 'empresaPeluqueria', null),
    (35, 'Corte de pelo', 'San Vicente', 11.5, '2021-06-26', '10:00', '10:30', 'LIBRE', 'empresaPeluqueria', null),
    (36, 'Corte de pelo', 'San Vicente', 11.5, '2021-06-26', '10:30', '11:00', 'LIBRE', 'empresaPeluqueria', null),
    (37, 'Corte de pelo', 'San Vicente', 11.5, '2021-06-26', '11:00', '11:30', 'LIBRE', 'empresaPeluqueria', null),
    (38, 'Corte de pelo', 'San Vicente', 11.5, '2021-06-26', '11:30', '12:00', 'LIBRE', 'empresaPeluqueria', null),
    (39, 'Corte de pelo', 'San Vicente', 11.5, '2021-06-26', '12:00', '12:30', 'LIBRE', 'empresaPeluqueria', null),
    (40, 'Corte de pelo', 'San Vicente', 11.5, '2021-06-26', '12:30', '13:00', 'LIBRE', 'empresaPeluqueria', null);

INSERT INTO `reservas`.`servicio` (id, nombre, direccion, precio, fecha, horaInicio, horaFin, estado, empresa, cliente) VALUES 
	(41, 'Corte de pelo señora', 'Granada', 15, '2021-06-22', '09:00', '09:30', 'RESERVADO', 'empresaPeluqueria1', 'clientePaula'),
	(42, 'Corte de pelo señora', 'Granada', 15, '2021-06-22', '09:30', '10:00', 'LIBRE', 'empresaPeluqueria1', null),
    (43, 'Corte de pelo señora', 'Granada', 15, '2021-06-22', '10:00', '10:30', 'LIBRE', 'empresaPeluqueria1', null),
    (44, 'Corte de pelo señora', 'Granada', 15, '2021-06-22', '10:30', '11:00', 'LIBRE', 'empresaPeluqueria1', null),
    (45, 'Corte de pelo señora', 'Granada', 15, '2021-06-22', '11:00', '11:30', 'LIBRE', 'empresaPeluqueria1', null),
    (46, 'Corte de pelo señora', 'Granada', 15, '2021-06-22', '11:30', '12:00', 'LIBRE', 'empresaPeluqueria1', null),
    (47, 'Corte de pelo señora', 'Granada', 15, '2021-06-22', '12:00', '12:30', 'LIBRE', 'empresaPeluqueria1', null),
    (48, 'Corte de pelo señora', 'Granada', 15, '2021-06-23', '09:00', '09:30', 'LIBRE', 'empresaPeluqueria1', null),
	(49, 'Corte de pelo señora', 'Granada', 15, '2021-06-23', '09:30', '10:00', 'LIBRE', 'empresaPeluqueria1', null),
    (50, 'Corte de pelo señora', 'Granada', 15, '2021-06-23', '10:00', '10:30', 'LIBRE', 'empresaPeluqueria1', null),
    (51, 'Corte de pelo señora', 'Granada', 15, '2021-06-23', '10:30', '11:00', 'LIBRE', 'empresaPeluqueria1', null),
    (52, 'Corte de pelo señora', 'Granada', 15, '2021-06-23', '11:00', '11:30', 'LIBRE', 'empresaPeluqueria1', null),
    (53, 'Corte de pelo señora', 'Granada', 15, '2021-06-23', '11:30', '12:00', 'LIBRE', 'empresaPeluqueria1', null),
    (54, 'Corte de pelo señora', 'Granada', 15, '2021-06-23', '12:00', '12:30', 'LIBRE', 'empresaPeluqueria1', null),
    (55, 'Corte de pelo señora', 'Granada', 15, '2021-06-24', '09:00', '09:30', 'LIBRE', 'empresaPeluqueria1', null),
	(56, 'Corte de pelo señora', 'Granada', 15, '2021-06-24', '09:30', '10:00', 'LIBRE', 'empresaPeluqueria1', null),
    (57, 'Corte de pelo señora', 'Granada', 15, '2021-06-24', '10:00', '10:30', 'LIBRE', 'empresaPeluqueria1', null),
    (58, 'Corte de pelo señora', 'Granada', 15, '2021-06-24', '10:30', '11:00', 'LIBRE', 'empresaPeluqueria1', null),
    (59, 'Corte de pelo señora', 'Granada', 15, '2021-06-24', '11:00', '11:30', 'LIBRE', 'empresaPeluqueria1', null),
    (60, 'Corte de pelo señora', 'Granada', 15, '2021-06-24', '11:30', '12:00', 'LIBRE', 'empresaPeluqueria1', null),
    (61, 'Corte de pelo señora', 'Granada', 15, '2021-06-24', '12:00', '12:30', 'LIBRE', 'empresaPeluqueria1', null),
    (62, 'Corte de pelo señora', 'Granada', 15, '2021-06-25', '09:00', '09:30', 'LIBRE', 'empresaPeluqueria1', null),
	(63, 'Corte de pelo señora', 'Granada', 15, '2021-06-25', '09:30', '10:00', 'LIBRE', 'empresaPeluqueria1', null),
    (64, 'Corte de pelo señora', 'Granada', 15, '2021-06-25', '10:00', '10:30', 'LIBRE', 'empresaPeluqueria1', null),
    (65, 'Corte de pelo señora', 'Granada', 15, '2021-06-25', '10:30', '11:00', 'LIBRE', 'empresaPeluqueria1', null),
    (66, 'Corte de pelo señora', 'Granada', 15, '2021-06-25', '11:00', '11:30', 'LIBRE', 'empresaPeluqueria1', null),
    (67, 'Corte de pelo señora', 'Granada', 15, '2021-06-25', '11:30', '12:00', 'LIBRE', 'empresaPeluqueria1', null),
    (68, 'Corte de pelo señora', 'Granada', 15, '2021-06-25', '12:00', '12:30', 'LIBRE', 'empresaPeluqueria1', null);
    
INSERT INTO `reservas`.`servicio` (id, nombre, direccion, precio, fecha, horaInicio, horaFin, estado, empresa, cliente) VALUES 
	(69, 'Corte de pelo masculino', 'Murcia', 12, '2021-06-23', '09:00', '09:30', 'LIBRE', 'empresaPeluqueria2', null),
	(70, 'Corte de pelo masculino', 'Murcia', 12, '2021-06-23', '09:30', '10:00', 'LIBRE', 'empresaPeluqueria2', null),
    (71, 'Corte de pelo masculino', 'Murcia', 12, '2021-06-23', '10:00', '10:30', 'LIBRE', 'empresaPeluqueria2', null),
    (72, 'Corte de pelo masculino', 'Murcia', 12, '2021-06-23', '10:30', '11:00', 'LIBRE', 'empresaPeluqueria2', null),
    (73, 'Corte de pelo masculino', 'Murcia', 12, '2021-06-24', '09:00', '09:30', 'LIBRE', 'empresaPeluqueria2', null),
	(74, 'Corte de pelo masculino', 'Murcia', 12, '2021-06-24', '09:30', '10:00', 'LIBRE', 'empresaPeluqueria2', null),
    (75, 'Corte de pelo masculino', 'Murcia', 12, '2021-06-24', '10:00', '10:30', 'LIBRE', 'empresaPeluqueria2', null),
    (76, 'Corte de pelo masculino', 'Murcia', 12, '2021-06-24', '10:30', '11:00', 'LIBRE', 'empresaPeluqueria2', null),
    (77, 'Corte de pelo masculino', 'Murcia', 12, '2021-06-25', '09:00', '09:30', 'LIBRE', 'empresaPeluqueria2', null),
	(78, 'Corte de pelo masculino', 'Murcia', 12, '2021-06-25', '09:30', '10:00', 'LIBRE', 'empresaPeluqueria2', null),
    (79, 'Corte de pelo masculino', 'Murcia', 12, '2021-06-25', '10:00', '10:30', 'LIBRE', 'empresaPeluqueria2', null),
    (80, 'Corte de pelo masculino', 'Murcia', 12, '2021-06-25', '10:30', '11:00', 'LIBRE', 'empresaPeluqueria2', null);

INSERT INTO `reservas`.`servicio` (id, nombre, direccion, precio, fecha, horaInicio, horaFin, estado, empresa, cliente) VALUES 
	(80, 'Corte de pelo', 'Novelda', 10, '2021-06-23', '09:00', '09:30', 'LIBRE', 'empresaPeluqueria3', null),
	(81, 'Corte de pelo', 'Novelda', 10, '2021-06-23', '09:30', '10:00', 'LIBRE', 'empresaPeluqueria3', null),
    (82, 'Corte de pelo', 'Novelda', 10, '2021-06-23', '10:00', '10:30', 'LIBRE', 'empresaPeluqueria3', null),
    (83, 'Corte de pelo', 'Novelda', 10, '2021-06-23', '10:30', '11:00', 'LIBRE', 'empresaPeluqueria3', null),
    (84, 'Corte de pelo', 'Novelda', 10, '2021-06-24', '09:00', '09:30', 'LIBRE', 'empresaPeluqueria3', null),
	(85, 'Corte de pelo', 'Novelda', 10, '2021-06-24', '09:30', '10:00', 'LIBRE', 'empresaPeluqueria3', null),
    (86, 'Corte de pelo', 'Novelda', 10, '2021-06-24', '10:00', '10:30', 'LIBRE', 'empresaPeluqueria3', null),
    (87, 'Corte de pelo', 'Novelda', 10, '2021-06-24', '10:30', '11:00', 'LIBRE', 'empresaPeluqueria3', null),
    (88, 'Corte de pelo', 'Novelda', 10, '2021-06-25', '09:00', '09:30', 'LIBRE', 'empresaPeluqueria3', null),
	(89, 'Corte de pelo', 'Novelda', 10, '2021-06-25', '09:30', '10:00', 'LIBRE', 'empresaPeluqueria3', null),
    (90, 'Corte de pelo', 'Novelda', 10, '2021-06-25', '10:00', '10:30', 'LIBRE', 'empresaPeluqueria3', null),
    (91, 'Corte de pelo', 'Novelda', 10, '2021-06-25', '10:30', '11:00', 'LIBRE', 'empresaPeluqueria3', null),
    (92, 'Corte de pelo', 'Novelda', 10, '2021-06-26', '09:00', '09:30', 'LIBRE', 'empresaPeluqueria3', null),
	(93, 'Corte de pelo', 'Novelda', 10, '2021-06-26', '09:30', '10:00', 'LIBRE', 'empresaPeluqueria3', null),
    (94, 'Corte de pelo', 'Novelda', 10, '2021-06-26', '10:00', '10:30', 'LIBRE', 'empresaPeluqueria3', null),
    (95, 'Corte de pelo', 'Novelda', 10, '2021-06-26', '10:30', '11:00', 'LIBRE', 'empresaPeluqueria3', null);

INSERT INTO `reservas`.`servicio` (id, nombre, direccion, precio, fecha, horaInicio, horaFin, estado, empresa, cliente) VALUES
	(96, 'Masaje', 'Alicante', 20, '2021-06-21', '09:00', '10:00', 'LIBRE', 'empresaSpa1', null),
	(97, 'Masaje', 'Alicante', 20, '2021-06-21', '10:00', '11:00', 'LIBRE', 'empresaSpa1', null),
    (98, 'Masaje', 'Alicante', 20, '2021-06-21', '11:00', '12:00', 'LIBRE', 'empresaSpa1', null),
    (99, 'Masaje', 'Alicante', 20, '2021-06-21', '12:00', '13:00', 'LIBRE', 'empresaSpa1', null),
    (100, 'Masaje', 'Alicante', 20, '2021-06-21', '13:00', '14:00', 'LIBRE', 'empresaSpa1', null),
    (101, 'Masaje', 'Alicante', 20, '2021-06-21', '16:00', '17:00', 'LIBRE', 'empresaSpa1', null),
    (102, 'Masaje', 'Alicante', 20, '2021-06-21', '17:00', '18:00', 'LIBRE', 'empresaSpa1', null),
    (103, 'Masaje', 'Alicante', 20, '2021-06-21', '18:00', '19:00', 'LIBRE', 'empresaSpa1', null),
    (104, 'Masaje', 'Alicante', 20, '2021-06-21', '19:00', '20:00', 'LIBRE', 'empresaSpa1', null),
    (105, 'Masaje', 'Alicante', 20, '2021-06-22', '09:00', '10:00', 'LIBRE', 'empresaSpa1', null),
	(106, 'Masaje', 'Alicante', 20, '2021-06-22', '10:00', '11:00', 'LIBRE', 'empresaSpa1', null),
    (107, 'Masaje', 'Alicante', 20, '2021-06-22', '11:00', '12:00', 'LIBRE', 'empresaSpa1', null),
    (108, 'Masaje', 'Alicante', 20, '2021-06-22', '12:00', '13:00', 'LIBRE', 'empresaSpa1', null),
    (109, 'Masaje', 'Alicante', 20, '2021-06-22', '13:00', '14:00', 'LIBRE', 'empresaSpa1', null),
    (110, 'Masaje', 'Alicante', 20, '2021-06-22', '16:00', '17:00', 'LIBRE', 'empresaSpa1', null),
    (111, 'Masaje', 'Alicante', 20, '2021-06-22', '17:00', '18:00', 'LIBRE', 'empresaSpa1', null),
    (112, 'Masaje', 'Alicante', 20, '2021-06-22', '18:00', '19:00', 'LIBRE', 'empresaSpa1', null),
    (113, 'Masaje', 'Alicante', 20, '2021-06-22', '19:00', '20:00', 'LIBRE', 'empresaSpa1', null),
    (114, 'Masaje', 'Alicante', 20, '2021-06-23', '09:00', '10:00', 'LIBRE', 'empresaSpa1', null),
	(115, 'Masaje', 'Alicante', 20, '2021-06-23', '10:00', '11:00', 'LIBRE', 'empresaSpa1', null),
    (116, 'Masaje', 'Alicante', 20, '2021-06-23', '11:00', '12:00', 'LIBRE', 'empresaSpa1', null),
    (117, 'Masaje', 'Alicante', 20, '2021-06-23', '12:00', '13:00', 'LIBRE', 'empresaSpa1', null),
    (118, 'Masaje', 'Alicante', 20, '2021-06-23', '13:00', '14:00', 'LIBRE', 'empresaSpa1', null),
    (119, 'Masaje', 'Alicante', 20, '2021-06-23', '16:00', '17:00', 'LIBRE', 'empresaSpa1', null),
    (120, 'Masaje', 'Alicante', 20, '2021-06-23', '17:00', '18:00', 'LIBRE', 'empresaSpa1', null),
    (121, 'Masaje', 'Alicante', 20, '2021-06-23', '18:00', '19:00', 'LIBRE', 'empresaSpa1', null),
    (122, 'Masaje', 'Alicante', 20, '2021-06-23', '19:00', '20:00', 'LIBRE', 'empresaSpa1', null),
    (123, 'Masaje', 'Alicante', 20, '2021-06-24', '09:00', '10:00', 'PLAN', 'empresaSpa1', null),
	(124, 'Masaje', 'Alicante', 20, '2021-06-24', '10:00', '11:00', 'LIBRE', 'empresaSpa1', null),
    (125, 'Masaje', 'Alicante', 20, '2021-06-24', '11:00', '12:00', 'RESERVADO', 'empresaSpa1', 'clientePaula'),
    (126, 'Masaje', 'Alicante', 20, '2021-06-24', '12:00', '13:00', 'LIBRE', 'empresaSpa1', null),
    (127, 'Masaje', 'Alicante', 20, '2021-06-24', '13:00', '14:00', 'LIBRE', 'empresaSpa1', null),
    (128, 'Masaje', 'Alicante', 20, '2021-06-24', '16:00', '17:00', 'LIBRE', 'empresaSpa1', null),
    (129, 'Masaje', 'Alicante', 20, '2021-06-24', '17:00', '18:00', 'LIBRE', 'empresaSpa1', null),
    (130, 'Masaje', 'Alicante', 20, '2021-06-24', '18:00', '19:00', 'LIBRE', 'empresaSpa1', null),
    (131, 'Masaje', 'Alicante', 20, '2021-06-24', '19:00', '20:00', 'LIBRE', 'empresaSpa1', null),
    (132, 'Masaje', 'Alicante', 20, '2021-06-25', '09:00', '10:00', 'LIBRE', 'empresaSpa1', null),
	(133, 'Masaje', 'Alicante', 20, '2021-06-25', '10:00', '11:00', 'LIBRE', 'empresaSpa1', null),
    (134, 'Masaje', 'Alicante', 20, '2021-06-25', '11:00', '12:00', 'LIBRE', 'empresaSpa1', null),
    (135, 'Masaje', 'Alicante', 20, '2021-06-25', '12:00', '13:00', 'LIBRE', 'empresaSpa1', null),
    (136, 'Masaje', 'Alicante', 20, '2021-06-25', '13:00', '14:00', 'LIBRE', 'empresaSpa1', null),
    (137, 'Masaje', 'Alicante', 20, '2021-06-25', '16:00', '17:00', 'LIBRE', 'empresaSpa1', null),
    (138, 'Masaje', 'Alicante', 20, '2021-06-25', '17:00', '18:00', 'LIBRE', 'empresaSpa1', null),
    (139, 'Masaje', 'Alicante', 20, '2021-06-25', '18:00', '19:00', 'LIBRE', 'empresaSpa1', null),
    (140, 'Masaje', 'Alicante', 20, '2021-06-25', '19:00', '20:00', 'LIBRE', 'empresaSpa1', null),
    (141, 'Masaje', 'Alicante', 20, '2021-06-26', '09:00', '10:00', 'LIBRE', 'empresaSpa1', null),
	(142, 'Masaje', 'Alicante', 20, '2021-06-26', '10:00', '11:00', 'LIBRE', 'empresaSpa1', null),
    (143, 'Masaje', 'Alicante', 20, '2021-06-26', '11:00', '12:00', 'LIBRE', 'empresaSpa1', null),
    (144, 'Masaje', 'Alicante', 20, '2021-06-26', '12:00', '13:00', 'LIBRE', 'empresaSpa1', null),
    (145, 'Masaje', 'Alicante', 20, '2021-06-26', '13:00', '14:00', 'RESERVADO', 'empresaSpa1', 'clientePaula');

INSERT INTO `reservas`.`servicio` (id, nombre, direccion, precio, fecha, horaInicio, horaFin, estado, empresa, cliente) VALUES 
	(146, 'Limpieza facial', 'Aspe', 25, '2021-06-21', '09:00', '10:00', 'RESERVADO', 'empresaSpa2', 'clientePaula'),
    (147, 'Limpieza facial', 'Aspe', 25, '2021-06-21', '10:00', '11:00', 'PLAN', 'empresaSpa2', null),
    (148, 'Limpieza facial', 'Aspe', 25, '2021-06-21', '11:00', '12:00', 'LIBRE', 'empresaSpa2', null),
    (149, 'Limpieza facial', 'Aspe', 25, '2021-06-21', '12:00', '13:00', 'RESERVADO', 'empresaSpa2', 'clienteSameh'),
    (150, 'Limpieza facial', 'Aspe', 25, '2021-06-22', '09:00', '10:00', 'LIBRE', 'empresaSpa2', null),
    (151, 'Limpieza facial', 'Aspe', 25, '2021-06-22', '10:00', '11:00', 'LIBRE', 'empresaSpa2', null),
    (152, 'Limpieza facial', 'Aspe', 25, '2021-06-22', '11:00', '12:00', 'LIBRE', 'empresaSpa2', null),
    (153, 'Limpieza facial', 'Aspe', 25, '2021-06-22', '12:00', '13:00', 'LIBRE', 'empresaSpa2', null),
    (154, 'Limpieza facial', 'Aspe', 25, '2021-06-23', '09:00', '10:00', 'LIBRE', 'empresaSpa2', null),
    (155, 'Limpieza facial', 'Aspe', 25, '2021-06-23', '10:00', '11:00', 'LIBRE', 'empresaSpa2', null),
    (156, 'Limpieza facial', 'Aspe', 25, '2021-06-23', '11:00', '12:00', 'LIBRE', 'empresaSpa2', null),
    (157, 'Limpieza facial', 'Aspe', 25, '2021-06-23', '12:00', '13:00', 'LIBRE', 'empresaSpa2', null),
    (158, 'Limpieza facial', 'Aspe', 25, '2021-06-24', '09:00', '10:00', 'LIBRE', 'empresaSpa2', null),
    (159, 'Limpieza facial', 'Aspe', 25, '2021-06-24', '10:00', '11:00', 'LIBRE', 'empresaSpa2', null),
    (160, 'Limpieza facial', 'Aspe', 25, '2021-06-24', '11:00', '12:00', 'PLAN', 'empresaSpa2', null),
    (161, 'Limpieza facial', 'Aspe', 25, '2021-06-24', '12:00', '13:00', 'LIBRE', 'empresaSpa2', null),
    (162, 'Limpieza facial', 'Aspe', 25, '2021-06-25', '09:00', '10:00', 'LIBRE', 'empresaSpa2', null),
    (163, 'Limpieza facial', 'Aspe', 25, '2021-06-25', '10:00', '11:00', 'LIBRE', 'empresaSpa2', null),
    (164, 'Limpieza facial', 'Aspe', 25, '2021-06-25', '11:00', '12:00', 'LIBRE', 'empresaSpa2', null),
    (165, 'Limpieza facial', 'Aspe', 25, '2021-06-25', '12:00', '13:00', 'LIBRE', 'empresaSpa2', null),
    (166, 'Limpieza facial', 'Aspe', 25, '2021-06-26', '09:00', '10:00', 'LIBRE', 'empresaSpa2', null),
    (167, 'Limpieza facial', 'Aspe', 25, '2021-06-26', '10:00', '11:00', 'LIBRE', 'empresaSpa2', null),
    (168, 'Limpieza facial', 'Aspe', 25, '2021-06-26', '11:00', '12:00', 'LIBRE', 'empresaSpa2', null),
    (169, 'Limpieza facial', 'Aspe', 25, '2021-06-26', '12:00', '13:00', 'LIBRE', 'empresaSpa2', null);

INSERT INTO `reservas`.`servicio` (id, nombre, direccion, precio, fecha, horaInicio, horaFin, estado, empresa, cliente) VALUES
	(170, 'Masaje', 'Torrevieja', 40, '2021-06-21', '16:00', '18:00', 'LIBRE', 'empresaSpa3', null),
    (171, 'Masaje', 'Torrevieja', 40, '2021-06-21', '18:00', '20:00', 'LIBRE', 'empresaSpa3', null),
    (172, 'Masaje', 'Torrevieja', 40, '2021-06-22', '16:00', '18:00', 'LIBRE', 'empresaSpa3', null),
    (173, 'Masaje', 'Torrevieja', 40, '2021-06-22', '18:00', '20:00', 'LIBRE', 'empresaSpa3', null),
    (174, 'Masaje', 'Torrevieja', 40, '2021-06-23', '16:00', '18:00', 'LIBRE', 'empresaSpa3', null),
    (175, 'Masaje', 'Torrevieja', 40, '2021-06-23', '18:00', '20:00', 'LIBRE', 'empresaSpa3', null),
    (176, 'Masaje', 'Torrevieja', 40, '2021-06-24', '16:00', '18:00', 'PLAN', 'empresaSpa3', null),
    (177, 'Masaje', 'Torrevieja', 40, '2021-06-24', '18:00', '20:00', 'LIBRE', 'empresaSpa3', null),
    (178, 'Masaje', 'Torrevieja', 40, '2021-06-25', '16:00', '18:00', 'LIBRE', 'empresaSpa3', null),
    (179, 'Masaje', 'Torrevieja', 40, '2021-06-25', '18:00', '20:00', 'LIBRE', 'empresaSpa3', null),
    (180, 'Masaje', 'Torrevieja', 40, '2021-06-26', '16:00', '18:00', 'LIBRE', 'empresaSpa3', null),
    (181, 'Masaje', 'Torrevieja', 40, '2021-06-26', '18:00', '20:00', 'LIBRE', 'empresaSpa3', null);

INSERT INTO `reservas`.`servicio` (id, nombre, direccion, precio, fecha, horaInicio, horaFin, estado, empresa, cliente) VALUES 
	(182, 'Comida', 'Aspe', 0, '2021-06-21', '13:00', '14:00', 'PLAN', 'empresaRestaurante', null),
    (183, 'Comida', 'Aspe', 0, '2021-06-21', '14:00', '15:00', 'LIBRE', 'empresaRestaurante', null),
    (184, 'Comida', 'Aspe', 0, '2021-06-21', '15:00', '16:00', 'LIBRE', 'empresaRestaurante', null),
    (185, 'Comida', 'Aspe', 0, '2021-06-22', '13:00', '14:00', 'LIBRE', 'empresaRestaurante', null),
    (186, 'Comida', 'Aspe', 0, '2021-06-22', '14:00', '15:00', 'LIBRE', 'empresaRestaurante', null),
    (187, 'Comida', 'Aspe', 0, '2021-06-22', '15:00', '16:00', 'LIBRE', 'empresaRestaurante', null),
    (188, 'Comida', 'Aspe', 0, '2021-06-23', '13:00', '14:00', 'LIBRE', 'empresaRestaurante', null),
    (189, 'Comida', 'Aspe', 0, '2021-06-23', '14:00', '15:00', 'RESERVADO', 'empresaRestaurante', 'clientePaula'),
    (190, 'Comida', 'Aspe', 0, '2021-06-23', '15:00', '16:00', 'LIBRE', 'empresaRestaurante', null),
    (191, 'Comida', 'Aspe', 0, '2021-06-24', '13:00', '14:00', 'LIBRE', 'empresaRestaurante', null),
    (192, 'Comida', 'Aspe', 0, '2021-06-24', '14:00', '15:00', 'LIBRE', 'empresaRestaurante', null),
    (193, 'Comida', 'Aspe', 0, '2021-06-24', '15:00', '16:00', 'LIBRE', 'empresaRestaurante', null),
    (194, 'Comida', 'Aspe', 0, '2021-06-25', '13:00', '14:00', 'PLAN', 'empresaRestaurante', null),
    (195, 'Comida', 'Aspe', 0, '2021-06-25', '14:00', '15:00', 'LIBRE', 'empresaRestaurante', null),
    (196, 'Comida', 'Aspe', 0, '2021-06-25', '15:00', '16:00', 'LIBRE', 'empresaRestaurante', null),
    (197, 'Comida', 'Aspe', 0, '2021-06-26', '13:00', '14:00', 'LIBRE', 'empresaRestaurante', null),
    (198, 'Comida', 'Aspe', 0, '2021-06-26', '14:00', '15:00', 'LIBRE', 'empresaRestaurante', null),
    (199, 'Comida', 'Aspe', 0, '2021-06-26', '15:00', '16:00', 'LIBRE', 'empresaRestaurante', null),
    (200, 'Comida', 'Aspe', 0, '2021-06-27', '13:00', '14:00', 'LIBRE', 'empresaRestaurante', null),
    (201, 'Comida', 'Aspe', 0, '2021-06-27', '14:00', '15:00', 'LIBRE', 'empresaRestaurante', null),
    (202, 'Comida', 'Aspe', 0, '2021-06-27', '15:00', '16:00', 'LIBRE', 'empresaRestaurante', null);
    
INSERT INTO `reservas`.`servicio` (id, nombre, direccion, precio, fecha, horaInicio, horaFin, estado, empresa, cliente) VALUES 
    (203, 'Menú paellero', 'Monforte', 0, '2021-06-25', '13:00', '14:00', 'LIBRE', 'empresaRestaurante1', null),
    (204, 'Menú paellero', 'Monforte', 0, '2021-06-25', '14:00', '15:00', 'PLAN', 'empresaRestaurante1', null),
    (205, 'Menú paellero', 'Monforte', 0, '2021-06-25', '15:00', '16:00', 'LIBRE', 'empresaRestaurante1', null),
    (206, 'Menú paellero', 'Monforte', 0, '2021-06-26', '13:00', '14:00', 'LIBRE', 'empresaRestaurante1', null),
    (207, 'Menú paellero', 'Monforte', 0, '2021-06-26', '14:00', '15:00', 'LIBRE', 'empresaRestaurante1', null),
    (208, 'Menú paellero', 'Monforte', 0, '2021-06-26', '15:00', '16:00', 'LIBRE', 'empresaRestaurante1', null),
    (209, 'Menú paellero', 'Monforte', 0, '2021-06-27', '13:00', '14:00', 'LIBRE', 'empresaRestaurante1', null),
    (210, 'Menú paellero', 'Monforte', 0, '2021-06-27', '14:00', '15:00', 'LIBRE', 'empresaRestaurante1', null),
    (211, 'Menú paellero', 'Monforte', 0, '2021-06-27', '15:00', '16:00', 'LIBRE', 'empresaRestaurante1', null);

INSERT INTO `reservas`.`servicio` (id, nombre, direccion, precio, fecha, horaInicio, horaFin, estado, empresa, cliente) VALUES 
    (212, 'Menú del día', 'Elda', 0, '2021-06-25', '13:00', '14:00', 'LIBRE', 'empresaRestaurante2', null),
    (213, 'Menú del día', 'Elda', 0, '2021-06-25', '14:00', '15:00', 'LIBRE', 'empresaRestaurante2', null),
    (214, 'Menú del día', 'Elda', 0, '2021-06-25', '15:00', '16:00', 'PLAN', 'empresaRestaurante2', null),
    (215, 'Menú del día', 'Elda', 0, '2021-06-26', '13:00', '14:00', 'LIBRE', 'empresaRestaurante2', null),
    (216, 'Menú del día', 'Elda', 0, '2021-06-26', '14:00', '15:00', 'LIBRE', 'empresaRestaurante2', null),
    (217, 'Menú del día', 'Elda', 0, '2021-06-26', '15:00', '16:00', 'LIBRE', 'empresaRestaurante2', null),
    (218, 'Menú del día', 'Elda', 0, '2021-06-27', '13:00', '14:00', 'LIBRE', 'empresaRestaurante2', null),
    (219, 'Menú del día', 'Elda', 0, '2021-06-27', '14:00', '15:00', 'LIBRE', 'empresaRestaurante2', null),
    (220, 'Menú del día', 'Elda', 0, '2021-06-27', '15:00', '16:00', 'LIBRE', 'empresaRestaurante2', null);

INSERT INTO `reservas`.`servicio` (id, nombre, direccion, precio, fecha, horaInicio, horaFin, estado, empresa, cliente) VALUES 
	(221, 'Comida', 'Petrer', 0, '2021-06-21', '13:00', '14:00', 'LIBRE', 'empresaRestaurante3', null),
    (222, 'Comida', 'Petrer', 0, '2021-06-21', '14:00', '15:00', 'LIBRE', 'empresaRestaurante3', null),
    (223, 'Comida', 'Petrer', 0, '2021-06-21', '15:00', '16:00', 'LIBRE', 'empresaRestaurante3', null),
    (224, 'Comida', 'Petrer', 0, '2021-06-22', '13:00', '14:00', 'LIBRE', 'empresaRestaurante3', null),
    (225, 'Comida', 'Petrer', 0, '2021-06-22', '14:00', '15:00', 'LIBRE', 'empresaRestaurante3', null),
    (226, 'Comida', 'Petrer', 0, '2021-06-22', '15:00', '16:00', 'LIBRE', 'empresaRestaurante3', null),
    (227, 'Comida', 'Petrer', 0, '2021-06-23', '13:00', '14:00', 'LIBRE', 'empresaRestaurante3', null),
    (228, 'Comida', 'Petrer', 0, '2021-06-23', '14:00', '15:00', 'LIBRE', 'empresaRestaurante3', null),
    (229, 'Comida', 'Petrer', 0, '2021-06-23', '15:00', '16:00', 'LIBRE', 'empresaRestaurante3', null),
    (230, 'Comida', 'Petrer', 0, '2021-06-24', '13:00', '14:00', 'LIBRE', 'empresaRestaurante3', null),
    (231, 'Comida', 'Petrer', 0, '2021-06-24', '14:00', '15:00', 'LIBRE', 'empresaRestaurante3', null),
    (232, 'Comida', 'Petrer', 0, '2021-06-24', '15:00', '16:00', 'LIBRE', 'empresaRestaurante3', null),
    (233, 'Comida', 'Petrer', 0, '2021-06-25', '13:00', '14:00', 'LIBRE', 'empresaRestaurante3', null),
    (234, 'Comida', 'Petrer', 0, '2021-06-25', '14:00', '15:00', 'LIBRE', 'empresaRestaurante3', null),
    (235, 'Comida', 'Petrer', 0, '2021-06-25', '15:00', '16:00', 'LIBRE', 'empresaRestaurante3', null),
    (236, 'Comida', 'Petrer', 0, '2021-06-26', '13:00', '14:00', 'LIBRE', 'empresaRestaurante3', null),
    (237, 'Comida', 'Petrer', 0, '2021-06-26', '14:00', '15:00', 'LIBRE', 'empresaRestaurante3', null),
    (238, 'Comida', 'Petrer', 0, '2021-06-26', '15:00', '16:00', 'LIBRE', 'empresaRestaurante3', null),
    (239, 'Comida', 'Petrer', 0, '2021-06-27', '13:00', '14:00', 'LIBRE', 'empresaRestaurante3', null),
    (240, 'Comida', 'Petrer', 0, '2021-06-27', '14:00', '15:00', 'LIBRE', 'empresaRestaurante3', null),
    (241, 'Comida', 'Petrer', 0, '2021-06-27', '15:00', '16:00', 'LIBRE', 'empresaRestaurante3', null);

INSERT INTO `reservas`.`servicio` (id, nombre, direccion, precio, fecha, horaInicio, horaFin, estado, empresa, cliente) VALUES 
	(242, 'Gimnasio', 'Alicante', 3, '2021-06-21', '07:00', '08:00', 'RESERVADO', 'empresaGimnasio1', 'clienteJosue'),
	(243, 'Gimnasio', 'Alicante', 3, '2021-06-21', '08:00', '09:00', 'PLAN', 'empresaGimnasio1', null),
    (244, 'Gimnasio', 'Alicante', 3, '2021-06-21', '09:00', '10:00', 'LIBRE', 'empresaGimnasio1', null),
	(245, 'Gimnasio', 'Alicante', 3, '2021-06-21', '10:00', '11:00', 'LIBRE', 'empresaGimnasio1', null),
	(246, 'Gimnasio', 'Alicante', 3, '2021-06-21', '11:00', '12:00', 'LIBRE', 'empresaGimnasio1', null),
    (247, 'Gimnasio', 'Alicante', 3, '2021-06-21', '12:00', '13:00', 'LIBRE', 'empresaGimnasio1', null),
    (248, 'Gimnasio', 'Alicante', 3, '2021-06-21', '13:00', '14:00', 'LIBRE', 'empresaGimnasio1', null),
    (249, 'Gimnasio', 'Alicante', 3, '2021-06-21', '14:00', '15:00', 'LIBRE', 'empresaGimnasio1', null),
    (250, 'Gimnasio', 'Alicante', 3, '2021-06-21', '15:00', '16:00', 'LIBRE', 'empresaGimnasio1', null),
    (251, 'Gimnasio', 'Alicante', 3, '2021-06-21', '16:00', '17:00', 'LIBRE', 'empresaGimnasio1', null),
    (252, 'Gimnasio', 'Alicante', 3, '2021-06-21', '17:00', '18:00', 'LIBRE', 'empresaGimnasio1', null),
    (253, 'Gimnasio', 'Alicante', 3, '2021-06-21', '18:00', '19:00', 'LIBRE', 'empresaGimnasio1', null),
    (254, 'Gimnasio', 'Alicante', 3, '2021-06-21', '19:00', '20:00', 'LIBRE', 'empresaGimnasio1', null),
    (255, 'Gimnasio', 'Alicante', 3, '2021-06-21', '20:00', '21:00', 'LIBRE', 'empresaGimnasio1', null),
    (256, 'Gimnasio', 'Alicante', 3, '2021-06-22', '07:00', '08:00', 'LIBRE', 'empresaGimnasio1', null),
	(257, 'Gimnasio', 'Alicante', 3, '2021-06-22', '08:00', '09:00', 'LIBRE', 'empresaGimnasio1', null),
    (258, 'Gimnasio', 'Alicante', 3, '2021-06-22', '09:00', '10:00', 'LIBRE', 'empresaGimnasio1', null),
	(259, 'Gimnasio', 'Alicante', 3, '2021-06-22', '10:00', '11:00', 'LIBRE', 'empresaGimnasio1', null),
	(260, 'Gimnasio', 'Alicante', 3, '2021-06-22', '11:00', '12:00', 'LIBRE', 'empresaGimnasio1', null),
    (261, 'Gimnasio', 'Alicante', 3, '2021-06-22', '12:00', '13:00', 'LIBRE', 'empresaGimnasio1', null),
    (262, 'Gimnasio', 'Alicante', 3, '2021-06-22', '13:00', '14:00', 'LIBRE', 'empresaGimnasio1', null),
    (263, 'Gimnasio', 'Alicante', 3, '2021-06-22', '14:00', '15:00', 'LIBRE', 'empresaGimnasio1', null),
    (264, 'Gimnasio', 'Alicante', 3, '2021-06-22', '15:00', '16:00', 'LIBRE', 'empresaGimnasio1', null),
    (265, 'Gimnasio', 'Alicante', 3, '2021-06-22', '16:00', '17:00', 'LIBRE', 'empresaGimnasio1', null),
    (266, 'Gimnasio', 'Alicante', 3, '2021-06-22', '17:00', '18:00', 'LIBRE', 'empresaGimnasio1', null),
    (267, 'Gimnasio', 'Alicante', 3, '2021-06-22', '18:00', '19:00', 'LIBRE', 'empresaGimnasio1', null),
    (268, 'Gimnasio', 'Alicante', 3, '2021-06-22', '19:00', '20:00', 'LIBRE', 'empresaGimnasio1', null),
    (269, 'Gimnasio', 'Alicante', 3, '2021-06-22', '20:00', '21:00', 'LIBRE', 'empresaGimnasio1', null),
    (270, 'Gimnasio', 'Alicante', 3, '2021-06-23', '07:00', '08:00', 'LIBRE', 'empresaGimnasio1', null),
	(271, 'Gimnasio', 'Alicante', 3, '2021-06-23', '08:00', '09:00', 'LIBRE', 'empresaGimnasio1', null),
    (272, 'Gimnasio', 'Alicante', 3, '2021-06-23', '09:00', '10:00', 'LIBRE', 'empresaGimnasio1', null),
	(273, 'Gimnasio', 'Alicante', 3, '2021-06-23', '10:00', '11:00', 'LIBRE', 'empresaGimnasio1', null),
	(274, 'Gimnasio', 'Alicante', 3, '2021-06-23', '11:00', '12:00', 'LIBRE', 'empresaGimnasio1', null),
    (275, 'Gimnasio', 'Alicante', 3, '2021-06-23', '12:00', '13:00', 'LIBRE', 'empresaGimnasio1', null),
    (276, 'Gimnasio', 'Alicante', 3, '2021-06-23', '13:00', '14:00', 'LIBRE', 'empresaGimnasio1', null),
    (277, 'Gimnasio', 'Alicante', 3, '2021-06-23', '14:00', '15:00', 'LIBRE', 'empresaGimnasio1', null),
    (278, 'Gimnasio', 'Alicante', 3, '2021-06-23', '15:00', '16:00', 'LIBRE', 'empresaGimnasio1', null),
    (279, 'Gimnasio', 'Alicante', 3, '2021-06-23', '16:00', '17:00', 'LIBRE', 'empresaGimnasio1', null),
    (280, 'Gimnasio', 'Alicante', 3, '2021-06-23', '17:00', '18:00', 'LIBRE', 'empresaGimnasio1', null),
    (281, 'Gimnasio', 'Alicante', 3, '2021-06-23', '18:00', '19:00', 'LIBRE', 'empresaGimnasio1', null),
    (282, 'Gimnasio', 'Alicante', 3, '2021-06-23', '19:00', '20:00', 'LIBRE', 'empresaGimnasio1', null),
    (283, 'Gimnasio', 'Alicante', 3, '2021-06-23', '20:00', '21:00', 'LIBRE', 'empresaGimnasio1', null),
    (284, 'Gimnasio', 'Alicante', 3, '2021-06-24', '07:00', '08:00', 'LIBRE', 'empresaGimnasio1', null),
	(285, 'Gimnasio', 'Alicante', 3, '2021-06-24', '08:00', '09:00', 'LIBRE', 'empresaGimnasio1', null),
    (286, 'Gimnasio', 'Alicante', 3, '2021-06-24', '09:00', '10:00', 'LIBRE', 'empresaGimnasio1', null),
	(287, 'Gimnasio', 'Alicante', 3, '2021-06-24', '10:00', '11:00', 'LIBRE', 'empresaGimnasio1', null),
	(288, 'Gimnasio', 'Alicante', 3, '2021-06-24', '11:00', '12:00', 'LIBRE', 'empresaGimnasio1', null),
    (289, 'Gimnasio', 'Alicante', 3, '2021-06-24', '12:00', '13:00', 'LIBRE', 'empresaGimnasio1', null),
    (290, 'Gimnasio', 'Alicante', 3, '2021-06-24', '13:00', '14:00', 'LIBRE', 'empresaGimnasio1', null),
    (291, 'Gimnasio', 'Alicante', 3, '2021-06-24', '14:00', '15:00', 'LIBRE', 'empresaGimnasio1', null),
    (292, 'Gimnasio', 'Alicante', 3, '2021-06-24', '15:00', '16:00', 'LIBRE', 'empresaGimnasio1', null),
    (293, 'Gimnasio', 'Alicante', 3, '2021-06-24', '16:00', '17:00', 'LIBRE', 'empresaGimnasio1', null),
    (294, 'Gimnasio', 'Alicante', 3, '2021-06-24', '17:00', '18:00', 'LIBRE', 'empresaGimnasio1', null),
    (295, 'Gimnasio', 'Alicante', 3, '2021-06-24', '18:00', '19:00', 'LIBRE', 'empresaGimnasio1', null),
    (296, 'Gimnasio', 'Alicante', 3, '2021-06-24', '19:00', '20:00', 'LIBRE', 'empresaGimnasio1', null),
    (297, 'Gimnasio', 'Alicante', 3, '2021-06-24', '20:00', '21:00', 'LIBRE', 'empresaGimnasio1', null),
    (298, 'Gimnasio', 'Alicante', 3, '2021-06-25', '07:00', '08:00', 'LIBRE', 'empresaGimnasio1', null),
	(299, 'Gimnasio', 'Alicante', 3, '2021-06-25', '08:00', '09:00', 'LIBRE', 'empresaGimnasio1', null),
    (300, 'Gimnasio', 'Alicante', 3, '2021-06-25', '09:00', '10:00', 'LIBRE', 'empresaGimnasio1', null),
	(301, 'Gimnasio', 'Alicante', 3, '2021-06-25', '10:00', '11:00', 'LIBRE', 'empresaGimnasio1', null),
	(302, 'Gimnasio', 'Alicante', 3, '2021-06-25', '11:00', '12:00', 'LIBRE', 'empresaGimnasio1', null),
    (303, 'Gimnasio', 'Alicante', 3, '2021-06-25', '12:00', '13:00', 'LIBRE', 'empresaGimnasio1', null),
    (304, 'Gimnasio', 'Alicante', 3, '2021-06-25', '13:00', '14:00', 'LIBRE', 'empresaGimnasio1', null),
    (305, 'Gimnasio', 'Alicante', 3, '2021-06-25', '14:00', '15:00', 'LIBRE', 'empresaGimnasio1', null),
    (306, 'Gimnasio', 'Alicante', 3, '2021-06-25', '15:00', '16:00', 'LIBRE', 'empresaGimnasio1', null),
    (307, 'Gimnasio', 'Alicante', 3, '2021-06-25', '16:00', '17:00', 'LIBRE', 'empresaGimnasio1', null),
    (308, 'Gimnasio', 'Alicante', 3, '2021-06-25', '17:00', '18:00', 'LIBRE', 'empresaGimnasio1', null),
    (309, 'Gimnasio', 'Alicante', 3, '2021-06-25', '18:00', '19:00', 'LIBRE', 'empresaGimnasio1', null),
    (310, 'Gimnasio', 'Alicante', 3, '2021-06-25', '19:00', '20:00', 'LIBRE', 'empresaGimnasio1', null),
    (311, 'Gimnasio', 'Alicante', 3, '2021-06-25', '20:00', '21:00', 'LIBRE', 'empresaGimnasio1', null),
    (312, 'Gimnasio', 'Alicante', 3, '2021-06-26', '07:00', '08:00', 'LIBRE', 'empresaGimnasio1', null),
	(313, 'Gimnasio', 'Alicante', 3, '2021-06-26', '08:00', '09:00', 'LIBRE', 'empresaGimnasio1', null),
    (314, 'Gimnasio', 'Alicante', 3, '2021-06-26', '09:00', '10:00', 'PLAN', 'empresaGimnasio1', null),
	(315, 'Gimnasio', 'Alicante', 3, '2021-06-26', '10:00', '11:00', 'LIBRE', 'empresaGimnasio1', null),
	(316, 'Gimnasio', 'Alicante', 3, '2021-06-26', '11:00', '12:00', 'LIBRE', 'empresaGimnasio1', null),
    (317, 'Gimnasio', 'Alicante', 3, '2021-06-26', '12:00', '13:00', 'LIBRE', 'empresaGimnasio1', null),
    (318, 'Gimnasio', 'Alicante', 3, '2021-06-26', '13:00', '14:00', 'LIBRE', 'empresaGimnasio1', null),
    (319, 'Gimnasio', 'Alicante', 3, '2021-06-26', '14:00', '15:00', 'LIBRE', 'empresaGimnasio1', null),
    (320, 'Gimnasio', 'Alicante', 3, '2021-06-26', '15:00', '16:00', 'LIBRE', 'empresaGimnasio1', null),
    (321, 'Gimnasio', 'Alicante', 3, '2021-06-26', '16:00', '17:00', 'LIBRE', 'empresaGimnasio1', null),
    (322, 'Gimnasio', 'Alicante', 3, '2021-06-26', '17:00', '18:00', 'LIBRE', 'empresaGimnasio1', null),
    (323, 'Gimnasio', 'Alicante', 3, '2021-06-26', '18:00', '19:00', 'RESERVADO', 'empresaGimnasio1', 'clientePaula'),
    (324, 'Gimnasio', 'Alicante', 3, '2021-06-26', '19:00', '20:00', 'LIBRE', 'empresaGimnasio1', null),
    (325, 'Gimnasio', 'Alicante', 3, '2021-06-26', '20:00', '21:00', 'LIBRE', 'empresaGimnasio1', null);

INSERT INTO `reservas`.`servicio` (id, nombre, direccion, precio, fecha, horaInicio, horaFin, estado, empresa, cliente) VALUES 
	(326, 'Gimnasio', 'Alicante', 3, '2021-06-21', '07:00', '08:00', 'LIBRE', 'empresaGimnasio2', null),
	(327, 'Gimnasio', 'Alicante', 3, '2021-06-21', '08:00', '09:00', 'LIBRE', 'empresaGimnasio2', null),
    (328, 'Gimnasio', 'Alicante', 3, '2021-06-21', '09:00', '10:00', 'LIBRE', 'empresaGimnasio2', null),
	(329, 'Gimnasio', 'Alicante', 3, '2021-06-21', '10:00', '11:00', 'LIBRE', 'empresaGimnasio2', null),
	(330, 'Gimnasio', 'Alicante', 3, '2021-06-21', '11:00', '12:00', 'LIBRE', 'empresaGimnasio2', null),
    (331, 'Gimnasio', 'Alicante', 3, '2021-06-21', '12:00', '13:00', 'LIBRE', 'empresaGimnasio2', null),
    (332, 'Gimnasio', 'Alicante', 3, '2021-06-21', '13:00', '14:00', 'LIBRE', 'empresaGimnasio2', null),
    (333, 'Gimnasio', 'Alicante', 3, '2021-06-21', '14:00', '15:00', 'LIBRE', 'empresaGimnasio2', null),
    (334, 'Gimnasio', 'Alicante', 3, '2021-06-21', '15:00', '16:00', 'LIBRE', 'empresaGimnasio2', null),
    (335, 'Gimnasio', 'Alicante', 3, '2021-06-21', '16:00', '17:00', 'LIBRE', 'empresaGimnasio2', null),
    (336, 'Gimnasio', 'Alicante', 3, '2021-06-21', '17:00', '18:00', 'LIBRE', 'empresaGimnasio2', null),
    (337, 'Gimnasio', 'Alicante', 3, '2021-06-21', '18:00', '19:00', 'LIBRE', 'empresaGimnasio2', null),
    (338, 'Gimnasio', 'Alicante', 3, '2021-06-21', '19:00', '20:00', 'LIBRE', 'empresaGimnasio2', null),
    (339, 'Gimnasio', 'Alicante', 3, '2021-06-21', '20:00', '21:00', 'LIBRE', 'empresaGimnasio2', null),
    (340, 'Gimnasio', 'Alicante', 3, '2021-06-22', '07:00', '08:00', 'LIBRE', 'empresaGimnasio2', null),
	(341, 'Gimnasio', 'Alicante', 3, '2021-06-22', '08:00', '09:00', 'LIBRE', 'empresaGimnasio2', null),
    (342, 'Gimnasio', 'Alicante', 3, '2021-06-22', '09:00', '10:00', 'LIBRE', 'empresaGimnasio2', null),
	(343, 'Gimnasio', 'Alicante', 3, '2021-06-22', '10:00', '11:00', 'LIBRE', 'empresaGimnasio2', null),
	(344, 'Gimnasio', 'Alicante', 3, '2021-06-22', '11:00', '12:00', 'LIBRE', 'empresaGimnasio2', null),
    (345, 'Gimnasio', 'Alicante', 3, '2021-06-22', '12:00', '13:00', 'LIBRE', 'empresaGimnasio2', null),
    (346, 'Gimnasio', 'Alicante', 3, '2021-06-22', '13:00', '14:00', 'LIBRE', 'empresaGimnasio2', null),
    (347, 'Gimnasio', 'Alicante', 3, '2021-06-22', '14:00', '15:00', 'LIBRE', 'empresaGimnasio2', null),
    (348, 'Gimnasio', 'Alicante', 3, '2021-06-22', '15:00', '16:00', 'LIBRE', 'empresaGimnasio2', null),
    (349, 'Gimnasio', 'Alicante', 3, '2021-06-22', '16:00', '17:00', 'LIBRE', 'empresaGimnasio2', null),
    (350, 'Gimnasio', 'Alicante', 3, '2021-06-22', '17:00', '18:00', 'LIBRE', 'empresaGimnasio2', null),
    (351, 'Gimnasio', 'Alicante', 3, '2021-06-22', '18:00', '19:00', 'LIBRE', 'empresaGimnasio2', null),
    (352, 'Gimnasio', 'Alicante', 3, '2021-06-22', '19:00', '20:00', 'LIBRE', 'empresaGimnasio2', null),
    (353, 'Gimnasio', 'Alicante', 3, '2021-06-22', '20:00', '21:00', 'LIBRE', 'empresaGimnasio2', null),
    (354, 'Gimnasio', 'Alicante', 3, '2021-06-23', '07:00', '08:00', 'LIBRE', 'empresaGimnasio2', null),
	(355, 'Gimnasio', 'Alicante', 3, '2021-06-23', '08:00', '09:00', 'LIBRE', 'empresaGimnasio2', null),
    (356, 'Gimnasio', 'Alicante', 3, '2021-06-23', '09:00', '10:00', 'LIBRE', 'empresaGimnasio2', null),
	(357, 'Gimnasio', 'Alicante', 3, '2021-06-23', '10:00', '11:00', 'LIBRE', 'empresaGimnasio2', null),
	(358, 'Gimnasio', 'Alicante', 3, '2021-06-23', '11:00', '12:00', 'LIBRE', 'empresaGimnasio2', null),
    (359, 'Gimnasio', 'Alicante', 3, '2021-06-23', '12:00', '13:00', 'RESERVADO', 'empresaGimnasio2', 'cliente10'),
    (360, 'Gimnasio', 'Alicante', 3, '2021-06-23', '13:00', '14:00', 'LIBRE', 'empresaGimnasio2', null),
    (361, 'Gimnasio', 'Alicante', 3, '2021-06-23', '14:00', '15:00', 'LIBRE', 'empresaGimnasio2', null),
    (362, 'Gimnasio', 'Alicante', 3, '2021-06-23', '15:00', '16:00', 'LIBRE', 'empresaGimnasio2', null),
    (363, 'Gimnasio', 'Alicante', 3, '2021-06-23', '16:00', '17:00', 'LIBRE', 'empresaGimnasio2', null),
    (364, 'Gimnasio', 'Alicante', 3, '2021-06-23', '17:00', '18:00', 'LIBRE', 'empresaGimnasio2', null),
    (365, 'Gimnasio', 'Alicante', 3, '2021-06-23', '18:00', '19:00', 'LIBRE', 'empresaGimnasio2', null),
    (366, 'Gimnasio', 'Alicante', 3, '2021-06-23', '19:00', '20:00', 'LIBRE', 'empresaGimnasio2', null),
    (367, 'Gimnasio', 'Alicante', 3, '2021-06-23', '20:00', '21:00', 'LIBRE', 'empresaGimnasio2', null),
    (368, 'Gimnasio', 'Alicante', 3, '2021-06-24', '07:00', '08:00', 'LIBRE', 'empresaGimnasio2', null),
	(369, 'Gimnasio', 'Alicante', 3, '2021-06-24', '08:00', '09:00', 'LIBRE', 'empresaGimnasio2', null),
    (370, 'Gimnasio', 'Alicante', 3, '2021-06-24', '09:00', '10:00', 'LIBRE', 'empresaGimnasio2', null),
	(371, 'Gimnasio', 'Alicante', 3, '2021-06-24', '10:00', '11:00', 'LIBRE', 'empresaGimnasio2', null),
	(372, 'Gimnasio', 'Alicante', 3, '2021-06-24', '11:00', '12:00', 'LIBRE', 'empresaGimnasio2', null),
    (373, 'Gimnasio', 'Alicante', 3, '2021-06-24', '12:00', '13:00', 'LIBRE', 'empresaGimnasio2', null),
    (374, 'Gimnasio', 'Alicante', 3, '2021-06-24', '13:00', '14:00', 'LIBRE', 'empresaGimnasio2', null),
    (375, 'Gimnasio', 'Alicante', 3, '2021-06-24', '14:00', '15:00', 'LIBRE', 'empresaGimnasio2', null),
    (376, 'Gimnasio', 'Alicante', 3, '2021-06-24', '15:00', '16:00', 'LIBRE', 'empresaGimnasio2', null),
    (377, 'Gimnasio', 'Alicante', 3, '2021-06-24', '16:00', '17:00', 'LIBRE', 'empresaGimnasio2', null),
    (378, 'Gimnasio', 'Alicante', 3, '2021-06-24', '17:00', '18:00', 'LIBRE', 'empresaGimnasio2', null),
    (379, 'Gimnasio', 'Alicante', 3, '2021-06-24', '18:00', '19:00', 'RESERVADO', 'empresaGimnasio2', 'cliente10'),
    (380, 'Gimnasio', 'Alicante', 3, '2021-06-24', '19:00', '20:00', 'LIBRE', 'empresaGimnasio2', null),
    (381, 'Gimnasio', 'Alicante', 3, '2021-06-24', '20:00', '21:00', 'LIBRE', 'empresaGimnasio2', null),
    (382, 'Gimnasio', 'Alicante', 3, '2021-06-25', '07:00', '08:00', 'LIBRE', 'empresaGimnasio2', null),
	(383, 'Gimnasio', 'Alicante', 3, '2021-06-25', '08:00', '09:00', 'LIBRE', 'empresaGimnasio2', null),
    (384, 'Gimnasio', 'Alicante', 3, '2021-06-25', '09:00', '10:00', 'LIBRE', 'empresaGimnasio2', null),
	(385, 'Gimnasio', 'Alicante', 3, '2021-06-25', '10:00', '11:00', 'LIBRE', 'empresaGimnasio2', null),
	(386, 'Gimnasio', 'Alicante', 3, '2021-06-25', '11:00', '12:00', 'LIBRE', 'empresaGimnasio2', null),
    (387, 'Gimnasio', 'Alicante', 3, '2021-06-25', '12:00', '13:00', 'LIBRE', 'empresaGimnasio2', null),
    (388, 'Gimnasio', 'Alicante', 3, '2021-06-25', '13:00', '14:00', 'LIBRE', 'empresaGimnasio2', null),
    (389, 'Gimnasio', 'Alicante', 3, '2021-06-25', '14:00', '15:00', 'LIBRE', 'empresaGimnasio2', null),
    (390, 'Gimnasio', 'Alicante', 3, '2021-06-25', '15:00', '16:00', 'LIBRE', 'empresaGimnasio2', null),
    (391, 'Gimnasio', 'Alicante', 3, '2021-06-25', '16:00', '17:00', 'LIBRE', 'empresaGimnasio2', null),
    (392, 'Gimnasio', 'Alicante', 3, '2021-06-25', '17:00', '18:00', 'LIBRE', 'empresaGimnasio2', null),
    (393, 'Gimnasio', 'Alicante', 3, '2021-06-25', '18:00', '19:00', 'LIBRE', 'empresaGimnasio2', null),
    (394, 'Gimnasio', 'Alicante', 3, '2021-06-25', '19:00', '20:00', 'LIBRE', 'empresaGimnasio2', null),
    (395, 'Gimnasio', 'Alicante', 3, '2021-06-25', '20:00', '21:00', 'LIBRE', 'empresaGimnasio2', null),
    (396, 'Gimnasio', 'Alicante', 3, '2021-06-26', '07:00', '08:00', 'LIBRE', 'empresaGimnasio2', null),
	(397, 'Gimnasio', 'Alicante', 3, '2021-06-26', '08:00', '09:00', 'LIBRE', 'empresaGimnasio2', null),
    (398, 'Gimnasio', 'Alicante', 3, '2021-06-26', '09:00', '10:00', 'LIBRE', 'empresaGimnasio2', null),
	(399, 'Gimnasio', 'Alicante', 3, '2021-06-26', '10:00', '11:00', 'RESERVADO', 'empresaGimnasio2', 'cliente10'),
	(400, 'Gimnasio', 'Alicante', 3, '2021-06-26', '11:00', '12:00', 'PLAN', 'empresaGimnasio2', null),
    (401, 'Gimnasio', 'Alicante', 3, '2021-06-26', '12:00', '13:00', 'LIBRE', 'empresaGimnasio2', null),
    (402, 'Gimnasio', 'Alicante', 3, '2021-06-26', '13:00', '14:00', 'LIBRE', 'empresaGimnasio2', null),
    (403, 'Gimnasio', 'Alicante', 3, '2021-06-26', '14:00', '15:00', 'LIBRE', 'empresaGimnasio2', null),
    (404, 'Gimnasio', 'Alicante', 3, '2021-06-26', '15:00', '16:00', 'LIBRE', 'empresaGimnasio2', null),
    (405, 'Gimnasio', 'Alicante', 3, '2021-06-26', '16:00', '17:00', 'LIBRE', 'empresaGimnasio2', null),
    (406, 'Gimnasio', 'Alicante', 3, '2021-06-26', '17:00', '18:00', 'LIBRE', 'empresaGimnasio2', null),
    (407, 'Gimnasio', 'Alicante', 3, '2021-06-26', '18:00', '19:00', 'RESERVADO', 'empresaGimnasio2', 'clienteJose'),
    (408, 'Gimnasio', 'Alicante', 3, '2021-06-26', '19:00', '20:00', 'LIBRE', 'empresaGimnasio2', null),
    (409, 'Gimnasio', 'Alicante', 3, '2021-06-26', '20:00', '21:00', 'LIBRE', 'empresaGimnasio2', null);

INSERT INTO `reservas`.`servicio` (id, nombre, direccion, precio, fecha, horaInicio, horaFin, estado, empresa, cliente) VALUES 
	(410, 'Consulta médica', 'Polonia', 25, '2021-06-21', '09:00', '10:00', 'RESERVADO', 'empresaMedico1', 'cliente1'),
    (411, 'Consulta médica', 'Polonia', 25, '2021-06-21', '10:00', '11:00', 'LIBRE', 'empresaMedico1', null),
    (412, 'Consulta médica', 'Polonia', 25, '2021-06-21', '11:00', '12:00', 'LIBRE', 'empresaMedico1', null),
    (413, 'Consulta médica', 'Polonia', 25, '2021-06-21', '12:00', '13:00', 'LIBRE', 'empresaMedico1', null),
    (414, 'Consulta médica', 'Polonia', 25, '2021-06-22', '09:00', '10:00', 'LIBRE', 'empresaMedico1', null),
    (415, 'Consulta médica', 'Polonia', 25, '2021-06-22', '10:00', '11:00', 'LIBRE', 'empresaMedico1', null),
    (416, 'Consulta médica', 'Polonia', 25, '2021-06-22', '11:00', '12:00', 'RESERVADO', 'empresaMedico1', 'cliente2'),
    (417, 'Consulta médica', 'Polonia', 25, '2021-06-22', '12:00', '13:00', 'LIBRE', 'empresaMedico1', null),
    (418, 'Consulta médica', 'Polonia', 25, '2021-06-23', '09:00', '10:00', 'LIBRE', 'empresaMedico1', null),
    (419, 'Consulta médica', 'Polonia', 25, '2021-06-23', '10:00', '11:00', 'LIBRE', 'empresaMedico1', null),
    (420, 'Consulta médica', 'Polonia', 25, '2021-06-23', '11:00', '12:00', 'LIBRE', 'empresaMedico1', null),
    (421, 'Consulta médica', 'Polonia', 25, '2021-06-23', '12:00', '13:00', 'LIBRE', 'empresaMedico1', null),
    (422, 'Consulta médica', 'Polonia', 25, '2021-06-24', '09:00', '10:00', 'LIBRE', 'empresaMedico1', null),
    (423, 'Consulta médica', 'Polonia', 25, '2021-06-24', '10:00', '11:00', 'LIBRE', 'empresaMedico1', null),
    (424, 'Consulta médica', 'Polonia', 25, '2021-06-24', '11:00', '12:00', 'LIBRE', 'empresaMedico1', null),
    (425, 'Consulta médica', 'Polonia', 25, '2021-06-24', '12:00', '13:00', 'LIBRE', 'empresaMedico1', null),
    (426, 'Consulta médica', 'Polonia', 25, '2021-06-25', '09:00', '10:00', 'LIBRE', 'empresaMedico1', null),
    (427, 'Consulta médica', 'Polonia', 25, '2021-06-25', '10:00', '11:00', 'LIBRE', 'empresaMedico1', null),
    (428, 'Consulta médica', 'Polonia', 25, '2021-06-25', '11:00', '12:00', 'LIBRE', 'empresaMedico1', null),
    (429, 'Consulta médica', 'Polonia', 25, '2021-06-25', '12:00', '13:00', 'LIBRE', 'empresaMedico1', null),
    (430, 'Consulta médica', 'Polonia', 25, '2021-06-26', '09:00', '10:00', 'LIBRE', 'empresaMedico1', null),
    (431, 'Consulta médica', 'Polonia', 25, '2021-06-26', '10:00', '11:00', 'LIBRE', 'empresaMedico1', null),
    (432, 'Consulta médica', 'Polonia', 25, '2021-06-26', '11:00', '12:00', 'LIBRE', 'empresaMedico1', null),
    (433, 'Consulta médica', 'Polonia', 25, '2021-06-26', '12:00', '13:00', 'LIBRE', 'empresaMedico1', null);

INSERT INTO `reservas`.`servicio` (id, nombre, direccion, precio, fecha, horaInicio, horaFin, estado, empresa, cliente) VALUES 
	(434, 'Consulta médica', 'Barcelona', 20, '2021-06-21', '09:00', '10:00', 'RESERVADO', 'empresaPsicologo1', 'clienteDario'),
    (435, 'Consulta médica', 'Barcelona', 20, '2021-06-21', '10:00', '11:00', 'LIBRE', 'empresaPsicologo1', null),
    (436, 'Consulta médica', 'Barcelona', 20, '2021-06-21', '11:00', '12:00', 'LIBRE', 'empresaPsicologo1', null),
    (437, 'Consulta médica', 'Barcelona', 20, '2021-06-21', '12:00', '13:00', 'LIBRE', 'empresaPsicologo1', null),
    (438, 'Consulta médica', 'Barcelona', 20, '2021-06-22', '09:00', '10:00', 'LIBRE', 'empresaPsicologo1', null),
    (439, 'Consulta médica', 'Barcelona', 20, '2021-06-22', '10:00', '11:00', 'LIBRE', 'empresaPsicologo1', null),
    (440, 'Consulta médica', 'Barcelona', 20, '2021-06-22', '11:00', '12:00', 'LIBRE', 'empresaPsicologo1', null),
    (441, 'Consulta médica', 'Barcelona', 20, '2021-06-22', '12:00', '13:00', 'RESERVADO', 'empresaPsicologo1', 'cliente4'),
    (442, 'Consulta médica', 'Barcelona', 20, '2021-06-23', '09:00', '10:00', 'LIBRE', 'empresaPsicologo1', null),
    (443, 'Consulta médica', 'Barcelona', 20, '2021-06-23', '10:00', '11:00', 'LIBRE', 'empresaPsicologo1', null),
    (444, 'Consulta médica', 'Barcelona', 20, '2021-06-23', '11:00', '12:00', 'LIBRE', 'empresaPsicologo1', null),
    (445, 'Consulta médica', 'Barcelona', 20, '2021-06-23', '12:00', '13:00', 'RESERVADO', 'empresaPsicologo1', 'cliente3'),
    (446, 'Consulta médica', 'Barcelona', 20, '2021-06-24', '09:00', '10:00', 'LIBRE', 'empresaPsicologo1', null),
    (447, 'Consulta médica', 'Barcelona', 20, '2021-06-24', '10:00', '11:00', 'LIBRE', 'empresaPsicologo1', null),
    (448, 'Consulta médica', 'Barcelona', 20, '2021-06-24', '11:00', '12:00', 'LIBRE', 'empresaPsicologo1', null),
    (449, 'Consulta médica', 'Barcelona', 20, '2021-06-24', '12:00', '13:00', 'LIBRE', 'empresaPsicologo1', null),
    (450, 'Consulta médica', 'Barcelona', 20, '2021-06-25', '09:00', '10:00', 'LIBRE', 'empresaPsicologo1', null),
    (451, 'Consulta médica', 'Barcelona', 20, '2021-06-25', '10:00', '11:00', 'LIBRE', 'empresaPsicologo1', null),
    (452, 'Consulta médica', 'Barcelona', 20, '2021-06-25', '11:00', '12:00', 'LIBRE', 'empresaPsicologo1', null),
    (453, 'Consulta médica', 'Barcelona', 20, '2021-06-25', '12:00', '13:00', 'RESERVADO', 'empresaPsicologo1', 'cliente4');

INSERT INTO `reservas`.`servicio` (id, nombre, direccion, precio, fecha, horaInicio, horaFin, estado, empresa, cliente) VALUES 
	(454, 'Consulta médica', 'Madrid', 20, '2021-06-21', '09:00', '10:00', 'RESERVADO', 'empresaPsicologo2', 'clienteSameh'),
    (455, 'Consulta médica', 'Madrid', 20, '2021-06-21', '10:00', '11:00', 'LIBRE', 'empresaPsicologo2', null),
    (456, 'Consulta médica', 'Madrid', 20, '2021-06-21', '11:00', '12:00', 'RESERVADO', 'empresaPsicologo2', 'cliente5'),
    (457, 'Consulta médica', 'Madrid', 20, '2021-06-21', '12:00', '13:00', 'LIBRE', 'empresaPsicologo2', null),
    (458, 'Consulta médica', 'Madrid', 20, '2021-06-22', '09:00', '10:00', 'LIBRE', 'empresaPsicologo2', null),
    (459, 'Consulta médica', 'Madrid', 20, '2021-06-22', '10:00', '11:00', 'LIBRE', 'empresaPsicologo2', null),
    (460, 'Consulta médica', 'Madrid', 20, '2021-06-22', '11:00', '12:00', 'RESERVADO', 'empresaPsicologo2', 'clienteJosue'),
    (461, 'Consulta médica', 'Madrid', 20, '2021-06-22', '12:00', '13:00', 'LIBRE', 'empresaPsicologo2', null),
    (462, 'Consulta médica', 'Madrid', 20, '2021-06-23', '09:00', '10:00', 'LIBRE', 'empresaPsicologo2', null),
    (463, 'Consulta médica', 'Madrid', 20, '2021-06-23', '10:00', '11:00', 'LIBRE', 'empresaPsicologo2', null),
    (464, 'Consulta médica', 'Madrid', 20, '2021-06-23', '11:00', '12:00', 'LIBRE', 'empresaPsicologo2', null),
    (465, 'Consulta médica', 'Madrid', 20, '2021-06-23', '12:00', '13:00', 'LIBRE', 'empresaPsicologo2', null),
    (466, 'Consulta médica', 'Madrid', 20, '2021-06-24', '09:00', '10:00', 'LIBRE', 'empresaPsicologo2', null),
    (467, 'Consulta médica', 'Madrid', 20, '2021-06-24', '10:00', '11:00', 'LIBRE', 'empresaPsicologo2', null),
    (468, 'Consulta médica', 'Madrid', 20, '2021-06-24', '11:00', '12:00', 'RESERVADO', 'empresaPsicologo2', 'clienteFele'),
    (469, 'Consulta médica', 'Madrid', 20, '2021-06-24', '12:00', '13:00', 'LIBRE', 'empresaPsicologo2', null),
    (470, 'Consulta médica', 'Madrid', 20, '2021-06-25', '09:00', '10:00', 'LIBRE', 'empresaPsicologo2', null),
    (471, 'Consulta médica', 'Madrid', 20, '2021-06-25', '10:00', '11:00', 'LIBRE', 'empresaPsicologo2', null),
    (472, 'Consulta médica', 'Madrid', 20, '2021-06-25', '11:00', '12:00', 'LIBRE', 'empresaPsicologo2', null),
    (473, 'Consulta médica', 'Madrid', 20, '2021-06-25', '12:00', '13:00', 'RESERVADO', 'empresaPsicologo2', 'cliente6');
    
INSERT INTO `reservas`.`servicio` (id, nombre, direccion, precio, fecha, horaInicio, horaFin, estado, empresa, cliente) VALUES 
	(474, 'Cuidado mascota', 'Aspe', 10, '2021-06-23', '09:00', '10:00', 'LIBRE', 'empresaMascotas1', null),
    (475, 'Cuidado mascota', 'Aspe', 10, '2021-06-23', '10:00', '11:00', 'LIBRE', 'empresaMascotas1', null),
    (476, 'Cuidado mascota', 'Aspe', 10, '2021-06-23', '11:00', '12:00', 'RESERVADO', 'empresaMascotas1', 'clienteJoaquin'),
    (477, 'Cuidado mascota', 'Aspe', 10, '2021-06-23', '12:00', '13:00', 'LIBRE', 'empresaMascotas1', null),
    (478, 'Cuidado mascota', 'Aspe', 10, '2021-06-24', '09:00', '10:00', 'LIBRE', 'empresaMascotas1', null),
    (479, 'Cuidado mascota', 'Aspe', 10, '2021-06-24', '10:00', '11:00', 'PLAN', 'empresaMascotas1', null),
    (480, 'Cuidado mascota', 'Aspe', 10, '2021-06-24', '11:00', '12:00', 'RESERVADO', 'empresaMascotas1', 'clienteJose'),
    (481, 'Cuidado mascota', 'Aspe', 10, '2021-06-24', '12:00', '13:00', 'LIBRE', 'empresaMascotas1', null),
    (482, 'Cuidado mascota', 'Aspe', 10, '2021-06-25', '09:00', '10:00', 'LIBRE', 'empresaMascotas1', null),
    (483, 'Cuidado mascota', 'Aspe', 10, '2021-06-25', '10:00', '11:00', 'LIBRE', 'empresaMascotas1', null),
    (484, 'Cuidado mascota', 'Aspe', 10, '2021-06-25', '11:00', '12:00', 'LIBRE', 'empresaMascotas1', null),
    (485, 'Cuidado mascota', 'Aspe', 10, '2021-06-25', '12:00', '13:00', 'LIBRE', 'empresaMascotas1', null),
    (486, 'Cuidado mascota', 'Aspe', 10, '2021-06-26', '09:00', '10:00', 'LIBRE', 'empresaMascotas1', null),
    (487, 'Cuidado mascota', 'Aspe', 10, '2021-06-26', '10:00', '11:00', 'LIBRE', 'empresaMascotas1', null),
    (488, 'Cuidado mascota', 'Aspe', 10, '2021-06-26', '11:00', '12:00', 'LIBRE', 'empresaMascotas1', null),
    (489, 'Cuidado mascota', 'Aspe', 10, '2021-06-26', '12:00', '13:00', 'LIBRE', 'empresaMascotas1', null);

INSERT INTO `reservas`.`servicio` (id, nombre, direccion, precio, fecha, horaInicio, horaFin, estado, empresa, cliente) VALUES 
	(490, 'Cuidado mascota', 'Torrevieja', 14, '2021-06-23', '09:00', '10:00', 'LIBRE', 'empresaMascotas2', null),
    (491, 'Cuidado mascota', 'Torrevieja', 14, '2021-06-23', '10:00', '11:00', 'LIBRE', 'empresaMascotas2', null),
    (492, 'Cuidado mascota', 'Torrevieja', 14, '2021-06-23', '11:00', '12:00', 'RESERVADO', 'empresaMascotas2', 'cliente5'),
    (493, 'Cuidado mascota', 'Torrevieja', 14, '2021-06-23', '12:00', '13:00', 'LIBRE', 'empresaMascotas2', null),
    (494, 'Cuidado mascota', 'Torrevieja', 14, '2021-06-24', '09:00', '10:00', 'LIBRE', 'empresaMascotas2', null),
    (495, 'Cuidado mascota', 'Torrevieja', 14, '2021-06-24', '10:00', '11:00', 'LIBRE', 'empresaMascotas2', null),
    (496, 'Cuidado mascota', 'Torrevieja', 14, '2021-06-24', '11:00', '12:00', 'LIBRE', 'empresaMascotas2', null),
    (497, 'Cuidado mascota', 'Torrevieja', 14, '2021-06-24', '12:00', '13:00', 'PLAN', 'empresaMascotas2', null),
    (498, 'Cuidado mascota', 'Torrevieja', 14, '2021-06-25', '09:00', '10:00', 'LIBRE', 'empresaMascotas2', null),
    (499, 'Cuidado mascota', 'Torrevieja', 14, '2021-06-25', '10:00', '11:00', 'RESERVADO', 'empresaMascotas2', 'clienteJosue'),
    (500, 'Cuidado mascota', 'Torrevieja', 14, '2021-06-25', '11:00', '12:00', 'LIBRE', 'empresaMascotas2', null),
    (501, 'Cuidado mascota', 'Torrevieja', 14, '2021-06-25', '12:00', '13:00', 'LIBRE', 'empresaMascotas2', null),
    (502, 'Cuidado mascota', 'Torrevieja', 14, '2021-06-26', '09:00', '10:00', 'RESERVADO', 'empresaMascotas2', 'cliente6'),
    (503, 'Cuidado mascota', 'Torrevieja', 14, '2021-06-26', '10:00', '11:00', 'LIBRE', 'empresaMascotas2', null),
    (504, 'Cuidado mascota', 'Torrevieja', 14, '2021-06-26', '11:00', '12:00', 'LIBRE', 'empresaMascotas2', null),
    (505, 'Cuidado mascota', 'Torrevieja', 14, '2021-06-26', '12:00', '13:00', 'LIBRE', 'empresaMascotas2', null);

INSERT INTO `reservas`.`servicio` (id, nombre, direccion, precio, fecha, horaInicio, horaFin, estado, empresa, cliente) VALUES 
	(506, 'Depilacion', 'Mexico', 50, '2021-06-21', '09:00', '10:00', 'LIBRE', 'empresaDepilacion1', null),
    (507, 'Depilacion', 'Mexico', 50, '2021-06-21', '10:00', '11:00', 'LIBRE', 'empresaDepilacion1', null),
    (508, 'Depilacion', 'Mexico', 50, '2021-06-21', '11:00', '12:00', 'LIBRE', 'empresaDepilacion1', null),
    (509, 'Depilacion', 'Mexico', 50, '2021-06-21', '12:00', '13:00', 'LIBRE', 'empresaDepilacion1', null),
    (510, 'Depilacion', 'Mexico', 50, '2021-06-22', '09:00', '10:00', 'LIBRE', 'empresaDepilacion1', null),
    (511, 'Depilacion', 'Mexico', 50, '2021-06-22', '10:00', '11:00', 'LIBRE', 'empresaDepilacion1', null),
    (512, 'Depilacion', 'Mexico', 50, '2021-06-22', '11:00', '12:00', 'LIBRE', 'empresaDepilacion1', null),
    (513, 'Depilacion', 'Mexico', 50, '2021-06-22', '12:00', '13:00', 'LIBRE', 'empresaDepilacion1', null),
    (514, 'Depilacion', 'Mexico', 50, '2021-06-23', '09:00', '10:00', 'LIBRE', 'empresaDepilacion1', null),
    (515, 'Depilacion', 'Mexico', 50, '2021-06-23', '10:00', '11:00', 'LIBRE', 'empresaDepilacion1', null),
    (516, 'Depilacion', 'Mexico', 50, '2021-06-23', '11:00', '12:00', 'LIBRE', 'empresaDepilacion1', null),
    (517, 'Depilacion', 'Mexico', 50, '2021-06-23', '12:00', '13:00', 'RESERVADO', 'empresaDepilacion1', 'clienteJose'),
    (518, 'Depilacion', 'Mexico', 50, '2021-06-24', '09:00', '10:00', 'LIBRE', 'empresaDepilacion1', null),
    (519, 'Depilacion', 'Mexico', 50, '2021-06-24', '10:00', '11:00', 'LIBRE', 'empresaDepilacion1', null),
    (520, 'Depilacion', 'Mexico', 50, '2021-06-24', '11:00', '12:00', 'LIBRE', 'empresaDepilacion1', null),
    (521, 'Depilacion', 'Mexico', 50, '2021-06-24', '12:00', '13:00', 'LIBRE', 'empresaDepilacion1', null),
    (522, 'Depilacion', 'Mexico', 50, '2021-06-25', '09:00', '10:00', 'RESERVADO', 'empresaDepilacion1', 'clienteFele'),
    (523, 'Depilacion', 'Mexico', 50, '2021-06-25', '10:00', '11:00', 'LIBRE', 'empresaDepilacion1', null),
    (524, 'Depilacion', 'Mexico', 50, '2021-06-25', '11:00', '12:00', 'LIBRE', 'empresaDepilacion1', null),
    (525, 'Depilacion', 'Mexico', 50, '2021-06-25', '12:00', '13:00', 'LIBRE', 'empresaDepilacion1', null),
    (526, 'Depilacion', 'Mexico', 50, '2021-06-26', '09:00', '10:00', 'LIBRE', 'empresaDepilacion1', null),
    (527, 'Depilacion', 'Mexico', 50, '2021-06-26', '10:00', '11:00', 'LIBRE', 'empresaDepilacion1', null),
    (528, 'Depilacion', 'Mexico', 50, '2021-06-26', '11:00', '12:00', 'LIBRE', 'empresaDepilacion1', null),
    (529, 'Depilacion', 'Mexico', 50, '2021-06-26', '12:00', '13:00', 'LIBRE', 'empresaDepilacion1', null);

INSERT INTO `reservas`.`servicio` (id, nombre, direccion, precio, fecha, horaInicio, horaFin, estado, empresa, cliente) VALUES
	(530, 'Excursion', 'Denia', 50, '2021-06-24', '09:00', '11:00', 'RESERVADO', 'empresaExcursion1', 'cliente7'),
    (531, 'Excursion', 'Denia', 50, '2021-06-24', '11:00', '13:00', 'LIBRE', 'empresaExcursion1', null),
    (532, 'Excursion', 'Denia', 50, '2021-06-24', '16:00', '18:00', 'LIBRE', 'empresaExcursion1', null),
    (533, 'Excursion', 'Denia', 50, '2021-06-24', '18:00', '20:00', 'LIBRE', 'empresaExcursion1', null),
    (534, 'Excursion', 'Denia', 50, '2021-06-25', '09:00', '11:00', 'RESERVADO', 'empresaExcursion1', 'cliente8'),
    (535, 'Excursion', 'Denia', 50, '2021-06-25', '11:00', '13:00', 'LIBRE', 'empresaExcursion1', null),
    (536, 'Excursion', 'Denia', 50, '2021-06-25', '16:00', '18:00', 'PLAN', 'empresaExcursion1', null),
    (537, 'Excursion', 'Denia', 50, '2021-06-25', '18:00', '20:00', 'LIBRE', 'empresaExcursion1', null),
    (538, 'Excursion', 'Denia', 50, '2021-06-26', '09:00', '11:00', 'LIBRE', 'empresaExcursion1', null),
    (539, 'Excursion', 'Denia', 50, '2021-06-26', '11:00', '13:00', 'LIBRE', 'empresaExcursion1', null),
    (540, 'Excursion', 'Denia', 50, '2021-06-26', '16:00', '18:00', 'LIBRE', 'empresaExcursion1', null),
    (541, 'Excursion', 'Denia', 50, '2021-06-26', '18:00', '20:00', 'RESERVADO', 'empresaExcursion1', 'clienteJoaquin'),
    (542, 'Excursion', 'Denia', 50, '2021-06-27', '09:00', '11:00', 'RESERVADO', 'empresaExcursion1', 'clienteJosue'),
    (543, 'Excursion', 'Denia', 50, '2021-06-27', '11:00', '13:00', 'LIBRE', 'empresaExcursion1', null),
    (544, 'Excursion', 'Denia', 50, '2021-06-27', '16:00', '18:00', 'LIBRE', 'empresaExcursion1', null),
    (545, 'Excursion', 'Denia', 50, '2021-06-27', '18:00', '20:00', 'LIBRE', 'empresaExcursion1', null);

INSERT INTO `reservas`.`servicio` (id, nombre, direccion, precio, fecha, horaInicio, horaFin, estado, empresa, cliente) VALUES
	(546, 'Excursion de montaña', 'Villena', 10, '2021-06-21', '09:00', '11:00', 'LIBRE', 'empresaExcursion2', null),
    (547, 'Excursion de montaña', 'Villena', 10, '2021-06-21', '11:00', '13:00', 'LIBRE', 'empresaExcursion2', null),
    (548, 'Excursion de montaña', 'Villena', 10, '2021-06-21', '16:00', '18:00', 'LIBRE', 'empresaExcursion2', null),
    (549, 'Excursion de montaña', 'Villena', 10, '2021-06-21', '18:00', '20:00', 'LIBRE', 'empresaExcursion2', null),
    (550, 'Excursion de montaña', 'Villena', 10, '2021-06-22', '09:00', '11:00', 'LIBRE', 'empresaExcursion2', null),
    (551, 'Excursion de montaña', 'Villena', 10, '2021-06-22', '11:00', '13:00', 'LIBRE', 'empresaExcursion2', null),
    (552, 'Excursion de montaña', 'Villena', 10, '2021-06-22', '16:00', '18:00', 'RESERVADO', 'empresaExcursion2', 'cliente9'),
    (553, 'Excursion de montaña', 'Villena', 10, '2021-06-22', '18:00', '20:00', 'LIBRE', 'empresaExcursion2', null),
    (554, 'Excursion de montaña', 'Villena', 10, '2021-06-23', '09:00', '11:00', 'LIBRE', 'empresaExcursion2', null),
    (555, 'Excursion de montaña', 'Villena', 10, '2021-06-23', '11:00', '13:00', 'LIBRE', 'empresaExcursion2', null),
    (556, 'Excursion de montaña', 'Villena', 10, '2021-06-23', '16:00', '18:00', 'LIBRE', 'empresaExcursion2', null),
    (557, 'Excursion de montaña', 'Villena', 10, '2021-06-23', '18:00', '20:00', 'LIBRE', 'empresaExcursion2', null),
    (558, 'Excursion de montaña', 'Villena', 10, '2021-06-24', '09:00', '11:00', 'LIBRE', 'empresaExcursion2', null),
    (559, 'Excursion de montaña', 'Villena', 10, '2021-06-24', '11:00', '13:00', 'LIBRE', 'empresaExcursion2', null),
    (560, 'Excursion de montaña', 'Villena', 10, '2021-06-24', '16:00', '18:00', 'LIBRE', 'empresaExcursion2', null),
    (561, 'Excursion de montaña', 'Villena', 10, '2021-06-24', '18:00', '20:00', 'LIBRE', 'empresaExcursion2', null),
    (562, 'Excursion de montaña', 'Villena', 10, '2021-06-25', '09:00', '11:00', 'LIBRE', 'empresaExcursion2', null),
    (563, 'Excursion de montaña', 'Villena', 10, '2021-06-25', '11:00', '13:00', 'PLAN', 'empresaExcursion2', null),
    (564, 'Excursion de montaña', 'Villena', 10, '2021-06-25', '16:00', '18:00', 'LIBRE', 'empresaExcursion2', null),
    (565, 'Excursion de montaña', 'Villena', 10, '2021-06-25', '18:00', '20:00', 'LIBRE', 'empresaExcursion2', null),
    (566, 'Excursion de montaña', 'Villena', 10, '2021-06-26', '09:00', '11:00', 'LIBRE', 'empresaExcursion2', null),
    (567, 'Excursion de montaña', 'Villena', 10, '2021-06-26', '11:00', '13:00', 'LIBRE', 'empresaExcursion2', null),
    (568, 'Excursion de montaña', 'Villena', 10, '2021-06-26', '16:00', '18:00', 'LIBRE', 'empresaExcursion2', null),
    (569, 'Excursion de montaña', 'Villena', 10, '2021-06-26', '18:00', '20:00', 'LIBRE', 'empresaExcursion2', null),
    (570, 'Excursion de montaña', 'Villena', 10, '2021-06-27', '09:00', '11:00', 'PLAN', 'empresaExcursion2', null),
    (571, 'Excursion de montaña', 'Villena', 10, '2021-06-27', '11:00', '13:00', 'PLAN', 'empresaExcursion2', null),
    (572, 'Excursion de montaña', 'Villena', 10, '2021-06-27', '16:00', '18:00', 'PLAN', 'empresaExcursion2', null),
    (573, 'Excursion de montaña', 'Villena', 10, '2021-06-27', '18:00', '20:00', 'RESERVADO', 'empresaExcursion2', 'cliente9');

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
    
INSERT INTO `reservas`.`planes` (`id`, `servicio_id`, `nombre`, `descripcion`, `precioTotal`, `estado`, `cliente`) VALUES 
	('1', '123', 'Plan de spas', 'Disfruta de un día de relajación completo', '85', 'LIBRE', null),
	('1', '160', 'Plan de spas', 'Disfruta de un día de relajación completo', '85', 'LIBRE', null),
	('1', '176', 'Plan de spas', 'Disfruta de un día de relajación completo', '85', 'LIBRE', null);


INSERT INTO `reservas`.`planes` (`id`, `servicio_id`, `nombre`, `descripcion`, `precioTotal`, `estado`, `cliente`) VALUES
	('2', '243', 'Día de actividad', '¡Llena tu día de acividades y aumenta tu energía!', '0', 'LIBRE', null),
	('2', '147', 'Día de actividad', '¡Llena tu día de acividades y aumenta tu energía!', '0', 'LIBRE', null),
	('2', '182', 'Día de actividad', '¡Llena tu día de acividades y aumenta tu energía!', '0', 'LIBRE', null);


INSERT INTO `reservas`.`planes` (`id`, `servicio_id`, `nombre`, `descripcion`, `precioTotal`, `estado`, `cliente`) VALUES
	('3', '314', 'Fuerza máxima', 'Un día con extra de ejercicio, ¿te vas a rendir?', '6', 'LIBRE', null),
	('3', '400', 'Fuerza máxima', 'Un día con extra de ejercicio, ¿te vas a rendir?', '6', 'LIBRE', null);

INSERT INTO `reservas`.`planes` (`id`, `servicio_id`, `nombre`, `descripcion`, `precioTotal`, `estado`, `cliente`) VALUES
	('4', '194', 'Estómago lleno', 'Visita varios restaurantes y elige tu estilo favorito.', '0', 'LIBRE', null),
	('4', '204', 'Estómago lleno', 'Visita varios restaurantes y elige tu estilo favorito.', '0', 'LIBRE', null),
    ('4', '214', 'Estómago lleno', 'Visita varios restaurantes y elige tu estilo favorito.', '0', 'LIBRE', null);

INSERT INTO `reservas`.`planes` (`id`, `servicio_id`, `nombre`, `descripcion`, `precioTotal`, `estado`, `cliente`) VALUES
	('5', '479', 'Mi mejor amigo', 'Con este plan tu mascota pasará un día increíble.', '24', 'LIBRE', null),
	('5', '497', 'Mi mejor amigo', 'Con este plan tu mascota pasará un día increíble.', '24', 'LIBRE', null);
    
INSERT INTO `reservas`.`planes` (`id`, `servicio_id`, `nombre`, `descripcion`, `precioTotal`, `estado`, `cliente`) VALUES
	('6', '570', 'Excurisón por la montaña', 'Pasarás un día completo en la montaña con un grupo encantador de personas.', '30', 'LIBRE', null),
	('6', '571', 'Excurisón por la montaña', 'Pasarás un día completo en la montaña con un grupo encantador de personas.', '30', 'LIBRE', null),
    ('6', '572', 'Excurisón por la montaña', 'Pasarás un día completo en la montaña con un grupo encantador de personas.', '30', 'LIBRE', null);

INSERT INTO `reservas`.`planes` (`id`, `servicio_id`, `nombre`, `descripcion`, `precioTotal`, `estado`, `cliente`) VALUES
	('7', '536', '¡Aventura!', 'Recupera tu espíritu aventurero. Después de estas escursiones sólo querrás repetir.', '30', 'LIBRE', null),
    ('7', '563', '¡Aventura!', 'Recupera tu espíritu aventurero. Después de estas escursiones sólo querrás repetir.', '30', 'LIBRE', null);


