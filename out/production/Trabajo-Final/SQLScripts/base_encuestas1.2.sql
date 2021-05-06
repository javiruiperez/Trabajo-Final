DROP DATABASE IF EXISTS encuestas;
CREATE DATABASE encuestas;
USE encuestas;

CREATE TABLE `creador` (
  `Nombre_Usuario` varchar(45) NOT NULL,
  `Correo` varchar(45) DEFAULT NULL,
  `Contrasenya` int DEFAULT NULL,
  `Saldo` int DEFAULT '0',
  PRIMARY KEY (`Nombre_Usuario`),
  UNIQUE KEY `Nombre_Usuario_UNIQUE` (`Nombre_Usuario`),
  UNIQUE KEY `Correo_UNIQUE` (`Correo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `encuestas` (
  `ID_Encuesta` int NOT NULL,
  `Titulo` varchar(45) DEFAULT NULL,
  `Numero_Preguntas` int DEFAULT NULL,
  `Remuneracion` double DEFAULT NULL,
  `ID_Usuario` int DEFAULT NULL,
  PRIMARY KEY (`ID_Encuesta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `pregunta` (
  `ID_Pregunta` int NOT NULL,
  `Nombre` varchar(45) DEFAULT NULL,
  `ID_Encuesta` int DEFAULT NULL,
  PRIMARY KEY (`ID_Pregunta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `respuesta` (
  `ID_Respuesta` int NOT NULL,
  `ID_Encuesta` int DEFAULT NULL,
  `ID_Usuario` int DEFAULT NULL,
  ''
  PRIMARY KEY (`ID_Respuesta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `respuesta-pregunta` (
  `ID_Pregunta` int DEFAULT NULL,
  `Respuesta` varchar(45) DEFAULT NULL,
  `ID_Respuesta` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
