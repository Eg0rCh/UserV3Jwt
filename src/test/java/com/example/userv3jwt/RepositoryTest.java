package com.example.userv3jwt;

import com.example.userv3jwt.user.User;
import com.example.userv3jwt.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

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

    @Test
    public void testUpdate(){
        User user = new User();
        user.setFirstname("test");
        user.setPassword("123456");
        user.setEmail("anpch@example.com");
        User savedUser = userRepository.save(user);

        savedUser.setFirstname("updatedName");
        User updatedUser = userRepository.save(savedUser);

        assertThat(updatedUser.getFirstname()).isEqualTo("updatedName");
    }

    @Test
    public void testDelete(){
        User user = new User();
        user.setFirstname("test");
        user.setPassword("123456");
        user.setEmail("anpch@example.com");
        User savedUser = userRepository.save(user);

        userRepository.delete(savedUser);

        assertThat(userRepository.findById(savedUser.getId())).isEmpty();
    }

    @Test
    public void testRead(){

        User user = new User();
        user.setFirstname("test");
        user.setPassword("123456");
        user.setEmail("anpch@example.com");
        User createdUser = userRepository.save(user);

        Optional<User> resultOptional = userRepository.findById(createdUser.getId());
        assertThat(resultOptional.isPresent()).isTrue();
        User result = resultOptional.get();

        assertThat(result.getFirstname()).isEqualTo(user.getFirstname());
        assertThat(result.getEmail()).isEqualTo(user.getEmail());

    }
}
