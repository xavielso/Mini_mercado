
package entity;


public class fornecedor {
    private int cod_produto;
    private int  endereco_cod_endereco;
    private String nome_fornecedor;
    private String cpf_fornecedor;

    public int getCod_produto() {
        return cod_produto;
    }

    public void setCod_produto(int cod_produto) {
        this.cod_produto = cod_produto;
    }

    public String getNome_fornecedor() {
        return nome_fornecedor;
    }

    public void setNome_fornecedor(String nome_fornecedor) {
        this.nome_fornecedor = nome_fornecedor;
    }

    public String getCpf_fornecedor() {
        return cpf_fornecedor;
    }

    public void setCpf_fornecedor(String cpf_fornecedor) {
        this.cpf_fornecedor = cpf_fornecedor;
    }

    public int getEndereco_cod_endereco() {
        return endereco_cod_endereco;
    }

    public void setEndereco_cod_endereco(int endereco_cod_endereco) {
        this.endereco_cod_endereco = endereco_cod_endereco;
    }
}
