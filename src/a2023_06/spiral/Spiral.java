package a2023_06.spiral;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public class Spiral {

    private final Map<Coordinate, Coordinate> LEFT_OFFSET = Map.of(
         new Coordinate(-1, 0), new Coordinate(0, -1),
         new Coordinate(0, -1), new Coordinate(1, 0),
         new Coordinate(1, 0), new Coordinate(0, 1),
         new Coordinate(0, 1), new Coordinate(-1, 0)
    );

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
        int steps = Integer.parseInt(reader.readLine());

        CoordinateWithOffset result = new Spiral().getAfterSteps(steps);
        writer.write(result.position.x + " " + result.position.y);
        writer.newLine();
        writer.flush();
    }

    CoordinateWithOffset getAfterSteps(int steps) {
        ArrayList<CoordinateWithOffset> past = new ArrayList<>();
        past.add(new CoordinateWithOffset(0, 0, 0, 1));

        for (int i = 0; i < steps; i++) {
            CoordinateWithOffset currentPosition = past.get(i);
            Coordinate leftTurnOffset = LEFT_OFFSET.get(currentPosition.offset);
            CoordinateWithOffset newPosition = leftTurnCoordinate(currentPosition, leftTurnOffset);
            if (past.stream().anyMatch(pos -> pos.equals(newPosition))) {
                past.add(
                    forwardCoordinate(currentPosition)
                );
            } else {
                past.add(newPosition);
            }
        }

        return past.get(past.size() - 1);
    }

    private CoordinateWithOffset leftTurnCoordinate(CoordinateWithOffset currentPosition, Coordinate leftTurnOffset) {
        return new CoordinateWithOffset(
                currentPosition.position.x + leftTurnOffset.x,
                currentPosition.position.y + leftTurnOffset.y,
                leftTurnOffset.x,
                leftTurnOffset.y
        );
    }

    private CoordinateWithOffset forwardCoordinate(CoordinateWithOffset currentPosition) {
        return new CoordinateWithOffset(
                currentPosition.position.x + currentPosition.offset.x,
                currentPosition.position.y + currentPosition.offset.y,
                currentPosition.offset.x,
                currentPosition.offset.y
        );
    }

    private class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Coordinate)) return false;
            Coordinate that = (Coordinate) o;
            return x == that.x && y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "Coordinate{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    private class CoordinateWithOffset {

        Coordinate position;
        Coordinate offset;

        public CoordinateWithOffset(int x, int y, int xOffset, int yOffset) {
            position = new Coordinate(x, y);
            offset = new Coordinate(xOffset, yOffset);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof CoordinateWithOffset)) return false;
            CoordinateWithOffset that = (CoordinateWithOffset) o;
            return Objects.equals(position, that.position);
        }

        @Override
        public int hashCode() {
            return Objects.hash(position);
        }

        @Override
        public String toString() {
            return "CoordinateWithOffset{" +
                    "position=" + position +
                    ", offset=" + offset +
                    '}';
        }
    }
}
