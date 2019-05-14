package br.com.softplan.repository;

import br.com.softplan.model.Aluno;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class AlunoRepository implements PanacheRepository<Aluno> {

    public Aluno findByNome(String name){
        return  find("name", name).firstResult();
    }

    public Aluno findBySobrenome(String sobrenome){
        return  find("sobrenome", sobrenome).firstResult();
    }
}
