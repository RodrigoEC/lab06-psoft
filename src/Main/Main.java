package Main;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        UsuarioObserver obs = new UsuarioObserver();
        Usuario rodrigo = new Usuario("Rodrigo", "045.487.594-20", "Lauritzen", "154782686",
                "rodrigo@hmail.com", "estudante",20);

        System.out.println("1- " + rodrigo.getSituacao());
        // Adiciona grupo de prioridade
        obs.addProfissao("estudante");
        System.out.println("2- " + rodrigo.getSituacao());
        // Adiciona o usuário na lista de observables
        obs.addUsuario(rodrigo);
        System.out.println("3- " + rodrigo.getSituacao());
        // Tenta vacinar o usuário
        rodrigo.vacinar();
        System.out.println("4- " + rodrigo.getSituacao());

        // Tenta fazer a segunda dose da vacina, mesmo que 20 dias não tenham se passado
        rodrigo.vacinar();
        System.out.println("5- " + rodrigo.getSituacao());

//       Essa próxima linha altera a data da vacinação para que seja possível continuar a demonstração do programa
//      Uma vez que ele funciona depois de 20 dias que o paciente foi vacinado
        rodrigo.getCartaoSUS().adicionaVacinacao("1", LocalDate.of(2020,11,17));

        // Tentativa de vacinação depois de mais de 20 dias
        rodrigo.vacinar();
        System.out.println("5- " + rodrigo.getSituacao());







    }
}
