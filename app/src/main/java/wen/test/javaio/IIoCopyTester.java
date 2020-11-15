package wen.test.javaio;

public interface IIoCopyTester {

    void start(String sourceFilePath, String targetFilePath);

    void setListener(ResultListener listener);

    boolean isCoping();

    long getCopyUsedTimeMs();

    interface ResultListener{
        void onStart();
        void onSuc();
        void onFail();
    }

}
