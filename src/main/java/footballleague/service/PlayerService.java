package footballleague.service;

import footballleague.model.Player;
import footballleague.model.PlayerDto;
import footballleague.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PlayerService {

    @Autowired
    private PlayerRepository repository;
    public Player createPlayer(PlayerDto dto) {
        Player newPlayer = new Player(dto);
        return repository.save(newPlayer);


    }
}
