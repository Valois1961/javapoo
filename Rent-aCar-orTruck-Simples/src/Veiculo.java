public abstract sealed class Veiculo implements Fretavel, Tributavel
        permits Caminhao, CarroPasseio {

    protected final String placa;
    protected final String marca;
    protected double valorLocacaoDiaria;
    protected final int anoFabricacao;
    protected double precoFipe;

    public Veiculo(String placa, String marca, double valorLocacaoDiaria,
                   int anoFabricacao, double precoFipe) throws Exception {

        if (placa == null || placa.isEmpty())
            throw new Exception("Placa inválida");

        if (marca == null || marca.isEmpty())
            throw new Exception("Marca inválida");

        if (valorLocacaoDiaria <= 0)
            throw new Exception("Valor de locação inválido");

        if (anoFabricacao <= 0)
            throw new Exception("Ano inválido");

        if (precoFipe <= 0)
            throw new Exception("Preço FIPE inválido");

        this.placa = placa;
        this.marca = marca;
        this.valorLocacaoDiaria = valorLocacaoDiaria;
        this.anoFabricacao = anoFabricacao;
        this.precoFipe = precoFipe;
    }

    protected boolean isIsentoIPVA() {
        int anoAtual = java.time.LocalDate.now().getYear();
        return (anoAtual - anoFabricacao) > 20;
    }
}
