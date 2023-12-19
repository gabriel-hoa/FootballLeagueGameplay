package footballleague.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter
public class CodenameService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Environment env;

    private List<String> laligaCodenameList = new ArrayList<>();
    private List<String> serieaCodenameList = new ArrayList<>();
    private List<String> premierleagueCodenameList = new ArrayList<>();


    ObjectMapper objectMapper = new ObjectMapper();

    @PostConstruct

    public void loadJsonData(){

        try {
            String codenameResponse = restTemplate.getForObject(env.getProperty("laliga"), String.class);
            JsonNode jsonNode = objectMapper.readTree(codenameResponse);

            ArrayNode laliga = (ArrayNode) jsonNode.get("laliga");

            for(JsonNode item: laliga) {
                this.laligaCodenameList.add(item.get("codename").asText());

            }


        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void loadJsonData(){

        try {
            String codenameResponse = restTemplate.getForObject(env.getProperty("seriea"), String.class);
            JsonNode jsonNode = objectMapper.readTree(codenameResponse);

            ArrayNode seriea = (ArrayNode) jsonNode.get("seriea");

            for(JsonNode item: seriea) {
                this.serieaCodenameList.add(item.get("codename").asText());

            }

        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void loadJsonData(){

        try {
            String codenameResponse = restTemplate.getForObject(env.getProperty("premierleague"), String.class);
            JsonNode jsonNode = objectMapper.readTree(codenameResponse);

            ArrayNode premierleague = (ArrayNode) jsonNode.get("premierleague");

            for(JsonNode item: premierleague) {
                this.premierleagueCodenameList.add(item.get("codename").asText());

            }


        } catch(Exception e){
            e.printStackTrace();
        }
    }




}
