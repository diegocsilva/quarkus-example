package br.com.softplan.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Entity
public class Aluno extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Integer id;

    private String nome;
    private String sobrenome;
    private String nomeMae;
    private String nomePai;
    private String dataNascimento;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="turma_id", referencedColumnName="id",nullable=false)
    private Turma turma;

    public Aluno merge(Aluno aluno) {
        if (!this.nome.equals(aluno.nome)){
            this.nome = aluno.nome;
        }
        if (!this.sobrenome.equals(aluno.sobrenome)){
            this.sobrenome = aluno.sobrenome;
        }
        if (!this.nomeMae.equals(aluno.nomeMae)){
            this.nomeMae = aluno.getNomeMae();
        }
        if (!this.nomePai.equals(aluno.nomePai)){
            this.nomePai = aluno.getNomePai();
        }
        if (!this.dataNascimento.equals(aluno.dataNascimento)){
            this.dataNascimento = aluno.getDataNascimento();
        }
        return this;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
