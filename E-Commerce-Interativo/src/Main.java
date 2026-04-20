import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            // 👤 Cliente
            System.out.print("Nome do cliente: ");
            String nome = sc.nextLine();

            System.out.print("Email: ");
            String email = sc.nextLine();

            Cliente cliente = new Cliente(nome, email);
            Pedido pedido = new Pedido(cliente);

            int opcao;

            do {
                System.out.println("\n1 - Adicionar item");
                System.out.println("2 - Fechar pedido");
                System.out.println("0 - Sair");
                System.out.print("Escolha: ");
                opcao = sc.nextInt();
                sc.nextLine(); // limpar buffer

                switch (opcao) {

                    case 1:
                        try {
                            System.out.print("Produto: ");
                            String produto = sc.nextLine();

                            System.out.print("Quantidade: ");
                            int qtd = sc.nextInt();

                            System.out.print("Preço unitário: ");
                            double preco = sc.nextDouble();
                            sc.nextLine();

                            ItemPedido item = new ItemPedido(produto, qtd, preco);
                            pedido.adicionarItem(item);

                            System.out.println("Item adicionado!");

                        } catch (Exception e) {
                            System.out.println("Erro ao adicionar item: " + e.getMessage());
                            sc.nextLine(); // limpar buffer em caso de erro
                        }
                        break;

                    case 2:
                        pedido.fecharPedido();
                        break;

                    case 0:
                        System.out.println("Encerrando...");
                        break;

                    default:
                        System.out.println("Opção inválida!");
                }

            } while (opcao != 0);

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        sc.close();
    }
}