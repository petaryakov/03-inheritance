package ohm.softa.a03;

public class PlayfulState extends State {

    public PlayfulState(int duration) {
        super(duration);
    }

    @Override
    public State successor(Cat cat) {
        logger.info("Yoan... getting tired!");
        return new SleepingState(cat.getSleep());
    }
}
