class FilaPedidos {
    private Pedido[] fila;
    private int inicio;
    private int fim;
    private int capacidadeMaxima;

    public FilaPedidos(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
        this.fila = new Pedido[capacidadeMaxima];
        this.inicio = 0;
        this.fim = 0;
    }

    public void adicionarPedido(Pedido pedido) {
        if (fim < capacidadeMaxima) {
            fila[fim++] = pedido;
        } else {
            System.out.println("A fila está cheia.");
        }
    }

    public Pedido processarPedido() {
        if (inicio < fim) {
            return fila[inicio++];
        }
        return null;
    }

    public void visualizarPedidos() {
        for (int i = inicio; i < fim; i++) {
            System.out.println("- " + fila[i].getDescricao());
        }
    }

    public void cancelarPedido(Pedido pedido) {
        for (int i = inicio; i < fim; i++) {
            if (fila[i] == pedido) {

                for (int j = i; j < fim - 1; j++) {
                    fila[j] = fila[j + 1];
                }
                fila[--fim] = null; 
                break;
            }
        }
    }

    public boolean isEmpty() {
        return inicio == fim;
    }
}