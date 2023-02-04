package dev.igor.enviopromocoesclientesjob.domain;

public class InteresseProdutoCliente {
    private Cliente client;
    private Produto produto;
    
    public Cliente getClient() {
        return client;
    }
    public void setClient(Cliente client) {
        this.client = client;
    }
    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    @Override
    public String toString() {
        return "InteresseProdutoCliente [client=" + client + ", produto=" + produto + "]";
    }
}
