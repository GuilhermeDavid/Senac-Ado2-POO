package operations;

import connection.PessoasDAO;
import entities.Pessoa;
import java.util.Scanner;

public class Insere {

    public void inserirPessoa() {

        try {
            Scanner sc = new Scanner(System.in);
            Pessoa p = new Pessoa();

            System.out.println("\n---  INSIRA  ---");

            System.out.print("\nInforme o nome: ");
            String nome = sc.nextLine().toUpperCase();

            p.setNome(nome);

            PessoasDAO cD = new PessoasDAO();
            cD.inserirPessoa(p);
            System.out.println("\nPessoa inserido com sucesso!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
