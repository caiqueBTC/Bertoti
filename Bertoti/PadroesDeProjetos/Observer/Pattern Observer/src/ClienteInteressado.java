public class ClienteInteressado implements ObservadorInteresse {
    private String nomeCliente;
    private SujeitoObservado produtoObservado;

    public ClienteInteressado(String nomeCliente, SujeitoObservado produto) {
        this.nomeCliente = nomeCliente;
        this.produtoObservado = produto;
        this.produtoObservado.registrarObservador(this);
    }

    @Override
    public void atualizar(String nomeProduto, String tipoNotificacao, Object valor) {
        System.out.print("Notificação para " + nomeCliente + " sobre o produto '" + nomeProduto + "': ");
        switch (tipoNotificacao) {
            case "PRECO_ALTERADO":
                System.out.println("O preço mudou para R$" + String.format("%.2f", (Double) valor));
                break;
            case "PRODUTO_DISPONIVEL":
                System.out.println("Está DISPONÍVEL em estoque! Quantidade: " + valor);
                break;
            case "PRODUTO_INDISPONIVEL":
                System.out.println("Está INDISPONÍVEL no momento.");
                break;
            case "ESTOQUE_ATUALIZADO":
                 System.out.println("Estoque atualizado para: " + valor + " unidades.");
                 break;
            default:
                System.out.println("Atualização desconhecida: " + tipoNotificacao + " com valor " + valor);
                break;
        }
    }

    public void pararDeReceberNotificacoes() {
        produtoObservado.removerObservador(this);
        System.out.println(nomeCliente + " não receberá mais notificações sobre " + ((ProdutoLoja)produtoObservado).getNomeProduto());
    }
}