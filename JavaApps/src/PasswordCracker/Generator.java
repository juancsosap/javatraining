package PasswordCracker;

import java.util.Iterator;

public class Generator implements Iterable<String> {

    private final char[] chars;
    private final int length;
    
    public Generator(String chars, int length) {
        this.chars = chars.toCharArray();
        this.length = length;
    }
    
    @Override
    public Iterator<String> iterator() {
        return new IteratorGen();
    }
    
    public String getLast() {
        StringBuilder text = new StringBuilder(this.length);
        char last = this.chars[this.chars.length - 1];
        for(int i=0; i<this.length; i++){
            text.append(last);
        }
        return text.toString();
    }
    
    private class IteratorGen implements Iterator<String> {
    
        private final int[] tokens;
    
        public IteratorGen() {
            this.tokens = new int[length];
            this.initialize();
        }
    
        @Override
        public boolean hasNext() {
            for(int i=0; i<this.tokens.length; i++) {
                if(this.tokens[i] < chars.length - 1)
                    return true;
            }
            return false;
        }

        @Override
        public String next() {
            this.incrementTokens();
            return this.generate();
        }

        private void initialize() {
            for(int i=0; i<this.tokens.length; i++) {
                this.tokens[i] = 0;
            }
        }

        private void incrementTokens() {
            for(int i=0; i<this.tokens.length; i++) {
                if(this.tokens[i] < chars.length - 1) {
                    this.tokens[i] += 1;
                    break;
                } else {
                    this.tokens[i] = 0;
                }
            }
        }

        private String generate() {
            StringBuilder text = new StringBuilder(this.tokens.length);
            for(int token : this.tokens) {
                text.insert(0, chars[token]);
            }
            return text.toString();
        }

    }
    
}
