import { UserDto } from "./userDto";

export interface StudentDto{
    id:number;
    user: UserDto;
    firstName:string;
    lastName:string;
    email:string;
    dateOfBirth:string;
    address:string;
}