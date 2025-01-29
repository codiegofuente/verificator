package com.test.verificador.infrastructure;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JacksonXmlRootElement(localName = "readings")
public class ClientReadingsXml {
    @JacksonXmlElementWrapper(localName = "reading", useWrapping = false)
    private List<ClientReadingXml> reading;
}

