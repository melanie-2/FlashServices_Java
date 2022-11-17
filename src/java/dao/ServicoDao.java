package dao;

import classes.Servico;
import static dao.ConexaoDao.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * classe de servico
 * @author FlashService
 */
public class ServicoDao {
    
    /**
     * pegar todos os serviços
     * @return 
     */
    public static List<Servico> getServicos() {
        List<Servico> list = new ArrayList<Servico>();   

        try{
            Connection con = getConnection(); 
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM servico");
            ResultSet rs = ps.executeQuery(); 

            while(rs.next()){
                Servico servico = new Servico();
                servico.setId(rs.getInt("id"));
                servico.setServico(rs.getString("servico"));
                list.add(servico);
            }
            
        }catch(Exception erro){
            System.out.println(erro);
        }
        return list;
    }
    
    /**
     * pegar todos os serviços para a paginação
     * @param start
     * @param total
     * @return 
     */
    public static List<Servico> getServicos(int start, int total) {
        List<Servico> list = new ArrayList<Servico>();   

        try{
            Connection con = getConnection(); 
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM servico LIMIT "+(start-1)+","+total);
            ResultSet rs = ps.executeQuery(); 

            while(rs.next()){
                Servico servico = new Servico();
                servico.setId(rs.getInt("id"));
                servico.setServico(rs.getString("servico"));
                list.add(servico);
            }
            
        }catch(Exception erro){
            System.out.println(erro);
        }
        return list;
    }

    /**
     * selecionar tudo de serviços para relatorio
     * @return 
     */
    public static List<Servico> getRelatorio() {
    List<Servico> list = new ArrayList<Servico>();
    try{
        Connection con = getConnection();
        PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM servico");
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Servico servico = new Servico();
            servico.setId(rs.getInt("id"));
            servico.setServico(rs.getString("servico"));
            list.add(servico);
        }       
    }catch(Exception erro){
        System.out.println(erro);
    }
    return list;
    }
    
    /**
     * faz a contagem de serviços
     * @return 
     */
    public static int getContagem() {
        int contagem = 0;
        try{
            Connection con = getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT count(*) AS contagem FROM servico");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                contagem = rs.getInt("contagem");
            }   
        }catch(SQLException erro){
            System.out.println(erro);
        }
        return contagem;
    }
    
    
    /**
     * gráfico de tipos de serviço
     * @return 
     */
        public static int[] getRelatorioServicos() {

        int[] valores = {0, 0, 0, 0, 0, 0};
        
        try{
            Connection con = getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT count(*) AS Construcao FROM profissional WHERE servico_id = (31 OR 37 OR 40 OR 41)");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                valores[0] = rs.getInt("Construcao");
            }   
 
            ps = (PreparedStatement) con.prepareStatement("SELECT count(*) AS Gerais FROM profissional WHERE servico_id = 20");
            rs = ps.executeQuery();
            while(rs.next()){
                valores[1] = rs.getInt("Gerais");
            }            
            
            ps = (PreparedStatement) con.prepareStatement("SELECT count(*) AS Maio FROM servico WHERE MONTH(data_acesso) = 5");
            rs = ps.executeQuery();
            while(rs.next()){
                valores[2] = rs.getInt("Maio");
            }
            
            ps = (PreparedStatement) con.prepareStatement("SELECT count(*) AS Junho FROM servico WHERE MONTH(data_acesso) = 6");
            rs = ps.executeQuery();
            while(rs.next()){
                valores[3] = rs.getInt("Junho");
            }
            
            ps = (PreparedStatement) con.prepareStatement("SELECT count(*) AS Julho FROM servico WHERE MONTH(data_acesso) = 7");
            rs = ps.executeQuery();
            while(rs.next()){
                valores[4] = rs.getInt("Julho");
            }
            
        }catch(Exception erro){
            System.out.println(erro);
        }
        return valores;
    }

}

