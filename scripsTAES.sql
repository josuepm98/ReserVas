CREATE SCHEMA `reservas` ;

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
  `inicioJornada` VARCHAR(255) NULL,
  `finJornada` VARCHAR(255) NULL,
  `tiempoServicio` VARCHAR(255) NULL,
  PRIMARY KEY (`nombreUser`),
  CONSTRAINT `empresa_usuario`
    FOREIGN KEY (`nombreUser`)
    REFERENCES `reservas`.`usuario` (`nombreUser`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

INSERT INTO `reservas`.`usuario` (`nombreUser`, `password`, `nombre`, `apellidos`, `email`) VALUES ('taesCliente', 'taes', 'TaesCliente', 'Taes Taes', 'taesCliente@gmail.com');
INSERT INTO `reservas`.`usuario` (`nombreUser`, `password`, `nombre`, `apellidos`, `email`) VALUES ('taesCliente2', 'taes', 'TaesCliente2', 'Taes Taes2', 'taesCliente2@gmail.com');
INSERT INTO `reservas`.`usuario` (`nombreUser`, `password`, `nombre`, `apellidos`, `email`) VALUES ('taesEmpresa', 'taes', 'TaesEmpresa', 'Taes Taes', 'taesEmpresa@gmail.com');

INSERT INTO `reservas`.`empresa` (`nombreUser`, `direccion`) VALUES ('taesEmpresa', 'san vicente');

INSERT INTO `reservas`.`cliente` (`nombreUser`, `fechaNac`) VALUES ('taesCliente', '2000-05-10');
INSERT INTO `reservas`.`cliente` (`nombreUser`, `fechaNac`) VALUES ('taesCliente2', '2000-05-10');

CREATE TABLE `reservas`.`categoria` (
  `nombre` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`nombre`));
  
INSERT INTO `reservas`.`categoria` VALUES ('Peluqueria');
INSERT INTO `reservas`.`categoria` VALUES ('Spa');
  
CREATE TABLE `reservas`.`servicio` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(255) NOT NULL,
  `direccion` VARCHAR(255) NOT NULL,
  `precio` DOUBLE NOT NULL,
  `fecha` DATE NOT NULL,
  `horaInicio` TIME NOT NULL,
  `horaFin` TIME NOT NULL,
  `categoria` VARCHAR(255) NOT NULL,
  `estado` VARCHAR(255) NOT NULL,
  `empresa` VARCHAR(255) NOT NULL,
  `cliente` VARCHAR(255) NULL,
  PRIMARY KEY (`id`, `empresa`),
  INDEX `tablaServicio_empresa_idx` (`empresa` ASC) VISIBLE,
  INDEX `tablaServicio_cliente_idx` (`cliente` ASC) VISIBLE,
  INDEX `tablaServicio_categoria_idx` (`categoria` ASC) VISIBLE,
  CONSTRAINT `tablaServicio_categoria`
    FOREIGN KEY (`categoria`)
    REFERENCES `reservas`.`categoria` (`nombre`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
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
    
INSERT INTO `reservas`.`servicio` (id, nombre, direccion, precio, fecha, horaInicio, horaFin, categoria, estado, empresa,
cliente) VALUES (null, 'corte de pelo', 'San Vicente', 11.5, '2021-04-20', '08:00:00', '09:00:00', 'Peluqueria',
'LIBRE', 'taesEmpresa', null);

INSERT INTO `reservas`.`servicio` (id, nombre, direccion, precio, fecha, horaInicio, horaFin, categoria, estado, empresa,
cliente) VALUES (null, 'corte de pelo', 'San Vicente', 11.5, '2021-04-20', '09:00:00', '10:00:00', 'Peluqueria',
'RESERVADO', 'taesEmpresa', 'taesCliente');

INSERT INTO `reservas`.`servicio` (id, nombre, direccion, precio, fecha, horaInicio, horaFin, categoria, estado, empresa,
cliente) VALUES (null, 'corte de pelo', 'San Vicente', 11.5, '2021-04-20', '10:00:00', '11:00:00', 'Peluqueria',
'RESERVADO', 'taesEmpresa', 'taesCliente2');