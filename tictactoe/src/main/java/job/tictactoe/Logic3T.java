package job.tictactoe;

import java.util.function.Predicate;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure3T cell = this.table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }

    public boolean isWinnerX() {
        return fillControl(Figure3T::hasMarkX);
    }

    public boolean isWinnerO() {
        return fillControl(Figure3T::hasMarkO);
    }

    public boolean fillControl(Predicate<Figure3T> predicate) {
        return this.fillBy(predicate, 0, 0, 1, 0)
                || this.fillBy(predicate, 0, 0, 0, 1)
                || this.fillBy(predicate, 0, 0, 1, 1)
                || this.fillBy(predicate, this.table.length - 2, 0, 0, 1)
                || this.fillBy(predicate, this.table.length - 1, 0, 0, 1)
                || this.fillBy(predicate, 0, this.table.length - 2, 1, 0)
                || this.fillBy(predicate, 0, this.table.length - 1, 1, 0)
                || this.fillBy(predicate, 0, this.table.length - 1, 1, -1);
    }

    public boolean hasGap() {
        int count = 0;
        for (int i = 0; i < this.table[0].length; i++) {
            for (int j = 0; j < this.table[0].length; j++) {
                if ((this.table[i][j].hasMarkO()) || (this.table[i][j].hasMarkX())) {
                    count++;
                }
            }
        }
        return count == 9 ? false : true;
    }
}
