import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Veiculo> lista = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n===== SISTEMA DE VEÍCULOS =====");
            System.out.println("\nDigite a Opcao Desejada :");
            System.out.println("1 - Cadastrar Caminhão");
            System.out.println("2 - Cadastrar Carro");
            System.out.println("3 - Listar Veículos");
            System.out.println("4 - Alugar Veículo");
            System.out.println("5 - Calcular IPVA");
            System.out.println("0 - Sair");
            System.out.println("\n");


            opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            try {
                switch (opcao) {

                    case 1:
                        cadastrarCaminhao(sc);
                        break;

                    case 2:
                        cadastrarCarro(sc);
                        break;

                    case 3:
                        listarVeiculos();
                        break;

                    case 4:
                        alugarVeiculo(sc);
                        break;

                    case 5:
                        calcularIpva(sc);
                        break;

                    case 0:
                        System.out.println("Saindo...");
                        break;

                    default:
                        System.out.println("Opção inválida");

                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }

        } while (opcao != 0);

        sc.close();
    }

    // =========================
    static void cadastrarCaminhao(Scanner sc) throws Exception {

        System.out.println("Placa:");
        String placa = sc.nextLine();

        System.out.println("Marca:");
        String marca = sc.nextLine();

        System.out.println("Valor diária:");
        double diaria = sc.nextDouble();

        System.out.println("Ano fabricação:"); // so como informacao nao afeta IPVA
        int ano = sc.nextInt();

        System.out.println("Preço FIPE:");
        double fipe = sc.nextDouble();

        System.out.println("Capacidade (ton):");
        double capacidade = sc.nextDouble();
        sc.nextLine();

        Caminhao c = new Caminhao(placa, marca, diaria, ano, fipe, capacidade);
        lista.add(c);

        System.out.println("Caminhão cadastrado!");
    }

    // =========================
    static void cadastrarCarro(Scanner sc) throws Exception {

        System.out.println("Placa:");
        String placa = sc.nextLine();

        System.out.println("Marca:");
        String marca = sc.nextLine();

        System.out.println("Valor diária:");
        double diaria = sc.nextDouble();

        System.out.println("Ano fabricação:");
        int ano = sc.nextInt();

        System.out.println("Preço FIPE:");
        double fipe = sc.nextDouble();
        sc.nextLine();

        CarroPasseio c = new CarroPasseio(placa, marca, diaria, ano, fipe);
        lista.add(c);

        System.out.println("Carro cadastrado!");
    }

    // =========================
    static void listarVeiculos() {

        if (lista.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado.");
            return;
        }

        for (int i = 0; i < lista.size(); i++) {
            Veiculo v = lista.get(i);

            System.out.println("\nID: " + i);
            System.out.println("Placa: " + v.placa);
            System.out.println("Marca: " + v.marca);
            System.out.println("Ano: " + v.anoFabricacao);

            if (v instanceof Caminhao) {
                System.out.println("Tipo: Caminhão");
            } else {
                System.out.println("Tipo: Carro");
            }
        }
    }

    // =========================
    static void alugarVeiculo(Scanner sc) throws Exception {

        listarVeiculos();

        System.out.println("Escolha o ID do Veiculo:");
        int id = sc.nextInt();

        if (id < 0 || id >= lista.size()) {
            throw new Exception("ID inválido");
        }
        Veiculo v = lista.get(id);

        System.out.println("Dias:");
        int dias = sc.nextInt();

        System.out.println("Peso da carga:");
        double peso = sc.nextDouble();

        double total = v.alugarVeiculo(peso, dias);

        System.out.println("Valor do aluguel: " + total);
    }

    // =========================
    static void calcularIpva(Scanner sc) throws Exception {

        listarVeiculos();

        System.out.println("Escolha o ID do Veiculo:");
        int id = sc.nextInt();

        if (id < 0 || id >= lista.size()){
            throw new Exception("ID inválido");
        }
        Veiculo v = lista.get(id);

        double ipva = v.calcularIpva();

        System.out.println("IPVA: " + ipva);
    }
}