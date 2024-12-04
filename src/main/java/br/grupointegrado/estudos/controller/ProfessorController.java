package br.grupointegrado.estudos.controller;

import br.grupointegrado.estudos.dto.ProfessorRequestDTO;
import br.grupointegrado.estudos.model.Disciplina;
import br.grupointegrado.estudos.model.Professor;
import br.grupointegrado.estudos.repository.DisciplinaRepository;
import br.grupointegrado.estudos.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professores")


public class ProfessorController {

    @Autowired
    private ProfessorRepository repository;

    private DisciplinaRepository disciplinaRepository;

    @GetMapping
    public ResponseEntity<List<Professor>> findALL(){
        return ResponseEntity.ok(this.repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professor> findById(@PathVariable Integer id) {
        Professor professor = this.repository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Professor não registrado"));

        return ResponseEntity.ok(professor);
    }

    @PostMapping
    public Professor save(@RequestBody ProfessorRequestDTO dto) {
        Professor professor = new Professor();
        professor.setNome(dto.nome());
        professor.setEmail(dto.email());
        professor.setEspecialidade(dto.especialidade());
        return this.repository.save(professor);
    }

    @PutMapping("/{id}")
    public Professor update(@PathVariable Integer id,
                        @RequestBody ProfessorRequestDTO dto) {
        Professor professor = this.repository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Professor não registrado"));
        professor.setNome(dto.nome());
        professor.setEmail(dto.email());
        professor.setEspecialidade(dto.especialidade());
        return this.repository.save(professor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        Professor professor = this.repository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Professor não registrado"));
        this.repository.delete(professor);

        return ResponseEntity.noContent().build();
    }

   @PostMapping("/{id}/add-disciplina")
   public ResponseEntity<Professor> addDisciplina(@PathVariable Integer id,
                                                   @RequestBody Disciplina disciplina){
       Professor professor = this.repository.findById(id)
               .orElseThrow(()->new IllegalArgumentException("Professor não registrado"));

       disciplina.setProfessor(professor);
       this.disciplinaRepository.save(disciplina);
       return ResponseEntity.ok(professor);
    }


}

