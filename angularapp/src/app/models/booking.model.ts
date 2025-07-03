export interface Booking {

    bookingId?:string;
    flightId?:number;//ref to flight model
    userId?:number;//ref to user model
    bookingDate?:Date;
    numberOfPassengers?:number;
    status?:string;//CONFIRMED, CANCELED

}
