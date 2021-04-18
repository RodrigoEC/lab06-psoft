package Main.Situacao;

import Main.Usuario;

public abstract class Situacao {
    public void update(Usuario usuario) {}
    public void habilitar(Usuario usuario) {}
    public String toString() { return ""; }
}
