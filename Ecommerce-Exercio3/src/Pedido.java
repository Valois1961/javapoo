package br.com.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private Cliente cliente;
    private List<ItemPedido> itens;
    private double total;
    private double frete;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(ItemPedido item) {
        itens.add(item);
    }

    private double calcularTotal() {
        double soma = 0;
        for (ItemPedido item : itens) {
            soma += item.getSubtotal();
        }
        return soma;
    }

    private double calcularFrete(double total) {
        if (total > 250) {
            return 0;
        }
        return 25;
    }

    public void fecharPedido() {
        this.total = calcularTotal();
        this.frete = calcularFrete(this.total);

        imprimirRecibo();
    }

    private void imprimirRecibo() {

        System.out.println("\n===== RECIBO =====");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Email: " + cliente.getEmail());

        System.out.println("\nItens:");
        for (ItemPedido item : itens) {
            System.out.println(
                    item.getNomeProduto() +
                            " | Qtd: " + item.getQuantidade() +
                            " | Preço: R$" + item.getPreco() +
                            " | Subtotal: R$" + item.getSubtotal()
            );
        }

        System.out.println("\nTotal: R$" + total);
        System.out.println("Frete: R$" + frete);
        System.out.println("Tota Final: R$" + (total + frete));
        System.out.println("=======================");
    }
}
