package ru.shurik16.graduation.repository;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import ru.shurik16.graduation.model.Vote;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class VoteRepository {

    private static final Sort SORT_RESTAURANT = Sort.by(Sort.Direction.ASC, "restaurant.name");

    private final CrudVoteRepository crudRepository;

    private final CrudRestaurantRepository restaurantRepository;

    private final CrudUserRepository userRepository;

    public VoteRepository(CrudVoteRepository crudRepository, CrudRestaurantRepository restaurantRepository, CrudUserRepository userRepository) {
        this.crudRepository = crudRepository;
        this.restaurantRepository = restaurantRepository;
        this.userRepository = userRepository;
    }

    public Vote save(Vote vote) {
        return crudRepository.save(vote);
    }

    public Vote save(int id_restaurant) {
        Vote vote = new Vote(LocalDateTime.now());
        vote.setRestaurant(restaurantRepository.getOne(id_restaurant));
        vote.setUser(userRepository.getOne(100000));
        return crudRepository.save(vote);
    }



    public boolean delete(int id) {
        return crudRepository.delete(id) != 0;
    }

    public Vote get(int id) {
        return crudRepository.findById(id).orElse(null);
    }

    public List<Vote> getAll() {
        return crudRepository.findAll(SORT_RESTAURANT);
    }
}
