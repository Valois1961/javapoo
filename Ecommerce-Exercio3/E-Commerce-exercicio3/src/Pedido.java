import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private Cliente cliente;
    private List<ItemPedido> itens = new ArrayList<>();

    public Pedido(Cliente cliente) throws Exception {

        if (cliente == null)
            throw new Exception("Cliente inválido");

        this.cliente = cliente;
    }

    public void adicionarItem(ItemPedido item) {
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
        double frete;

        if (total > 250) {
            frete = 0;
        } else {
            frete = 25;
        }

        double totalFinal = total + frete;

        // 🧾 RECIBO
        System.out.println("\n===== RECIBO =====");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Email: " + cliente.getEmail());

        System.out.println("\nItens:");
        for (ItemPedido item : itens) {
            System.out.printf(
                    "%s | Qtd: %d | Unit: R$ %.2f | Subtotal: R$ %.2f%n",
                    item.getNomeProduto(),
                    item.getQuantidade(),
                    item.getPrecoUnitario(),
                    item.calcularSubtotal()
            );
        }

        System.out.printf("\nTotal dos itens: R$ %.2f%n", total);
        System.out.printf("Frete: R$ %.2f%n", frete);
        System.out.printf("TOTAL FINAL: R$ %.2f%n", totalFinal);
    }
}
