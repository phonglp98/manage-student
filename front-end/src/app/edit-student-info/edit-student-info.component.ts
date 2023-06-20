import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA,MatDialogRef} from '@angular/material/dialog';
import { StudentDto } from '../entity/studentDto';
import { StudentService } from '../service/student.service';

@Component({
  selector: 'app-edit-student-info',
  templateUrl: './edit-student-info.component.html',
  styleUrls: ['./edit-student-info.component.scss']
})
export class EditStudentInfoComponent {
  constructor(@Inject(MAT_DIALOG_DATA) public data: StudentDto,
  public dialogRef: MatDialogRef<EditStudentInfoComponent>,
  private studentService: StudentService) {}

  onNoClick(): void {
    this.dialogRef.close();
  }
}
