DROP DATABASE IF EXISTS 'encuestas';
CREATE DATABASE 'encuestas';
USE 'encuestas';

create table encuestas.creador
(
    Nombre_Usuario varchar(45)      not null,
    Correo         varchar(45)      null,
    Contrasenya    varchar(16)      null,
    Saldo          double default 0 null,
    constraint Nombre_Usuario_UNIQUE
        unique (Nombre_Usuario)
);

alter table encuestas.creador
    add primary key (Nombre_Usuario);

create table encuestas.encuestas
(
    ID_Encuesta      int auto_increment
        primary key,
    Titulo           varchar(45) null,
    Numero_Preguntas int         null,
    Remuneracion     double      null,
    Nombre_Usuario   varchar(45) null,
    constraint encuestas_creador_Nombre_Usuario_fk
        foreign key (Nombre_Usuario) references encuestas.creador (Nombre_Usuario)
);

create table encuestas.pregunta
(
    ID_Pregunta int auto_increment
        primary key,
    Texto       varchar(200) null,
    ID_Encuesta int          null,
    constraint pregunta_encuestas_ID_Encuesta_fk
        foreign key (ID_Encuesta) references encuestas.encuestas (ID_Encuesta)
);

create table encuestas.respuesta
(
    ID_Respuesta int auto_increment
        primary key,
    ID_Pregunta  int          null,
    Texto        varchar(200) null,
    constraint respuesta_pregunta_ID_Pregunta_fk
        foreign key (ID_Pregunta) references encuestas.pregunta (ID_Pregunta)
);

create table encuestas.`respuesta-usuario`
(
    ID_Pregunta    int         null,
    Nombre_Usuario varchar(45) null,
    ID_Respuesta   int         null,
    constraint `respuesta-usuario_pregunta_ID_Pregunta_fk`
        foreign key (ID_Pregunta) references encuestas.pregunta (ID_Pregunta),
    constraint `respuesta-usuario_respuesta_ID_Respuesta_fk`
        foreign key (ID_Respuesta) references encuestas.respuesta (ID_Respuesta)
);

create index `respuesta-pregunta_creador_Nombre_Usuario_fk`
    on encuestas.`respuesta-usuario` (Nombre_Usuario);


