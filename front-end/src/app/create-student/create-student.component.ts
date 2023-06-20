import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { UserDto } from '../entity/userDto';
import { StudentService } from '../service/student.service';
import { StudentDto } from '../entity/studentDto';

@Component({
  selector: 'app-create-student',
  templateUrl: './create-student.component.html',
  styleUrls: ['./create-student.component.scss']
})
export class CreateStudentComponent {
  firstName:string='';
  lastName:string='';
  email:string='';
  dateOfBirth:string='';
  address:string='';

  userDto: UserDto = {} as UserDto;

constructor(
  private router: Router,
  public dialog: MatDialog,
  private studentService: StudentService,
  private route: ActivatedRoute
) {

}

ngOnInit(): void {
  
}

createStudent(){
  const encodedObject = this.route.snapshot.paramMap.get('encodedObject');  
  if (encodedObject) {
  const decodedObject = JSON.parse(decodeURIComponent(encodedObject));
  this.userDto = decodedObject;
  }
  const studentDto: StudentDto = {} as StudentDto ;
  studentDto.user = this.userDto;

  console.log(studentDto.user);

  studentDto.firstName = this.firstName;
  studentDto.lastName = this.lastName;
  studentDto.email = this.email;
  studentDto.dateOfBirth = this.dateOfBirth;
  studentDto.address = this.address;

  console.log(studentDto);

  this.studentService.createStudent(studentDto).subscribe(result =>{
  alert('Dang ky thanh cong');
  this.router.navigate(["/login"]);
  }
  , error => {
    alert("Không được để trống thông tin ");
  })
}
}
