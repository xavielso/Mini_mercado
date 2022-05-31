
package Dao;

import entity.Funcionario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Dao.Connections;
import Main.Main;

public class FuncionarioDao {
    private Connections conexao;

    public Connections getConexao(){
        return this.conexao;
    }
    
    public FuncionarioDao() {
        conexao = new Connections();
    }
    
    public void insert(Funcionario funcionario) {
        try {
            conexao.conectar("127.0.0.1");
            PreparedStatement pst = conexao.getConexao().
                    prepareStatement("insert into funcionario"
                            + "(nome_funcionario,setor,salario) values (?,?,?)");
            pst.setString(1, funcionario.getNome_funcionario().toUpperCase());
            pst.executeUpdate();
            conexao.confirmar();
            pst.close();
            conexao.fechar();
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

    public void update(Funcionario funcionario) {
        try {
            conexao.conectar("127.0.0.1");
            PreparedStatement pst = conexao.getConexao().prepareStatement("update funcionario set nome_funcionario = ? where cod_funcionario = ?");
            pst.setString(1, funcionario.getNome_funcionario().toUpperCase());
            pst.setString(2, funcionario.getSetor());
            pst.setFloat(3, funcionario.getSalario());
            pst.setInt(4, funcionario.getCod_funcionario());
            pst.executeUpdate();
            conexao.confirmar();
            pst.close();
            conexao.fechar();
        } catch (Exception ex) {
            Logger.getLogger(EnderecoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void delete(Funcionario funcionario) {
        try {
            conexao.conectar("127.0.0.1");
            PreparedStatement pst = conexao.getConexao().prepareStatement("delete from funcionario where nome_funcionario = ?");
            pst.setString(1, funcionario.getNome_funcionario());
            pst.executeUpdate();
            conexao.confirmar();
            pst.close();
            conexao.fechar();
        } catch (Exception ex) {
            Logger.getLogger(EnderecoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public ResultSet query(String str){
        try {
            conexao.conectar("127.0.0.1");
            PreparedStatement pst = conexao.getConexao().prepareStatement("select cod_funcionario, nome_funcionario, salario, setor, "
                    +"from funcionario where nome_funcionario like ?");
            pst.setString(1, "%"+str+"%");
            ResultSet rs = pst.executeQuery();
            if(!rs.next()){
                JOptionPane.showMessageDialog(null, "Nenhum registro encontrado!!", "ERRO",JOptionPane.ERROR_MESSAGE);
            }
            return rs;
        } catch (Exception ex) {
            Logger.getLogger(EnderecoDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }        
    }
}
