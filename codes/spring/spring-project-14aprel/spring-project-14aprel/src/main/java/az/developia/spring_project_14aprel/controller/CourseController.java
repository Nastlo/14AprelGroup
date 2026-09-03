package az.developia.spring_project_14aprel.controller;

import az.developia.spring_project_14aprel.entity.Student;
import az.developia.spring_project_14aprel.requestdto.CourseCreateRequest;
import az.developia.spring_project_14aprel.requestdto.CourseUpdateRequest;
import az.developia.spring_project_14aprel.responsedto.ApiResponse;
import az.developia.spring_project_14aprel.responsedto.CourseResponse;
import az.developia.spring_project_14aprel.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<CourseResponse>> create(
            @Valid @RequestBody CourseCreateRequest request) {

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Course yaradıldı",
                        courseService.create(request)));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<CourseResponse>>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Course siyahısı",
                        courseService.findAll(
                                PageRequest.of(page, size)).getContent()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CourseResponse>> findById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Course tapıldı",
                        courseService.findById(id)));
    }

    @PutMapping
    public ResponseEntity<ApiResponse<CourseResponse>> update(
            @Valid @RequestBody CourseUpdateRequest request) {

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Course yeniləndi",
                        courseService.update(request)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(
            @PathVariable Long id) {

        courseService.delete(id);

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Course silindi", null));
    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<List<CourseResponse>>> search(
            @RequestParam String name) {

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Axtarış nəticəsi",
                        courseService.search(name)));
    }

    @GetMapping("/{id}/students")
    public ResponseEntity<ApiResponse<List<Student>>> getStudents(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Course tələbələri",
                        courseService.getStudents(id)));
    }
}