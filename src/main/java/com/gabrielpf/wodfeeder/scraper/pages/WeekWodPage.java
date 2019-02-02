package com.gabrielpf.wodfeeder.scraper.pages;

import com.gabrielpf.wodfeeder.scraper.pages.utils.DailyWorkoutReader;
import org.jsoup.nodes.Document;

import java.net.UnknownHostException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

public class WeekWodPage extends BasePage {

    private DailyWorkoutReader workouts;

    public WeekWodPage(String url) throws UnknownHostException {
        super(url);
    }

    public WeekWodPage(Document document) {
        super(document);
        workouts = new DailyWorkoutReader(document.select("p"));
    }

    public LocalDate readPublishingDate() {

        String publishedTimeString = document.select(".entry-time").attr("datetime");

        LocalDateTime publishedTime = LocalDateTime.parse(publishedTimeString, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        return publishedTime.toLocalDate();
    }

    public Map<LocalDate, String> readDailyWorkouts() {
        LocalDate publishingDate = readPublishingDate();
        final int dayOfWeek = publishingDate.getDayOfWeek().getValue() == 7 ? 0 : publishingDate.getDayOfWeek().getValue();

        return Arrays.stream(DayOfWeek.values())
                .filter(day -> day != DayOfWeek.SUNDAY)
                .collect(toMap(day -> publishingDate.plusDays(day.getValue() - dayOfWeek), workouts::getWorkoutForDay));
    }


}
//	public void readDaylyWorkouts(Map<DayOfWeek, Integer> workoutsStartLine) {
//		new DailyWorkoutReader(paragraphs).getWorkouts();
//	}
//
//	public String br2nl(String html) {
//		if(html==null)
//			return html;
//
//		Document document = Jsoup.parse(html);
//		document.outputSettings(new Document.OutputSettings().prettyPrint(false));//makes html() preserve linebreaks and spacing
//		document.select("br").append("\\n");
////		document.select("p").prepend("\\n\\n");
//		String s = document.html().replaceAll("\\\\n", "\n");
//
//
//		return Jsoup.clean(s, "", Whitelist.none(), new Document.OutputSettings().prettyPrint(false));
//	}
//
//}
//
//
//
//
////		Cycle 01: Week 1 of 4.
////		Standard warm up for the week:
////		3 min. Jump Rope w/ footwork
////		Stretch (solo): At post – Twist out + down – 20 sec./side At post – Twist in – 20 sec./side At post – Hips back – 20 sec./side Stdg. Quad stretch – 20 sec./side Seated, H2K – 20 sec./side
////		2 rounds: 10 Jumping Pullups 10 Cobra Push ups 10 Jumping Lunges 10 V-sits 10 1/2 bridges
////		Monday
////		Body weight:
////		N/A
////		Strength:
////		Bench Press: (12, 9) + 5 X 7 reps Wide grip strict pull ups: (4, 6) + 5 X 8 reps Rest
////		1 min./station, increase load/set
////		Workout:
////		2 rounds:
////		30 Burpees 50 Flutter kicks (4 count for 1 rep) 50 push ups
////		Tuesday
////		Body weight:
////		N/A
////		Strength:
////		Back squat: (12, 9) + 5 X 7 reps HSPU: (3, 5) + 5 X 6 reps Rest
////		1 min./station, increase load/set
////		Workout:
////		20 min. AMRAP:
////		10 Riing rows 20 Alt. Jump Lunges 5 close hand push ups (index and tips of thumbs touch)
////		Wednesday
////		Body Weight Progression:
////		Rope climb tech: 1. Spanish wrap 2. Heel hook 3. Step through
////		Strength:
////		N/A
////		Workout:
////		4 rounds:
////		7 Snatches (135, 95) 7 push ups 7 Rope climbs 7 Ring dips
////		Thursday
////		Body weight:
////		N/A
////		Big Lift progression:
////		Shoulder Press: (12, 9) + 5 X 7 reps Alt. Pistols: (3, 5) + 5 X 6 reps/leg Rest
////		1 min./station, increase load/set
////		Workout:
////		5 rounds:
////		10 bar hop burpees 10 Hang Cleans (135, 95) 10 Roll out push ups 10 Wall balls (20, 14)
////		Friday
////		Body weight:
////		N/A
////		Big Lift progression:
////		DL: (12, 9) + 5 X 7 reps Ring Dips: (3, 5) + 5 X 6 reps Rest
////		1 min./station, increase load/set
////		Workout:
////		20 min. AMRAP:
////		20 KB Lunges (53, 35) 15 KBS (53, 35) 10 KB sit ups (53, 35)
////		Saturday
////		Workout:
////		3 rounds:
////		50′ HS walk 40 squats 30 GHD sit ups 20 T2B 10 Jack Knife push-ups
////		Sunday
////		Rest.
//
////	}
////
////}
////
