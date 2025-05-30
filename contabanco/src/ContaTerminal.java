import java.util.InputMismatchException; // Importar para lidar com erros de tipo de entrada
import java.util.Locale;              // Importar para garantir o uso de ponto decimal
import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) { // Removido 'throws Exception' pois o tratamento de exceção é mais específico
        // Configura o Scanner para usar o ponto como separador decimal, independentemente da localidade do sistema.
        // Isso é crucial para que números decimais como "25.50" sejam lidos corretamente.

//************************** Validacion del formato UTF-8 DEL iDE *******************************
 
                try {
            System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
        } catch (java.io.UnsupportedEncodingException e) {
            System.err.println("UTF-8 encoding is not supported: " + e.getMessage());
            return;
        }
//****************************************************************************************** */




        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        int numero = 0; // Inicializado para evitar erro de "variável não inicializada"
        String agencia = "";
        String nome = "";
        double saldo = 0.0; // Inicializado para evitar erro de "variável não inicializada"

        System.out.println("----------------------------------------------");
        System.out.println("        Criação de Conta Bancária             ");
        System.out.println("----------------------------------------------");

        try {
            System.out.print("Por favor, digite o número da Agência: ");
            agencia = scanner.nextLine(); // Leitura como String (texto)

            System.out.print("Por favor, digite o número da Conta (somente números): ");
            // Loop para garantir que um número inteiro válido seja inserido
            while (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida. Por favor, digite um número inteiro para a Conta.");
                scanner.next(); // Consome a entrada inválida
                System.out.print("Por favor, digite o número da Conta (somente números): ");
            }
            numero = scanner.nextInt(); // Leitura como int (número inteiro)
            scanner.nextLine(); // Consome o restante da linha após o nextInt()

            System.out.print("Por favor, digite o Nome do Cliente: ");
            nome = scanner.nextLine(); // Leitura como String (texto)

            System.out.print("Por favor, digite o Saldo (use ponto para decimais, ex: 100.50): ");
            // Loop para garantir que um número decimal válido seja inserido
            while (!scanner.hasNextDouble()) {
                System.out.println("Entrada inválida. Por favor, digite um valor numérico para o Saldo (ex: 100.50).");
                scanner.next(); // Consome a entrada inválida
                System.out.print("Por favor, digite o Saldo (use ponto para decimais, ex: 100.50): ");
            }
            saldo = scanner.nextDouble(); // Leitura como double (decimal)
            scanner.nextLine(); // Consome o restante da linha após o nextDouble()

            System.out.println("\n----------------------------------------------");
            System.out.println("         Dados da Conta Criada                ");
            System.out.println("----------------------------------------------");
            System.out.println("Olá " + nome + ", obrigado por criar uma conta em nosso banco.");
            System.out.println("Sua agência é " + agencia + ", conta " + numero + ".");
            System.out.printf("Seu saldo %.2f já está disponível para saque.\n", saldo); // Usando printf para formatar o saldo com 2 casas decimais

        } catch (InputMismatchException e) {
            // Esta exceção será capturada se o nextInt() ou nextDouble() receberem um tipo diferente do esperado.
            // Embora os loops `while` já tratem isso, é uma boa prática ter um catch geral para InputMismatchException.
            System.err.println("Erro de formato de entrada. Certifique-se de digitar números onde são esperados.");
        } catch (Exception e) {
            // Captura outras exceções inesperadas.
            System.err.println("Ocorreu um erro inesperado: " + e.getMessage());
        } finally {
            scanner.close(); // Sempre fecha o scanner no bloco finally para liberar recursos.
        }
    }
}
