package com.test.verificador.domain.model;


import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class ClientReading {
    private String clientId;
    private String period;
    private Long reading;

    public ClientReading(String clientId, String period, Long reading) {
        this.clientId = clientId;
        this.period = period;
        this.reading = reading;
    }

    public ClientReading() {
        this.clientId = "";
        this.period = "";
        this.reading = 0L;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ClientReading clientReading = (ClientReading) obj;
        return Objects.equals(clientId, clientReading.clientId) && Objects.equals(period, clientReading.period) && Objects.equals(reading, clientReading.reading);
    }
}

