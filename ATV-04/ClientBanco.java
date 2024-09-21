import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientBanco {
    private Connection con;

    public ClientBanco() throws SQLException {
        con = ConexaoBanco.obterConexao();
    }

    public void PostCandidato(Candidato can ){
        String sql = "INSERT INTO candidatos(codigo, nome, sexo, data_nasc, cargo_pretendido, texto_curriculo) VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, can.getCodigo());
            ps.setString(2, can.getNome());
            ps.setString(3, can.getSexo());
            ps.setDate(4, can.getData_nasc());
            ps.setString(5, can.getCargo_pretendido());
            ps.setString(6, can.getTexto_curriculo());

            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Candidato SearchCandidato(int id){
        String sql = "SELECT * FROM candidatos WHERE id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Candidato c = null;
            if (rs.next()) {
                c = new Candidato(rs.getString(2), rs.getString(3).charAt(0), rs.getDate(4).toString(), rs.getString(5), rs.getString(6));
            }
            return c;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
