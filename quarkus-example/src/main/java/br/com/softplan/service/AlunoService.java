package br.com.softplan.service;

import br.com.softplan.model.Aluno;
import br.com.softplan.repository.AlunoRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class AlunoService {

    @Inject
    private AlunoRepository repository;

    public Aluno findByNome(String nome){
        return repository.findByNome(nome);
    }

    public void save(Aluno aluno) {
        repository.persist(aluno);
    }
}
