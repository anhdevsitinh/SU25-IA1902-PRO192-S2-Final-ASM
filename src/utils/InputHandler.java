package utils;

import java.util.Scanner;

/*
Inputter: This is a template class, not used to create objects,
but to store helper methods for input.
*/

public class InputHandler {

    // properties

    public static final Scanner sc = new Scanner(System.in);

    // get an integer

    public static int getInt(String inputMsg, String errMsg) {
        while (true) {
            System.out.print(inputMsg);

            try {
                int number = Integer.parseInt(sc.nextLine());
                return number;
            } catch (NumberFormatException e) {
                System.out.println(errMsg);
            }
        }
    }

    // get an integer in a range

    public static int getInt(String inputMsg, String object, int min, int max) {
        if (min > max) {
            int tmp = min;
            min = max;
            max = tmp;
        }

        while (true) {
            System.out.print(inputMsg);

            try {
                int number = Integer.parseInt(sc.nextLine());

                if (number < min || number > max) {
                    System.out.println(object + " is out of range from + " + min + " to " + max + ". Try again!!!");
                    continue;
                }

                return number;
            } catch (NumberFormatException e) {
                System.out.println("Invalid " + object + ". Try again!!!");
            }
        }
    }

    // get an integer with min only
    public static int getIntMin(String inputMsg, String object, int min) {
        while (true) {
            System.out.print(inputMsg);
            try {
                int number = Integer.parseInt(sc.nextLine());
                if (number < min) {
                    System.out.println(object + " must be at least " + min + ". Try again!!!");
                    continue;
                }
                return number;
            } catch (NumberFormatException e) {
                System.out.println("Invalid " + object + ". Try again!!!");
            }
        }
    }

    // get an integer with max only
    public static int getIntMax(String inputMsg, String object, int max) {
        while (true) {
            System.out.print(inputMsg);
            try {
                int number = Integer.parseInt(sc.nextLine());
                if (number > max) {
                    System.out.println(object + " must be at most " + max + ". Try again!!!");
                    continue;
                }
                return number;
            } catch (NumberFormatException e) {
                System.out.println("Invalid " + object + ". Try again!!!");
            }
        }
    }

    // get a double

    public static double getDouble(String inputMsg, String object) {
        while (true) {
            System.out.println(inputMsg);

            try {
                double number = Double.parseDouble(sc.nextLine());
                return number;
            } catch (NumberFormatException e) {
                System.out.println("Invalid " + object + ". Try again!!");
            }
        }
    }

    // get a double in a range

    public static double getDouble(String inputMsg, String object, double min, double max) {

        if (min > max) {
            double tmp = min;
            min = max;
            max = tmp;
        }

        while (true) {
            System.out.println(inputMsg);

            try {
                double number = Double.parseDouble(sc.nextLine());

                if (number < min || number > max) {
                    System.out.println(object + " is out of range from + " + min + " to " + max + ". Try again!!!");
                    continue;
                }

                return number;
            } catch (NumberFormatException e) {
                System.out.println("Invalid " + object + ". Try again!!");
            }
        }
    }

    // get a double with min only
    public static double getDoubleMin(String inputMsg, String object, double min) {
        while (true) {
            System.out.println(inputMsg);
            try {
                double number = Double.parseDouble(sc.nextLine());
                if (number < min) {
                    System.out.println(object + " must be at least " + min + ". Try again!!!");
                    continue;
                }
                return number;
            } catch (NumberFormatException e) {
                System.out.println("Invalid " + object + ". Try again!!");
            }
        }
    }

    // get a double with max only
    public static double getDoubleMax(String inputMsg, String object, double max) {
        while (true) {
            System.out.println(inputMsg);
            try {
                double number = Double.parseDouble(sc.nextLine());
                if (number > max) {
                    System.out.println(object + " must be at most " + max + ". Try again!!!");
                    continue;
                }
                return number;
            } catch (NumberFormatException e) {
                System.out.println("Invalid " + object + ". Try again!!");
            }
        }
    }

    // get a float

    public static float getFloat(String inputMsg, String object) {
        return (float) getDouble(inputMsg, object);
    }

    // get a float in a range

    public static float getFloat(String inputMsg, String object, float min, float max) {
        return (float) getDouble(inputMsg, object, min, max);
    }

    // get a float with min only
    public static float getFloatMin(String inputMsg, String object, float min) {
        return (float) getDoubleMin(inputMsg, object, min);
    }

    // get a float with max only
    public static float getFloatMax(String inputMsg, String object, float max) {
        return (float) getDoubleMax(inputMsg, object, max);
    }

    // get a string

    public static String getString(String inputMsg, String object) {
        while (true) {
            System.out.println(inputMsg);

            String str = sc.nextLine();

            if (str == null || str.isEmpty()) {
                System.out.println(object + " must not be empty!!!");
                continue;
            }

            return str;
        }
    }

    // get a string with regex

    public static String getString(String inputMsg, String object, String regex) {
        while (true) {
            System.out.println(inputMsg);

            String str = sc.nextLine();

            if (str == null || str.isEmpty()) {
                System.out.println(object + " must not be empty. Try again!!!");
                continue;
            }

            if (!str.matches(regex)) {
                System.out.println("Invalid format of " + object + ". Try again!!!");
                continue;
            }

            return str;
        }
    }

    // get a date

}
