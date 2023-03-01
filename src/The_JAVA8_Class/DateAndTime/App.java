package The_JAVA8_Class.DateAndTime;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class App {
    public static void main(String[] args) throws InterruptedException{
        // 기계용 시간 (Instant) / 특정 날짜 (LocalDate) / 시간 (LocalTime) / 날짜 기반 (Period)
        Date date = new Date();
        long time = date.getTime();
        System.out.println(time);
        Calendar calendar = new GregorianCalendar(1997, Calendar.JULY, 30);
        SimpleDateFormat dateFormat = new SimpleDateFormat();

        /**
         * @NOTE 기계용 시간 API (메소드 실행 시간 등으로 활용)
         */
        Instant instant = Instant.now();
        System.out.println(instant); // 기준시 UTC, GMT
        System.out.println(instant.atZone(ZoneId.of("UTC")));

        ZoneId zone = ZoneId.systemDefault();
        System.out.println(zone);
        ZonedDateTime zonedDateTime = instant.atZone(zone);
        System.out.println(zonedDateTime);

        /**
         * @NOTE 인간용 시간 API
         */
        // Local 은 서버의 시간을 가져온다
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        LocalDateTime birthday = LocalDateTime.of(1997, Month.JULY, 15, 0, 0, 0);
        ZonedDateTime nowInKorea = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        ZonedDateTime nowInKorea2 = Instant.now().atZone(ZoneId.of("Asia/Seoul"));
        System.out.println("ZonedDateTime : " + nowInKorea + " || " + "Instant Time : " + nowInKorea2);

        /**
         * @NOTE 기간을 표현하는 API
         */
        // 휴면용 시간 비교
        LocalDate today = LocalDate.now();
        LocalDate thisBD = LocalDate.of(2023, Month.JULY, 30);

        Period period = Period.between(today, thisBD);
        System.out.println(period.getMonths() + " " + period.getDays());

        Period until = today.until(thisBD);
        System.out.println(until.get(ChronoUnit.MONTHS) + " " +until.get(ChronoUnit.DAYS));

        // 머신용 시간 비교
        Instant getNow = Instant.now();
        Instant plus = getNow.plus(10, ChronoUnit.SECONDS);
        Duration between = Duration.between(getNow, plus);
        System.out.println(between.getSeconds());

        /**
         * @NOTE 파싱 및 포맷팅
         */
        // 포맷팅
        LocalDateTime goodNow = LocalDateTime.now();
        DateTimeFormatter MMddyyyy = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println(goodNow.format(MMddyyyy));

        // 파싱
        //DateTimeFormatter YYYYMMdd = DateTimeFormatter.ofPattern("YYYY/MM/dd");
        LocalDate parse = LocalDate.parse("1997-07-30",MMddyyyy);
        System.out.println(parse);

        /**
         * @NOTE 레거시 API 지원
         */
        Date date2 = new Date();
        Instant instant2 = date2.toInstant();
        Date newDate = Date.from(instant2);

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        LocalDateTime dateTime = gregorianCalendar.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        ZonedDateTime zonedDateTime2 = gregorianCalendar.toInstant().atZone(ZoneId.systemDefault());
        GregorianCalendar.from(zonedDateTime2);

        ZoneId zoneId = TimeZone.getTimeZone("PST").toZoneId();
        TimeZone timeZone = TimeZone.getTimeZone(zoneId);
    }
}
