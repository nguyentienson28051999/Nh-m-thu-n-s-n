package Pb0;
import java.io.*;
import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;

public class DictionaryManagement {
    Scanner sc = new Scanner(System.in);

    public DictionaryManagement(Dictionary dic) {};

    public Comparator<Word> wordTarget = new Comparator<Word>() {
        public int compare(Word o1, Word o2) {
            return o1.word_target.compareTo(o2.word_target);
        }

    };
        public void sort(Dictionary dic) {
        Collections.sort(dic.listWord,wordTarget);
    }

    public void insertFromCommandline(Dictionary dic) {
        System.out.print("Nhap vao ban phim so luong tu vung : ");
        int n = sc.nextInt();
        sc.nextLine();
        for(int i=0; i<n; i++){
            System.out.print("Nhap tu tieng Anh : ");
            String tu = sc.nextLine();
            System.out.print("Nhap giai thich sang tieng Viet : ");
            String nghia = sc.nextLine();
            Word word = new Word(tu,nghia);
            dic.listWord.add(word);
        }
        sort(dic);

    }



    public void insertFromFile(Dictionary dic){
        try {
            File infile = new File("dictionaries.txt");
            FileReader fileReader = new FileReader(infile);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\t");
                dic.listWord.add(new Word(words[0],words[1]));
            }
             sort(dic);
            fileReader.close();
            reader.close();
        }catch (Exception e){}
    }


    public void dictionaryLookup(Dictionary dic, DictionaryCommandline dce) {
        System.out.print("Nhap tu can tra: ");
        String tu = sc.nextLine().trim();
        int index = Collections.binarySearch(dic.listWord, new Word(tu, ""), wordTarget);
        if (index >= 0) {
            System.out.println("Da tim thay !");
            System.out.print("Tu can tra : ");
            System.out.println(dic.listWord.get(index).word_target + "\t" + dic.listWord.get(index).word_explain);
        } else {
            System.out.println("Khong ton tai tu can tra !");
        }
    }



    public void dictionaryExportToFile(Dictionary dic){
        try {
            FileWriter writer = new FileWriter("out.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            int n = dic.listWord.size();
            for (int i = 0; i < n; i++) {
                String str = dic.listWord.get(i).word_target + "\t" + dic.listWord.get(i).word_explain;
                bufferedWriter.write(str);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            writer.close();
        } catch (Exception e) {}
    }


    public void addWord(Dictionary dic){
        System.out.print("Nhap tu tieng Anh: ");
        String tu = sc.nextLine().trim();
        int index = Collections.binarySearch(dic.listWord, new Word(tu,""), wordTarget);
        if (index >= 0) {
            System.out.println("Da ton tai tu can them \n" + dic.listWord.get(index));
        } else {
            System.out.print("Nhap giai thich sang tieng Viet : ");
            String nghia = sc.nextLine().trim();
            dic.listWord.add(new Word(tu,nghia));
            sort(dic);
            System.out.println("Da them tu thanh cong !");
        }
    }

    public void deleteAWord(Dictionary dic){
        System.out.print("Nhap tu muon xoa : ");
        String tu = sc.nextLine().trim();
        int index = Collections.binarySearch(dic.listWord, new Word(tu, ""), wordTarget);
        if (index < 0) {
            System.out.println("Khong ton tai tu muon xoa");
        } else {
            dic.listWord.remove(index);
            System.out.println("Da xoa tu thanh cong !");
        }
    }

    public void editWord(Dictionary dic){
        System.out.print("Nhap tu muon sua : ");
        String tu = sc.nextLine();
        int index = Collections.binarySearch(dic.listWord, new Word(tu, ""), wordTarget);
        if (index < 0) {
            System.out.println("Khong ton tai tu muon sua");
        } else {
            dic.listWord.get(index);
            System.out.print("Nhap nghia moi : ");
            String nghia = sc.nextLine();
            dic.listWord.get(index).setWord_explain(nghia);
            System.out.println("Da sua tu thanh cong !");
        }

    }

    public void dictionarySearcher(Dictionary dic, DictionaryCommandline dce){
        System.out.print("Nhap tu can tim kiem nhanh : ");
        String tu = sc.nextLine().trim();
        ArrayList<Word> listWordSearch = new ArrayList<>();
        for (int i = 0; i < dic.listWord.size(); i++) {
            Word word = dic.listWord.get(i);
            if (word.word_target.indexOf(tu) == 0) {
                listWordSearch.add(word);
            }
        }

        for (int i = 0; i < listWordSearch.size(); i++) {
            System.out.printf("%-5d%-20s%-20s",i+1,listWordSearch.get(i).word_target,listWordSearch.get(i).word_explain);
            System.out.println();
        }
    }


}
