package controllers.audio;

import gui.views.pickers.CustomLambdaExpression;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Audio {
    private class AudioListener implements LineListener {
        private boolean done = false;

        @Override
        public synchronized void update(LineEvent event) {
            if (event.getType() == LineEvent.Type.STOP) {
                stopActivity.apply();
                removeActivityOnStop();
            }
            if (loopCondition(event)) {
                done = true;
                notifyAll();
            }
        }

        public void resetDone() {
            done = false;
        }

        protected synchronized boolean loopCondition(LineEvent event) {
            return event.getType() == LineEvent.Type.CLOSE;
        }

        public synchronized void waitUntilDone() throws InterruptedException {
            while (!done) {
                wait();
            }
        }
    }

    private class NotInfiniteLoopListener extends AudioListener {
        @Override
        protected synchronized boolean loopCondition(LineEvent event) {
            return event.getType() == LineEvent.Type.CLOSE || event.getType() == LineEvent.Type.STOP;
        }
    }

    private boolean inLoop = true;
    private AudioListener listener;
    private Clip mainClip;
    private AudioInputStream mainStream;
    private File file;

    public void setMainClip(String path, boolean inLoop){
        try {
            mainClip = AudioSystem.getClip();
            setInLoop(inLoop);
            file = new File(path);
            mainStream = AudioSystem.getAudioInputStream(file);
            mainClip.addLineListener(listener);
        } catch (LineUnavailableException | UnsupportedAudioFileException |
                IOException ex){

        }
    }

    public void runMainClip() {
        listener.resetDone();
        try {
            if (!mainClip.isOpen()) {
                mainStream = AudioSystem.getAudioInputStream(file);
                mainClip.open(mainStream);
            }
            if (inLoop)
                mainClip.loop(Clip.LOOP_CONTINUOUSLY);

            try {
                mainClip.start();
                listener.waitUntilDone();
            } finally {
                mainClip.close();
            }
        } catch (RuntimeException | UnsupportedAudioFileException | IOException | InterruptedException |
                 LineUnavailableException ex) {
            System.out.println("This file is definitely broken!");
        } finally {
            try {
                mainStream.close();
            } catch (IOException ex) {
                System.out.println("yyyy");
            }
        }
    }

    private void setInLoop(boolean val) {
        inLoop = val;
        if (inLoop) {
            listener = new AudioListener();
        } else {
            listener = new NotInfiniteLoopListener();
        }
        mainClip.addLineListener(listener);
    }

    private long currentClipTime = 0;
    private CustomLambdaExpression stopActivity = () -> {
    };

    public void stop() {
        mainClip.stop();
        currentClipTime = mainClip.getMicrosecondPosition();
    }

    public void start() {
        mainClip.start();
        mainClip.setMicrosecondPosition(currentClipTime);
        if (inLoop)
            mainClip.loop(Clip.LOOP_CONTINUOUSLY);

    }

    public void setActivityOnStop(CustomLambdaExpression lambdaExpression) {
        stopActivity = lambdaExpression;
    }

    private void removeActivityOnStop() {
        stopActivity = () -> {
        };
    }

}
