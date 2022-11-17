package classes;

public class Profissional {
    private int id;
    private int usuario_id;
    private String nome;
    private String servico;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }
    
    private int servico_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuario_Id() {
        return usuario_id;
    }

    public void setUsuario_Id(int usuario) {
        this.usuario_id = usuario_id;
    }

    public int getServico_Id() {
        return servico_id;
    }

    public void setServico_Id(int servico) {
        this.servico_id = servico_id;
    }
    
}
