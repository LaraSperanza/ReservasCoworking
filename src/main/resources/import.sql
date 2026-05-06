-- Jerarquia de Sectores y Salas.
-- Edificio (ID 1, padre NULL)
INSERT INTO Sectores (nombre, padre_id) VALUES ('Edificio Central', NULL);
-- Piso 1 (ID 2, hijo de ID 1)
INSERT INTO Sectores (nombre, padre_id) VALUES ('Piso 1', 1);
-- Piso 2 (ID 3, hijo de ID 1)
INSERT INTO Sectores (nombre, padre_id) VALUES ('Piso 2', 1);
-- Ala Norte (ID 4, hijo de ID 2)
-- Ala Sur (ID 5, hijo de ID 2)
INSERT INTO Sectores (nombre, padre_id) VALUES ('Ala Norte', 2);
INSERT INTO Sectores (nombre, padre_id) VALUES ('Ala Sur', 2);
-- Ala Norte (ID 6, hijo de ID 3)
-- Ala Sur (ID 7, hijo de ID 3)
INSERT INTO Sectores (nombre, padre_id) VALUES ('Ala Norte', 3);
INSERT INTO Sectores (nombre, padre_id) VALUES ('Ala Sur', 3);
-- Salas (Asociadas al Piso 1)
INSERT INTO Salas (nombre, capacidad, precio_hora, sector_id) VALUES ('Sala de Reuniones A', 4, 1500.00, 4);
INSERT INTO Salas (nombre, capacidad, precio_hora, sector_id) VALUES ('Auditorio Principal', 50, 5000.00, 5);
