package mafiaprod.Utils.Predetermined;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class polityManager {
    private static final List<Polity> polityList = new ArrayList<>();

    public void addPolity(Polity polity){
        polityList.add(polity);
    }

    public static Polity getPolity(String polityName){
        for(Polity polity : polityList){
            if(polity.getPolityName().equals(polityName)){
                return polity;
            }
        }
        return null;
    }

    public static String outputPolity(){
        List<String> polityNameList = new ArrayList<>();
        for(int i = 0; i <= polityList.size(); i++){
            polityNameList.add(polityList.get(i).getPolityName());
        }

        return polityNameList.stream()
                .collect(Collectors.joining(", ", "", ""));
    }
}
