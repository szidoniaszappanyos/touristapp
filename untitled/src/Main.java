import java.util.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Main {

    public static void main(String[] args) throws ParseException {

        String sDate1="31/12/1998 10:30";
        Date date1=new SimpleDateFormat("dd/MM/yyyy hh:mm").parse(sDate1);
        Timestamp fromTS1 = new Timestamp(date1.getTime());
        System.out.println( fromTS1 );


    }
}
