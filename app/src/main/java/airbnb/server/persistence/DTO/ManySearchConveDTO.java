package airbnb.server.persistence.DTO;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class ManySearchConveDTO implements Serializable {
    public ManySearchConveDTO(boolean pool, boolean wifi, boolean kitchen, boolean free_parking, boolean jacuzzi, boolean washer_dryer, boolean air_conditioner, boolean self_check_in, boolean notebook_work_space, boolean can_pets) {
        this.pool = pool;
        this.wifi = wifi;
        this.kitchen = kitchen;
        this.free_parking = free_parking;
        this.jacuzzi = jacuzzi;
        this.washer_dryer = washer_dryer;
        this.air_conditioner = air_conditioner;
        this.self_check_in = self_check_in;
        this.notebook_work_space = notebook_work_space;
        this.can_pets = can_pets;
    }

    public ManySearchConveDTO(boolean pool, boolean wifi, boolean kitchen, boolean free_parking, boolean jacuzzi, boolean washer_dryer, boolean air_conditioner, boolean self_check_in, boolean notebook_work_space, boolean can_pets, int manysearchconve_no) {
        this(pool, wifi, kitchen, free_parking, jacuzzi, washer_dryer, air_conditioner, self_check_in, notebook_work_space, can_pets);
        this.manysearchconve_no = manysearchconve_no;
    }

    private boolean pool, wifi, kitchen, free_parking, jacuzzi, washer_dryer, air_conditioner, self_check_in, notebook_work_space, can_pets;
    private int manysearchconve_no;

    public void print(){
        System.out.println("pool > " + pool + ", wifi > " + wifi + ", kitchen > " + kitchen + ", free_parking > " + free_parking + ", jacuzzi > " + jacuzzi + ", washer_dryer > " + washer_dryer + ", air_conditioner > " + air_conditioner + ",self_check_in > " + self_check_in + ", notebook_work_space > " + notebook_work_space + ", can_pets > " + can_pets);
    }

    public ManySearchConveDTO lineToDTO(String line){
        ManySearchConveDTO temp = new ManySearchConveDTO();
        String[] tokens = line.split(",");
        for(String token : tokens){
            switch(Integer.parseInt(token.trim())){
                case 1:
                    temp.pool = true;
                    break;
                case 2:
                    temp.wifi = true;
                    break;
                case 3:
                    temp.kitchen = true;
                    break;
                case 4:
                    temp.free_parking = true;
                    break;
                case 5:
                    temp.jacuzzi = true;
                    break;
                case 6:
                    temp.washer_dryer = true;
                    break;
                case 7:
                    temp.air_conditioner = true;
                    break;
                case 8:
                    temp.self_check_in = true;
                    break;
                case 9:
                    temp.notebook_work_space = true;
                    break;
                case 10:
                    temp.can_pets = true;
                    break;
                default:
                    break;
            }
        }
        return temp;
    }
}
