/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Thiago
 */
public class Connections {
     
    Connection conexao;
    
    public Connection getConexao(){
        return conexao;
    }
    
    public boolean conectar(String url) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        
        conexao = DriverManager.getConnection(
                "jdbc:mysql://" + url + "/pbancodados", "root", "");
        
        conexao.setAutoCommit(false);
        conexao.setTransactionIsolation(
                Connection.TRANSACTION_READ_COMMITTED);
        return true;
    }
    
    public boolean fechar(){
        try{
            conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean confirmar(){
        try{
            conexao.commit();
        } catch(SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean cancelar(){
        try{
            conexao.rollback();
        } catch(SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
}
