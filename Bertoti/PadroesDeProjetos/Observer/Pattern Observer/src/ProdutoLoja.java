import java.util.ArrayList;
import java.util.List;

public class ProdutoLoja implements SujeitoObservado {
    private List<ObservadorInteresse> observadores = new ArrayList<>();
    private String nomeProduto;
    private double preco;
    private int estoque;

    public ProdutoLoja(String nomeProduto, double precoInicial, int estoqueInicial) {
        this.nomeProduto = nomeProduto;
        this.preco = precoInicial;
        this.estoque = estoqueInicial;
    }

    public void setPreco(double novoPreco) {
        if (this.preco != novoPreco) {
            this.preco = novoPreco;
            notificarObservadores("PRECO_ALTERADO", novoPreco);
        }
    }

    public void setEstoque(int novoEstoque) {
        if (this.estoque != novoEstoque) {
            int estoqueAnterior = this.estoque;
            this.estoque = novoEstoque;
            if (novoEstoque > 0 && estoqueAnterior == 0) { 
                 notificarObservadores("PRODUTO_DISPONIVEL", novoEstoque);
            } else if (novoEstoque == 0) {
                 notificarObservadores("PRODUTO_INDISPONIVEL", novoEstoque);
            } else {
                 notificarObservadores("ESTOQUE_ATUALIZADO", novoEstoque);
            }
        }
    }

    @Override
    public void registrarObservador(ObservadorInteresse o) {
        observadores.add(o);
    }

    @Override
    public void removerObservador(ObservadorInteresse o) {
        observadores.remove(o);
    }

    @Override
    public void notificarObservadores(String tipoNotificacao, Object valor) {
        for (ObservadorInteresse o : observadores) {
            o.atualizar(this.nomeProduto, tipoNotificacao, valor);
        }
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public double getPreco() {
        return preco;
    }

    public int getEstoque() {
        return estoque;
    }
}