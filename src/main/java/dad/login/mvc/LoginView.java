package dad.login.mvc;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class LoginView extends VBox {

	private TextField usuario;
	private PasswordField contraseña;
	private CheckBox ldap;
	private Button acceder, cancelar;

	public LoginView() {
		super();
		usuario = new TextField();
		contraseña = new PasswordField();
		ldap = new CheckBox("Usar LDAP");

		HBox usuariobox = new HBox(5, new Label("Usuario:"), usuario);
		HBox contraseñabox = new HBox(5, new Label("Contraseña:"), contraseña);

		acceder = new Button("Acceder");
		acceder.setDefaultButton(true);
		cancelar = new Button("Cancelar");

		HBox botonesBox = new HBox(5, acceder, cancelar);

		setSpacing(5);
		setFillWidth(false);
		setAlignment(Pos.CENTER);
		getChildren().addAll(usuariobox, contraseñabox, ldap, botonesBox);
	}

	public TextField getUsuario() {
		return usuario;
	}

	public PasswordField getContraseña() {
		return contraseña;
	}

	public Button getAcceder() {
		return acceder;
	}

	public Button getCancelar() {
		return cancelar;
	}

	public CheckBox getLdap() {
		return ldap;
	}

}
