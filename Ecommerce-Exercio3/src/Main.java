package br.com.ecommerce.main;

import br.com.ecommerce.model.*;

public class Main {

    public static void main(String[] args) {

        Cliente cliente = new Cliente("Valois Costa", "valois61@email.com");

        Pedido pedido = new Pedido(cliente);

        pedido.adicionarItem(new ItemPedido("Tenis", 400, 2));
        pedido.adicionarItem(new ItemPedido("Bone", 100, 3));
        pedido.adicionarItem(new ItemPedido("Bermuda", 200, 1));

        pedido.fecharPedido();
    }
}