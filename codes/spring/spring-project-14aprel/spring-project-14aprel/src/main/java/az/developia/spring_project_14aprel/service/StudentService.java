package az.developia.spring_project_14aprel.service;

import az.developia.spring_project_14aprel.entity.Course;
import az.developia.spring_project_14aprel.entity.Student;
import az.developia.spring_project_14aprel.exception.CourseNotFoundException;
import az.developia.spring_project_14aprel.exception.ResourceAlreadyExistsException;
import az.developia.spring_project_14aprel.exception.StudentNotFoundException;
import az.developia.spring_project_14aprel.mapper.StudentMapper;
import az.developia.spring_project_14aprel.repository.CourseRepository;
import az.developia.spring_project_14aprel.repository.StudentRepository;
import az.developia.spring_project_14aprel.requestdto.StudentCreateRequest;
import az.developia.spring_project_14aprel.requestdto.StudentUpdateRequest;
import az.developia.spring_project_14aprel.responsedto.StudentResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final StudentMapper studentMapper;

    public StudentService(
            StudentRepository studentRepository,
            CourseRepository courseRepository,
            StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.studentMapper = studentMapper;
    }

    public StudentResponse create(StudentCreateRequest request) {

        if (studentRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new ResourceAlreadyExistsException("Bu email artıq istifadə olunur.");
        }

        Student student = studentMapper.toEntity(request);
        return studentMapper.toResponse(studentRepository.save(student));
    }

    public Page<StudentResponse> findAll(Pageable pageable) {

        return studentRepository.findAll(pageable)
                .map(studentMapper::toResponse);
    }

    public StudentResponse findById(Long id) throws StudentNotFoundException {

        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(
                        "Student tapılmadı: " + id));

        return studentMapper.toResponse(student);
    }

    public StudentResponse update(StudentUpdateRequest request) throws StudentNotFoundException {

        Student student = studentRepository.findById(request.getId())
                .orElseThrow(() -> new StudentNotFoundException(
                        "Student tapılmadı: " + request.getId()));

        if (!student.getEmail().equals(request.getEmail())
                && studentRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new ResourceAlreadyExistsException("Bu email artıq istifadə olunur.");
        }

        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setAge(request.getAge());
        student.setEmail(request.getEmail());

        return studentMapper.toResponse(studentRepository.save(student));
    }

    public void delete(Long id) throws StudentNotFoundException {

        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(
                        "Student tapılmadı: " + id));

        studentRepository.delete(student);
    }

    public List<StudentResponse> search(String name) {

        return studentRepository.searchByName(name)
                .stream()
                .map(studentMapper::toResponse)
                .toList();
    }

    public void assignCourse(Long studentId, Long courseId) throws StudentNotFoundException, CourseNotFoundException {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException(
                        "Student tapılmadı: " + studentId));

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new CourseNotFoundException(
                        "Course tapılmadı: " + courseId));

        if (student.getCourses() == null) {
            student.setCourses(new java.util.ArrayList<>());
        }

        if (!student.getCourses().contains(course)) {
            student.getCourses().add(course);
        }

        studentRepository.save(student);
    }

    public void removeCourse(Long studentId, Long courseId) throws StudentNotFoundException, CourseNotFoundException {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException(
                        "Student tapılmadı: " + studentId));

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new CourseNotFoundException(
                        "Course tapılmadı: " + courseId));

        if (student.getCourses() != null) {
            student.getCourses().remove(course);
        }

        studentRepository.save(student);
    }

    public List<Course> getCourses(Long studentId) throws StudentNotFoundException {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException(
                        "Student tapılmadı: " + studentId));

        return student.getCourses();
    }

    public void uploadPhoto(Long id, MultipartFile file) throws StudentNotFoundException {

        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(
                        "Student tapılmadı: " + id));

        try {
            student.setProfilePhoto(file.getBytes());
            studentRepository.save(student);
        } catch (IOException e) {
            throw new RuntimeException("Şəkil yüklənərkən xəta baş verdi.");
        }
    }

    public byte[] downloadPhoto(Long id) throws StudentNotFoundException {

        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(
                        "Student tapılmadı: " + id));

        if (student.getProfilePhoto() == null) {
            throw new RuntimeException("Student-in şəkli yoxdur.");
        }

        return student.getProfilePhoto();
    }

    public void deletePhoto(Long id) throws StudentNotFoundException {

        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(
                        "Student tapılmadı: " + id));

        student.setProfilePhoto(null);
        studentRepository.save(student);
    }
}