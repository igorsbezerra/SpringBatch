package dev.igor.webservice.reader;

import dev.igor.webservice.domain.ResponseUser;
import dev.igor.webservice.domain.User;
import org.springframework.batch.core.annotation.AfterChunk;
import org.springframework.batch.core.annotation.BeforeChunk;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserReader implements ItemReader<User> {
    private final RestTemplate restTemplate;
    private int page = 1;
    private int total = 0;
    private List<User> users = new ArrayList<>();
    private int userIndex = 0;
    private int chunkSize;
    private int pageSize;
    private int limit;
    private static final String url = "https://gorest.co.in/public/v1/users?page=%d";

    public UserReader(RestTemplate restTemplate, @Value("${chunk.size}") int chunkSize, @Value("${api.page}") int pageSize, @Value("${api.limit}") int limit) {
        this.restTemplate = restTemplate;
        this.chunkSize = chunkSize;
        this.pageSize = pageSize;
        this.limit = limit;
    }

    @Override
    public User read() {
        User user;

        if (userIndex < users.size())
            user = users.get(userIndex);
        else
            user = null;

        userIndex++;
        return user;
    }

    private List<User> fetchUserDataFromAPI() {
        ResponseEntity<ResponseUser> response = restTemplate
                .getForEntity(String.format("https://gorest.co.in/public/v1/users?page=%d", page), ResponseUser.class);
        List<User> userData = response.getBody().getData();
        return userData;
    }

    @BeforeChunk
    private void beforeChunk(ChunkContext context) {
        for (int i = 0; i < chunkSize; i += pageSize) {
            if (total >= limit) return;

            List<User> usersData = fetchUserDataFromAPI();
            users.addAll(usersData);
            total += usersData.size();
            page++;
        }
    }

    @AfterChunk
    private void afterChunk(ChunkContext context) {
        System.out.println("Fim do Chunk");
        userIndex = 0;
        users = new ArrayList<>();
    }
}
