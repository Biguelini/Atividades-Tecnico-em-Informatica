/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

/**
 *
 * @author JP
 */
public class ClienteEmpresa extends Cliente {
    private String Ie;
    private String Cnpj;

    public ClienteEmpresa(String _nome, String _fone, String _Ie, String _Cnpj) {
        super(_nome, _fone);
        this.Ie = _Ie;
        this.Cnpj = _Cnpj;
    }
}
