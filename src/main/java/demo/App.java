package demo;

import java.io.StringReader;
import org.apache.lucene.analysis.ngram.NGramTokenizer;
import org.apache.lucene.analysis.TokenStream;

public class App {
    public static void main(String[] args) {
        NGramTokenizer tokenizer = new NGramTokenizer(2, 3);
        StringReader reader = new StringReader("hεllo");
        tokenizer.setReader(reader);

        TokenStream tokenStream = tokenizer;
        try {
            tokenStream.reset();
            while (tokenStream.incrementToken()) {
                System.out.println(tokenizer.toString());
            }
            tokenStream.end();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                tokenStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println(tokenizer.toString());
    }
}
