package entity;

public class Funcionario {
    private int cod_funcionario;
    private int funcionario_cod_funcionario;
    private String nome_funcionario;
    private Float salario;
    private String setor;

    public int getCod_funcionario() {
        return cod_funcionario;
    }

    public void setCod_funcionario(int cod_funcionario) {
        this.cod_funcionario = cod_funcionario;
    }

    public int getFuncionario_cod_funcionario() {
        return funcionario_cod_funcionario;
    }

    public void setFuncionario_cod_funcionario(int funcionario_cod_funcionario) {
        this.funcionario_cod_funcionario = funcionario_cod_funcionario;
    }

    public String getNome_funcionario() {
        return nome_funcionario;
    }

    public void setNome_funcionario(String nome_funcionario) {
        this.nome_funcionario = nome_funcionario;
    }

    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) {
        this.salario = salario;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }
    
}
