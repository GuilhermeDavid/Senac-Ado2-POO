package connection;

import entities.Pessoa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoasDAO {

    public List<Pessoa> obterListaDePessoas() throws SQLException {
        try {

            Conexao con = new Conexao();
            con.getConexao(); //Obtendo a conexão

            String sql = "select * from tb_pessoas;";

            PreparedStatement comando = con.getConexao().prepareStatement(sql);
            ResultSet resultado = comando.executeQuery();

            List<Pessoa> listaDePessoas;
            listaDePessoas = new ArrayList<>();

            while (resultado.next()) {
                Pessoa p = new Pessoa();

                p.setId(resultado.getInt("id"));
                p.setNome(resultado.getString("nome"));

                listaDePessoas.add(p);
            }

            resultado.close();
            comando.close();
            con.getConexao().close();

            return listaDePessoas;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void inserirPessoa(Pessoa p) {

        Conexao conexao = new Conexao();
        PreparedStatement st = null;

        try {
            String sql = "";
            sql += "";
            sql += "INSERT INTO tb_pessoas"
                    + "(nome)"
                    + "VALUES"
                    + "(?)";

            st = conexao.getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            st.setString(1, p.getNome());

            int linhasAfetadas = st.executeUpdate();

            if (linhasAfetadas > 0) {
                try ( ResultSet rs = st.getGeneratedKeys()) {
                    if (rs.next()) {
                        int id = rs.getInt(1);
                        p.setId(id);
                    }
                }
            } else {
                throw new SQLException("Erro inesperado! Nenhuma linha afetada!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            conexao.fechaConexao();
        }
    }
}
