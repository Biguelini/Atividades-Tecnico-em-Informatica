/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

/**
 *
 * @author JP
 */
import vo.Disciplina;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class BdDisciplina {

    public void insere(Disciplina disciplina) {
        String sql = "insert into disciplina(nome,ch,professor) values(?,?,?)";
        try {
            PreparedStatement ps = Bd.getCon().prepareStatement(sql);
            ps.setString(1, disciplina.getNome());
            ps.setInt(2, disciplina.getCh());
            ps.setString(3, disciplina.getProfessor());
            ps.execute();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL: " + e.getMessage());
        }
    }

    public void salva(Disciplina disciplina) {
        if (disciplina.getCodigo() == 0) {
            insere(disciplina);
        } else {
            String sql = "update disciplina set nome=?,ch=?,professor=? where codigo=?";
            try {
                PreparedStatement ps = Bd.getCon().prepareStatement(sql);
                ps.setInt(4, disciplina.getCodigo());
                ps.setString(1, disciplina.getNome());
                ps.setInt(2, disciplina.getCh());
                ps.setString(3, disciplina.getProfessor());
                ps.execute();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro SQL: " + e.getMessage());
            }
        }
    }

    public Disciplina localiza(int codigo) {
        String sql = "select * from disciplina where codigo=?";
        Disciplina registro = new Disciplina();
        try {
            PreparedStatement ps = Bd.getCon().prepareStatement(sql);
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                registro.setCodigo(rs.getInt("codigo"));
                registro.setNome(rs.getString("nome"));
                registro.setCh(rs.getInt("ch"));
                registro.setProfessor(rs.getString("professor"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL: " + e.getMessage());
        }
        return registro;
    }

    public List pesquisa(String busca) {
        String sql = "select * from disciplina where nome like ?";
        List lista = new ArrayList();
        try {
            PreparedStatement ps = Bd.getCon().prepareStatement(sql);
            ps.setString(1, "%" + busca + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Disciplina registro = new Disciplina();
                registro.setCodigo(rs.getInt("codigo"));
                registro.setNome(rs.getString("nome"));
                registro.setCh(rs.getInt("ch"));
                registro.setProfessor(rs.getString("professor"));
                lista.add(registro);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL: " + e.getMessage());
        }
        return lista;
    }

    public void exclui(int codigo) {
        String sql = "delete from disciplina where codigo=?";
        try {
            PreparedStatement ps = Bd.getCon().prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL: " + e.getMessage());
        }
    }
}
