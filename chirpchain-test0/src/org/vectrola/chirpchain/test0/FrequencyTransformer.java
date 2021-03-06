package org.vectrola.chirpchain.test0;

/**
 * Created by jlunder on 6/10/15.
 */
public abstract class FrequencyTransformer {
    private static final float DESIRED_TIME_WINDOW = 1f;
    private static final float DESIRED_ROW_TIME = 0.005f;
    private static final float DESIRED_WAVELET_WINDOW = DESIRED_ROW_TIME * 2;
    public static final int ROW_SAMPLES = (int)Math.rint(DESIRED_ROW_TIME * SampleSeries.SAMPLE_RATE);
    public static final float ROW_TIME = ROW_SAMPLES / SampleSeries.SAMPLE_RATE;
    public static final int TOTAL_ROWS = (int) Math.ceil(DESIRED_TIME_WINDOW / ROW_TIME);
    public static final float TIME_WINDOW = TOTAL_ROWS * ROW_TIME;
    public static final float MIN_FREQUENCY = 1000f;
    public static final float MAX_FREQUENCY = 6000f;
    public static final float BIN_BANDWIDTH = 100f;
    public static final int BINS_PER_ROW = (int)((MAX_FREQUENCY - MIN_FREQUENCY) / BIN_BANDWIDTH) + 1;
    public static final int WAVELET_WINDOW_SAMPLES = (int)Math.rint(DESIRED_WAVELET_WINDOW * SampleSeries.SAMPLE_RATE);
    public static final float WAVELET_WINDOW = WAVELET_WINDOW_SAMPLES / SampleSeries.SAMPLE_RATE;
    public static final float MIN_AMPLITUDE = 1e-5f;
    public static final float LOG_MIN_AMPLITUDE = (float)Math.log(MIN_AMPLITUDE);

    public abstract float getTime();
    public abstract int getQueuedRows();
    public abstract int getAvailableRows();

    public void getBinRows(float[] dest, int numRows) {
        getBinRows(dest, 0, numRows);
    }

    public abstract void getBinRows(float[] dest, int offset, int numRows);
    public abstract void discardRows(int numRows);
    public abstract void reset();
}

