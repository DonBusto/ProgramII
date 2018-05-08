import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {
	public static ArrayList<Usuario> usuarios = new ArrayList<>();
	public String nick;

	public static ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public static void setUsuarios(ArrayList<Usuario> usuarios) {
		Usuario.usuarios = usuarios;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String password;
	public boolean admin;

	public Usuario(String nick, String password, boolean admin) {
		this.nick = nick;
		this.password = password;
		this.admin = admin;
	}

	public static void cargarUsuario() {

		File file = new File("usuarios.csv");
		{

			try {
				Scanner inputStream = new Scanner(file);
				while (inputStream.hasNext()) {
					String data = inputStream.next();
					String[] dataSplit = data.split(";");
					boolean adminArray = Boolean.parseBoolean(dataSplit[2]);
					Usuario u = new Usuario(dataSplit[0], dataSplit[1], adminArray);
					usuarios.add(u);
				}
				inputStream.close();

			} catch (Exception e) {

			}
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (admin ? 1231 : 1237);
		result = prime * result + ((nick == null) ? 0 : nick.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (admin != other.admin)
			return false;
		if (nick == null) {
			if (other.nick != null)
				return false;
		} else if (!nick.equals(other.nick))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	public static boolean check(Usuario u) {
		for (int i = 0; i < (Usuario.usuarios.size()); i++) {
			if (u.equals(Usuario.usuarios.get(i))) {
				return true;
			}
		}
		return false;
	}
}
