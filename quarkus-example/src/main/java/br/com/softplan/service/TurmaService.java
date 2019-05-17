package br.com.softplan.service;

import br.com.softplan.model.Turma;
import br.com.softplan.repository.TurmaRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.management.RuntimeOperationsException;
import java.util.List;

@RequestScoped
public class TurmaService {

    @Inject
    private TurmaRepository repository;

    public Turma getByName(String nome){
        return repository.findByNome(nome);
    }

    public List<Turma> list(){
        return repository.findAll().list();
    }

    public void create(Turma turma) {
        repository.persist(turma);
    }

    public Turma update(Turma turma) {
        if (turma.getId() == null){
            throw new RuntimeOperationsException(new RuntimeException(), "Turma ainda não presente no cadastro!");
        }
        Turma entity = repository.findById(turma.getId());
        turma = entity.merge(turma);
        repository.persist(entity);
        return turma;
    }

    public void delete(Turma turma) {
        repository.delete(turma);
    }
}
