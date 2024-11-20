public class Main {
    public static void main(String[] args) {

        PedidoManager pedidoManager = new PedidoManager(5);

        Pedido pedido1 = new Pedido("Café preto", false);
        Pedido pedido2 = new Pedido("Capuccino", true); // VIP
        Pedido pedido3 = new Pedido("Chá verde", false);
        Pedido pedido4 = new Pedido("Espresso duplo", true); // VIP
        Pedido pedido5 = new Pedido("Latte", false);

        pedidoManager.adicionarPedido(pedido1);
        pedidoManager.adicionarPedido(pedido2);
        pedidoManager.adicionarPedido(pedido3);
        pedidoManager.adicionarPedido(pedido4);
        pedidoManager.adicionarPedido(pedido5);

        System.out.println("Pedidos em espera (inicial):");
        pedidoManager.visualizarPedidosEmEspera();

        System.out.println("\nProcessando pedidos:");
        Pedido processado = pedidoManager.processarProximoPedido();
        System.out.println("Pedido processado: " + processado.getDescricao());
        
        processado = pedidoManager.processarProximoPedido();
        System.out.println("Pedido processado: " + processado.getDescricao());

        System.out.println("\nPedidos em espera (após processamento):");
        pedidoManager.visualizarPedidosEmEspera();

        System.out.println("\nCancelando pedido: " + pedido3.getDescricao());
        pedidoManager.cancelarPedido(pedido3);

        System.out.println("\nPedidos em espera (após cancelamento):");
        pedidoManager.visualizarPedidosEmEspera();

        System.out.println("\nProcessando os pedidos restantes:");
        while ((processado = pedidoManager.processarProximoPedido()) != null) {
            System.out.println("Pedido processado: " + processado.getDescricao());
        }

        System.out.println("\nPedidos em espera (final):");
        pedidoManager.visualizarPedidosEmEspera();
    }
}
