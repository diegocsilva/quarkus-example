package br.com.softplan.service;

import br.com.softplan.model.Aluno;
import br.com.softplan.model.Turma;
import br.com.softplan.repository.AlunoRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.management.RuntimeOperationsException;
import java.util.List;

@RequestScoped
public class AlunoService {

    @Inject
    private AlunoRepository repository;

    @Inject
    private TurmaService turmaService;

    public Aluno getByName(String nome){
        return repository.findByNome(nome);
    }

    public List<Aluno> list(){
        return repository.findAll().list();
    }

    public void create(Aluno aluno) {
        repository.persist(aluno);
    }

    public void update(Aluno aluno) {
        if (aluno.getId() == null){
            throw new RuntimeOperationsException(new RuntimeException(), "Aluno ainda não presente no cadastro!");
        }
        Aluno entity = repository.findById(aluno.getId());
        Turma turma = turmaService.update(aluno.getTurma());
        entity.setTurma(turma);
        entity.merge(aluno);
        repository.persist(entity);
    }

    public void delete(Integer id) {
        Aluno entity = repository.findById(id);
        repository.delete(entity);
    }
}
