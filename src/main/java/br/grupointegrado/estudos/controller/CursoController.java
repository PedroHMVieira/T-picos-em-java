package br.grupointegrado.estudos.controller;
import br.grupointegrado.estudos.dto.CursoRequestDTO;
import br.grupointegrado.estudos.model.Curso;
import br.grupointegrado.estudos.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Cursos")


public class CursoController {

    @Autowired
    private CursoRepository repository;

    @GetMapping
    public ResponseEntity<List<Curso>> findALL(){
        return ResponseEntity.ok(this.repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> findById(@PathVariable Integer id) {
        Curso curso = this.repository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Curso não registrado"));

        return ResponseEntity.ok(curso);
    }

    @PostMapping
    public Curso save(@RequestBody CursoRequestDTO dto) {
        Curso curso = new Curso();
        curso.setNome(dto.nome());
        curso.setCodigo(dto.codigo());
        curso.setCarga_horaria(dto.carga_horaria());
        return this.repository.save(curso);
    }

    @PutMapping("/{id}")
    public Curso update(@PathVariable Integer id,
                             @RequestBody CursoRequestDTO dto) {
        Curso curso = this.repository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Curso não registrado"));
        curso.setNome(dto.nome());
        curso.setCodigo(dto.codigo());
        curso.setCarga_horaria(dto.carga_horaria());
        return this.repository.save(curso);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        Curso curso = this.repository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Curso não registrado"));
        this.repository.delete(curso);

        return ResponseEntity.noContent().build();
    }


}

