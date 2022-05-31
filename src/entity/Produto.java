package entity;

public class Produto {
    private int cod_produto;
    private String descricao_produto;
    private Float preco_compra;
    private Float preco_venda;
    private int fornecedor_cod_fornecedor;

    public int getCod_produto() {
        return cod_produto;
    }

    public void setCod_produto(int cod_produto) {
        this.cod_produto = cod_produto;
    }

    public int getFornecedor_cod_fornecedor() {
        return fornecedor_cod_fornecedor;
    }

    public void setFornecedor_cod_fornecedor(int fornecedor_cod_fornecedor) {
        this.fornecedor_cod_fornecedor = fornecedor_cod_fornecedor;
    }
    

    public String getDescricao_produto() {
        return descricao_produto;
    }

    public void setDescricao_produto(String descricao_produto) {
        this.descricao_produto = descricao_produto;
    }

    public Float getPreco_compra() {
        return preco_compra;
    }

    public void setPreco_compra(Float preco_compra) {
        this.preco_compra = preco_compra;
    }

    public Float getPreco_venda() {
        return preco_venda;
    }

    public void setPreco_venda(Float preco_venda) {
        this.preco_venda = preco_venda;
    }
    
}
