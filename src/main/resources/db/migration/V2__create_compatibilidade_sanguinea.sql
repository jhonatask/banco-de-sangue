CREATE TABLE compatibilidade_sanguinea
(
    id       BIGINT AUTO_INCREMENT NOT NULL,
    receptor VARCHAR(5) NOT NULL,
    doador   VARCHAR(5) NOT NULL,
    CONSTRAINT pk_compatibilidade PRIMARY KEY (id)
);

INSERT INTO compatibilidade_sanguinea (receptor, doador) VALUES
-- A+
('A+',  'A+'), ('A+',  'A-'), ('A+',  'O+'), ('A+',  'O-'),
-- A-
('A-',  'A-'), ('A-',  'O-'),
-- B+
('B+',  'B+'), ('B+',  'B-'), ('B+',  'O+'), ('B+',  'O-'),
-- B-
('B-',  'B-'), ('B-',  'O-'),
-- AB+
('AB+', 'A+'), ('AB+', 'A-'), ('AB+', 'B+'), ('AB+', 'B-'),
('AB+', 'O+'), ('AB+', 'O-'), ('AB+', 'AB+'), ('AB+', 'AB-'),
-- AB-
('AB-', 'A-'), ('AB-', 'B-'), ('AB-', 'O-'), ('AB-', 'AB-'),
-- O+
('O+',  'O+'), ('O+',  'O-'),
-- O-
('O-',  'O-');
