package Transformation;

import cucumber.api.Transformer;

public class SalaryCountTransform extends Transformer<Integer>{

	@Override
	public Integer transform(String salary) {
		// Convert String salary to integer
		return salary.length();
	}

}
