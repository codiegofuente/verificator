package com.test.verificador.infrastructure;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.test.verificador.domain.model.ClientReading;
import com.test.verificador.domain.repository.CsvReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Component
public class CsvReaderImpl implements CsvReader {

        @Value("${files.path}")
        private String filesPath;
        @Value("${csv.file.header}")
        private String csvFileHeader;

        @Override
        public List<ClientReading> readCsvFile(String fileName) {
            List<ClientReading> readings = new ArrayList<>();

            try (CSVReader reader = new CSVReader(new FileReader(filesPath + fileName))) {
                String[] nextLine;
                while ((nextLine = reader.readNext()) != null) {
                    if(!(nextLine[0] + "," + nextLine[1] + "," + nextLine[2]).equals(csvFileHeader))
                        readings.add(new ClientReading(nextLine[0], nextLine[1], Long.parseLong(nextLine[2])));
                }
            } catch (IOException | CsvValidationException e) {
                throw new RuntimeException("Error al leer el archivo CSV", e);
            }
            return readings;
        }
}
