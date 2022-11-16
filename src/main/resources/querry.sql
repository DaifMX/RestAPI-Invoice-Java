CREATE SCHEMA IF NOT EXISTS `proyecto_final`;
USE `proyecto_final`;


CREATE TABLE IF NOT EXISTS `cliente` (
  `id` BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `dni` VARCHAR(255),
  `nombre` VARCHAR(255),
  `apellido` VARCHAR(255),
  `fecha_nacimiento` DATE
);


CREATE TABLE IF NOT EXISTS `venta` (
  `id` BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `fecha_alta` DATETIME(6),
  `total` DOUBLE,
  `cliente_id` BIGINT,
  CONSTRAINT fk_cliente_id FOREIGN KEY (`cliente_id`) REFERENCES cliente(id)
);


CREATE TABLE IF NOT EXISTS `producto` (
  `id` BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(255),
  `fecha_alta` DATETIME(6),
  `precio_compra` DOUBLE,
  `precio_venta` DOUBLE,
  `sku` VARCHAR(255),
  `stock` INT
);

CREATE TABLE IF NOT EXISTS `detalle_venta` (
  `id` BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `cantidad` INT,
  `subtotal` DOUBLE,
  `precio_del_producto` DOUBLE,
  `producto_id` BIGINT,
  `venta_id` BIGINT,
   CONSTRAINT fk_venta_id FOREIGN KEY (venta_id) REFERENCES venta(id),
   CONSTRAINT fk_producto_id FOREIGN KEY (producto_id) REFERENCES producto(id)
);