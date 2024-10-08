package raisetech.StudentManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class StudentManagementApplication {

	@Autowired
	private StudentRepository repository;


	private String name = "Takahasi Kanta";
	private String age = "23";

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementApplication.class, args);
	}


	@GetMapping("/studentInfo")
	public String getstudentInfo() {
		Student student =  repository.searchByName("Simizu");
		return student.getName() + " " + student.getAge() + "歳" ;
	}

	@PostMapping("/studentInfo")
	public  void setStudentInfo(String name,String age) {
		this.name = name;
		this.age  = age;
	}
	@PostMapping("/studentName")
	public void updateStudentName(String name) {
		this.name = name ;
	}

}
// TEST