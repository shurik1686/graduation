package ru.shurik16.graduation.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "vote")
public class Vote extends AbstractBaseEntity{

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "RESTAURANT_ID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    //@NotNull
    private Restaurant restaurant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    //@NotNull
    private User user;

    @Column(name = "DATE_TIME", nullable = false)
    @NotNull
    private LocalDateTime dateTime;

    public Vote() {

    }

    public Vote(Vote vote) {
      this(vote.getId(),vote.getRestaurant(),vote.getUser(),vote.getDateTime());
    }

    public Vote(@NotNull LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Vote(Integer id, Restaurant restaurant, User user, @NotNull LocalDateTime dateTime) {
        super(id);
        this.restaurant = restaurant;
        this.user = user;
        this.dateTime = dateTime;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public LocalDate getDate() {
        return dateTime.toLocalDate();
    }

    public LocalTime getTime() {
        return dateTime.toLocalTime();
    }

    @Override
    public String toString() {
        return "Vote{" +
                "id=" + id +
                ", restaurant=" + restaurant +
                ", user=" + user.getId() +
                ", dateTime=" + dateTime +
                '}';
    }
}
