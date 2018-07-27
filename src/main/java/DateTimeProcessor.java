import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTimeProcessor {
    /**
     * convert between different datetime string format
     * @param dt_str datetime string to convert
     * @param in_format input datetime format
     * @param out_format out put datetime format
     * @return coverted datetime string
     */
    private static String convertDateTimeFormat(String dt_str, String in_format, String out_format){
        SimpleDateFormat input = new SimpleDateFormat(in_format);
        SimpleDateFormat output = new SimpleDateFormat(out_format);
        try{
            Date dateValue = input.parse(dt_str);
            return output.format(dateValue);
        }catch (Exception e){
            System.out.println("Error when parse dt str" + e);
        }
        return null;
    }

    /**
     * convert datetime string from one format to another
     * @param dt_str datetime string to convert
     * @param in_format input datetime format
     * @param out_format out put datetime format
     * @return datetime string in type of out_format
     */
    public static String convertDateTimeFormatNew(String dt_str, String in_format, String out_format){
        DateTimeFormatter format_in = DateTimeFormatter.ofPattern(in_format);
        DateTimeFormatter format_out = DateTimeFormatter.ofPattern(out_format);
        LocalDateTime localDatetime = LocalDateTime.parse(dt_str, format_in);

        return localDatetime.format(format_out);
    }

    /**
     * shift a datetime string several minutes back
     * @param dtStr datetime string to shift, in type yyyyMMddHHmm
     * @param shift how many minutes to shift back
     * @return shifted datetime string
     */
    public static String shiftDateTimeStr (String dtStr, int shift) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmm");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm");

        try{
            Date parsedDate = sdf.parse(dtStr);
            LocalDateTime localDateTime = parsedDate.toInstant().atZone(
                        ZoneId.systemDefault()).toLocalDateTime();

            LocalDateTime res_dt = localDateTime.minusMinutes(shift);
            return res_dt.format(formatter);
        }catch (java.text.ParseException parse_e){
            System.out.println("Error when shift datetime string" + parse_e);
        }
        return null;
    }

    /**
     * shift a datetime string several minutes back
     * @param dtStr datetime string to shift, in type yyyyMMddHHmm
     * @param shift how many minutes to shift back
     * @return shifted datetime string
     */
    public static String shiftDateTimeStrNew (String dtStr, int shift) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
        LocalDateTime localDateTime = LocalDateTime.parse(dtStr, formatter);

        LocalDateTime res_dt = localDateTime.minusMinutes(shift);
        return res_dt.format(formatter);
    }
}
