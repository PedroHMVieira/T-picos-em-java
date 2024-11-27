CREATE TABLE Disciplinas (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    codigo VARCHAR(20) NOT NULL UNIQUE,
    curso_id INT NOT NULL,
    professor_id INT,
    FOREIGN KEY (curso_id) REFERENCES Cursos(ID),
    FOREIGN KEY (professor_id) REFERENCES Professores(ID) ON DELETE SET NULL
);
