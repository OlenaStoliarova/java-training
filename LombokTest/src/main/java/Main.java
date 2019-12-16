import lombok.extern.java.Log;

@Log
public class Main {
    public static void main(String[] args) {
        /*
        //Exception in thread "main" java.lang.NullPointerException: phone is marked non-null but is null
        Contact contact1 = Contact.builder()
                .name("Vladimir")
                .email("vova@gmail.com")
                .build();
         */

        Contact contact1 = Contact.builder()
                .name("Vladimir")
                .phone("+380501234569")
                .email("vova@gmail.com")
                .build();
        System.out.println(contact1.toString());
        System.out.println(contact1.getName());

        log.warning("test");

        Parakeet bird1 = new Parakeet("Kesha", Parakeet.ParakeetColor.LIGHT_GREEN, true);

        System.out.println(bird1.toString());
        //Before @ToString annotation was added >> Parakeet@1b6d3586
        //Before @ToString annotation was added >> Parakeet(name=Kesha, color=LIGHT_GREEN, canTalk=true)

        System.out.println(bird1.getName()); //here was a compiler error before @Getter annotation was added
        log.info(bird1.getColor().toString());


        Parakeet bird2 = new Parakeet("Kesha", Parakeet.ParakeetColor.LIGHT_GREEN, true);
        System.out.println("bird1 same as bird2? " + bird1.equals(bird2));
        //Before @EqualsAndHashCode annotation was added >> false
        //Before @EqualsAndHashCode annotation was added >> true

        Parakeet bird3 = new Parakeet("Petrusha", Parakeet.ParakeetColor.DARK_BLUE, true);
        System.out.println("bird1 same as bird3? " + bird1.equals(bird3)); //false
    }
}
