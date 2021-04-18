package Main.Situacao;

import Main.Usuario;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class VacinadoPrimeiraDose extends Situacao {

    @Override
    public void update(Usuario usuario) {
        LocalDate dataPrimeiraDose = usuario.recuperaDataVacinacao("1");
        LocalDate dataAtual = LocalDate.now();
        long diasPassados = ChronoUnit.DAYS.between(dataPrimeiraDose, dataAtual);
        if (diasPassados >= 20) {
            this.habilitar(usuario);
        } else {
            System.out.println("O usuário " + usuario.getNome() + " Ainda não está habilitado a tomar a segunda dose da" +
                    " vacina, volte em " + (20 - diasPassados) + " dias");
        }
    }

    @Override
    public void habilitar(Usuario usuario) {
        usuario.setSituacao(new VacinadoSegundaDose());
    }

    @Override
    public String toString() {
        return "Usuário vacinado com a primeira dose da vacina";
    }
}
