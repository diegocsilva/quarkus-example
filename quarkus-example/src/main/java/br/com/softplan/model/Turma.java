package br.com.softplan.model;

import br.com.softplan.domain.PeriodoEnum;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.Entity;

@Entity
public class Turma extends PanacheEntityBase {

    private Integer ano;
    private PeriodoEnum periodo;

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
}
