package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private String statusConexao = "Não conectado!";

    public Connection getConexao() {

        Connection conexao = null;

        try {

            String nomeDriver = "com.mysql.cj.jdbc.Driver";
            Class.forName(nomeDriver);

            String servidor = "localhost";
            String schema = "db_pessoas";

            String url = "jdbc:mysql://" + servidor + "/" + schema;

            String usuario = "root";
            String senha = "12345";

            conexao = (Connection) DriverManager.getConnection(url, usuario, senha);

            if (conexao != null) {

                statusConexao = "Conectado!";
            } else {
                statusConexao = "Não conectado";
            }

            return conexao;

        } catch (ClassNotFoundException e) {
            System.out.println("Drive não encontrado!");
            return null;
        } catch (SQLException e) {
            System.out.println("Não conectado!");
            System.out.println(e.getMessage());
            return null;
        }
    }

    public String getStatusConexao() {
        return statusConexao;
    }

    public boolean fechaConexao() {
        try {
            getConexao().close();
            statusConexao = "Conexão Fechada";
            return true;
        } catch (SQLException e) {

            System.out.println(e.getMessage());
            return false;
        }
    }

    public Connection reiniciaConexao() {
        fechaConexao();
        return getConexao();
    }
}
