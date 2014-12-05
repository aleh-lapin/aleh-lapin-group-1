package jmp.module08.ci.jmpmodule08;

import hudson.model.Cause;
import hudson.model.Result;
import hudson.model.Run.Summary;

import java.util.List;

import org.kohsuke.stapler.export.Exported;

public class CheckPointMetric {
	
	private String buildName;
	
	private long buildDuration;
	
	private String displayName;
	
	private List<Cause> causes;
	
	private Summary summary;
	
	private Result result;
	
	public CheckPointMetric() {
		
	}

	@Exported
	public long getBuildDuration() {
		return buildDuration;
	}

	public void setBuildDuration(long buildDuration) {
		this.buildDuration = buildDuration;
	}

	@Exported
	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public List<Cause> getCauses() {
		return causes;
	}

	public void setCauses(List<Cause> causes) {
		this.causes = causes;
	}

	public Summary getSummary() {
		return summary;
	}

	public void setSummary(Summary summary) {
		this.summary = summary;
	}

	@Exported
	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	@Exported
	public String getBuildName() {
		return buildName;
	}

	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}
		
}
