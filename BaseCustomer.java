/**
 * The BaseCustomer class represents a base class for storing customer information.
 * It provides methods to retrieve various details of a customer, such as name, phone number,
 * email, number of people in reservation, date of reservation, and time of reservation.
 */

public abstract class BaseCustomer {

	//protected String Name;
	private String name;
    private String num;
    private String mail;
    private int res;
    private String date;
    private String time;
    private String ambiance;

	
		public BaseCustomer(String name, String num, String mail, int res, String date, String time, String ambiance)
		{
			this.name= name;
			this.num= num;
        	this.mail= mail;
        	this.res= res;
        	this.date= date;
        	this.time= time;
            this.ambiance=ambiance;
		}
		

		 /**
     * Retrieves the phone number of the customer.
     * @return The phone number.
     */
    public String getnNum() {
        return num;
    }

    /**
     * Retrieves the email address of the customer.
     * @return The email address.
     */
    public String getMail() {
        return mail;
    }

    /**
     * Retrieves the number of people in the reservation.
     * @return The number of people.
     */
    public int getRes() {
        return res;
    }

    /**
     * Retrieves the date of the reservation.
     * @return The date of the reservation.
     */
    public String getDate() {
        return date;
    }

    /**
     * Retrieves the time of the reservation.
     * @return The time of the reservation.
     */
    public String getTime() {
        return time;
    }

    /**
     * Retrieves the name of the customer.
     * @return The name of the customer.
     */
    public String getName() {
        return name;
    }

    public String getAmbiance(){
        return ambiance;
    }

    public String setName(String name){
        return name;
    }

    public String setnNum(String num){
        return num;
    }

    public String setMail(String Mail){
        return mail;
    }

    public int setRes(int Res){
        return res;
    }

    public String setDate(String newDate){
        return date;
    }

    public String setTime(String time){
        return time;
    }
}