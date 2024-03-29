import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Kevin Gay on 27/02/2017.
 */
public class Main {

    /**
     * Main function
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<Category> categories = new ArrayList<Category>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome on the Trivia Game!");

        categories.add(new Category("AdventureTime"));
        categories.add(new Category("StarWars"));
        categories.add(new Category("HarryPotter"));

        menu(categories, sc);

        for (Category category : categories) {
            if (category.isUpdate())
                category.writeInFile();
        }
    }

    /**
     * First Menu to show
     * @param categories of the files
     * @param sc Scanner for the input
     */
    private static void menu(ArrayList<Category> categories, Scanner sc){
        boolean isWorking = true;

        while (isWorking) {
            System.out.println("a. Select Category\n" +
                    "q. Quit"
            );

            if (sc.hasNextLine()){
                switch (sc.nextLine()){
                    case "a":
                        selectCategory(categories, sc);
                        break;
                    case "q":
                        isWorking = false;
                        break;
                }
            }
        }
    }

    /**
     * Select the category that you want
     * @param categories of the files
     * @param sc Scanner
     */
    private static void selectCategory(ArrayList<Category> categories, Scanner sc) {
        int i = 0;
        int index = 0;
        boolean isWorking = true;

        Category selectedCategory;

        for (Category category : categories) {
            System.out.println(i++ + " : " + category.getName());
        }

        while (isWorking) {
            System.out.println("Select your category");
            if (sc.hasNextInt()) {
                index = sc.nextInt();
                sc.nextLine();

                if (index >= 0 && index < categories.size()) {
                    selectedCategory = categories.get(index);

                    while (isWorking) {
                        System.out.println("a. Take quiz\n" +
                                "b. Add new question\n" +
                                "c. Modify question"
                        );

                        if (sc.hasNextLine()) {
                            switch (sc.nextLine()) {
                                case "a":
                                    takeQuizz(selectedCategory, sc);
                                    break;
                                case "b":
                                    selectedCategory.addQuestion(sc);
                                    break;
                                case "c":
                                    selectedCategory.selectModifyQuestion(sc);
                                    break;
                            }
                            isWorking = false;
                        }
                    }
                }
            }
        }
    }

    /**
     * Give 10 randoms question to the player
     * @param category that you have selected befire
     * @param sc Scanner for the input
     */
    private static void takeQuizz(Category category, Scanner sc){
        int index = 0;
        int answer = 0;
        int wrongAnswer = 0;
        boolean isWorking = true;

        for (int i = 0; i < 10; i++) {
            Random rn = new Random();
            isWorking = true;
            index = rn.nextInt(category.getQuestions().size() - 1);
            System.out.println(category.getQuestions().get(index).toString());

            while (isWorking) {
                if (sc.hasNextInt()) {
                    answer = sc.nextInt();
                    if (answer < 0 || answer > 4) {
                        System.out.println("It must be a number between 1-4");
                    }else if (category.getQuestions().get(index).getRealAnswer() != answer) {
                         wrongAnswer++;
                         isWorking = false;
                     } else
                        isWorking = false;
                    sc.nextLine();
                }
            }
        }

        System.out.println("You got " + wrongAnswer + "/10 wrong answer");
    }
}
