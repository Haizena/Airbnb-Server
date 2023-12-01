package airbnb.server.persistence.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class BasicConveDTO {
    public BasicConveDTO(boolean toiletPaper, boolean soap, boolean towel, boolean bedclothes, boolean pilow, boolean cleaningSupplies) {
        this.toiletPaper = toiletPaper;
        this.soap = soap;
        this.towel = towel;
        this.bedclothes = bedclothes;
        this.pilow = pilow;
        this.cleaningSupplies = cleaningSupplies;
    }

    public BasicConveDTO(boolean toiletPaper, boolean soap, boolean towel, boolean bedclothes, boolean pilow, boolean cleaningSupplies, int basicconve_no) {
        this(toiletPaper, soap, towel, bedclothes, pilow, cleaningSupplies);
        this.basicconve_no = basicconve_no;
    }

    private boolean toiletPaper, soap, towel, bedclothes, pilow, cleaningSupplies;
    private int basicconve_no;

    public void print(){
        System.out.println("toiletPaper > " + toiletPaper + ", soap > " + soap + ", towel > " + towel + ", bedclothes > " + bedclothes + ", pilow > " + pilow + ", cleaningSupplies > " + cleaningSupplies);
    }

    public BasicConveDTO lineToDTO(String line){
        BasicConveDTO temp = new BasicConveDTO();
        String[] tokens = line.split(",");
        for(String token : tokens){
            switch(Integer.parseInt(token.trim())){
                case 1:
                    temp.toiletPaper = true;
                    break;
                case 2:
                    temp.soap = true;
                    break;
                case 3:
                    temp.towel = true;
                    break;
                case 4:
                    temp.bedclothes = true;
                    break;
                case 5:
                    temp.pilow = true;
                    break;
                case 6:
                    temp.cleaningSupplies = true;
                    break;
                default:
                    break;
            }
        }
        return temp;
    }
}
