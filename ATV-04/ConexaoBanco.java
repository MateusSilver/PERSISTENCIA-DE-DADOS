import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {
    private String user;
    private String senha;
    private String textoConexao;

    public static Connection obterConexao() throws SQLException {
        String user = "root";
        String senha = "root";
        String url = "jdbc:mysql://localhost:3306/candidatos";

        return DriverManager.getConnection(url, user, senha);
    }


}
