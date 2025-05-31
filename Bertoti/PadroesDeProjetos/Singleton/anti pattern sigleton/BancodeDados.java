public class BancodeDados {
    private static BancoDeDados instancia;

    private BancoDeDados() {}

    public static BancoDeDados getInstancia() {
        if (instancia == null) {
            instancia = new BancoDeDados();
        }
        return instancia;
    }

    public String buscarDados() {
        return "Dados reais do banco de dados";
    }
}
