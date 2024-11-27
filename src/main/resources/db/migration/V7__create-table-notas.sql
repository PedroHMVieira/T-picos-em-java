CREATE TABLE Notas (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    matricula_id INT NOT NULL,
    disciplina_id INT NOT NULL,
    nota DECIMAL(5, 2) NOT NULL CHECK (nota >= 0 AND nota <= 10),
    data_lancamento DATE NOT NULL,
    FOREIGN KEY (matricula_id) REFERENCES Matriculas(ID) ON DELETE CASCADE,
    FOREIGN KEY (disciplina_id) REFERENCES Disciplinas(ID) ON DELETE CASCADE
);
