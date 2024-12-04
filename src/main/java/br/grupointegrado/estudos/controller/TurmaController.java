package br.grupointegrado.estudos.controller;


import br.grupointegrado.estudos.dto.TurmaRequestDTO;
import br.grupointegrado.estudos.model.Curso;
import br.grupointegrado.estudos.model.Turma;
import br.grupointegrado.estudos.repository.CursoRepository;
import br.grupointegrado.estudos.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/Turma")


public class TurmaController {

    @Autowired
    private TurmaRepository repository;

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping
    public ResponseEntity<List<Turma>> findALL(){
        return ResponseEntity.ok(this.repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turma> findById(@PathVariable Integer id) {
        Turma turma = this.repository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Turma não registrada"));

        return ResponseEntity.ok(turma);
    }

    @PostMapping
    public Turma save(@RequestBody TurmaRequestDTO dto) {
        Turma turma = new Turma();
        turma.setAno(dto.ano());
        turma.setSemestre(dto.semestre());

        Curso curso = this.cursoRepository.findById(dto.curso_id())
                .orElseThrow(()->new IllegalArgumentException("Curso não registrado"));
        turma.setCurso(curso);

        return this.repository.save(turma);
    }

    @PutMapping("/{id}")
    public Turma update(@PathVariable Integer id,
                        @RequestBody TurmaRequestDTO dto) {
        Turma turma = this.repository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Aluno não registrado"));
        turma.setAno(dto.ano());
        turma.setSemestre(dto.semestre());

        Curso curso = this.cursoRepository.findById(dto.curso_id())
                .orElseThrow(()->new IllegalArgumentException("Curso não registrado"));
        turma.setCurso(curso);
        return this.repository.save(turma);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        Turma curso = this.repository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Curso não registrado"));
        this.repository.delete(curso);

        return ResponseEntity.noContent().build();
    }


}

