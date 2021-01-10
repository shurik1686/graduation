package ru.shurik16.graduation.service;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.shurik16.graduation.model.Restaurant;
import ru.shurik16.graduation.model.Vote;
import ru.shurik16.graduation.repository.VoteRepository;

import java.util.List;

import static ru.shurik16.graduation.util.ValidationUtil.checkNotFoundWithId;

@Service
public class VoteService {

    private final VoteRepository repository;

    public VoteService(VoteRepository repository) {
        this.repository = repository;
    }

    public Vote create(Vote vote) {
        Assert.notNull(vote, "vote must not be null");
        return repository.save(vote);
    }

    public Vote create(int id_restaurant) {
        Assert.notNull(id_restaurant, "id_restaurant must not be null");
        return repository.save(id_restaurant);
    }

    public void delete(int id) {
        checkNotFoundWithId(repository.delete(id), id);
    }

    public Vote get(int id) {
        return checkNotFoundWithId(repository.get(id), id);
    }


    public List<Vote> getAll() {
        return repository.getAll();
    }


    public void update(Vote vote) {
        Assert.notNull(vote, "vote must not be null");
        checkNotFoundWithId(repository.save(vote), vote.id());
    }
}
