import com.thoughtworks.xstream.XStream;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class criaXML {
    public static void main(String[] args) throws IOException {
        Funcionario f1 = new Funcionario();

        Scanner sc = new Scanner(System.in);

        System.out.print("CPF: ");
        f1.cpf = sc.nextLine();

        System.out.print("Nome: ");
        f1.nome = sc.nextLine();

        System.out.print("Salario: ");
        f1.salario = sc.nextDouble();
        sc.nextLine();

        System.out.print("Idade: ");
        f1.idade = sc.nextInt();
        sc.nextLine();

        System.out.print("Cargo: ");
        f1.cargo = sc.nextLine();

        System.out.print("Quantas habilidades? ");
        int n = sc.nextInt();
        sc.nextLine();

        f1.habilidades = new String[n];
        for (int i = 0; i < n; i++) {
            f1.habilidades[i] = sc.nextLine();
        }

        String nomeArquivo = f1.cpf+".xml";
        Writer arq = new FileWriter(nomeArquivo);

        XStream x = new XStream();
        x.toXML(f1, arq);
    }
}