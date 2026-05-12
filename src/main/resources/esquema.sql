CREATE TABLE Sectores (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(30) NOT NULL,
    padre_id BIGINT, 
    FOREIGN KEY (padre_id) REFERENCES Sectores(id)
);

CREATE TABLE Salas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(30) NOT NULL,
    capacidad INT NOT NULL,
    precio_hora DECIMAL(10,2) NOT NULL,
    sector_id BIGINT NOT NULL,
    FOREIGN KEY (sector_id) REFERENCES Sectores(id)
);

CREATE TABLE Membresias (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(30) NOT NULL,
    precioMensual DECIMAL(10,2) NOT NULL,
    porcentajeDescuento DECIMAL(5,2) NOT NULL,
    limiteHorasMensuales INT NOT NULL,
    permiteAuditorios BOOLEAN NOT NULL,
    FOREIGN KEY (membresia_id) REFERENCES Membresias(id)
);

CREATE TABLE Socios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(30) NOT NULL,
    email VARCHAR(30) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    fecha_alta DATE NOT NULL,
    activo BOOLEAN NOT NULL,
    membresia_id BIGINT NOT NULL, 
    FOREIGN KEY (membresia_id) REFERENCES Membresias(id)
);

CREATE TABLE Reservas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    socio_id BIGINT NOT NULL, 
    sala_id BIGINT NOT NULL,  
    fecha DATE NOT NULL,
    hora_inicio TIME NOT NULL,
    hora_fin TIME NOT NULL,
    FOREIGN KEY (socio_id) REFERENCES Socios(id),
    FOREIGN KEY (sala_id) REFERENCES Salas(id)
);