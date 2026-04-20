import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private Cliente cliente;
    private List<ItemPedido> itens = new ArrayList<>();

    public Pedido(Cliente cliente) {
        if (cliente == null)
            throw new IllegalArgumentException("Cliente inválido");

        this.cliente = cliente;
    }

    public void adicionarItem(ItemPedido item) {
        if (item == null)
            throw new IllegalArgumentException("Item inválido");

        itens.add(item);
    }

    public double calcularTotal() {
        double total = 0;

        for (ItemPedido item : itens) {
            total += item.calcularSubtotal();
        }

        return total;
    }

    public void fecharPedido() {
        double total = calcularTotal();

        double frete = (total > 250) ? 0 : 25;
        double totalFinal = total + frete;

        System.out.println("\n===== RECIBO =====");
        System.out.println("Cliente: " + cliente.getNome());

        for (ItemPedido item : itens) {
            System.out.println(
                    item.getNomeProduto() +
                            " | Qtd: " + item.getQuantidade() +
                            " | Subtotal: " + item.calcularSubtotal()
            );
        }

        System.out.println("------------------");
        System.out.println("Total: " + total);
        System.out.println("Frete: " + frete);
        System.out.println("Total Final: " + totalFinal);
    }
}
