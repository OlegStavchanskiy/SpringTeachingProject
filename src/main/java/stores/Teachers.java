package stores;

import lombok.Data;
import java.util.List;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
@Data
@Table
public class Teachers implements Serializable{
    @Id
    private Long id;
    @NotNull
    private String FIO;
    private Integer s_mark;
    @NotNull
    private String s_rank;
    private String rank;
    private List<Diciplines> disciplines;

}
