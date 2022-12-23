package The_JAVA8_Class.OriginalFuntionInterFace;

import java.util.function.Function;

public class OriginalFuntionInterface implements Function<Object, Object> {
    @Override
    public Object apply(Object o) {
        return (Integer)o+10;
    }
}
