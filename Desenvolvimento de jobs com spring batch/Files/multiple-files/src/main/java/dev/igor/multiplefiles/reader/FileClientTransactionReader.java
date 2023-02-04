package dev.igor.multiplefiles.reader;

import dev.igor.multiplefiles.domain.Client;
import dev.igor.multiplefiles.domain.Transaction;
import org.springframework.batch.item.*;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.ResourceAwareItemReaderItemStream;
import org.springframework.core.io.Resource;

public class FileClientTransactionReader implements ItemStreamReader<Client>, ResourceAwareItemReaderItemStream<Client> {
    private Object currentObj;
    private final FlatFileItemReader<Object> delegate;

    public FileClientTransactionReader(FlatFileItemReader<Object> delegate) {
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

    @Override
    public void setResource(Resource resource) {
        delegate.setResource(resource);
    }
}

