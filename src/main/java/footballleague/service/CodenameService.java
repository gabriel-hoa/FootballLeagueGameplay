package footballleague.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Getter
public class CodenameService {

    @Autowired
    private  RestTemplate restTemplate;

    @Autowired
    private Environment env;

    private List<String> laligaCodenameList = new ArrayList<>();

    ObjectMapper objectMapper = new ObjectMapper();

    public void loadJsonData(){

        try {
            String codenameResponse = restTemplate.getForObject(env.getProperty("LA_LIGA"), String.class);
        }
    }

}
