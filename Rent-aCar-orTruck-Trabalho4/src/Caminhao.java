public final class Caminhao extends Veiculo {

    private final double capacidadeCargaToneladas;

    public Caminhao(String placa, String marca, double valorLocacaoDiaria,
                    int anoFabricacao, double precoFipe,
                    double capacidadeCargaToneladas) throws Exception {

        super(placa, marca, valorLocacaoDiaria, anoFabricacao, precoFipe);

        if (capacidadeCargaToneladas <= 0){
            throw new Exception("Capacidade de carga inválida");
        }

        this.capacidadeCargaToneladas = capacidadeCargaToneladas;
    }

    @Override
    public double alugarVeiculo(double pesoCarga, int dias) throws Exception {

        if (pesoCarga < 0 || dias <= 0){
            throw new Exception("Parâmetros inválidos");
        }
        double total = valorLocacaoDiaria * dias;

        // Regra de sobrecarga
        if (pesoCarga > capacidadeCargaToneladas) {
            total += total * 0.10; // Carga excede  a capacidade de carga +10%
        }

        return total;
    }

    @Override
    public double calcularIpva() {

        if (isIsentoIPVA()){
            return 0.0;
        }
        return precoFipe * 0.04; // 4%
    }
}
