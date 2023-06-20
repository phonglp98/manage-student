import { Component, ViewChild } from '@angular/core';
import { StudentDto } from '../entity/studentDto';
import { UserDto } from '../entity/userDto';
import { CourseDto } from '../entity/courseDto';
import { EnrnollmentDto } from '../entity/enrollmentDto';
import { MatTable } from '@angular/material/table';
import { ActivatedRoute } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { StudentService } from '../service/student.service';
import { EditStudentInfoComponent } from '../edit-student-info/edit-student-info.component';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.scss']
})
export class StudentComponent {
  student: StudentDto = {} as StudentDto;
  user: UserDto = {} as UserDto;

  displayedColumns: string[] = ['id', 'name', 'description', 'startDate', 'endDate', 'capacity', 'action'];
  displayedColumns1: string[] = ['id', 'name', 'description', 'startDate', 'endDate', 'capacity', 'action'];

  dataSource: CourseDto[] = [];

  dataSource1: CourseDto[] = [];

  unenrolledCourses: CourseDto[] = [];

  enrollment: EnrnollmentDto = {} as EnrnollmentDto;


  @ViewChild(MatTable) table: MatTable<CourseDto> = {} as MatTable<CourseDto>;

  @ViewChild(MatTable) table1: MatTable<CourseDto> = {} as MatTable<CourseDto>;

  constructor(
    public dialog: MatDialog,
    private studentService: StudentService,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.getStudent();
  }

  getStudent() {
    // nhận dữ liệu userDto từ trang login,
    // giúp hiển thị dữ liệu tương ứng với user lúc đăng nhập
    const encodedObject = this.route.snapshot.paramMap.get('encodedObject');
    if (encodedObject) {
      const decodedObject = JSON.parse(decodeURIComponent(encodedObject));
      this.user = decodedObject;
    }
    this.studentService.getStudent(this.user.username).subscribe(response => {
      this.student = response;
      this.student.user = this.user;
      console.log('res1', this.student);
    });
  }

  openDialog(element: StudentDto) {
    const dialogRef = this.dialog.open(EditStudentInfoComponent, {
      data: { ...element }
    });
    dialogRef.afterClosed().subscribe(result => {
      if (result !== undefined) {
        this.updateStudent(result.id, result);
        console.log('The dialog was closed', result);
        this.student = result;
      }
    });
  }

  updateStudent(id: number, student: StudentDto) {
    this.studentService.updateStudent(id, student).subscribe(result => {
    });
  }

  getAllCourseByStudentId(id: number) {
    this.studentService.getAllCourseByStudentId({ id }).subscribe(response => {
      console.log('res2', response);
      this.dataSource = response;
    });
  }

  getAllCourseByStudentIdEnrolled(id: number) {
    this.studentService.getAllCourseByStudentIdEnrolled({ id }).subscribe(response => {
      console.log('res3', response);
      this.dataSource1 = response;
    });
  }

  enrollCourse(id: number) {
    this.studentService.getCourseById(id).subscribe(response => {
      this.enrollment.course = response;
      this.enrollment.student = this.student;
      this.dataSource1.push(response);

      this.studentService.createEnrollment(this.enrollment).subscribe(response => {
        // khi đăng kí khóa học, khóa học nào được đăng kí sẽ bị xóa khỏi table
        console.log('this.enrollment', this.enrollment);
        alert("Đăng ký thành công");
        this.dataSource = this.dataSource.filter((e) => {
          return e.id !== id;
        });
      });
    });
  }

  deleteEnrollment(id: number) {
    // Lấy enrollment với id của course
    let enrollment: EnrnollmentDto = {} as EnrnollmentDto;

    let courseId: number;

    this.studentService.getEnrollmentById(id).subscribe(response => {
      enrollment = response;
      courseId = response.id;
      console.log('enrollment', enrollment);

      this.studentService.deleteEnrollment(courseId).subscribe(response => {
        alert("Xóa thành công");
        this.dataSource1 = this.dataSource1.filter((e) => {
          return e.id !== id;
        });
        this.table1.renderRows;
      });
    });
  }
}
