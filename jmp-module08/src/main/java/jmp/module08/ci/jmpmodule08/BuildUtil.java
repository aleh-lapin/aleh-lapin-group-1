package jmp.module08.ci.jmpmodule08;

import hudson.model.AbstractBuild;
import hudson.model.Result;

@SuppressWarnings("rawtypes")
public class BuildUtil {
	
	public static AbstractBuild getPreviousBuiltBuild(AbstractBuild build) {

		if (build == null) {
			return null;
		}

		AbstractBuild previousFullBuild = build.getPreviousBuild();
		while( previousFullBuild != null && 
				( previousFullBuild.getResult() == null || previousFullBuild.getResult() == Result.NOT_BUILT )) {
			previousFullBuild = previousFullBuild.getPreviousBuild();
		}
		
		return previousFullBuild;
	}
}
