import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Candidato {
    int codigo;
    String nome;
    char sexo;
    LocalDate data_nasc;
    String cargo_pretendido;
    String texto_curriculo;

    public Candidato(String nome, char sexo, String data_nasc, String cargo_pretendido, String texto_curriculo) {
        Random rand  = new Random();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        this.codigo = rand.nextInt(1000);
        this.nome = nome;
        this.sexo = sexo;
        this.data_nasc = LocalDate.parse(data_nasc, formatter);
        this.cargo_pretendido = cargo_pretendido;
        this.texto_curriculo = texto_curriculo;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getSexo() {
        return String.valueOf(sexo);
    }

    public Date getData_nasc() {
        return Date.valueOf(data_nasc);
    }

    public String getCargo_pretendido() {
        return cargo_pretendido;
    }

    public String getTexto_curriculo() {
        return texto_curriculo;
    }
}
