public class ItemPedido {

    private String nomeProduto;
    private int quantidade;
    private double precoUnitario;

    public ItemPedido(String nomeProduto, int quantidade, double precoUnitario) throws Exception {

        if (nomeProduto == null || nomeProduto.isEmpty()) {
            throw new Exception("Produto inválido");
        }
        if (quantidade <= 0) {
            throw new Exception("Quantidade inválida");
        }
        if (precoUnitario <= 0) {
            throw new Exception("Preço inválido");
        }
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    public double calcularSubtotal() {
        return quantidade * precoUnitario;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }
}
