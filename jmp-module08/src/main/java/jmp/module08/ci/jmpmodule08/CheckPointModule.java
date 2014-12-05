package jmp.module08.ci.jmpmodule08;

import hudson.model.AbstractBuild;
import hudson.model.FreeStyleBuild;
import java.util.ArrayList;
import java.util.List;

public class CheckPointModule {

    private List<CheckPointMetric> metrics = new ArrayList<CheckPointMetric>();

    public List<CheckPointMetric> evaluate(AbstractBuild build, CheckPoint checkPoint) {
        if (build instanceof FreeStyleBuild) {
        	FreeStyleBuild mavenModuleSetBuild = (FreeStyleBuild)build;
            while (mavenModuleSetBuild != null) {
            	metrics.add(checkPoint.check(mavenModuleSetBuild));
            	mavenModuleSetBuild = (FreeStyleBuild)(FreeStyleBuild)BuildUtil.getPreviousBuiltBuild(mavenModuleSetBuild);
            }
        }   
        return metrics;
        
    }
    
    public List<CheckPointMetric> getMetrics() {
        return metrics;
    }

}
