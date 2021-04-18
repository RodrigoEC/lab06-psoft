package Main.Situacao;

import Main.Usuario;

import java.time.LocalDate;

public class HabilitadoPrimeiraDose extends Situacao {

    @Override
    public void update(Usuario usuario) {
        usuario.adicionaDataVacinacao("1", LocalDate.now());
        usuario.setSituacao(new VacinadoPrimeiraDose());
    }

    @Override
    public String toString() {
        return "Usuário Habilitado para tomar a primeira dose da vacina";
    }
}
