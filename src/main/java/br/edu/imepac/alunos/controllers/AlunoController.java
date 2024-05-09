package br.edu.imepac.alunos.controllers;

import br.edu.imepac.alunos.model.Aluno;
import br.edu.imepac.alunos.repositories.AlunoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("alunos")
public class AlunoController {
    AlunoRepository alunoRepository;

    public AlunoController(AlunoRepository alunoRepository){
        this.alunoRepository = alunoRepository;
    }
    @PostMapping
    public Aluno addStudent(@RequestBody Aluno aluno){
        return this.alunoRepository.save(aluno);
    }

    @GetMapping("{id}")
    public Aluno getAluno(@PathVariable Long id){
        return this.alunoRepository.findById(id).get();
    }
}
