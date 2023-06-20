import { EnrnollmentDto } from "./enrollmentDto";

export interface CourseDto{
    id:number;
    name:string;
    description:string;
    startDate:string;
    endDate:string;
    capacity:number;
}