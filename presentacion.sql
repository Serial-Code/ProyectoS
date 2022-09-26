-- MariaDB dump 10.19  Distrib 10.4.22-MariaDB, for Win64 (AMD64)
--
-- Host: 127.0.0.1    Database: fastpaperwork
-- ------------------------------------------------------
-- Server version	10.4.22-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `administrador`
--

DROP TABLE IF EXISTS `administrador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `administrador` (
  `idadministrador` int(11) NOT NULL AUTO_INCREMENT,
  `RUT` varchar(45) NOT NULL,
  `idinventario` int(11) DEFAULT NULL,
  `idusuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`idadministrador`),
  KEY `fk_administrador_inventario1_idx` (`idinventario`),
  KEY `fk_administrador_usuario1_idx` (`idusuario`),
  CONSTRAINT `fk_administrador_inventario1` FOREIGN KEY (`idinventario`) REFERENCES `inventario` (`idinventario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_administrador_usuario1` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1221 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrador`
--

LOCK TABLES `administrador` WRITE;
/*!40000 ALTER TABLE `administrador` DISABLE KEYS */;
INSERT INTO `administrador` VALUES (1212,'2233423',20,2121),(1213,'3434',21,2122),(1214,'55532',22,2123),(1215,'56643',23,2124),(1216,'54334',24,2125),(1217,'45321',25,2126),(1218,'43421',26,2127),(1219,'65341',27,2128),(1220,'23221',28,2129);
/*!40000 ALTER TABLE `administrador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `calificacion`
--

DROP TABLE IF EXISTS `calificacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `calificacion` (
  `idcalificacion` int(11) NOT NULL AUTO_INCREMENT,
  `fechaHora` date NOT NULL,
  `puntuacion` int(11) NOT NULL,
  `idcliente` int(11) DEFAULT NULL,
  `idventa` int(11) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  PRIMARY KEY (`idcalificacion`),
  KEY `fk_calificacion_cliente1_idx` (`idcliente`),
  KEY `fk_calificacion_venta1_idx` (`idventa`),
  CONSTRAINT `fk_calificacion_cliente1` FOREIGN KEY (`idcliente`) REFERENCES `cliente` (`idcliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_calificacion_venta1` FOREIGN KEY (`idventa`) REFERENCES `venta` (`idventa`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6231 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calificacion`
--

LOCK TABLES `calificacion` WRITE;
/*!40000 ALTER TABLE `calificacion` DISABLE KEYS */;
INSERT INTO `calificacion` VALUES (6222,'2021-01-01',4,2,102,NULL),(6223,'2021-01-02',5,3,103,NULL),(6224,'2022-01-22',4,4,104,NULL),(6227,'2022-02-04',5,7,107,NULL);
/*!40000 ALTER TABLE `calificacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `idcliente` int(11) NOT NULL AUTO_INCREMENT,
  `edad` int(11) NOT NULL,
  `idusuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`idcliente`),
  KEY `fk_cliente_usuario1_idx` (`idusuario`),
  CONSTRAINT `fk_cliente_usuario1` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=252537 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (0,18,2121),(1,19,2122),(2,22,2123),(3,30,2124),(4,42,2125),(5,25,2126),(7,43,2128),(8,24,2129),(252535,18,NULL),(252536,25,NULL);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `copiausuario`
--

DROP TABLE IF EXISTS `copiausuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `copiausuario` (
  `idCopiaUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `primer_nombre` varchar(45) NOT NULL,
  `segundo_nombre` varchar(45) NOT NULL,
  `primer_apellidos` varchar(45) NOT NULL,
  `segundo_apellido` varchar(45) NOT NULL,
  `tipodocumento` varchar(45) NOT NULL,
  `noIdentificacion` varchar(45) NOT NULL,
  `telefono` int(11) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  PRIMARY KEY (`idCopiaUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `copiausuario`
--

LOCK TABLES `copiausuario` WRITE;
/*!40000 ALTER TABLE `copiausuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `copiausuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cotizacion`
--

DROP TABLE IF EXISTS `cotizacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cotizacion` (
  `idcotizacion` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `total` double NOT NULL,
  `idproducto` int(11) DEFAULT NULL,
  `idadministrador` int(11) DEFAULT NULL,
  `idcliente` int(11) DEFAULT NULL,
  PRIMARY KEY (`idcotizacion`),
  KEY `fk_cotizacion_producto1_idx` (`idproducto`),
  KEY `fk_cotizacion_administrador1_idx` (`idadministrador`),
  KEY `fk_cotizacion_cliente1_idx` (`idcliente`),
  CONSTRAINT `fk_cotizacion_administrador1` FOREIGN KEY (`idadministrador`) REFERENCES `administrador` (`idadministrador`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cotizacion_cliente1` FOREIGN KEY (`idcliente`) REFERENCES `cliente` (`idcliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cotizacion_producto1` FOREIGN KEY (`idproducto`) REFERENCES `producto` (`idproducto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1003 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cotizacion`
--

LOCK TABLES `cotizacion` WRITE;
/*!40000 ALTER TABLE `cotizacion` DISABLE KEYS */;
INSERT INTO `cotizacion` VALUES (981,'2022-03-28',5000,123,1212,0),(984,'2022-05-23',12300,126,1215,0),(985,'2022-05-08',23700,127,1216,0),(987,'2022-06-15',6700,129,1218,0),(996,'2013-03-02',1220,NULL,NULL,NULL),(997,'2022-09-28',12330,NULL,NULL,NULL),(999,'2022-09-20',8000,NULL,NULL,NULL),(1001,'2022-09-12',2210,NULL,NULL,NULL);
/*!40000 ALTER TABLE `cotizacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `forma_de_pago`
--

DROP TABLE IF EXISTS `forma_de_pago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `forma_de_pago` (
  `idforma_de_pago` int(11) NOT NULL AUTO_INCREMENT,
  `forma_de_pago` varchar(45) NOT NULL,
  `pedido_idpedido` int(11) DEFAULT NULL,
  PRIMARY KEY (`idforma_de_pago`)
) ENGINE=InnoDB AUTO_INCREMENT=919 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `forma_de_pago`
--

LOCK TABLES `forma_de_pago` WRITE;
/*!40000 ALTER TABLE `forma_de_pago` DISABLE KEYS */;
INSERT INTO `forma_de_pago` VALUES (909,'EFECTIVO',NULL),(911,'NEQUI',NULL),(912,'EFECTIVO',NULL),(913,'DAVIPLATA',NULL),(915,'NEQUI',NULL),(917,'EFECTIVO',NULL);
/*!40000 ALTER TABLE `forma_de_pago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventario`
--

DROP TABLE IF EXISTS `inventario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inventario` (
  `idinventario` int(11) NOT NULL AUTO_INCREMENT,
  `categoria` varchar(45) NOT NULL,
  `entradas` int(11) NOT NULL,
  `salidas` int(11) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `idproducto` int(11) DEFAULT NULL,
  PRIMARY KEY (`idinventario`),
  KEY `fk_inventario_producto1_idx` (`idproducto`),
  CONSTRAINT `fk_inventario_producto1` FOREIGN KEY (`idproducto`) REFERENCES `producto` (`idproducto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventario`
--

LOCK TABLES `inventario` WRITE;
/*!40000 ALTER TABLE `inventario` DISABLE KEYS */;
INSERT INTO `inventario` VALUES (20,'DULCERIA',22,11,'CUADERNOS',123),(21,'PAPELERIA',32,34,'LAPICES',124),(22,'DULCERIA',12,32,'GOMAS',125),(23,'PAPELERIA',22,54,'ESFEROS',126),(24,'DULCERIA',16,42,'DULCES',127),(25,'BISUTERIA',20,45,'ARETES',128),(26,'PAPELERIA',40,21,'AGENDAS',129),(27,'BISUTERIA',32,15,'LAPIZ E OJOS',130),(28,'BISUTERIA',33,16,'LABIAL',131);
/*!40000 ALTER TABLE `inventario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login` (
  `idlogin` int(11) NOT NULL AUTO_INCREMENT,
  `correo` varchar(45) NOT NULL,
  `contraseña` varchar(45) NOT NULL,
  PRIMARY KEY (`idlogin`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (1,'greet654@gmail.com','2345'),(2,'julio433@gmail.com','23423'),(3,'',''),(4,'',''),(5,'',''),(6,'',''),(7,'',''),(8,'',''),(9,'','');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedido` (
  `idpedido` int(11) NOT NULL AUTO_INCREMENT,
  `cantidad` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `descuento` double NOT NULL,
  `idcliente` int(11) DEFAULT NULL,
  `idseguimiento_envio` int(11) DEFAULT NULL,
  `idforma_de_pago` int(11) DEFAULT NULL,
  PRIMARY KEY (`idpedido`),
  KEY `fk_pedido_cliente1_idx` (`idcliente`),
  KEY `fk_pedido_seguimiento_envio1_idx` (`idseguimiento_envio`),
  KEY `fk_pedido_forma_de_pago1_idx` (`idforma_de_pago`),
  CONSTRAINT `fk_pedido_cliente1` FOREIGN KEY (`idcliente`) REFERENCES `cliente` (`idcliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_pedido_forma_de_pago1` FOREIGN KEY (`idforma_de_pago`) REFERENCES `forma_de_pago` (`idforma_de_pago`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_pedido_seguimiento_envio1` FOREIGN KEY (`idseguimiento_envio`) REFERENCES `seguimiento_envio` (`idseguimiento_envio`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4457 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
INSERT INTO `pedido` VALUES (4445,10,'2020-02-25','CARRERA 12',0,0,3435,909),(4448,34,'2020-01-14','AVENIDA 65',30,2,3438,912);
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido_has_producto`
--

DROP TABLE IF EXISTS `pedido_has_producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedido_has_producto` (
  `idpedido` int(11) NOT NULL,
  `idproducto` int(11) NOT NULL,
  PRIMARY KEY (`idpedido`,`idproducto`),
  KEY `fk_pedido_has_producto_producto1_idx` (`idproducto`),
  KEY `fk_pedido_has_producto_pedido1_idx` (`idpedido`),
  CONSTRAINT `fk_pedido_has_producto_pedido1` FOREIGN KEY (`idpedido`) REFERENCES `pedido` (`idpedido`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_pedido_has_producto_producto1` FOREIGN KEY (`idproducto`) REFERENCES `producto` (`idproducto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido_has_producto`
--

LOCK TABLES `pedido_has_producto` WRITE;
/*!40000 ALTER TABLE `pedido_has_producto` DISABLE KEYS */;
/*!40000 ALTER TABLE `pedido_has_producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permisos`
--

DROP TABLE IF EXISTS `permisos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permisos` (
  `idpermisos` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`idpermisos`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permisos`
--

LOCK TABLES `permisos` WRITE;
/*!40000 ALTER TABLE `permisos` DISABLE KEYS */;
INSERT INTO `permisos` VALUES (3,'gAKAFD'),(5,'uuu564');
/*!40000 ALTER TABLE `permisos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pqrs`
--

DROP TABLE IF EXISTS `pqrs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pqrs` (
  `idpqrs` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(45) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `fecha` date NOT NULL,
  `idrespuesta` int(11) DEFAULT NULL,
  `idcliente` int(11) DEFAULT NULL,
  PRIMARY KEY (`idpqrs`),
  KEY `fk_pqrs_respuesta1_idx` (`idrespuesta`),
  KEY `fk_pqrs_cliente1_idx` (`idcliente`),
  CONSTRAINT `fk_pqrs_cliente1` FOREIGN KEY (`idcliente`) REFERENCES `cliente` (`idcliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_pqrs_respuesta1` FOREIGN KEY (`idrespuesta`) REFERENCES `respuesta` (`idrespuesta`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=797 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pqrs`
--

LOCK TABLES `pqrs` WRITE;
/*!40000 ALTER TABLE `pqrs` DISABLE KEYS */;
INSERT INTO `pqrs` VALUES (777,'Reclamo','Pedido incompleto','2020-05-16',76,0),(778,'SUGERENCIA','mejora','2022-03-01',77,1),(784,'SUGERENCIA','mejora de precios','2022-08-09',83,7);
/*!40000 ALTER TABLE `pqrs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producto` (
  `idproducto` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `categoria` varchar(45) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `estado` varchar(45) NOT NULL,
  `precio` double NOT NULL,
  `idproveedor` int(11) DEFAULT NULL,
  PRIMARY KEY (`idproducto`),
  KEY `fk_producto_proveedor1_idx` (`idproveedor`),
  CONSTRAINT `fk_producto_proveedor1` FOREIGN KEY (`idproveedor`) REFERENCES `proveedor` (`idproveedor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=144 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (123,'PAPEL','PAPELERIA',11,'HABILITADO',500,1),(124,'LAPICES','PAPELERIA',20,'HABILITADO',900,2),(125,'ESFEROS','PAPELERIA',30,'HABILITADO',1200,3),(126,'LABIAL','BISUTERIA',15,'DESABILITADO',4000,4),(127,'LAPIZ DE OJOS','BISUTERIA',20,'HABILITADO',10000,5),(128,'GOMAS','DULCERIA',30,'HABILITADO',2000,6),(129,'DULCES','DULCERIA',30,'DESABILITADO',300,7),(130,'AGENDAS','PAPELERIA',20,'DESABILITADO',7000,8),(131,'ARETES','BISUTERIA',17,'HABILITADO',4000,9);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proveedor` (
  `idproveedor` int(11) NOT NULL AUTO_INCREMENT,
  `RUT` int(11) NOT NULL,
  `primer_nombre` varchar(45) NOT NULL,
  `segundo_nombre` varchar(45) NOT NULL,
  `primer_apellido` varchar(45) NOT NULL,
  `segundo_apellido` varchar(45) NOT NULL,
  `telefono` int(11) NOT NULL,
  PRIMARY KEY (`idproveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor`
--

LOCK TABLES `proveedor` WRITE;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
INSERT INTO `proveedor` VALUES (1,345354,'JOSE','ALVERTO','MORA','DUARTE',7656865),(2,345435,'MARIA','LUCIA','HUERTAS','CARO',7656866),(3,3423,'MARTIN','FELIPE','BORQUEZ','SANCHEZ',7656867),(4,7566,'HOLLMAN','STIVEN','AGUIRRE','MAECHA',7656868),(5,567657,'GISELL','SOFIA','VERGARA','HERRERA',7656869),(6,67655,'ANDRES','FELIPE','HERNANDEZ','PEREZ',7656870),(7,65768,'JULIANA','','ROJAS','VANEGAS',7656871),(8,4564,'CAMILA','ANDREA','RODRIGUEZ','VERA',7656872),(9,63848,'GERALDINE','','ALAYON','ARIAS',7645839);
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `respuesta`
--

DROP TABLE IF EXISTS `respuesta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `respuesta` (
  `idrespuesta` int(11) NOT NULL AUTO_INCREMENT,
  `respuesta` varchar(45) NOT NULL,
  `idadministrador` int(11) DEFAULT NULL,
  PRIMARY KEY (`idrespuesta`),
  KEY `fk_respuesta_administrador1_idx` (`idadministrador`),
  CONSTRAINT `fk_respuesta_administrador1` FOREIGN KEY (`idadministrador`) REFERENCES `administrador` (`idadministrador`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `respuesta`
--

LOCK TABLES `respuesta` WRITE;
/*!40000 ALTER TABLE `respuesta` DISABLE KEYS */;
INSERT INTO `respuesta` VALUES (76,'LO SOLUCIONAREMOS',1212),(77,'GRACIAS POR TU OPINION',1213),(78,'NO TE PREOCUPES',1215),(79,'ES IMPORTANTE QUE..',1214),(80,'NO ES CLARO LA CONSULTA',1216),(81,'ESTAMOS PARA AYUDARTE',1217),(82,'GRACIAS POR COMPARTIR',1218),(83,'ESTAMOS SIEMPRE MUY AGRADECIDOS',1219),(84,'MUCHAS GRACIAS 33',1220),(85,'asfdasdf',NULL);
/*!40000 ALTER TABLE `respuesta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rol` (
  `idrol` int(11) NOT NULL AUTO_INCREMENT,
  `ROL` varchar(45) NOT NULL,
  `idusuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`idrol`),
  KEY `fk_rol_usuario1_idx` (`idusuario`),
  CONSTRAINT `fk_rol_usuario1` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=561 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (555,'Usuario',2121),(556,'Administrador',2122),(558,'Administrador',2124),(559,'Usuario',2125),(560,'Usuario',2126);
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol_has_permisos`
--

DROP TABLE IF EXISTS `rol_has_permisos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rol_has_permisos` (
  `idrol` int(11) NOT NULL,
  `idpermisos` int(11) NOT NULL,
  PRIMARY KEY (`idrol`,`idpermisos`),
  KEY `fk_rol_has_permisos_permisos1_idx` (`idpermisos`),
  KEY `fk_rol_has_permisos_rol_idx` (`idrol`),
  CONSTRAINT `fk_rol_has_permisos_permisos1` FOREIGN KEY (`idpermisos`) REFERENCES `permisos` (`idpermisos`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_rol_has_permisos_rol` FOREIGN KEY (`idrol`) REFERENCES `rol` (`idrol`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol_has_permisos`
--

LOCK TABLES `rol_has_permisos` WRITE;
/*!40000 ALTER TABLE `rol_has_permisos` DISABLE KEYS */;
/*!40000 ALTER TABLE `rol_has_permisos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seguimiento_envio`
--

DROP TABLE IF EXISTS `seguimiento_envio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seguimiento_envio` (
  `idseguimiento_envio` int(11) NOT NULL AUTO_INCREMENT,
  `referenciaenvio` int(11) NOT NULL,
  `fechainicio` date NOT NULL,
  `fechafin` date NOT NULL,
  `destino` varchar(45) NOT NULL,
  PRIMARY KEY (`idseguimiento_envio`)
) ENGINE=InnoDB AUTO_INCREMENT=3449 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seguimiento_envio`
--

LOCK TABLES `seguimiento_envio` WRITE;
/*!40000 ALTER TABLE `seguimiento_envio` DISABLE KEYS */;
INSERT INTO `seguimiento_envio` VALUES (3435,9080745,'2022-01-12','2022-01-13','CALLE 32'),(3437,9080543,'2022-01-20','2022-01-21','CARRERA 65'),(3438,9080865,'2022-01-22','2022-01-23','AVENIDA 23'),(3439,9080985,'2022-01-30','2022-01-31','CARRERA 87'),(3440,9080098,'2022-02-02','2022-02-03','CALLE 44'),(3441,9080234,'2022-02-05','2022-02-07','CARRERA 90'),(3442,90807542,'2022-01-11','2022-01-13','AVENIDA 78'),(3445,23412341,'2020-01-03','2020-01-14','Bogota calle 33');
/*!40000 ALTER TABLE `seguimiento_envio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `idusuario` int(11) NOT NULL AUTO_INCREMENT,
  `primer_nombre` varchar(45) NOT NULL,
  `segundo_nombre` varchar(45) NOT NULL,
  `primer_apellidos` varchar(45) NOT NULL,
  `segundo_apellido` varchar(45) NOT NULL,
  `tipoIdentificacion` varchar(45) NOT NULL,
  `noIdentificacion` int(11) NOT NULL,
  `telefono` int(11) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `rol` varchar(45) NOT NULL,
  `idlogin` int(11) DEFAULT NULL,
  PRIMARY KEY (`idusuario`),
  KEY `fk_usuario_login1_idx` (`idlogin`)
) ENGINE=InnoDB AUTO_INCREMENT=2135 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (2121,'JULIO','CESAR','GUTIERREZ','MORFIN','C.C',1001356567,7656861,'CARRERA 58','',0),(2122,'JOSE','VICENTE','BELTRAN','VILVADO','C.C',1001876342,7656862,'CARRERA 58','',1),(2123,'HECTOR','FEDERICO','ARDILA','GUAJARDO','C.C',1001356634,7656863,'CARRERA 58','',2),(2124,'JOSE','DE JESUS','NUÑES','YANOME','C.C',1001356980,7656864,'CARRERA 58','',3),(2125,'DIEGO','ELIZABEHT','MARTINEZ','BELTRAN','C.C',1001356098,7656865,'CARRERA 58','',4),(2126,'JESUS','CARLOS','GONZALEZ','DIAZ','C.C',1001356123,7656866,'CARRERA 58','',5),(2127,'JOSE','AMBROSIO','GARCIA','DUARTE','C.C',1001356124,7656867,'CARRERA 58','',6),(2128,'ROSA','ELENA','MARQUEZ','VERDIAZ','C.C',1001356125,7656868,'CARRERA 58','',7),(2129,'CLAUDIA','VALERIA','LOPEZ','MONTERO','C.C',1001356126,7656869,'CARRERA 58','',8);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venta`
--

DROP TABLE IF EXISTS `venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `venta` (
  `idventa` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `cantidad` int(11) NOT NULL,
  `detalle` varchar(45) NOT NULL,
  `total` double NOT NULL,
  PRIMARY KEY (`idventa`)
) ENGINE=InnoDB AUTO_INCREMENT=115 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta`
--

LOCK TABLES `venta` WRITE;
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
INSERT INTO `venta` VALUES (100,'2022-05-12',12,'PAPELERIA',54000),(101,'2022-05-13',3,'DULCERIA',2000),(102,'2022-05-14',8,'LAPICES',6400),(103,'2022-05-15',13,'PAPELERIA',25000),(104,'2022-05-16',19,'ESFEROS',22800),(105,'2022-05-17',20,'CUADERNOS',50000),(106,'2022-05-18',6,'ARETES',24000),(107,'2022-05-19',7,'LABIAL',28000);
/*!40000 ALTER TABLE `venta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-25 21:53:24
