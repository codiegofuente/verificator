package com.test.verificador;

import com.test.verificador.domain.model.ClientReading;
import com.test.verificador.domain.repository.CsvReader;
import com.test.verificador.domain.repository.XmlReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class XmlReaderImplTest {
    @Autowired
    private XmlReader xmlReader;

    private List<ClientReading> clientReading;
    private String fileName;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        clientReading = new ArrayList<ClientReading>();
        clientReading.add(new ClientReading("583ef6329e237", "2016-11", 1379L));
        clientReading.add(new ClientReading("583ef6329e271", "2016-10", 121208L));
        clientReading.add(new ClientReading("583ef6329e2e2", "2016-01", 56667L));
        clientReading.add(new ClientReading("583ef6329e2e2", "2016-07", 55743L));
        clientReading.add(new ClientReading("583ef6329e2e2", "2016-10", 56055L));
        clientReading.add(new ClientReading("583ef6329e3ab", "2016-11", 6440L));
        clientReading.add(new ClientReading("583ef6329e41b", "2016-05", 133369L));

        fileName = "test.xml";
    }

    @Test
    void testLoadReadings_withXmlFile() {
        List<ClientReading> result = xmlReader.readXmlFile(fileName);
        assertEquals(clientReading, result);
    }
}
