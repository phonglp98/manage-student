import { CourseDto } from "./courseDto";
import { StudentDto } from "./studentDto";

export interface EnrnollmentDto{
    id: number;
    student: StudentDto;
    course: CourseDto;
    enrollmentDate: string;
}