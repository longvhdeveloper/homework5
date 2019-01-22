package my.vlong.java.homework05.infrstructure.mapper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DateMapper {

    private static final String PATTERN = "yyyy-MM-dd";
    private final DateFormat dateFormat;

    public DateMapper() {
        dateFormat = new SimpleDateFormat(PATTERN);
    }

    public Date toDate(String dateString) {
        Date date = null;
        if (dateString != null && !dateString.isEmpty()) {
            try {
                date = dateFormat.parse(dateString);
            } catch (ParseException ex) {
                Logger.getLogger(DateMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return date;
    }

    public String toDateString(Date date) {
        String dateString = "";
        if (date != null) {
            dateString = dateFormat.format(date);
        }

        return dateString;
    }

}
