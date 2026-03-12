package dates;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Set;

public class Dates {
    public static void main(String[] args) {
        System.out.println("=== ДЕМОНСТРАЦИЯ LocalDateTime и ZonedDateTime ===\n");

        // 1. Создание объектов
        System.out.println("1. СОЗДАНИЕ ОБЪЕКТОВ:");
        System.out.println("=".repeat(50));

        // LocalDateTime - без информации о временной зоне
        LocalDateTime localNow = LocalDateTime.now();
        System.out.println("LocalDateTime.now(): " + localNow);

        // Создание конкретной даты и времени
        LocalDateTime specificLocal = LocalDateTime.of(2024, 6, 15, 14, 30, 45);
        System.out.println("LocalDateTime.of(2024,6,15,14,30,45): " + specificLocal);

        // ZonedDateTime - с информацией о временной зоне
        ZonedDateTime zonedNow = ZonedDateTime.now();
        System.out.println("ZonedDateTime.now(): " + zonedNow);

        // Создание с конкретной временной зоной
        ZoneId newYorkZone = ZoneId.of("America/New_York");
        ZonedDateTime newYorkTime = ZonedDateTime.now(newYorkZone);
        System.out.println("ZonedDateTime в Нью-Йорке: " + newYorkTime);

        ZoneId tokyoZone = ZoneId.of("Asia/Tokyo");
        ZonedDateTime tokyoTime = ZonedDateTime.now(tokyoZone);
        System.out.println("ZonedDateTime в Токио: " + tokyoTime);

        System.out.println();

        // 2. Разница между временными зонами
        System.out.println("2. РАЗНИЦА МЕЖДУ ВРЕМЕННЫМИ ЗОНАМИ:");
        System.out.println("=".repeat(50));

        System.out.println("Текущее время в системе: " + zonedNow);
        System.out.println("Время в Нью-Йорке: " + newYorkTime);
        System.out.println("Время в Токио: " + tokyoTime);

        // Разница во времени между зонами
        long hoursDiff = ChronoUnit.HOURS.between(newYorkTime, tokyoTime);
        System.out.println("Разница между Нью-Йорком и Токио: " + hoursDiff + " часов");

        System.out.println();

        // 3. Конвертация между типами
        System.out.println("3. КОНВЕРТАЦИЯ МЕЖДУ ТИПАМИ:");
        System.out.println("=".repeat(50));

        // LocalDateTime -> ZonedDateTime
        ZonedDateTime localToZoned = specificLocal.atZone(ZoneId.systemDefault());
        System.out.println("LocalDateTime -> ZonedDateTime: " + specificLocal + " -> " + localToZoned);

        // ZonedDateTime -> LocalDateTime
        LocalDateTime zonedToLocal = zonedNow.toLocalDateTime();
        System.out.println("ZonedDateTime -> LocalDateTime: " + zonedNow + " -> " + zonedToLocal);

        // Смена временной зоны
        ZonedDateTime tokyoFromSystem = zonedNow.withZoneSameInstant(tokyoZone);
        System.out.println("Конвертация системного времени в Токио: " + tokyoFromSystem);

        System.out.println();

        // 4. Форматирование
        System.out.println("4. ФОРМАТИРОВАНИЕ:");
        System.out.println("=".repeat(50));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss z");
        System.out.println("Форматированное время: " + zonedNow.format(formatter));

        DateTimeFormatter localFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        System.out.println("Форматированный LocalDateTime: " + localNow.format(localFormatter));

        System.out.println();

        // 5. Арифметические операции
        System.out.println("5. АРИФМЕТИЧЕСКИЕ ОПЕРАЦИИ:");
        System.out.println("=".repeat(50));

        LocalDateTime tomorrow = localNow.plusDays(1);
        System.out.println("Завтра в это же время: " + tomorrow);

        ZonedDateTime nextWeek = zonedNow.plusWeeks(1);
        System.out.println("Через неделю: " + nextWeek.format(formatter));

        // Разница между датами
        Duration duration = Duration.between(localNow, tomorrow);
        System.out.println("До завтра осталось: " + duration.toHours() + " часов");

        System.out.println();

        // 6. Доступные временные зоны
        System.out.println("6. НЕКОТОРЫЕ ДОСТУПНЫЕ ВРЕМЕННЫЕ ЗОНЫ:");
        System.out.println("=".repeat(50));

        Set<String> availableZones = ZoneId.getAvailableZoneIds();
        availableZones.stream()
                .filter(zone -> zone.contains("Europe") || zone.contains("America") || zone.contains("Asia"))
                .sorted()
                .limit(10)
                .forEach(zone -> System.out.println("• " + zone));

        System.out.println("\n... и ещё " + (availableZones.size() - 10) + " зон");

        System.out.println();

        // 7. Важные особенности
        System.out.println("7. ВАЖНЫЕ ОСОБЕННОСТИ:");
        System.out.println("=".repeat(50));

        System.out.println("LocalDateTime НЕ содержит информацию о временной зоне!");
        System.out.println("ZonedDateTime содержит полную информацию о времени и зоне");
        System.out.println("LocalDateTime подходит для: дней рождений, расписаний без привязки к зоне");
        System.out.println("ZonedDateTime подходит для: времени встреч, логирования событий с учётом зоны");

        // Демонстрация проблемы с LocalDateTime
        System.out.println("\nПример: встреча в 15:00 по LocalDateTime:");
        LocalDateTime meetingTime = LocalDateTime.of(2024, 6, 15, 15, 0);
        System.out.println("Местное время встречи: " + meetingTime);
        System.out.println("Но если участник из другой зоны, он увидит другое время!");

        ZonedDateTime meetingZoned = meetingTime.atZone(ZoneId.of("Europe/London"));
        System.out.println("Та же встреча в Лондоне: " + meetingZoned);
    }
}