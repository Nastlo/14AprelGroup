package az.developia.spring_project_14aprel.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import az.developia.spring_project_14aprel.entity.Computer;
import az.developia.spring_project_14aprel.entity.User;
import az.developia.spring_project_14aprel.repository.ComputerRepo;
import az.developia.spring_project_14aprel.repository.UserRepository;
import az.developia.spring_project_14aprel.requestdto.ComputerRequestDto;
import az.developia.spring_project_14aprel.responsedto.ComputerResponseDto;

@ExtendWith(MockitoExtension.class)
class ComputerServiceTest {

    @Mock
    ComputerRepo computerRepo;

    @Mock
    ModelMapper modelMapper;

    @Mock
    UserRepository userRepository;

    @InjectMocks
    ComputerService computerService;

    @Test
    void getAllSuccess() {
        when(computerRepo.findAll()).thenReturn(List.of());

        List<ComputerResponseDto> result = computerService.getAll();

        assertNotNull(result);
        verify(computerRepo).findAll();
    }

    @Test
    void getAllEmpty() {
        when(computerRepo.findAll()).thenReturn(List.of());

        List<ComputerResponseDto> result = computerService.getAll();

        assertTrue(result.isEmpty());
        verify(computerRepo).findAll();
    }

    @Test
    void getByIdSuccess() {
        Computer computer = new Computer();
        computer.setId(1);

        when(computerRepo.findById(1))
                .thenReturn(Optional.of(computer));

        when(modelMapper.map(computer, ComputerResponseDto.class))
                .thenReturn(new ComputerResponseDto());

        ComputerResponseDto result = computerService.getById(1);

        assertNotNull(result);
        verify(computerRepo).findById(1);
    }

    @Test
    void getByIdNotFound() {
        when(computerRepo.findById(1))
                .thenReturn(Optional.empty());

        ComputerResponseDto result = computerService.getById(1);

        assertNull(result);
        verify(computerRepo).findById(1);
    }

    @Test
    void addSuccess() {
        ComputerRequestDto dto = new ComputerRequestDto();
        Computer computer = new Computer();

        User user = new User();
        user.setId(1);

        when(modelMapper.map(dto, Computer.class))
                .thenReturn(computer);

        when(userRepository.findByUsername("omer"))
                .thenReturn(user);

        var authentication = mock(
                org.springframework.security.core.Authentication.class
        );

        var context = mock(
                org.springframework.security.core.context.SecurityContext.class
        );

        when(authentication.getName()).thenReturn("omer");
        when(context.getAuthentication()).thenReturn(authentication);

        org.springframework.security.core.context.SecurityContextHolder
                .setContext(context);

        computerService.add(dto);

        verify(computerRepo).save(computer);

        org.springframework.security.core.context.SecurityContextHolder
                .clearContext();
    }

    @Test
    void addUserNotFound() {
        ComputerRequestDto dto = new ComputerRequestDto();
        Computer computer = new Computer();

        when(modelMapper.map(dto, Computer.class))
                .thenReturn(computer);

        when(userRepository.findByUsername("omer"))
                .thenReturn(null);

        var authentication = mock(
                org.springframework.security.core.Authentication.class
        );

        var context = mock(
                org.springframework.security.core.context.SecurityContext.class
        );

        when(authentication.getName()).thenReturn("omer");
        when(context.getAuthentication()).thenReturn(authentication);

        org.springframework.security.core.context.SecurityContextHolder
                .setContext(context);

        assertThrows(
                Exception.class,
                () -> computerService.add(dto)
        );

        org.springframework.security.core.context.SecurityContextHolder
                .clearContext();
    }

    @Test
    void updateSuccess() {
        ComputerRequestDto dto = new ComputerRequestDto();
        Computer computer = new Computer();

        when(modelMapper.map(dto, Computer.class))
                .thenReturn(computer);

        computerService.update(dto);

        verify(computerRepo).save(computer);
    }

    @Test
    void updateSecondTest() {
        ComputerRequestDto dto = new ComputerRequestDto();
        Computer computer = new Computer();

        when(modelMapper.map(dto, Computer.class))
                .thenReturn(computer);

        computerService.update(dto);

        verify(computerRepo).save(computer);
    }

    @Test
    void deleteSuccess() {
        computerService.delete(1);

        verify(computerRepo).deleteById(1);
    }

    @Test
    void deleteSecondTest() {
        computerService.delete(2);

        verify(computerRepo).deleteById(2);
    }

    @Test
    void findByBrandSuccess() {
        when(computerRepo.findByBrandContaining("HP"))
                .thenReturn(List.of(new Computer()));

        List<Computer> result =
                computerService.findByBrand("HP");

        assertNotNull(result);
        verify(computerRepo).findByBrandContaining("HP");
    }

    @Test
    void findByBrandEmpty() {
        when(computerRepo.findByBrandContaining("HP"))
                .thenReturn(List.of());

        List<Computer> result =
                computerService.findByBrand("HP");

        assertTrue(result.isEmpty());
        verify(computerRepo).findByBrandContaining("HP");
    }

    @Test
    void findByPriceRangeSuccess() {
        when(computerRepo.findComputersByPriceRange(100.0, 1000.0))
                .thenReturn(List.of(new Computer()));

        List<Computer> result =
                computerService.findByPriceRange(100.0, 1000.0);

        assertNotNull(result);
        verify(computerRepo)
                .findComputersByPriceRange(100.0, 1000.0);
    }

    @Test
    void findByPriceRangeEmpty() {
        when(computerRepo.findComputersByPriceRange(100.0, 1000.0))
                .thenReturn(List.of());

        List<Computer> result =
                computerService.findByPriceRange(100.0, 1000.0);

        assertTrue(result.isEmpty());
        verify(computerRepo)
                .findComputersByPriceRange(100.0, 1000.0);
    }

    @Test
    void getPaginationSuccess() {
        when(computerRepo.findAll(
                any(org.springframework.data.domain.Pageable.class)))
                .thenReturn(
                        new org.springframework.data.domain.PageImpl<>(
                                List.of()
                        )
                );

        var result = computerService.getPagination(0, 10);

        assertNotNull(result);

        verify(computerRepo).findAll(
                any(org.springframework.data.domain.Pageable.class)
        );
    }

    @Test
    void getPaginationEmpty() {
        when(computerRepo.findAll(
                any(org.springframework.data.domain.Pageable.class)))
                .thenReturn(
                        new org.springframework.data.domain.PageImpl<>(
                                List.of()
                        )
                );

        var result = computerService.getPagination(0, 10);

        assertTrue(result.isEmpty());

        verify(computerRepo).findAll(
                any(org.springframework.data.domain.Pageable.class)
        );
    }
}