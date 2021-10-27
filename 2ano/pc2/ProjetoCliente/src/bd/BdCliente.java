/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import vo.Cliente;

/**
 *
 * @author JP
 */
public class BdCliente {
    public void insere(Cliente cliente) {
        String sql = "insert into clientes (codigo,nome,endereco,cidade,uf,telefone,renda) values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = Bd.getCon().prepareStatement(sql);
            ps.setInt(1, cliente.getCodigo());
            ps.setString(2, cliente.getNome());
            ps.setString(3, cliente.getEndereco());
            ps.setString(4, cliente.getCidade());
            ps.setString(5, cliente.getUf());
            ps.setString(6, cliente.getTelefone());
            ps.setDouble(7, cliente.getRenda());
            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL: " + e.getMessage());
        }
    }
    public void atualiza(Cliente cliente) {
        String sql = "update clientes set nome=?, endereco=?, cidade=?, uf=?, telefone=?, renda=? where codigo=?";
        try {
            PreparedStatement ps = Bd.getCon().prepareStatement(sql);
            ps.setInt(7, cliente.getCodigo());
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEndereco());
            ps.setString(3, cliente.getCidade());
            ps.setString(4, cliente.getUf());
            ps.setString(5, cliente.getTelefone());
            ps.setDouble(6, cliente.getRenda());
            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL: " + e.getMessage());
        }
    }
    public Cliente localiza(String codigo) {
        String sql = "select * from clientes where codigo=?";

        Cliente registro = new Cliente();
        try {
            PreparedStatement ps = Bd.getCon().prepareStatement(sql);
            ps.setString(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                registro.setCodigo(rs.getInt("codigo"));
                registro.setNome(rs.getString("nome"));
                registro.setEndereco(rs.getString("endereco"));
                registro.setCidade(rs.getString("cidade"));
                registro.setUf(rs.getString("uf"));
                registro.setTelefone(rs.getString("telefone"));
                registro.setRenda(rs.getDouble("renda"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL: " + e.getMessage());
        }
        return registro;
    }

    public void exclui(Integer codigo) {
        String sql = "delete from clientes where codigo=?";
        try {
            PreparedStatement ps = Bd.getCon().prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL: " + e.getMessage());
        }
    }
}
