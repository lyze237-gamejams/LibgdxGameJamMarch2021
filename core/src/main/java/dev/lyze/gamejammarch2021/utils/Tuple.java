package dev.lyze.gamejammarch2021.utils;

import java.util.Objects;

public class Tuple<I1, I2>
{
    private final I1 item1;
    private final I2 item2;

    public Tuple(I1 item1, I2 item2) {
       this.item1 = item1;
       this.item2 = item2;
    }

    public I1 getItem1()
    {
        return item1;
    }

    public I2 getItem2()
    {
        return item2;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tuple<?, ?> tuple = (Tuple<?, ?>) o;
        return Objects.equals(item1, tuple.item1) && Objects.equals(item2, tuple.item2);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(item1, item2);
    }
}
