package com.amo.labs.lab4;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DataEquation {
    private String stringEpsilon;
    private String start;
    private String stop;

    private String result;

    private String k;

    public String getStringEpsilon() {
        return stringEpsilon;
    }

    public void setStringEpsilon(String stringEpsilon) {
        this.stringEpsilon = stringEpsilon;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getStop() {
        return stop;
    }

    public void setStop(String stop) {
        this.stop = stop;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getK() {
        return k;
    }

    public void setK(String k) {
        this.k = k;
    }

    @Override
    public String toString() {
        return "DataEquation{" +
                "stringEpsilon='" + stringEpsilon + '\'' +
                ", start='" + start + '\'' +
                ", stop='" + stop + '\'' +
                '}';
    }
}
