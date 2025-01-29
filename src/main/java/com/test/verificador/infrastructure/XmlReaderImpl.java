package com.test.verificador.infrastructure;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.test.verificador.domain.model.ClientReading;
import com.test.verificador.domain.repository.XmlReader;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class XmlReaderImpl implements XmlReader {

        @Value("${files.path}")
        private String filesPath;

        @Override
        public List<ClientReading> readXmlFile(String fileName) {

            try {
                File file = new File(filesPath + fileName);
                XmlMapper xmlMapper = new XmlMapper();
                ClientReadingsXml clientReadingsXml = xmlMapper.readValue(file, ClientReadingsXml.class);
                return clientReadingsXml.getReading().stream()
                        .map(
                                reading
                                        -> new ClientReading(reading.getClientId(), reading.getPeriod(), reading.getReading())
                        )
                        .collect(Collectors.toList());
            } catch (StreamReadException e) {
                throw new RuntimeException("Error al leer el archivo XML", e);
            } catch (DatabindException e) {
                throw new RuntimeException("Error al leer el archivo XML", e);
            } catch (IOException e) {
                throw new RuntimeException("Error al leer el archivo XML", e);
            }
        }
}
