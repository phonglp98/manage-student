import { Component, ViewChild } from '@angular/core';
import {MatTable,} from '@angular/material/table';
import { Router } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { UserDto } from '../entity/userDto';
import { StudentService } from '../service/student.service';

@Component({
  selector: 'app-manage-user',
  templateUrl: './manage-user.component.html',
  styleUrls: ['./manage-user.component.scss']
})
export class ManageUserComponent {
  displayedColumns: string[] = ['id', 'username', 'role'];
  dataSource: UserDto[] = [];

  @ViewChild(MatTable) table: MatTable<UserDto> = {} as MatTable<UserDto>;

  constructor(
    private studentService: StudentService,
    private router: Router,
    public dialog: MatDialog
  ) {}

  ngOnInit(): void {
    this.getAllStudents();
  }

  getAllStudents() {
    this.studentService.getAllUsers().subscribe(response => {
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
