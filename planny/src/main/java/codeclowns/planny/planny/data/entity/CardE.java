package codeclowns.planny.planny.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Card")
public class CardE {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id")
    private Integer cardId;

    @Column(name = "title", length = 128, nullable = false)
    private String title;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "cover", length = 128)
    private String cover;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "due_date")
    private Date dueDate;

    @Column(name = "is_completed")
    private boolean isCompleted;

    @Column(name = "short_name", length = 63, unique = true)
    private String shortName;

    @Column(name = "slug_url", length = 63, unique = true)
    private String slugUrl;

    @Column(name = "is_enabled")
    private boolean isEnabled ;

    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "list_id")
    private ListE list;

    @OneToMany(mappedBy = "card", cascade = {
            CascadeType.ALL,
    })
    private List<CardConductorE> cardConductorEList;

}
