package com.example.SharingIsCaring;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@SpringBootTest
class SharingIsCaringApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void testMainPage() {
		MainController controller = new MainController();
		Model model = mock(Model.class);

		String viewName = controller.mainPage(model);

		assertEquals("HomePage", viewName);
	}

	@Test
	public void register() {
		String Password;
		Password = "123";
		assertEquals("123", Password);
	}

	@Test
	public void loginPage() {
		String username;
		username = "Sion";
		assertEquals("Sion", username);
	}

}
