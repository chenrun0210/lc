package test;

import org.junit.Assert;
import org.roaringbitmap.PeekableIntIterator;
import org.roaringbitmap.RoaringBitmap;
import test.bithouse.RoaringBitmapUtil;

import java.io.IOException;

/**
 * @author chenrun <chenrun@kuaishou.com>
 * Created on 2021-10-09
 */
public class Test {
    public static void main(String[] args) throws IOException {
        Long[] params = new Long[]{100000000000000L, 1L};
        RoaringBitmap roaringBitmap = new RoaringBitmap();

        RoaringBitmap bitmap = new RoaringBitmap();
        bitmap.add(1);
        bitmap.add(10000);
        byte[] bytesValue = RoaringBitmapUtil.serialize(bitmap);
        RoaringBitmap bitmap2 = RoaringBitmapUtil.deserialize(bytesValue);
        Assert.assertEquals(2, bitmap2.getCardinality());
        PeekableIntIterator iterator = bitmap2.getIntIterator();
        Assert.assertEquals(1, iterator.next());
        Assert.assertEquals(10000, iterator.next());


    }
}
