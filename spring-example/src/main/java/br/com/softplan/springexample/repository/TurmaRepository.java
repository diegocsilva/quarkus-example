package br.com.softplan.springexample.repository;

import br.com.softplan.springexample.model.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Integer> {

    public Turma findByAno(Integer ano);
}
