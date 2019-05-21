package br.com.softplan.springexample.model;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;
    private String sobrenome;
    private String nomeMae;
    private String nomePai;
    private Date dataNascimento;

    @ManyToOne(cascade = CascadeType.ALL)
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
}
