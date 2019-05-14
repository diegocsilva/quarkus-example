package br.com.softplan.springexample.model;

import br.com.softplan.domain.PeriodoEnum;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Turma {

    @Id
    private Long id;
    private Integer ano;
    private PeriodoEnum periodo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}