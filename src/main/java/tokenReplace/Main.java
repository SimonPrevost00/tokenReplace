package tokenReplace;

public class Main {

	public static void main(String[] args) {
		String text = "Bonjour {name} souhaitez-vous {arme} ?";
		Transformer transformer = new Transformer();
		transformer.addToken("{name}", "Billy");
		transformer.addToken("{arme}", "une massue");
		transformer.addToken("{arme}", "un gourdin");
		transformer.addToken("{pays}", "France");
		System.out.println(transformer.transform(text));
	}

}
