package az.developia.spring_project_14aprel.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.cache.CacheManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import az.developia.spring_project_14aprel.responsedto.ComputerResponseDto;
import az.developia.spring_project_14aprel.security.JwtAuthenticationFilter;
import az.developia.spring_project_14aprel.security.JwtService;
import az.developia.spring_project_14aprel.service.ComputerService;

@WebMvcTest(ComputerController.class)
@AutoConfigureMockMvc(addFilters = false)
class ComputerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ComputerService computerService;

    @MockitoBean
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @MockitoBean
    private JwtService jwtService;

    @MockitoBean
    private CacheManager cacheManager;

    @Test
    void getAllTest() throws Exception {

        when(computerService.getAll())
                .thenReturn(new ArrayList<>());

        mockMvc.perform(
                get("/computers")
        )
        .andExpect(status().isOk());
    }

    @Test
    void getByIdTest() throws Exception {

        when(computerService.getById(1))
                .thenReturn(null);

        mockMvc.perform(
                get("/computers/1")
        )
        .andExpect(status().isOk());
    }

    @Test
    void addTest() throws Exception {

        mockMvc.perform(
                post("/computers")
                        .contentType("application/json")
                        .content("""
                                {
                                    "brand": "ASUS",
                                    "model": "TUF F17",
                                    "price": 1500
                                }
                                """)
        )
        .andExpect(status().isOk());
    }

    @Test
    void updateTest() throws Exception {

        mockMvc.perform(
                put("/computers")
                        .contentType("application/json")
                        .content("""
                                {
                                    "id": 1,
                                    "brand": "ASUS",
                                    "model": "TUF F17",
                                    "price": 1600
                                }
                                """)
        )
        .andExpect(status().isOk());
    }

    @Test
    void deleteTest() throws Exception {

        mockMvc.perform(
                delete("/computers/1")
        )
        .andExpect(status().isOk());
    }

    @Test
    void paginationTest() throws Exception {

        Page<ComputerResponseDto> page =
                new PageImpl<>(new ArrayList<>());

        when(computerService.getPagination(0, 5))
                .thenReturn(page);

        mockMvc.perform(
                get("/computers/page")
                        .param("page", "0")
                        .param("size", "5")
        )
        .andExpect(status().isOk());
    }
}