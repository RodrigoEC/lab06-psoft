package Main;

import Main.Situacao.Desabilitado;
import Main.Situacao.Situacao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private String nome;
    private String cpf;
    private String endereco;
    private ContaSUS cartaoSUS;
    private String eMail;
    private String profissao;
    private List<String> comorbidades;
    private Integer idade;
    private Situacao situacao;

    public Usuario(String nome, String cpf, String endereco, String cartaoSus, String eMail, String profissao, Integer idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.cartaoSUS = new ContaSUS(cpf, cartaoSus);
        this.eMail = eMail;
        this.profissao = profissao;
        this.comorbidades = new ArrayList<>();
        this.idade = idade;
        this.situacao = new Desabilitado();
    }

    public Usuario(String nome, String cpf, String endereco, String cartaoSus, String eMail, String profissao, Integer idade, List<String> comorbidades) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.cartaoSUS = new ContaSUS(cpf, cartaoSus);
        this.eMail = eMail;
        this.profissao = profissao;
        this.comorbidades = new ArrayList<>();
        this.idade = idade;
        this.comorbidades.addAll(comorbidades);
        this.situacao = new Desabilitado();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getProfissao() {
        return profissao;
    }

    public ContaSUS getCartaoSUS() {
        return cartaoSUS;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public List<String> getComorbidades() {
        return comorbidades;
    }

    public void setComorbidades(List<String> comorbidades) {
        this.comorbidades = comorbidades;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void notificaComorbidade(List<String> todasComorbidades) {
        if (!(this.situacao instanceof Desabilitado)) return;

        for (String comorbidade: this.comorbidades) {
            if (todasComorbidades.contains(comorbidade)) {
                this.situacao.habilitar(this);
            }
        }
    }

    public void notificaProfissao(List<String> profissoes) {
        if (!(this.situacao instanceof Desabilitado)) return;

        if (profissoes.contains(this.profissao)) {
            this.situacao.habilitar(this);
        }
    }

    public void notificaIdade(List<Integer> idades) {
        if (!(this.situacao instanceof Desabilitado)) return;

        if (idades.contains(this.idade)) {
            this.situacao.habilitar(this);
        }
    }

    public String vacinar() {
        this.situacao.update(this);
        return this.situacao.toString();
    }

    public void adicionaDataVacinacao(String dose, LocalDate dataVacinacao) {
        this.cartaoSUS.adicionaVacinacao(dose, dataVacinacao);
    }

    public LocalDate recuperaDataVacinacao(String dose) {
        return this.cartaoSUS.recuperaDataVacinacao(dose);
    }
}
