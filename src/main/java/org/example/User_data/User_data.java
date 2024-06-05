package org.example.User_data;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Getter
@Setter
public class User_data {
    private String Id;
    private String password;
    private String name;
    private String birthday;
    private int buildingNumber;
    private int managedFloor;
}


