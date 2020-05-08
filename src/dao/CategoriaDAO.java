
package dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Categoria;


public class CategoriaDAO {
    Connection con = null;
    public CategoriaDAO(){
        con = new Conexao().conectar();
    }
    
    public String inserir(Categoria c){
        String status = "Categoria inserido com sucesso!";
        String sql = "INSERT INTO categoria (codigo, nome) values (?,?)";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, c.getCodigo());
            ps.setString(2, c.getNome());
            
            
            int n = ps.executeUpdate();
            if(n == 0){
                status = "Erro ao inserir";
            }
        }catch(Exception e){
            status = "Codigo já cadastrado!";
        }
        return status;
    }

    public ArrayList<Categoria> listar(){
        ArrayList<Categoria> categorias = new ArrayList();
        try{
            String sql = "SELECT * FROM categoria";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Categoria c = new Categoria();
                c.setCodigo(rs.getString(1));
                c.setNome(rs.getString(2));
                
                
                categorias.add(c);
            }
            return categorias;
        }catch(Exception e){
            return null;
        }
    }
    public String atualizar(Categoria c){
        String status = "Categoria atualizado com sucesso!";
        String sql = "UPDATE categoria SET nome = ? WHERE codigo = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, c.getNome());
            ps.setString(2, c.getCodigo());
            ps.executeUpdate();
            
        }catch(Exception e){
            status = "Erro ao atualizar o categoria";
        }
        return status;
    }
    
    public String excluir(Categoria c){
        String status = "Categoria excluída com sucesso!";
        try{
            String sql = "DELETE FROM categoria WHERE codigo = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, c.getCodigo());
            ps.executeUpdate();
        }catch(Exception e){
            status = e.getMessage();
        }
        return status;
    }
}
