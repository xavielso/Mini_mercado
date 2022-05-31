
package Dao;
import entity.Produto;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.util.logging.PlatformLogger;
import Main.Main;
public class ProdutoDao {
    private Connections conexao;

    public Connections getConexao() {
        return conexao;
    }

    public void setConexao(Connections conexao) {
        this.conexao = conexao;
    }
    
    public ProdutoDao(){
    conexao = new Connections();
}
    public void insert (Produto produto){
        try {
            conexao.conectar("127.0.0.1");
            PreparedStatement pst = conexao.getConexao().prepareStatement("insert into produto"
                    + "(descricao_produto,preco_compra, preco_venda) values (?,?,?)");
                    pst.setString(1,produto.getDescricao_produto().toUpperCase());
                    pst.executeUpdate();
                    conexao.confirmar();
                    pst.close();
                    conexao.fechar();
                    
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).
                    log(Level.SEVERE, null,ex );
        }
           
}
             public void update(Produto produto){
                 try {
                     conexao.conectar("127.0.0.1");
                     PreparedStatement pst = conexao.getConexao()
                             .prepareStatement("update produto set descricao_produto = ?"
                             + "where cod_produto = ?");
                 } catch (Exception e) {
                 }
   
             }
            
    }
    
    
    
