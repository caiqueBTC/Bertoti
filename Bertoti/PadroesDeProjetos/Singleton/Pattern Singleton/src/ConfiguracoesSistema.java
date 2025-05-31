public class ConfiguracoesSistema {
    
    private static ConfiguracoesSistema instancia;

    private String modoAplicacao;

    private ConfiguracoesSistema() {
        this.modoAplicacao = "Produção"; 
    }


    public static ConfiguracoesSistema getInstancia() {
        if (instancia == null) {
            instancia = new ConfiguracoesSistema();
        }
        return instancia;
    }

    
    public String getModoAplicacao() {
        return modoAplicacao;
    }

    public void setModoAplicacao(String novoModo) {
        this.modoAplicacao = novoModo;
    }
}
