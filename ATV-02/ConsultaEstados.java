package exercicio001;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ConsultaEstados {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a sigla do estado: ");
        String estado = sc.nextLine();

        FileReader arq = new FileReader("src/exercicio001/resources/UF.csv");
        BufferedReader br = new BufferedReader(arq);

        String line = br.readLine();
        while(line != null) {
            String[] data = line.split(",");
            if(estado.equals(data[1])) {
                System.out.print(data[2] + " ");
                switch (data[3]){
                    case "1":
                        System.out.print("Norte ");
                        break;
                    case "2":
                        System.out.print("Nordeste ");
                        break;
                        case "3":
                            System.out.print("Sudeste ");
                            break;
                            case "4":
                                System.out.print("Sul ");
                                break;
                                case "5":
                                    System.out.print("Centro Oeste ");
                                    break;
                                    default:
                                        System.out.println("Região não encontrada");

                }
                System.out.println(data[4]);
            }
            line = br.readLine();
        }
        arq.close();
    }
}
