package Transformation;

import cucumber.api.Transformer;

public class EmailTransform extends Transformer<String> {

	@Override
	public String transform(String userName) {
		// Concatenate Username with @jncb.com
		return userName.concat("@jncb.com");
	}
	
	
}
