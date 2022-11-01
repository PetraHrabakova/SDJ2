package LoginApplication;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.LoginModelBase;
import modelimpls.LoginModelInMemory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import viewmodels.CreateUserVM;
import viewmodels.LoginVM;

import static org.junit.jupiter.api.Assertions.*;

class CreateUserVMTest {
  private CreateUserVM createUserVM;
  private LoginVM loginVM;

  @BeforeEach
  public void setup() {
    LoginModelBase model = new LoginModelInMemory();
    model.populateModelWithDummyusers();
    loginVM = new LoginVM(model);
    createUserVM = new CreateUserVM(model);
  }

  @Test
  public void testValidLogin() {
    // arrange
    StringProperty result = new SimpleStringProperty();
    StringProperty username = new SimpleStringProperty();
    StringProperty password = new SimpleStringProperty();

    result.bind(loginVM.loginResultProperty());
    username.bindBidirectional(loginVM.userNameProperty());
    password.bindBidirectional(loginVM.passwordProperty());

    // Act
    username.set("Kasper");
    password.set("Kasper1");
    loginVM.validateLogin();

    // Assert
    assertEquals("OK", loginVM.loginResultProperty().get());
    assertEquals("", loginVM.userNameProperty().get());
    assertEquals("", loginVM.passwordProperty().get());

  }

  @Test
  public void createValidUser_OtherTroels_12345678Az_Successful() {
    // arrange
    StringProperty username = new SimpleStringProperty();
    StringProperty password = new SimpleStringProperty();
    StringProperty passwordAgain = new SimpleStringProperty();
    StringProperty result = new SimpleStringProperty();
    createUserVM.usernameProperty().bindBidirectional(username);
    createUserVM.passwordProperty().bindBidirectional(password);
    createUserVM.passwordAgainProperty().bindBidirectional(passwordAgain);
    createUserVM.createUserResultProperty().bindBidirectional(result);

    // act
    username.setValue("Hello");
    password.setValue("12345678Az");
    passwordAgain.setValue("12345678Az");
    createUserVM.attemptCreateUser();

    // assert
    assertEquals("OK", result.getValue());
  }
}