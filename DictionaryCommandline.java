package Pb0;


public class DictionaryCommandline {
    public DictionaryCommandline(Dictionary dic) {
    }


    public void showAllWords(Dictionary dic) {
        int n = dic.listWord.size();
        System.out.println("No    | English         | Vietnamese");
        for(int i=0; i<n; i++){
            System.out.printf("%-5d | %-15s | %s",i+1,dic.listWord.get(i).word_target,dic.listWord.get(i).word_explain);
            System.out.println();
        }
    }



    public  void dictionaryBasic(DictionaryManagement dmt, Dictionary dic){

        dmt.insertFromCommandline(dic);
        System.out.println("In ra tu dien : ");
        showAllWords(dic);
    }

    public void dictionaryAdvanced(Dictionary dic, DictionaryManagement dmt, DictionaryCommandline dce){
        dmt.insertFromFile(dic);
        showAllWords(dic);
        dmt.dictionaryLookup(dic,dce);
    }



}
