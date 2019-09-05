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
        return this.fillBy(Figure3T::hasMarkX, 0, 0, 1, 0)
                || this.fillBy(Figure3T::hasMarkX, 0, 0, 0, 1)
                || this.fillBy(Figure3T::hasMarkX, 0, 0, 1, 1)
                || this.fillBy(Figure3T::hasMarkX, this.table.length - 2, 0, 0, 1)
                || this.fillBy(Figure3T::hasMarkX, this.table.length - 1, 0, 0, 1)
                || this.fillBy(Figure3T::hasMarkX, 0, this.table.length - 2, 1, 0)
                || this.fillBy(Figure3T::hasMarkX, 0, this.table.length - 1, 1, 0)
                || this.fillBy(Figure3T::hasMarkX, 0, this.table.length - 1, 1, -1);

        /* первоначальный вариант решения:
        boolean result = false;
        int count1 = 1; int count2 = 1;

        for (int i = 1; i < this.table[0].length; i++) {
            if ( (this.table[i][i].hasMarkX() == this.table[i - 1][i - 1].hasMarkX() && (this.table[i][i].hasMarkX() != false)  )
               ) {
                  count1++;
            }

            if ( (this.table[i][this.table[0].length - 1 - i].hasMarkX() == this.table[i - 1][this.table[0].length - i].hasMarkX())
                    && (this.table[i][this.table[0].length - 1 - i].hasMarkX() != false)
            ) {
                count2++;
            }

            if ((count1 == 3) || (count2 == 3)) {
                result = true;
            }
        }

        if (result == false) {
            for (int i = 0; i < this.table[0].length; i++) {
                if (  ((this.table[i][0].hasMarkX() == this.table[i][1].hasMarkX())
                        && (this.table[i][0].hasMarkX() == this.table[i][2].hasMarkX())
                        && (this.table[i][0].hasMarkX() != false)
                      )
                      || ( (this.table[0][i].hasMarkX() == this.table[1][i].hasMarkX())
                        && (this.table[0][i].hasMarkX() == this.table[2][i].hasMarkX())
                        && (this.table[0][i].hasMarkX() != false)
                      )
                ) {
                    result = true;
                    break;
                }
            }
        }

        return result;
        */
    }

    public boolean isWinnerO() {
        return this.fillBy(Figure3T::hasMarkO, 0, 0, 1, 0)
                || this.fillBy(Figure3T::hasMarkO, 0, 0, 0, 1)
                || this.fillBy(Figure3T::hasMarkO, 0, 0, 1, 1)
                || this.fillBy(Figure3T::hasMarkO, this.table.length - 2, 0, 0, 1)
                || this.fillBy(Figure3T::hasMarkO, this.table.length - 1, 0, 0, 1)
                || this.fillBy(Figure3T::hasMarkO, 0, this.table.length - 2, 1, 0)
                || this.fillBy(Figure3T::hasMarkO, 0, this.table.length - 1, 1, 0)
                || this.fillBy(Figure3T::hasMarkO, 0, this.table.length - 1, 1, -1);
        /* первоначальный вариант решения:
        boolean result = false;
        int count1 = 1; int count2 = 1;

        for (int i = 1; i < this.table[0].length; i++) {
            if ( (this.table[i][i].hasMarkO() == this.table[i - 1][i - 1].hasMarkO() && (this.table[i][i].hasMarkO() != false)  )
            ) {
                count1++;
            }

            if ( (this.table[i][this.table[0].length - 1 - i].hasMarkO() == this.table[i - 1][this.table[0].length - i].hasMarkO())
                    && (this.table[i][this.table[0].length - 1 - i].hasMarkO() != false)
            ) {
                count2++;
            }

            if ((count1 == 3) || (count2 == 3)) {
                result = true;
            }
        }

        if (result == false) {
            for (int i = 0; i < this.table[0].length; i++) {
                if (  ((this.table[i][0].hasMarkO() == this.table[i][1].hasMarkO())
                        && (this.table[i][0].hasMarkO() == this.table[i][2].hasMarkO())
                        && (this.table[i][0].hasMarkO() != false)
                )
                        || ( (this.table[0][i].hasMarkO() == this.table[1][i].hasMarkO())
                        && (this.table[0][i].hasMarkO() == this.table[2][i].hasMarkO())
                        && (this.table[0][i].hasMarkO() != false)
                )
                ) {
                    result = true;
                    break;
                }
            }
        }
        return result;
         */
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
