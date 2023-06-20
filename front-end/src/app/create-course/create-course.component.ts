import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA,MatDialogRef } from '@angular/material/dialog';
import { CourseDto } from '../entity/courseDto';

@Component({
  selector: 'app-create-course',
  templateUrl: './create-course.component.html',
  styleUrls: ['./create-course.component.scss']
})
export class CreateCourseComponent {
  constructor(@Inject(MAT_DIALOG_DATA) public data: CourseDto,
  public dialogRef: MatDialogRef<CreateCourseComponent>) {}

  onNoClick(): void {
    this.dialogRef.close();
  }
}
