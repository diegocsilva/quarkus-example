package br.com.softplan.springexample.service;

import br.com.softplan.springexample.model.Turma;
import br.com.softplan.springexample.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.RuntimeOperationsException;
import java.util.List;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository repository;

    public List<Turma> list(){
        return repository.findAll();
    }

    public void create(Turma turma) {
        repository.save(turma);
    }

    public Turma update(Turma turma) {
        if (turma.getId() == null){
            throw new RuntimeOperationsException(new RuntimeException(), "Turma ainda não presente no cadastro!");
        }
        Turma entity = repository.findById(turma.getId()).get();
        turma = entity.merge(turma);
        repository.save(entity);
        return turma;
    }

    public void delete(Turma turma) {
        repository.delete(turma);
    }
}
