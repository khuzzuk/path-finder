package pl.khuzzuk.pathfinder.model;

public class Board {
    private Field[][] fields;

    private Board(Field[][] fields) {
        this.fields = fields;
    }

    public static Board cleanBoardOfSize(int x, int y) {
        Field[][] fields = new Field[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                fields[i][j] = Field.CLEAR;
            }
        }
        return new Board(fields);
    }

    void occupyField(int x, int y) {
        fields[x][y] = Field.OCCUPIED;
    }

    int rows() {
        return fields.length;
    }

    int columns() {
        return fields[0].length;
    }

    Place placeFor(int x, int y) {
        Place place = new Place();
        place.center = fields[x][y];
        place.bottom = bottom(x, y);
        place.top = top(x, y);
        place.left = left(x, y);
        place.right = right(x, y);
        return place;
    }

    private Field bottom(int x, int y) {
        return fields[x].length - 1 <= y ? null : fields[x][y + 1];
    }

    private Field top(int x, int y) {
        return 0 >= y ? null : fields[x][y - 1];
    }

    private Field left(int x, int y) {
        return 0 >= x ? null : fields[x - 1][y];
    }

    private Field right(int x, int y) {
        return fields.length - 1 <= x ? null : fields[x + 1][y];
    }
}
