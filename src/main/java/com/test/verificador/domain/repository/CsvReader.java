package com.test.verificador.domain.repository;

import com.test.verificador.domain.model.ClientReading;

import java.util.List;

public interface CsvReader {
    List<ClientReading> readCsvFile(String fileName);
}
