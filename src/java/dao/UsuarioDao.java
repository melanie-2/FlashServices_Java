package dao;

import classes.Usuario;
import static dao.ConexaoDao.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * classe do usuario
 * @author flashservice
 */
public class UsuarioDao {
      
    /**
     * seleciona todos os usuarios de um certo id
     * @return 
     */
    public static List<Usuario> getUsuarios() {
    List<Usuario> list = new ArrayList<>();
    try{
        Connection con = getConnection();
        PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM usuario where id=?");
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Usuario usuario = null;
            usuario.setId(rs.getInt("id"));
            usuario.setNome(rs.getString("nome"));
            usuario.setEmail(rs.getString("email"));
            usuario.setAcesso(rs.getString("acesso"));
            usuario.setData_Acesso(rs.getString("data_acesso"));
            list.add(usuario);
        }       
    }catch(SQLException erro){
        System.out.println(erro);
    }
    return list;
    }
    
    /**
     * pegar os usuarios por id
     * @param id
     * @return 
     */
    public static Usuario getUsuarioById(int id){
        Usuario usuario = null;      
    try{
        Connection con = getConnection();
        PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM usuario WHERE id=?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            usuario = new Usuario();
            usuario.setId(rs.getInt("id"));
            usuario.setNome(rs.getString("nome"));
            usuario.setEmail(rs.getString("email"));         
            usuario.setSenha(rs.getString("senha"));   
            usuario.setAcesso(rs.getString("acesso")); 
        }
    }catch(Exception erro){
        System.out.println(erro);
    }      
        return usuario;
    }
    
    /**
     * pegar usuarios para paginação
     * @param inicio
     * @param total
     * @return 
     */
    public static List<Usuario> getUsuarios(int inicio, int total){
    List<Usuario> list = new ArrayList<>();
    try{
        Connection con = getConnection();
        PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM usuario ORDER BY id LIMIT " + (inicio - 1) + " ," + total);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Usuario usuario = new Usuario();
            usuario.setId(rs.getInt("id"));
            usuario.setNome(rs.getString("nome"));
            usuario.setEmail(rs.getString("email"));         
            usuario.setSenha(rs.getString("senha"));   
            usuario.setAcesso(rs.getString("acesso"));
            usuario.setData_Acesso(rs.getString("data_acesso"));
            usuario.setStatus(rs.getString("status"));
            list.add(usuario);
        }       
    }catch(SQLException erro){
        System.out.println(erro);
    }
    return list;
    }

    /**
     * pegar os usuarios para relatorios
     * @return 
     */
    public static List<Usuario> getRelatorio() {
    List<Usuario> list = new ArrayList<Usuario>();
    try{
        Connection con = getConnection();
        PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM usuario");
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Usuario usuario = new Usuario();
            usuario.setId(rs.getInt("id"));
            usuario.setNome(rs.getString("nome"));
            usuario.setEmail(rs.getString("email")); 
            usuario.setData_Acesso(rs.getString("data_acesso"));
            list.add(usuario);
        }       
    }catch(SQLException erro){
        System.out.println(erro);
    }
    return list;
    }
    
    /**
     * fazer a contagem de usuarios
     * @return 
     */
    public static int getContagem() {
        int contagem = 0;
        try{
            Connection con = getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT count(*) AS contagem FROM usuario");
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
     * gráfico de usuarios novos por mês
     * @return 
     */
        public static int[] getRelatorioUsuarioPorMes() {

        int[] mes = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        
        try{
            Connection con = getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT count(*) AS Janeiro FROM usuario WHERE MONTH(data_acesso) = 1");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                mes[0] = rs.getInt("Janeiro");
            }   
 
            ps = (PreparedStatement) con.prepareStatement("SELECT count(*) AS Fevereiro FROM usuario WHERE MONTH(data_acesso) = 2");
            rs = ps.executeQuery();
            while(rs.next()){
                mes[1] = rs.getInt("Fevereiro");
            }           
            
            ps = (PreparedStatement) con.prepareStatement("SELECT count(*) AS Março FROM usuario WHERE MONTH(data_acesso) = 3");
            rs = ps.executeQuery();
            while(rs.next()){
                mes[2] = rs.getInt("Março");
            }  
            
            ps = (PreparedStatement) con.prepareStatement("SELECT count(*) AS Abril FROM usuario WHERE MONTH(data_acesso) = 4");
            rs = ps.executeQuery();
            while(rs.next()){
                mes[3] = rs.getInt("Abril");
            }  
            
            ps = (PreparedStatement) con.prepareStatement("SELECT count(*) AS Maio FROM usuario WHERE MONTH(data_acesso) = 5");
            rs = ps.executeQuery();
            while(rs.next()){
                mes[4] = rs.getInt("Maio");
            }  
            
            ps = (PreparedStatement) con.prepareStatement("SELECT count(*) AS Junho FROM usuario WHERE MONTH(data_acesso) = 6");
            rs = ps.executeQuery();
            while(rs.next()){
                mes[5] = rs.getInt("Junho");
            }  
            
            ps = (PreparedStatement) con.prepareStatement("SELECT count(*) AS Julho FROM usuario WHERE MONTH(data_acesso) = 7");
            rs = ps.executeQuery();
            while(rs.next()){
                mes[6] = rs.getInt("Julho");
            }  
            
            ps = (PreparedStatement) con.prepareStatement("SELECT count(*) AS Agosto FROM usuario WHERE MONTH(data_acesso) = 8");
            rs = ps.executeQuery();
            while(rs.next()){
                mes[7] = rs.getInt("Agosto");
            }  
            
            ps = (PreparedStatement) con.prepareStatement("SELECT count(*) AS Setembro FROM usuario WHERE MONTH(data_acesso) = 9");
            rs = ps.executeQuery();
            while(rs.next()){
                mes[8] = rs.getInt("Setembro");
            }  
            
            ps = (PreparedStatement) con.prepareStatement("SELECT count(*) AS Outubro FROM usuario WHERE MONTH(data_acesso) = 10");
            rs = ps.executeQuery();
            while(rs.next()){
                mes[9] = rs.getInt("Outubro");
            }  
            
            ps = (PreparedStatement) con.prepareStatement("SELECT count(*) AS Novembro FROM usuario WHERE MONTH(data_acesso) = 11");
            rs = ps.executeQuery();
            while(rs.next()){
                mes[10] = rs.getInt("Novembro");
            }  
            
            ps = (PreparedStatement) con.prepareStatement("SELECT count(*) AS Dezembro FROM usuario WHERE MONTH(data_acesso) = 12");
            rs = ps.executeQuery();
            while(rs.next()){
                mes[11] = rs.getInt("Dezembro");
            }  
            
        }catch(Exception erro){
            System.out.println(erro);
        }
        return mes;
    }
 
        /**
         * gráfico de condição dos usuarios
         * @return 
         */
        public static int[] getRelatorioCondicao() {

        int[] valores = {0, 0};
        
        try{
            Connection con = getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT count(*) AS Ativo FROM usuario WHERE status = 'Ativo'");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                valores[0] = rs.getInt("Ativo");
            }   
 
            ps = (PreparedStatement) con.prepareStatement("SELECT count(*) AS Inativo FROM usuario WHERE status = 'Inativo'");
            rs = ps.executeQuery();
            while(rs.next()){
                valores[1] = rs.getInt("Inativo");
            }            
            
        }catch(Exception erro){
            System.out.println(erro);
        }
        return valores;
    }
        
        /**
         * editar usuario
         * @param usuario
         * @return 
         */
  public static int editarUsuario(Usuario usuario){
       int status = 0;  
   try{
        Connection con = getConnection();
        PreparedStatement ps = (PreparedStatement) con.prepareStatement("UPDATE usuario SET nome=?, email=?, acesso=? WHERE id=?");
        ps.setString(1, usuario.getNome());
        ps.setString(2, usuario.getEmail());
        ps.setString(3, usuario.getAcesso()); 
        ps.setInt(4, usuario.getId());         
        status = ps.executeUpdate();
    }catch(SQLException erro){
        System.out.println(erro);
    }      
       return status;
   }
        
  /**
   * editar usuario
   * @param usuario
   * @return 
   */
  public static int excluirUsuario(Usuario usuario){
       int status = 0;  
        try{
             Connection con = getConnection();
             PreparedStatement ps = (PreparedStatement) con.prepareStatement("DELETE FROM usuario WHERE id=?");
             ps.setInt(1, usuario.getId());         
             status = ps.executeUpdate();
         }catch(SQLException erro){
             System.out.println(erro);
         }      
            return status;
   }
    
