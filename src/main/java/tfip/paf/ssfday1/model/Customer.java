package tfip.paf.ssfday1.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    private Integer id;
    private String first_name;
    private String last_name;
    private Date dob;

    
}
