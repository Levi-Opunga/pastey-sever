package dev.levi.pastey.pastedtexts;

import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class ClipNote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false )
    private Long id;

    @Column(length = 10000)
    private String text;

    @Column(length = 10000)
    private String title;
    private String date;
    private String username;
    private boolean hidden;

}
