package br.grupointegrado.estudos.repository;

import br.grupointegrado.estudos.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
}
