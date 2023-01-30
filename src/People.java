import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class People {
    public static void main(String[] args) throws IOException {

        String str = "";
        FileReader reader = new FileReader("People.txt");

        while (reader.ready()) {
            str += (char) reader.read();
        }

        String[] strings = str.split("\n");

        ArrayList<String> surnames = new ArrayList<>();
        ArrayList<String> firstNames = new ArrayList<>();
        ArrayList<String> secondNames = new ArrayList<>();
        ArrayList<Integer> ages = new ArrayList<>();
        ArrayList<String> gender = new ArrayList<>();

        LinkedList<Integer> indexes = new LinkedList<>();

        for (int i = 0; i < strings.length; i++) {  // раскидываем по спискам, выводим на экран
            String[] tmp = strings[i].split(" ");
            System.out.println(tmp[0] + " " + tmp[1].charAt(0) + "." + tmp[2].charAt(0) + ". " + tmp[3] + " " + tmp[4]);
            surnames.add(tmp[0]);
            firstNames.add(tmp[1]);
            secondNames.add(tmp[2]);
            ages.add(Integer.parseInt(tmp[3]));
            gender.add(tmp[4]);
        }

        for (int i = 1; i < surnames.size() + 1; i++) { // заполняем индексы
            indexes.add(i);
        }

        Integer temp;
        for (int i = 0; i < indexes.size(); i++) {
            int minInd = i;
            for (int j = i; j < indexes.size(); j++) {
                if (ages.get(j) < ages.get(minInd)) {
                    minInd = j;
                }
            }
            //swap(array, left, minInd);
            temp = indexes.get(i);
            indexes.set(i, indexes.get(minInd));
            indexes.set(minInd, temp);
        }
        System.out.println(indexes);

        for (int i = 0; i < ages.size(); i++) {
            System.out.print(ages.get(indexes.get(i)) + " ");
        }

    }
}
