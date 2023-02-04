package dev.igor.enviopromocoesclientesjob.processor;

import java.text.NumberFormat;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import dev.igor.enviopromocoesclientesjob.domain.InteresseProdutoCliente;

@Component
public class ProcessarEmailProdutoClienteProcessor implements ItemProcessor<InteresseProdutoCliente, SimpleMailMessage>{

    @Override
    public SimpleMailMessage process(InteresseProdutoCliente cliente) throws Exception {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setFrom("xpto@no-reply.com");
        email.setTo(cliente.getClient().getEmail());
        email.setSubject("Promocao Imperdivel!!!!");
        email.setText(gerarTextoPromocao(cliente));
        Thread.sleep(2000);
        return email;
    }
    
    private String gerarTextoPromocao(InteresseProdutoCliente cliente) {
        StringBuilder writer = new StringBuilder();
        writer.append(String.format("Ola, %s!\n\n", cliente.getClient().getNome()));
        writer.append("Essa promocao pode ser do seu interesse:\n\n");
        writer.append(String.format("%s - %s\n\n", cliente.getProduto().getNome(), cliente.getProduto().getDescricao()));
        writer.append(String.format("Por apenas %s!",
            NumberFormat.getCurrencyInstance().format(cliente.getProduto().getPreco())));
        return writer.toString();
    }
}
