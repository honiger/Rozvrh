package cz.uhk.rozvrh;

import com.google.gson.Gson;

import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class RozvrhLoader {

    public static List<RozvrhovaAkce> loadRozvrh(String budova, String mistnost) throws Exception {
        String urlStr = "https://stag-demo.uhk.cz/ws/services/rest2/rozvrhy/getRozvrhByMistnost?semestr=%25&budova="+ budova +"&mistnost=" + mistnost + "&outputFormat=JSON";

        URL url = new URL(urlStr);
        InputStreamReader reader = new InputStreamReader(url.openStream(), "UTF-8");

        Gson gson = new Gson();
        RozvrhData data = gson.fromJson(reader, RozvrhData.class);

        // Kontrola
        if (data == null || data.rozvrhovaAkce == null) {
            throw new Exception("Nepodařilo se načíst žádná data.");
        }

        // Filtr
        List<RozvrhovaAkce> filtrovane = new ArrayList<>();
        for (RozvrhovaAkce akce : data.rozvrhovaAkce) {
            if (akce.ucitel != null && akce.ucitel.jmeno != null && !akce.ucitel.jmeno.isEmpty()) {
                filtrovane.add(akce);
            }
        }

        return filtrovane;
    }
}
