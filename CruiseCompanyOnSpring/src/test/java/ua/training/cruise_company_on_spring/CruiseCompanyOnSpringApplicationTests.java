package ua.training.cruise_company_on_spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ua.training.cruise_company_on_spring.entity.User;
import ua.training.cruise_company_on_spring.entity.UserRole;
import ua.training.cruise_company_on_spring.service.UserService;

@SpringBootTest
class CruiseCompanyOnSpringApplicationTests {
	@Autowired
	private UserService userService;

	@Test
	void testCreateUser() {
		userService.updateUserRole("boss@c.ua", UserRole.ROLE_TRAVEL_AGENT);

/*
		userService.saveUser(User.builder()
				.email("boss@c.ua")
				.password("boss")
				.firstNameEn("Maria")
				.lastNameEn("Terehova")
				.firstNameNative("Марія")
				.lastNameNative("Терехова")
				.build());*/
/*
		userService.saveUser(User.builder()
				.email("@b.ua")
				.password("user")
				.firstNameEn("Kosya")
				.lastNameEn("Vyhan")
				.firstNameNative("Кося")
				.lastNameNative("Вухань")
				.nationality("ukrainian")
				.passportNumber("ME456715")
				.build());*/
	}

}
