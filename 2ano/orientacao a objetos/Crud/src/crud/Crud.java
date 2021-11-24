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
public class Crud {

    public static void main(String[] args) {
        Cliente c = new Cliente("João", "99349909");
        ClientePessoa cp = new ClientePessoa("João", "99349909", "000000000","000000000");
        ClienteEmpresa ce = new ClienteEmpresa("Pastelaria do Zé", "70707070", "000000000","000000000");
    }
    
}
