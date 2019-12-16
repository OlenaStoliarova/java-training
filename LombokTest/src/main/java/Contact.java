import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Builder
@ToString
public class Contact {
    @NonNull
    private String name;
    @NonNull
    private String phone;
    private String email;
    private String skype;
    private String telegram;
    private String viber;
    @Builder.Default private LocalDate created = LocalDate.now();
}
