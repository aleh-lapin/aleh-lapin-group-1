package jmp.module08.ci.jmpmodule08;

import java.util.List;
import jmp.module08.ci.jmpmodule08.CustomBuilder.DescriptorImpl;
import org.kohsuke.stapler.export.Exported;
import org.kohsuke.stapler.export.ExportedBean;
import hudson.model.Action;


@ExportedBean(defaultVisibility = 999)
@SuppressWarnings("rawtypes")
public class CustomAction implements Action {
	
	private CheckPointModule module;
	public CustomAction(CheckPointModule module) {
		this.module = module;
	}

	public CheckPointModule getModule() {
		return module;
	}

	public void setModule(CheckPointModule module) {
		this.module = module;
	}

	public String getDisplayName() {
		return "My custom plugin."; //$NON-NLS-1$
	}
	public String getIconFileName() {

		return DescriptorImpl.ACTION_LOGO_LARGE;
	}
	public String getUrlName() {
		return "jmpmodule08"; //$NON-NLS-1$
	}
		
	@Exported
	public List<CheckPointMetric> getMetrics() {
		return getModule().getMetrics();
	}
	
}
