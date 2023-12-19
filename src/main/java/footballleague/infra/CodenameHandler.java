package footballleague.infra;

import footballleague.model.GroupType;
import footballleague.service.CodenameService;
import org.springframework.beans.factory.annotation.Autowired;
public class CodenameHandler {

    @Autowired
    private CodenameService service;

    public String findCodename(GroupType groupType) {
        if (groupType == GroupType.LA_LIGA) {
            String firstMatch = service.getLaligaCodenameList().stream().findFirst().orElseThrow();
            this.service.getLaligaCodenameList().remove(firstMatch);
            return firstMatch;

        } else if (groupType == GroupType.SERIE_A) {
            String firstMatch = service.getSerieaCodenameList().stream().findFirst().orElseThrow();
            this.service.getSerieaCodenameList().remove(firstMatch);
            return firstMatch;
        }
        if (groupType == GroupType.PREMIER_LEAGUE) {
            String firstMatch = service.getPremierleagueCodenameList().stream().findFirst().orElseThrow();
            this.service.getPremierleagueCodenameList().remove(firstMatch);
            return firstMatch;
        }
    }
}
