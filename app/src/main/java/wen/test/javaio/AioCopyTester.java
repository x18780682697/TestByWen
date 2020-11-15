package wen.test.javaio;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import wen.test.utils.LogUtils;

public class AioCopyTester implements IIoCopyTester{

    final static String     TAG             = AioCopyTester.class.getSimpleName();
    ResultListener          mListener;
    AsynchronousFileChannel mInputChannel, mOutputChannel;
    boolean                 isCoping;
    long                    mStartTime;
    long                    mStopTime;

    @Override
    public void start(String sourceFilePath, String targetFilePath) {
        LogUtils.d(TAG, "start...");
        LogUtils.d(TAG, "start...sourceFilePath " + sourceFilePath);
        LogUtils.d(TAG, "start...targetFilePath " + targetFilePath);
        try {
            File sourceFile = new File(sourceFilePath);
            if (!sourceFile.exists()){
                onFail();
            }
            mInputChannel = AsynchronousFileChannel
                    .open(Paths.get(sourceFilePath), StandardOpenOption.READ);
            File targetFile = new File(targetFilePath);
            boolean ret = false;
            if (targetFile.exists()){
                ret = targetFile.delete();
            }
            if (!ret){
                onFail();
            }
            ret = targetFile.createNewFile();
            if (!ret){
                onFail();
            }
            mOutputChannel = AsynchronousFileChannel
                    .open(Paths.get(targetFilePath), StandardOpenOption.WRITE);
            startCopy();
        } catch (IOException e) {
            e.printStackTrace();
            onFail();
        }
    }

    private void startCopy() {
        LogUtils.d(TAG, "startCopy...");
        isCoping = true;
        mStartTime = System.currentTimeMillis();
        if (mListener != null){
            mListener.onStart();
        }
        ByteBuffer inputBuf = ByteBuffer.allocate(10);
        startReadNext(inputBuf, 0);
    }

    private void onSuc(){
        LogUtils.d(TAG, "onSuc...");
        isCoping = false;
        mStopTime = System.currentTimeMillis();
        if (mListener != null){
            mListener.onSuc();
        }
    }

    private void onFail(){
        LogUtils.d(TAG, "onFail...");
        isCoping = false;
        mStartTime = 0;
        mStopTime = 0;
        if (mListener != null){
            mListener.onFail();
        }
    }

    private void startReadNext(final ByteBuffer inputBuf, final int position){
        LogUtils.d(TAG, "startRead...");
        inputBuf.clear();
        mInputChannel.read(inputBuf, position, null, new CompletionHandler<Integer, Object>() {
            @Override
            public void completed(Integer result, Object attachment) {
                LogUtils.d(TAG, "completed...");
                if (result != null && result <= 0){
                    onSuc();
                    return;
                }
                startWriteNext(inputBuf, position);
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                LogUtils.d(TAG, "failed...");
                exc.printStackTrace();
                onFail();
            }
        });
    }

    private void startWriteNext(final ByteBuffer outputBuf, final int position){
        LogUtils.d(TAG, "startWrite...");
        outputBuf.flip();
        mOutputChannel.write(outputBuf, position, null, new CompletionHandler<Integer, Object>() {
            @Override
            public void completed(Integer result, Object attachment) {
                LogUtils.d(TAG, "completed...");
                startReadNext(outputBuf, position + result);
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                LogUtils.d(TAG, "failed...");
                exc.printStackTrace();
                onFail();
            }
        });
    }

    @Override
    public void setListener(ResultListener listener) {
        mListener = listener;
    }

    @Override
    public boolean isCoping() {
        return isCoping;
    }

    @Override
    public long getCopyUsedTimeMs() {
        return mStopTime - mStartTime;
    }

}
