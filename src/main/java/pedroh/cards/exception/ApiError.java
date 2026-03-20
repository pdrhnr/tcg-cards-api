package pedroh.cards.exception;

public class ApiError {

    private String erro;
    private String detalhes;

    public ApiError(String erro, String detalhes) {
        this.erro = erro;
        this.detalhes = detalhes;
    }

    public String getErro() {
        return erro;
    }

    public String getDetalhes() {
        return detalhes;
    }
}