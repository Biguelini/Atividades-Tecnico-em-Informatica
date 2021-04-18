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
import vo.Socios;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class BdSocio {
    public void insere(Socios socio){
        String sql = "insert into socio(nome,endereco,numero,cidade,uf,telefone) values (?,?,?,?,?,?)";
        try{
            PreparedStatement ps = Bd.getCon().prepareStatement(sql);
            ps.setString(1, socio.getNome());
            ps.setString(2, socio.getEndereco());
            ps.setString(3, socio.getNumero());
            ps.setString(4, socio.getCidade());
            ps.setString(5, socio.getUf());
            ps.setString(6, socio.getTelefone());
            ps.execute();
        } catch (SQLException e){
            System.out.println("Erro SQL: "+ e.getMessage());
        }
        
    }
    public void salva(Socios socio){
        if(socio.getId()== 0){
            insere(socio);
        }else{
            String sql = "update socio set nome=?,endereco=?,numero=?,cidade=?,uf=?,telefone=? where id=?";
            try{
                PreparedStatement ps = Bd.getCon().prepareStatement(sql);
                ps.setInt(7,socio.getId());
                ps.setString(1,socio.getNome());
                ps.setString(2,socio.getEndereco());
                ps.setString(3,socio.getNumero());
                ps.setString(4,socio.getCidade());
                ps.setString(5,socio.getUf());
                ps.setString(6,socio.getTelefone());
                ps.execute();
            } catch (SQLException e){
                System.out.println("Erro SQL: "+ e.getMessage());
            }
        }
    }
    public Socios localiza(int id){
        String sql = "select * from socio where id=?";
        Socios registro = new Socios();
        try{
            PreparedStatement ps = Bd.getCon().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                registro.setId(rs.getInt("id"));
                registro.setNome(rs.getString("nome"));
                registro.setEndereco(rs.getString("endereco"));
                registro.setNumero(rs.getString("numero"));
                registro.setCidade(rs.getString("cidade"));
                registro.setUf(rs.getString("uf"));
                registro.setTelefone(rs.getString("telefone"));
            }
        } catch (SQLException e){
            System.out.println("Erro SQL: "+ e.getMessage());
        }
        return registro;
    }
    public List pesquisa(String busca){
        String sql = "select * from socio where nome like ?";
        List lista = new ArrayList();
        try {
            PreparedStatement ps = Bd.getCon().prepareStatement(sql);
            ps.setString(1, "%"+busca+"%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Socios registro = new Socios();
                registro.setId(rs.getInt("id"));
                registro.setNome(rs.getString("nome"));
                registro.setEndereco(rs.getString("endereco"));
                registro.setNumero(rs.getString("numero"));
                registro.setCidade(rs.getString("cidade"));
                registro.setUf(rs.getString("uf"));
                registro.setTelefone(rs.getString("telefone"));
                lista.add(registro);
            }
        } catch (SQLException e){
            System.out.println("Erro SQL: "+ e.getMessage());
        }
        return lista;
    }
    public void exclui(int id){
        String sql = "delete from socio where id=?";
        try{
            PreparedStatement ps = Bd.getCon().prepareStatement(sql);
            ps.setInt(1,id);
            ps.execute();
        } catch (SQLException e){
            System.out.println("Erro SQL: "+ e.getMessage());
        }
    }
}
