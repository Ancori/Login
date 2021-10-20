package dad.login.mvc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.apache.commons.codec.digest.DigestUtils;
import dad.login.auth.AuthService;
import dad.login.auth.FileAuthService;
import dad.login.auth.LdapAuthService;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class LoginController {

	private LoginView view = new LoginView();
	private LoginModel model = new LoginModel();
	private BufferedReader br = null;

	public LoginController() {
		view.getUsuario().textProperty().bindBidirectional(model.usuarioProperty());
		view.getContraseña().textProperty().bindBidirectional(model.contraseñaProperty());
		view.getAcceder().setOnAction(e -> onAcceder(e));
		view.getCancelar().setOnAction(e -> onCancelar(e));
	}

	private void onAcceder(ActionEvent e) {
		if (view.getLdap().isSelected()) {
			boolean useLdap = true;
			AuthService ldap = useLdap ? new LdapAuthService() : new FileAuthService();
			try {
				if (ldap.login(model.getUsuario(), model.getContraseña()) == true) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Login");
					alert.setHeaderText("Acceso permitido");
					alert.setContentText("Las credenciales de acceso son validas");
					alert.showAndWait();
					System.exit(0);

				} else {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Login");
					alert.setHeaderText("Acceso denegado");
					alert.setContentText("El usuario y/o contraseña no son validos");
					alert.showAndWait();
					model.setContraseña("");
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else {
			try {
				br = new BufferedReader(new FileReader("src\\main\\resources\\users.csv"));
				String line = br.readLine();
				int usuarioscont = 0;
				int paswordcont = 0;
				String[] valores;
				while (null != line) {
					valores = line.split(",");
					line = br.readLine();
					for (int i = 0; i < valores.length; i++) {
						if (i % 2 == 0) {
							if (model.getUsuario().equals(valores[i])) {
								usuarioscont++;
							}
						} else {
							String password = model.getContraseña();
							String md5 = DigestUtils.md5Hex(password).toUpperCase();
							if (md5.equals(valores[i])) {
								paswordcont++;
							}
						}

					}
				}
				if (usuarioscont > 0 && paswordcont > 0) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Login");
					alert.setHeaderText("Acceso permitido");
					alert.setContentText("Las credenciales de acceso son validas");
					alert.showAndWait();
					System.exit(0);
				} else {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Login");
					alert.setHeaderText("Acceso denegado");
					alert.setContentText("El usuario y/o contraseña no son validos");
					alert.showAndWait();
					model.setContraseña("");
				}

			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	private void onCancelar(ActionEvent e) {
		System.exit(0);
	}

	public LoginView getView() {
		return view;
	}

	public LoginModel getModel() {
		return model;
	}

}
