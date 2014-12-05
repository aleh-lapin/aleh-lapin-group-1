package jmp.module08.ci.jmpmodule08;

import hudson.model.Result;
import hudson.model.AbstractBuild;

public class CheckPointObject implements CheckPoint {

	public CheckPointMetric check(AbstractBuild<?, ?> currentBuild) {
		CheckPointMetric metric = new CheckPointMetric();
		if (currentBuild != null && currentBuild.getResult() != null && currentBuild.getResult().isBetterOrEqualTo(Result.SUCCESS)) {
			metric.setBuildName("Current build is still failed.");
			metric.setBuildDuration(currentBuild.getDuration());
			metric.setCauses(currentBuild.getCauses());
			metric.setDisplayName(currentBuild.getDisplayName());
			metric.setResult(currentBuild.getResult());
			metric.setSummary(currentBuild.getBuildStatusSummary());
    	}
    	
        return metric;
	}
	
}
