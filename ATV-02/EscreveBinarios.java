package exercicio002;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class EscreveBinarios {
    public static int searchEspecific(String Estado, String pais) throws IOException {
        FileReader arq = new FileReader("src/exercicio002/resources/UF.csv");
        BufferedReader br = new BufferedReader(arq);

        String line = br.readLine();
        while(line != null) {
            String[] data = line.split(",");
            if(data[1].equals(Estado) && data[4].equals(pais)) {
                arq.close();
                System.out.println("codigo de pais: " + data[1]);
                return Integer.parseInt(data[0]);
            }
            line = br.readLine();
        }
        arq.close();
        return -1;
    }

    public static int searchEstado(String Estado) throws IOException {
        FileReader arq = new FileReader("src/exercicio001/resources/UF.csv");
        BufferedReader br = new BufferedReader(arq);

        Scanner sc = new Scanner(System.in);


        ArrayList<Integer> IDs = new ArrayList<Integer>();

        String line = br.readLine();
        while(line != null) {
            String[] data = line.split(",");
            if(data[1].equals(Estado)) {
                System.out.println("codigo de estado encontrado: " + data[0]);
                IDs.add(Integer.parseInt(data[0]));
            }
            line = br.readLine();
        }
        int quant = IDs.size();
        System.out.println("estados com o UF encontrados: " + quant);
        String pais;
        if(quant > 1){
            System.out.println("Qual país?");
            pais = sc.nextLine();
            System.out.println(pais);

            arq.close();
            return searchEspecific(Estado, pais);
        }
        arq.close();
        if(quant == 0){
            return -1;
        }
        return Integer.parseInt(String.valueOf(IDs.getFirst()));
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        FileOutputStream arq = new FileOutputStream("src/exercicio002/resources/funcionarios.dat");
        DataOutputStream gravador = new DataOutputStream(arq);



        do {
            System.out.print("nome: ");
            String name = sc.nextLine();
            System.out.println(name);

            System.out.print("idade: ");
            int idade = sc.nextInt();
            System.out.println(idade);
            sc.nextLine();

            System.out.print("estado: ");
            String Estado = sc.nextLine();
            System.out.println(Estado);

            System.out.print("salario(,): ");
            double salario = sc.nextDouble();
            System.out.println(salario);

            System.out.println("analisando ID de estado");
            int IDestado = searchEstado(Estado);

            System.out.println("inserido dados no arquivo, ID = " + IDestado);

            if(IDestado > 0){
                gravador.writeUTF(name);
                gravador.writeInt(idade);
                gravador.writeDouble(salario);
                gravador.writeInt(IDestado);
            }

            sc.nextLine();
        } while(sc.hasNext());
        arq.close();
    }
}
