package appliances;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class HomeControlSystem {

	private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
	private final CopyOnWriteArrayList<Appliance> appliances = new CopyOnWriteArrayList<Appliance>();
	
	
	//Maintain the list of appliances 
	public void addAppliances(Appliance appliance) {

		appliances.add(appliance);
	}

	//schedule is initialized upon the object creation
	public HomeControlSystem() {

		scheduleAnnulaUpdate();
	}
	
	//Find each appliances and turn off them
	public void turnOffAll() {

		for (Appliance appliance : appliances) {
			appliance.turnOff();
		}

		System.out.println("All appliances are tunedoff");
	}

	private void scheduleAnnulaUpdate() {

		ZonedDateTime now = ZonedDateTime.now(ZoneId.systemDefault());
		ZonedDateTime nextUpdate = ZonedDateTime.of(LocalDate.of(now.getYear(), Month.JANUARY, 1), LocalTime.of(1, 0),
				ZoneId.systemDefault());

		if (now.isAfter(nextUpdate)) {
			nextUpdate = nextUpdate.plusYears(1);
		}

		long delay = Duration.between(now, nextUpdate).toMillis();

		scheduler.schedule(() -> {
			turnOffAll();
			scheduleAnnulaUpdate();

		}, delay, TimeUnit.MILLISECONDS);

	}
	
	//To Eliminate the task from scheduler
	public void shutDown() {
		scheduler.shutdown();
	}
}
