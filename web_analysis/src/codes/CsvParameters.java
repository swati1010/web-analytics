package codes;

public class CsvParameters {
	public static String ratings = "";
	public static String review = "";
	public static String classes = "";

	public CsvParameters(String r, String c, String rt) {
		// TODO Auto-generated constructor stub
		review = r;
		classes = c;
		ratings = rt;
	}

	public static String getRatings() {
		return ratings;
	}

	public static void setRatings(String ratings) {
		CsvParameters.ratings = ratings;
	}

	public static String getReview() {
		return review;
	}

	public static String getClasses() {
		return classes;
	}

	public static void setReview(String review) {
		CsvParameters.review = review;
	}

	public static void setClasses(String classes) {
		CsvParameters.classes = classes;
	}

	
	
}
