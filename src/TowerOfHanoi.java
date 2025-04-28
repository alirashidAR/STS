public class TowerOfHanoi {
    public void towerOfHanoi(int n, int source, int auxiliary, int destination) {
        if (n == 1) {
            System.out.println("Move disk 1 from rod " + source + " to rod " + destination);
            return;
        }
        towerOfHanoi(n-1, source, destination, auxiliary);
        System.out.println("Move disk " + n + " from rod " + source + " to rod " + destination);
        towerOfHanoi(n-1, auxiliary, source, destination);
    }

    public static void main(String[] args) {
        TowerOfHanoi toh = new TowerOfHanoi();
        int n = 3; // Number of disks
        toh.towerOfHanoi(n, 1, 2, 3); // rods are 1 (source), 2 (auxiliary), 3 (destination)
    }
}
