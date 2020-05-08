
package dao;
import conexao.Conexao;
import java.sql.*;
import java.util.ArrayList;
import modelo.Estoque;

public class EstoqueDAO {
    Connection con = null;
    public EstoqueDAO(){
        con = new Conexao().conectar();
    }
    
    public String inserir(Estoque c){
        String status = "Cliente inserido com sucesso!";
        String sql = "INSERT INTO cliente (cpf, nome, telefone, endereco) values (?,?,?,?)";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, c.getCpf());
            ps.setString(2, c.getNome());
            ps.setString(3, c.getTelefone());
            ps.setString(4, c.getEndereco());
            
            int n = ps.executeUpdate();
            if(n == 0){
                status = "Erro ao inserir";
            }
        }catch(Exception e){
            status = "CPF já cadastrado!";
        }
        return status;
    }

    public ArrayList<Cliente> listar(){
        ArrayList<Cliente> clientes = new ArrayList();
        try{
            String sql = "SELECT * FROM cliente";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Cliente c = new Cliente();
                c.setCpf(rs.getString(1));
                c.setNome(rs.getString(2));
                c.setTelefone(rs.getString(3));
                c.setEndereco(rs.getString(4));
                
                clientes.add(c);
            }
            return clientes;
        }catch(Exception e){
            return null;
        }
    }
    public String atualizar(Cliente c){
        String status = "Cliente atualizado com sucesso!";
        String sql = "UPDATE cliente SET nome = ?, telefone = ?, endereco = ? WHERE cpf = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, c.getNome());
            ps.setString(2, c.getTelefone());
            ps.setString(3, c.getEndereco());
            ps.setString(4, c.getCpf());
            ps.executeUpdate();
            
        }catch(Exception e){
            status = "Erro ao atualizar o cliente";
        }
        return status;
    }
    
    public String excluir(Cliente c){
        String status = "Cliente excluído com sucesso!";
        try{
            String sql = "DELETE FROM cliente WHERE cpf = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, c.getCpf());
            ps.executeUpdate();
        }catch(Exception e){
            status = e.getMessage();
        }
        return status;
    }
}