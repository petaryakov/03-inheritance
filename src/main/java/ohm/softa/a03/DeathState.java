package ohm.softa.a03;

public class DeathState extends State {

    public DeathState(){
        super(-1);
    }
    @Override
    public State successor(Cat cat) {
        return this;
    }
}
