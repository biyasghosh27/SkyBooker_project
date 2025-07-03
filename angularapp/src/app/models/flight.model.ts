export interface Flight{

    flightId?:number;
    flightNumber:string;
    airline:string;
    departureLocation:string;
    arrivalLocation:string;
    departureTime:string;//change to string for time only
    arrivalTime:string;//change to string for time only
    price:number;
    totalSeats?:number;
    
}
