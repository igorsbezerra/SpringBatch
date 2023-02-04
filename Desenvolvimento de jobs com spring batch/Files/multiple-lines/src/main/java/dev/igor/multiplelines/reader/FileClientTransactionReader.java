package dev.igor.multiplelines.reader;

import dev.igor.multiplelines.domain.Client;
import dev.igor.multiplelines.domain.Transaction;
import org.springframework.batch.item.*;

public class FileClientTransactionReader implements ItemStreamReader<Client> {
    private Object currentObj;
    private final ItemStreamReader<Object> delegate;

    public FileClientTransactionReader(ItemStreamReader<Object> delegate) {
        this.delegate = delegate;
    }

    @Override
    public Client read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if (currentObj == null)
            currentObj = delegate.read();

        Client client = (Client) currentObj;
        currentObj = null;

        if (client != null) {
            while(peek() instanceof Transaction) {
                client.getTransactions().add((Transaction) currentObj);
            }
        }
        return client;
    }

    private Object peek() throws Exception {
        currentObj = delegate.read();
        return currentObj;
    }

    @Override
    public void open(ExecutionContext executionContext) throws ItemStreamException {
        delegate.open(executionContext);
    }

    @Override
    public void update(ExecutionContext executionContext) throws ItemStreamException {
        delegate.update(executionContext);
    }

    @Override
    public void close() throws ItemStreamException {
        delegate.close();
    }
}
