package tokenReplace;

import java.util.HashMap;

public class Transformer {
	
	private HashMap<String, String> tokens = new HashMap<String, String>();
	
	/**
	 * Add a new token with it's value
	 * 
	 * A token should be a name between {}
	 *  
	 * @param token the name of the token between {}
	 * @param value to replace the token by
	 */
	public void addToken(String token, String value) {
		if (verifyToken(token)) this.tokens.put(token, value);
	}
	
	/**
	 * Remove a token 
	 * 
	 * A token should be a name between {}
	 * 
	 * @param token
	 */
	public void removeToken(String token) {
		if (verifyToken(token)) this.tokens.remove(token);
	}
	
	/**
	 * Transform a text by replacing a set of tokens by pre-defined values
	 * 
	 * Example
	 * 
	 * I am {name} => I am Robert
	 * 
	 * A token should be a name between {}
	 * 
	 * @param text
	 * @return
	 */
	public String transform(String text) {
		for (String key: tokens.keySet()) {
			text = text.replace(key, tokens.get(key));
		}
		return text;
	}
	
	/**
	 * Verify if the token is not null, not empty and between {}
	 * 
	 * @param token
	 * @return true if the token syntax is compliant, false if not
	 */
	private boolean verifyToken(String token) {
		if (token == null || token.equals("")) {
			return false;
		} else if (token.charAt(0) != '{' || token.charAt(token.length()-1) != '}') {
			return false;
		} else {
			return true;
		}
	}
}