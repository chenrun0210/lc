package test.bithouse;


import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.roaringbitmap.RoaringBitmap;
import org.roaringbitmap.longlong.Roaring64NavigableMap;

/**
 * encrypt data with roaring bitmap
 */
public class RoaringBitmapUtil {
    public static byte[] serialize(RoaringBitmap roaringBitmap) throws IOException {
        roaringBitmap.runOptimize();
        byte[] bytes = new byte[roaringBitmap.serializedSizeInBytes()];
        roaringBitmap.serialize(new DataOutputStream(new RBOutputStream(bytes)));
        return bytes;
    }

    public static RoaringBitmap deserialize(byte[] bytesValue) throws IOException {
        return deserialize(bytesValue, 0, bytesValue.length);
    }

    public static RoaringBitmap deserialize(byte[] bytesValue, int offset, int len) throws IOException {
        RoaringBitmap roaringBitmap = new RoaringBitmap();
        roaringBitmap.deserialize(new java.io.DataInputStream(new RBInputStream(bytesValue, offset, len)));
        return roaringBitmap;
    }

    public static byte[] serialize64(Roaring64NavigableMap roaring64NavigableMap) throws IOException {
        roaring64NavigableMap.runOptimize();
        long len = roaring64NavigableMap.serializedSizeInBytes();
        int bytesLen = 0;
        if (len > Integer.MAX_VALUE) {
            throw new IllegalStateException("roaring64NavigableMap size:" + len + " > Integer.MAX_VALUE");
        } else {
            bytesLen = (int) len;
        }
        byte[] bytes = new byte[bytesLen];
        roaring64NavigableMap.serialize(new DataOutputStream(new RBOutputStream(bytes)));
        return bytes;
    }

    public static Roaring64NavigableMap deserialize64(byte[] bytesValue) throws IOException {
        return deserialize64(bytesValue, 0, bytesValue.length);
    }

    public static Roaring64NavigableMap deserialize64(byte[] bytesValue, int offset, int len) throws IOException {
        Roaring64NavigableMap roaring64NavigableMap = new Roaring64NavigableMap();
        roaring64NavigableMap.deserialize(new java.io.DataInputStream(new RBInputStream(bytesValue, offset, len)));
        return roaring64NavigableMap;
    }

    private static class RBOutputStream extends OutputStream {
        private byte[] bytes;

        public RBOutputStream(byte[] bytes) {
            this.bytes = bytes;
        }

        private int count = 0;

        @Override
        public void write(int value) {
            bytes[count++] = (byte) value;
        }

        public void write(byte[] value) {
            this.write(value, 0, value.length);
        }

        public void write(byte[] value, int start, int len) {
            System.arraycopy(value, start, bytes, count, len);
            count += len;
        }
    }


    private static class RBInputStream extends InputStream {
        private byte[] bytesValue;
        private int offset = 0;
        private int len;

        public RBInputStream(byte[] bytesValue, int offset, int len) {
            this.bytesValue = bytesValue;
            this.offset = offset;
            this.len = len;
        }

        @Override
        public int read() {
            //CHECKSTYLE:OFF
            return bytesValue[offset++] & 0xff;
            //CHECKSTYLE:ON
        }

        @Override
        public int read(byte[] b) {
            return read(b, offset, b.length);
        }

        @Override
        public int read(byte[] b, int off, int l) {
            System.arraycopy(bytesValue, offset, b, off, l);
            offset += l;
            return l;
        }
    }
}

