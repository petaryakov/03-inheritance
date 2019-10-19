package ohm.softa.a03;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Cat {

	private static final Logger logger = LogManager.getLogger();

	// state durations (set via constructor), ie. the number of ticks in each state
	private final int sleep;
	private final int awake;
	private final int digest;
	private State state;
	private final String name;

	public Cat(String name, int sleep, int awake, int digest) {
		this.name = name;
		this.sleep = sleep;
		this.awake = awake;
		this.digest = digest;

		state = new SleepingState(sleep);
	}

	public void tick(){

		this.state = state.tick(this);
		/*time = time + 1;

		switch (state) {
			case SLEEPING:
				if (time == sleep) {
					logger.info("Yoan... getting hungry!");
					state = HUNGRY;
					time = 0;
				}
				break;
			case HUNGRY:
				if(time == awake){
					logger.info("I've starved for a too long time...good bye...");
					state = DEAD;
				}
				break;
			case DIGESTING:
				timeDigesting = timeDigesting + 1;
				if (timeDigesting == digest) {
					logger.info("Getting in a playful mood!");
					state = PLAYFUL;
				}
				break;
			case PLAYFUL:
				if (time >= awake) {
					logger.info("Yoan... getting tired!");
					state = SLEEPING;
					time = 0;
				}
				break;

			case DEAD:
				break;
			default:
				throw new IllegalStateException("Unknown cat state " + state.name());
		}*/
	}

	/**
	 * This would be a user interaction: feed the cat to change its state!
	 */
	public void feed(){
		if (!isHungry())
			throw new IllegalStateException("Not every cat is Garfield...");

		logger.info("You feed the cat...");
		this.state = ((HungryState) state).feed(this);
	}

	public boolean isAsleep() {
		return state instanceof SleepingState;
	}

	public boolean isPlayful() {
		return state instanceof PlayfulState;
	}

	public boolean isHungry() {
		return state instanceof HungryState;
	}

	public boolean isDigesting() {
		return state instanceof DigestingState;
	}

	public boolean isDead() {
		return state instanceof DeathState;
	}

	public int getSleep(){return sleep;}

	public int getAwake(){ return awake;}

	public int getDigest(){ return digest;}

	@Override
	public String toString() {
		return name;
	}

}
