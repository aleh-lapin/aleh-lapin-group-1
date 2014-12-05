package jmp.module08.ci.jmpmodule08;

import hudson.model.AbstractBuild;

public interface CheckPoint {
	
	CheckPointMetric check(AbstractBuild<?, ?> currentBuild);

}
