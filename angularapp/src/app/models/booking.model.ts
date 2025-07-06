import { Flight } from "./flight.model";
import { User } from "./user.model";

export interface Booking {

    bookingId?:string;
    //flightId?:number;//ref to flight model
    //userId?:number;//ref to user model
    bookingDate?:Date;
    numberOfPassengers?:number;
    status?:string;//Approved, Rejected

    flight?:Flight;
    user?:User;

    //only numberOfPassengers in enough because status will set and then changed from admin side
    //bookingDate will be current date
    //the other three comes directly from different places
}
