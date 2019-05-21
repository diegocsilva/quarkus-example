package br.com.softplan.springexample.model;


import br.com.softplan.springexample.domain.PeriodoEnum;

import javax.persistence.*;
import java.util.List;

@Entity
public class Turma {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer ano;
    private PeriodoEnum periodo;

    @ManyToOne
    private Escola escola;

    @OneToMany
    private List<Aluno> alunos;

    public Turma merge(Turma turma){
        if (!this.ano.equals(turma.getAno())){
            this.ano = turma.getAno();
        }
        if (!this.periodo.equals(turma.getPeriodo())){
            this.periodo = turma.periodo;
        }
        return this;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public PeriodoEnum getPeriodo() {
        return periodo;
    }

    public void setPeriodo(PeriodoEnum periodo) {
        this.periodo = periodo;
    }

    public Escola getEscola() {
        return escola;
    }

    public void setEscola(Escola escola) {
        this.escola = escola;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
}
