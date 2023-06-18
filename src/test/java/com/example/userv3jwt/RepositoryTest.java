package com.example.userv3jwt;

import com.example.userv3jwt.user.User;
import com.example.userv3jwt.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RepositoryTest extends BaseSpringIntegrationTest{
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testCreate(){
        User user = new User();
        user.setFirstname("test");
        user.setPassword("123456");
        user.setEmail("anpch@example.com");
        User result = userRepository.save(user);

        assertThat(result.getId()).isNotNull();
    }
}
