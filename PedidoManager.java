public class PedidoManager {
    private FilaPedidos filaVip;
    private FilaPedidos filaNormal;

    public PedidoManager(int capacidadeMaxima) {
        this.filaVip = new FilaPedidos(capacidadeMaxima);
        this.filaNormal = new FilaPedidos(capacidadeMaxima);
    }

    public void adicionarPedido(Pedido pedido) {
        if (pedido.isVip()) {
            filaVip.adicionarPedido(pedido);
        } else {
            filaNormal.adicionarPedido(pedido);
        }
    }

    public Pedido processarProximoPedido() {
        if (!filaVip.isEmpty()) {
            return filaVip.processarPedido();
        } else if (!filaNormal.isEmpty()) {
            return filaNormal.processarPedido();
        }
        return null;
    }

    public void visualizarPedidosEmEspera() {
        System.out.println("Pedidos VIP em espera:");
        filaVip.visualizarPedidos();
        System.out.println("Pedidos normais em espera:");
        filaNormal.visualizarPedidos();
    }

    public void cancelarPedido(Pedido pedido) {
        if (pedido.isVip()) {
            filaVip.cancelarPedido(pedido);
        } else {
            filaNormal.cancelarPedido(pedido);
        }
    }
}