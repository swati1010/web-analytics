package codes;

public class UserCredentials {
	
	public static String Username = "";
	public static String EmailId = "";
	public static String Password = "";
	public static int userid = 0;

	

	public static int getUserid() {
		return userid;
	}

	public static void setUserid(int userid) {
		UserCredentials.userid = userid;
	}

	public static String getUsername() {
		return Username;
	}

	public static void setUsername(String username) {
		Username = username;
	}

	public static String getEmailId() {
		return EmailId;
	}

	public static void setEmailId(String emailId) {
		EmailId = emailId;
	}

	public static String getPassword() {
		return Password;
	}

	public static void setPassword(String password) {
		Password = password;
	}
	
}
