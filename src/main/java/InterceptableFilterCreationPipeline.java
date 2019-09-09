import javax.sound.midi.SysexMessage;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class InterceptableFilterCreationPipeline implements IFilterCreationPipeline {

    public FutureTask interceptBeforeNextStep() {
        Runnable runnable = new Runnable() {
            public void run() {
                System.out.println("");
            }
        };
        return new FutureTask((Callable) runnable);
    }

    private boolean intercept;

    public void processPipeline() {
        while(!intercept) {
            //iterate through steps
        }
    }
}
