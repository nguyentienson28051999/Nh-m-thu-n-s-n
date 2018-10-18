package Pb0;

public class CommandlineCaiTienLan1 {
    public static void main(String[] args){
        Dictionary dic = new Dictionary();
        DictionaryManagement dmt = new DictionaryManagement(dic);
        DictionaryCommandline dce = new DictionaryCommandline(dic);
        dce. dictionaryAdvanced(dic,dmt,dce);
    }
}
