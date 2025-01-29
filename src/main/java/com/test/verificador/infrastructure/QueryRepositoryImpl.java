package com.test.verificador.infrastructure;

import com.test.verificador.domain.model.ClientReading;
import com.test.verificador.domain.model.OutputRecord;
import com.test.verificador.domain.repository.QueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class QueryRepositoryImpl implements QueryRepository {

    @Override
    public List<OutputRecord> findSyspiciousReadings(List<ClientReading> readings) {
        double totalMedian = calculateMedia(readings);
        return readings.stream().
                filter(reading -> (reading.getReading() > totalMedian *  1.5 || reading.getReading() < totalMedian *  0.5))
                .map(
                        reading
                                -> new OutputRecord(reading.getClientId(), reading.getPeriod().split("-")[1], reading.getReading(), totalMedian)
                )
                .collect(Collectors.toList());
    }

    double calculateMedia(List<ClientReading> readings){
        return readings.stream()
                .mapToDouble(o -> o.getReading())
                .sum() / readings.size();
    }

}
