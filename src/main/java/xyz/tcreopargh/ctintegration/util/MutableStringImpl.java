package xyz.tcreopargh.ctintegration.util;

public class MutableStringImpl implements IMutableString {

    private final StringBuilder builder;

    public MutableStringImpl(StringBuilder builder) {
        this.builder = builder;
    }

    public MutableStringImpl(String str) {
        this.builder = new StringBuilder(str);
    }

    public MutableStringImpl() {
        this.builder = new StringBuilder();
    }

    @Override
    public int hashCode() {
        return builder.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof IMutableString)) {
            return false;
        }
        return builder.toString().equals(obj.toString());
    }

    @Override
    public String toString() {
        return builder.toString();
    }

    @Override
    public IMutableString append(String s) {
        builder.append(s);
        return this;
    }

    @Override
    public IMutableString append(Object s) {
        builder.append(s);
        return this;
    }

    @Override
    public IMutableString append(int s) {
        builder.append(s);
        return this;
    }

    @Override
    public IMutableString append(double s) {
        builder.append(s);
        return this;
    }

    @Override
    public IMutableString append(float s) {
        builder.append(s);
        return this;
    }

    @Override
    public IMutableString append(long s) {
        builder.append(s);
        return this;
    }

    @Override
    public IMutableString append(boolean s) {
        builder.append(s);
        return this;
    }

    @Override
    public IMutableString append(short s) {
        builder.append(s);
        return this;
    }

    @Override
    public IMutableString append(byte s) {
        builder.append(s);
        return this;
    }

    @Override
    public IMutableString insert(int offset, String s) {
        builder.insert(offset, s);
        return this;
    }

    @Override
    public IMutableString insert(int offset, Object s) {
        builder.insert(offset, s);
        return this;
    }

    @Override
    public IMutableString insert(int offset, int s) {
        builder.insert(offset, s);
        return this;
    }

    @Override
    public IMutableString insert(int offset, double s) {
        builder.insert(offset, s);
        return this;
    }

    @Override
    public IMutableString insert(int offset, float s) {
        builder.insert(offset, s);
        return this;
    }

    @Override
    public IMutableString insert(int offset, long s) {
        builder.insert(offset, s);
        return this;
    }

    @Override
    public IMutableString insert(int offset, boolean s) {
        builder.insert(offset, s);
        return this;
    }

    @Override
    public IMutableString insert(int offset, short s) {
        builder.insert(offset, s);
        return this;
    }

    @Override
    public IMutableString insert(int offset, byte s) {
        builder.insert(offset, s);
        return this;
    }

    @Override
    public IMutableString reverse() {
        builder.reverse();
        return this;
    }

    @Override
    public String build() {
        return this.toString();
    }

    @Override
    public IMutableString delete(int start, int end) {
        builder.delete(start, end);
        return this;
    }

    @Override
    public IMutableString deleteCharAt(int pos) {
        builder.deleteCharAt(pos);
        return this;
    }
}
