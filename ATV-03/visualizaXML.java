import com.thoughtworks.xstream.XStream;

import java.io.*;
import java.util.Scanner;

public class visualizaXML {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Pesquisa FUNCIONARIO\nCPF: ");
        String cpf = sc.nextLine();

        XStream x = new XStream();

        try{
            String filename = "./"+cpf+".xml";
            File file = new File(filename);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            StringBuilder xmlBuilder = new StringBuilder();
            while((line = bufferedReader.readLine()) != null){
                xmlBuilder.append(line);
                xmlBuilder.append(System.lineSeparator());
            }
            bufferedReader.close();
            String xml = xmlBuilder.toString();
            System.out.println(xml);

            x.alias("Funcionario", Funcionario.class);
            Funcionario f = (Funcionario) x.fromXML(xml);

            System.out.println("\nCPF: " + f.cpf +
                    "\nNome: " + f.nome +
                    "\nIdade: " + f.idade +
                    "\nSalário: " + f.salario +
                    "\nCargo: " + f.cargo + "\n");
            int n = f.habilidades.length;
            int numhabilidade;
            System.out.println("Habilidades");
            for(int i = 0; i<n; i++){
                numhabilidade = i+1;
                System.out.print("Habilidade " + numhabilidade + ": ");
                System.out.println(f.habilidades[i]);
            }


        } catch (Exception e) {
            System.out.println("\nCPF não encontrado");
            throw new RuntimeException(e);
        }
    }
}
