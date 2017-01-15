package lab04;

import java.util.*;
import org.jbehave.core.*;
import org.jbehave.core.configuration.*;
import org.jbehave.core.embedder.*;
import org.jbehave.core.io.*;
import org.jbehave.core.junit.*;
import org.jbehave.core.reporters.*;
import org.jbehave.core.steps.*;
import org.jbehave.web.selenium.*;
import com.google.common.util.concurrent.*;

import org.openqa.selenium.chrome.*;
import static java.util.Arrays.*;
import static org.jbehave.core.io.CodeLocations.*;

public class SeleniumConfig extends JUnitStories {
	
	private WebDriverProvider driverProvider = new TypeWebDriverProvider(ChromeDriver.class);
    private static final String DRIVERKEY = "webdriver.chrome.driver";
    private static final String DRIVERVALUE = "D://Downloads//chromedriver.exe";

    private WebDriverSteps lifecycleSteps = new PerStoriesWebDriverSteps(driverProvider);
    private SeleniumPages pages = new SeleniumPages(driverProvider);
    private SeleniumContext context = new SeleniumContext();
    private ContextView contextView = new LocalFrameContextView().sized(500, 100);

    public SeleniumConfig() {
        System.setProperty(DRIVERKEY, DRIVERVALUE);
        if (lifecycleSteps instanceof PerStoriesWebDriverSteps)
            configuredEmbedder().useExecutorService(MoreExecutors.sameThreadExecutor());
    }

    @Override
    public Configuration configuration() {
        Class<? extends Embeddable> embeddableClass = this.getClass();
        return new SeleniumConfiguration()
                .useSeleniumContext(context)
                .useWebDriverProvider(driverProvider)
                .useStepMonitor(new SeleniumStepMonitor(contextView, context, new SilentStepMonitor()))
                .useStoryLoader(new LoadFromClasspath(embeddableClass))
                .useStoryReporterBuilder(new StoryReporterBuilder()
                        .withCodeLocation(codeLocationFromClass(embeddableClass))
                        .withDefaultFormats()
                        .withFormats(Format.CONSOLE, Format.TXT));
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        Configuration configuration = configuration();
        return new InstanceStepsFactory(configuration,
                new SeleniumSteps(pages),
                lifecycleSteps,
                new WebDriverScreenshotOnFailure(driverProvider, configuration.storyReporterBuilder()));
    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder()
                .findPaths(codeLocationFromClass(this.getClass()).getFile(), asList("**/*web.story"), null);
    }

    public static class SameThreadEmbedder extends Embedder {
        public SameThreadEmbedder() {
            useExecutorService(MoreExecutors.sameThreadExecutor());
        }
    }
}
