/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import vo.Dependentes;

/**
 *
 * @author JP
 */
public class BdDependente {
    public void insere(Dependentes dependente){
        String sql = "insert into dependente(nome,idade,idSocio) values (?,?,?)";
        try{
            PreparedStatement ps = Bd.getCon().prepareStatement(sql);
            ps.setString(1, dependente.getNome());
            ps.setInt(2, dependente.getIdade());
            ps.setInt(3, dependente.getIdSocio());
            ps.execute();
        } catch (SQLException e){
            System.out.println("Erro SQL: "+ e.getMessage());
        }
        
    }
    public void salva(Dependentes dependente){
        if(dependente.getId()== 0){
            insere(dependente);
        }else{
            String sql = "update dependente set nome=?,idade=?,idSocio=? where id=?";
            try{
                PreparedStatement ps = Bd.getCon().prepareStatement(sql);
                ps.setInt(4,dependente.getId());
                ps.setString(1,dependente.getNome());
                ps.setInt(2,dependente.getIdade());
                ps.setInt(3,dependente.getIdSocio());
                ps.execute();
            } catch (SQLException e){
                System.out.println("Erro SQL: "+ e.getMessage());
            }
        }
    }
    public Dependentes localiza(int id){
        String sql = "select * from dependente where id=?";
        Dependentes registro = new Dependentes();
        try{
            PreparedStatement ps = Bd.getCon().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                registro.setId(rs.getInt("id"));
                registro.setNome(rs.getString("nome"));
                registro.setIdade(rs.getInt("idade"));
                registro.setIdSocio(rs.getInt("idSocio"));
            }
        } catch (SQLException e){
            System.out.println("Erro SQL: "+ e.getMessage());
        }
        return registro;
    }
    public List pesquisa(String busca){
        String sql = "select * from dependente where nome like ?";
        List lista = new ArrayList();
        try {
            PreparedStatement ps = Bd.getCon().prepareStatement(sql);
            ps.setString(1, "%"+busca+"%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Dependentes registro = new Dependentes();
                registro.setId(rs.getInt("id"));
                registro.setNome(rs.getString("nome"));
                registro.setIdade(rs.getInt("idade"));
                registro.setIdSocio(rs.getInt("idSocio"));
                lista.add(registro);
            }
        } catch (SQLException e){
            System.out.println("Erro SQL: "+ e.getMessage());
        }
        return lista;
    }
    public void exclui(int id){
        String sql = "delete from dependente where id=?";
        try{
            PreparedStatement ps = Bd.getCon().prepareStatement(sql);
            ps.setInt(1,id);
            ps.execute();
        } catch (SQLException e){
            System.out.println("Erro SQL: "+ e.getMessage());
        }
    }
}
