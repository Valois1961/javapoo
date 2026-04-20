public class Cliente {

    private String nome;
    private String email;

    public Cliente(String nome, String email) throws Exception {

        if (nome == null || nome.isEmpty()) {
            throw new Exception("Nome inválido");
        }
        if (email == null || email.isEmpty()) {
            throw new Exception("Email inválido");
        }
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
}
