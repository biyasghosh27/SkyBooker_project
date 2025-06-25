interface Booking {

    bookingId?:string;
    flightId?:number;
    userId?:number;
    bookingDate?:Date;
    numberOfPassengers?:number;
    status?:string;

}

module.exports = "Booking";