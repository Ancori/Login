package dad.login.mvc;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LoginModel {

	private StringProperty usuario = new SimpleStringProperty();
	private StringProperty contraseña = new SimpleStringProperty();

	public StringProperty usuarioProperty() {
		return this.usuario;
	}

	public String getUsuario() {
		return this.usuarioProperty().get();
	}

	public void setUsuario(final String usuario) {
		this.usuarioProperty().set(usuario);
	}

	public StringProperty contraseñaProperty() {
		return this.contraseña;
	}

	public String getContraseña() {
		return this.contraseñaProperty().get();
	}

	public void setContraseña(final String contraseña) {
		this.contraseñaProperty().set(contraseña);
	}

}
