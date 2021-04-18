package Main;

import java.util.ArrayList;
import java.util.List;

public class UsuarioObserver {
    private List<String> comorbidades;
    private List<String> profissoes;
    private List<Integer> idades;
    private List<Usuario> usuarios;

    public UsuarioObserver(List<String> comorbidades, List<String> profissoes, List<Integer> idades) {
        this.comorbidades = comorbidades;
        this.profissoes = profissoes;
        this.idades = idades;
        this.usuarios = new ArrayList<>();
    }

    public UsuarioObserver() {
        this.comorbidades = new ArrayList<>();
        this.profissoes = new ArrayList<>();
        this.idades = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    public void addComorbidade(String comorbidade) {
        this.comorbidades.add(comorbidade);
        this.usuarios.forEach(usuario -> usuario.notificaComorbidade(this.comorbidades));
    }

    public void addProfissao(String profissao) {
        this.profissoes.add(profissao);
        this.usuarios.forEach(usuario -> usuario.notificaProfissao(this.profissoes));
    }

    public void addIdade(Integer idade) {
        this.idades.add(idade);
        this.usuarios.forEach(usuario -> usuario.notificaIdade(this.idades));
    }

    public void notificaUsuario(Usuario usuario) {
        usuario.notificaComorbidade(this.comorbidades);
        usuario.notificaProfissao(this.profissoes);
        usuario.notificaIdade(this.idades);
    }

    public void addUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
        this.notificaUsuario(usuario);
    }
}
