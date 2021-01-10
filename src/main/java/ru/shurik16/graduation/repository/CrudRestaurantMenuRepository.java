package ru.shurik16.graduation.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.shurik16.graduation.model.Restaurant;
import ru.shurik16.graduation.model.Restaurant_menu;

import java.time.LocalDateTime;
import java.util.List;

@Transactional(readOnly = true)
public interface CrudRestaurantMenuRepository extends JpaRepository<Restaurant_menu,Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Restaurant_menu m WHERE m.id=:id")
    int delete(@Param("id") int id);

    @Query("SELECT m from Restaurant_menu m WHERE m.restaurant.id=:restaurantId AND m.date >= :startDate AND m.date < :endDate ORDER BY m.date DESC")
    List<Restaurant_menu> getBetweenHalfOpen(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate, @Param("restaurantId") int restaurantId);

    @Query("SELECT m from Restaurant_menu m WHERE m.date >= :startDate AND m.date < :endDate ORDER BY m.restaurant.id DESC")
    List<Restaurant_menu> getBetweenHalfOpen(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

}
