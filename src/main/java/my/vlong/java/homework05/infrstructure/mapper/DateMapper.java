package my.vlong.java.homework05.infrstructure.mapper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateMapper {

    private static final String PATTERN = "yyyy-MM-dd";
    private final DateFormat dateFormat;

    public DateMapper() {
        dateFormat = new SimpleDateFormat(PATTERN);
    }

    public Date toDate(String dateString) throws ParseException {
        Date date = null;
        if (dateString != null && !dateString.isEmpty()) {
            date = dateFormat.parse(dateString);
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
