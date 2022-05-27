package DataAccess;

import Application.DataTypes.BookingTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.Statement;



public class BookingTableData {

    //fields
    private static Statement statement;
    private static ObservableList<BookingTable> bookingTableItems;


    //get booking table items
    public static ObservableList<BookingTable> getBookingTableItems() {
        bookingTableItems = FXCollections.observableArrayList();

        try{
            statement = DataConnection.getConnection().createStatement();
            ResultSet rs = statement.executeQuery("SELECT departure_date, departure_city, arrival_city, first_name, last_name, booking_id\n" +
                    "                    FROM booking b JOIN  flight f\n" +
                    "                    ON b.flight_id1 = f.flight_id\n" +
                    "                    JOIN customer c\n" +
                    "                    ON b.customer_id1 = c.customer_id\n" +
                    "                    JOIN schedule s\n" +
                    "                    ON f.schedule_id1 = s.schedule_id\n" +
                    "                    JOIN airline a\n" +
                    "                    ON f.airline_id1 = a.airline_id\n" +
                    "                    ORDER BY departure_date;");

            if(rs!=null)
                while(rs.next()){
                    BookingTable b = new BookingTable();
                    b.setDeparture_date(rs.getDate(1).toString());
                    b.setRoute(rs.getString(2) + " -> " + rs.getString(3));
                    b.setCustomer(rs.getString(4) + " " + rs.getString(5));
                    b.setBooking_id(rs.getInt(6));

                    bookingTableItems.add(b);
                }
        }

        catch(Exception e){
            e.printStackTrace();
        }

        return  bookingTableItems;
    }

}
