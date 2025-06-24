interface Booking{
    bookingId?:number;
    flightId?:number;//reference to flight model
    userId?:number;//reference to user model
    bookingDate?:Date;
    numberOfPassengers?:number;
    status?:string//CONFIRMED,CANCELED
}