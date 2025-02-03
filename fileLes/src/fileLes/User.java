package fileLes;

import java.io.Serializable;
import java.util.UUID;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	private UUID id;
	private String name;
	private String email;
	private int age;
	private String password;

	public User(String name, String email, int age, String password) {
		this.id = UUID.randomUUID();
		this.name = name;
		this.email = email;
		this.age = age;
		this.password = password;
	}

	public UUID getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User{ " + "\n\tid=" + id + "\n\tname='" + name + '\'' + "\n\temail='" + email + '\'' + "\n\tage=" + age
				+ "\n\tpassword='" + password + '\'' + "\n\t}";
	}
}
