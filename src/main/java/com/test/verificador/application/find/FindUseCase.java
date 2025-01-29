package com.test.verificador.application.find;

import com.test.verificador.domain.model.ClientReading;
import com.test.verificador.domain.model.OutputRecord;
import com.test.verificador.domain.repository.CsvReader;
import com.test.verificador.domain.repository.QueryRepository;
import com.test.verificador.domain.repository.XmlReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

@Slf4j
@Service
@RequiredArgsConstructor
public class FindUseCase {
    private final QueryRepository queryRepository;
    private final CsvReader csvReader;
    private final XmlReader xmlReader;
    public List<OutputRecord> findSyspiciousReadings(String fileName){
        List<ClientReading> readings;
        String[] filaNameAndExtension = fileName.split(Pattern.quote("."));
        switch (filaNameAndExtension[1].toLowerCase()){
            case "csv":
                readings = csvReader.readCsvFile(fileName);
                break;
            case "xml":
                readings = xmlReader.readXmlFile(fileName);
                break;
            default:
                throw new RuntimeException("El tipo de archivo facilitado no es compatible.");
        }

        return this.queryRepository.findSyspiciousReadings(readings);
    }
}
