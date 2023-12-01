package airbnb.server.persistence.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class ConvenienceDTO {
    public ConvenienceDTO(BasicConveDTO basicConveDTO, ManySearchConveDTO manySearchConveDTO, SafetyConveDTO safetyConveDTO, AccessibilityConvesDTO accessibilityConvesDTO, HouseConveDTO houseConveDTO) {
            this.basicConveDTO = basicConveDTO;
            this.manySearchConveDTO = manySearchConveDTO;
            this.safetyConveDTO = safetyConveDTO;
            this.accessibilityConvesDTO = accessibilityConvesDTO;
        this.houseConveDTO = houseConveDTO;
    }

    private BasicConveDTO basicConveDTO;
    private ManySearchConveDTO manySearchConveDTO;
    private SafetyConveDTO safetyConveDTO;
    private AccessibilityConvesDTO accessibilityConvesDTO;
    private HouseConveDTO houseConveDTO;
}
