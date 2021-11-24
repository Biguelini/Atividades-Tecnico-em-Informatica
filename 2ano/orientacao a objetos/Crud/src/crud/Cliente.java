package crud;
public class Cliente {

    private String nome;
    private String fone;

    public Cliente(String _nome, String _fone) {
        this.nome = _nome;
        this.fone = _fone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }
    public void salvar(){
        System.out.println("Salvo");
    }
    public void editar(){
        System.out.println("Editado");
    }
    public void excluir(){
        System.out.println("Excluído");
    }
    public String ler(){
        System.out.println("Lendo...");
        return "Cliente";
    }
}
