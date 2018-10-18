package Pb0;
import java.util.Scanner;

public class CommandlineCaiTienLan2 {
    public static void main(String[] args){
        Dictionary dic = new Dictionary();
        DictionaryManagement dmt = new DictionaryManagement(dic);
        DictionaryCommandline dce = new DictionaryCommandline(dic);
        dmt.insertFromFile(dic);
        Scanner sc = new Scanner(System.in);
        int luaChon;
        do {
            System.out.println("Tu dien Anh-Viet ");
            System.out.println("1. Them tu.");
            System.out.println("2. Xoa tu.");
            System.out.println("3. Sua nghia tu da co.");
            System.out.println("4. Tim kiem nhanh.");
            System.out.println("5. Tra tu.");
            System.out.println("6. Hien thi tat ca cac tu.");
            System.out.println("7. Thoat.");
            System.out.print("Nhap lua chon : ");
            luaChon = sc.nextInt();
            sc.nextLine();
            switch (luaChon){
                case 1:
                    dmt.addWord(dic);
                    break;
                case 2:
                    dmt.deleteAWord(dic);
                    break;
                case 3:
                    dmt.editWord(dic);
                    break;
                case 4:
                    dmt.dictionarySearcher(dic,dce);
                    break;
                case 5:
                    dmt.dictionaryLookup(dic,dce);
                    break;
                case 6:
                    dce.showAllWords(dic);
                    break;
                case 7:
                    System.exit(0);
            }

            dmt.dictionaryExportToFile(dic);
            System.out.println();

        } while (luaChon >= 1 && luaChon <= 7);


            System.out.println("|------------------------------------|");
            System.out.println("Cam on ban da su dung chuong trinh !");
        }

}
