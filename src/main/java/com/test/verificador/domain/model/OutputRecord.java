package com.test.verificador.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@AllArgsConstructor
@Getter
@Setter
public class OutputRecord {
    private String userId;
    private String month;
    private Long suspiciousReading;
    private Double median;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        OutputRecord outputRecord = (OutputRecord) obj;
        return Objects.equals(userId, outputRecord.userId) && Objects.equals(month, outputRecord.month) && Objects.equals(suspiciousReading, outputRecord.suspiciousReading) && Objects.equals(median, outputRecord.median);
    }
}
