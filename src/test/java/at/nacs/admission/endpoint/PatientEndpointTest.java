package at.nacs.admission.endpoint;

import at.nacs.admission.domain.Patient;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import static org.assertj.core.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)

class PatientEndpointTest {
    @Autowired
    TestRestTemplate restTemplate;
    String url = "/patient";

    @Test
    public void add() {
        Patient patient = new Patient("David", "headache","");
        Patient actual = restTemplate.postForObject(url, patient,Patient.class);
        assertThat(actual.getId()).isNotEmpty();

    }

}