/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Profissional;
import classes.Servico;
import classes.Usuario;
import static dao.ConexaoDao.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * classe de profissional
 * @author aluno
 */
public class ProfissionalDao {
    
    /**
     * Selecionar todos os profissionais do bd
     * @return 
     */
    public static List<Profissional> getProfissionais() {
    List<Profissional> list = new ArrayList<Profissional>();
    
    try{
        Connection con = getConnection(); 
        PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM profissional INNER JOIN usuario ON profissional.usuario_id = usuario.id INNER JOIN servico ON profissional.servico_id = servico.id");
        ResultSet rs = ps.executeQuery(); 
        
        while(rs.next()){
            Profissional profissional = new Profissional();
            profissional.setId(rs.getInt("id"));
            profissional.setNome(rs.getString("nome"));
            profissional.setServico(rs.getString("servico"));
            profissional.setUsuario_Id(rs.getInt("usuario_id"));
            profissional.setServico_Id(rs.getInt("servico_id"));
            list.add(profissional);
        }
    }catch(Exception erro){
        System.out.println(erro);
    }
    return list;
    }
        
        /**
         * cadastrar profissionais
         * @param profissional_numero
         * @param servico_id
         * @return 
         */
public static int cadastrarProfissional(int profissional_numero, int servico_id){
       int status = 0;  
   try{
        Connection con = getConnection();
        PreparedStatement ps = (PreparedStatement) con.prepareStatement("INSERT INTO PROFISSIONAL(USUARIO,SERVICO_ID) VALUES(?,?)");
           int profissional_usuario = 0;
        ps.setInt(1, profissional_usuario);
        ps.setInt(2, servico_id);        
        status = ps.executeUpdate();
    }catch(Exception erro){
        System.out.println(erro);
    }      
       return status;
   }


/**
 * gráfico de tipos de serviço
 * @return 
 */
public static int[] getRelatoriosServico() {

        int[] valores = {0, 0, 0, 0, 0, 0};
        
        try{
            Connection con = getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT count(servico_id) AS Construcao FROM profissional WHERE (servico_id = 25) OR (servico_id = 31) OR (servico_id = 33) OR (servico_id = 37) OR (servico_id = 38) OR (servico_id = 40) OR (servico_id = 41) OR (servico_id = 43) OR (servico_id = 46)");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                valores[0] = rs.getInt("Construcao");
            }   
 
            ps = (PreparedStatement) con.prepareStatement("SELECT count(servico_id) AS Gerais FROM profissional WHERE (servico_id = '11') OR (servico_id = '17') OR (servico_id = '18') OR (servico_id = '20') OR (servico_id = '21') OR (servico_id = '23') OR (servico_id = '27') OR (servico_id = '28') OR (servico_id = '32') OR (servico_id = '34') OR (servico_id = '39') OR (servico_id = '41') OR (servico_id = '44') OR (servico_id = '45') OR (servico_id = '47')");
            rs = ps.executeQuery();
            while(rs.next()){
                valores[1] = rs.getInt("Gerais");
            }            
            
            ps = (PreparedStatement) con.prepareStatement("SELECT count(servico_id) AS Tecnologia FROM profissional WHERE (servico_id = 2) OR (servico_id = 3) OR (servico_id = 6) OR (servico_id = 8) OR (servico_id = 10) OR (servico_id = 22) OR (servico_id = 36) OR (servico_id = 48)");
            rs = ps.executeQuery();
            while(rs.next()){
                valores[2] = rs.getInt("Tecnologia");
            }
            
            ps = (PreparedStatement) con.prepareStatement("SELECT count(servico_id) AS Estética FROM profissional WHERE (servico_id = 13) OR (servico_id = 26) OR (servico_id = 35) OR (servico_id = 49) OR (servico_id = 50) OR (servico_id = 51)");
            rs = ps.executeQuery();
            while(rs.next()){
                valores[3] = rs.getInt("Estética");
            }
            
            ps = (PreparedStatement) con.prepareStatement("SELECT count(servico_id) AS Técnicos FROM profissional WHERE (servico_id = 4) OR (servico_id = 5) OR (servico_id = 7) OR (servico_id = 9) OR (servico_id = 24)");
            rs = ps.executeQuery();
            while(rs.next()){
                valores[4] = rs.getInt("Técnicos");
            }
            
            ps = (PreparedStatement) con.prepareStatement("SELECT count(servico_id) AS Eventos FROM profissional WHERE (servico_id = 1) OR (servico_id = 12) OR (servico_id = 14) OR (servico_id = 15) OR (servico_id = 16) OR (servico_id = 19) OR (servico_id = 29) OR (servico_id = 30)");
            rs = ps.executeQuery();
            while(rs.next()){
                valores[5] = rs.getInt("Eventos");
            } 
        }catch(Exception erro){
            System.out.println(erro);
        }
        return valores;
    }
    
}

