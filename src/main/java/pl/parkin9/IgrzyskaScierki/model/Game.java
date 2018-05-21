package pl.parkin9.IgrzyskaScierki.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="game_id")
    private Long id = 0L;

    @CreationTimestamp
    @Column(name = "start", updatable = false)
    private Date start;

    @NotNull
    @Column(name = "end")
    private Date end;

    @NotNull
    private Boolean active = true;

    @ManyToOne
    private PlayerGroup playerGroup;

///////////////////////////////////////////////////////////

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public PlayerGroup getPlayerGroup() {
        return playerGroup;
    }

    public void setPlayerGroup(PlayerGroup playerGroup) {
        this.playerGroup = playerGroup;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", start=" + start +
                ", end=" + end +
                ", active=" + active +
                ", playerGroup=" + playerGroup +
                '}';
    }
}
