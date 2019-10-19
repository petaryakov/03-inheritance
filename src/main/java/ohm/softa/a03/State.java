package ohm.softa.a03;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class State {
    protected static final Logger logger = LogManager.getLogger();
    private int time = 0;
    final private int duration;

    int timree;

    protected State(int duration){
        this.duration = duration;
    }

    final State tick(Cat cat){
        if(duration < 0)
            return this;

        // time goes by...
        time++;

        if(time < duration) {
            logger.info("Still in {}", getClass().getSimpleName());
            return this;
        } else {
            return successor(cat);
        }
       /* if(time == duration) {
            return successor(cat);
        }
        else {
            time++;
            return this;
        }*/
    }

    public abstract State successor(Cat cat);

    public int getTime(){
        return time;
    }

    public int getDuration(){
        return duration;
    }
}
