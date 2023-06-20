import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { MatDialog } from "@angular/material/dialog";
import { StudentService } from '../service/student.service';
import { UserDto } from '../entity/userDto';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  username: string = '';
  password: string = '';


  constructor(
    private router: Router,
    public dialog: MatDialog,
    private userService: StudentService
  ) {

  }

  ngOnInit(): void {

  }

  public login() {
    const userDto: UserDto = {} as UserDto;
    userDto.username = this.username;
    userDto.password = this.password;
    userDto.role = 'student';
    this.userService.checkUser(userDto).subscribe(result => {
      if (result === false) {
        // result tra ve false dang nhap voi tu cach 'admin'
        alert('Đăng nhập thành công, chào mừng bạn đến với trang Admin');
        this.router.navigate(["/manage-student"]);
      } else {
        alert('Đăng nhập thành công');

        let user1 = this.userService.getUserByUsername(userDto.username);
        console.log('res10', user1);

        // result tra ve true dang nhap voi tu cach 'student'
        // encodedObject dung de gui du lieu la userDto sang manage-student component
        const encodedObject = encodeURIComponent(JSON.stringify(userDto));
        this.router.navigate(["/student", { encodedObject }]);
      }
    })
  }
}
