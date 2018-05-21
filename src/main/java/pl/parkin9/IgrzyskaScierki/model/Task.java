package pl.parkin9.IgrzyskaScierki.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="task_id")
    private Long id;

    @NotBlank
    @Column(name = "name")
    private String name;

    @NotNull
    //  @Min(value = 1)
    @Column(name = "points_value")
    private Integer pointsValue;

    @ManyToOne
    private PlayerGroup playerGroup;

///////////////////////////////////////////////////////

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

    public Integer getPointsValue() {
        return pointsValue;
    }

    public void setPointsValue(Integer pointsValue) {
        this.pointsValue = pointsValue;
    }

    public PlayerGroup getPlayerGroup() {
        return playerGroup;
    }

    public void setPlayerGroup(PlayerGroup playerGroup) {
        this.playerGroup = playerGroup;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pointsValue=" + pointsValue +
                ", playerGroup=" + playerGroup +
                '}';
    }
}
