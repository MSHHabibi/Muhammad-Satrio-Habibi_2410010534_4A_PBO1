package travelriamkanan;

// No.14 ERROR HANDLING (exception buatan sendiri)
// No.8 INHERITANCE (extends Exception) 
public class CarterException extends Exception {
    // No.4 CONSTRUCTOR 
    public CarterException(String pesan) {
        super(pesan);
    }
}