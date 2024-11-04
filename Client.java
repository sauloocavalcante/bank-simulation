public class Client {

    private String name;
    private String cpf;

    public Client(String name, String cpf) {
        this.name = name;
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, CPF: %s", getName(), getCpf());
    }
}
