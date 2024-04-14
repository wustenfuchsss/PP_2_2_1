package hiber.model;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "cars")
@Entity
public class Car implements Serializable {
    @Column
    private String model;
    @Column
    private int series;

    @Id
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;


    public Car() {
    }

    public Car(User user,String model, int series) {
        this.user = user;
        this.model = model;
        this.series = series;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
