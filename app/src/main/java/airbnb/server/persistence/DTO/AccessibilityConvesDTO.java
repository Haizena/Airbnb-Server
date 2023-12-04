
package airbnb.server.persistence.DTO;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class AccessibilityConvesDTO implements Serializable {
    public AccessibilityConvesDTO(boolean no_stair_entrance, boolean entrance_width, boolean corridor_width) {
        this.no_stair_entrance = no_stair_entrance;
        this.entrance_width = entrance_width;
        this.corridor_width = corridor_width;
    }

    public AccessibilityConvesDTO(boolean no_stair_entrance, boolean entrance_width, boolean corridor_width, int accessibilityconve_no) {
        this(no_stair_entrance, entrance_width, corridor_width);
        this.accessibilityconve_no = accessibilityconve_no;
    }

    private boolean no_stair_entrance, entrance_width, corridor_width;
    private int accessibilityconve_no;

    public void print(){
        System.out.println("no_stair_entrance > " + no_stair_entrance + ", entrance_width > " + entrance_width + ", corridor_width > " + corridor_width);
    }

    public AccessibilityConvesDTO lineToDTO(String line){
        AccessibilityConvesDTO temp = new AccessibilityConvesDTO();
        String[] tokens = line.split(",");
        for(String token : tokens){
            switch(Integer.parseInt(token.trim())){
                case 1:
                    temp.no_stair_entrance = true;
                    break;
                case 2:
                    temp.entrance_width = true;
                    break;
                case 3:
                    temp.corridor_width = true;
                    break;
                default:
                    break;
            }
        }
        return temp;
    }
}
