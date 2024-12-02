package br.grupointegrado.estudos.repository;
import br.grupointegrado.estudos.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
}
