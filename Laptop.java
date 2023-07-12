import java.util.*;

class Laptop {
    private String color;
    private String os;
    private int ram;
    private int hdd;

    public Laptop(String color, String os, int ram, int hdd) {
        this.color = color;
        this.os = os;
        this.ram = ram;
        this.hdd = hdd;
    }

    public String getColor() {
        return color;
    }

    public String getOs() {
        return os;
    }

    public int getRam() {
        return ram;
    }

    public int getHdd() {
        return hdd;
    }

    @Override
    public String toString() {
        return "laptop { " +
                "color='" + color + '\'' +
                ", os='" + os + '\'' +
                ", ram=" + ram +
                ", hdd=" + hdd +
                " }";
    }

    public static void main(String[] args) {
        Set<Laptop> laptops = new HashSet<>();
        laptops.add(new Laptop("Black", "Windows", 8, 500));
        laptops.add(new Laptop("White", "MacOS", 16, 256));
        laptops.add(new Laptop("Grey", "Linux", 4, 1000));

        Scanner scanner = new Scanner(System.in);
        Map<String, Object> filterCriteria = new HashMap<>();

        while (true) {
            System.out.println("Enter the number corresponding to the necessary criterion:");
            System.out.println("1 - RAM\n2 - HDD\n3 - OS\n4 - Color\n(type 5 to start search)");
            int choice = scanner.nextInt();

            if (choice == 5) break;

            switch (choice) {
                case 1:
                    System.out.println("Enter minimum RAM:");
                    filterCriteria.put("ram", scanner.nextInt());
                    break;
                case 2:
                    System.out.println("Enter minimum HDD:");
                    filterCriteria.put("hdd", scanner.nextInt());
                    break;
                case 3:
                    System.out.println("Enter OS:");
                    filterCriteria.put("os", scanner.next());
                    break;
                case 4:
                    System.out.println("Enter color:");
                    filterCriteria.put("color", scanner.next());
                    break;
            }
        }

        int laptopsCount = 0;
        for (Laptop laptop : laptops) {
            if (filterCriteria.get("ram") != null && laptop.getRam() < (int)filterCriteria.get("ram")) continue;
            if (filterCriteria.get("hdd") != null && laptop.getHdd() < (int)filterCriteria.get("hdd")) continue;
            if (filterCriteria.get("os") != null && !laptop.getOs().equals(filterCriteria.get("os"))) continue;
            if (filterCriteria.get("color") != null && !laptop.getColor().equals(filterCriteria.get("color"))) continue;

            laptopsCount += 1;
            System.out.println(laptop);
        }

        if (laptopsCount == 0) System.out.println("No matches found");
    }
}