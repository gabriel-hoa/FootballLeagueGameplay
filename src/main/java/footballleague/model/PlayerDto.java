package footballleague.model;

public record PlayerDto(

        String name,
        String email,
        String phoneNumber,
        GroupType groupType
) {

}
