import java.util.ArrayList;
import java.util.List;

public class KitPC implements ItemDeVenda {
    private String nomeDoKit;
    private List<ItemDeVenda> componentes = new ArrayList<>();

    public KitPC(String nomeDoKit) {
        this.nomeDoKit = nomeDoKit;
    }

    @Override
    public void adicionarItem(ItemDeVenda componente) {
        componentes.add(componente);
    }

    public void removerItem(ItemDeVenda componente) {
        componentes.remove(componente);
    }

    @Override
    public String getNome() {
        return nomeDoKit;
    }

    @Override
    public double getPreco() {
        double total = 0;
        for (ItemDeVenda componente : componentes) {
            total += componente.getPreco();
        }
        return total * 0.92; // 8% de desconto no kit
    }

    @Override
    public void listarItens() {
        System.out.println("\nKit PC: " + getNome() + " - Preço com desconto: R$" + String.format("%.2f", getPreco()));
        System.out.println("Componentes do Kit:");
        for (ItemDeVenda item : componentes) {
            System.out.print("- ");
            item.listarItens();
        }
    }
}