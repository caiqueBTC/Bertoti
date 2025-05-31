public interface ItemDeVenda {
    String getNome();
    double getPreco();
    void adicionarItem(ItemDeVenda item) throws UnsupportedOperationException;
    void removerItem(ItemDeVenda item) throws UnsupportedOperationException;
    void listarItens();
}