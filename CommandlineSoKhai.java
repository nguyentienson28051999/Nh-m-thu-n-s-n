package Pb0;

public class CommandlineSoKhai {
    public static void main(String[] args){
        Dictionary dic = new Dictionary();
        DictionaryManagement dmt = new DictionaryManagement(dic);
        DictionaryCommandline dce = new DictionaryCommandline(dic);
        dce.dictionaryBasic(dmt,dic);
    }

}
