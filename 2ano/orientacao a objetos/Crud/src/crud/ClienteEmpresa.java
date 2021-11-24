package crud;
public class ClienteEmpresa extends Cliente {

    private String Ie;
    private String Cnpj;

    public ClienteEmpresa(String _nome, String _fone, String _Ie, String _Cnpj) {
        super(_nome, _fone);
        this.Ie = _Ie;
        this.Cnpj = _Cnpj;
    }
    public String getIe() {
        return Ie;
    }

    public void setIe(String Ie) {
        this.Ie = Ie;
    }

    public String getCnpj() {
        return Cnpj;
    }

    public void setCnpj(String Cnpj) {
        this.Cnpj = Cnpj;
    }
}
