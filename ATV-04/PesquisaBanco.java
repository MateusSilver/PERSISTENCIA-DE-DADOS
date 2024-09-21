import java.sql.SQLException;
import java.util.Scanner;

public class PesquisaBanco {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o id de busca: ");
        int id = sc.nextInt();
        sc.nextLine();

        ClientBanco cb = new ClientBanco();
         Candidato achado = cb.SearchCandidato(id);
         if(achado != null) {
             System.out.println(achado.getNome() + "\n" + achado.getSexo() + "\n" + achado.getData_nasc() + "\n" + achado.getCargo_pretendido() + "\n" + achado.getTexto_curriculo() + "\n");
         } else {
             System.out.println("Erro: codigo Não encontrado");
         }
    }
}
