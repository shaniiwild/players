package com.intuit.player.util;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// Converts String to Date during CSV mapping to bean
public class CustomDateConverter extends AbstractBeanField<Date, String> {
    public CustomDateConverter() {
    }

    private final String[] formats = {"dd/MM/yyyy", "yyyy-MM-dd"};

    // try to parse date according to list of supported formats
    @Override
    protected Date convert(String s) throws CsvDataTypeMismatchException, CsvConstraintViolationException {
        for (String format : formats) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat(format);
                return dateFormat.parse(s);
            } catch (ParseException e) {
                // continue to try next format
            }
        }
        return null; // unable to parse with any format // todo notify user format is not supported (new exception IllegalArgument)
    }
}
