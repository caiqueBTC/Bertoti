public interface SujeitoObservado {
    void registrarObservador(ObservadorInteresse o);
    void removerObservador(ObservadorInteresse o);
    void notificarObservadores(String tipoNotificacao, Object valor);
}