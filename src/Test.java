import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by Intellij.
 * Author: abhis
 * Date: 24/02/2022
 * Time: 10:14 am
 */
public class Test {
    public static void main(String[] args) {

        readFile("a_an_example.in.txt", "a_an_example.out.txt");
        readFile("b_basic.in.txt", "b_basic.out.txt");
        readFile("c_coarse.in.txt", "c_coarse.out.txt");
        readFile("d_difficult.in.txt", "d_difficult.out.txt");
        readFile("e_elaborate.in.txt", "e_elaborate.out.txt");

    }



    public static void readFile(String inputFile, String outputFile){
        HashSet<String> likes = new HashSet<>();
        HashSet<String> disLikes = new HashSet<>();

        try {
            FileReader fr = new FileReader("E:\\Abhishek\\hashcode\\test2\\input\\" + inputFile);
            BufferedReader br = new BufferedReader(fr);

            StringBuffer sb = new StringBuffer();
            String line = null;

            int count = 0;

            int clientCount = 0;

            while ((line = br.readLine()) != null) {
                sb.append(line);


                String[] split = line.split(" ");
                if (count == 0) {  // is first line assign data to the variables............
                    clientCount = Integer.valueOf(split[0]);
                }else {

                    if ((count - 1) % 2 == 0) {
                        int likesCount = Integer.parseInt(split[0]);
                        for (int x = 1; x <= likesCount; x++) {
                            likes.add(split[x]);
                        }

                    } else {
                        int disLikesCount = Integer.parseInt(split[0]);
                        System.out.println("disLikesCount -- " + disLikesCount);
                        if (disLikesCount != 0) {
                            for (int x = 1; x <= disLikesCount; x++) {
                                disLikes.add(split[x]);
                                likes.remove(split[x]);
                            }
                        }
                    }
                }

                count++;
            }

//            System.out.println("clientCount --- " + clientCount);
//
//            System.out.println(likes);
//            System.out.println(disLikes);

            writeFile(likes, outputFile);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void writeFile(HashSet<String> likes, String outputFile) {
        try {
            File myObj = new File("E:\\Abhishek\\hashcode\\test2\\output\\"+outputFile);
            if (myObj.createNewFile()) {
                FileWriter myWriter = new FileWriter(myObj);

                myWriter.write(likes.size() + " ");
                for(String s : likes){
                    myWriter.write(s + " ");
                }

                myWriter.close();

                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
