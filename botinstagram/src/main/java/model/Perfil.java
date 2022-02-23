package model;

public class Perfil {


   
    private String username;
    private String senha;
    private String nome;
    private String sobreNome;      
    private int numeroSeguidor;
    private int numeroSeguindo;
    public Perfil() {
    }

    
    public Perfil(String username, String senha) {
        this.username = username;
        this.senha = senha;
    }


    public Perfil(String username, String senha, String nome, String sobreNome, int numeroSeguidor,
            int numeroSeguindo) {
        this.username = username;
        this.senha = senha;
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.numeroSeguidor = numeroSeguidor;
        this.numeroSeguindo = numeroSeguindo;
    }


    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public String getSenha() {
        return senha;
    }


    public void setSenha(String senha) {
        this.senha = senha;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getSobreNome() {
        return sobreNome;
    }


    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }


    public int getNumeroSeguidor() {
        return numeroSeguidor;
    }


    public void setNumeroSeguidor(int numeroSeguidor) {
        this.numeroSeguidor = numeroSeguidor;
    }


    public int getNumeroSeguindo() {
        return numeroSeguindo;
    }


    public void setNumeroSeguindo(int numeroSeguindo) {
        this.numeroSeguindo = numeroSeguindo;
    }


    @Override
    public String toString() {
        return "Perfil [nome=" + nome + ", numeroSeguidor=" + numeroSeguidor + ", numeroSeguindo=" + numeroSeguindo
                + ", senha=" + senha + ", sobreNome=" + sobreNome + ", username=" + username + "]";
    }

    

}
