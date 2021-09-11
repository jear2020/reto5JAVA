-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.2.40-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para reto5
CREATE DATABASE IF NOT EXISTS `reto5` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `reto5`;

-- Volcando estructura para tabla reto5.accesos
CREATE TABLE IF NOT EXISTS `accesos` (
  `id` int(3) unsigned NOT NULL AUTO_INCREMENT,
  `correo` varchar(100) NOT NULL,
  `tipo` varchar(20) NOT NULL,
  `estado` varchar(20) NOT NULL,
  `hora` time NOT NULL,
  `usu_id` int(3) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK__usuarios` (`usu_id`),
  CONSTRAINT `FK__usuarios` FOREIGN KEY (`usu_id`) REFERENCES `usuarios` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=148 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla reto5.accesos: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `accesos` DISABLE KEYS */;
/*!40000 ALTER TABLE `accesos` ENABLE KEYS */;

-- Volcando estructura para tabla reto5.contenidos
CREATE TABLE IF NOT EXISTS `contenidos` (
  `id` int(3) unsigned NOT NULL AUTO_INCREMENT,
  `titulo` varchar(50) NOT NULL,
  `texto` text NOT NULL,
  `cur_id` int(3) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_contenidos_cursos` (`cur_id`),
  CONSTRAINT `FK_contenidos_cursos` FOREIGN KEY (`cur_id`) REFERENCES `cursos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla reto5.contenidos: ~11 rows (aproximadamente)
/*!40000 ALTER TABLE `contenidos` DISABLE KEYS */;
INSERT INTO `contenidos` (`id`, `titulo`, `texto`, `cur_id`) VALUES
	(1, 'Diagramas de Flujo', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industrys standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.', 1),
	(2, 'algoritmos', 'lorem ', 1),
	(3, 'contenido 1', 'contenido para paradigmas de progrmamacion\ncontenido para paradigmas de progrmamacion\ncontenido para paradigmas de progrmamacion\ncontenido para paradigmas de progrmamacion', 13),
	(4, 'contenido de prueba', 'prueba de contenico', 13),
	(6, 'contenido para algoritmos', 'este es un contenido de prueba para el curso de algoritmos ', 3),
	(7, 'contenido programacion 1', 'este es un contenido para el curso de programacion one', 1),
	(8, 'nuevo contenido', 'primer contenido esturcturas', 4),
	(9, 'primer contenido', 'Este es el primer contenido de prueba', 5),
	(10, 'modelos sql', 'modelos sql implementando los motores mariaDB y MySql', 2),
	(11, 'otro contenido', 'otro contenido otro contenido otro contenido', 3),
	(13, 'nuevo contenido', ' nuevo contenido nuevo contenido nuevo contenido', 4);
/*!40000 ALTER TABLE `contenidos` ENABLE KEYS */;

-- Volcando estructura para tabla reto5.coordinadores
CREATE TABLE IF NOT EXISTS `coordinadores` (
  `id` int(3) unsigned NOT NULL AUTO_INCREMENT,
  `usu_id` int(3) unsigned NOT NULL,
  PRIMARY KEY (`id`,`usu_id`) USING BTREE,
  KEY `FK_coordinadores_usuarios` (`usu_id`),
  CONSTRAINT `FK_coordinadores_usuarios` FOREIGN KEY (`usu_id`) REFERENCES `usuarios` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla reto5.coordinadores: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `coordinadores` DISABLE KEYS */;
INSERT INTO `coordinadores` (`id`, `usu_id`) VALUES
	(1, 4);
/*!40000 ALTER TABLE `coordinadores` ENABLE KEYS */;

-- Volcando estructura para tabla reto5.cursos
CREATE TABLE IF NOT EXISTS `cursos` (
  `id` int(3) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(40) NOT NULL,
  `horario` varchar(30) NOT NULL,
  `ubicacion` varchar(40) NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date NOT NULL,
  `pro_id` int(3) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_cursos_profesores` (`pro_id`),
  CONSTRAINT `FK_cursos_profesores` FOREIGN KEY (`pro_id`) REFERENCES `profesores` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla reto5.cursos: ~9 rows (aproximadamente)
/*!40000 ALTER TABLE `cursos` DISABLE KEYS */;
INSERT INTO `cursos` (`id`, `nombre`, `horario`, `ubicacion`, `fecha_inicio`, `fecha_fin`, `pro_id`) VALUES
	(1, 'Programacion I', '2 - 4', 'salon 202', '2021-08-15', '2021-11-20', 1),
	(2, 'Base de datos', '3-6', 'salon 404', '2021-08-08', '2021-08-31', 1),
	(3, 'algoritmos', '2-4', 'salon rojo', '2021-08-05', '2021-08-21', 1),
	(4, 'estructura de datos', '1-7', 'Salon 5', '2021-08-01', '2021-08-29', 1),
	(5, 'prueba', '3-5', 'salon 1', '2021-08-05', '2021-08-08', 1),
	(13, 'Paradigmas de programacion', '1-8', 'salon cicom', '2021-08-06', '2021-08-08', 3),
	(14, 'inicios de programacion', '2-5', 'salon 3', '2021-08-02', '2021-08-31', 7),
	(15, 'pedagogia', '1-3', 'salon 301-1', '2021-08-06', '2021-08-27', 8),
	(16, 'pedagogia 1', '1-3', 'Salon pedagogico', '2021-08-04', '2021-08-20', 9);
/*!40000 ALTER TABLE `cursos` ENABLE KEYS */;

-- Volcando estructura para tabla reto5.estudiantes
CREATE TABLE IF NOT EXISTS `estudiantes` (
  `id` int(3) unsigned NOT NULL AUTO_INCREMENT,
  `usu_id` int(3) unsigned NOT NULL,
  PRIMARY KEY (`id`,`usu_id`),
  KEY `FK_estudiantes_usuarios` (`usu_id`),
  CONSTRAINT `FK_estudiantes_usuarios` FOREIGN KEY (`usu_id`) REFERENCES `usuarios` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla reto5.estudiantes: ~6 rows (aproximadamente)
/*!40000 ALTER TABLE `estudiantes` DISABLE KEYS */;
INSERT INTO `estudiantes` (`id`, `usu_id`) VALUES
	(1, 1),
	(2, 2),
	(3, 15),
	(4, 16),
	(5, 18),
	(6, 18);
/*!40000 ALTER TABLE `estudiantes` ENABLE KEYS */;

-- Volcando estructura para tabla reto5.estudiantesxcursos
CREATE TABLE IF NOT EXISTS `estudiantesxcursos` (
  `id` int(3) unsigned NOT NULL AUTO_INCREMENT,
  `est_id` int(3) unsigned NOT NULL,
  `cur_id` int(3) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK__estudiantes` (`est_id`),
  KEY `FK__cursos` (`cur_id`),
  CONSTRAINT `FK__cursos` FOREIGN KEY (`cur_id`) REFERENCES `cursos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK__estudiantes` FOREIGN KEY (`est_id`) REFERENCES `estudiantes` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla reto5.estudiantesxcursos: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `estudiantesxcursos` DISABLE KEYS */;
INSERT INTO `estudiantesxcursos` (`id`, `est_id`, `cur_id`) VALUES
	(35, 1, 1);
/*!40000 ALTER TABLE `estudiantesxcursos` ENABLE KEYS */;

-- Volcando estructura para tabla reto5.profesores
CREATE TABLE IF NOT EXISTS `profesores` (
  `id` int(3) unsigned NOT NULL AUTO_INCREMENT,
  `titulo` varchar(50) NOT NULL,
  `anios_experiencia` int(2) unsigned NOT NULL,
  `usu_id` int(3) unsigned NOT NULL,
  PRIMARY KEY (`id`,`usu_id`),
  KEY `FK_profesores_usuarios` (`usu_id`),
  CONSTRAINT `FK_profesores_usuarios` FOREIGN KEY (`usu_id`) REFERENCES `usuarios` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla reto5.profesores: ~6 rows (aproximadamente)
/*!40000 ALTER TABLE `profesores` DISABLE KEYS */;
INSERT INTO `profesores` (`id`, `titulo`, `anios_experiencia`, `usu_id`) VALUES
	(1, 'Ingenieria de Sistemas', 4, 3),
	(3, 'otrs', 21, 5),
	(4, 'Matematica Pura', 3, 11),
	(7, 'Fisico', 3, 17),
	(8, 'Ingeniria de Sistemas', 1, 19),
	(9, 'Pedagogia', 16, 21);
/*!40000 ALTER TABLE `profesores` ENABLE KEYS */;

-- Volcando estructura para tabla reto5.usuarios
CREATE TABLE IF NOT EXISTS `usuarios` (
  `id` int(3) unsigned NOT NULL AUTO_INCREMENT,
  `identificacion` varchar(20) NOT NULL DEFAULT '',
  `nombre` varchar(50) NOT NULL,
  `tipo` varchar(20) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `contrasena` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `correo` (`correo`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla reto5.usuarios: ~13 rows (aproximadamente)
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` (`id`, `identificacion`, `nombre`, `tipo`, `correo`, `contrasena`) VALUES
	(1, '12345', 'John Edward', 'Estudiante', 'jhedacro@hotmail.com', 'john1234'),
	(2, '54321', 'Pedro Suarez', 'Estudiante', 'pedro@gmail.com', 'pedro1234'),
	(3, '13245', 'Sandra Florez', 'Profesor', 'sandra@hotmail.com', 'sandra1234'),
	(4, '0', 'Julio Cesar', 'Coordinador', 'julio@gmail.com', 'julio1234'),
	(5, '321', 'Beatriz Rojas', 'Profesor', 'beartriz@hotmail.com', 'beatriz1234'),
	(11, '123213', 'Edgar Ferreira', 'Profesor', 'edgar@gmail.com', 'edgar1234'),
	(15, '1212', 'brayan', 'Estudiante', 'brayan@gmail.com', 'brayan1234'),
	(16, '1234', 'lucas restrepo', 'Estudiante', 'lucas@hotmail.com', 'lucas1234'),
	(17, '4321', 'Saul Contreras', 'Profesor', 'saul@gmail.com', 'saul1234'),
	(18, '12', 'Angel Ruiz', 'Estudiante', 'angel@hotmail.com', 'angel1234'),
	(19, '15', 'Edward Rojas', 'Profesor', 'edward@gmail.com', 'edward1234'),
	(20, '12', 'Nicolas', 'Estudiante', 'nicolas@hotmail.com', 'nicolas1234'),
	(21, '13', 'Heisy Caceres', 'Profesor', 'heisy@gmail.com', 'heisy1234');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
