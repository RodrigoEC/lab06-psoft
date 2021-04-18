package Main;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class ContaSUS {
    private String cpf;
    private String numeroCartao;
    private final Map<String, LocalDate> cartelaVacinacao;

    public ContaSUS(String cpf, String numeroCartao) {
        this.cpf = cpf;
        this.numeroCartao = numeroCartao;
        this.cartelaVacinacao = new HashMap<>();
    }

    public void adicionaVacinacao(String dose, LocalDate dataVacinacao) {
        this.cartelaVacinacao.put(dose, dataVacinacao);
    }

    public LocalDate recuperaDataVacinacao(String dose) {
        return this.cartelaVacinacao.get(dose);
    }
}
