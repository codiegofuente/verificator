package com.test.verificador.infrastructure;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

@JacksonXmlRootElement(localName = "reading")
public class ClientReadingXml {
    @JacksonXmlProperty(localName = "clientID", isAttribute = true)
    private String clientId;
    @JacksonXmlProperty(localName = "period", isAttribute = true)
    private String period;
    @JacksonXmlText
    private Long reading;

    public ClientReadingXml() {
    }

    public ClientReadingXml(String clientId, String period, Long reading) {
        this.clientId = clientId;
        this.period = period;
        this.reading = reading;
    }

    public void setReading(Long reading) {
        this.reading = reading;
    }

    public Long getReading() {
        return reading;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getPeriod() {
        return period;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientId() {
        return clientId;
    }


}
