import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserDto } from '../entity/userDto';
import { Observable } from 'rxjs';
import { CourseDto } from '../entity/courseDto';
import { EnrnollmentDto } from '../entity/enrollmentDto';
import { StudentDto } from '../entity/studentDto';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  constructor(private http: HttpClient) { }

  checkUser(userDto: UserDto):Observable<boolean>{
    return this.http.post<boolean>('http://localhost:8080/users/check-user',userDto);
  }

  getStudent(username:string):Observable<StudentDto>{
    return this.http.get<StudentDto>('http://localhost:8080/students/dashboard/'+username);
  }

  createUser(user: UserDto):Observable<UserDto>{
    return this.http.post<UserDto>('http://localhost:8080/users',user);
  }

  createStudent(student: StudentDto):Observable<StudentDto>{
    return this.http.post<StudentDto>('http://localhost:8080/students',student);
  }

  updateStudent(id:number, student: StudentDto):Observable<StudentDto>{
    return this.http.put<StudentDto>('http://localhost:8080/students/'+id,student);
  }

  getUserByUsername(username:string):Observable<UserDto>{
    return this.http.get<UserDto>('http://localhost:8080/users/'+username);
  }

  getAllStudents():Observable<StudentDto[]>{
    return this.http.get<StudentDto[]>('http://localhost:8080/students');
  }

  getAllCourseByStudentId({ id }: { id: number; }):Observable<CourseDto[]>{
    return this.http.get<CourseDto[]>('http://localhost:8080/courses/get/'+id);
  }

  getAllCourseByStudentIdEnrolled({ id }: { id: number; }):Observable<CourseDto[]>{
    return this.http.get<CourseDto[]>('http://localhost:8080/courses/get/enrolled/'+id);
  }

  createCourse(course: CourseDto):Observable<CourseDto>{
    return this.http.post<CourseDto>('http://localhost:8080/courses',course);
  }

  createEnrollment(enrollment: EnrnollmentDto):Observable<EnrnollmentDto>{
    return this.http.post<EnrnollmentDto>('http://localhost:8080/enrollments',enrollment);
  }

  getCourseById(id:number):Observable<CourseDto>{
    return this.http.get<CourseDto>('http://localhost:8080/courses/'+id);
  }

  getAllEnrollments():Observable<EnrnollmentDto[]>{
    return this.http.get<EnrnollmentDto[]>('http://localhost:8080/enrollments');
  }

  getAllUsers():Observable<UserDto[]>{
    return this.http.get<UserDto[]>('http://localhost:8080/users');
  }

  getAllCourses():Observable<CourseDto[]>{
    return this.http.get<CourseDto[]>('http://localhost:8080/courses');
  }

  deleteEnrollment(id:number):Observable<void>{
    return this.http.delete<void>('http://localhost:8080/enrollments/'+id);
  }

  getEnrollmentById(id:number):Observable<EnrnollmentDto>{
    return this.http.get<EnrnollmentDto>('http://localhost:8080/enrollments/'+id);
  }
}
