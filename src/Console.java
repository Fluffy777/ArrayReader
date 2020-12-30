public final class Console {
    private Console() {};

    public static void println(String title, String message) {
        System.out.println(ConsoleColors.ANSI_RED + title + ": " + ConsoleColors.ANSI_RESET + message);
    }

    public static void println(String title, Object obj) {
        println(title,obj.toString());
    }
}