/**
 * bloquear usuario
 * @param usuario
 * @return 
 */
    public static int bloquearUsuario(Usuario usuario){
       int status = 0;  
       String statusdousuario;
       
       if(usuario.getStatus().equals("Ativo")){
        statusdousuario = "Inativo";   
       }else{
        statusdousuario = "Ativo";   
       }
        try{
             Connection con = getConnection();
             PreparedStatement ps = (PreparedStatement) con.prepareStatement("UPDATE usuario SET status=? WHERE id=?");
             ps.setString(1, statusdousuario);
             ps.setInt(2, usuario.getId());         
             status = ps.executeUpdate();
         }catch(SQLException erro){
             System.out.println(erro);
         }      
            return status;
   }

    
    /**
     * cadastrar usuarios
     * @param usuario
     * @return 
     */
   public static int cadastrarUsuario(Usuario usuario){
       int status = 0;  
       	DateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
	Date date = new Date();
        String strDate = dateFormat.format(date);
   try{
        Connection con = getConnection();
        PreparedStatement ps = (PreparedStatement) con.prepareStatement("INSERT INTO usuario(nome,email,senha,telefone,acesso,data_acesso,status) VALUES(?,?,?,?,?,?,'Ativo')");
        ps.setString(1, usuario.getNome());
        ps.setString(2, usuario.getEmail());
        ps.setString(3, usuario.getSenha());
        ps.setString(4, usuario.getTelefone());
        ps.setString(5, usuario.getAcesso());
        ps.setString(6, strDate);
        status = ps.executeUpdate();
    }catch(SQLException erro){
        System.out.println(erro);
    }      
       return status;
   }
        
    
    
    /**
     * login do usuario
     * @param email
     * @param senha
     * @return 
     */
public static Usuario logar(String email, String senha){ 
Usuario usuario = new Usuario();    
    try{
        Connection con = getConnection();
        PreparedStatement ps = (PreparedStatement) con.prepareStatement("select * from usuario where Email=?");
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();
        //Verifica se a consulta retornou resultado
        if (rs.next()) {       
                if(rs.getString("status").equals("ativo")){
                    if(rs.getString("senha").equals(senha)){
                        usuario.setId(rs.getInt("id"));
                        usuario.setNome(rs.getString("nome"));
                        usuario.setEmail(rs.getString("email"));         
                        usuario.setSenha(rs.getString("senha"));   
                        usuario.setAcesso(rs.getString("acesso"));     
                    }else{
                        //Senha errada
                        usuario = null;
                    }
                }else{
                   //Usuário Inativo
                   usuario = null;     
                }
        }else{
            // E-mail não existe
            usuario = null; 
        }
    }catch(SQLException erro){
        System.out.println(erro);
    }      
        return usuario;
    }
   

}
