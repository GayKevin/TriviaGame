import javax.annotation.processing.SupportedSourceVersion;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by thieg on 27/02/2017.
 */
public class Category {

    private ArrayList<Question> questions = new ArrayList<Question>();
    private String name;

    Category(String name){
        this.name = name;
        parseFiles(name);
    }

    private void parseFiles(String name){
        String[] str = new String[6];
        File file = new File(name + ".txt");
        int i = 0;

        try {
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                str[i++] = sc.nextLine();
                while (sc.hasNextLine()) {
                    str[i++] = sc.nextLine();
                    if (i % 6 == 0) {
                        questions.add(new Question(str));
                        i = 0;
                    }
                }
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("We didnt find your file");
            str = null;
        }
    }

    public void selectModifyQuestion(Scanner sc){
        int i = 0;
        int index = 0;
        boolean isWorking = true;

        for (Question question : this.questions) {
            System.out.println(i++ + " : " + question.getQuestion());
        }

        while (isWorking) {
            System.out.print("Select the question you want to edit : ");
            if (sc.hasNextInt()){
                index = sc.nextInt();
                if (index >= 0 && index < this.questions.size()){
                    isWorking = false;
                    modifyQuestion(index, sc);
                }
            }
        }
    }

    private void modifyQuestion(int index, Scanner sc){
        boolean isWorking = true;
        int part = 0;
        String realAnwser;

        System.out.println("1- " + this.questions.get(index).getQuestion());
        System.out.println("2- " + this.questions.get(index).getAnswer1());
        System.out.println("3- " + this.questions.get(index).getAnswer2());
        System.out.println("4- " + this.questions.get(index).getAnswer3());
        System.out.println("5- " + this.questions.get(index).getAnswer4());
        System.out.println("6- " + this.questions.get(index).getRealAnswer());

        while (isWorking){
            System.out.println("Select the part you want to edit");
            if (sc.hasNextInt()){
                part = sc.nextInt();
                sc.nextLine();
                if (part >= 1 && part <= 6){
                    if (part != 6 && sc.hasNextLine()){
                        editQuestion(index, part, sc.nextLine());
                    } else {
                        while (isWorking) {
                            System.out.print("Enter your modification : ");
                            if (sc.hasNextInt()) {
                                realAnwser = sc.nextLine();
                                if (Integer.parseInt(realAnwser) >= 0 && Integer.parseInt(realAnwser) <= 4) {
                                    editQuestion(index, part, realAnwser);
                                    isWorking = false;
                                } else
                                    System.out.println("It must be a number between 1 - 4");
                            } else {
                                System.out.println("It must be a number between 1 - 4");
                                sc.nextLine();
                            }
                        }
                    }
                    isWorking = false;
                }
            }
        }
    }

    void editQuestion(int index, int part, String str){
        switch (part){
            case 1:
                this.questions.get(index).setQuestion(str);
                break;
            case 2:
                this.questions.get(index).setAnswer1(str);
                break;
            case 3:
                this.questions.get(index).setAnswer2(str);
                break;
            case 4:
                this.questions.get(index).setAnswer3(str);
                break;
            case 5:
                this.questions.get(index).setAnswer4(str);
                break;
            case 6:
                this.questions.get(index).setRealAnswer(Integer.valueOf(str));
                break;
        }
    }

    String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }
}
