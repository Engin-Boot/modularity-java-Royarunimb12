package colorcoder.philips.service;

import colorcoder.*;

public class ColorService {




    public static ColorPair GetColorFromPairNumber(int pairNumber) {
        int zeroBasedPairNumber = pairNumber - 1;
        MajorColor majorColor = (MajorColor)fromIndex(MajorColor.values(),zeroBasedPairNumber /ColorNames.numberOfMinorColors);
        MinorColor minorColor = (MinorColor)fromIndex(MinorColor.values(),zeroBasedPairNumber % ColorNames.numberOfMinorColors);
        return new ColorPair(majorColor, minorColor);
    }

    public static int GetPairNumberFromColor(MajorColor major, MinorColor minor) {
        return major.getIndex() * ColorNames.numberOfMinorColors + minor.getIndex() + 1;
    }

    public static IColor fromIndex(Object[] colors, int index) {
        for(Object obj: colors) {
            IColor color = (IColor)obj;
            if(color.getIndex() == index) {
                return color;
            }
        }
        return null;
    }


}
