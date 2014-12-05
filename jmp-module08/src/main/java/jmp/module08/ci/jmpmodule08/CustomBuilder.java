package jmp.module08.ci.jmpmodule08;
import hudson.Launcher;
import hudson.Extension;
import hudson.util.FormValidation;
import hudson.model.AbstractBuild;
import hudson.model.Action;
import hudson.model.BuildListener;
import hudson.model.AbstractProject;
import hudson.tasks.Builder;
import hudson.tasks.BuildStepDescriptor;
import net.sf.json.JSONObject;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.StaplerRequest;
import org.kohsuke.stapler.QueryParameter;
import javax.servlet.ServletException;
import java.io.IOException;

public class CustomBuilder extends Builder {

    private final String name;

    @DataBoundConstructor
    public CustomBuilder(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean perform(AbstractBuild build, Launcher launcher, BuildListener listener) {
    	
    	CheckPointModule module = new CheckPointModule();
    	module.evaluate(build, getDescriptor().getCheckPointObject());
    	
    	Action customAction = new CustomAction(module);
    	build.getActions().add(customAction);
    	
    	for(CheckPointMetric metric : module.getMetrics()) {
    		listener.getLogger().println("metric : "+metric);
    	}
    	
        listener.getLogger().println("Hello, "+name+"!");
        return true;
    }

    @Override
    public DescriptorImpl getDescriptor() {
        return (DescriptorImpl)super.getDescriptor();
    }

    @Extension
    public static final class DescriptorImpl extends BuildStepDescriptor<Builder> {
     
    	public static final String ACTION_LOGO_LARGE = "/plugin/jmp-module08/icons/icon-32x32.png"; //$NON-NLS-1$
    	
        private boolean useFrench;
        
        public CheckPointObject getCheckPointObject() {
        	return new CheckPointObject();
        }

        public DescriptorImpl() {
            load();
        }

        public FormValidation doCheckName(@QueryParameter String value)
                throws IOException, ServletException {
            if (value.length() == 0)
                return FormValidation.error("Please set a name");
            if (value.length() < 4)
                return FormValidation.warning("Isn't the name too short?");
            return FormValidation.ok();
        }

        public boolean isApplicable(Class<? extends AbstractProject> aClass) {
            return true;
        }

        public String getDisplayName() {
            return "My Custom Plugin";
        }

        @Override
        public boolean configure(StaplerRequest req, JSONObject formData) throws FormException {
            useFrench = formData.getBoolean("useFrench");
            //req.bindJSON(this, formData);
            save();
            return super.configure(req,formData);
        }

        public boolean getUseFrench() {
            return useFrench;
        }
    }
}

