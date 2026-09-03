package az.developia.spring_project_14aprel.controller;

import az.developia.spring_project_14aprel.entity.Course;
import az.developia.spring_project_14aprel.requestdto.StudentCreateRequest;
import az.developia.spring_project_14aprel.requestdto.StudentUpdateRequest;
import az.developia.spring_project_14aprel.responsedto.ApiResponse;
import az.developia.spring_project_14aprel.responsedto.StudentResponse;
import az.developia.spring_project_14aprel.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<StudentResponse>> create(
            @Valid @RequestBody StudentCreateRequest request) {

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Student yaradıldı",
                        studentService.create(request)));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<StudentResponse>>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "firstName") String sort) {

        org.springframework.data.domain.PageRequest pageRequest =
                org.springframework.data.domain.PageRequest.of(
                        page, size,
                        org.springframework.data.domain.Sort.by(sort));

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Student siyahısı",
                        studentService.findAll(pageRequest).getContent()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<StudentResponse>> findById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Student tapıldı",
                        studentService.findById(id)));
    }

    @PutMapping
    public ResponseEntity<ApiResponse<StudentResponse>> update(
            @Valid @RequestBody StudentUpdateRequest request) {

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Student yeniləndi",
                        studentService.update(request)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(
            @PathVariable Long id) {

        studentService.delete(id);

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Student silindi", null));
    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<List<StudentResponse>>> search(
            @RequestParam String name) {

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Axtarış nəticəsi",
                        studentService.search(name)));
    }

    @PostMapping("/{id}/upload-photo")
    public ResponseEntity<ApiResponse<Void>> uploadPhoto(
            @PathVariable Long id,
            @RequestParam("file") MultipartFile file) {

        studentService.uploadPhoto(id, file);

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Şəkil yükləndi", null));
    }

    @GetMapping("/{id}/photo")
    public ResponseEntity<ByteArrayResource> downloadPhoto(
            @PathVariable Long id) {

        byte[] photo = studentService.downloadPhoto(id);

        ByteArrayResource resource = new ByteArrayResource(photo);

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "inline; filename=student-photo.jpg")
                .body(resource);
    }

    @DeleteMapping("/{id}/photo")
    public ResponseEntity<ApiResponse<Void>> deletePhoto(
            @PathVariable Long id) {

        studentService.deletePhoto(id);

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Şəkil silindi", null));
    }

    @PostMapping("/{studentId}/courses/{courseId}")
    public ResponseEntity<ApiResponse<Void>> assignCourse(
            @PathVariable Long studentId,
            @PathVariable Long courseId) {

        studentService.assignCourse(studentId, courseId);

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Student kursa qeyd edildi", null));
    }

    @DeleteMapping("/{studentId}/courses/{courseId}")
    public ResponseEntity<ApiResponse<Void>> removeCourse(
            @PathVariable Long studentId,
            @PathVariable Long courseId) {

        studentService.removeCourse(studentId, courseId);

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Student kursdan çıxarıldı", null));
    }

    @GetMapping("/{studentId}/courses")
    public ResponseEntity<ApiResponse<List<Course>>> getCourses(
            @PathVariable Long studentId) {

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Student kursları",
                        studentService.getCourses(studentId)));
    }
}