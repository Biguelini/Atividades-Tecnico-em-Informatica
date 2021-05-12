/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

/**
 *
 * @author 2info2021
 */
import vo.Equipamento;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class BdEquipamentos {

    public void insere(Equipamento equipamento) {
        String sql = "insert into produtos(id,descricao,fabricante,numserie,numpatrimonio,localizacao) values(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = Bd.getCon().prepareStatement(sql);
            ps.setInt(1, equipamento.getId());
            ps.setString(2, equipamento.getDescricao());
            ps.setString(3, equipamento.getFabricante());
            ps.setString(4, equipamento.getNumserie());
            ps.setInt(5, equipamento.getNumpatrimonio());
            ps.setString(6, equipamento.getLocalizacao());
            ps.execute();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL: " + e.getMessage());
        }
    }

    public void salva(Equipamento equipamento) {
        if (equipamento.getId() == 0) {
            insere(equipamento);
        } else {
            String sql = "update produtos set descricao=?,fabricante=?, numserie=?, numpatrimonio=?, localizacao=? where id=?";
            try {
                PreparedStatement ps = Bd.getCon().prepareStatement(sql);
                ps.setInt(6, equipamento.getId());
                ps.setString(1, equipamento.getDescricao());
                ps.setString(2, equipamento.getFabricante());
                ps.setString(3, equipamento.getNumserie());
                ps.setInt(4, equipamento.getNumpatrimonio());
                ps.setString(5, equipamento.getLocalizacao());
                ps.execute();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro SQL: " + e.getMessage());
            }
        }
    }

    public Equipamento localiza(int id) {
        String sql = "select * from produtos where id=?";
        Equipamento registro = new Equipamento();
        try {
            PreparedStatement ps = Bd.getCon().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                registro.setId(rs.getInt("id"));
                registro.setDescricao(rs.getString("descricao"));
                registro.setFabricante(rs.getString("fabricante"));
                registro.setNumserie(rs.getString("numserie"));
                registro.setNumpatrimonio(rs.getInt("numpatrimonio"));
                registro.setLocalizacao(rs.getString("localizacao"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL: " + e.getMessage());
        }
        return registro;
    }

    public List pesquisa(String busca) {
        String sql = "select * from produtos where descricao like ?";
        List lista = new ArrayList();
        try {
            PreparedStatement ps = Bd.getCon().prepareStatement(sql);
            ps.setString(1, "%" + busca + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Equipamento registro = new Equipamento();
                registro.setId(rs.getInt("id"));
                registro.setDescricao(rs.getString("descricao"));
                registro.setFabricante(rs.getString("fabricante"));
                registro.setNumserie(rs.getString("numserie"));
                registro.setNumpatrimonio(rs.getInt("numpatrimonio"));
                registro.setLocalizacao(rs.getString("localizacao"));
                lista.add(registro);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL: " + e.getMessage());
        }
        return lista;
    }

    public void exclui(int id) {
        String sql = "delete from produtos where id=?";
        try {
            PreparedStatement ps = Bd.getCon().prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL: " + e.getMessage());
        }
    }
}
