import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { StudentService } from '../service/student.service';
import { UserDto } from '../entity/userDto';

@Component({
  selector: 'app-create-user',
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.scss']
})
export class CreateUserComponent {
  username:string='';
  password:string='';

  constructor(
    private router: Router,
    public dialog: MatDialog,
    private userService: StudentService
  ) {

  }

  ngOnInit(): void {
    
  }

  createUser(){
    const userDto: UserDto = {} as UserDto;
    userDto.username = this.username;
    userDto.password = this.password;
    userDto.role = 'student';
    this.userService.createUser(userDto).subscribe(result =>{
    alert('Dang ky thanh cong');
    const encodedObject = encodeURIComponent(JSON.stringify(userDto));
    this.router.navigate(["/create-student", {encodedObject}]);
    }
    , error => {
      alert("Không được để trống thông tin")
    })
  }
}
