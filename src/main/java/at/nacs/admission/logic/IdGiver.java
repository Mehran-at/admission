package at.nacs.admission.logic;

import at.nacs.admission.domain.Patient;
import org.springframework.stereotype.Component;
import java.util.UUID;

@Component
public class IdGiver {
    public Patient giveId(Patient  patient) {
        patient.setId(UUID.randomUUID().toString());
        return patient;
    }
}
