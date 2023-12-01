package airbnb.server.persistence.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class SafetyConveDTO {
    public SafetyConveDTO(boolean carbon_Monoxide, boolean fire_waring, boolean extinguisher, boolean aid_kit, boolean emergencyInformation) {
        this.carbon_Monoxide = carbon_Monoxide;
        this.fire_waring = fire_waring;
        this.extinguisher = extinguisher;
        this.aid_kit = aid_kit;
        this.emergencyInformation = emergencyInformation;
    }

    public SafetyConveDTO(boolean carbon_Monoxide, boolean fire_waring, boolean extinguisher, boolean aid_kit, boolean emergencyInformation, int safetyconve_no) {
        this(carbon_Monoxide, fire_waring, extinguisher, aid_kit, emergencyInformation);
        this.safetyconve_no = safetyconve_no;
    }

    private boolean carbon_Monoxide, fire_waring, extinguisher, aid_kit, emergencyInformation;
    private int safetyconve_no;

    public void print(){
        System.out.println("carbon_Monoxide > " + carbon_Monoxide + ", fire_waring > " + fire_waring + ", extinguisher > " + extinguisher + ", aid_kit > " + aid_kit + ", emergencyInformation > " + emergencyInformation);
    }

    public SafetyConveDTO lineToDTO(String line){
        SafetyConveDTO temp = new SafetyConveDTO();
        String[] tokens = line.split(",");
        for(String token : tokens){
            switch(Integer.parseInt(token.trim())){
                case 1:
                    temp.carbon_Monoxide = true;
                    break;
                case 2:
                    temp.fire_waring = true;
                    break;
                case 3:
                    temp.extinguisher = true;
                    break;
                case 4:
                    temp.aid_kit = true;
                    break;
                case 5:
                    temp.emergencyInformation = true;
                    break;
                default:
                    break;
            }
        }
        return temp;
    }
}
