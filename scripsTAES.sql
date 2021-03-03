CREATE SCHEMA `usuario` ;

CREATE TABLE `usuario`.`usuario` (
  `nombreUser` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `nombre` VARCHAR(255) NOT NULL,
  `apellidos` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`nombreUser`));
  
CREATE TABLE `usuario`.`cliente` (
  `nombreUser` VARCHAR(255) NOT NULL,
  `fechaNac` DATE NOT NULL,
  PRIMARY KEY (`nombreUser`),
  CONSTRAINT `cliente_usuario`
    FOREIGN KEY (`nombreUser`)
    REFERENCES `usuario`.`usuario` (`nombreUser`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `usuario`.`empresario` (
  `nombreUser` VARCHAR(255) NOT NULL,
  `direccion` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`nombreUser`),
  CONSTRAINT `empresario_usuario`
    FOREIGN KEY (`nombreUser`)
    REFERENCES `usuario`.`usuario` (`nombreUser`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

INSERT INTO `usuario`.`usuario` (`nombreUser`, `password`, `nombre`, `apellidos`, `email`) VALUES ('taesCliente', 'taes', 'TaesCliente', 'Taes Taes', 'taesCliente@gmail.com');
INSERT INTO `usuario`.`usuario` (`nombreUser`, `password`, `nombre`, `apellidos`, `email`) VALUES ('taesEmpresario', 'taes', 'TaesEmpresario', 'Taes Taes', 'taesEmpresario@gmail.com');

INSERT INTO `usuario`.`empresario` (`nombreUser`, `direccion`) VALUES ('taesEmpresario', 'san vicente');

INSERT INTO `usuario`.`cliente` (`nombreUser`, `fechaNac`) VALUES ('taesCliente', '2000-05-10');