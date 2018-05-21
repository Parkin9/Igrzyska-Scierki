package pl.parkin9.IgrzyskaScierki.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name ="player_groups")
public class PlayerGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_group_id")
    private long id;

    @NotBlank(message = "*Pole obowiązkowe.")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "*Pole obowiązkowe.")
    @Size(min = 6, message = "*Minimum 6 znaków.")
    @Column(name = "password")
    private String password;

/////////////////////////////////////////////////////////////

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "PlayerGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
