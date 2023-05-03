import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Collections;
import java.util.Iterator;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Main {
    static Scanner input = new Scanner(System.in);


    public static void main(String[] args )throws IOException {

        ArrayList<Task> myList = new ArrayList<>();
        ObjectMapper map = new ObjectMapper();
        System.out.println("Reader Time");
        File file = new File("data.json");
        BufferedReader br = new BufferedReader(new FileReader("data.json"));
        String st;
        String total = "";
        while ((st = br.readLine()) != null) {
            total = st + total;
        }
        myList = map.readValue(total, ArrayList.class);
        System.out.println(myList);
        try {






            System.out.println("1. Add a Task");
            System.out.println("2. Remove a Task");
            System.out.println("3. Update a Task");
            System.out.println("4. List all Tasks");
            System.out.println("0. Exit");
            System.out.println("What would you like to do? ");
            int userInput = input.nextInt();
            input.nextLine();

            while (userInput > 0) {

                if (userInput == 1) {
                    addTask(myList);
                    map.writeValue(new File("data.json"), myList);



                } else if (userInput == 0) {


                    map.writeValue(new File("data.json"), myList);
                    System.exit(0);

                } else if (userInput == 2) {
                    removeTask(myList);
                    System.out.println(myList);

                } else if (userInput == 4) {
                    System.out.println("Here are your current Tasks");
                    map.writeValue(new File("data.json"), myList);
                    System.out.println(myList);

                } else if (userInput == 3) {
                    updateTask(myList);
                    System.out.println(myList);
                } else if (userInput == 5) {
                    pri(myList);
                }

                System.out.println("What would you like to do? ");
                userInput = input.nextInt();
                input.nextLine();
            }
        }catch(Exception e){
            System.out.println("Something went wrong");
        }




    }


    static ArrayList<Task> addTask(ArrayList<Task> a)
    {
        System.out.println("What is the title of the task?...");

        String title = input.nextLine();

        System.out.println("Description of the Task");
        String desc = input.nextLine();

        System.out.println("What is the Priority of the Task? ");

        int prio = input.nextInt();

        Task aNewTask = new Task(title, desc, prio);

        a.add(aNewTask);




        return a;

    }


    static ArrayList<Task> removeTask(ArrayList<Task> a) {
        System.out.println("What index would you like to remove:");
        String task = input.nextLine();
        a.remove(Integer.parseInt(task));
        return a;
    }

    static ArrayList<Task> updateTask(ArrayList<Task> a) {
        System.out.println("What task would you like to update?");
        int update = input.nextInt();
        input.nextLine();

        System.out.println("Please enter a title for the task:");
        String title = input.nextLine();

        System.out.println("Please enter a description for the task");
        String desc = input.nextLine();

        System.out.println("Please enter a priority for the task:");
        int priority = input.nextInt();

        Task aNewTask = new Task(title, desc, priority);

        a.set(update, aNewTask);
        return a;
    }

    static void listTask(ArrayList<Task> a) {
        System.out.println("Here are the tasks you already have!");
        String userin = input.next();

    }
    static void pri(ArrayList<Task>a){
        for (Task item : a){
            System.out.println("What priority would you like to find: ");
            int userinput = input.nextInt();
            int prio = item.getPriority();
            if(prio==userinput){
                System.out.println(item);
            }
        }

    }


}

class Task implements Comparable<Task>,Iterable<Task>{
    private String title;
    private String desc;
    private int priority;





    public Task(String title, String desc, int priority) {
        this.title = title;
        this.desc = desc;
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "task{" +
                "title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", priority=" + priority +
                '}';
    }

    @Override
    public int compareTo(Task other) {
        int compareResult = this.title.compareTo(other.title);


        if(compareResult==0) {
            if(this.priority< other.priority){
                return -1;
            }
        }
        return compareResult;


    }

    @Override
    public Iterator<Task> iterator() {
        return this.iterator();
    }
}



