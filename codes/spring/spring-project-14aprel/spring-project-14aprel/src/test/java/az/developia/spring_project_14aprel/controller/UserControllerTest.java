package az.developia.spring_project_14aprel.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import az.developia.spring_project_14aprel.config.SpringContext;
import az.developia.spring_project_14aprel.repository.UserRepository;
import az.developia.spring_project_14aprel.security.JwtAuthenticationFilter;
import az.developia.spring_project_14aprel.service.UserService;

@WebMvcTest(UserController.class)
@AutoConfigureMockMvc(addFilters = false)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private UserService userService;

    @MockitoBean
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @MockitoBean
    private CacheManager cacheManager;

    @MockitoBean
    private UserRepository userRepository;

    @Test
    void registerTest() throws Exception {

        when(userRepository.findByEmailJPQL("omer123@gmail.com"))
                .thenReturn(null);

        when(userService.register(any()))
                .thenReturn("Qeydiyyat uğurla tamamlandı");

        try (MockedStatic<SpringContext> mockedStatic = mockStatic(SpringContext.class)) {

            mockedStatic
                    .when(() -> SpringContext.getBean(UserRepository.class))
                    .thenReturn(userRepository);

            mockMvc.perform(
                    post("/users/register")
                            .contentType("application/json")
                            .content("""
                                    {
                                        "firstName": "Omer",
                                        "lastName": "Ceferli",
                                        "username": "omer123",
                                        "password": "1234",
                                        "email": "omer123@gmail.com"
                                    }
                                    """)
            )
            .andExpect(status().isOk());
        }
    }

    @Test
    void countAllUsersTest() throws Exception {

        when(userService.countAllUsers())
                .thenReturn(10L);

        mockMvc.perform(
                get("/users/count")
        )
        .andExpect(status().isOk());
    }

    @Test
    void countUsersJPQLTest() throws Exception {

        when(userService.countUsersJPQL())
                .thenReturn(5L);

        mockMvc.perform(
                get("/users/count-jpql")
        )
        .andExpect(status().isOk());
    }

    @Test
    void findByEmailTest() throws Exception {

        when(userService.findByEmailJPQL("omer123@gmail.com"))
                .thenReturn(null);

        mockMvc.perform(
                get("/users/email")
                        .param("email", "omer123@gmail.com")
        )
        .andExpect(status().isOk());
    }

    @Test
    void findByIdTest() throws Exception {

        when(userService.findById(1))
                .thenReturn(null);

        mockMvc.perform(
                get("/users/1")
        )
        .andExpect(status().isOk());
    }
}