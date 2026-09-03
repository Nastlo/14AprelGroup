package az.developia.spring_project_14aprel.mapper;

import az.developia.spring_project_14aprel.entity.Course;
import az.developia.spring_project_14aprel.requestdto.CourseCreateRequest;
import az.developia.spring_project_14aprel.requestdto.CourseUpdateRequest;
import az.developia.spring_project_14aprel.responsedto.CourseResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {

    private final ModelMapper modelMapper;

    public CourseMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Course toEntity(CourseCreateRequest request) {
        return modelMapper.map(request, Course.class);
    }

    public Course toEntity(CourseUpdateRequest request) {
        return modelMapper.map(request, Course.class);
    }

    public CourseResponse toResponse(Course course) {
        return modelMapper.map(course, CourseResponse.class);
    }
}