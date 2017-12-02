package pl.isa.web.tools;

import java.text.Normalizer;

public class StringNormalizer {

    public String normalize(String string) {
        return this.unaccent(string).toLowerCase().replace(" ", "-")
                .replace(",", "");
    }

    private String unaccent(String src) {
        return Normalizer
                .normalize(src, Normalizer.Form.NFD)
                .replaceAll("ł", "l")
                .replaceAll("[^\\p{ASCII}]", "");
    }

}
