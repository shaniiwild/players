package com.intuit.player.util;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.experimental.UtilityClass;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Utility class for CSV operations
 */
@UtilityClass
public class CSVUtil {
    /**
     * Create objects based on CSV input file
     *
     * @param path   CSV file Path
     * @param target Bean class
     * @return List of objects
     * @throws Exception
     */
    public <T> List<T> csvToBeanBuilder(Path path, Class<T> target) throws Exception {
        BufferedReader reader = Files.newBufferedReader(path);
        CsvToBean<T> csvToBean = new CsvToBeanBuilder<T>(reader)
                .withType(target)
                .withIgnoreLeadingWhiteSpace(true).build();
        return csvToBean.parse();
    }
}
