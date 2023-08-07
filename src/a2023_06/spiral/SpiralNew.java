package a2023_06.spiral;

import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Map;

public class SpiralNew {

    private final Map<Point, Point> LEFT_OFFSET = Map.of(
         new Point(-1, 0), new Point(0, -1),
         new Point(0, -1), new Point(1, 0),
         new Point(1, 0), new Point(0, 1),
         new Point(0, 1), new Point(-1, 0)
    );

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
        int steps = Integer.parseInt(reader.readLine());

        Point result = new SpiralNew().getAfterSteps(steps);
        writer.write(result.x + " " + result.y);
        writer.newLine();
        writer.flush();
    }

    Point getAfterSteps(int steps) {
        ArrayList<SimpleEntry<Point, Point>> past = new ArrayList<>();
        past.add(new SimpleEntry<>(new Point(0, 0), new Point(0, 1)));

        for (int i = 0; i < steps; i++) {
            SimpleEntry<Point, Point> currentPosition = past.get(i);
            Point leftTurnOffset = LEFT_OFFSET.get(currentPosition.getValue());
            SimpleEntry<Point, Point> newPosition = leftTurnCoordinate(currentPosition, leftTurnOffset);
            if (past.stream().anyMatch(pos -> pos.getKey().equals(newPosition.getKey()))) {
                past.add(
                    forwardCoordinate(currentPosition)
                );
            } else {
                past.add(newPosition);
            }
        }

        return past.get(past.size() - 1).getKey();
    }

    private SimpleEntry<Point, Point> leftTurnCoordinate(SimpleEntry<Point, Point> currentPosition, Point leftTurnOffset) {
        return new SimpleEntry<>(
            new Point(
                currentPosition.getKey().x + leftTurnOffset.x,
                currentPosition.getKey().y + leftTurnOffset.y
            ),
            new Point(
                leftTurnOffset.x,
                leftTurnOffset.y
            )
        );
    }

    private SimpleEntry<Point, Point> forwardCoordinate(SimpleEntry<Point, Point> currentPosition) {
        return new SimpleEntry<>(
            new Point(
                currentPosition.getKey().x + currentPosition.getValue().x,
                currentPosition.getKey().y + currentPosition.getValue().y
            ),
            new Point(
                currentPosition.getValue().x,
                currentPosition.getValue().y
            )
        );
    }
}
