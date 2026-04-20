public class Main {
    public static void main(String[] args) {

        try {

            Cliente cliente = new Cliente("João Silva", "joao@email.com");

            Pedido pedido = new Pedido(cliente);

            pedido.adicionarItem(new ItemPedido("Notebook", 1, 2000));
            pedido.adicionarItem(new ItemPedido("Mouse", 2, 50));

            pedido.fecharPedido();

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}