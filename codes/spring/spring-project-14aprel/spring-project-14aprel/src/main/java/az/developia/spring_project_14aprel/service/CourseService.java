package az.developia.spring_project_14aprel.service;

import az.developia.spring_project_14aprel.entity.Course;
import az.developia.spring_project_14aprel.entity.Student;
import az.developia.spring_project_14aprel.exception.CourseNotFoundException;
import az.developia.spring_project_14aprel.exception.ResourceAlreadyExistsException;
import az.developia.spring_project_14aprel.mapper.CourseMapper;
import az.developia.spring_project_14aprel.repository.CourseRepository;
import az.developia.spring_project_14aprel.requestdto.CourseCreateRequest;
import az.developia.spring_project_14aprel.requestdto.CourseUpdateRequest;
import az.developia.spring_project_14aprel.responsedto.CourseResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    public CourseService(
            CourseRepository courseRepository,
            CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }

    public CourseResponse create(CourseCreateRequest request) {

        if (courseRepository.findByName(request.getName()).isPresent()) {
            throw new ResourceAlreadyExistsException(
                    "Bu adda course artıq mövcuddur.");
        }

        Course course = courseMapper.toEntity(request);

        return courseMapper.toResponse(courseRepository.save(course));
    }

    public Page<CourseResponse> findAll(Pageable pageable) {

        return courseRepository.findAll(pageable)
                .map(courseMapper::toResponse);
    }

    public CourseResponse findById(Long id) throws CourseNotFoundException {

        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException(
                        "Course tapılmadı: " + id));

        return courseMapper.toResponse(course);
    }

    public CourseResponse update(CourseUpdateRequest request) throws CourseNotFoundException {

        Course course = courseRepository.findById(request.getId())
                .orElseThrow(() -> new CourseNotFoundException(
                        "Course tapılmadı: " + request.getId()));

        if (!course.getName().equals(request.getName())
                && courseRepository.findByName(request.getName()).isPresent()) {
            throw new ResourceAlreadyExistsException(
                    "Bu adda course artıq mövcuddur.");
        }

        course.setName(request.getName());
        course.setTeacherName(request.getTeacherName());
        course.setCredit(request.getCredit());

        return courseMapper.toResponse(courseRepository.save(course));
    }

    public void delete(Long id) throws CourseNotFoundException {

        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException(
                        "Course tapılmadı: " + id));

        courseRepository.delete(course);
    }

    public List<CourseResponse> search(String name) {

        return courseRepository.searchByName(name)
                .stream()
                .map(courseMapper::toResponse)
                .toList();
    }

    public List<Student> getStudents(Long id) throws CourseNotFoundException {

        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException(
                        "Course tapılmadı: " + id));

        return course.getStudents();
    }
}