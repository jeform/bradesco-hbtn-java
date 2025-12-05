 import java.io.BufferedWriter;
 import java.io.FileWriter;
 import java.io.IOException;
 import java.util.Scanner;

public class FileWritingExercise {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

         System.out.print("Digite o nome do arquivo (com extensão .txt): ");
         String fileName = scanner.nextLine();

         System.out.println("Digite as linhas de texto (digite 'sair' para finalizar):");
         
         try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
             String linha;
             
             while (true) {
                 linha = scanner.nextLine();
                 
                 if (linha.equals("sair")) {
                     break;
                 }
                 
                 writer.write(linha);
                 writer.newLine();
             }
             
             System.out.println("Arquivo '" + fileName + "' criado e conteúdo salvo com sucesso!");
             
         } catch (IOException e) {
             System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
         }

         scanner.close();
     }
}
