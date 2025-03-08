/**
 * The CustomerInfo class extends the BaseCustomer class and implements the Comparable interface.
 * It represents customer information and provides methods to retrieve and compare customer details.
 */

public class CustomerInfo extends BaseCustomer implements Comparable<CustomerInfo> {

    public CustomerInfo(String name, String num, String mail, int res, String date, String time, String ambiance) {
        super(name, num, mail, res, date, time,ambiance );
    }
/**
 * Retrieves the formatted header for displaying customer information.
 * @return The formatted header string.
 */
    public static String getPHeader() {
        String returnval = "Name\tPhoneNumber\tEmail\tDate\tTimeofReservation\tNumberofPersons";
        returnval += "\n---------------------------------";
        return returnval;
    }

    public int compareTo(CustomerInfo other) {
        return Integer.compare(this.getRes(), other.getRes());
    }
}
