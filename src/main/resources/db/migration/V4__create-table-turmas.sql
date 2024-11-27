CREATE TABLE Turmas (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    ano INT NOT NULL,
    semestre INT NOT NULL CHECK (semestre IN (1, 2)),
    curso_id INT NOT NULL,
    FOREIGN KEY (curso_id) REFERENCES Cursos(ID) ON DELETE CASCADE
);
