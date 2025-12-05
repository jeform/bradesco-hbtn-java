import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvFileReader {
    public static void main(String[] args) {
        String fileName = "funcionarios.csv";
        
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] campos = line.split(",");
                
                System.out.println("Funcionário: " + campos[0]);
                System.out.println("Idade: " + campos[1]);
                System.out.println("Departamento: " + campos[2]);
                System.out.println("Salarial: " + campos[3]);
                System.out.println("------------------------");
            }
            
            System.out.println("Leitura do arquivo concluída.");
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
