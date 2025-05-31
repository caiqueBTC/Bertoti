// Original: ItemIndividual.java
public class ComponentePCUnitario implements ItemDeVenda {
    private String nome;
    private double preco;

    public ComponentePCUnitario(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public double getPreco() {
        return preco;
    }

    @Override
    public void adicionarItem(ItemDeVenda item) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Não é possível adicionar item a um ComponentePCUnitario.");
    }

    @Override
    public void removerItem(ItemDeVenda item) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Não é possível remover item de um ComponentePCUnitario.");
    }

    @Override
    public void listarItens() {
        System.out.println("Componente: " + getNome() + " - Preço: R$" + getPreco());
    }
}