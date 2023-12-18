package ma.emsi.control.dtos;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * BookDTO
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BookDTO {

    private String title;
    private String publisher;
    private LocalDate datePublication;
    private Float price;
    private String resume;

}