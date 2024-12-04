package br.grupointegrado.estudos.repository;

import br.grupointegrado.estudos.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Integer> {
}
