package com.test.verificador;

import com.test.verificador.application.find.FindUseCase;
import com.test.verificador.domain.model.ClientReading;
import com.test.verificador.domain.model.OutputRecord;
import com.test.verificador.domain.repository.CsvReader;
import com.test.verificador.domain.repository.QueryRepository;
import com.test.verificador.domain.repository.XmlReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class FindUseCaseTest {

    @Mock
    private CsvReader csvReader;

    @Mock
    private XmlReader xmlReader;

    @Autowired
    private FindUseCase findUseCase;

    private List<OutputRecord> expectedOutput;
    private String fileName;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        expectedOutput = new ArrayList<OutputRecord>();
        expectedOutput.add(new OutputRecord("583ef6329e237", "11", 1379L, 61551.57142857143));
        expectedOutput.add(new OutputRecord("583ef6329e271", "10", 121208L, 61551.57142857143));
        expectedOutput.add(new OutputRecord("583ef6329e3ab", "11", 6440L, 61551.57142857143));
        expectedOutput.add(new OutputRecord("583ef6329e41b", "05", 133369L, 61551.57142857143));
    }

    @Test
    void testFindSyspiciousReadings_withCsvFile() {
        fileName = "test.csv";
        List<OutputRecord> result = findUseCase.findSyspiciousReadings(fileName);
        assertEquals(expectedOutput, result);
    }

    @Test
    void testFindSyspiciousReadings_withXmlFile() {
        fileName = "test.xml";
        List<OutputRecord> result = findUseCase.findSyspiciousReadings(fileName);
        assertEquals(expectedOutput, result);
    }

    @Test
    void testFindSyspiciousReadings_withUnsupportedFileType() {
        fileName = "readings.txt";

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            findUseCase.findSyspiciousReadings(fileName);
        });

        assertEquals("El tipo de archivo facilitado no es compatible.", exception.getMessage());
    }
}
