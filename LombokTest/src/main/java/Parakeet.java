import lombok.*;

/*
@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
*/
@Value
public class Parakeet {
    private String name;
    private ParakeetColor color;
    private Boolean canTalk;

    public enum ParakeetColor{
        LIGHT_GREEN, DARK_GREEN,
        LIGHT_BLUE, DARK_BLUE,
        VIOLETTE, WHITE
    }
}
