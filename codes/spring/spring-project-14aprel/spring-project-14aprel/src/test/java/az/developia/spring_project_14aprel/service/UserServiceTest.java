package az.developia.spring_project_14aprel.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import az.developia.spring_project_14aprel.entity.User;
import az.developia.spring_project_14aprel.exception.ResourcesNotFoundException;
import az.developia.spring_project_14aprel.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @Mock
    PasswordEncoder passwordEncoder;

    @InjectMocks
    UserService userService;

    @Test
    void registerSuccess() {
        User user = new User();
        user.setUsername("omer");
        user.setPassword("1234");

        when(userRepository.findByUsername("omer"))
                .thenReturn(null);

        when(passwordEncoder.encode("1234"))
                .thenReturn("encoded");

        String result = userService.register(user);

        assertEquals("Qeydiyyat uğurla tamamlandı", result);
        verify(userRepository).save(user);
    }

    @Test
    void registerUsernameExists() {
        User user = new User();
        user.setUsername("omer");

        when(userRepository.findByUsername("omer"))
                .thenReturn(new User());

        String result = userService.register(user);

        assertEquals("Bu username artıq mövcuddur!", result);
        verify(userRepository).findByUsername("omer");
    }

    @Test
    void countAllUsersSuccess() {
        when(userRepository.countAllUsers())
                .thenReturn(10L);

        long result = userService.countAllUsers();

        assertEquals(10L, result);
        verify(userRepository).countAllUsers();
    }

    @Test
    void countAllUsersZero() {
        when(userRepository.countAllUsers())
                .thenReturn(0L);

        long result = userService.countAllUsers();

        assertEquals(0L, result);
    }

    @Test
    void cascadeExampleSuccess() {
        userService.cascadeExample();

        verify(userRepository).save(any(User.class));
    }

    @Test
    void cascadeExampleSecondTest() {
        userService.cascadeExample();

        verify(userRepository).save(any(User.class));
    }

    @Test
    void countUsersJPQLSuccess() {
        when(userRepository.countUsersJPQL())
                .thenReturn(5L);

        long result = userService.countUsersJPQL();

        assertEquals(5L, result);
        verify(userRepository).countUsersJPQL();
    }

    @Test
    void countUsersJPQLZero() {
        when(userRepository.countUsersJPQL())
                .thenReturn(0L);

        long result = userService.countUsersJPQL();

        assertEquals(0L, result);
    }

    @Test
    void findByEmailSuccess() {
        User user = new User();
        user.setEmail("omer@gmail.com");

        when(userRepository.findByEmailJPQL("omer@gmail.com"))
                .thenReturn(user);

        User result =
                userService.findByEmailJPQL("omer@gmail.com");

        assertNotNull(result);
        verify(userRepository)
                .findByEmailJPQL("omer@gmail.com");
    }

    @Test
    void findByEmailNotFound() {
        when(userRepository.findByEmailJPQL("test@gmail.com"))
                .thenReturn(null);

        User result =
                userService.findByEmailJPQL("test@gmail.com");

        assertNull(result);
        verify(userRepository)
                .findByEmailJPQL("test@gmail.com");
    }

    @Test
    void findByIdSuccess() {
        User user = new User();
        user.setId(1);

        when(userRepository.findById(1))
                .thenReturn(Optional.of(user));

        User result = userService.findById(1);

        assertNotNull(result);
        verify(userRepository).findById(1);
    }

    @Test
    void findByIdNotFound() {
        when(userRepository.findById(1))
                .thenReturn(Optional.empty());

        assertThrows(
                ResourcesNotFoundException.class,
                () -> userService.findById(1)
        );

        verify(userRepository).findById(1);
    }
}