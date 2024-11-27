CREATE TABLE Matriculas (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    aluno_id INT NOT NULL,
    turma_id INT NOT NULL,
    FOREIGN KEY (aluno_id) REFERENCES Alunos(ID) ON DELETE CASCADE,
    FOREIGN KEY (turma_id) REFERENCES Turmas(ID) ON DELETE CASCADE,
    UNIQUE (aluno_id, turma_id)
);
