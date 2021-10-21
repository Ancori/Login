package dad.login.mvc;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class LoginView extends GridPane {

	private TextField usuario;
	private PasswordField contraseña;
	private CheckBox ldap;
	private Button acceder, cancelar;

	public LoginView() {
		super();
		usuario = new TextField();
		contraseña = new PasswordField();
		ldap = new CheckBox("Usar LDAP");

		
		

		acceder = new Button("Acceder");
		acceder.setDefaultButton(true);
		cancelar = new Button("Cancelar");

		HBox botonesBox = new HBox(5, acceder, cancelar);
		botonesBox.setAlignment(Pos.CENTER);

		setPadding(new Insets(5));
		setHgap(5);
		setVgap(5);
		addRow(0,new Label("Usuario:"), usuario);
		addRow(1,new Label("Contraseña:"), contraseña);
		add(ldap, 1, 3);
		add(botonesBox, 0, 4);
		setColumnSpan(botonesBox, 2);
		setAlignment(Pos.CENTER);
		
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
