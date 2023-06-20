import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { StudentComponent } from './student/student.component';
import { CreateUserComponent } from './create-user/create-user.component';
import { CreateStudentComponent } from './create-student/create-student.component';
import { ManageStudentComponent } from './manage-student/manage-student.component';
import { ManageCourseComponent } from './manage-course/manage-course.component';
import { ManageUserComponent } from './manage-user/manage-user.component';

const routes: Routes = [
{ path: 'login', component: LoginComponent },
{ path: 'student', component: StudentComponent },
{ path: '',   redirectTo: '/login', pathMatch: 'full' },
{ path: 'create-user', component: CreateUserComponent },
{ path: 'create-student', component: CreateStudentComponent },
{ path: 'manage-student', component: ManageStudentComponent },
{ path: 'manage-course', component: ManageCourseComponent },
{ path: 'manage-user', component: ManageUserComponent },
// { path: 'enrollment', component: CreateEnrollmentComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
