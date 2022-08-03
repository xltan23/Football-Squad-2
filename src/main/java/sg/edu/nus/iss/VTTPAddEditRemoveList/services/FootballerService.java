package sg.edu.nus.iss.VTTPAddEditRemoveList.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import sg.edu.nus.iss.VTTPAddEditRemoveList.models.Footballer;

@Service
public class FootballerService {
    private List<Footballer> players = new ArrayList<>();

    public void addPlayer(Footballer f) {
        players.add(new Footballer(f.getFullName(), f.getPosition(), f.getRatings()));
    }

    public void delPlayer(Footballer f) {
        Footballer toRemove = players.stream().filter(o -> o.getId().equals(f.getId())).findAny().orElse(null);
        players.remove(toRemove);
    }

    // public void updatedPlayer(Footballer f) {
    //     Footballer toUpdate = players.stream().filter(o -> o.getId().equals(f.getId())).findAny().orElse(null);
    //     Footballer updatedPlayer = new Footballer();
    //     updatedPlayer.setId(f.getId());
    //     updatedPlayer.setFullName(f.getFullName());
    //     updatedPlayer.setPosition(f.getPosition());
    //     updatedPlayer.setRatings(f.getRatings());

    //     players.remove(toUpdate);
    //     players.add(new Footballer(updatedPlayer.getId(), updatedPlayer.getFullName(), updatedPlayer.getPosition(), updatedPlayer.getRatings()));
    // }

    public List<Footballer> getPlayers() {
        return players;
    }

}
