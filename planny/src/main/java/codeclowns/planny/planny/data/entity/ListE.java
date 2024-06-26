package codeclowns.planny.planny.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="List")
public class ListE {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="list_id")
    private Integer listId;
    @Column(name="title", length=63, nullable=false)
    private String title;
    @Column(name="ordinal_nummeral", length=63, nullable=false)
    private int ordinalNummeral;
    @Column(name="is_enabled", nullable = false)
    private Boolean isEnable;

    @OneToMany(mappedBy = "list", cascade = {
            CascadeType.ALL,
    })
    private List<CardE> cardEList;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="board_id", nullable=false)
    private BoardE board;
}
