public record Crane(int numberEggs, String name) {
    public Crane {
        if (name == null || name.length() < 1)
            throw new IllegalArgumentException();
        name = name.substring(0, 1).toUpperCase()
                + name.substring(1).toLowerCase();
    }
}