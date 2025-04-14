package org.example.ds.interview;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateConvertor {

    /**
     *
     * Not a Thread Safe
     * @param inputDate
     * @return
     */
    static String oldParser(String inputDate){
        SimpleDateFormat sdfInput = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdfOutput = new SimpleDateFormat("dd-MM-YYYY");
        String outputDate = null;
        try {
            Date parseDate = sdfInput.parse(inputDate);
            outputDate = sdfOutput.format(parseDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return outputDate;

    }

    /**
     * Thread Safe
     * @param inputDate
     * @return
     */
    static String newParser(String inputDate){
        LocalDate datformat = LocalDate.parse(inputDate);
        String formattedDate = datformat.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        return formattedDate;

    }

    public static void main(String[] args) {

        String inputDate = "2024-06-29";
        System.out.println(" OLd Parser : "+ oldParser(inputDate));
        System.out.println(" New Parser : "+ newParser(inputDate));

    }
}
