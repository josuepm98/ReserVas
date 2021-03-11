CREATE SCHEMA `reservas` ;

CREATE TABLE `reservas`.`usuario` (
  `nombreUser` VARCHAR(255) NOT NULL,
  `password` SHA(VARCHAR(255)) NOT NULL,
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
  PRIMARY KEY (`nombreUser`),
  CONSTRAINT `empresa_usuario`
    FOREIGN KEY (`nombreUser`)
    REFERENCES `reservas`.`usuario` (`nombreUser`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

INSERT INTO `reservas`.`usuario` (`nombreUser`, `password`, `nombre`, `apellidos`, `email`) VALUES ('taesCliente', 'taes', 'TaesCliente', 'Taes Taes', 'taesCliente@gmail.com');
INSERT INTO `reservas`.`usuario` (`nombreUser`, `password`, `nombre`, `apellidos`, `email`) VALUES ('taesEmpresa', 'taes', 'TaesEmpresa', 'Taes Taes', 'taesEmpresa@gmail.com');

INSERT INTO `reservas`.`empresa` (`nombreUser`, `direccion`) VALUES ('taesEmpresa', 'san vicente');

INSERT INTO `reservas`.`cliente` (`nombreUser`, `fechaNac`) VALUES ('taesCliente', '2000-05-10');