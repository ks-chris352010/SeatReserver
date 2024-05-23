public class SeatReserver {
    private char[][] seatingChart;

    // Constructor to initialize the seating chart with all seats available (represented by '0'):
    public SeatReserver(int rows, int columns) {
        seatingChart = new char[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                seatingChart[i][j] = '0';
            }
        }
    }

    // Method to display the seating chart:
    public void displaySeatingChart() {
        System.out.println("Seating Chart:");
        for (int i = 0; i < seatingChart.length; i++) {
            for (int j = 0; j < seatingChart[i].length; j++) {
                System.out.print(seatingChart[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(); 
    }

    // Method to reserve a seat:
    public void reserveSeat(int row, int column) {
        // Removes 1 from each so that 1,1 will be the top left most:
        row -= 1;
        column -= 1;
        if (row < 0 || row >= seatingChart.length || column < 0 || column >= seatingChart[0].length) {
            System.out.println("Seat (" + (row+1) + ", " + (column+1) + ") is out of range.");
            return;
        }

        if (seatingChart[row][column] == 'X') {
            System.out.println("Seat (" + (row+1) + ", " + (column+1) + ") is already taken.");
        } else {
            // Reserve the seat:
            seatingChart[row][column] = 'X';
            System.out.println("Seat (" + (row+1) + ", " + (column+1) + ") reserved successfully.");
        }
    }

    // Main method to test the MovieTheater class:
    public static void main(String[] args) {
        // Create a MovieTheater object with 5 rows and 6 columns:
        SeatReserver theater = new SeatReserver(5, 6);

        // Display the initial seating chart:
        theater.displaySeatingChart();

        // Reserve seat test:
        theater.reserveSeat(1, 1);
        theater.displaySeatingChart();

        theater.reserveSeat(1, 1); // Attempt to reserve an already taken seat
        theater.displaySeatingChart();

        theater.reserveSeat(2, 3);
        theater.displaySeatingChart();

        theater.reserveSeat(4, 5);
        theater.displaySeatingChart();

        
        theater.reserveSeat(6, 6); // Attempt to reserve a seat that is out of range
        theater.displaySeatingChart();
    }
}
