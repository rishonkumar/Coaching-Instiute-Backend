    package com.CoachingInstitute.controller;

    import com.CoachingInstitute.dto.StudentDto;
    import com.CoachingInstitute.model.Student;
    import com.CoachingInstitute.response.ApiResponse;
    import com.CoachingInstitute.service.StudentService;
    import lombok.RequiredArgsConstructor;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestBody;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;

    @RequiredArgsConstructor
    @RestController
    @RequestMapping("/student")
    public class StudentController {

        /*
        To choose the subject they want to take subjects on

        So this is the request i wil sending as a dto
    Subjects
    StudentId
    StudentName
    Email
    totalFeesPaid
    or is there any other ideal approach
    @AllArgsConstructor
    @Data
    public class ApiResponse {
        private String message;
        private Object data;
    }
         */


        private final StudentService studentService;

        @PostMapping("/choose-subject")
        public ApiResponse chooseSubject(@RequestBody StudentDto studentDto) {
            boolean isUpdated = studentService.chooseSubjectForStudents(studentDto);
            if (isUpdated) {
                return new ApiResponse("Subject chosen successfully ", studentDto);
            } else {
                return new ApiResponse("Subject chosen failed", studentDto);
            }
        }

        @PostMapping("/register")
        public ApiResponse register(@RequestBody StudentDto studentDto) {
            Student student = studentService.registerStudent(studentDto);
            if (student != null) {
                return new ApiResponse("Student registered successfully ", studentDto);
            } else{
                return new ApiResponse("Student registeration failed", studentDto);
            }
        }

    }
