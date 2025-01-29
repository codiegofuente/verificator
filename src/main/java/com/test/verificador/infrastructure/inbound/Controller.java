package com.test.verificador.infrastructure.inbound;

import com.test.verificador.application.find.FindUseCase;
import com.test.verificador.domain.model.OutputRecord;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@Slf4j
@RequestMapping("/suspiciousReadings")
@RequiredArgsConstructor
public class Controller {
    private final FindUseCase findUseCase;

    @GetMapping
    public ResponseEntity findAllPosts(@RequestParam(required = true) String fileName){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("%-30s", "| Client").replace(" ", "&nbsp;"));
        stringBuilder.append(String.format("%-30s", "| Month").replace(" ", "&nbsp;"));
        stringBuilder.append(String.format("%-30s", "| Suspicious").replace(" ", "&nbsp;"));
        stringBuilder.append("| Median<br>");
        stringBuilder.append(String.format("%117s", "-<br>").replace(" ", "-"));
        List<OutputRecord> output = this.findUseCase.findSyspiciousReadings(fileName);
        output.stream().forEach(record -> stringBuilder.append(String.format("%-30s", "| " + record.getUserId()).replace(" ", "&nbsp;") +
                String.format("%-30s", "| " + record.getMonth()).replace(" ", "&nbsp;") +
                String.format("%-30s", "| " + record.getSuspiciousReading()).replace(" ", "&nbsp;") +
                "| " + record.getMedian() + "<br>"));
        return ResponseEntity.ok(stringBuilder);
    }
}
