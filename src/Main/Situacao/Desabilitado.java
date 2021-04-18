package Main.Situacao;

import Main.Usuario;

public class Desabilitado extends Situacao {

    @Override
    public void habilitar(Usuario usuario) {
        usuario.setSituacao(new HabilitadoPrimeiraDose());
    }

    @Override
    public String toString() {
        return "Usuário desabilitado para tomar a primeira dose da vacina";
    }
}
