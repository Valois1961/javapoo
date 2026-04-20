import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double saldo = 0.0;
        int opcao = -1;
        int quantidadeSaques = 0;

        do {
            System.out.println("\n===== TERMINAL BANCÁRIO =====");
            System.out.println("1 - Ver saldo");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
            } else {
                System.out.println("Digite um número válido!");
                scanner.next();
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.println("Saldo atual: R$ " + saldo);
                    break;

                case 2:
                    System.out.print("Digite o valor para depósito: R$ ");
                    double deposito = scanner.nextDouble();
                    if (deposito > 0) {
                        saldo += deposito;
                        System.out.println("Depósito realizado com sucesso!");
                    } else {
                        System.out.println("Valor inválido.");
                    }
                    break;

                case 3:
                    if (quantidadeSaques >= 3) {
                        System.out.println("Limite de Saques Diarios Ultrapassado");
                        break;
                    }

                    System.out.print("Digite o valor para saque: R$ ");
                    double saque = scanner.nextDouble();

                    if (saque > 1000) {
                        System.out.println("Valor máximo por saque é R$1000.00");
                    } else if (saque > saldo) {
                        System.out.println("Saldo insuficiente.");
                    } else if (saque <= 0) {
                        System.out.println("Valor inválido.");
                    } else {
                        saldo -= saque;
                        quantidadeSaques++;
                        System.out.println("Saque realizado com sucesso!");
                    }
                    break;

                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}