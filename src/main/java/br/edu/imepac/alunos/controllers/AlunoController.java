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
        return alunoRepository.save(aluno);
    }

    @GetMapping
    public Aluno getAluno(@RequestBody Long id){
        Optional<Aluno> temp = alunoRepository.findById(id);
        return temp.get();
    }
}
