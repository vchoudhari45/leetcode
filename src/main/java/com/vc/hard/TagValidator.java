package com.vc.hard;

import java.util.*;

class TagValidator {
    private int index = 0;
    private String CDATA_PREFIX_START = "<![CDATA[";
    private String CDATA_PREFIX_END = "]]>";

    private String OPENING_TAG_START = "<";
    private String OPENING_TAG_END = ">";

    private String CLOSING_TAG_START = "</";
    private String CLOSING_TAG_END = ">";

    public boolean isValid(String code) {
        Stack<String> st = new Stack<>();
        int n = code.length();
        while(index < n) {
            if(index > 0 && st.isEmpty()) return false;
            else if(code.startsWith(CDATA_PREFIX_START, index)) {
                if(!processCDATA(code)) return false;
            }
            else if(code.startsWith(CLOSING_TAG_START, index)) {
                if(!isValidClosingTag(code, st)) return false;
            }
            else if(code.startsWith(OPENING_TAG_START, index)) {
                if(!isValidOpeningTag(code, st)) return false;
            }
            else index++;
        }
        return st.isEmpty();
    }

    private boolean processCDATA(String code) {
        int start = code.indexOf(CDATA_PREFIX_START, index);
        int end = code.indexOf(CDATA_PREFIX_END, start + CDATA_PREFIX_START.length());
        if(start != -1 && end != -1) {
            index = end + CDATA_PREFIX_END.length();
            return true;
        }
        return false;
    }

    private boolean isValidOpeningTag(String code, Stack st) {
        int start = code.indexOf(OPENING_TAG_START, index);
        int end = code.indexOf(OPENING_TAG_END, start + OPENING_TAG_START.length());
        if(start != -1 && end != -1) {
            String tagName = code.substring(start + 1, end);
            if(tagName.length() <= 9
                    && tagName.length() >= 1
                    && containsUpper(tagName)) {
                st.push(tagName);
                index = end + OPENING_TAG_END.length();
                return true;
            }
        }
        return false;
    }

    private boolean isValidClosingTag(String code, Stack st) {
        int start = code.indexOf(CLOSING_TAG_START, index);
        int end = code.indexOf(CLOSING_TAG_END, start + CLOSING_TAG_START.length());
        if(start != -1 && end != -1) {
            String tagName = code.substring(start + 2, end);
            if(tagName.length() <= 9
                    && tagName.length() >= 1
                    && containsUpper(tagName)
                    && !st.isEmpty()
                    && st.pop().equals(tagName)) {
                index = end + CLOSING_TAG_END.length();
                return true;
            }
        }
        return false;
    }

    private boolean containsUpper(String tagName) {
        for(int i = 0; i < tagName.length(); i++) {
            if(!(tagName.charAt(i) >= 'A' && tagName.charAt(i) <= 'Z')) return false;
        }
        return true;
    }
}
