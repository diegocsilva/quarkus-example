package br.com.softplan.model;

import br.com.softplan.domain.PeriodoEnum;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.AUTO;

@Entity
public class Turma extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Integer id;

    private Integer ano;

    private PeriodoEnum periodo;

    public Turma merge(Turma turma){
        if (!this.ano.equals(turma.getAno())){
            this.ano = turma.getAno();
        }
        if (!this.periodo.equals(turma.getPeriodo())){
            this.periodo = turma.periodo;
        }
        return this;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
