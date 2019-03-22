package at.nacs.admission.endpoint;

import at.nacs.admission.domain.Patient;
import at.nacs.admission.logic.IdGiver;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor

public class PatientEndpoint {
    private final IdGiver idGiver;
    private final RestTemplate restTemplate;
    @Value("${diognose.url}")
    private String url;

    @PostMapping
    Patient add(@RequestBody Patient patient) {
        idGiver.giveId(patient);
        forward(patient);
        return patient;
    }

    String forward(@PathVariable Patient patient) {
        return restTemplate.postForObject(url, patient, String.class);
    }
}
