public final class CarroPasseio extends Veiculo {

    public CarroPasseio(String placa, String marca, double valorLocacaoDiaria,
                        int anoFabricacao, double precoFipe) throws Exception {

        super(placa, marca, valorLocacaoDiaria, anoFabricacao, precoFipe);
    }

    @Override
    public double alugarVeiculo(double pesoCarga, int dias) throws Exception {

        if (dias <= 0) {
            throw new Exception("Dias inválidos");
        }
        if (pesoCarga > 0){
            throw new Exception("Carro de passeio não transporta carga");
        }
        // carro não considera carga
        return valorLocacaoDiaria * dias;
    }
    // opcional (overload usei esse conceito para nao ter que passar pesoCarga para Carro!!!)
    public double alugarVeiculo(int dias) throws Exception {
        if (dias <= 0){
            throw new Exception("Dias inválidos");
        }
        return valorLocacaoDiaria * dias;
    }

    @Override
    public double calcularIpva() {

        if (isIsentoIPVA()){
            return 0.0;
        }
        return precoFipe * 0.15; // 15%
    }
}

