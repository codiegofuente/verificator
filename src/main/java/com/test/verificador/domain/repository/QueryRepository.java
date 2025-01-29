package com.test.verificador.domain.repository;

import com.test.verificador.domain.model.ClientReading;
import com.test.verificador.domain.model.OutputRecord;

import java.util.List;

public interface QueryRepository {
    List<OutputRecord> findSyspiciousReadings(List<ClientReading> readings);
}
