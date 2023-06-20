import { Component, ViewChild } from '@angular/core';
import { CourseDto } from '../entity/courseDto';
import { MatTable } from '@angular/material/table';
import { StudentService } from '../service/student.service';
import { Router } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { CreateCourseComponent } from '../create-course/create-course.component';

@Component({
  selector: 'app-manage-course',
  templateUrl: './manage-course.component.html',
  styleUrls: ['./manage-course.component.scss']
})
export class ManageCourseComponent {
  displayedColumns: string[] = ['id', 'name', 'description','startDate', 'endDate', 'capacity'];
  dataSource: CourseDto[] = [];

  course:CourseDto = {} as CourseDto;

  @ViewChild(MatTable) table: MatTable<CourseDto> = {} as MatTable<CourseDto>;

  constructor(
    private studentService: StudentService,
    private router: Router,
    public dialog: MatDialog
  ) {}

  ngOnInit(): void {
    this.getAllCourse();
  }

  getAllCourse() {
    this.studentService.getAllCourses().subscribe(response => {
      console.log('res1', response);
      this.dataSource = response;
    });
  }

  openDialog(element: CourseDto) {
    const dialogRef = this.dialog.open(CreateCourseComponent, {
      data: { ...element }
    });
    dialogRef.afterClosed().subscribe(result => {
      if(result !== undefined){
        this.createCourse(result);
        console.log('The dialog was closed', result);
        alert("Thêm khóa học thành công");
        this.table.renderRows;
      }
    });
  }

  createCourse(course: CourseDto){
    this.studentService.createCourse(course).subscribe(result =>{
    });
  }

  removeData() {
    this.dataSource.pop();
    this.table.renderRows();
  }

  manageStudent(){
    this.router.navigate(["/manage-student"]);
  }

  manageCourse(){
    this.router.navigate(["/manage-course"]);
  }

  manageUser(){
    this.router.navigate(["/manage-user"]);
  }
}
