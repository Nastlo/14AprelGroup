package az.developia.spring_project_14aprel.mapper;

import az.developia.spring_project_14aprel.entity.Student;
import az.developia.spring_project_14aprel.requestdto.StudentCreateRequest;
import az.developia.spring_project_14aprel.requestdto.StudentUpdateRequest;
import az.developia.spring_project_14aprel.responsedto.StudentResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    private final ModelMapper modelMapper;

    public StudentMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Student toEntity(StudentCreateRequest request) {
        return modelMapper.map(request, Student.class);
    }

    public Student toEntity(StudentUpdateRequest request) {
        return modelMapper.map(request, Student.class);
    }

    public StudentResponse toResponse(Student student) {
        return modelMapper.map(student, StudentResponse.class);
    }
}