package application;

import java.sql.SQLException;
import java.util.Scanner;
import operations.Insere;
import operations.Listar;

public class Program {

   public static void main(String[] args) throws SQLException {
       Scanner sc = new Scanner(System.in);
       Insere inserir = new Insere();
       
       Listar listar = new Listar();
       
       int op;
       
       do {
           System.out.println("\t ----  MENU  --- ");
            System.out.println("\t1. Inserir");
            System.out.println("\t2. Listar");
            System.out.println("\t0. Sair");
            System.out.print("\n\tEscolha uma opção: ");
            
            op = sc.nextInt();
            
            switch(op){
                case 0:
                    break;
                case 1:
                    inserir.inserirPessoa();
                    break;
                case 2:
                    listar.listarPessoas();
                    break;
                default:
                    System.out.println("\n\t -- Opção inválida! -- \n");
            }
   
       } while (op != 0);
       
       sc.close();
    }

}
