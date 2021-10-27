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
import vo.Veiculo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class BdVeiculo {

    public void insere(Veiculo Veiculo) {
        String sql = "insert into Veiculo(nome,serie,turma) values(?,?,?)";
        try {
            PreparedStatement ps = Bd.getCon().prepareStatement(sql);
            ps.setString(1, Veiculo.getNome());
            ps.setInt(2, Veiculo.getSerie());
            ps.setString(3, Veiculo.getTurma());
            ps.execute();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL: " + e.getMessage());
        }
    }

    public void salva(Veiculo Veiculo) {
        if (Veiculo.getCodigo() == 0) {
            insere(Veiculo);
        } else {
            String sql = "update Veiculo set nome=?,serie=?,turma=? where codigo=?";
            try {
                PreparedStatement ps = Bd.getCon().prepareStatement(sql);
                ps.setInt(4, Veiculo.getCodigo());
                ps.setString(1, Veiculo.getNome());
                ps.setInt(2, Veiculo.getSerie());
                ps.setString(3, Veiculo.getTurma());
                ps.execute();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro SQL: " + e.getMessage());
            }
        }
    }

    public Veiculo localiza(int codigo) {
        String sql = "select * from Veiculo where codigo=?";
        Veiculo registro = new Veiculo();
        try {
            PreparedStatement ps = Bd.getCon().prepareStatement(sql);
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                registro.setCodigo(rs.getInt("codigo"));
                registro.setNome(rs.getString("nome"));
                registro.setSerie(rs.getInt("serie"));
                registro.setTurma(rs.getString("turma"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL: " + e.getMessage());
        }
        return registro;
    }

    public List pesquisa(String busca) {
        String sql = "select * from Veiculo where nome like ?";
        List lista = new ArrayList();
        try {
            PreparedStatement ps = Bd.getCon().prepareStatement(sql);
            ps.setString(1, "%" + busca + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Veiculo registro = new Veiculo();
                registro.setCodigo(rs.getInt("codigo"));
                registro.setNome(rs.getString("nome"));
                registro.setSerie(rs.getInt("serie"));
                registro.setTurma(rs.getString("turma"));
                lista.add(registro);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL: " + e.getMessage());
        }
        return lista;
    }

    public void exclui(int codigo) {
        String sql = "delete from Veiculo where codigo=?";
        try {
            PreparedStatement ps = Bd.getCon().prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL: " + e.getMessage());
        }
    }
}