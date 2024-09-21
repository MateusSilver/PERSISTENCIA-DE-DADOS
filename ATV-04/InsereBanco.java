import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class InsereBanco {
    public static void main(String[] args) throws SQLException {
        String nome;
        String sexo;
        String data_nasc;
        String cargo;
        String curriculo;


        Scanner sc = new Scanner(System.in);
        System.out.println("Insira um Nome: ");
        nome = sc.nextLine();
        System.out.println("Insira um Sexo(M ou F):");
        sexo = sc.nextLine();
        System.out.println("insira uma data no formato (dd/MM/yyyy): ");
        data_nasc = sc.nextLine();
        System.out.println("Insira o cargo pretendido: ");
        cargo = sc.nextLine();
        System.out.println("insira um breve texto curriculo: ");
        curriculo = sc.nextLine();

        Candidato novo = new Candidato(nome, sexo.charAt(0), data_nasc, cargo, curriculo);
        ClientBanco cb = new ClientBanco();
        cb.PostCandidato(novo);
    }
}