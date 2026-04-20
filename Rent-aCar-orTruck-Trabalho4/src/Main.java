public class Main {
    public static void main(String[] args) {

        try {
            Caminhao caminhao = new Caminhao(
                    "CAM0001",
                    "Mercedes1113",
                    350,
                    2015,
                    80000,
                    10
            );

            CarroPasseio carro = new CarroPasseio(
                    "PASS001",
                    "FIATFastback",
                    150,
                    2016,
                    85000
            );

            // Teste aluguel
            double aluguelCaminhao = caminhao.alugarVeiculo(12, 5);
            double aluguelCarro = carro.alugarVeiculo(3);

            System.out.println("Aluguel Caminhão: " + aluguelCaminhao);
            System.out.println("Aluguel Carro: " + aluguelCarro);

            // Teste IPVA
            System.out.println("IPVA Caminhão: " + caminhao.calcularIpva());
            System.out.println("IPVA Carro: " + carro.calcularIpva());

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}