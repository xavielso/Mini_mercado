
package Dao;
import entity.Endereco;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Dao.Connections;
import Main.Main;

public class EnderecoDao {
 private Connections conexao;

    public Connections getConexao(){
        return this.conexao;
    }
    
    public EnderecoDao() {
        conexao = new Connections();
    }
    
    public void insert(Endereco Endereco) {
        try {
            conexao.conectar("127.0.0.1");
            PreparedStatement pst = conexao.getConexao().
                    prepareStatement("insert into endereco"
                            + "(rua,bairro,cidade,estado,complemento,cep) values (?,?,?,?,?,?)");
            pst.setString(1, Endereco.getRua().toUpperCase());
            pst.executeUpdate();
            conexao.confirmar();
            pst.close();
            conexao.fechar();
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

    public void update(Endereco endereco) {
        try {
            conexao.conectar("127.0.0.1");
            PreparedStatement pst = conexao.getConexao().prepareStatement("update endereco set desc_categoria = ? where cod_categoria = ?");
            pst.setString(1, endereco.getRua().toUpperCase());
            pst.setString(2, endereco.getBairro());
            pst.setString(3, endereco.getCidade().toUpperCase());
            pst.setString(4, endereco.getEstado().toUpperCase());
            pst.setString(5, endereco.getComplemento().toUpperCase());
            pst.setString(6, endereco.getCep().toUpperCase());
            pst.setInt(7, endereco.getCod_endereco());
            pst.executeUpdate();
            conexao.confirmar();
            pst.close();
            conexao.fechar();
        } catch (Exception ex) {
            Logger.getLogger(EnderecoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void delete(Endereco endereco) {
        try {
            conexao.conectar("127.0.0.1");
            PreparedStatement pst = conexao.getConexao().prepareStatement("delete from endereco where rua = ?");
            pst.setString(1, endereco.getRua());
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
            PreparedStatement pst = conexao.getConexao().prepareStatement("select cod_endereco, rua, bairro, cidade, estado,"
                    + " complemento, cep from endereco where rua like ?");
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
