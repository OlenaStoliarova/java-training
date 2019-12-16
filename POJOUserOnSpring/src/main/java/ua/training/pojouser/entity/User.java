package ua.training.pojouser.entity;

import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@ToString
public class User {
    @NonNull
    private final String login;
    @NonNull
    private String password;
    @NonNull
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    @Builder.Default private State state = State.INACTIVE;
    @Builder.Default private LocalDate created = LocalDate.now();

    public enum State{
        INACTIVE,
        ACTIVE,
        BLOCKED
    }
}
