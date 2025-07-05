export interface Flight{

    flightId?:number;
    flightNumber:string;
    airline:string;
    departureLocation:string;
    arrivalLocation:string;
    departureTime:Date;//changed it to Date from string but Date will fail testcases
    arrivalTime:Date;//same
    price:number;
    totalSeats?:number;
    
}
