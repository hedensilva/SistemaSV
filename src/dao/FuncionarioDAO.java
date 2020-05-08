package dao;
import conexao.Conexao;
import java.sql.*;
import java.util.ArrayList;
import modelo.Funcionario;

public class FuncionarioDAO {
    Connection con = null;
    public FuncionarioDAO(){
        con = new Conexao().conectar();
    }
    
    public String inserir(Funcionario c){
        String status = "Funcionario inserido com sucesso!";
        String sql = "INSERT INTO funcionario (cpf, nome, sexo, telefone, endereco, salario) values (?,?,?,?,?,?)";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, c.getCpf());
            ps.setString(2, c.getNome());
            ps.setString(3, c.getSexo());
            ps.setString(4, c.getTelefone());
            ps.setString(5, c.getEndereco());
            ps.setDouble(6, c.getSalario());
            
            int n = ps.executeUpdate();
            if(n == 0){
                status = "Erro ao inserir";
            }
        }catch(Exception e){
            status = "CPF já cadastrado!";
        }
        return status;
    }

    public ArrayList<Funcionario> listar(){
        ArrayList<Funcionario> funcionarios = new ArrayList();
        try{
            String sql = "SELECT * FROM funcionario";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Funcionario c = new Funcionario();
                c.setCpf(rs.getString(1));
                c.setNome(rs.getString(2));
                c.setSexo(rs.getString(3));
                c.setTelefone(rs.getString(4));
                c.setEndereco(rs.getString(5));
                c.setSalario(rs.getDouble(6));
                
                funcionarios.add(c);
            }
            return funcionarios;
        }catch(Exception e){
            return null;
        }
    }
    public String atualizar(Funcionario c){
        String status = "Funcionario atualizado com sucesso!";
        String sql = "UPDATE funcionario SET nome = ?, sexo = ?, telefone = ?, endereco = ?, salario = ? WHERE cpf = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, c.getNome());
            ps.setString(2, c.getSexo());
            ps.setString(3, c.getTelefone());
            ps.setString(4, c.getEndereco());
            ps.setDouble(5, c.getSalario());
            ps.setString(6, c.getCpf());
            ps.executeUpdate();
            
            
        }catch(Exception e){
            status = "Erro ao atualizar o funcionario";
        }
        return status;
    }
    
    public String excluir(Funcionario c){
        String status = "Funcionario excluído com sucesso!";
        try{
            String sql = "DELETE FROM funcionario WHERE cpf = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, c.getCpf());
            ps.executeUpdate();
        }catch(Exception e){
            status = e.getMessage();
        }
        return status;
    }
}