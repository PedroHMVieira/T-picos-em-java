package br.grupointegrado.estudos.controller;

import br.grupointegrado.estudos.dto.DisciplinaRequestDTO;
import br.grupointegrado.estudos.model.Curso;
import br.grupointegrado.estudos.model.Disciplina;
import br.grupointegrado.estudos.model.Professor;
import br.grupointegrado.estudos.repository.CursoRepository;
import br.grupointegrado.estudos.repository.DisciplinaRepository;
import br.grupointegrado.estudos.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/disciplinas")


public class DisciplinaController {

  @Autowired
  private DisciplinaRepository repository;

  @Autowired
  private CursoRepository cursoRepository;

    @Autowired
    private ProfessorRepository professorRepository;

  @GetMapping
  public ResponseEntity<List<Disciplina>> findALL(){
      return ResponseEntity.ok(this.repository.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Disciplina> findById(@PathVariable Integer id) {
      Disciplina disciplina = this.repository.findById(id)
              .orElseThrow(()->new IllegalArgumentException("Disciplina não registrada"));

      return ResponseEntity.ok(disciplina);
  }

@PostMapping
  public Disciplina save(@RequestBody DisciplinaRequestDTO dto) {
      Disciplina disciplina = new Disciplina();
      disciplina.setNome(dto.nome());
      disciplina.setCodigo(dto.codigo());

    Curso curso = this.cursoRepository.findById(dto.curso_id())
            .orElseThrow(()->new IllegalArgumentException("Curso não registrado"));
    disciplina.setCurso(curso);

    Professor professor = this.professorRepository.findById(dto.professor_id())
            .orElseThrow(()->new IllegalArgumentException("Professor não registrado"));
    disciplina.setProfessor(professor);

    return this.repository.save(disciplina);
  }

  @PutMapping("/{id}")
  public Disciplina update(@PathVariable Integer id,
                      @RequestBody DisciplinaRequestDTO dto) {
      Disciplina disciplina = this.repository.findById(id)
              .orElseThrow(()->new IllegalArgumentException("Disciplina não registrada"));
      disciplina.setNome(dto.nome());
      disciplina.setCodigo(dto.codigo());

      Curso curso = this.cursoRepository.findById(dto.curso_id())
              .orElseThrow(()->new IllegalArgumentException("Curso não registrado"));
      disciplina.setCurso(curso);

      Professor professor = this.professorRepository.findById(dto.professor_id())
              .orElseThrow(()->new IllegalArgumentException("Professor não registrado"));
      disciplina.setProfessor(professor);

      return this.repository.save(disciplina);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Integer id){
      Disciplina disciplina = this.repository.findById(id)
              .orElseThrow(()->new IllegalArgumentException("Disciplina não registrada"));
      this.repository.delete(disciplina);

      return ResponseEntity.noContent().build();
  }


}

