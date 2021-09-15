package kata1;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Person {
    private final String name;
    private final Calendar birthdate;
    private final long MILLISECONDS_PER_YEAR = (long) (1000*60*60*24*365.25);
    
    public Person(String name, Calendar birthdate){
        this.name = name;
        this.birthdate = birthdate;
    }
    
    public String getName(){
        return this.name;
    }
    
    public Calendar getDate(){
        return this.birthdate;
    }
    
    public int getAge(){
        Date date = new Date();
        ZoneId timeZone = ZoneId.systemDefault();
        LocalDate getLocalDate = date.toInstant().atZone(timeZone).toLocalDate();
        return (int) (Period.between(LocalDate.ofInstant(birthdate.toInstant(), ZoneId.systemDefault()), getLocalDate).getYears());
    }
    
    private long millisecondsToYear (long milles){
        return milles / MILLISECONDS_PER_YEAR;
    }
}
