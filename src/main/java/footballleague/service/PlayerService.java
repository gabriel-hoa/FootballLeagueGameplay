package footballleague.service;

import footballleague.infra.CodenameHandler;
import footballleague.model.GroupType;
import footballleague.model.Player;
import footballleague.model.PlayerDto;
import footballleague.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PlayerService {

    @Autowired
    private PlayerRepository repository;

    @Autowired
    private CodenameHandler handler;

    public Player createPlayer(PlayerDto dto) {
        Player newPlayer = new Player(dto);
        String codename = getCodename(dto.groupType());
        newPlayer.setCodename(codename);
        return repository.save(newPlayer);

    }

    private String getCodename(GroupType groupType) {
        return handler.findCodename(groupType);

    }

}
