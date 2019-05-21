package br.com.softplan.springexample.repository;

import br.com.softplan.springexample.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

    public Aluno findByNome(String name);

    public Aluno findBySobrenome(String sobrenome);
}
