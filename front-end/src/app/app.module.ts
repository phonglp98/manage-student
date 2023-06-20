import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {MatRadioModule} from '@angular/material/radio';
import {MatButtonModule} from '@angular/material/button';
import {MatCardModule} from '@angular/material/card';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatInputModule} from '@angular/material/input';
import {MatSelectModule} from '@angular/material/select';
import {MatTableModule} from '@angular/material/table';
import { MatDialogModule } from '@angular/material/dialog';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { MatIconModule } from '@angular/material/icon';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatMenuModule} from '@angular/material/menu';
import { LoginComponent } from './login/login.component';
import { StudentComponent } from './student/student.component';
import { EditStudentInfoComponent } from './edit-student-info/edit-student-info.component';
import { CreateUserComponent } from './create-user/create-user.component';
import { CreateStudentComponent } from './create-student/create-student.component';
import { ManageStudentComponent } from './manage-student/manage-student.component';
import { ManageCourseComponent } from './manage-course/manage-course.component';
import { CreateCourseComponent } from './create-course/create-course.component';
import { ManageUserComponent } from './manage-user/manage-user.component';




@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    StudentComponent,
    EditStudentInfoComponent,
    CreateUserComponent,
    CreateStudentComponent,
    ManageStudentComponent,
    ManageCourseComponent,
    CreateCourseComponent,
    ManageUserComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    MatRadioModule,
    MatTableModule,
    MatButtonModule,
    MatCardModule,
    MatGridListModule,
    MatInputModule,
    MatSelectModule,
    MatDialogModule,
    HttpClientModule,
    CommonModule,
    MatIconModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    ReactiveFormsModule,
    MatToolbarModule,
    MatMenuModule,
    MatButtonModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
