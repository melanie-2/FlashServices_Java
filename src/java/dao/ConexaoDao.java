package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDao {
    
    /**
     * Fazer a conexão com o bd
     * @return 
     */
    public static Connection getConnection(){
    Connection con = null;
    try{
        Class.forName("com.mysql.jdbc.Driver");       
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/flashservices","root","");
    }catch(ClassNotFoundException | SQLException erro){
        System.out.println(erro);
    }
        return con;
    
    }
}
