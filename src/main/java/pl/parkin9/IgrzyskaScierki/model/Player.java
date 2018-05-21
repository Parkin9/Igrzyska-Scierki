package pl.parkin9.IgrzyskaScierki.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="player_id")
    private Long id;

    @NotBlank
    @Column(name="name")
    private String name;

    @Column(name="score")
    private Integer score = 0;

    @ManyToOne
    private PlayerGroup playerGroup;

//////////////////////////////////////////////////////

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public PlayerGroup getPlayerGroup() {
        return playerGroup;
    }

    public void setPlayerGroup(PlayerGroup playerGroup) {
        this.playerGroup = playerGroup;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                ", playerGroup=" + playerGroup +
                '}';
    }
}
