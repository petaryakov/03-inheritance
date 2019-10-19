package ohm.softa.a03;

public class SleepingState extends State {

    public SleepingState(int duration){
        super(duration);
    }
    @Override
    public State successor(Cat cat) {
        logger.info("Yoan... getting hungry!");
        return new HungryState(cat.getAwake());
    }
}
