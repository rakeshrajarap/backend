package prep.SpringBootApplication_1.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users", schema = "pint")
public class  User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uesr_id") // Note: keeping the typo as it exists in your DB
    private Integer userId;

    @Column(name = "first_name", length = 30)
    private String firstName;

    @Column(name = "last_name", length = 30)
    private String lastName;

    @Column(name = "user_name", length = 60)
    private String userName;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "mobilenumber")
    private Long mobileNumber;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "address", columnDefinition = "jsonb")
    private String address;

    @Column(name = "inserted_time")
    private LocalDateTime insertedTime;

    @Column(name = "inserted_by")
    private String insertedBy;
}
