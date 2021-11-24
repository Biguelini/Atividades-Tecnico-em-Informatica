package crud;
public class ClientePessoa extends Cliente {
    private String Rg;
    private String Cpf;

    public ClientePessoa(String _nome, String _fone, String _Rg, String _Cpf) {
        super(_nome, _fone);
        this.Rg = _Rg;
        this.Cpf = _Cpf;
    }

    public String getRg() {
        return Rg;
    }

    public void setRg(String Rg) {
        this.Rg = Rg;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String Cpf) {
        this.Cpf = Cpf;
    }

}
