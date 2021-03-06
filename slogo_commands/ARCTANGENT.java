package slogo_commands;

/**
 * @author Larissa
 * purpose: implements ARTTANGENT command
 * dependencies: abstract class MathBoolCommand and interface Command
 */

import java.util.List;

import slogo_logic.MathBoolCommand;

public class ARCTANGENT extends MathBoolCommand{

	@Override
	protected String execute(List<String> params) {
		return String.valueOf(Math.atan(Double.parseDouble((params.get(0)))));
	}

}
