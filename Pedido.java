class Pedido {
    private String descricao;
    private boolean isVip;

    public Pedido(String descricao, boolean isVip) {
        this.descricao = descricao;
        this.isVip = isVip;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isVip() {
        return isVip;
    }
}