package az.developia.spring_project_14aprel.controller;

import az.developia.spring_project_14aprel.entity.Student;
import az.developia.spring_project_14aprel.requestdto.CourseCreateRequest;
import az.developia.spring_project_14aprel.requestdto.CourseUpdateRequest;
import az.developia.spring_project_14aprel.responsedto.ApiResponse;
import az.developia.spring_project_14aprel.responsedto.CourseResponse;
import az.developia.spring_project_14aprel.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@Tag(name = "Courses", description = "Course idarəetmə əməliyyatları")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    @Operation(summary = "Yeni course yaradır")
    public ResponseEntity<ApiResponse<CourseResponse>> create(
            @Valid @RequestBody CourseCreateRequest request) {

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Course yaradıldı",
                        courseService.create(request)));
    }

    @GetMapping
    @Operation(summary = "Bütün course-ları gətirir")
    public ResponseEntity<ApiResponse<List<CourseResponse>>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Course siyahısı",
                        courseService.findAll(
                                PageRequest.of(page, size)).getContent()));
    }

    @GetMapping("/{id}")
    @Operation(summary = "ID-yə görə course gətirir")
    public ResponseEntity<ApiResponse<CourseResponse>> findById(
            @Parameter(description = "Course ID-si")
            @PathVariable Long id) {

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Course tapıldı",
                        courseService.findById(id)));
    }

    @PutMapping
    @Operation(summary = "Course məlumatlarını yeniləyir")
    public ResponseEntity<ApiResponse<CourseResponse>> update(
            @Valid @RequestBody CourseUpdateRequest request) {

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Course yeniləndi",
                        courseService.update(request)));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Course-u silir")
    public ResponseEntity<ApiResponse<Void>> delete(
            @Parameter(description = "Silinəcək course-un ID-si")
            @PathVariable Long id) {

        courseService.delete(id);

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Course silindi", null));
    }

    @GetMapping("/search")
    @Operation(summary = "Course axtarışı edir")
    public ResponseEntity<ApiResponse<List<CourseResponse>>> search(
            @RequestParam String name) {

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Axtarış nəticəsi",
                        courseService.search(name)));
    }

    @GetMapping("/{id}/students")
    @Operation(summary = "Course-a qeydiyyatda olan student-ləri gətirir")
    public ResponseEntity<ApiResponse<List<Student>>> getStudents(
            @Parameter(description = "Course ID-si")
            @PathVariable Long id) {

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Course tələbələri",
                        courseService.getStudents(id)));
    }
}