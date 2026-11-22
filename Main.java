import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Sobrenome: ");
        String sobrenome = scanner.nextLine();

        int idade = lerInteiro(scanner, "Idade: ");
        double altura = lerDecimal(scanner, "Altura (m): ");
        double peso = lerDecimal(scanner, "Peso (kg): ");

        Pessoa pessoa = new Pessoa(nome, sobrenome, idade, altura, peso);
        double imc = pessoa.calculaIMC();

        System.out.println();
        System.out.println("Pessoa: " + pessoa.getNome() + " " + pessoa.getSobrenome());
        System.out.printf("IMC: %.2f%n", imc);
        System.out.println("Classificacao: " + pessoa.informaObesidade());

        scanner.close();
    }

    private static int lerInteiro(Scanner scanner, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            try {
                int valor = Integer.parseInt(scanner.nextLine().trim());
                if (valor > 0) {
                    return valor;
                }
            } catch (NumberFormatException e) {
            }
            System.out.println("Valor invalido. Tente novamente.");
        }
    }

    private static double lerDecimal(Scanner scanner, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            try {
                double valor = Double.parseDouble(scanner.nextLine().trim().replace(',', '.'));
                if (valor > 0) {
                    return valor;
                }
            } catch (NumberFormatException e) {
            }
            System.out.println("Valor invalido. Tente novamente.");
        }
    }
}
