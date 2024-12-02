package br.grupointegrado.estudos.controller;

import br.grupointegrado.estudos.dto.AlunoRequestDTO;
import br.grupointegrado.estudos.model.Aluno;
import br.grupointegrado.estudos.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Alunos")


public class AlunoController {

    @Autowired
    private AlunoRepository repository;

    @GetMapping
    public List<Aluno> findALL(){
        return this.repository.findAll();
    }

    @GetMapping("/{id}")
    public Aluno findById(@PathVariable Integer id) {
        return this.repository.findById(id)
         .orElseThrow(()->new IllegalArgumentException("Aluno não registrado"));
    }

    @PostMapping
    public Aluno save(@RequestBody AlunoRequestDTO dto) {
        Aluno aluno = new Aluno();
        aluno.setNome(dto.nome());
        aluno.setEmail(dto.email());
        aluno.setMatricula(dto.matricula());
        return this.repository.save(aluno);
    }
    }

