package dao;

import classes.Agendamento;
import static dao.ConexaoDao.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class AgendamentoDao {
    
    
    /**
     * Cadastro de agendamento
     * 
     * @param data
     * @param hora
     * @return 
     */
    public static int cadastrarAgendamento(String data, String hora){
       int status = 0;  
   try{
        Connection con = getConnection();
       PreparedStatement ps = (PreparedStatement) con.prepareStatement("INSERT INTO agendamentos(title, description, start, end, color, usuario_id) VALUES('Agenda', 'Agenda marcado', ?, ?, 'blue', 4)");
        Timestamp start = java.sql.Timestamp.valueOf(data + ' ' + hora);
        Timestamp end = new Timestamp(start.getTime()+2400000);  
        ps.setTimestamp(1, start);
        ps.setTimestamp(2, end);        
        status = ps.executeUpdate();
    }catch(SQLException erro){
        System.out.println(erro);
    }      
       return status;
   }        
    
    
    /**
     * Selecionar todos os agendamentos
     * @return 
     */
    public static List<Agendamento> getAgendamento() {
    List<Agendamento> list = new ArrayList<>();
    try{
        Connection con = getConnection();
        PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM agendamento");
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Agendamento agendamento = new Agendamento();
            agendamento.setId(rs.getInt("id"));
            agendamento.setData(rs.getString("data"));
            agendamento.setHora(rs.getString("hora"));
            agendamento.setUsuario_id(rs.getInt("usuario_id"));
            agendamento.setEndereco(rs.getString("endereco"));
            agendamento.setDescription(rs.getString("descricao"));
            agendamento.setStart(rs.getTimestamp("start"));
            agendamento.setEnd(rs.getTimestamp("end"));                
            agendamento.setColor(rs.getString("color"));
            agendamento.setServico_id(rs.getInt("servico_id")); 
            agendamento.setStatus(rs.getString("status")); 
            agendamento.setProfissional_id(rs.getInt("profissional_id")); 
            
            list.add(agendamento);
        }       
    }catch(SQLException erro){
        System.out.println(erro);
    }
    return list;
    }
    
    /**
     * Pegar a contagem de agendamentos
     * @return 
     */
    public static int getContagem() {
        int contagem = 0;
        try{
            Connection con = getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT count(*) AS contagem FROM agendamento");
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
     * Gráfico de tipos de serviços
     * @return 
     */
    public static int[] getRelatorioServicos() {

        int[] valores = {0, 0, 0, 0, 0, 0};
        
        try{
            Connection con = getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT count(servico_id) AS Construcao FROM agendamento WHERE (servico_id = 25) OR (servico_id = 31) OR (servico_id = 33) OR (servico_id = 37) OR (servico_id = 38) OR (servico_id = 40) OR (servico_id = 41) OR (servico_id = 43) OR (servico_id = 46)");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                valores[0] = rs.getInt("Construcao");
            }   
 
            ps = (PreparedStatement) con.prepareStatement("SELECT count(servico_id) AS Gerais FROM agendamento WHERE (servico_id = '11') OR (servico_id = '17') OR (servico_id = '18') OR (servico_id = '20') OR (servico_id = '21') OR (servico_id = '23') OR (servico_id = '27') OR (servico_id = '28') OR (servico_id = '32') OR (servico_id = '34') OR (servico_id = '39') OR (servico_id = '41') OR (servico_id = '44') OR (servico_id = '45') OR (servico_id = '47')");
            rs = ps.executeQuery();
            while(rs.next()){
                valores[1] = rs.getInt("Gerais");
            }            
            
            ps = (PreparedStatement) con.prepareStatement("SELECT count(servico_id) AS Tecnologia FROM agendamento WHERE (servico_id = 2) OR (servico_id = 3) OR (servico_id = 6) OR (servico_id = 8) OR (servico_id = 10) OR (servico_id = 22) OR (servico_id = 36) OR (servico_id = 48)");
            rs = ps.executeQuery();
            while(rs.next()){
                valores[2] = rs.getInt("Tecnologia");
            }
            
            ps = (PreparedStatement) con.prepareStatement("SELECT count(servico_id) AS Estética FROM agendamento WHERE (servico_id = 13) OR (servico_id = 26) OR (servico_id = 35) OR (servico_id = 49) OR (servico_id = 50) OR (servico_id = 51)");
            rs = ps.executeQuery();
            while(rs.next()){
                valores[3] = rs.getInt("Estética");
            }
            
            ps = (PreparedStatement) con.prepareStatement("SELECT count(servico_id) AS Técnicos FROM agendamento WHERE (servico_id = 4) OR (servico_id = 5) OR (servico_id = 7) OR (servico_id = 9) OR (servico_id = 24)");
            rs = ps.executeQuery();
            while(rs.next()){
                valores[4] = rs.getInt("Técnicos");
            }
            
            ps = (PreparedStatement) con.prepareStatement("SELECT count(servico_id) AS Eventos FROM agendamento WHERE (servico_id = 1) OR (servico_id = 12) OR (servico_id = 14) OR (servico_id = 15) OR (servico_id = 16) OR (servico_id = 19) OR (servico_id = 29) OR (servico_id = 30)");
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
