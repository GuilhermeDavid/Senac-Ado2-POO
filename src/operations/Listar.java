package operations;

import connection.PessoasDAO;
import entities.Pessoa;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Listar {

    public void listarPessoas() throws SQLException {

        PessoasDAO pessoa = new PessoasDAO();

        List<Pessoa> listaDePessoas;
        listaDePessoas = new ArrayList<>();
        listaDePessoas = pessoa.obterListaDePessoas();

        System.out.println("\nid\t|\tNome");
        System.out.println("----\t|\t-----");

        for (Pessoa p : listaDePessoas) { // 
            System.out.print(p.getId()+ "\t|\t");
            System.out.print(p.getNome());
            System.out.println("\n");
        }
    }
}
