package br.grupointegrado.estudos.repository;
import br.grupointegrado.estudos.model.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Integer> {
}
