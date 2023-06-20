import { Component, OnInit, ViewChild } from '@angular/core';
import {MatTable,} from '@angular/material/table';
import { Router } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { StudentDto } from '../entity/studentDto';
import { StudentService } from '../service/student.service';

@Component({
  selector: 'app-manage-student',
  templateUrl: './manage-student.component.html',
  styleUrls: ['./manage-student.component.scss']
})
export class ManageStudentComponent {
  displayedColumns: string[] = ['id', 'firstName', 'lastName','email', 'dateOfBirth', 'address'];
  dataSource: StudentDto[] = [];

  @ViewChild(MatTable) table: MatTable<StudentDto> = {} as MatTable<StudentDto>;

  constructor(
    private studentService: StudentService,
    private router: Router,
    public dialog: MatDialog
  ) {}

  ngOnInit(): void {
    this.getAllStudents();
  }

  getAllStudents() {
    this.studentService.getAllStudents().subscribe(response => {
      console.log('res1', response);
      this.dataSource = response;
    });
  }

  addData() {
    const randomElementIndex = Math.floor(Math.random() * this.dataSource.length);
    this.dataSource.push(this.dataSource[randomElementIndex]);
    this.table.renderRows();
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
