package ua.training.notebook.controller;

public interface NoteBookRegExs {
    String EMPTY_STRING = "^$";

    // Cyrillic name
    String NAME_UKR = "^[А-ЩЬЮЯҐІЇЄа-щьюяґіїє]+([' -]?[А-ЩЬЮЯҐІЇЄа-щьюяґіїє]+)*$";
    // Latin name
    String NAME_LAT = "^[a-zA-Z]+([' -]?[a-zA-Z]+)*$";

    String NICKNAME = "\\w+";
    String COMMENT = "[\\w\\W]{1,150}";
    String PHONE = "[+][0-9]{2}[(][0-9]{3}[)][0-9]{3}[-][0-9]{2}[-][0-9]{2}"; //+38(050)555-55-55
    String PHONE_NO_DELIMITERS = "[+][0-9]{12}"; // +380505555555
    String EMAIL = "^[a-zA-Z0-9]+['a-zA-Z0-9._-]*@[a-zA-Z0-9]+(['a-zA-Z0-9._-])*$";
    String SKYPE = "^[a-zA-Z][a-zA-Z0-9_.,-]{5,31}$";
    String ZIPCODE_US = "^\\d{5}([ -]\\d{4})?$";
    String ZIPCODE_UA = "\\d{5}";
    String STREET_LAT = "^[a-zA-Z0-9]+([' -]?[a-zA-Z0-9]+)*$";
    String STREET_UKR = "^[А-ЩЬЮЯҐІЇЄа-щьюяґіїє0-9]+([' -]?[А-ЩЬЮЯҐІЇЄа-щьюяґіїє0-9]+)*$";
    String BUILDING_NUMBER_LAT = "^[1-9][0-9]*([a-zA-Z]?|([/]?[1-9][0-9]*))$";
    String BUILDING_NUMBER_UKR = "^[1-9][0-9]*([А-ЩЬЮЯҐІЇЄа-щьюяґіїє]?|([/]?[1-9][0-9]*))$";
    String APARTMENT_NUMBER_LAT = "^[1-9][0-9]*([a-zA-Z]?|([./]?[1-9][0-9]*))$";
    String APARTMENT_NUMBER_UKR = "^[1-9][0-9]*([./]?[1-9][0-9]*)?$";
}
