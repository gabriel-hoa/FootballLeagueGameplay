package footballleague.controller;

import footballleague.model.Player;
import footballleague.model.PlayerDto;
import footballleague.service.PlayerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/players")
@RestController

public class PlayerController {

    @Autowired
    private PlayerService service;
    public ResponseEntity<Player> createPlayer(@RequestBody @Valid PlayerDto dto) {
        Player newPlayer = service.createPlayer(dto);

    }
}
