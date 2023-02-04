package dev.igor.enviopromocoesclientesjob.reader;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import dev.igor.enviopromocoesclientesjob.domain.Cliente;
import dev.igor.enviopromocoesclientesjob.domain.InteresseProdutoCliente;
import dev.igor.enviopromocoesclientesjob.domain.Produto;

@Configuration
public class LerInteresseProdutoClienteReaderConfig {

    private static final String sql = "select * from interesse_produto_cliente join cliente on (cliente.id = cliente) join produto on (produto.id = produto)";

    @Bean
    public JdbcCursorItemReader<InteresseProdutoCliente> lerInteresseProdutoClienteReader(
        @Qualifier("appDataSource") DataSource dataSource) {
            return new JdbcCursorItemReaderBuilder<InteresseProdutoCliente>()
                .name("lerInteresseProdutoClienteReader")
                .dataSource(dataSource)
                .sql(sql)
                .rowMapper(rowMapper())
                .build();
        }

    private RowMapper<InteresseProdutoCliente> rowMapper() {
        return new RowMapper<InteresseProdutoCliente>() {
            @Override
            @Nullable
            public InteresseProdutoCliente mapRow(ResultSet rs, int rowNum) throws SQLException {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));

                Produto produto = new Produto();
                produto.setId(rs.getInt(6));
                produto.setNome(rs.getString(7));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPreco(rs.getDouble("preco"));

                InteresseProdutoCliente interesse = new InteresseProdutoCliente();
                interesse.setClient(cliente);
                interesse.setProduto(produto);

                return interesse;
            }
        };
    }
}
