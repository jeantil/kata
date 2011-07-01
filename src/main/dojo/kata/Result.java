package dojo.kata;

import java.util.List;

public class Result {

	public void setDictionnary(List<Byte> asList) {
		dictionnary = asList;
	}

	public void setOutput(List<Byte> asList) {
		output = asList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
		+ ((dictionnary == null) ? 0 : dictionnary.hashCode());
		result = prime * result + ((output == null) ? 0 : output.hashCode());
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
		Result other = (Result) obj;
		if (dictionnary == null) {
			if (other.dictionnary != null)
				return false;
		} else if (!dictionnary.equals(other.dictionnary))
			return false;
		if (output == null) {
			if (other.output != null)
				return false;
		} else if (!output.equals(other.output))
			return false;
		return true;
	}

	private List<Byte> dictionnary;

	private List<Byte> output;

	@Override
	public String toString() {
		return "Result [dictionnary=" + dictionnary + ", output=" + output
				+ "]";
	}

}
